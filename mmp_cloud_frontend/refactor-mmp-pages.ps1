# MMP 页面重构脚本 - 简化版
param(
    [Parameter(Mandatory=$false)]
    [string]$Directory = "",
    [Parameter(Mandatory=$false)]
    [switch]$DryRun = $false
)

$baseDir = "D:\project\FreelancerProject\mmp_cloud\mmp_cloud_frontend\src\views"

$directories = @("emergency", "ledger", "qc", "radiation", "supervision", "surgery", "tumorqc", "natdss")

if ($Directory) {
    $directories = @($Directory)
}

Write-Host "`n======================================== " -ForegroundColor Cyan
Write-Host "MMP 页面重构脚本" -ForegroundColor Cyan
Write-Host "========================================`n" -ForegroundColor Cyan

if ($DryRun) {
    Write-Host "[预览模式] 只显示将要修改的文件`n" -ForegroundColor Yellow
}

function Test-NeedsRefactor {
    param([string]$filePath)
    
    $content = Get-Content $filePath -Raw -Encoding UTF8
    
    if ($content -match 'class="app-container"') {
        return $false
    }
    
    if ($content -match 'class="p-2"') {
        return $true
    }
    
    return $false
}

function Refactor-VueFile {
    param([string]$filePath, [string]$pageName)
    
    Write-Host "  正在重构: $pageName..." -ForegroundColor Yellow
    
    $content = Get-Content $filePath -Raw -Encoding UTF8
    
    # 1. 替换根容器
    $content = $content -replace 'class="p-2"', 'class="app-container"'
    
    # 2. 更新搜索区域class
    $content = $content -replace 'class="mb-\[10px\]"', 'class="search-container mb-4"'
    $content = $content -replace '(<el-card shadow="hover">)', '<el-card shadow="hover" class="search-card">'
    
    # 3. 更新表格card
    $content = $content -replace '(<el-card shadow="never">)', '<el-card shadow="never" class="table-card">'
    
    # 4. 移除按钮的plain属性，添加size="small"
    $content = $content -replace 'type="primary" plain icon', 'type="primary" icon'
    $content = $content -replace 'type="success" plain icon', 'type="success" icon'
    $content = $content -replace 'type="danger" plain icon', 'type="danger" icon'
    $content = $content -replace 'type="warning" plain icon', 'type="warning" icon'
    
    # 5. 恢复按钮的plain属性和添加size="small" (正确的做法)
    $content = $content -replace '(type="(?:primary|success|danger|warning)") icon', '$1 plain icon'
    $content = $content -replace '(type="(?:primary|success|danger|warning)" plain icon="[^"]+")([^>]*?)>', '$1 size="small"$2>'
    $content = $content -replace '(type="(?:primary|success|danger|warning)" plain icon="[^"]+")([^>]*?size="small")([^>]*?)>', '$1$3>'
    $content = $content -replace '(type="(?:primary|success|danger|warning)" plain icon="[^"]+")([^>]*?)>', '$1 size="small"$2>'
    
    # 6. 更新配置按钮
    $content = $content -replace 'type="info" plain icon="Setting"', 'text type="primary"'
    
    # 7. 更新ref名称
    $content = $content -replace 'ref="searchFormRef"', 'ref="queryFormRef"'
    
    # 8. 更新配置管理器变量名和初始化
    # 移除 .clearConfig() 调用
    $content = $content -replace '(const fieldConfigManager = create[^\r\n]+)\r?\nfieldConfigManager\.clearConfig\(\);', '$1'
    
    # 不要添加 new 关键字，直接调用函数即可
    $content = $content -replace 'const fieldConfig = create', 'const fieldConfigManager = create'
    $content = $content -replace 'const searchConfig = create', 'const searchConfigManager = create'
    $content = $content -replace '([^a-zA-Z])fieldConfig\.', '$1fieldConfigManager.'
    $content = $content -replace '([^a-zA-Z])searchConfig\.', '$1searchConfigManager.'
    
    # 9. 更新props名称 - 使用驼峰命名
    $content = $content -replace ':config-manager="fieldConfigManager"', ':fieldConfigManager="fieldConfigManager"'
    $content = $content -replace ':config-manager="searchConfigManager"', ':searchConfigManager="searchConfigManager"'
    $content = $content -replace ':field-config="fieldConfig"', ':fieldConfigManager="fieldConfigManager"'
    $content = $content -replace ':search-config="searchConfig"', ':searchConfigManager="searchConfigManager"'
    $content = $content -replace ':query-params="queryParams"', ':query="queryParams"'
    
    # 10. 移除 DynamicForm 导入（如果存在）
    $content = $content -replace "import DynamicForm from '@/components/DynamicForm\.vue';\r?\n", ''
    
    if (!$DryRun) {
        Set-Content -Path $filePath -Value $content -Encoding UTF8 -NoNewline
        Write-Host "    ✓ 完成" -ForegroundColor Green
    } else {
        Write-Host "    [预览] 将修改此文件" -ForegroundColor Cyan
    }
}

$totalFiles = 0
$refactoredFiles = 0
$skippedFiles = 0

foreach ($dir in $directories) {
    $dirPath = Join-Path $baseDir $dir
    
    if (!(Test-Path $dirPath)) {
        Write-Host "跳过不存在的目录: $dir" -ForegroundColor Yellow
        continue
    }
    
    Write-Host "处理目录: $dir" -ForegroundColor Cyan
    Write-Host "----------------------------------------" -ForegroundColor Gray
    
    $vueFiles = Get-ChildItem -Path $dirPath -Recurse -Filter "index.vue"
    
    foreach ($file in $vueFiles) {
        $totalFiles++
        $pageName = $file.Directory.Name
        
        if (Test-NeedsRefactor -filePath $file.FullName) {
            Refactor-VueFile -filePath $file.FullName -pageName $pageName
            $refactoredFiles++
        } else {
            Write-Host "  跳过(已重构): $pageName" -ForegroundColor Gray
            $skippedFiles++
        }
    }
    
    Write-Host ""
}

Write-Host "======================================== " -ForegroundColor Cyan
Write-Host "重构完成!" -ForegroundColor Green
Write-Host "----------------------------------------" -ForegroundColor Gray
Write-Host "总文件数: $totalFiles" -ForegroundColor White
Write-Host "已重构: $refactoredFiles" -ForegroundColor Green
Write-Host "已跳过: $skippedFiles" -ForegroundColor Yellow
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

if ($DryRun) {
    Write-Host "这是预览模式，没有实际修改文件。" -ForegroundColor Yellow
    Write-Host "要执行实际修改，请运行: .\refactor-mmp-pages.ps1" -ForegroundColor Yellow
} else {
    Write-Host "重构已完成，建议检查修改的文件并测试功能。" -ForegroundColor Cyan
}
Write-Host ""

