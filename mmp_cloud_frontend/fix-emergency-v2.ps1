# Emergency目录最终修复脚本 - V2
$basePath = "d:\project\FreelancerProject\mmp_cloud\mmp_cloud_frontend\src\views\mmp\emergency"

# 定义文件名列表
$fileNames = @(
    'emergencyEventResponse',
    'emergencyEventTreatment',
    'emergencyMedicalSupport',
    'emergencyPlan',
    'emergencyPlanApproval',
    'emergencyTeamMember'
)

# 定义配置映射
$titleMap = @{
    'emergencyEventResponse' = '应急事件响应管理'
    'emergencyEventTreatment' = '应急事件处置管理'
    'emergencyMedicalSupport' = '应急医疗保障管理'
    'emergencyPlan' = '应急预案管理'
    'emergencyPlanApproval' = '应急预案审批管理'
    'emergencyTeamMember' = '应急队伍成员管理'
}

$iconMap = @{
    'emergencyEventResponse' = 'i-ep-warning'
    'emergencyEventTreatment' = 'i-ep-first-aid-kit'
    'emergencyMedicalSupport' = 'i-ep-medicine-box'
    'emergencyPlan' = 'i-ep-document-copy'
    'emergencyPlanApproval' = 'i-ep-document-checked'
    'emergencyTeamMember' = 'i-ep-avatar'
}

$descMap = @{
    'emergencyEventResponse' = '管理应急事件的响应措施和处理流程'
    'emergencyEventTreatment' = '管理应急事件的处置过程和结果记录'
    'emergencyMedicalSupport' = '管理应急医疗保障资源和支援措施'
    'emergencyPlan' = '管理应急预案的制定、审批和实施'
    'emergencyPlanApproval' = '管理应急预案的审批流程和记录'
    'emergencyTeamMember' = '管理应急队伍成员的信息和职责'
}

foreach ($fileName in $fileNames) {
    $filePath = Join-Path $basePath "$fileName\index.vue"
    
    if (-not (Test-Path $filePath)) {
        Write-Host "文件不存在: $filePath" -ForegroundColor Yellow
        continue
    }
    
    Write-Host "处理文件: $fileName" -ForegroundColor Cyan
    
    $title = $titleMap[$fileName]
    $icon = $iconMap[$fileName]
    $desc = $descMap[$fileName]
    
    $content = Get-Content $filePath -Raw -Encoding UTF8
    
    # 1. 检查并添加page-header（如果没有）
    if ($content -notmatch '<div class="page-header">') {
        Write-Host "  添加 page-header" -ForegroundColor Green
        
        # 找到 <div class="app-container"> 后的位置
        $pageHeader = @"
    <!-- 页面标题 -->
    <div class="page-header">
      <div class="header-content">
        <div class="header-icon">
          <el-icon size="24">
            <component :is="'$icon'" />
          </el-icon>
        </div>
        <div class="header-text">
          <h2 class="header-title">$title</h2>
          <p class="header-description">$desc</p>
        </div>
      </div>
    </div>

"@
        $content = $content -replace '(<div class="app-container">)', "`$1`n$pageHeader"
    }
    
    # 2. 修复搜索区域的header（添加搜索配置按钮）
    if ($content -match '<div class="search-card">[\s\S]*?<div class="card-header">') {
        if ($content -notmatch 'handleSearchConfig') {
            Write-Host "  添加搜索配置按钮" -ForegroundColor Green
            
            # 查找搜索区域的card-header，添加搜索配置按钮
            $searchHeaderPattern = '(<div class="search-card">[\s\S]*?<div class="card-header">[\s\S]*?<span>搜索条件</span>\s*</div>)'
            $searchHeaderReplacement = @'
<div class="search-card">
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
'@
            $content = $content -replace $searchHeaderPattern, $searchHeaderReplacement
        }
    }
    
    # 3. 修复table-header（从el-row格式改为div格式）
    if ($content -match '<el-row :gutter="10" class="mb8">') {
        Write-Host "  修复 table-header 结构" -ForegroundColor Green
        
        # 提取按钮内容（保留现有的按钮）
        if ($content -match '(?s)<el-row :gutter="10" class="mb8">(.*?)</el-row>') {
            $buttonsContent = $matches[1]
            
            # 移除el-col包装，但保留按钮
            $buttonsContent = $buttonsContent -replace '<el-col[^>]*>', ''
            $buttonsContent = $buttonsContent -replace '</el-col>', ''
            
            # 确保所有按钮都有plain和size="small"
            $buttonsContent = $buttonsContent -replace '<el-button(?![^>]*\bplain\b)', '<el-button plain'
            $buttonsContent = $buttonsContent -replace '<el-button(?![^>]*\bsize=)', '<el-button size="small"'
            
            $newTableHeader = @"
      <div class="table-header">
        <div class="header-title">
          <span>数据列表</span>
        </div>
        <div class="header-actions">
$buttonsContent
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
      </div>
"@
            
            # 替换整个el-row结构
            $oldPattern = '(?s)<el-row :gutter="10" class="mb8">.*?</el-row>'
            $content = $content -replace $oldPattern, $newTableHeader
        }
    }
    
    # 4. 确保所有独立按钮都有plain和size="small"
    $content = $content -replace '<el-button(?![^>]*\bplain\b)(?=[^>]*@click="(handleAdd|handleEdit|handleDelete|handleExport|handleImport|handleFieldConfig|handleSearchConfig)")', '<el-button plain'
    $content = $content -replace '<el-button(?![^>]*\bsize=)(?=[^>]*@click="(handleAdd|handleEdit|handleDelete|handleExport|handleImport|handleFieldConfig|handleSearchConfig)")', '<el-button size="small"'
    
    # 5. 保存文件
    Set-Content -Path $filePath -Value $content -Encoding UTF8 -NoNewline
    Write-Host "  ✓ 完成" -ForegroundColor Green
}

Write-Host "`n全部处理完成！" -ForegroundColor Green
