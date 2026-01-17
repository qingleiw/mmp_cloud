import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

// 定义需要补充的配置
const missingConfigs = {
  radiation: [
    { varName: 'radiationDoseAlert', label: '辐射剂量预警' },
    { varName: 'radiationDoseAlertRecord', label: '辐射剂量预警记录' },
    { varName: 'radiationDoseMonitoring', label: '辐射剂量监测' },
    { varName: 'radiationDoseRecord', label: '辐射剂量记录' },
    { varName: 'radiationEquipmentInspection', label: '辐射设备检查' },
    { varName: 'radiationHealthExam', label: '辐射健康体检' },
    { varName: 'radiationHealthExamPlan', label: '辐射健康体检计划' },
    { varName: 'radiationHealthExamResult', label: '辐射健康体检结果' },
    { varName: 'radiationStaff', label: '辐射工作人员' },
    { varName: 'radiationTraining', label: '辐射培训' },
    { varName: 'radiationTrainingParticipant', label: '辐射培训参与人员' },
    { varName: 'radiationTrainingPlan', label: '辐射培训计划' },
    { varName: 'radiationWorker', label: '辐射工作者' }
  ],
  supervision: [
    { varName: 'supervisionExpertGroup', label: '督导专家组' },
    { varName: 'supervisionExpertMember', label: '督导专家成员' },
    { varName: 'supervisionForm', label: '督导表单' },
    { varName: 'supervisionFormField', label: '督导表单字段' },
    { varName: 'supervisionIssue', label: '督导问题' },
    { varName: 'supervisionPlan', label: '督导计划' },
    { varName: 'supervisionPlanDept', label: '督导计划部门' },
    { varName: 'supervisionPlanForm', label: '督导计划表单' },
    { varName: 'supervisionProject', label: '督导项目' },
    { varName: 'supervisionProjectIndicator', label: '督导项目指标' },
    { varName: 'supervisionRectificationProgress', label: '督导整改进度' },
    { varName: 'supervisionRectificationTask', label: '督导整改任务' },
    { varName: 'supervisionResult', label: '督导结果' },
    { varName: 'supervisionResultDetail', label: '督导结果明细' },
    { varName: 'supervisionReview', label: '督导审核' }
  ],
  surgery: [
    { varName: 'surgeryApprovalForm', label: '手术审批表' },
    { varName: 'surgeryCatalog', label: '手术目录' },
    { varName: 'surgeryComplicationRecord', label: '手术并发症记录' },
    { varName: 'surgeryRecord', label: '手术记录' },
    { varName: 'surgeryTeam', label: '手术团队' },
    { varName: 'surgeryVideo', label: '手术视频' },
    { varName: 'surgeryWorkloadStatistics', label: '手术工作量统计' }
  ]
};

// 生成FieldConfig函数
function generateFieldConfig(dir: string, varName: string, label: string): string {
  const entityName = varName.charAt(0).toUpperCase() + varName.slice(1);
  return `
// ${label}字段配置
export function create${entityName}FieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'code', label: '编码', visible: true, required: true, type: 'input', group: 'basic' },
        { prop: 'name', label: '名称', visible: true, required: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '状态', visible: true, type: 'select', group: 'basic' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('${varName}', fieldGroups);
}
`;
}

// 生成SearchConfig函数
function generateSearchConfig(dir: string, varName: string, label: string): string {
  const entityName = varName.charAt(0).toUpperCase() + varName.slice(1);
  return `
// ${label}搜索配置
export function create${entityName}SearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'code', label: '编码', type: 'input', placeholder: '请输入编码', group: 'basic' },
        { prop: 'name', label: '名称', type: 'input', placeholder: '请输入名称', group: 'basic' },
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态', group: 'basic' }
      ]
    }
  ];

  return new SearchConfigManager('${varName}', searchFieldGroups);
}
`;
}

// 处理每个目录
for (const [dir, configs] of Object.entries(missingConfigs)) {
  const fieldConfigPath = path.join(__dirname, `src/utils/configs/${dir}/${dir}FieldConfigs.ts`);
  const searchConfigPath = path.join(__dirname, `src/utils/configs/${dir}/${dir}SearchConfigs.ts`);

  // 读取现有文件
  let fieldContent = fs.readFileSync(fieldConfigPath, 'utf-8');
  let searchContent = fs.readFileSync(searchConfigPath, 'utf-8');

  // 为每个缺失的配置生成函数
  let newFieldFunctions = '';
  let newSearchFunctions = '';

  for (const config of configs) {
    const entityName = config.varName.charAt(0).toUpperCase() + config.varName.slice(1);
    
    // 检查是否已存在
    if (!fieldContent.includes(`create${entityName}FieldConfig`)) {
      newFieldFunctions += generateFieldConfig(dir, config.varName, config.label);
    }
    
    if (!searchContent.includes(`create${entityName}SearchConfig`)) {
      newSearchFunctions += generateSearchConfig(dir, config.varName, config.label);
    }
  }

  // 追加到文件末尾
  if (newFieldFunctions) {
    fieldContent += newFieldFunctions;
    fs.writeFileSync(fieldConfigPath, fieldContent, 'utf-8');
    console.log(`✓ 已更新 ${dir}FieldConfigs.ts，添加了 ${configs.length} 个函数`);
  }

  if (newSearchFunctions) {
    searchContent += newSearchFunctions;
    fs.writeFileSync(searchConfigPath, searchContent, 'utf-8');
    console.log(`✓ 已更新 ${dir}SearchConfigs.ts，添加了 ${configs.length} 个函数`);
  }
}

console.log('\n✓ 全部完成！');
