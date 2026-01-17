# Emergency目录完整重构脚本
# 处理：page-header、search-header、按钮样式、table-header

$files = @{
    "emergencyEventResponse" = @{
        "title" = "应急事件响应管理"
        "icon" = "i-ep-warning"
        "description" = "管理应急事件的响应措施和处理流程"
    }
    "emergencyEventTreatment" = @{
        "title" = "应急事件处置管理"
        "icon" = "i-ep-first-aid-kit"
        "description" = "管理应急事件的处置过程和结果记录"
    }
    "emergencyMedicalSupport" = @{
        "title" = "应急医疗保障管理"
        "icon" = "i-ep-medicine-box"
        "description" = "管理应急医疗保障资源和支援措施"
    }
    "emergencyPlan" = @{
        "title" = "应急预案管理"
        "icon" = "i-ep-document-copy"
        "description" = "管理应急预案的制定、审批和实施"
    }
    "emergencyPlanApproval" = @{
        "title" = "应急预案审批管理"
        "icon" = "i-ep-document-checked"
        "description" = "管理应急预案的审批流程和记录"
    }
    "emergencyTeamMember" = @{
        "title" = "应急队伍成员管理"
        "icon" = "i-ep-avatar"
        "description" = "管理应急队伍成员的信息和职责"
    }
}

foreach ($fileName in $files.Keys) {
    $filePath = "D:\project\FreelancerProject\mmp_cloud\mmp_cloud_frontend\src\views\emergency\$fileName\index.vue"
    
    if (!(Test-Path $filePath)) {
        Write-Host "文件不存在: $fileName" -ForegroundColor Yellow
        continue
    }
    
    Write-Host "`n处理: $fileName..." -ForegroundColor Cyan
    
    $content = Get-Content $filePath -Raw -Encoding UTF8
    $fileInfo = $files[$fileName]
    
    # 1. 添加page-header（如果不存在）
    if ($content -notmatch '<div class="page-header mb-4">') {
        Write-Host "  添加 page-header..." -ForegroundColor Yellow
        $pageHeader = @"
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <$($fileInfo.icon) class="title-icon"></$($fileInfo.icon)>
        $($fileInfo.title)
      </h2>
      <p class="page-description">$($fileInfo.description)</p>
    </div>

"@
        $content = $content -replace '(<template>\s*<div class="app-container">)', "`$1`n$pageHeader"
    }
    
    # 2. 添加搜索区域的header（如果缺少）
    if ($content -match '<el-card shadow="hover" class="search-card">\s*<DynamicSearchForm') {
        Write-Host "  添加 search-header..." -ForegroundColor Yellow
        $searchHeader = @'
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
'@
        $content = $content -replace '(<el-card shadow="hover" class="search-card">)\s*(<DynamicSearchForm)', "`$1`n$searchHeader`n          `$2"
    }
    
    # 3. 修复table-header结构（使用el-row的旧格式改为新格式）
    if ($content -match '<el-row :gutter="10" class="mb8">') {
        Write-Host "  修复 table-header..." -ForegroundColor Yellow
        
        # 提取权限前缀
        $permPrefix = ""
        if ($content -match "v-hasPermi=\[`"(\w+:\w+):") {
            $permPrefix = $matches[1]
        }
        
        $newHeader = @"
        <div class="table-header">
          <div class="table-title">
            <i-ep-list class="table-icon"></i-ep-list>
            <span>数据列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['${permPrefix}:add']" size="small">新增</el-button>
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['${permPrefix}:edit']"
              size="small"
            >修改</el-button>
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['${permPrefix}:remove']"
              size="small"
            >删除</el-button>
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['${permPrefix}:export']" size="small">导出</el-button>
            <el-button text type="primary" @click="handleFieldConfig" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
"@
        
        # 替换从<el-row到</el-row>的整个header部分
        $content = $content -replace '(?s)<el-row :gutter="10" class="mb8">.*?</el-row>', $newHeader
    }
    
    # 4. 修复按钮：添加plain和size（如果还没有）
    $content = $content -replace '(type="(?:primary|success|danger|warning)") icon="([^"]+)"(?! plain)(?! size)', '$1 plain icon="$2"'
    $content = $content -replace '(type="(?:primary|success|danger|warning)" plain icon="[^"]+")(?! size="small")', '$1 size="small"'
    
    # 5. 移除重复的"搜索项配置"按钮（保留字段配置就够了）
    $content = $content -replace '\s*<el-button text type="primary" @click="(?:searchConfigVisible = true|handleSearchConfig)" class="config-btn">\s*<i-ep-setting class="btn-icon"></i-ep-setting>\s*搜索项配置\s*</el-button>\s*(?=<right-toolbar)', "`n            "
    
    # 6. 修复el-button的@click事件，统一使用函数
    $content = $content -replace '@click="fieldConfigVisible = true"', '@click="handleFieldConfig"'
    $content = $content -replace '@click="searchConfigVisible = true"', '@click="handleSearchConfig"'
    
    Set-Content -Path $filePath -Value $content -Encoding UTF8 -NoNewline
    Write-Host "  ✓ 完成" -ForegroundColor Green
}

Write-Host "`n========================================" -ForegroundColor Cyan
Write-Host "所有文件处理完成！" -ForegroundColor Green
Write-Host "========================================`n" -ForegroundColor Cyan
