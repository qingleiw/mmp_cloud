import * as fs from 'fs';
import * as path from 'path';

// 从正确的模板文件中提取结构
const templatePath = 'd:\\project\\FreelancerProject\\mmp_cloud\\mmp_cloud_frontend\\src\\views\\emergency\\emergencyDrillPlan\\index.vue';
const basePath = 'd:\\project\\FreelancerProject\\mmp_cloud\\mmp_cloud_frontend\\src\\views\\ledger';

interface LedgerConfig {
  name: string;
  title: string;
  icon: string;
  desc: string;
  listTitle: string;
  apiPath: string;  // API路径
  entityName: string;  // 实体名称（大写开头驼峰）
}

const ledgerConfigs: LedgerConfig[] = [
  {
    name: 'ledgerBusinessLearning',
    title: '业务学习管理',
    icon: 'i-ep-reading',
    desc: '管理业务学习和培训记录',
    listTitle: '业务学习列表',
    apiPath: 'ledger/ledgerBusinessLearning',
    entityName: 'LedgerBusinessLearning'
  },
  {
    name: 'ledgerCriticalPatient',
    title: '危重患者管理',
    icon: 'i-ep-warning',
    desc: '管理危重患者信息和监护',
    listTitle: '危重患者列表',
    apiPath: 'ledger/ledgerCriticalPatient',
    entityName: 'LedgerCriticalPatient'
  },
  {
    name: 'ledgerLongStayPatient',
    title: '长期住院患者管理',
    icon: 'i-ep-timer',
    desc: '管理长期住院患者信息',
    listTitle: '长期住院患者列表',
    apiPath: 'ledger/ledgerLongStayPatient',
    entityName: 'LedgerLongStayPatient'
  },
  {
    name: 'ledgerMajorSurgery',
    title: '大型手术管理',
    icon: 'i-ep-first-aid-kit',
    desc: '管理大型手术记录和统计',
    listTitle: '大型手术列表',
    apiPath: 'ledger/ledgerMajorSurgery',
    entityName: 'LedgerMajorSurgery'
  },
  {
    name: 'ledgerPatientFullCycle',
    title: '患者全周期管理',
    icon: 'i-ep-data-line',
    desc: '管理患者全生命周期信息',
    listTitle: '患者全周期列表',
    apiPath: 'ledger/ledgerPatientFullCycle',
    entityName: 'LedgerPatientFullCycle'
  },
  {
    name: 'ledgerUnplannedReoperation',
    title: '非计划再手术管理',
    icon: 'i-ep-refresh',
    desc: '管理非计划再手术记录和分析',
    listTitle: '非计划再手术列表',
    apiPath: 'ledger/ledgerUnplannedReoperation',
    entityName: 'LedgerUnplannedReoperation'
  }
];

function capitalizeFirst(str: string): string {
  return str.charAt(0).toUpperCase() + str.slice(1);
}

