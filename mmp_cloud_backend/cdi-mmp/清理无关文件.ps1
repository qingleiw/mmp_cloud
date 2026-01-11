# CDI-MMP module irrelevant file cleanup script
# Description: This script deletes irrelevant files in each module directory, keeping only module-related files

# Define module mapping: module directory name -> keywords to keep
$moduleMap = @{
    "cdi-mmp-coresystem" = @("CoreSystem", "Announcement")  # Core system module
    "cdi-mmp-doctor" = @("Doctor")  # Doctor management module
    "cdi-mmp-emergency" = @("Emergency")  # Emergency management module
    "cdi-mmp-ntp" = @("Ntp", "NewTechnology")  # New technology new project module
    "cdi-mmp-qc" = @("Qc", "QualityControl", "AdverseEvent")  # Quality control module
    "cdi-mmp-qualification" = @("Qualification", "DepartmentQualification")  # Qualification management module
    "cdi-mmp-radiation" = @("Radiation")  # Radiation management module
    "cdi-mmp-supervision" = @("Supervision", "Inspection")  # Supervision management module
    "cdi-mmp-surgery" = @("Surgery", "MajorSurgery", "DeathCase", "Consultation")  # Surgery management module
    "cdi-mmp-tumorqc" = @("Tumor", "TumorQc", "Cancer")  # Tumor quality control module
}

# Base path
$basePath = "c:\project\mmp-cloud\mmp_cloud_backend\cdi-mmp"

# Statistics
$totalDeleted = 0
$totalKept = 0

Write-Host "========================================" -ForegroundColor Cyan
Write-Host "CDI-MMP Module Irrelevant File Cleanup Tool" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Process each module
foreach ($moduleName in $moduleMap.Keys) {
    $modulePath = Join-Path $basePath $moduleName
    $javaPath = Join-Path $modulePath "src\main\java"
    $resourcesPath = Join-Path $modulePath "src\main\resources\mapper"

    if (-not (Test-Path $javaPath)) {
        Write-Host "Warning: Directory does not exist $javaPath" -ForegroundColor Yellow
        continue
    }

    Write-Host "Processing module: $moduleName" -ForegroundColor Green
    $keepKeywords = $moduleMap[$moduleName]
    Write-Host "  Keep keywords: $($keepKeywords -join ', ')" -ForegroundColor Gray

    $deleted = 0
    $kept = 0

    # Process Java files
    Get-ChildItem -Path $javaPath -Recurse -File -Filter "*.java" | ForEach-Object {
        $file = $_
        $shouldKeep = $false

        # Check if filename contains any keep keywords
        foreach ($keyword in $keepKeywords) {
            if ($file.Name -match $keyword) {
                $shouldKeep = $true
                break
            }
        }

        # Special handling: keep common system files (ApplicationRunner and ImportListener)
        if ($file.Name -match "^(ApplicationRunner|ImportListener)") {
            $shouldKeep = $true
        }

        if ($shouldKeep) {
            $kept++
        } else {
            Write-Host "    Deleting: $($file.Name)" -ForegroundColor Red
            Remove-Item $file.FullName -Force
            $deleted++
        }
    }

    # Process Mapper XML files
    if (Test-Path $resourcesPath) {
        Get-ChildItem -Path $resourcesPath -Recurse -File -Filter "*.xml" | ForEach-Object {
            $file = $_
            $shouldKeep = $false

            foreach ($keyword in $keepKeywords) {
                if ($file.Name -match $keyword) {
                    $shouldKeep = $true
                    break
                }
            }

            # Keep system-related XML files (ApplicationRunner and ImportListener related)
            if ($file.Name -match "^(ApplicationRunner|ImportListener)") {
                $shouldKeep = $true
            }

            if ($shouldKeep) {
                $kept++
            } else {
                Write-Host "    Deleting: mapper/$($file.Name)" -ForegroundColor Red
                Remove-Item $file.FullName -Force
                $deleted++
            }
        }
    }

    Write-Host "  Completed: Kept $kept files, deleted $deleted files" -ForegroundColor Yellow
    Write-Host ""

    $totalDeleted += $deleted
    $totalKept += $kept
}

Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Cleanup Complete!" -ForegroundColor Green
Write-Host "Total: Kept $totalKept files, deleted $totalDeleted files" -ForegroundColor Yellow
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Tips: Suggested actions after deletion:" -ForegroundColor Cyan
Write-Host "  1. Validate with Maven compile: mvn clean compile" -ForegroundColor Gray
Write-Host "  2. Check Git status: git status" -ForegroundColor Gray
Write-Host "  3. Rollback if needed: git checkout ." -ForegroundColor Gray
