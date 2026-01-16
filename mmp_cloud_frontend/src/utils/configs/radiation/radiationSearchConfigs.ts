import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// 放射检查记录搜索配置
export function createRadiationExaminationRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'examinationNo', label: '检查编号', type: 'input', placeholder: '请输入检查编号' },
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' }
      ]
    },
    {
      name: 'examination',
      label: '检查信息',
      fields: [
        { prop: 'examinationType', label: '检查类型', type: 'select', placeholder: '请选择检查类型' },
        { prop: 'examinationItem', label: '检查项目', type: 'input', placeholder: '请输入检查项目' },
        { prop: 'bodyPart', label: '检查部位', type: 'input', placeholder: '请输入检查部位' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'examinationDate', label: '检查日期', type: 'daterange', placeholder: '请选择检查日期范围' }
      ]
    },
    {
      name: 'personnel',
      label: '人员信息',
      fields: [
        { prop: 'technician', label: '技术员', type: 'input', placeholder: '请输入技术员' },
        { prop: 'physician', label: '医师', type: 'input', placeholder: '请输入医师' }
      ]
    }
  ];

  return new SearchConfigManager('radiationExaminationRecord', searchFieldGroups);
}

// 放射设备管理搜索配置
export function createRadiationEquipmentManagementSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'equipmentCode', label: '设备编码', type: 'input', placeholder: '请输入设备编码' },
        { prop: 'equipmentName', label: '设备名称', type: 'input', placeholder: '请输入设备名称' },
        { prop: 'equipmentModel', label: '设备型号', type: 'input', placeholder: '请输入设备型号' }
      ]
    },
    {
      name: 'specification',
      label: '规格参数',
      fields: [
        { prop: 'equipmentType', label: '设备类型', type: 'select', placeholder: '请选择设备类型' },
        { prop: 'manufacturer', label: '制造商', type: 'input', placeholder: '请输入制造商' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'equipmentStatus', label: '设备状态', type: 'select', placeholder: '请选择设备状态' },
        { prop: 'maintenanceStatus', label: '维护状态', type: 'select', placeholder: '请选择维护状态' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'installationDate', label: '安装日期', type: 'daterange', placeholder: '请选择安装日期范围' },
        { prop: 'lastMaintenanceDate', label: '最后维护日期', type: 'daterange', placeholder: '请选择维护日期范围' }
      ]
    }
  ];

  return new SearchConfigManager('radiationEquipmentManagement', searchFieldGroups);
}

// 放射剂量监控搜索配置
export function createRadiationDoseMonitorSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'monitorNo', label: '监控编号', type: 'input', placeholder: '请输入监控编号' },
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' }
      ]
    },
    {
      name: 'dose',
      label: '剂量信息',
      fields: [
        { prop: 'doseType', label: '剂量类型', type: 'select', placeholder: '请选择剂量类型' },
        { prop: 'doseLevel', label: '剂量水平', type: 'select', placeholder: '请选择剂量水平' }
      ]
    },
    {
      name: 'assessment',
      label: '评估信息',
      fields: [
        { prop: 'riskAssessment', label: '风险评估', type: 'select', placeholder: '请选择风险评估' }
      ]
    },
    {
      name: 'cumulative',
      label: '累积信息',
      fields: [
        { prop: 'cumulativeDose', label: '累积剂量', type: 'numberrange', placeholder: '请输入累积剂量范围' },
        { prop: 'annualDose', label: '年度剂量', type: 'numberrange', placeholder: '请输入年度剂量范围' }
      ]
    }
  ];

  return new SearchConfigManager('radiationDoseMonitor', searchFieldGroups);
}

// 放射质量控制搜索配置
export function createRadiationQualityControlSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'controlNo', label: '质控编号', type: 'input', placeholder: '请输入质控编号' },
        { prop: 'controlType', label: '质控类型', type: 'select', placeholder: '请选择质控类型' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'controlDate', label: '质控日期', type: 'daterange', placeholder: '请选择质控日期范围' }
      ]
    },
    {
      name: 'result',
      label: '质控结果',
      fields: [
        { prop: 'controlResult', label: '质控结果', type: 'select', placeholder: '请选择质控结果' },
        { prop: 'passFail', label: '合格/不合格', type: 'select', placeholder: '请选择合格状态' }
      ]
    },
    {
      name: 'personnel',
      label: '人员信息',
      fields: [
        { prop: 'technician', label: '技术员', type: 'input', placeholder: '请输入技术员' },
        { prop: 'reviewer', label: '审核人', type: 'input', placeholder: '请输入审核人' }
      ]
    }
  ];

  return new SearchConfigManager('radiationQualityControl', searchFieldGroups);
}

// 放射报告审核搜索配置
export function createRadiationReportReviewSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'reportNo', label: '报告编号', type: 'input', placeholder: '请输入报告编号' },
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' }
      ]
    },
    {
      name: 'review',
      label: '审核信息',
      fields: [
        { prop: 'reviewLevel', label: '审核级别', type: 'select', placeholder: '请选择审核级别' },
        { prop: 'reviewer', label: '审核人', type: 'input', placeholder: '请输入审核人' },
        { prop: 'reviewStatus', label: '审核状态', type: 'select', placeholder: '请选择审核状态' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'reviewTime', label: '审核时间', type: 'daterange', placeholder: '请选择审核时间范围' }
      ]
    },
    {
      name: 'issues',
      label: '问题记录',
      fields: [
        { prop: 'issuesFound', label: '发现问题', type: 'select', placeholder: '请选择是否发现问题' },
        { prop: 'issueType', label: '问题类型', type: 'select', placeholder: '请选择问题类型' }
      ]
    }
  ];

  return new SearchConfigManager('radiationReportReview', searchFieldGroups);
}

// 放射工作量统计搜索配置
export function createRadiationWorkloadStatisticsSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'departmentName', label: '科室名称', type: 'input', placeholder: '请输入科室名称' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'statisticsDate', label: '统计日期', type: 'daterange', placeholder: '请选择统计日期范围' }
      ]
    },
    {
      name: 'workload',
      label: '工作量统计',
      fields: [
        { prop: 'totalExaminations', label: '总检查数', type: 'numberrange', placeholder: '请输入总检查数范围' },
        { prop: 'ctExaminations', label: 'CT检查数', type: 'numberrange', placeholder: '请输入CT检查数范围' },
        { prop: 'mriExaminations', label: 'MRI检查数', type: 'numberrange', placeholder: '请输入MRI检查数范围' }
      ]
    },
    {
      name: 'efficiency',
      label: '效率指标',
      fields: [
        { prop: 'equipmentUtilization', label: '设备利用率', type: 'numberrange', placeholder: '请输入设备利用率范围' },
        { prop: 'averageReportTime', label: '平均报告时间', type: 'numberrange', placeholder: '请输入平均报告时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('radiationWorkloadStatistics', searchFieldGroups);
}