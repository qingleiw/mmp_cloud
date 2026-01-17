import * as fs from 'fs';
import * as path from 'path';

interface FileConfig {
  directory: string;  // 目录名（如 ledger, qc 等）
  files: Array<{
    name: string;
    title: string;
    icon: string;
    desc: string;
  }>;
}

// 配置所有需要重构的目录和文件
const allConfigs: FileConfig[] = [
  {
    directory: 'emergency',
    files: [
      { name: 'emergencyDrillPlan', title: '应急演练计划管理', icon: 'i-ep-document', desc: '管理应急演练计划的创建、执行和评估' },
      { name: 'emergencyDrillSummary', title: '应急演练总结管理', icon: 'i-ep-document-checked', desc: '管理应急演练总结和评估报告' },
      { name: 'emergencyEvent', title: '突发事件管理', icon: 'i-ep-bell', desc: '管理突发事件的报告、处理和跟踪' },
      { name: 'emergencyEventResponse', title: '应急事件响应管理', icon: 'i-ep-warning', desc: '管理应急事件的响应措施和处理流程' },
      { name: 'emergencyEventTreatment', title: '应急事件处置管理', icon: 'i-ep-first-aid-kit', desc: '管理应急事件的处置过程和结果记录' },
      { name: 'emergencyIncident', title: '应急事故管理', icon: 'i-ep-warning-filled', desc: '管理应急事故的记录和分析' },
      { name: 'emergencyMedicalSupport', title: '应急医疗保障管理', icon: 'i-ep-medicine-box', desc: '管理应急医疗保障资源和支援措施' },
      { name: 'emergencyPlan', title: '应急预案管理', icon: 'i-ep-document-copy', desc: '管理应急预案的制定、审批和实施' },
      { name: 'emergencyPlanApproval', title: '应急预案审批管理', icon: 'i-ep-document-checked', desc: '管理应急预案的审批流程和记录' },
      { name: 'emergencyTeam', title: '应急队伍管理', icon: 'i-ep-user-filled', desc: '管理应急队伍的组建和培训' },
      { name: 'emergencyTeamMember', title: '应急队伍成员管理', icon: 'i-ep-avatar', desc: '管理应急队伍成员的信息和职责' }
    ]
  },
  {
    directory: 'ledger',
    files: [
      { name: 'ledgerAccountBalance', title: '账户余额管理', icon: 'i-ep-wallet', desc: '管理账户余额信息和查询' },
      { name: 'ledgerAccountBook', title: '账簿管理', icon: 'i-ep-notebook', desc: '管理账簿信息和记录' },
      { name: 'ledgerAccountingEntry', title: '会计分录管理', icon: 'i-ep-document', desc: '管理会计分录和凭证' },
      { name: 'ledgerAccountingSubject', title: '会计科目管理', icon: 'i-ep-files', desc: '管理会计科目设置和分类' },
      { name: 'ledgerAccountingVoucher', title: '会计凭证管理', icon: 'i-ep-ticket', desc: '管理会计凭证的录入和审核' },
      { name: 'ledgerFinancialStatement', title: '财务报表管理', icon: 'i-ep-data-analysis', desc: '管理财务报表的生成和查看' },
      { name: 'ledgerPaymentRecord', title: '支付记录管理', icon: 'i-ep-coin', desc: '管理支付记录和流水' }
    ]
  },
  {
    directory: 'qc',
    files: [
      { name: 'qcInspectionItem', title: '质控检查项目管理', icon: 'i-ep-list', desc: '管理质控检查项目和标准' },
      { name: 'qcInspectionPlan', title: '质控检查计划管理', icon: 'i-ep-calendar', desc: '管理质控检查计划和安排' },
      { name: 'qcInspectionRecord', title: '质控检查记录管理', icon: 'i-ep-document-checked', desc: '管理质控检查记录和结果' },
      { name: 'qcInspectionReport', title: '质控检查报告管理', icon: 'i-ep-data-board', desc: '管理质控检查报告和分析' },
      { name: 'qcInspectionStandard', title: '质控检查标准管理', icon: 'i-ep-coordinate', desc: '管理质控检查标准和规范' },
      { name: 'qcInspectionTemplate', title: '质控检查模板管理', icon: 'i-ep-document-copy', desc: '管理质控检查模板和配置' }
    ]
  },
  {
    directory: 'radiation',
    files: [
      { name: 'radiationDevice', title: '放射设备管理', icon: 'i-ep-monitor', desc: '管理放射设备信息和维护' },
      { name: 'radiationDeviceMaintenance', title: '放射设备维护管理', icon: 'i-ep-tools', desc: '管理放射设备维护记录' },
      { name: 'radiationDoseMonitoring', title: '辐射剂量监测管理', icon: 'i-ep-data-line', desc: '管理辐射剂量监测数据' },
      { name: 'radiationExamination', title: '放射检查管理', icon: 'i-ep-picture', desc: '管理放射检查申请和记录' },
      { name: 'radiationExposureRecord', title: '辐射暴露记录管理', icon: 'i-ep-warning', desc: '管理辐射暴露记录和统计' },
      { name: 'radiationProtection', title: '放射防护管理', icon: 'i-ep-lock', desc: '管理放射防护措施和培训' },
      { name: 'radiationProtectionEquipment', title: '放射防护设备管理', icon: 'i-ep-box', desc: '管理放射防护设备和配置' },
      { name: 'radiationQualityControl', title: '放射质量控制管理', icon: 'i-ep-finished', desc: '管理放射质量控制和检测' },
      { name: 'radiationReport', title: '放射报告管理', icon: 'i-ep-document', desc: '管理放射检查报告和审核' },
      { name: 'radiationRoom', title: '放射机房管理', icon: 'i-ep-office-building', desc: '管理放射机房信息和状态' },
      { name: 'radiationSafetyTraining', title: '放射安全培训管理', icon: 'i-ep-reading', desc: '管理放射安全培训和考核' },
      { name: 'radiationStaff', title: '放射工作人员管理', icon: 'i-ep-user', desc: '管理放射工作人员资质和培训' },
      { name: 'radiationWasteDisposal', title: '放射性废物处置管理', icon: 'i-ep-delete-filled', desc: '管理放射性废物处置记录' }
    ]
  },
  {
    directory: 'supervision',
    files: [
      { name: 'supervisionComplaint', title: '投诉管理', icon: 'i-ep-chat-line-square', desc: '管理投诉信息和处理' },
      { name: 'supervisionComplaintHandling', title: '投诉处理管理', icon: 'i-ep-edit', desc: '管理投诉处理流程和结果' },
      { name: 'supervisionInspection', title: '监督检查管理', icon: 'i-ep-search', desc: '管理监督检查计划和执行' },
      { name: 'supervisionInspectionItem', title: '检查项目管理', icon: 'i-ep-list', desc: '管理检查项目和标准' },
      { name: 'supervisionInspectionPlan', title: '检查计划管理', icon: 'i-ep-calendar', desc: '管理检查计划和安排' },
      { name: 'supervisionInspectionRecord', title: '检查记录管理', icon: 'i-ep-document', desc: '管理检查记录和结果' },
      { name: 'supervisionInspectionReport', title: '检查报告管理', icon: 'i-ep-data-board', desc: '管理检查报告和分析' },
      { name: 'supervisionInspectionTask', title: '检查任务管理', icon: 'i-ep-finished', desc: '管理检查任务分配和执行' },
      { name: 'supervisionLawEnforcement', title: '执法管理', icon: 'i-ep-stamp', desc: '管理执法行动和记录' },
      { name: 'supervisionPenalty', title: '处罚管理', icon: 'i-ep-warning', desc: '管理处罚决定和执行' },
      { name: 'supervisionRectification', title: '整改管理', icon: 'i-ep-refresh', desc: '管理整改通知和跟踪' },
      { name: 'supervisionRectificationNotice', title: '整改通知管理', icon: 'i-ep-bell', desc: '管理整改通知发送和回复' },
      { name: 'supervisionRectificationRecord', title: '整改记录管理', icon: 'i-ep-document-checked', desc: '管理整改记录和验收' },
      { name: 'supervisionRisk', title: '风险管理', icon: 'i-ep-warning-filled', desc: '管理风险识别和评估' },
      { name: 'supervisionRiskAssessment', title: '风险评估管理', icon: 'i-ep-data-analysis', desc: '管理风险评估和报告' }
    ]
  },
  {
    directory: 'surgery',
    files: [
      { name: 'surgeryAnesthesiaRecord', title: '麻醉记录管理', icon: 'i-ep-document', desc: '管理麻醉记录和监测' },
      { name: 'surgeryOperationRecord', title: '手术记录管理', icon: 'i-ep-edit', desc: '管理手术记录和报告' }
    ]
  },
  {
    directory: 'tumorqc',
    files: [
      { name: 'tumorqcCaseDiscussion', title: '病例讨论管理', icon: 'i-ep-chat-dot-square', desc: '管理肿瘤病例讨论和记录' },
      { name: 'tumorqcCaseReview', title: '病例审查管理', icon: 'i-ep-document-checked', desc: '管理肿瘤病例审查和评价' },
      { name: 'tumorqcQualityIndicator', title: '质量指标管理', icon: 'i-ep-data-line', desc: '管理肿瘤质控指标和监测' },
      { name: 'tumorqcTreatmentPlan', title: '治疗方案管理', icon: 'i-ep-document-copy', desc: '管理肿瘤治疗方案和执行' },
      { name: 'tumorqcTreatmentRecord', title: '治疗记录管理', icon: 'i-ep-document', desc: '管理肿瘤治疗记录和随访' }
    ]
  },
  {
    directory: 'natdss',
    files: [
      { name: 'natdssDecisionModel', title: '决策模型管理', icon: 'i-ep-data-analysis', desc: '管理决策模型和算法' },
      { name: 'natdssDecisionRecord', title: '决策记录管理', icon: 'i-ep-document', desc: '管理决策记录和结果' },
      { name: 'natdssDecisionRule', title: '决策规则管理', icon: 'i-ep-files', desc: '管理决策规则和配置' },
      { name: 'natdssDecisionTask', title: '决策任务管理', icon: 'i-ep-finished', desc: '管理决策任务和执行' },
      { name: 'natdssKnowledgeBase', title: '知识库管理', icon: 'i-ep-collection', desc: '管理知识库和资源' },
      { name: 'natdssKnowledgeEntry', title: '知识条目管理', icon: 'i-ep-document-copy', desc: '管理知识条目和内容' }
    ]
  }
];

