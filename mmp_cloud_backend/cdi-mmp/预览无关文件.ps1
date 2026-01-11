# CDI-MMP module irrelevant file preview script (safe mode - view only, no deletion)
# Description: This script only shows which files will be deleted, does not actually delete files

# Define module mapping: module directory name -> keywords to keep
$moduleMap = @{
    "cdi-mmp-coresystem" = @("CoreSystem", "Announcement")
    "cdi-mmp-doctor" = @("Doctor")
    "cdi-mmp-emergency" = @("Emergency")
    "cdi-mmp-ntp" = @("Ntp", "NewTechnology")
    "cdi-mmp-qc" = @("Qc", "QualityControl", "AdverseEvent")
    "cdi-mmp-qualification" = @("Qualification", "DepartmentQualification")
    "cdi-mmp-radiation" = @("Radiation")
    "cdi-mmp-supervision" = @("Supervision", "Inspection")
    "cdi-mmp-surgery" = @("Surgery", "MajorSurgery", "DeathCase", "Consultation")
    "cdi-mmp-tumorqc" = @("Tumor", "TumorQc", "Cancer")
}

$basePath = "c:\project\mmp-cloud\mmp_cloud_backend\cdi-mmp"

$totalToDelete = 0
$totalToKeep = 0
$deleteList = @()

Write-Host "========================================" -ForegroundColor Cyan
Write-Host "CDI-MMP Module Irrelevant File Preview Tool (Safe Mode)" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

foreach ($moduleName in $moduleMap.Keys) {
    $modulePath = Join-Path $basePath $moduleName
    $javaPath = Join-Path $modulePath "src\main\java"

    if (-not (Test-Path $javaPath)) {
        continue
    }

    Write-Host "Module: $moduleName" -ForegroundColor Green
    $keepKeywords = $moduleMap[$moduleName]

    $toDelete = 0
    $toKeep = 0

    Get-ChildItem -Path $javaPath -Recurse -File -Filter "*.java" | ForEach-Object {
        $file = $_
        $shouldKeep = $false

        foreach ($keyword in $keepKeywords) {
            if ($file.Name -match $keyword) {
                $shouldKeep = $true
                break
            }
        }

        # Keep common system files (ApplicationRunner and ImportListener)
        if ($file.Name -match "^(ApplicationRunner|ImportListener)") {
            $shouldKeep = $true
        }

        if ($shouldKeep) {
            $toKeep++
        } else {
            Write-Host "  [Will Delete] $($file.Name)" -ForegroundColor Red
            $deleteList += @{
                Module = $moduleName
                File = $file.Name
                Path = $file.FullName
            }
            $toDelete++
        }
    }

    Write-Host "  Subtotal: Keep $toKeep files, Will delete $toDelete files" -ForegroundColor Yellow
    Write-Host ""

    $totalToDelete += $toDelete
    $totalToKeep += $toKeep
}

Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Preview Complete!" -ForegroundColor Green
Write-Host "Total: Keep $totalToKeep files, Will delete $totalToDelete files" -ForegroundColor Yellow
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Ask if to execute deletion
$response = Read-Host "Do you want to execute the deletion operation? (Enter YES to confirm deletion, any other key to cancel)"

if ($response -eq "YES") {
    Write-Host ""
    Write-Host "Starting file deletion..." -ForegroundColor Yellow

    $deleted = 0
    foreach ($item in $deleteList) {
        if (Test-Path $item.Path) {
            Remove-Item $item.Path -Force
            $deleted++
            Write-Host "  Deleted: $($item.Module)/$($item.File)" -ForegroundColor Red
        }
    }

    Write-Host ""
    Write-Host "Deletion Complete! Total deleted $deleted files" -ForegroundColor Green
    Write-Host ""
    Write-Host "Suggested actions:" -ForegroundColor Cyan
    Write-Host "  cd c:\project\mmp-cloud\mmp_cloud_backend" -ForegroundColor Gray
    Write-Host "  mvn clean compile" -ForegroundColor Gray
} else {
    Write-Host ""
    Write-Host "Deletion operation cancelled" -ForegroundColor Yellow
}
