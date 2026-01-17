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
  
  // 1. 删除旧的字段配置和搜索项配置按钮
  // 匹配: <el-button ... @click="fieldConfigVisible = true">字段配置</el-button>
  content = content.replace(/<el-button[^>]*@click="fieldConfigVisible\s*=\s*true"[^>]*>[\s\S]*?<\/el-button>\s*/g, '');
  content = content.replace(/<el-button[^>]*@click="searchConfigVisible\s*=\s*true"[^>]*>[\s\S]*?<\/el-button>\s*/g, '');
  
  // 2. 在search-card中添加header和搜索配置按钮
  if (content.includes('<el-card shadow="hover" class="search-card">')) {
    // 检查是否已经有搜索配置按钮
    if (!content.includes('@click="handleSearchConfig"')) {
      console.log('  添加搜索配置按钮');
      
      // 查找: <el-card shadow="hover" class="search-card">
      //        <DynamicSearchForm ...
      // 替换为: <el-card shadow="hover" class="search-card">
      //           <template #header>
      //             <div class="card-header">...
      //           </template>
      //           <DynamicSearchForm ...
      
      const searchCardPattern = /(<el-card shadow="hover" class="search-card">)\s*(<DynamicSearchForm)/;
      const searchCardReplacement = `$1
          <template #header>
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
            </div>
          </template>
          $2`;
      
      content = content.replace(searchCardPattern, searchCardReplacement);
    }
  }
  
  // 3. 保存文件
  fs.writeFileSync(filePath, content, 'utf-8');
  console.log('  ✓ 完成');
}

console.log('\n全部处理完成！');
