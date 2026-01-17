import * as fs from 'fs';
import * as path from 'path';

const basePath = 'd:\\project\\FreelancerProject\\mmp_cloud\\mmp_cloud_frontend\\src\\views\\emergency';

interface FileConfig {
  name: string;
  title: string;
  icon: string;
  desc: string;
}

const fileConfigs: FileConfig[] = [
  {
    name: 'emergencyEventResponse',
    title: '应急事件响应管理',
    icon: 'i-ep-warning',
    desc: '管理应急事件的响应措施和处理流程'
  },
  {
    name: 'emergencyEventTreatment',
    title: '应急事件处置管理',
    icon: 'i-ep-first-aid-kit',
    desc: '管理应急事件的处置过程和结果记录'
  },
  {
    name: 'emergencyMedicalSupport',
    title: '应急医疗保障管理',
    icon: 'i-ep-medicine-box',
    desc: '管理应急医疗保障资源和支援措施'
  },
  {
    name: 'emergencyPlan',
    title: '应急预案管理',
    icon: 'i-ep-document-copy',
    desc: '管理应急预案的制定、审批和实施'
  },
  {
    name: 'emergencyPlanApproval',
    title: '应急预案审批管理',
    icon: 'i-ep-document-checked',
    desc: '管理应急预案的审批流程和记录'
  },
  {
    name: 'emergencyTeamMember',
    title: '应急队伍成员管理',
    icon: 'i-ep-avatar',
    desc: '管理应急队伍成员的信息和职责'
  }
];

for (const config of fileConfigs) {
  const filePath = path.join(basePath, config.name, 'index.vue');
  
  if (!fs.existsSync(filePath)) {
    console.log(`文件不存在: ${filePath}`);
    continue;
  }
  
  console.log(`处理文件: ${config.name}`);
  
  let content = fs.readFileSync(filePath, 'utf-8');
  
  // 1. 检查并添加page-header（如果没有）
  if (!content.includes('<div class="page-header">')) {
    console.log('  添加 page-header');
    
    const pageHeader = `    <!-- 页面标题 -->
    <div class="page-header">
      <div class="header-content">
        <div class="header-icon">
          <el-icon size="24">
            <component :is="'${config.icon}'" />
          </el-icon>
        </div>
        <div class="header-text">
          <h2 class="header-title">${config.title}</h2>
          <p class="header-description">${config.desc}</p>
        </div>
      </div>
    </div>

`;
    
    content = content.replace(/(<div class="app-container">)/, `$1\n${pageHeader}`);
  }
  
  // 2. 修复搜索区域的header（添加搜索配置按钮）
  if (content.includes('<div class="search-card">') && content.includes('<div class="card-header">')) {
    if (!content.includes('@click="handleSearchConfig"')) {
      console.log('  添加搜索配置按钮');
      
      // 查找搜索区域的card-header，添加搜索配置按钮
      const searchHeaderPattern = /(<div class="search-card">[\s\S]*?<div class="card-header">[\s\S]*?<span>搜索条件<\/span>\s*<\/div>)/;
      const searchHeaderReplacement = `<div class="search-card">
      <div class="card-header">
        <span>搜索条件</span>
        <el-button
          type="primary"
          :icon="Setting"
          size="small"
          plain
          @click="handleSearchConfig"
        >
          搜索配置
        </el-button>
      </div>`;
      
      content = content.replace(searchHeaderPattern, searchHeaderReplacement);
    }
  }
  
  // 3. 修复table-header（从el-row格式改为div格式）
  if (content.includes('<el-row :gutter="10" class="mb8">')) {
    console.log('  修复 table-header 结构');
    
    // 提取按钮内容（保留现有的按钮）
    const rowMatch = content.match(/<el-row :gutter="10" class="mb8">([\s\S]*?)<\/el-row>/);
    if (rowMatch) {
      let buttonsContent = rowMatch[1];
      
      // 移除el-col包装，但保留按钮
      buttonsContent = buttonsContent.replace(/<el-col[^>]*>/g, '');
      buttonsContent = buttonsContent.replace(/<\/el-col>/g, '');
      
      // 移除旧的字段配置和搜索项配置按钮（它们使用fieldConfigVisible和searchConfigVisible）
      buttonsContent = buttonsContent.replace(/<el-button[^>]*fieldConfigVisible\s*=\s*true[^>]*>[\s\S]*?<\/el-button>\s*/g, '');
      buttonsContent = buttonsContent.replace(/<el-button[^>]*searchConfigVisible\s*=\s*true[^>]*>[\s\S]*?<\/el-button>\s*/g, '');
      
      // 确保所有按钮都有plain和size="small"
      buttonsContent = buttonsContent.replace(/<el-button(?![^>]*\bplain\b)/g, '<el-button plain');
      buttonsContent = buttonsContent.replace(/<el-button(?![^>]*\bsize=)/g, '<el-button size="small"');
      
      const newTableHeader = `      <div class="table-header">
        <div class="header-title">
          <span>数据列表</span>
        </div>
        <div class="header-actions">
${buttonsContent}
          <el-button
            type="primary"
            :icon="Setting"
            size="small"
            plain
            @click="handleFieldConfig"
          >
            列配置
          </el-button>
        </div>
      </div>`;
      
      // 替换整个el-row结构
      content = content.replace(/<el-row :gutter="10" class="mb8">[\s\S]*?<\/el-row>/, newTableHeader);
    }
  }
  
  // 4. 确保所有独立按钮都有plain和size="small"
  content = content.replace(/<el-button(?![^>]*\bplain\b)(?=[^>]*@click="(handleAdd|handleEdit|handleDelete|handleExport|handleImport|handleFieldConfig|handleSearchConfig)")/g, '<el-button plain');
  content = content.replace(/<el-button(?![^>]*\bsize=)(?=[^>]*@click="(handleAdd|handleEdit|handleDelete|handleExport|handleImport|handleFieldConfig|handleSearchConfig)")/g, '<el-button size="small"');
  
  // 5. 保存文件
  fs.writeFileSync(filePath, content, 'utf-8');
  console.log('  ✓ 完成');
}

console.log('\n全部处理完成！');
