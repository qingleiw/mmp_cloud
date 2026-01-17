/**
 * 从SQL文件中提取表名并生成映射
 */
import fs from 'fs';
import path from 'path';

// 将snake_case转换为camelCase
function toCamelCase(str: string): string {
  return str.replace(/_([a-z])/g, (_, letter) => letter.toUpperCase());
}

// 移除mmp_前缀并转换为camelCase
function tableNameToVarName(tableName: string): string {
  const withoutPrefix = tableName.replace(/^mmp_/, '');
  return toCamelCase(withoutPrefix);
}

const sqlFilePath = path.join(process.cwd(), '..', 'docs', '1.sql');
const sqlContent = fs.readFileSync(sqlFilePath, 'utf-8');

// 提取所有CREATE TABLE语句
const tableRegex = /CREATE TABLE[^`]*`(mmp_\w+)`/gi;
let match;
const tables: string[] = [];

while ((match = tableRegex.exec(sqlContent)) !== null) {
  tables.push(match[1]);
}

// 按模块分组
const modules = ['ledger', 'natdss', 'qualification', 'radiation', 'supervision', 'surgery'];
const moduleMapping: Record<string, string[]> = {};

modules.forEach(module => {
  moduleMapping[module] = tables.filter(t => t.startsWith(`mmp_${module}_`));
});

// 输出映射代码
console.log('// 新增的6个模块映射：\n');

modules.forEach(module => {
  const moduleTables = moduleMapping[module];
  if (moduleTables.length > 0) {
    console.log(`  // ${module} (${moduleTables.length}个表)`);
    moduleTables.forEach(tableName => {
      const varName = tableNameToVarName(tableName);
      console.log(`  '${tableName}': { dir: '${module}', varName: '${varName}' },`);
    });
    console.log('');
  }
});

// 输出统计
console.log('\n统计信息：');
modules.forEach(module => {
  console.log(`${module}: ${moduleMapping[module].length}个表`);
});
