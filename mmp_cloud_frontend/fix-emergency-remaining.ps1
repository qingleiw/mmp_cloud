# 批量修复emergency目录下剩余页面的脚本

$files = @(
    "emergencyDrillSummary",
    "emergencyEvent",
    "emergencyEventResponse", 
    "emergencyEventTreatment",
    "emergencyIncident",
    "emergencyMedicalSupport",
    "emergencyPlan",
    "emergencyPlanApproval",
    "emergencyTeamMember",
    "importantMedicalEvent"
)

foreach ($file in $files) {
    $filePath = "D:\project\FreelancerProject\mmp_cloud\mmp_cloud_frontend\src\views\emergency\$file\index.vue"
    
    if (!(Test-Path $filePath)) {
        Write-Host "文件不存在: $file" -ForegroundColor Yellow
        continue
    }
    
    Write-Host "处理: $file..." -ForegroundColor Cyan
    
    $content = Get-Content $filePath -Raw -Encoding UTF8
    
    # 1. 修复prop名称
    $content = $content -replace ':config-manager="fieldConfigManager"', ':fieldConfigManager="fieldConfigManager"'
    $content = $content -replace ':config-manager="searchConfigManager"', ':searchConfigManager="searchConfigManager"'
    
    # 2. 添加handleSearchConfig和handleFieldConfig函数（如果不存在）
    if ($content -notmatch 'const handleSearchConfig') {
        $insertPoint = $content.IndexOf('onMounted\(\)')
        if ($insertPoint -gt 0) {
            $functionsToAdd = @"

/** 搜索配置 */
const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

/** 字段配置 */
const handleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

"@
            $content = $content.Insert($insertPoint, $functionsToAdd)
        }
    }
    
    # 3. 添加样式（如果不存在）
    if ($content -notmatch '<style scoped') {
        $stylesToAdd = @'

<style scoped lang="scss">
.app-container {
  padding: 20px;

  .page-header {
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
  }

  .search-container {
    margin-bottom: 16px;

    .search-card {
      border-radius: 8px;
      overflow: hidden;

      .search-header {
        display: flex;
        align-items: center;
        justify-content: space-between;

        .search-title {
          display: flex;
          align-items: center;
          font-size: 14px;
          font-weight: 600;
          color: #303133;

          .search-icon {
            margin-right: 6px;
            font-size: 16px;
          }
        }

        .search-actions {
          .config-btn {
            padding: 4px 8px;

            .btn-icon {
              margin-right: 4px;
            }
          }
        }
      }

      :deep(.el-card__body) {
        padding: 16px;
      }
    }
  }

  .table-card {
    border-radius: 8px;

    .table-header {
      display: flex;
      align-items: center;
      justify-content: space-between;
      flex-wrap: wrap;
      gap: 12px;

      .table-title {
        display: flex;
        align-items: center;
        font-size: 16px;
        font-weight: 600;
        color: #303133;

        .table-icon {
          margin-right: 8px;
          font-size: 18px;
          color: #409eff;
        }
      }

      .table-actions {
        display: flex;
        align-items: center;
        gap: 8px;
        flex-wrap: wrap;

        .config-btn {
          padding: 8px 12px;

          .btn-icon {
            margin-right: 4px;
          }
        }
      }
    }

    :deep(.el-table) {
      margin-top: 16px;

      .el-table__header {
        th {
          background-color: #f5f7fa;
          color: #606266;
          font-weight: 600;
        }
      }
    }
  }
}
</style>
'@
        $content += $stylesToAdd
    }
    
    Set-Content -Path $filePath -Value $content -Encoding UTF8 -NoNewline
    Write-Host "  ✓ 完成" -ForegroundColor Green
}

Write-Host "`n所有文件处理完成！" -ForegroundColor Green
