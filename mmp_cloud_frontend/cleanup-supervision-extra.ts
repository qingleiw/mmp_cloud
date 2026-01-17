/**
 * 清理supervision的多余函数
 */

import fs from 'fs';
import path from 'path';

const toRemove = [
  'createSupervisionFeedbackFieldConfig',
  'createSupervisionImprovementPlanFieldConfig',
  'createSupervisionImprovementFieldConfig',
  'createSupervisionReportFieldConfig',
  'createSupervisionTaskFieldConfig'
];

function removeFunctionFromFile(content: string, functionName: string): string {
  const functionRegex = new RegExp(
    `\n// [^\\n]*\\nexport function ${functionName}\\(\\)[\\s\\S]*?return new (?:Field|Search)ConfigManager\\([^)]+\\);\\n}\\n`,
    'g'
  );
  
  return content.replace(functionRegex, '\n');
}

const fieldConfigPath = path.join(process.cwd(), 'src', 'utils', 'configs', 'supervision', 'supervisionFieldConfigs.ts');
const searchConfigPath = path.join(process.cwd(), 'src', 'utils', 'configs', 'supervision', 'supervisionSearchConfigs.ts');

// 清理FieldConfigs
let fieldContent = fs.readFileSync(fieldConfigPath, 'utf-8');
toRemove.forEach(funcName => {
  fieldContent = removeFunctionFromFile(fieldContent, funcName);
  console.log(`✓ 已从FieldConfigs删除: ${funcName}`);
});
fs.writeFileSync(fieldConfigPath, fieldContent, 'utf-8');

// 清理SearchConfigs
let searchContent = fs.readFileSync(searchConfigPath, 'utf-8');
toRemove.forEach(funcName => {
  const searchFuncName = funcName.replace('FieldConfig', 'SearchConfig');
  searchContent = removeFunctionFromFile(searchContent, searchFuncName);
  console.log(`✓ 已从SearchConfigs删除: ${searchFuncName}`);
});
fs.writeFileSync(searchConfigPath, searchContent, 'utf-8');

console.log('\n✅ 清理完成！supervision现在有15个函数');
