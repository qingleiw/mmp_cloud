import { FieldConfigManager, FieldGroup } from '../../fieldConfigManager';

// 放射检查记录字段配置
export function createRadiationExaminationRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'examinationNo', label: '检查编号', visible: true, required: true, group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, required: true, group: 'basic' },
        { prop: 'examinationDate', label: '检查日期', visible: true, required: true, width: '120', group: 'basic' }
      ]
    },
    {
      name: 'examination',
      label: '检查信息',
      fields: [
        { prop: 'examinationType', label: '检查类型', visible: true, required: true, group: 'examination' },
        { prop: 'examinationItem', label: '检查项目', visible: true, required: true, group: 'examination' },
        { prop: 'examinationMethod', label: '检查方法', visible: true, group: 'examination' },
        { prop: 'bodyPart', label: '检查部位', visible: true, group: 'examination' }
      ]
    },
    {
      name: 'technical',
      label: '技术参数',
      fields: [
        { prop: 'equipmentModel', label: '设备型号', visible: true, group: 'technical' },
        { prop: 'radiationDose', label: '辐射剂量', visible: true, group: 'technical' },
        { prop: 'exposureTime', label: '曝光时间', visible: true, group: 'technical' },
        { prop: 'imageQuality', label: '图像质量', visible: true, group: 'technical' }
      ]
    },
    {
      name: 'result',
      label: '结果信息',
      fields: [
        { prop: 'findings', label: '检查所见', visible: true, group: 'result' },
        { prop: 'impression', label: '印象诊断', visible: true, group: 'result' },
        { prop: 'conclusion', label: '结论', visible: true, group: 'result' },
        { prop: 'recommendations', label: '建议', visible: true, group: 'result' }
      ]
    },
    {
      name: 'personnel',
      label: '人员信息',
      fields: [
        { prop: 'technician', label: '技术员', visible: true, group: 'personnel' },
        { prop: 'physician', label: '医师', visible: true, group: 'personnel' },
        { prop: 'reviewer', label: '审核人', visible: true, group: 'personnel' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('radiationExaminationRecord', fieldGroups);
}

// 放射设备管理字段配置
export function createRadiationEquipmentManagementFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'equipmentCode', label: '设备编码', visible: true, required: true, group: 'basic' },
        { prop: 'equipmentName', label: '设备名称', visible: true, required: true, group: 'basic' },
        { prop: 'equipmentModel', label: '设备型号', visible: true, required: true, group: 'basic' },
        { prop: 'manufacturer', label: '制造商', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'specification',
      label: '规格参数',
      fields: [
        { prop: 'equipmentType', label: '设备类型', visible: true, group: 'specification' },
        { prop: 'maxVoltage', label: '最大电压', visible: true, group: 'specification' },
        { prop: 'maxCurrent', label: '最大电流', visible: true, group: 'specification' },
        { prop: 'focalSpotSize', label: '焦点尺寸', visible: true, group: 'specification' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'installationDate', label: '安装日期', visible: true, width: '120', group: 'status' },
        { prop: 'equipmentStatus', label: '设备状态', visible: true, group: 'status' },
        { prop: 'maintenanceStatus', label: '维护状态', visible: true, group: 'status' },
        { prop: 'lastMaintenanceDate', label: '最后维护日期', visible: true, width: '120', group: 'status' }
      ]
    },
    {
      name: 'location',
      label: '位置信息',
      fields: [
        { prop: 'department', label: '所在科室', visible: true, group: 'location' },
        { prop: 'roomNumber', label: '房间号', visible: true, group: 'location' },
        { prop: 'locationDescription', label: '位置描述', visible: true, group: 'location' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('radiationEquipmentManagement', fieldGroups);
}

// 放射剂量监控字段配置
export function createRadiationDoseMonitorFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'monitorNo', label: '监控编号', visible: true, required: true, group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, group: 'basic' },
        { prop: 'examinationId', label: '检查ID', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'dose',
      label: '剂量信息',
      fields: [
        { prop: 'doseValue', label: '剂量值', visible: true, group: 'dose' },
        { prop: 'doseUnit', label: '剂量单位', visible: true, group: 'dose' },
        { prop: 'doseType', label: '剂量类型', visible: true, group: 'dose' },
        { prop: 'referenceDose', label: '参考剂量', visible: true, group: 'dose' }
      ]
    },
    {
      name: 'assessment',
      label: '评估信息',
      fields: [
        { prop: 'doseLevel', label: '剂量水平', visible: true, group: 'assessment' },
        { prop: 'riskAssessment', label: '风险评估', visible: true, group: 'assessment' },
        { prop: 'justification', label: '正当性评估', visible: true, group: 'assessment' },
        { prop: 'optimization', label: '优化建议', visible: true, group: 'assessment' }
      ]
    },
    {
      name: 'cumulative',
      label: '累积信息',
      fields: [
        { prop: 'cumulativeDose', label: '累积剂量', visible: true, group: 'cumulative' },
        { prop: 'annualDose', label: '年度剂量', visible: true, group: 'cumulative' },
        { prop: 'lifetimeDose', label: '终身剂量', visible: true, group: 'cumulative' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('radiationDoseMonitor', fieldGroups);
}

// 放射质量控制字段配置
export function createRadiationQualityControlFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'controlNo', label: '质控编号', visible: true, required: true, group: 'basic' },
        { prop: 'controlDate', label: '质控日期', visible: true, required: true, width: '120', group: 'basic' },
        { prop: 'controlType', label: '质控类型', visible: true, required: true, group: 'basic' },
        { prop: 'equipmentId', label: '设备ID', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'parameters',
      label: '质控参数',
      fields: [
        { prop: 'testParameter', label: '测试参数', visible: true, group: 'parameters' },
        { prop: 'measuredValue', label: '测量值', visible: true, group: 'parameters' },
        { prop: 'referenceValue', label: '参考值', visible: true, group: 'parameters' },
        { prop: 'tolerance', label: '容差范围', visible: true, group: 'parameters' }
      ]
    },
    {
      name: 'result',
      label: '质控结果',
      fields: [
        { prop: 'controlResult', label: '质控结果', visible: true, group: 'result' },
        { prop: 'passFail', label: '合格/不合格', visible: true, group: 'result' },
        { prop: 'deviation', label: '偏差值', visible: true, group: 'result' },
        { prop: 'correctiveAction', label: '纠正措施', visible: true, group: 'result' }
      ]
    },
    {
      name: 'personnel',
      label: '人员信息',
      fields: [
        { prop: 'technician', label: '技术员', visible: true, group: 'personnel' },
        { prop: 'reviewer', label: '审核人', visible: true, group: 'personnel' },
        { prop: 'approver', label: '批准人', visible: true, group: 'personnel' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('radiationQualityControl', fieldGroups);
}

// 放射报告审核字段配置
export function createRadiationReportReviewFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'reportId', label: '报告ID', visible: true, group: 'basic' },
        { prop: 'reportNo', label: '报告编号', visible: true, required: true, group: 'basic' },
        { prop: 'examinationId', label: '检查ID', visible: true, group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'review',
      label: '审核信息',
      fields: [
        { prop: 'reviewLevel', label: '审核级别', visible: true, group: 'review' },
        { prop: 'reviewer', label: '审核人', visible: true, group: 'review' },
        { prop: 'reviewTime', label: '审核时间', visible: true, width: '180', group: 'review' },
        { prop: 'reviewStatus', label: '审核状态', visible: true, group: 'review' }
      ]
    },
    {
      name: 'content',
      label: '内容审核',
      fields: [
        { prop: 'findingsReview', label: '所见审核', visible: true, group: 'content' },
        { prop: 'impressionReview', label: '印象审核', visible: true, group: 'content' },
        { prop: 'conclusionReview', label: '结论审核', visible: true, group: 'content' },
        { prop: 'recommendationsReview', label: '建议审核', visible: true, group: 'content' }
      ]
    },
    {
      name: 'issues',
      label: '问题记录',
      fields: [
        { prop: 'issuesFound', label: '发现问题', visible: true, group: 'issues' },
        { prop: 'issueType', label: '问题类型', visible: true, group: 'issues' },
        { prop: 'issueDescription', label: '问题描述', visible: true, group: 'issues' },
        { prop: 'correctiveAction', label: '纠正措施', visible: true, group: 'issues' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('radiationReportReview', fieldGroups);
}

// 放射工作量统计字段配置
export function createRadiationWorkloadStatisticsFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'statisticsDate', label: '统计日期', visible: true, required: true, width: '120', group: 'basic' },
        { prop: 'departmentId', label: '科室ID', visible: true, group: 'basic' },
        { prop: 'departmentName', label: '科室名称', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'workload',
      label: '工作量统计',
      fields: [
        { prop: 'totalExaminations', label: '总检查数', visible: true, group: 'workload' },
        { prop: 'ctExaminations', label: 'CT检查数', visible: true, group: 'workload' },
        { prop: 'mriExaminations', label: 'MRI检查数', visible: true, group: 'workload' },
        { prop: 'xrayExaminations', label: 'X线检查数', visible: true, group: 'workload' },
        { prop: 'ultrasoundExaminations', label: '超声检查数', visible: true, group: 'workload' }
      ]
    },
    {
      name: 'efficiency',
      label: '效率指标',
      fields: [
        { prop: 'averageReportTime', label: '平均报告时间', visible: true, group: 'efficiency' },
        { prop: 'equipmentUtilization', label: '设备利用率', visible: true, group: 'efficiency' },
        { prop: 'technicianWorkload', label: '技术员工作量', visible: true, group: 'efficiency' },
        { prop: 'physicianWorkload', label: '医师工作量', visible: true, group: 'efficiency' }
      ]
    },
    {
      name: 'quality',
      label: '质量指标',
      fields: [
        { prop: 'reportAccuracy', label: '报告准确率', visible: true, group: 'quality' },
        { prop: 'imageQuality', label: '图像质量评分', visible: true, group: 'quality' },
        { prop: 'patientSatisfaction', label: '患者满意度', visible: true, group: 'quality' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('radiationWorkloadStatistics', fieldGroups);
}