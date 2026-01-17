/**
 * 清理旧的配置函数
 * 删除radiation、supervision、surgery这三个目录中前6个不匹配的旧函数
 */

import fs from 'fs';
import path from 'path';

// 需要删除的旧函数（每个目录的前6个）
const oldFunctions = {
  radiation: [
    'createRadiationExaminationRecordFieldConfig',
    'createRadiationEquipmentManagementFieldConfig',
    'createRadiationDoseMonitorFieldConfig',
    'createRadiationQualityControlFieldConfig',
    'createRadiationReportReviewFieldConfig',
    'createRadiationWorkloadStatisticsFieldConfig'
  ],
  supervision: [
    'createSupervisionInspectionRecordFieldConfig',
    'createSupervisionRectificationNoticeFieldConfig',
    'createSupervisionRectificationReportFieldConfig',
    'createSupervisionPenaltyDecisionFieldConfig',
    'createSupervisionWorkPlanFieldConfig',
    'createSupervisionStatisticsReportFieldConfig'
  ],
  surgery: [
    'createMajorSurgeryApplicationFieldConfig',
    'createSurgeryWorkloadStatisticsFieldConfig',
    'createSurgeryComplicationRecordFieldConfig',
    'createSurgeryTeamFieldConfig',
    'createSurgeryVideoFieldConfig',
    'createSurgeryRecordFieldConfig'
  ]
};

function removeFunctionFromFile(content: string, functionName: string): string {
  // 匹配整个函数，从export function到return语句结束
  const functionRegex = new RegExp(
    `\n// [^\\n]*\\nexport function ${functionName}\\(\\)[\\s\\S]*?return new (?:Field|Search)ConfigManager\\([^)]+\\);\\n}\\n`,
    'g'
  );
  
  return content.replace(functionRegex, '\n');
}

function cleanupDirectory(dir: string) {
  const fieldConfigPath = path.join(process.cwd(), 'src', 'utils', 'configs', dir, `${dir}FieldConfigs.ts`);
  const searchConfigPath = path.join(process.cwd(), 'src', 'utils', 'configs', dir, `${dir}SearchConfigs.ts`);
  
  const functionsToRemove = oldFunctions[dir as keyof typeof oldFunctions];
  
  if (!functionsToRemove) {
    console.log(`⚠️  ${dir} 没有需要清理的函数`);
    return;
  }
  
  console.log(`\n📁 处理目录: ${dir}`);
  console.log(`   需要删除 ${functionsToRemove.length} 个旧函数`);
  
  // 清理FieldConfigs
  if (fs.existsSync(fieldConfigPath)) {
    let fieldContent = fs.readFileSync(fieldConfigPath, 'utf-8');
    let removedCount = 0;
    
    functionsToRemove.forEach(funcName => {
      const beforeLength = fieldContent.length;
      fieldContent = removeFunctionFromFile(fieldContent, funcName);
      if (fieldContent.length < beforeLength) {
        removedCount++;
        console.log(`   ✓ 已从FieldConfigs删除: ${funcName}`);
      }
    });
    
    if (removedCount > 0) {
      fs.writeFileSync(fieldConfigPath, fieldContent, 'utf-8');
      console.log(`✅ 已更新 ${dir}FieldConfigs.ts，删除了 ${removedCount} 个函数`);
    }
  }
  
  // 清理SearchConfigs
  if (fs.existsSync(searchConfigPath)) {
    let searchContent = fs.readFileSync(searchConfigPath, 'utf-8');
    let removedCount = 0;
    
    functionsToRemove.forEach(funcName => {
      const searchFuncName = funcName.replace('FieldConfig', 'SearchConfig');
      const beforeLength = searchContent.length;
      searchContent = removeFunctionFromFile(searchContent, searchFuncName);
      if (searchContent.length < beforeLength) {
        removedCount++;
        console.log(`   ✓ 已从SearchConfigs删除: ${searchFuncName}`);
      }
    });
    
    if (removedCount > 0) {
      fs.writeFileSync(searchConfigPath, searchContent, 'utf-8');
      console.log(`✅ 已更新 ${dir}SearchConfigs.ts，删除了 ${removedCount} 个函数`);
    }
  }
}

// 主函数
function main() {
  console.log('🚀 开始清理旧的配置函数...\n');
  
  ['radiation', 'supervision', 'surgery'].forEach(dir => {
    try {
      cleanupDirectory(dir);
    } catch (error) {
      console.error(`❌ 处理 ${dir} 时出错:`, error);
    }
  });
  
  console.log('\n✨ 清理完成！');
  console.log('\n下一步：运行 npm exec tsx sync-search-configs-from-fields.ts 重新生成搜索配置');
}

main();
