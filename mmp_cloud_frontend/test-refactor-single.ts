import * as fs from 'fs';
import * as path from 'path';

const basePath = 'd:\\project\\FreelancerProject\\mmp_cloud\\mmp_cloud_frontend\\src\\views';

const fileConfig = {
  directory: 'emergency',
  name: 'emergencyEventResponse',
  title: '应急事件响应管理',
  icon: 'i-ep-warning',
  desc: '管理应急事件的响应措施和处理流程'
};

function processFile(directory: string, fileConfig: any) {
  const filePath = path.join(basePath, directory, fileConfig.name, 'index.vue');
  
  if (!fs.existsSync(filePath)) {
    console.log(`  ⊗ 文件不存在: ${fileConfig.name}`);
    return;
  }
  
  console.log(`处理文件: ${fileConfig.name}`);
  
  let content = fs.readFileSync(filePath, 'utf-8');
  let modified = false;
  let needAddPageHeaderStyle = false;
  
  // 1. 添加或替换 page-header
  if (!content.includes('<div class="page-header">')) {
    console.log(`  + 添加 page-header`);
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
    console.log(`  * 替换为简单的 page-header 结构`);
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
    console.log(`  * 修复导入路径`);
    modified = true;
    content = content.replace(/@\/components\/DynamicForm\/FieldConfigDialog\.vue/g, '@/components/FieldConfigDialog.vue');
  }
  
  // 3. 删除旧的字段配置和搜索项配置按钮
  const oldConfigButtonsPattern = /<el-button[^>]*@click="(fieldConfigVisible|searchConfigVisible)\s*=\s*true"[^>]*>[\s\S]*?<\/el-button>\s*/g;
  if (oldConfigButtonsPattern.test(content)) {
    console.log(`  - 删除旧的配置按钮`);
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
      console.log(`  + 添加搜索配置header`);
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
    console.log(`  * 修复 table-header 结构`);
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
      console.log(`  * 设置统一的 page-header 样式`);
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
    console.log(`  ✓ 完成`);
  } else {
    console.log(`  = 无需修改`);
  }
}

console.log('开始重构 emergencyEventResponse...\n');
processFile(fileConfig.directory, fileConfig);
console.log('\n✓ 重构完成！');
