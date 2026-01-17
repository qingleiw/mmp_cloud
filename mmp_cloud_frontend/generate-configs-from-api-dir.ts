import fs from 'fs';
import path from 'path';
import * as ts from 'typescript';

// Usage: tsx generate-configs-from-api-dir.ts natdss
const dirArg = process.argv[2];
if (!dirArg) {
  console.error('请传入要处理的 api 子目录，例如: natdss');
  process.exit(1);
}

const apiRoot = path.join(process.cwd(), 'src', 'api', dirArg);
if (!fs.existsSync(apiRoot)) {
  console.error('api 目录不存在:', apiRoot);
  process.exit(1);
}

interface FieldInfo { prop: string; label: string; type: string; required: boolean }

function getTsTypeToFieldType(tsType: string): string {
  if (!tsType) return 'input';
  if (/number/.test(tsType)) return 'number';
  if (/boolean/.test(tsType)) return 'select';
  if (/Date/.test(tsType) || /time/i.test(tsType) || /date/i.test(tsType)) return 'datetime';
  if (/string\s*\|/.test(tsType)) return 'input';
  return 'input';
}
function getSearchType(fieldType: string): string {
  const map: Record<string,string> = { input: 'input', number: 'number', select: 'select', date: 'daterange', datetime: 'daterange', textarea: 'input', switch: 'select' };
  return map[fieldType] || 'input';
}

function parseFirstExportedInterface(typesFilePath: string): { name: string, fields: FieldInfo[] } | null {
  if (!fs.existsSync(typesFilePath)) return null;
  const code = fs.readFileSync(typesFilePath, 'utf8');
  const sf = ts.createSourceFile(typesFilePath, code, ts.ScriptTarget.Latest, true);
  let found: { name: string, fields: FieldInfo[] } | null = null;

  function visit(node: ts.Node) {
    if (found) return;
    if (ts.isInterfaceDeclaration(node) && node.modifiers && node.modifiers.some(m => m.kind === ts.SyntaxKind.ExportKeyword)) {
      const name = node.name.text;
      const fields: FieldInfo[] = [];
      node.members.forEach(member => {
        if (ts.isPropertySignature(member) && member.name && ts.isIdentifier(member.name)) {
          const prop = member.name.text;
          if (['id','delFlag','createTime','createBy','createDept','updateTime','updateBy'].includes(prop)) return;
          let label = prop;
          const jsDocs = (member as any).jsDoc;
          if (jsDocs && jsDocs[0] && jsDocs[0].comment) label = jsDocs[0].comment.replace(/\n/g,' ').trim();
          let tsType = 'string';
          if (member.type) tsType = member.type.getText(sf);
          const fieldType = getTsTypeToFieldType(tsType);
          const required = !member.questionToken;
          fields.push({ prop, label, type: fieldType, required });
        }
      });
      found = { name, fields };
      return;
    }
    ts.forEachChild(node, visit);
  }
  visit(sf);
  return found;
}

function normalizeVarName(folderName: string) {
  return folderName.replace(/[^a-zA-Z0-9]/g, '');
}

function upperFirst(s: string){ return s.charAt(0).toUpperCase() + s.slice(1); }

function generateFieldConfig(varName: string, fields: FieldInfo[]): string {
  const entityName = upperFirst(varName);
  let out = `\n// ${entityName} 字段配置\n`;
  out += `export function create${entityName}FieldConfig() {\n`;
  out += `  const fieldGroups: FieldGroup[] = [\n`;

  const basic = fields.filter(f => /code|name|no|id|sn|date|time|type|status/i.test(f.prop)).slice(0,8);
  const others = fields.filter(f => !basic.includes(f));

  if (basic.length) {
    out += `    { name: 'basic', label: '基础信息', fields: [\n`;
    basic.forEach((f,i)=>{
      out += `      { prop: '${f.prop}', label: '${f.label}', visible: true, ${f.required?"required: true, ":''}type: '${f.type}', group: 'basic' }${i< basic.length-1?',':''}\n`;
    });
    out += `    ] },\n`;
  }
  if (others.length) {
    out += `    { name: 'detail', label: '详细信息', fields: [\n`;
    others.forEach((f,i)=>{
      out += `      { prop: '${f.prop}', label: '${f.label}', visible: true, ${f.required?"required: true, ":''}type: '${f.type}', group: 'detail' }${i< others.length-1?',':''}\n`;
    });
    out += `    ] },\n`;
  }
  out += `    { name: 'system', label: '系统字段', fields: [\n`;
  out += `      { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },\n`;
  out += `      { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },\n`;
  out += `      { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' }\n`;
  out += `    ] }\n`;

  out += `  ];\n\n`;
  out += `  return new FieldConfigManager('${varName}', fieldGroups);\n`;
  out += `}\n`;
  return out;
}

function generateSearchConfig(varName: string, fields: FieldInfo[]): string {
  const entityName = upperFirst(varName);
  let out = `\n// ${entityName} 搜索配置\n`;
  out += `export function create${entityName}SearchConfig() {\n`;
  out += `  const searchFieldGroups: SearchFieldGroup[] = [\n`;
  out += `    { name: 'search', label: '搜索条件', fields: [\n`;
  fields.forEach((f,i)=>{
    const st = getSearchType(f.type);
    out += `      { prop: '${f.prop}', label: '${f.label}', type: '${st}', visible: false, placeholder: '请输入${f.label}' }${i<fields.length-1?',':''}\n`;
  });
  out += `    ] }\n`;
  out += `  ];\n\n`;
  out += `  return new SearchConfigManager('${varName}', searchFieldGroups);\n`;
  out += `}\n`;
  return out;
}

// Collect
const folders = fs.readdirSync(apiRoot, { withFileTypes: true }).filter(d=>d.isDirectory()).map(d=>d.name);
const fieldConfigs: string[] = [];
const searchConfigs: string[] = [];

folders.forEach(folder => {
  const typesFile = path.join(apiRoot, folder, 'types.ts');
  const parsed = parseFirstExportedInterface(typesFile);
  if (!parsed) {
    console.log(`跳过 ${folder}：未找到 types.ts 或导出接口`);
    return;
  }
  const varName = normalizeVarName(folder);
  console.log(`处理 ${folder} -> ${varName}, 接口 ${parsed.name}, 字段 ${parsed.fields.length}`);
  fieldConfigs.push(generateFieldConfig(varName, parsed.fields));
  searchConfigs.push(generateSearchConfig(varName, parsed.fields));
});

// Write to configs
const outDir = path.join(process.cwd(),'src','utils','configs',dirArg);
if (!fs.existsSync(outDir)) fs.mkdirSync(outDir, { recursive: true });
const fieldPath = path.join(outDir, `${dirArg}FieldConfigs.ts`);
const searchPath = path.join(outDir, `${dirArg}SearchConfigs.ts`);

let fieldContent = `import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';\n`;
fieldContent += fieldConfigs.join('\n');
fs.writeFileSync(fieldPath, fieldContent, 'utf8');
console.log(`写入 ${fieldPath}，包含 ${fieldConfigs.length} 个函数`);

let searchContent = `import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';\n`;
searchContent += searchConfigs.join('\n');
fs.writeFileSync(searchPath, searchContent, 'utf8');
console.log(`写入 ${searchPath}，包含 ${searchConfigs.length} 个函数`);

console.log('完成');
