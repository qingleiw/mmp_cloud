/**
 * 同步搜索配置与字段配置
 * 让搜索配置包含所有字段配置中的字段，用户可以自己选择显示哪些
 */

import fs from 'fs';
import path from 'path';

// 目录配置
const directories = ['emergency', 'qc', 'radiation', 'supervision', 'surgery', 'tumorqc', 'natdss', 'ledger'];

// 字段类型映射：FieldConfig类型 -> SearchConfig类型
const fieldTypeMap: Record<string, string> = {
  'input': 'input',
  'number': 'number',
  'select': 'select',
  'date': 'daterange',
  'datetime': 'daterange',
  'textarea': 'input',
  'switch': 'select'
};

function getSearchType(fieldType?: string): string {
  if (!fieldType) return 'input';
  return fieldTypeMap[fieldType] || 'input';
}

function convertFieldToSearchField(field: string): string {
  // 提取字段属性
  const propMatch = field.match(/prop:\s*'([^']+)'/);
  const labelMatch = field.match(/label:\s*'([^']+)'/);
  const typeMatch = field.match(/type:\s*'([^']+)'/);
  const visibleMatch = field.match(/visible:\s*(true|false)/);
  const optionsMatch = field.match(/options:\s*\[([^\]]+)\]/);
  
  if (!propMatch || !labelMatch) return '';
  
  const prop = propMatch[1];
  const label = labelMatch[1];
  const fieldType = typeMatch ? typeMatch[1] : undefined;
  const searchType = getSearchType(fieldType);
  // 默认visible为false，让用户自己选择显示哪些
  const visible = visibleMatch ? visibleMatch[1] : 'false';
  
  let result = `{ prop: '${prop}', label: '${label}', type: '${searchType}', visible: ${visible}, placeholder: '请输入${label}'`;
  
  // 如果是日期范围类型，添加startProp和endProp
  if (searchType === 'daterange') {
    result += `, startProp: '${prop}Start', endProp: '${prop}End'`;
  }
  
  // 如果是数字范围类型，添加startProp和endProp
  if (searchType === 'numberrange') {
    result += `, startProp: '${prop}Min', endProp: '${prop}Max'`;
  }
  
  // 如果有选项，添加options
  if (optionsMatch && searchType === 'select') {
    result += `, options: [${optionsMatch[1]}]`;
  }
  
  result += ' }';
  return result;
}

function extractFieldsFromFieldConfig(content: string, functionName: string): { groups: any[], varName: string } {
  // 提取函数内容
  const functionRegex = new RegExp(`export function ${functionName}\\(\\)[\\s\\S]*?return new FieldConfigManager\\('([^']+)', fieldGroups\\);`, 'm');
  const functionMatch = content.match(functionRegex);
  
  if (!functionMatch) {
    console.log(`❌ 未找到函数 ${functionName}`);
    return { groups: [], varName: '' };
  }
  
  const varName = functionMatch[1];
  const functionContent = functionMatch[0];
  
  // 提取所有字段组
  const groupRegex = /\{\s*name:\s*'([^']+)',\s*label:\s*'([^']+)',\s*fields:\s*\[([\s\S]*?)\]\s*\}/g;
  const groups: any[] = [];
  
  let groupMatch;
  while ((groupMatch = groupRegex.exec(functionContent)) !== null) {
    const groupName = groupMatch[1];
    const groupLabel = groupMatch[2];
    const fieldsContent = groupMatch[3];
    
    // 排除系统字段组
    if (groupName === 'system') continue;
    
    // 提取字段
    const fieldRegex = /\{[^}]+\}/g;
    const fields: string[] = [];
    let fieldMatch;
    
    while ((fieldMatch = fieldRegex.exec(fieldsContent)) !== null) {
      const searchField = convertFieldToSearchField(fieldMatch[0]);
      if (searchField) {
        fields.push(searchField);
      }
    }
    
    if (fields.length > 0) {
      groups.push({
        name: groupName,
        label: groupLabel,
        fields: fields
      });
    }
  }
  
  return { groups, varName };
}

function generateSearchConfig(varName: string, groups: any[]): string {
  const entityName = varName.charAt(0).toUpperCase() + varName.slice(1);
  
  let result = `\n// ${groups[0]?.label ? '搜索配置' : varName}搜索配置\n`;
  result += `export function create${entityName}SearchConfig() {\n`;
  result += `  const searchFieldGroups: SearchFieldGroup[] = [\n`;
  
  groups.forEach((group, index) => {
    result += `    {\n`;
    result += `      name: '${group.name}',\n`;
    result += `      label: '${group.label}',\n`;
    result += `      fields: [\n`;
    
    group.fields.forEach((field: string, fieldIndex: number) => {
      result += `        ${field}`;
      if (fieldIndex < group.fields.length - 1) {
        result += ',\n';
      } else {
        result += '\n';
      }
    });
    
    result += `      ]\n`;
    result += `    }`;
    
    if (index < groups.length - 1) {
      result += ',\n';
    } else {
      result += '\n';
    }
  });
  
  result += `  ];\n\n`;
  result += `  return new SearchConfigManager('${varName}', searchFieldGroups);\n`;
  result += `}\n`;
  
  return result;
}

function processDirectory(dir: string) {
  const fieldConfigPath = path.join(process.cwd(), 'src', 'utils', 'configs', dir, `${dir}FieldConfigs.ts`);
  const searchConfigPath = path.join(process.cwd(), 'src', 'utils', 'configs', dir, `${dir}SearchConfigs.ts`);
  
  if (!fs.existsSync(fieldConfigPath)) {
    console.log(`⚠️  ${dir}FieldConfigs.ts 不存在，跳过`);
    return;
  }
  
  const fieldConfigContent = fs.readFileSync(fieldConfigPath, 'utf-8');
  
  // 提取所有函数名
  const functionNames = [...fieldConfigContent.matchAll(/export function (create\w+FieldConfig)/g)].map(m => m[1]);
  
  console.log(`\n📁 处理目录: ${dir}`);
  console.log(`   找到 ${functionNames.length} 个字段配置函数`);
  
  // 生成新的搜索配置内容
  let newSearchConfig = `import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';\n`;
  
  functionNames.forEach(functionName => {
    const { groups, varName } = extractFieldsFromFieldConfig(fieldConfigContent, functionName);
    
    if (groups.length > 0) {
      const searchConfig = generateSearchConfig(varName, groups);
      newSearchConfig += searchConfig;
    }
  });
  
  // 写入文件
  fs.writeFileSync(searchConfigPath, newSearchConfig, 'utf-8');
  console.log(`✅ 已更新 ${dir}SearchConfigs.ts，包含 ${functionNames.length} 个搜索配置函数`);
}

// 主函数
function main() {
  console.log('🚀 开始同步搜索配置...\n');
  
  directories.forEach(dir => {
    try {
      processDirectory(dir);
    } catch (error) {
      console.error(`❌ 处理 ${dir} 时出错:`, error);
    }
  });
  
  console.log('\n✨ 同步完成！\n');
  console.log('现在搜索配置包含了所有字段配置中的字段（除了系统字段）');
  console.log('用户可以在页面上通过"搜索配置"按钮自己选择要显示哪些搜索字段');
}

main();
