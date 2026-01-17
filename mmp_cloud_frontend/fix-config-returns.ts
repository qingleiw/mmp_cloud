import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

// 需要修复的目录列表
const dirs = ['qc', 'radiation', 'supervision', 'surgery', 'tumorqc', 'natdss'];

for (const dir of dirs) {
  // 修复 FieldConfigs
  const fieldConfigPath = path.join(__dirname, `src/utils/configs/${dir}/${dir}FieldConfigs.ts`);
  if (fs.existsSync(fieldConfigPath)) {
    console.log(`处理: ${dir}FieldConfigs.ts`);
    let content = fs.readFileSync(fieldConfigPath, 'utf-8');
    
    // 替换所有 `return fieldGroups;` 为 `return new FieldConfigManager('xxx', fieldGroups);`
    // 需要找到函数名来确定管理器的名称
    const functionPattern = /export function create(\w+)FieldConfig\(\) \{[\s\S]*?return fieldGroups;\n\}/g;
    let match;
    const replacements: Array<{old: string, new: string}> = [];
    
    while ((match = functionPattern.exec(content)) !== null) {
      const fullMatch = match[0];
      const entityName = match[1];
      // 将第一个字母改为小写
      const managerName = entityName.charAt(0).toLowerCase() + entityName.slice(1);
      const newContent = fullMatch.replace(
        'return fieldGroups;',
        `return new FieldConfigManager('${managerName}', fieldGroups);`
      );
      replacements.push({ old: fullMatch, new: newContent });
    }
    
    // 执行替换
    for (const { old, new: newContent } of replacements) {
      content = content.replace(old, newContent);
    }
    
    fs.writeFileSync(fieldConfigPath, content, 'utf-8');
    console.log(`  ✓ 完成 (${replacements.length} 个函数)`);
  }
  
  // 修复 SearchConfigs
  const searchConfigPath = path.join(__dirname, `src/utils/configs/${dir}/${dir}SearchConfigs.ts`);
  if (fs.existsSync(searchConfigPath)) {
    console.log(`处理: ${dir}SearchConfigs.ts`);
    let content = fs.readFileSync(searchConfigPath, 'utf-8');
    
    // 替换所有 `return searchFieldGroups;` 为 `return new SearchConfigManager('xxx', searchFieldGroups);`
    const functionPattern = /export function create(\w+)SearchConfig\(\) \{[\s\S]*?return searchFieldGroups;\n\}/g;
    let match;
    const replacements: Array<{old: string, new: string}> = [];
    
    while ((match = functionPattern.exec(content)) !== null) {
      const fullMatch = match[0];
      const entityName = match[1];
      // 将第一个字母改为小写
      const managerName = entityName.charAt(0).toLowerCase() + entityName.slice(1);
      const newContent = fullMatch.replace(
        'return searchFieldGroups;',
        `return new SearchConfigManager('${managerName}', searchFieldGroups);`
      );
      replacements.push({ old: fullMatch, new: newContent });
    }
    
    // 执行替换
    for (const { old, new: newContent } of replacements) {
      content = content.replace(old, newContent);
    }
    
    fs.writeFileSync(searchConfigPath, content, 'utf-8');
    console.log(`  ✓ 完成 (${replacements.length} 个函数)`);
  }
}

console.log('\n全部完成！');
