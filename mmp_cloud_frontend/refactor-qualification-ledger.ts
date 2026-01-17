import * as fs from 'fs';
import * as path from 'path';

interface FileConfig {
  directory: string;  // 目录名（如 ledger, qualification 等）
  files: Array<{
    name: string;
    title: string;
    icon: string;
    desc: string;
    listTitle: string;  // 列表标题，例如"业务学习列表"
  }>;
}

// 配置需要重构的目录和文件
const allConfigs: FileConfig[] = [
  {
    directory: 'qualification',
    files: [
      { name: 'qualificationAdmissionCondition', title: '准入条件管理', icon: 'i-ep-tickets', desc: '管理准入条件和要求', listTitle: '准入条件列表' },
      { name: 'qualificationAuthorizationApply', title: '授权申请管理', icon: 'i-ep-document', desc: '管理授权申请和审批', listTitle: '授权申请列表' },
      { name: 'qualificationAuthorizationRecord', title: '授权记录管理', icon: 'i-ep-document-checked', desc: '管理授权记录和历史', listTitle: '授权记录列表' },
      { name: 'qualificationCatalog', title: '资质目录管理', icon: 'i-ep-folder', desc: '管理资质目录和分类', listTitle: '资质目录列表' },
      { name: 'qualificationExamArrangement', title: '考试安排管理', icon: 'i-ep-calendar', desc: '管理考试安排和通知', listTitle: '考试安排列表' },
      { name: 'qualificationExamPaper', title: '考试试卷管理', icon: 'i-ep-document-copy', desc: '管理考试试卷和题库', listTitle: '考试试卷列表' },
      { name: 'qualificationExamQuestion', title: '考试题目管理', icon: 'i-ep-edit', desc: '管理考试题目和答案', listTitle: '考试题目列表' },
      { name: 'qualificationExamRecord', title: '考试记录管理', icon: 'i-ep-notebook', desc: '管理考试记录和成绩', listTitle: '考试记录列表' },
      { name: 'qualificationPermissionAdjustment', title: '权限调整管理', icon: 'i-ep-key', desc: '管理权限调整和变更', listTitle: '权限调整列表' },
      { name: 'qualificationRiskMonitor', title: '风险监测管理', icon: 'i-ep-warning', desc: '管理风险监测和预警', listTitle: '风险监测列表' },
      { name: 'qualificationUsageRecord', title: '使用记录管理', icon: 'i-ep-clock', desc: '管理资质使用记录和统计', listTitle: '使用记录列表' }
    ]
  },
  {
    directory: 'ledger',
    files: [
      { name: 'ledgerBusinessLearning', title: '业务学习管理', icon: 'i-ep-reading', desc: '管理业务学习和培训记录', listTitle: '业务学习列表' },
      { name: 'ledgerCriticalPatient', title: '危重患者管理', icon: 'i-ep-warning', desc: '管理危重患者信息和监护', listTitle: '危重患者列表' },
      { name: 'ledgerLongStayPatient', title: '长期住院患者管理', icon: 'i-ep-timer', desc: '管理长期住院患者信息', listTitle: '长期住院患者列表' },
      { name: 'ledgerMajorSurgery', title: '大型手术管理', icon: 'i-ep-first-aid-kit', desc: '管理大型手术记录和统计', listTitle: '大型手术列表' },
      { name: 'ledgerPatientFullCycle', title: '患者全周期管理', icon: 'i-ep-data-line', desc: '管理患者全生命周期信息', listTitle: '患者全周期列表' },
      { name: 'ledgerUnplannedReoperation', title: '非计划再手术管理', icon: 'i-ep-refresh', desc: '管理非计划再手术记录和分析', listTitle: '非计划再手术列表' }
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
  // 先删除所有旧的page-header（包括重复的）
  const pageHeaderPattern = /(\s*<!--[^>]*页面标题[^>]*-->\s*)?<div class="page-header[^>]*>[\s\S]*?<\/div>(?=\s*\n\s*(?:<transition|<el-card|<div|<!--))/g;
  const oldHeaders = content.match(pageHeaderPattern);
  if (oldHeaders && oldHeaders.length > 0) {
    console.log(`    - 删除 ${oldHeaders.length} 个旧的 page-header`);
    content = content.replace(pageHeaderPattern, '');
    modified = true;
  }
  
  // 然后添加新的page-header
  if (!content.includes('<div class="page-header">')) {
    console.log(`    + 添加 page-header`);
    modified = true;
    needAddPageHeaderStyle = true;
    
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
  if (content.includes('v-show="showSearch"')) {
    const hasDynamicSearchForm = content.includes('DynamicSearchForm');
    const hasSearchConfig = content.includes('@click="handleSearchConfig"');
    
    // 修复重复的class属性
    content = content.replace(/class="mb-\[10px\]"\s+class="search-container mb-4"/, 'class="search-container mb-4"');
    content = content.replace(/(<div v-show="showSearch")[^>]*class="mb-\[10px\]"[^>]*class="search-container mb-4"/, '$1 class="search-container mb-4"');
    
    if (!hasDynamicSearchForm || !hasSearchConfig) {
      console.log(`    + 添加搜索配置功能`);
      modified = true;
      
      // 如果是旧的el-form结构，替换为DynamicSearchForm
      if (!hasDynamicSearchForm) {
        const oldFormPattern = /(<el-card[^>]*>)\s*(<el-form ref="queryFormRef"[\s\S]*?<\/el-form>)\s*(<\/el-card>)/;
        
        if (oldFormPattern.test(content)) {
          content = content.replace(
            oldFormPattern,
            `<el-card shadow="hover" class="search-card">
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
          <DynamicSearchForm
            ref="queryFormRef"
            :query="queryParams"
            :visible-fields="visibleSearchFields"
            @search="handleQuery"
            @reset="resetQuery"
          />
        </el-card>`
          );
        }
      } else if (!hasSearchConfig) {
        // 已经有DynamicSearchForm但缺少搜索配置按钮，添加header
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
      
      // 查找并替换旧的 table-header 样式
      const oldStylePattern = /\.page-header\s*\{[\s\S]*?(?=\n\s{2}\.(?!page-|title-|description)|\n\}[\s\S]*?<\/style>)/;
      if (oldStylePattern.test(content)) {
        content = content.replace(oldStylePattern, newPageHeaderStyle);
      }
    }
  }
  
  // 7. 修改列表标题
  if (content.includes('<span>数据列表</span>')) {
    console.log(`    * 修改列表标题为 "${fileConfig.listTitle}"`);
    modified = true;
    content = content.replace(/<span>数据列表<\/span>/g, `<span>${fileConfig.listTitle}</span>`);
  }
  
  // 8. 添加必要的导入语句
  const hasScriptSetup = content.includes('<script') && content.includes('setup');
  if (hasScriptSetup) {
    const needsDynamicSearchForm = content.includes('DynamicSearchForm') && !content.includes("import DynamicSearchForm from");
    const needsSearchConfigDialog = content.includes('handleSearchConfig') && !content.includes("import SearchConfigDialog from");
    const needsFieldConfigDialog = content.includes('handleFieldConfig') && !content.includes("import FieldConfigDialog from");
    
    if (needsDynamicSearchForm || needsSearchConfigDialog || needsFieldConfigDialog) {
      console.log(`    + 添加必要的组件导入`);
      modified = true;
      
      let imports = '';
      if (needsDynamicSearchForm) imports += "import DynamicSearchForm from '@/components/DynamicSearchForm.vue';\n";
      if (needsSearchConfigDialog) imports += "import SearchConfigDialog from '@/components/SearchConfigDialog.vue';\n";
      if (needsFieldConfigDialog) imports += "import FieldConfigDialog from '@/components/FieldConfigDialog.vue';\n";
      
      content = content.replace(
        /(<script.*?setup.*?lang="ts">\s*\n)/,
        `$1${imports}`
      );
    }
  }
  
  // 9. 在script部分添加必要的状态和方法
  if (hasScriptSetup) {
    const needsSearchConfig = content.includes('DynamicSearchForm') || content.includes('handleSearchConfig');
    const needsFieldConfig = content.includes('handleFieldConfig');
    
    if (needsSearchConfig || needsFieldConfig) {
      const hasSearchConfigVisible = content.includes('const searchConfigVisible') || content.includes('searchConfigVisible = ref');
      const hasFieldConfigVisible = content.includes('const fieldConfigVisible') || content.includes('fieldConfigVisible = ref');
      const hasVisibleSearchFields = content.includes('const visibleSearchFields') || content.includes('visibleSearchFields = ref');
      const hasHandleSearchConfig = content.includes('const handleSearchConfig = ');
      const hasHandleFieldConfig = content.includes('const handleFieldConfig = ');
      
      if (!hasSearchConfigVisible || !hasFieldConfigVisible || !hasVisibleSearchFields || !hasHandleSearchConfig || !hasHandleFieldConfig) {
        console.log(`    + 添加状态和方法`);
        modified = true;
        
        // 查找getCurrentInstance的位置，在它之前插入代码
        const getCurrentInstanceMatch = content.match(/(const\s+\{[\s\S]*?\}\s*=\s*getCurrentInstance\(\)[^\n]*;)/);
        if (getCurrentInstanceMatch) {
          let additionalCode = '\n';
          
          if (!hasSearchConfigVisible) {
            additionalCode += 'const searchConfigVisible = ref(false);\n';
          }
          if (!hasFieldConfigVisible) {
            additionalCode += 'const fieldConfigVisible = ref(false);\n';
          }
          if (!hasVisibleSearchFields) {
            additionalCode += 'const visibleSearchFields = ref<string[]>([]);\n';
          }
          if (!hasHandleSearchConfig) {
            additionalCode += '\nconst handleSearchConfig = () => {\n  searchConfigVisible.value = true;\n};\n';
          }
          if (!hasHandleFieldConfig) {
            additionalCode += '\nconst handleFieldConfig = () => {\n  fieldConfigVisible.value = true;\n};\n';
          }
          
          const insertPosition = content.indexOf(getCurrentInstanceMatch[0]);
          content = content.substring(0, insertPosition) + additionalCode + '\n' + content.substring(insertPosition);
        }
      }
    }
  }
  
  // 10. 添加配置对话框组件到正确位置（</template>之前）
  if (hasScriptSetup) {
    const needsDialogs = content.includes('handleSearchConfig') || content.includes('handleFieldConfig');
    
    if (needsDialogs && content.includes('</template>')) {
      // 先删除所有错误位置的对话框
      content = content.replace(/\s*<!--\s*搜索配置对话框\s*-->\s*<SearchConfigDialog[\s\S]*?\/>\s*/g, '');
      content = content.replace(/\s*<!--\s*字段配置对话框\s*-->\s*<FieldConfigDialog[\s\S]*?\/>\s*/g, '');
      
      const hasSearchConfigDialog = content.includes('<SearchConfigDialog');
      const hasFieldConfigDialog = content.includes('<FieldConfigDialog');
      
      if (!hasSearchConfigDialog || !hasFieldConfigDialog) {
        console.log(`    + 添加配置对话框组件`);
        modified = true;
        
        let dialogComponents = '\n';
        if (!hasSearchConfigDialog && content.includes('handleSearchConfig')) {
          dialogComponents += `    <!-- 搜索配置对话框 -->
    <SearchConfigDialog
      v-model:visible="searchConfigVisible"
      v-model:fields="visibleSearchFields"
      :config="[]"
      title="搜索字段配置"
    />
`;
        }
        if (!hasFieldConfigDialog && content.includes('handleFieldConfig')) {
          dialogComponents += `    
    <!-- 字段配置对话框 -->
    <FieldConfigDialog
      v-model:visible="fieldConfigVisible"
      :config="[]"
      title="列表字段配置"
    />
`;
        }
        
        // 简单替换：在</template>之前添加
        content = content.replace('</template>', `${dialogComponents}  </template>`);
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
console.log('开始重构 qualification 和 ledger 目录...\n');

for (const config of allConfigs) {
  console.log(`\n处理目录: ${config.directory} (${config.files.length} 个文件)`);
  console.log('='.repeat(60));
  
  for (const fileConfig of config.files) {
    processFile(config.directory, fileConfig);
  }
}

console.log('\n' + '='.repeat(60));
console.log('✓ 全部处理完成！');