function processFile(config: LedgerConfig) {
  const filePath = path.join(basePath, config.name, 'index.vue');
  
  if (!fs.existsSync(filePath)) {
    console.log(`  ⊗ 文件不存在: ${config.name}`);
    return;
  }
  
  console.log(`\n处理: ${config.name}`);
  console.log('-'.repeat(60));
  
  let content = fs.readFileSync(filePath, 'utf-8');
  
  // 1. 替换Page Header
  console.log('  ✓ 替换 Page Header');
  const pageHeaderTemplate = `    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <${config.icon} class="title-icon"></${config.icon}>
        ${config.title}
      </h2>
      <p class="page-description">${config.desc}</p>
    </div>`;
  
  // 删除所有旧的page-header
  content = content.replace(/(\s*<!--[^>]*页面标题[^>]*-->\s*)?<div class="page-header[^>]*>[\s\S]*?<\/div>(?=\s*\n\s*(?:<transition|<el-card|<div|<!--|$))/g, '');
  
  // 在容器开始后添加新的page-header
  if (content.includes('class="app-container"')) {
    content = content.replace(/(<div class="app-container">)/, `$1\n${pageHeaderTemplate}\n`);
  } else if (content.includes('class="p-2"')) {
    content = content.replace(/(<div class="p-2">)/, `$1\n${pageHeaderTemplate}\n`);
  }
  
  // 2. 替换搜索区域
  console.log('  ✓ 替换搜索区域');
  const searchTemplate = `    <!-- 搜索区域 -->
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="search-container mb-4">
        <el-card shadow="hover" class="search-card">
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
        </el-card>
      </div>
    </transition>`;
  
  // 删除旧的搜索区域
  content = content.replace(/<transition[^>]*enter-active-class="proxy\?\.animate\.searchAnimate\.enter"[\s\S]*?<\/transition>/g, searchTemplate);
  
  // 3. 修改列表标题
  console.log('  ✓ 修改列表标题');
  content = content.replace(/<span>数据列表<\/span>/g, `<span>${config.listTitle}</span>`);
  
  // 4. 确保table-header结构正确
  if (!content.includes('<div class="table-header">')) {
    console.log('  ✓ 添加 table-header');
    // 需要添加table-header结构
  }
  
  // 5. 替换script部分的import
  console.log('  ✓ 更新 imports');
  const scriptMatch = content.match(/<script[^>]*>([\s\S]*?)<\/script>/);
  if (scriptMatch) {
    let scriptContent = scriptMatch[1];
    
    // 确保有必要的import
    if (!scriptContent.includes("import DynamicSearchForm")) {
      scriptContent = `import DynamicSearchForm from '@/components/DynamicSearchForm.vue';\n` + scriptContent;
    }
    if (!scriptContent.includes("import SearchConfigDialog")) {
      scriptContent = `import SearchConfigDialog from '@/components/SearchConfigDialog.vue';\n` + scriptContent;
    }
    if (!scriptContent.includes("import FieldConfigDialog")) {
      scriptContent = `import FieldConfigDialog from '@/components/FieldConfigDialog.vue';\n` + scriptContent;
    }
    
    // 添加配置管理器import（如果配置文件存在）
    const configImport = `import { create${config.entityName}FieldConfig } from '@/utils/configs/ledger/ledgerFieldConfigs';\nimport { create${config.entityName}SearchConfig } from '@/utils/configs/ledger/ledgerSearchConfigs';\n`;
    if (!scriptContent.includes(`create${config.entityName}FieldConfig`)) {
      // 在第一个import之后添加
      const firstImportEnd = scriptContent.indexOf(';') + 1;
      scriptContent = scriptContent.slice(0, firstImportEnd) + '\n' + configImport + scriptContent.slice(firstImportEnd);
    }
    
    // 添加必要的状态和方法
    if (!scriptContent.includes('const fieldConfigVisible')) {
      const getCurrentInstanceMatch = scriptContent.match(/(const\s+\{[\s\S]*?\}\s*=\s*getCurrentInstance\(\)[^\n]*;)/);
      if (getCurrentInstanceMatch) {
        const insertCode = `\n\n// 字段配置相关变量
const fieldConfigManager = create${config.entityName}FieldConfig();
const fieldConfigVisible = ref(false);
const searchConfigManager = create${config.entityName}SearchConfig();
const searchConfigVisible = ref(false);

// 计算属性：获取可见的搜索字段
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

// 计算属性：获取可见的表格字段
const visibleTableFields = computed(() => fieldConfigManager.getVisibleFields());
`;
        const insertPos = scriptContent.indexOf(getCurrentInstanceMatch[0]) + getCurrentInstanceMatch[0].length;
        scriptContent = scriptContent.slice(0, insertPos) + insertCode + scriptContent.slice(insertPos);
      }
    }
    
    // 添加处理方法
    if (!scriptContent.includes('const handleSearchConfig')) {
      const onMountedMatch = scriptContent.match(/onMounted\s*\(\s*\(\s*\)\s*=>\s*\{/);
      if (onMountedMatch) {
        const methodsCode = `
/** 搜索配置 */
const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

/** 字段配置 */
const handleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

/** 搜索配置确认 */
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  fieldConfigVisible.value = false;
};

`;
        const insertPos = scriptContent.indexOf(onMountedMatch[0]);
        scriptContent = scriptContent.slice(0, insertPos) + methodsCode + scriptContent.slice(insertPos);
      }
    }
    
    content = content.replace(/<script[^>]*>[\s\S]*?<\/script>/, `<script${scriptMatch[0].match(/<script([^>]*)>/)?.[1] || ''}>${scriptContent}</script>`);
  }
  
  // 6. 添加对话框组件
  console.log('  ✓ 添加配置对话框');
  if (!content.includes('<SearchConfigDialog')) {
    // 在最后一个</el-dialog>和</template>之间添加
    const lastDialogMatch = content.lastIndexOf('</el-dialog>');
    const templateEndMatch = content.indexOf('</template>');
    
    if (lastDialogMatch > 0 && templateEndMatch > lastDialogMatch) {
      const dialogComponents = `

    <!-- 搜索配置对话框 -->
    <SearchConfigDialog
      v-model:visible="searchConfigVisible"
      :searchConfigManager="searchConfigManager"
      @confirm="handleSearchConfigConfirm"
    />

    <!-- 字段配置对话框 -->
    <FieldConfigDialog
      v-model:visible="fieldConfigVisible"
      :fieldConfigManager="fieldConfigManager"
      @confirm="handleFieldConfigConfirm"
    />
  `;
      content = content.slice(0, lastDialogMatch + 12) + dialogComponents + content.slice(lastDialogMatch + 12);
    }
  }
  
  fs.writeFileSync(filePath, content, 'utf-8');
  console.log('  ✅ 完成');
}

console.log('='.repeat(60));
console.log('基于模板重构 ledger 页面');
console.log('='.repeat(60));

for (const config of ledgerConfigs) {
  processFile(config);
}

console.log('\n' + '='.repeat(60));
console.log('✅ 全部处理完成！');
console.log('='.repeat(60));