const basePath = 'd:\\project\\FreelancerProject\\mmp_cloud\\mmp_cloud_frontend\\src\\views';

function processFile(directory: string, fileConfig: any) {
  const filePath = path.join(basePath, directory, fileConfig.name, 'index.vue');
  
  if (!fs.existsSync(filePath)) {
    console.log(`  ⊗ 文件不存在: ${fileConfig.name}`);
    return;
  }
  
  console.log(`  处理: ${fileConfig.name}`);
  
  let content = fs.readFileSync(filePath, 'utf-8');
  let modified = false;
  let needAddPageHeaderStyle = false;
  
  // 1. 添加或替换 page-header
  if (!content.includes('<div class="page-header">')) {
    console.log(`    + 添加 page-header`);
    modified = true;
    
    const pageHeader = `    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <${fileConfig.icon} class="title-icon"></${fileConfig.icon}>
        ${fileConfig.title}
      </h2>
      <p class="page-description">${fileConfig.desc}</p>
    </div>

`;
    
    // 支持 app-container 和 p-2 两种容器
    if (content.includes('class="app-container"')) {
      content = content.replace(/(<div class="app-container">)/, `$1\n${pageHeader}`);
    } else if (content.includes('class="p-2"')) {
      content = content.replace(/(<div class="p-2">)/, `$1\n${pageHeader}`);
    }
    needAddPageHeaderStyle = true;
  } else if (content.includes('<div class="header-content">') || content.includes('<component :is=')) {
    // 如果使用了旧的复杂结构，替换为简单结构
    console.log(`    * 替换为简单的 page-header 结构`);
    modified = true;
    
    // 匹配整个 page-header 块（包括注释），从注释或div开始到对应的闭合标签
    const oldHeaderPattern = /(\s*<!--[^>]*页面标题[^>]*-->\s*)?<div class="page-header[^>]*>[\s\S]*?<\/div>(?=\s*\n\s*(?:<transition|<el-card|<div))/;
    const newHeader = `    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <${fileConfig.icon} class="title-icon"></${fileConfig.icon}>
        ${fileConfig.title}
      </h2>
      <p class="page-description">${fileConfig.desc}</p>
    </div>
`;
    
    if (oldHeaderPattern.test(content)) {
      content = content.replace(oldHeaderPattern, newHeader);
    }
    needAddPageHeaderStyle = true;
  }
  
  // 2. 修复导入路径
  if (content.includes('@/components/DynamicForm/FieldConfigDialog.vue')) {
    console.log(`    * 修复导入路径`);
    modified = true;
    content = content.replace(/@\/components\/DynamicForm\/FieldConfigDialog\.vue/g, '@/components/FieldConfigDialog.vue');
  }
  
  // 3. 删除旧的字段配置和搜索项配置按钮
  const oldConfigButtonsPattern = /<el-button[^>]*@click="(fieldConfigVisible|searchConfigVisible)\s*=\s*true"[^>]*>[\s\S]*?<\/el-button>\s*/g;
  if (oldConfigButtonsPattern.test(content)) {
    console.log(`    - 删除旧的配置按钮`);
    modified = true;
    content = content.replace(oldConfigButtonsPattern, '');
  }
  
  // 4. 在搜索区域中添加header和搜索配置按钮
  if (content.includes('v-show="showSearch"') && content.includes('DynamicSearchForm')) {
    // 先给transition下的div添加class和注释（如果没有）
    if (!content.includes('class="search-container"')) {
      content = content.replace(
        /(<div v-show="showSearch"[^>]*)(>)/,
        '$1 class="search-container mb-4"$2'
      );
    }
    
    // 给el-card添加class（如果没有）
    content = content.replace(
      /<el-card shadow="hover">/g,
      '<el-card shadow="hover" class="search-card">'
    );
    
    // 如果还没有搜索配置按钮，添加header
    if (!content.includes('@click="handleSearchConfig"')) {
      console.log(`    + 添加搜索配置header`);
      modified = true;
      
      const searchCardPattern = /(<el-card shadow="hover" class="search-card">)\s*(<DynamicSearchForm|<template)/;
      const searchCardReplacement = `$1
          <template #header>
            <div class="search-header">
              <span class="search-title">
                <i-ep-search class="search-icon"></i-ep-search>
                搜索条件
              </span>
              <div class="search-actions">
                <el-button text type="primary" @click="handleSearchConfig" class="config-btn">
                  <i-ep-setting class="btn-icon"></i-ep-setting>
                  搜索配置
                </el-button>
              </div>
            </div>
          </template>
          $2`;
      
      content = content.replace(searchCardPattern, searchCardReplacement);
    }
  }
  
  // 5. 修复table-header（从el-row格式改为div格式）
  if (content.includes('<el-row :gutter="10" class="mb8">')) {
    console.log(`    * 修复 table-header 结构`);
    modified = true;
    
    const rowMatch = content.match(/<el-row :gutter="10" class="mb8">([\s\S]*?)<\/el-row>/);
    if (rowMatch) {
      let buttonsContent = rowMatch[1];
      
      // 移除el-col包装
      buttonsContent = buttonsContent.replace(/<el-col[^>]*>/g, '');
      buttonsContent = buttonsContent.replace(/<\/el-col>/g, '');
      
      // 删除旧的配置按钮
      buttonsContent = buttonsContent.replace(/<el-button[^>]*@click="(fieldConfigVisible|searchConfigVisible)\s*=\s*true"[^>]*>[\s\S]*?<\/el-button>\s*/g, '');
      
      // 删除已存在的right-toolbar（避免重复）
      buttonsContent = buttonsContent.replace(/<right-toolbar[^>]*>[\s\S]*?<\/right-toolbar>\s*/g, '');
      
      // 确保所有按钮都有plain和size="small"
      buttonsContent = buttonsContent.replace(/<el-button(?![^>]*\bplain\b)(?![^>]*\btext\b)/g, '<el-button plain');
      buttonsContent = buttonsContent.replace(/<el-button(?![^>]*\bsize=)/g, '<el-button size="small"');
      
      const newTableHeader = `      <div class="table-header">
        <div class="table-title">
          <i-ep-list class="table-icon"></i-ep-list>
          <span>数据列表</span>
        </div>
        <div class="table-actions">
${buttonsContent}
          <el-button text type="primary" @click="handleFieldConfig" class="config-btn">
            <i-ep-setting class="btn-icon"></i-ep-setting>
            字段配置
          </el-button>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </div>
      </div>`;
      
      content = content.replace(/<el-row :gutter="10" class="mb8">[\s\S]*?<\/el-row>/, newTableHeader);
    }
  } else if (content.includes('<div class="table-header">') && !content.includes('@click="handleFieldConfig"')) {
    // 如果已经是div格式但缺少字段配置按钮，添加它
    console.log(`    + 添加字段配置按钮`);
    modified = true;
    
    // 在right-toolbar之前添加字段配置按钮
    content = content.replace(
      /(<div class="table-actions">)([\s\S]*?)(<right-toolbar)/,
      (match, p1, p2, p3) => {
        // 确保移除重复的right-toolbar
        let actions = p2.replace(/<right-toolbar[^>]*>[\s\S]*?<\/right-toolbar>\s*/g, '');
        return `${p1}${actions}
          <el-button text type="primary" @click="handleFieldConfig" class="config-btn">
            <i-ep-setting class="btn-icon"></i-ep-setting>
            字段配置
          </el-button>
          ${p3}`;
      }
    );
  }
  
  // 6. 确保 page-header 使用统一的白色背景样式
  if (content.includes('<style') && content.includes('.page-header')) {
    // 定义统一的样式（和 emergencyDrillPlan 保持一致）
    const newPageHeaderStyle = `.page-header {
    background: white;
    padding: 20px;
    border-radius: 8px;
    margin-bottom: 20px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

    .page-title {
      display: flex;
      align-items: center;
      gap: 8px;
      margin: 0 0 8px 0;
      color: #1d2129;
      font-size: 18px;
      font-weight: 600;

      .title-icon {
        color: #409eff;
        font-size: 20px;
      }
    }

    .page-description {
      margin: 0;
      color: #86909c;
      font-size: 14px;
    }
  }`;
    
    // 如果添加了新的HTML结构，或者样式不匹配，则替换样式
    if (needAddPageHeaderStyle || !content.includes('.page-title') || content.includes('.header-content')) {
      console.log(`    * 设置统一的 page-header 样式`);
      modified = true;
      
      // 查找并替换旧的 page-header 样式
      const oldStylePattern = /\.page-header\s*\{[\s\S]*?(?=\n\s{2}\.(?!page-|title-|description)|\n\}[\s\S]*?<\/style>)/;
      if (oldStylePattern.test(content)) {
        content = content.replace(oldStylePattern, newPageHeaderStyle);
      }
    }
  }
  
  if (modified) {
    fs.writeFileSync(filePath, content, 'utf-8');
    console.log(`    ✓ 完成`);
  } else {
    console.log(`    = 无需修改`);
  }
}

// 主处理逻辑
console.log('开始批量重构 MMP 目录...\n');

for (const config of allConfigs) {
  console.log(`\n处理目录: ${config.directory} (${config.files.length} 个文件)`);
  console.log('='.repeat(60));
  
  for (const fileConfig of config.files) {
    processFile(config.directory, fileConfig);
  }
}

console.log('\n' + '='.repeat(60));
console.log('✓ 全部处理完成！');
