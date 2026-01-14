import { SearchConfigManager, type SearchFieldGroup } from './searchConfig';

export function createDoctorCertificateSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基本信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'certificateName', label: '证书名称', type: 'input', visible: true },
        { prop: 'certificateNo', label: '证书编号', type: 'input', visible: true }
      ]
    },
    {
      name: 'issue',
      label: '发证信息',
      fields: [
        { prop: 'issueUnit', label: '发证机构', type: 'input', visible: true },
        {
          prop: 'issueDate',
          label: '发证日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择发证日期' }
        },
        {
          prop: 'validDate',
          label: '有效期至',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择有效期至' }
        },
        { prop: 'isPermanent', label: '是否长期有效 1-是 0-否', type: 'input', visible: false }
      ]
    },
    {
      name: 'attachment',
      label: '附件',
      fields: [{ prop: 'certificateUrl', label: '证书附件URL', type: 'input', visible: false }]
    },
    {
      name: 'other',
      label: '其他',
      fields: [
        { prop: 'remindDays', label: '提前提醒天数', type: 'input', visible: false },
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];
  return new SearchConfigManager('doctorCertificate', fieldGroups);
}

export function createDoctorBasicInfoSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorCode', label: '医生工号', type: 'input', visible: true },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true },
        {
          prop: 'birthDate',
          label: '出生日期',
          type: 'date',
          visible: false,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择出生日期' }
        },
        { prop: 'gender', label: '性别', type: 'input', visible: false }
      ]
    },
    {
      name: 'contact',
      label: '联系',
      fields: [
        { prop: 'phone', label: '联系电话', type: 'input', visible: false },
        { prop: 'email', label: '电子邮箱', type: 'input', visible: false }
      ]
    },
    {
      name: 'work',
      label: '工作',
      fields: [
        { prop: 'departmentName', label: '科室名称', type: 'input', visible: true },
        { prop: 'title', label: '职称', type: 'input', visible: false },
        { prop: 'titleLevel', label: '职称级别', type: 'input', visible: false },
        {
          prop: 'entryDate',
          label: '入职日期',
          type: 'date',
          visible: false,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择入职日期' }
        }
      ]
    },
    {
      name: 'system',
      label: '系统',
      fields: [{ prop: 'delFlag', label: '删除标志', type: 'input', visible: false }]
    }
  ];
  return new SearchConfigManager('doctorBasicInfo', fieldGroups);
}

export function createDoctorEducationSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'schoolName', label: '学校名称', type: 'input', visible: true },
        { prop: 'major', label: '专业', type: 'input', visible: true }
      ]
    },
    {
      name: 'degree',
      label: '学历学位',
      fields: [
        { prop: 'educationLevel', label: '学历', type: 'input', visible: false },
        { prop: 'degree', label: '学位', type: 'input', visible: false }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        {
          prop: 'startDate',
          label: '开始日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择开始日期' }
        },
        {
          prop: 'endDate',
          label: '结束日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择结束日期' }
        }
      ]
    },
    {
      name: 'other',
      label: '其他',
      fields: [
        { prop: 'isFullTime', label: '是否全日制', type: 'input', visible: false },
        { prop: 'certificateNo', label: '证书编号', type: 'input', visible: false },
        { prop: 'certificateUrl', label: '证书附件URL', type: 'input', visible: false },
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];
  return new SearchConfigManager('doctorEducation', fieldGroups);
}

export function createDoctorHonorSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'honorName', label: '荣誉名称', type: 'input', visible: true },
        { prop: 'honorLevel', label: '荣誉级别', type: 'input', visible: true }
      ]
    },
    {
      name: 'award',
      label: '授予信息',
      fields: [
        { prop: 'awardUnit', label: '授予单位', type: 'input', visible: true },
        {
          prop: 'awardDate',
          label: '获得日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择获得日期' }
        }
      ]
    },
    {
      name: 'other',
      label: '其他',
      fields: [
        { prop: 'certificateNo', label: '证书编号', type: 'input', visible: false },
        { prop: 'certificateUrl', label: '证书附件URL', type: 'input', visible: false },
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];
  return new SearchConfigManager('doctorHonor', fieldGroups);
}

export function createDoctorAcademicPositionSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'organization', label: '学术组织', type: 'input', visible: true },
        { prop: 'position', label: '职务', type: 'input', visible: true },
        { prop: 'positionLevel', label: '职务级别', type: 'input', visible: false }
      ]
    },
    {
      name: 'time',
      label: '任职时间',
      fields: [
        {
          prop: 'startDate',
          label: '开始日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择开始日期' }
        },
        {
          prop: 'endDate',
          label: '结束日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择结束日期' }
        }
      ]
    },
    {
      name: 'other',
      label: '其他',
      fields: [
        { prop: 'isCurrent', label: '是否现任', type: 'input', visible: false },
        { prop: 'appointmentUrl', label: '任职证明URL', type: 'input', visible: false },
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];
  return new SearchConfigManager('doctorAcademicPosition', fieldGroups);
}

export function createDoctorEthicsEvaluationSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'evaluationYear', label: '考评年度', type: 'input', visible: true },
        { prop: 'evaluationCycle', label: '考评周期', type: 'input', visible: false }
      ]
    },
    {
      name: 'score',
      label: '评分',
      fields: [
        { prop: 'selfScore', label: '自评得分', type: 'input', visible: false },
        { prop: 'peerScore', label: '同行评议得分', type: 'input', visible: false },
        { prop: 'patientScore', label: '患者评价得分', type: 'input', visible: false },
        { prop: 'departmentScore', label: '科室评价得分', type: 'input', visible: false },
        { prop: 'hospitalScore', label: '医院评价得分', type: 'input', visible: false },
        { prop: 'totalScore', label: '总分', type: 'input', visible: false }
      ]
    },
    {
      name: 'result',
      label: '结果',
      fields: [
        { prop: 'evaluationResult', label: '考评结果', type: 'input', visible: true },
        { prop: 'rewardPunishment', label: '奖惩情况', type: 'input', visible: false }
      ]
    },
    {
      name: 'system',
      label: '系统',
      fields: [{ prop: 'delFlag', label: '删除标志', type: 'input', visible: false }]
    }
  ];
  return new SearchConfigManager('doctorEthicsEvaluation', fieldGroups);
}

// 医生能力评估搜索配置

export function createTodoTaskSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'taskNo', label: '任务编号', type: 'input', visible: true },
        { prop: 'taskTitle', label: '任务标题', type: 'input', visible: true },
        { prop: 'taskCategory', label: '任务分类', type: 'input', visible: true },
        { prop: 'priority', label: '优先级', type: 'input', visible: true }
      ]
    },
    {
      name: 'assign',
      label: '分配信息',
      fields: [
        { prop: 'assignFromUserName', label: '分配人姓名', type: 'input', visible: false },
        { prop: 'assignToUserName', label: '分配给用户', type: 'input', visible: false },
        { prop: 'assignToDepartmentName', label: '分配科室', type: 'input', visible: false },
        {
          prop: 'assignTime',
          label: '分配时间',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择分配时间' }
        }
      ]
    },
    {
      name: 'status',
      label: '状态进度',
      fields: [
        { prop: 'taskStatus', label: '任务状态', type: 'input', visible: true },
        { prop: 'processStatus', label: '处理进度状态', type: 'input', visible: false },
        {
          prop: 'deadline',
          label: '截止时间',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择截止时间' }
        },
        { prop: 'isOverdue', label: '是否逾期', type: 'input', visible: true }
      ]
    },
    {
      name: 'workflow',
      label: '流程',
      fields: [
        { prop: 'workflowInstanceId', label: '流程实例ID', type: 'input', visible: false },
        { prop: 'workflowNodeName', label: '节点名称', type: 'input', visible: false }
      ]
    },
    {
      name: 'system',
      label: '系统',
      fields: [{ prop: 'delFlag', label: '删除标志', type: 'input', visible: false }]
    }
  ];
  return new SearchConfigManager('todoTask', fieldGroups);
}

export function createQcIndicatorCollectionConfigSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'indicatorId', label: '指标ID', type: 'input', visible: true },
        { prop: 'sourceSystem', label: '来源系统', type: 'input', visible: true },
        { prop: 'sourceTable', label: '来源表', type: 'input', visible: true },
        { prop: 'sourceField', label: '来源字段', type: 'input', visible: true }
      ]
    },
    {
      name: 'rule',
      label: '规则',
      fields: [
        { prop: 'extractionRule', label: '提取规则', type: 'input', visible: false },
        { prop: 'validationRule', label: '校验规则', type: 'input', visible: false },
        { prop: 'dataType', label: '数据类型', type: 'input', visible: false },
        { prop: 'defaultValue', label: '默认值', type: 'input', visible: false }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [
        {
          prop: 'isRequired',
          label: '是否必需',
          type: 'select',
          visible: true,
          options: [
            { label: '是', value: 1 },
            { label: '否', value: 0 }
          ]
        },
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          options: [
            { label: '否', value: 0 },
            { label: '是', value: 1 }
          ]
        }
      ]
    }
  ];
  return new SearchConfigManager('qcIndicatorCollectionConfig', fieldGroups);
}

export function createSystemIndicatorMonitorRecordSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'time',
      label: '时间',
      fields: [
        { prop: 'recordDate', label: '记录日期', type: 'date', visible: true, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } },
        { prop: 'calculationCycle', label: '计算周期', type: 'input', visible: true }
      ]
    },
    {
      name: 'dept',
      label: '科室',
      fields: [
        { prop: 'departmentId', label: '科室ID', type: 'input', visible: false },
        { prop: 'departmentName', label: '科室名称', type: 'input', visible: true }
      ]
    },
    {
      name: 'system',
      label: '制度',
      fields: [
        { prop: 'systemId', label: '制度ID', type: 'input', visible: false },
        { prop: 'systemCode', label: '制度编码', type: 'input', visible: true },
        { prop: 'systemName', label: '制度名称', type: 'input', visible: true },
        { prop: 'systemScore', label: '制度得分', type: 'input', visible: false }
      ]
    },
    {
      name: 'indicator',
      label: '指标',
      fields: [
        { prop: 'indicatorId', label: '指标ID', type: 'input', visible: false },
        { prop: 'indicatorCode', label: '指标编码', type: 'input', visible: true },
        { prop: 'indicatorName', label: '指标名称', type: 'input', visible: true },
        { prop: 'indicatorValue', label: '指标值', type: 'input', visible: false },
        { prop: 'indicatorScore', label: '指标得分', type: 'input', visible: false },
        { prop: 'targetValue', label: '目标值', type: 'input', visible: false }
      ]
    },
    {
      name: 'performance',
      label: '表现',
      fields: [
        { prop: 'completionRate', label: '完成率(%)', type: 'input', visible: true },
        { prop: 'defectCount', label: '缺陷数', type: 'input', visible: false },
        { prop: 'rankInHospital', label: '院内排名', type: 'input', visible: false },
        {
          prop: 'trendDirection',
          label: '趋势方向',
          type: 'select',
          visible: true,
          options: [
            { label: '上升', value: 'up' },
            { label: '下降', value: 'down' },
            { label: '持平', value: 'flat' }
          ]
        },
        { prop: 'trendValue', label: '趋势值', type: 'input', visible: false },
        {
          prop: 'isAlert',
          label: '是否预警',
          type: 'select',
          visible: true,
          options: [
            { label: '否', value: 0 },
            { label: '是', value: 1 }
          ]
        }
      ]
    }
  ];
  return new SearchConfigManager('systemIndicatorMonitorRecord', fieldGroups);
}

export function createTumorQcIndicatorConfigSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'indicatorCode', label: '指标编码', type: 'input', visible: true },
        { prop: 'indicatorName', label: '指标名称', type: 'input', visible: true },
        { prop: 'indicatorCategory', label: '指标分类', type: 'input', visible: true }
      ]
    },
    {
      name: 'calc',
      label: '计算',
      fields: [
        { prop: 'calculationFormula', label: '计算公式', type: 'input', visible: false },
        { prop: 'dataSource', label: '数据来源', type: 'input', visible: false },
        { prop: 'collectionFrequency', label: '采集频率', type: 'input', visible: true },
        { prop: 'standardValue', label: '标准值', type: 'input', visible: false },
        { prop: 'targetValue', label: '目标值', type: 'input', visible: false },
        { prop: 'effectiveDate', label: '生效日期', type: 'date', visible: true, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } }
      ]
    },
    {
      name: 'policy',
      label: '政策',
      fields: [
        { prop: 'policyLevel', label: '政策级别', type: 'input', visible: false },
        { prop: 'policySource', label: '政策来源', type: 'input', visible: false },
        {
          prop: 'isEnabled',
          label: '是否启用',
          type: 'select',
          visible: true,
          options: [
            { label: '是', value: 1 },
            { label: '否', value: 0 }
          ]
        },
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          options: [
            { label: '否', value: 0 },
            { label: '是', value: 1 }
          ]
        }
      ]
    }
  ];
  return new SearchConfigManager('tumorQcIndicatorConfig', fieldGroups);
}

export function createTumorQcIndicatorDetailSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'recordId', label: '监测记录ID', type: 'input', visible: true },
        { prop: 'indicatorId', label: '指标ID', type: 'input', visible: true }
      ]
    },
    {
      name: 'patient',
      label: '患者',
      fields: [
        { prop: 'patientId', label: '患者ID', type: 'input', visible: false },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: true },
        { prop: 'visitNo', label: '就诊号', type: 'input', visible: true }
      ]
    },
    {
      name: 'result',
      label: '结果',
      fields: [
        { prop: 'diagnosis', label: '诊断', type: 'input', visible: false },
        { prop: 'indicatorResult', label: '指标结果', type: 'input', visible: true },
        { prop: 'resultDescription', label: '结果说明', type: 'input', visible: false },
        { prop: 'relatedData', label: '相关数据JSON', type: 'input', visible: false }
      ]
    }
  ];
  return new SearchConfigManager('tumorQcIndicatorDetail', fieldGroups);
}

export function createTumorQcInspectionSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'inspectionCode', label: '检查编码', type: 'input', visible: true },
        { prop: 'inspectionDate', label: '检查日期', type: 'date', visible: true, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } },
        { prop: 'inspectorName', label: '检查人姓名', type: 'input', visible: true },
        { prop: 'departmentName', label: '检查科室名称', type: 'input', visible: true },
        { prop: 'inspectionType', label: '检查类型', type: 'input', visible: false }
      ]
    },
    {
      name: 'result',
      label: '结果',
      fields: [
        { prop: 'inspectionResult', label: '检查结果', type: 'input', visible: true },
        { prop: 'problemDescription', label: '问题描述', type: 'input', visible: false },
        { prop: 'suggestion', label: '整改建议', type: 'input', visible: false },
        { prop: 'status', label: '状态', type: 'input', visible: false },
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          options: [
            { label: '否', value: 0 },
            { label: '是', value: 1 }
          ]
        }
      ]
    }
  ];
  return new SearchConfigManager('tumorQcInspection', fieldGroups);
}

export function createTumorQcIndicatorRecordSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'indicatorId', label: '指标ID', type: 'input', visible: true },
        { prop: 'recordDate', label: '记录日期', type: 'date', visible: true, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } }
      ]
    },
    {
      name: 'value',
      label: '数值',
      fields: [
        { prop: 'indicatorValue', label: '指标值', type: 'input', visible: false },
        { prop: 'indicatorScore', label: '指标得分', type: 'input', visible: false }
      ]
    }
  ];
  return new SearchConfigManager('tumorQcIndicatorRecord', fieldGroups);
}

export function createTumorQcPlanSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'planCode', label: '方案编码', type: 'input', visible: true },
        { prop: 'planName', label: '方案名称', type: 'input', visible: true }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        { prop: 'startDate', label: '开始日期', type: 'date', visible: true, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } },
        { prop: 'endDate', label: '结束日期', type: 'date', visible: true, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } }
      ]
    }
  ];
  return new SearchConfigManager('tumorQcPlan', fieldGroups);
}

export function createTumorQcRectificationSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'rectificationCode', label: '整改编码', type: 'input', visible: true },
        { prop: 'rectificationStatus', label: '整改状态', type: 'input', visible: true }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        { prop: 'rectificationDate', label: '整改日期', type: 'date', visible: true, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } }
      ]
    }
  ];
  return new SearchConfigManager('tumorQcRectification', fieldGroups);
}

export function createTumorQcReportSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'reportCode', label: '报告编码', type: 'input', visible: true },
        { prop: 'reportName', label: '报告名称', type: 'input', visible: true }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [{ prop: 'reportDate', label: '报告日期', type: 'date', visible: true, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } }]
    }
  ];
  return new SearchConfigManager('tumorQcReport', fieldGroups);
}

export function createTumorQcResultSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'resultCode', label: '结果编码', type: 'input', visible: true },
        { prop: 'indicatorId', label: '指标ID', type: 'input', visible: true }
      ]
    },
    {
      name: 'value',
      label: '数值',
      fields: [
        { prop: 'resultValue', label: '结果值', type: 'input', visible: true },
        {
          prop: 'isQualified',
          label: '是否达标',
          type: 'select',
          visible: true,
          options: [
            { label: '否', value: 0 },
            { label: '是', value: 1 }
          ]
        }
      ]
    }
  ];
  return new SearchConfigManager('tumorQcResult', fieldGroups);
}

export function createDoctorElectronicRegistrationSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'registrationNo', label: '注册编号', type: 'input', visible: true },
        { prop: 'practiceCategory', label: '执业类别', type: 'input', visible: true },
        { prop: 'practiceLocation', label: '执业地点', type: 'input', visible: false }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        {
          prop: 'issueDate',
          label: '发证日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择发证日期' }
        },
        {
          prop: 'validDate',
          label: '有效期至',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择有效期至' }
        }
      ]
    },
    {
      name: 'other',
      label: '其他',
      fields: [
        { prop: 'registrationAuthority', label: '注册机关', type: 'input', visible: true },
        { prop: 'multiInstitutionFlag', label: '多机构备案', type: 'input', visible: false },
        { prop: 'certificateUrl', label: '证书附件URL', type: 'input', visible: false },
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];
  return new SearchConfigManager('doctorElectronicRegistration', fieldGroups);
}

export function createDoctorInsuranceCodeSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'insuranceCode', label: '医保医师码', type: 'input', visible: true }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        {
          prop: 'validDate',
          label: '有效期至',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择有效期至' }
        },
        {
          prop: 'applyDate',
          label: '申请日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择申请日期' }
        },
        {
          prop: 'approveDate',
          label: '审批日期',
          type: 'date',
          visible: false,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择审批日期' }
        }
      ]
    },
    {
      name: 'system',
      label: '系统',
      fields: [{ prop: 'delFlag', label: '删除标志', type: 'input', visible: false }]
    }
  ];
  return new SearchConfigManager('doctorInsuranceCode', fieldGroups);
}

export function createDoctorAdverseRecordSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'recordTitle', label: '记录标题', type: 'input', visible: true },
        {
          prop: 'occurDate',
          label: '发生日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择发生日期' }
        }
      ]
    },
    {
      name: 'detail',
      label: '详情',
      fields: [
        { prop: 'description', label: '事件描述', type: 'input', visible: false },
        { prop: 'consequence', label: '后果', type: 'input', visible: false },
        { prop: 'handlingMeasure', label: '处理措施', type: 'input', visible: false },
        { prop: 'punishment', label: '处罚情况', type: 'input', visible: false }
      ]
    },
    {
      name: 'system',
      label: '系统',
      fields: [{ prop: 'delFlag', label: '删除标志', type: 'input', visible: false }]
    }
  ];
  return new SearchConfigManager('doctorAdverseRecord', fieldGroups);
}

export function createDoctorPublicationSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'title', label: '标题', type: 'input', visible: true },
        { prop: 'authors', label: '作者', type: 'input', visible: true },
        { prop: 'journalName', label: '期刊/出版社', type: 'input', visible: true }
      ]
    },
    {
      name: 'pub',
      label: '发表信息',
      fields: [
        {
          prop: 'publishDate',
          label: '发表日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择发表日期' }
        },
        { prop: 'volume', label: '卷号', type: 'input', visible: false },
        { prop: 'issue', label: '期号', type: 'input', visible: false }
      ]
    },
    {
      name: 'extra',
      label: '其他',
      fields: [
        { prop: 'doi', label: 'DOI', type: 'input', visible: false },
        { prop: 'impactFactor', label: '影响因子', type: 'input', visible: false },
        { prop: 'citationCount', label: '引用次数', type: 'input', visible: false },
        { prop: 'fullTextUrl', label: '全文URL', type: 'input', visible: false },
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];
  return new SearchConfigManager('doctorPublication', fieldGroups);
}

export function createDoctorResearchProjectSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'projectName', label: '项目名称', type: 'input', visible: true },
        { prop: 'projectNo', label: '项目编号', type: 'input', visible: true },
        { prop: 'projectLevel', label: '项目级别', type: 'input', visible: true },
        { prop: 'role', label: '角色', type: 'input', visible: true }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        {
          prop: 'startDate',
          label: '开始日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择开始日期' }
        },
        {
          prop: 'endDate',
          label: '结束日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择结束日期' }
        }
      ]
    },
    {
      name: 'other',
      label: '其他',
      fields: [
        { prop: 'fundingAmount', label: '资助金额', type: 'input', visible: false },
        { prop: 'status', label: '状态', type: 'input', visible: false },
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];
  return new SearchConfigManager('doctorResearchProject', fieldGroups);
}

export function createSurgeryComplicationRecordSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'doctorName', label: '医师姓名', type: 'input', visible: true },
        { prop: 'surgeryCode', label: '手术编码', type: 'input', visible: true },
        { prop: 'surgeryName', label: '手术名称', type: 'input', visible: true }
      ]
    },
    {
      name: 'complication',
      label: '并发症',
      fields: [
        { prop: 'complicationType', label: '并发症类型', type: 'input', visible: false },
        { prop: 'complicationDescription', label: '并发症描述', type: 'input', visible: true },
        {
          prop: 'complicationLevel',
          label: '并发症等级',
          type: 'select',
          visible: true,
          options: [
            { label: '轻微', value: '轻微' },
            { label: '中等', value: '中等' },
            { label: '严重', value: '严重' },
            { label: '致命', value: '致命' }
          ]
        }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        { prop: 'occurrenceTime', label: '发生时间', type: 'date', visible: true, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [
        {
          prop: 'isPlannedSecondary',
          label: '是否非计划二次手术',
          type: 'select',
          visible: true,
          options: [
            { label: '是', value: '1' },
            { label: '否', value: '0' }
          ]
        },
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          options: [
            { label: '正常', value: '0' },
            { label: '已删除', value: '1' }
          ]
        }
      ]
    }
  ];
  return new SearchConfigManager('surgeryComplicationRecord', fieldGroups);
}

export function createSurgeryWorkloadStatisticsSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'doctorName', label: '医师姓名', type: 'input', visible: true },
        { prop: 'surgeryCode', label: '手术编码', type: 'input', visible: true },
        { prop: 'surgeryName', label: '手术名称', type: 'input', visible: true },
        { prop: 'surgeryLevel', label: '手术级别', type: 'input', visible: true }
      ]
    },
    {
      name: 'count',
      label: '工作量',
      fields: [
        { prop: 'surgeryCount', label: '手术数量', type: 'input', visible: true },
        { prop: 'mainOperatorCount', label: '主刀次数', type: 'input', visible: true },
        { prop: 'firstAssistantCount', label: '一助次数', type: 'input', visible: true }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        { prop: 'statisticsYear', label: '统计年份', type: 'input', visible: true },
        { prop: 'statisticsMonth', label: '统计月份', type: 'input', visible: true }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          options: [
            { label: '存在', value: '0' },
            { label: '删除', value: '1' }
          ]
        }
      ]
    }
  ];
  return new SearchConfigManager('surgeryWorkloadStatistics', fieldGroups);
}

export function createSurgeryVideoSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'videoNo', label: '视频编号', type: 'input', visible: true },
        { prop: 'videoTitle', label: '视频标题', type: 'input', visible: true },
        { prop: 'videoFormat', label: '视频格式', type: 'input', visible: false },
        { prop: 'recordingDevice', label: '录制设备', type: 'input', visible: false }
      ]
    },
    {
      name: 'personnel',
      label: '人员与时间',
      fields: [
        { prop: 'recordingDoctorName', label: '录制医生姓名', type: 'input', visible: true },
        { prop: 'uploadTime', label: '上传时间', type: 'date', visible: true, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } },
        { prop: 'reviewTime', label: '审核时间', type: 'date', visible: false, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [
        {
          prop: 'reviewStatus',
          label: '审核状态',
          type: 'select',
          visible: true,
          options: [
            { label: '待审核', value: 'pending' },
            { label: '已通过', value: 'approved' },
            { label: '已拒绝', value: 'rejected' }
          ]
        },
        {
          prop: 'accessLevel',
          label: '访问级别',
          type: 'select',
          visible: true,
          options: [
            { label: '院内', value: 'internal' },
            { label: '公开', value: 'public' },
            { label: '受限', value: 'restricted' }
          ]
        },
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          options: [
            { label: '正常', value: '0' },
            { label: '已删除', value: '1' }
          ]
        }
      ]
    }
  ];
  return new SearchConfigManager('surgeryVideo', fieldGroups);
}

export function createQualificationPermissionAdjustmentSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'doctorName', label: '医师姓名', type: 'input', visible: true },
        { prop: 'originalLevel', label: '原权限级别', type: 'input', visible: true },
        { prop: 'newLevel', label: '新权限级别', type: 'input', visible: true },
        { prop: 'adjustmentReason', label: '调整原因', type: 'input', visible: false },
        { prop: 'adjustmentBasis', label: '调整依据', type: 'input', visible: false }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        { prop: 'adjustmentTime', label: '调整时间', type: 'date', visible: true, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [
        { prop: 'operatorName', label: '操作人姓名', type: 'input', visible: false },
        { prop: 'isAutoAdjustment', label: '是否自动调整', type: 'input', visible: false },
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];
  return new SearchConfigManager('qualificationPermissionAdjustment', fieldGroups);
}

export function createNewTechnologyImplementationSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'projectNo', label: '项目编号', type: 'input', visible: true },
        {
          prop: 'implementationStatus',
          label: '实施状态',
          type: 'select',
          visible: true,
          options: [
            { label: '未开始', value: 0 },
            { label: '进行中', value: 1 },
            { label: '已完成', value: 2 },
            { label: '暂停', value: 3 }
          ]
        },
        { prop: 'implementDoctor', label: '实施医生', type: 'input', visible: true }
      ]
    }
  ];
  return new SearchConfigManager('newTechnologyImplementation', fieldGroups);
}
export function createMajorSurgeryApplicationSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'applicationNo', label: '申请编号', type: 'input', visible: true },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: true },
        { prop: 'doctorName', label: '申请医师姓名', type: 'input', visible: true },
        { prop: 'departmentName', label: '申请科室名称', type: 'input', visible: true }
      ]
    },
    {
      name: 'surgery',
      label: '手术',
      fields: [
        { prop: 'surgeryName', label: '拟手术名称', type: 'input', visible: true },
        { prop: 'expectedTime', label: '预计手术时间', type: 'date', visible: true, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } },
        { prop: 'applicationStatus', label: '申请状态', type: 'input', visible: true }
      ]
    },
    {
      name: 'approval',
      label: '审批',
      fields: [
        { prop: 'approverName', label: '审批人姓名', type: 'input', visible: false },
        { prop: 'approvalTime', label: '审批时间', type: 'date', visible: false, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } }
      ]
    }
  ];
  return new SearchConfigManager('majorSurgeryApplication', fieldGroups);
}

export function createDoctorQualificationCatalogSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'catalogCode', label: '资质编码', type: 'input', visible: true },
        { prop: 'catalogName', label: '资质名称', type: 'input', visible: true },
        { prop: 'parentId', label: '父级ID', type: 'input', visible: false },
        { prop: 'catalogLevel', label: '目录层级', type: 'input', visible: true }
      ]
    },
    {
      name: 'other',
      label: '其他',
      fields: [
        { prop: 'description', label: '资质描述', type: 'input', visible: false },
        { prop: 'sortOrder', label: '排序', type: 'input', visible: false },
        { prop: 'isEnabled', label: '是否启用', type: 'input', visible: false },
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];
  return new SearchConfigManager('doctorQualificationCatalog', fieldGroups);
}

export function createDepartmentQualificationCatalogSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'departmentId', label: '科室ID', type: 'input', visible: true },
        { prop: 'qualificationId', label: '资质ID', type: 'input', visible: true },
        { prop: 'isEnabled', label: '是否启用', type: 'input', visible: false }
      ]
    },
    {
      name: 'approve',
      label: '审批',
      fields: [
        {
          prop: 'approveTime',
          label: '审批时间',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择审批时间' }
        },
        { prop: 'approveBy', label: '审批人', type: 'input', visible: true }
      ]
    },
    {
      name: 'system',
      label: '系统',
      fields: [{ prop: 'delFlag', label: '删除标志', type: 'input', visible: false }]
    }
  ];
  return new SearchConfigManager('departmentQualificationCatalog', fieldGroups);
}

export function createTechnicianQualificationCatalogSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'catalogCode', label: '资质编码', type: 'input', visible: true },
        { prop: 'catalogName', label: '资质名称', type: 'input', visible: true },
        { prop: 'parentId', label: '父级ID', type: 'input', visible: false },
        { prop: 'catalogLevel', label: '目录层级', type: 'input', visible: true }
      ]
    },
    {
      name: 'other',
      label: '其他',
      fields: [
        { prop: 'description', label: '资质描述', type: 'input', visible: false },
        { prop: 'sortOrder', label: '排序', type: 'input', visible: false },
        { prop: 'isEnabled', label: '是否启用', type: 'input', visible: false },
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];
  return new SearchConfigManager('technicianQualificationCatalog', fieldGroups);
}

export function createQualificationAuthorizationRecordSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'authorizationNo', label: '授权编号', type: 'input', visible: true },
        { prop: 'staffId', label: '人员ID', type: 'input', visible: true },
        { prop: 'staffName', label: '人员姓名', type: 'input', visible: true },
        { prop: 'qualificationId', label: '资质ID', type: 'input', visible: false },
        { prop: 'qualificationCode', label: '资质编码', type: 'input', visible: false },
        { prop: 'qualificationName', label: '资质名称', type: 'input', visible: true },
        { prop: 'authorizationLevel', label: '授权级别', type: 'input', visible: false }
      ]
    },
    {
      name: 'valid',
      label: '有效期',
      fields: [
        {
          prop: 'validStartDate',
          label: '有效期开始',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择开始日期' }
        },
        {
          prop: 'validEndDate',
          label: '有效期结束',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择结束日期' }
        }
      ]
    },
    {
      name: 'extra',
      label: '其他',
      fields: [
        { prop: 'applyId', label: '关联申请ID', type: 'input', visible: false },
        { prop: 'specialCondition', label: '特殊限制条件', type: 'input', visible: false },
        { prop: 'patientId', label: '限定患者ID', type: 'input', visible: false },
        { prop: 'authorizationReason', label: '授权理由', type: 'input', visible: false },
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];
  return new SearchConfigManager('qualificationAuthorizationRecord', fieldGroups);
}

export function createQualificationAuthorizationApplySearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'applicant',
      label: '申请人',
      fields: [
        { prop: 'applyNo', label: '申请单号', type: 'input', visible: true },
        { prop: 'applicantId', label: '申请人ID', type: 'input', visible: true },
        { prop: 'applicantName', label: '申请人姓名', type: 'input', visible: true },
        { prop: 'departmentId', label: '科室ID', type: 'input', visible: false },
        { prop: 'departmentName', label: '科室名称', type: 'input', visible: false }
      ]
    },
    {
      name: 'qualification',
      label: '资质',
      fields: [
        { prop: 'qualificationIds', label: '资质ID列表', type: 'input', visible: true },
        { prop: 'applyReason', label: '申请理由', type: 'input', visible: false },
        { prop: 'certificateIds', label: '证书ID', type: 'input', visible: false }
      ]
    },
    {
      name: 'assessment',
      label: '考核与工作',
      fields: [
        { prop: 'examScore', label: '考核成绩', type: 'input', visible: false },
        { prop: 'workQuantity', label: '工作量JSON', type: 'input', visible: false },
        { prop: 'workQuality', label: '工作质量JSON', type: 'input', visible: false }
      ]
    },
    {
      name: 'workflow',
      label: '流程',
      fields: [
        { prop: 'applyStatus', label: '申请状态', type: 'input', visible: true },
        { prop: 'currentNode', label: '当前节点', type: 'input', visible: true },
        { prop: 'workflowInstanceId', label: '流程实例ID', type: 'input', visible: false }
      ]
    },
    {
      name: 'system',
      label: '系统',
      fields: [{ prop: 'delFlag', label: '删除标志', type: 'input', visible: false }]
    }
  ];
  return new SearchConfigManager('qualificationAuthorizationApply', fieldGroups);
}

export function createQualificationAdmissionConditionSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'qualificationId', label: '资质ID', type: 'input', visible: true },
        { prop: 'qualificationType', label: '资质类型', type: 'input', visible: false },
        { prop: 'conditionType', label: '条件类型', type: 'input', visible: false }
      ]
    },
    {
      name: 'condition',
      label: '条件',
      fields: [
        { prop: 'conditionOperator', label: '运算符', type: 'input', visible: true },
        { prop: 'conditionValue', label: '条件值', type: 'input', visible: true },
        { prop: 'conditionUnit', label: '条件单位', type: 'input', visible: false },
        { prop: 'isRequired', label: '是否必须', type: 'input', visible: false },
        { prop: 'logicRelation', label: '逻辑关系', type: 'input', visible: false }
      ]
    },
    {
      name: 'other',
      label: '其他',
      fields: [
        { prop: 'sortOrder', label: '排序', type: 'input', visible: false },
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];
  return new SearchConfigManager('qualificationAdmissionCondition', fieldGroups);
}

export function createDoctorAbilityAssessmentSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'assessmentYear', label: '评估年度', type: 'input', visible: true },
        { prop: 'assessmentType', label: '评估类型', type: 'input', visible: false }
      ]
    },
    {
      name: 'score',
      label: '评分',
      fields: [
        { prop: 'clinicalAbilityScore', label: '临床能力得分', type: 'input', visible: false },
        { prop: 'teachingAbilityScore', label: '教学能力得分', type: 'input', visible: false },
        { prop: 'researchAbilityScore', label: '科研能力得分', type: 'input', visible: false },
        { prop: 'managementAbilityScore', label: '管理能力得分', type: 'input', visible: false },
        { prop: 'totalScore', label: '总分', type: 'input', visible: false }
      ]
    },
    {
      name: 'result',
      label: '结果',
      fields: [
        { prop: 'assessmentResult', label: '评估结果', type: 'input', visible: true },
        { prop: 'assessor', label: '评估人', type: 'input', visible: false },
        {
          prop: 'assessmentDate',
          label: '评估日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择评估日期' }
        }
      ]
    },
    {
      name: 'system',
      label: '系统',
      fields: [{ prop: 'delFlag', label: '删除标志', type: 'input', visible: false }]
    }
  ];
  return new SearchConfigManager('doctorAbilityAssessment', fieldGroups);
}

export function createDoctorWorkExperienceSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'organization', label: '工作单位', type: 'input', visible: true },
        { prop: 'department', label: '部门', type: 'input', visible: false },
        { prop: 'position', label: '职位', type: 'input', visible: true }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        {
          prop: 'startDate',
          label: '开始日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择开始日期' }
        },
        {
          prop: 'endDate',
          label: '结束日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择结束日期' }
        }
      ]
    },
    {
      name: 'other',
      label: '其他',
      fields: [
        { prop: 'jobDescription', label: '工作描述', type: 'input', visible: false },
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];
  return new SearchConfigManager('doctorWorkExperience', fieldGroups);
}

export function createDoctorTrainingSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'trainingName', label: '培训名称', type: 'input', visible: true },
        { prop: 'trainingUnit', label: '培训单位', type: 'input', visible: true }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        {
          prop: 'startDate',
          label: '开始日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择开始日期' }
        },
        {
          prop: 'endDate',
          label: '结束日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择结束日期' }
        }
      ]
    },
    {
      name: 'result',
      label: '结果',
      fields: [
        { prop: 'trainingHours', label: '培训学时', type: 'input', visible: false },
        { prop: 'trainingResult', label: '培训结果', type: 'input', visible: true },
        { prop: 'certificateNo', label: '证书编号', type: 'input', visible: false },
        { prop: 'certificateUrl', label: '证书附件URL', type: 'input', visible: false },
        { prop: 'credits', label: '学分', type: 'input', visible: false }
      ]
    },
    {
      name: 'system',
      label: '系统',
      fields: [{ prop: 'delFlag', label: '删除标志', type: 'input', visible: false }]
    }
  ];
  return new SearchConfigManager('doctorTraining', fieldGroups);
}

// 核心制度指标搜索配置
export function createCoreSystemIndicatorSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'indicatorCode', label: '指标编码', type: 'input', visible: true },
        { prop: 'indicatorName', label: '指标名称', type: 'input', visible: true },
        { prop: 'systemId', label: '所属制度ID', type: 'input', visible: false },
        { prop: 'parentId', label: '父指标ID', type: 'input', visible: false }
      ]
    },
    {
      name: 'calculation',
      label: '计算信息',
      fields: [
        { prop: 'indicatorType', label: '指标类型', type: 'input', visible: true },
        { prop: 'calculationFormula', label: '计算公式', type: 'input', visible: true },
        {
          prop: 'calculationCycle',
          label: '计算周期',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择计算周期',
            options: [
              { label: '日', value: '日' },
              { label: '周', value: '周' },
              { label: '月', value: '月' },
              { label: '季度', value: '季度' },
              { label: '年', value: '年' }
            ]
          }
        },
        { prop: 'dataSource', label: '数据来源', type: 'input', visible: true }
      ]
    },
    {
      name: 'target',
      label: '目标信息',
      fields: [
        { prop: 'targetValue', label: '目标值', type: 'number', visible: true },
        { prop: 'indicatorScore', label: '指标分值', type: 'number', visible: true },
        {
          prop: 'isReverse',
          label: '是否反向指标',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择是否反向指标',
            options: [
              { label: '是', value: '1' },
              { label: '否', value: '0' }
            ]
          }
        },
        { prop: 'alertThreshold', label: '预警阈值', type: 'number', visible: true }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        {
          prop: 'isEnabled',
          label: '是否启用',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择是否启用',
            options: [
              { label: '是', value: '1' },
              { label: '否', value: '0' }
            ]
          }
        },
        {
          prop: 'isCustom',
          label: '是否自定义',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择是否自定义',
            options: [
              { label: '是', value: '1' },
              { label: '否', value: '0' }
            ]
          }
        },
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          componentProps: {
            placeholder: '请选择删除标志',
            options: [
              { label: '正常', value: '0' },
              { label: '已删除', value: '1' }
            ]
          }
        }
      ]
    }
  ];
  return new SearchConfigManager('coreSystemIndicator', fieldGroups);
}

// 重要医疗事件搜索配置
export function createImportantMedicalEventSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'eventNo', label: '事件编号', type: 'input', visible: true },
        {
          prop: 'eventType',
          label: '事件类型',
          type: 'select',
          visible: true,
          componentProps: { placeholder: '请选择事件类型' },
          options: [
            { label: '死亡', value: 'death' },
            { label: '非计划手术', value: 'unplanned_surgery' },
            { label: '重大手术', value: 'major_surgery' },
            { label: '危急值', value: 'critical_value' }
          ]
        },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: true },
        { prop: 'visitNo', label: '就诊号', type: 'input', visible: true }
      ]
    },
    {
      name: 'medical',
      label: '医疗信息',
      fields: [
        { prop: 'departmentName', label: '科室名称', type: 'input', visible: true },
        { prop: 'responsibleDoctor', label: '责任医生', type: 'input', visible: true },
        {
          prop: 'eventTime',
          label: '事件时间',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择事件时间' }
        },
        { prop: 'eventDescription', label: '事件描述', type: 'input', visible: true },
        { prop: 'eventLevel', label: '事件级别', type: 'input', visible: true }
      ]
    },
    {
      name: 'notification',
      label: '通知信息',
      fields: [
        {
          prop: 'isNotified',
          label: '是否已通知',
          type: 'select',
          visible: true,
          componentProps: { placeholder: '请选择是否已通知' },
          options: [
            { label: '是', value: '1' },
            { label: '否', value: '0' }
          ]
        },
        {
          prop: 'notifyTime',
          label: '通知时间',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择通知时间' }
        }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [{ prop: 'sourceSystem', label: '来源系统', type: 'input', visible: true }]
    }
  ];

  return new SearchConfigManager('importantMedicalEvent', fieldGroups);
}

// 移动设备搜索配置
export function createMobileDeviceSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'userId', label: '用户ID', type: 'input', visible: true },
        { prop: 'deviceId', label: '设备ID', type: 'input', visible: true },
        {
          prop: 'deviceType',
          label: '设备类型',
          type: 'select',
          visible: true,
          componentProps: { placeholder: '请选择设备类型' },
          options: [
            { label: 'iOS', value: 'iOS' },
            { label: 'Android', value: 'Android' }
          ]
        },
        { prop: 'deviceModel', label: '设备型号', type: 'input', visible: true }
      ]
    },
    {
      name: 'version',
      label: '版本信息',
      fields: [
        { prop: 'osVersion', label: '操作系统版本', type: 'input', visible: true },
        { prop: 'appVersion', label: 'APP版本', type: 'input', visible: true }
      ]
    },
    {
      name: 'login',
      label: '登录信息',
      fields: [
        {
          prop: 'lastLoginTime',
          label: '最后登录时间',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择最后登录时间' }
        },
        { prop: 'lastLoginIp', label: '最后登录IP', type: 'input', visible: true },
        {
          prop: 'isActive',
          label: '是否活跃',
          type: 'select',
          visible: true,
          componentProps: { placeholder: '请选择是否活跃' },
          options: [
            { label: '是', value: '1' },
            { label: '否', value: '0' }
          ]
        }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [{ prop: 'deviceToken', label: '推送Token', type: 'input', visible: false }]
    }
  ];

  return new SearchConfigManager('mobileDevice', fieldGroups);
}

// 核心制度评估记录搜索配置
export function createCoreSystemAssessmentRecordSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'systemName', label: '制度名称', type: 'input', visible: true },
        { prop: 'assessorName', label: '考核人名称', type: 'input', visible: true }
      ]
    },
    {
      name: 'assessment',
      label: '考核信息',
      fields: [
        {
          prop: 'assessmentTime',
          label: '考核时间',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择考核时间' }
        },
        {
          prop: 'assessmentCycle',
          label: '考核周期',
          type: 'select',
          visible: true,
          componentProps: { placeholder: '请选择考核周期' },
          options: [
            { label: '月度', value: 'monthly' },
            { label: '季度', value: 'quarterly' },
            { label: '半年度', value: 'half-yearly' },
            { label: '年度', value: 'yearly' }
          ]
        },
        { prop: 'assessmentScore', label: '考核分数', type: 'input', visible: true },
        {
          prop: 'assessmentGrade',
          label: '考核等级',
          type: 'select',
          visible: true,
          componentProps: { placeholder: '请选择考核等级' },
          options: [
            { label: '优秀', value: 'A' },
            { label: '良好', value: 'B' },
            { label: '合格', value: 'C' },
            { label: '不合格', value: 'D' }
          ]
        },
        { prop: 'assessmentResult', label: '考核结果', type: 'input', visible: true },
        { prop: 'assessmentOpinion', label: '考核意见', type: 'input', visible: true }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [{ prop: 'delFlag', label: '删除标志', type: 'input', visible: false }]
    }
  ];

  return new SearchConfigManager('coreSystemAssessmentRecord', fieldGroups);
}

// 核心制度执行记录搜索配置
export function createCoreSystemExecutionRecordSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'systemName', label: '制度名称', type: 'input', visible: true },
        { prop: 'executorName', label: '执行人姓名', type: 'input', visible: true }
      ]
    },
    {
      name: 'execution',
      label: '执行信息',
      fields: [
        {
          prop: 'executionTime',
          label: '执行时间',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择执行时间' }
        },
        {
          prop: 'executionResult',
          label: '执行结果',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择执行结果',
            options: [
              { label: '成功', value: 1 },
              { label: '失败', value: 0 }
            ]
          }
        }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          componentProps: {
            placeholder: '请选择状态',
            options: [
              { label: '未删除', value: 0 },
              { label: '已删除', value: 1 }
            ]
          }
        }
      ]
    }
  ];

  return new SearchConfigManager('coreSystemExecutionRecord', fieldGroups);
}

// 核心制度整改记录搜索配置
export function createCoreSystemRectificationRecordSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'systemName', label: '制度名称', type: 'input', visible: true },
        { prop: 'rectifierName', label: '整改人', type: 'input', visible: true }
      ]
    },
    {
      name: 'status',
      label: '状态与时间',
      fields: [
        {
          prop: 'rectificationStatus',
          label: '整改状态',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择整改状态',
            options: [
              { label: '未开始', value: '0' },
              { label: '进行中', value: '1' },
              { label: '已完成', value: '2' },
              { label: '暂停', value: '3' }
            ]
          }
        },
        { prop: 'rectificationStartTime', label: '开始时间', type: 'date', visible: true, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } },
        { prop: 'rectificationEndTime', label: '完成时间', type: 'date', visible: true, componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD' } }
      ]
    },
    {
      name: 'acceptance',
      label: '验收',
      fields: [
        {
          prop: 'acceptanceResult',
          label: '验收结果',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择验收结果',
            options: [
              { label: '合格', value: '1' },
              { label: '不合格', value: '0' }
            ]
          }
        }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [{ prop: 'delFlag', label: '删除标志', type: 'select', visible: false }]
    }
  ];
  return new SearchConfigManager('coreSystemRectificationRecord', fieldGroups);
}

export function createQualificationUsageRecordSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基本信息',
      fields: [
        { prop: 'authorizationId', label: '授权记录ID', type: 'input', visible: true },
        { prop: 'staffId', label: '人员ID', type: 'input', visible: true },
        { prop: 'qualificationId', label: '资质ID', type: 'input', visible: true }
      ]
    },
    {
      name: 'usage',
      label: '使用信息',
      fields: [
        {
          prop: 'usageDate',
          label: '使用时间',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择使用时间' }
        },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: true }
      ]
    },
    {
      name: 'operation',
      label: '操作信息',
      fields: [
        { prop: 'operationCode', label: '操作编码', type: 'input', visible: true },
        { prop: 'operationName', label: '操作名称', type: 'input', visible: true },
        {
          prop: 'usageResult',
          label: '使用结果',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择使用结果',
            options: [
              { label: '正常', value: '正常' },
              { label: '异常', value: '异常' }
            ]
          }
        }
      ]
    },
    {
      name: 'authority',
      label: '权限信息',
      fields: [
        {
          prop: 'isOverAuthority',
          label: '是否超权限',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择是否超权限',
            options: [
              { label: '是', value: '1' },
              { label: '否', value: '0' }
            ]
          }
        },
        { prop: 'sourceSystem', label: '来源系统', type: 'input', visible: true }
      ]
    }
  ];

  return new SearchConfigManager('qualificationUsageRecord', fieldGroups);
}

export function createQualificationRiskMonitorSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基本信息',
      fields: [
        { prop: 'riskNo', label: '风险编号', type: 'input', visible: true },
        { prop: 'staffId', label: '人员ID', type: 'input', visible: true },
        { prop: 'staffName', label: '人员姓名', type: 'input', visible: true }
      ]
    },
    {
      name: 'qualification',
      label: '资质信息',
      fields: [
        { prop: 'qualificationId', label: '资质ID', type: 'input', visible: true },
        { prop: 'qualificationName', label: '资质名称', type: 'input', visible: true }
      ]
    },
    {
      name: 'risk',
      label: '风险信息',
      fields: [
        {
          prop: 'riskLevel',
          label: '风险等级',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择风险等级',
            options: [
              { label: '高', value: '高' },
              { label: '中', value: '中' },
              { label: '低', value: '低' }
            ]
          }
        },
        { prop: 'riskDescription', label: '风险描述', type: 'input', visible: true },
        {
          prop: 'riskDate',
          label: '风险发生时间',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择风险发生时间' }
        }
      ]
    },
    {
      name: 'related',
      label: '关联信息',
      fields: [
        { prop: 'relatedPatientId', label: '关联患者ID', type: 'input', visible: true },
        { prop: 'relatedEventId', label: '关联事件ID', type: 'input', visible: true }
      ]
    },
    {
      name: 'handling',
      label: '处理信息',
      fields: [
        { prop: 'handler', label: '处理人', type: 'input', visible: true },
        {
          prop: 'handleTime',
          label: '处理时间',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择处理时间' }
        },
        { prop: 'handleResult', label: '处理结果', type: 'input', visible: true },
        {
          prop: 'handlingStatus',
          label: '处理状态',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择处理状态',
            options: [
              { label: '待处理', value: '待处理' },
              { label: '处理中', value: '处理中' },
              { label: '已处理', value: '已处理' },
              { label: '已关闭', value: '已关闭' }
            ]
          }
        }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          componentProps: {
            placeholder: '请选择状态',
            options: [
              { label: '未删除', value: '0' },
              { label: '已删除', value: '1' }
            ]
          }
        }
      ]
    }
  ];

  return new SearchConfigManager('qualificationRiskMonitor', fieldGroups);
}

export function createQualificationExamArrangementSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'examCode', label: '考试编号', type: 'input', visible: true },
        { prop: 'examName', label: '考试名称', type: 'input', visible: true },
        { prop: 'paperId', label: '试卷ID', type: 'input', visible: true },
        { prop: 'qualificationId', label: '资质ID', type: 'input', visible: true }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        {
          prop: 'examStartTime',
          label: '考试开始时间',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择考试开始时间' }
        },
        {
          prop: 'examEndTime',
          label: '考试结束时间',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择考试结束时间' }
        }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        {
          prop: 'examStatus',
          label: '考试状态',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择考试状态',
            options: [
              { label: '未开始', value: '0' },
              { label: '进行中', value: '1' },
              { label: '已结束', value: '2' },
              { label: '已取消', value: '3' }
            ]
          }
        },
        { prop: 'examineeIds', label: '考生ID列表', type: 'input', visible: true }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          componentProps: {
            placeholder: '请选择状态',
            options: [
              { label: '未删除', value: '0' },
              { label: '已删除', value: '1' }
            ]
          }
        }
      ]
    }
  ];

  return new SearchConfigManager('qualificationExamArrangement', fieldGroups);
}

// 资质考试题目搜索配置
export function createQualificationExamQuestionSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基本信息',
      fields: [
        { prop: 'questionCode', label: '题目编号', type: 'input', visible: true },
        { prop: 'qualificationId', label: '关联资质ID', type: 'input', visible: true },
        {
          prop: 'questionType',
          label: '题型',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择题型',
            options: [
              { label: '单选', value: 'single' },
              { label: '多选', value: 'multiple' },
              { label: '判断', value: 'judgment' },
              { label: '简答', value: 'essay' }
            ]
          }
        }
      ]
    },
    {
      name: 'content',
      label: '题目内容',
      fields: [
        { prop: 'questionContent', label: '题目内容', type: 'input', visible: true },
        { prop: 'correctAnswer', label: '正确答案', type: 'input', visible: true }
      ]
    },
    {
      name: 'settings',
      label: '题目设置',
      fields: [
        {
          prop: 'difficultyLevel',
          label: '难度级别',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择难度',
            options: [
              { label: '易', value: '1' },
              { label: '中', value: '2' },
              { label: '难', value: '3' }
            ]
          }
        },
        { prop: 'score', label: '分值', type: 'input', visible: true },
        {
          prop: 'isEnabled',
          label: '是否启用',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择状态',
            options: [
              { label: '禁用', value: '0' },
              { label: '启用', value: '1' }
            ]
          }
        }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          componentProps: {
            placeholder: '请选择状态',
            options: [
              { label: '未删除', value: '0' },
              { label: '已删除', value: '1' }
            ]
          }
        }
      ]
    }
  ];

  return new SearchConfigManager('qualificationExamQuestion', fieldGroups);
}

// 资质考试试卷搜索配置
export function createQualificationExamPaperSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基本信息',
      fields: [
        { prop: 'paperCode', label: '试卷编号', type: 'input', visible: true },
        { prop: 'paperName', label: '试卷名称', type: 'input', visible: true },
        { prop: 'qualificationId', label: '关联资质ID', type: 'input', visible: true }
      ]
    },
    {
      name: 'score',
      label: '分数设置',
      fields: [
        { prop: 'totalScore', label: '总分', type: 'input', visible: true },
        { prop: 'passScore', label: '及格分', type: 'input', visible: true }
      ]
    },
    {
      name: 'exam',
      label: '考试设置',
      fields: [
        { prop: 'examDuration', label: '考试时长(分钟)', type: 'input', visible: true },
        {
          prop: 'isRandom',
          label: '是否随机抽题',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择',
            options: [
              { label: '否', value: '0' },
              { label: '是', value: '1' }
            ]
          }
        },
        {
          prop: 'isEnabled',
          label: '是否启用',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择',
            options: [
              { label: '禁用', value: '0' },
              { label: '启用', value: '1' }
            ]
          }
        }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          componentProps: {
            placeholder: '请选择状态',
            options: [
              { label: '未删除', value: '0' },
              { label: '已删除', value: '1' }
            ]
          }
        }
      ]
    }
  ];

  return new SearchConfigManager('qualificationExamPaper', fieldGroups);
}

// 新技术延期申请搜索配置
export function createNewTechnologyExtensionApplySearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'applyNo', label: '申请编号', type: 'input', visible: true },
        { prop: 'projectId', label: '项目ID', type: 'input', visible: true },
        { prop: 'extendDays', label: '延期天数', type: 'number', visible: true },
        {
          prop: 'originalEndDate',
          label: '原结束日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择原结束日期' }
        },
        {
          prop: 'newEndDate',
          label: '新结束日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择新结束日期' }
        }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        {
          prop: 'applyStatus',
          label: '申请状态',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择申请状态',
            options: [
              { label: '草稿', value: 'draft' },
              { label: '提交', value: 'submitted' },
              { label: '审核中', value: 'reviewing' },
              { label: '通过', value: 'approved' },
              { label: '驳回', value: 'rejected' }
            ]
          }
        }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          componentProps: {
            placeholder: '请选择状态',
            options: [
              { label: '未删除', value: '0' },
              { label: '已删除', value: '1' }
            ]
          }
        }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyExtensionApply', fieldGroups);
}

// 新技术进展报告搜索配置
export function createNewTechnologyProgressReportSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'reportNo', label: '报告编号', type: 'input', visible: true },
        { prop: 'projectId', label: '项目ID', type: 'input', visible: true },
        { prop: 'reportType', label: '报告类型', type: 'input', visible: true },
        { prop: 'reportPeriod', label: '报告期间', type: 'input', visible: true },
        {
          prop: 'reportDate',
          label: '报告日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择报告日期' }
        }
      ]
    },
    {
      name: 'data',
      label: '数据统计',
      fields: [
        { prop: 'caseCount', label: '开展病例数', type: 'number', visible: true },
        { prop: 'successCount', label: '成功病例数', type: 'number', visible: true },
        { prop: 'complicationCount', label: '并发症例数', type: 'number', visible: true },
        { prop: 'adverseReactionCount', label: '不良反应例数', type: 'number', visible: true },
        { prop: 'mortalityCount', label: '死亡例数', type: 'number', visible: true }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        {
          prop: 'reportStatus',
          label: '报告状态',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择报告状态',
            options: [
              { label: '草稿', value: 'draft' },
              { label: '提交', value: 'submitted' },
              { label: '审核中', value: 'reviewing' },
              { label: '通过', value: 'approved' },
              { label: '驳回', value: 'rejected' }
            ]
          }
        },
        {
          prop: 'continueStatus',
          label: '继续状态',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择继续状态',
            options: [
              { label: '继续', value: 'continue' },
              { label: '暂停', value: 'pause' },
              { label: '终止', value: 'terminate' }
            ]
          }
        }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          componentProps: {
            placeholder: '请选择状态',
            options: [
              { label: '未删除', value: '0' },
              { label: '已删除', value: '1' }
            ]
          }
        }
      ]
    }
  ];

  return new SearchConfigManager('newTechnologyProgressReport', fieldGroups);
}

// 资质考试记录搜索配置
export function createQualificationExamRecordSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'examRecordId', label: '考试记录ID', type: 'input', visible: true },
        { prop: 'staffId', label: '人员ID', type: 'input', visible: false },
        { prop: 'staffName', label: '人员姓名', type: 'input', visible: true },
        { prop: 'qualificationId', label: '资质ID', type: 'input', visible: false },
        { prop: 'qualificationName', label: '资质名称', type: 'input', visible: true }
      ]
    },
    {
      name: 'exam',
      label: '考试信息',
      fields: [
        { prop: 'examPaperId', label: '试卷ID', type: 'input', visible: false },
        { prop: 'examPaperName', label: '试卷名称', type: 'input', visible: true },
        {
          prop: 'examDate',
          label: '考试日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择考试日期' }
        },
        {
          prop: 'examStartTime',
          label: '考试开始时间',
          type: 'datetime',
          visible: true,
          componentProps: { type: 'datetime', valueFormat: 'YYYY-MM-DD HH:mm:ss', placeholder: '请选择考试开始时间' }
        },
        {
          prop: 'examEndTime',
          label: '考试结束时间',
          type: 'datetime',
          visible: true,
          componentProps: { type: 'datetime', valueFormat: 'YYYY-MM-DD HH:mm:ss', placeholder: '请选择考试结束时间' }
        }
      ]
    },
    {
      name: 'score',
      label: '成绩信息',
      fields: [
        { prop: 'totalScore', label: '总分', type: 'number', visible: true },
        { prop: 'passingScore', label: '及格分数', type: 'number', visible: true },
        {
          prop: 'examStatus',
          label: '考试状态',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择考试状态',
            options: [
              { label: '未开始', value: '0' },
              { label: '进行中', value: '1' },
              { label: '已完成', value: '2' },
              { label: '已阅卷', value: '3' }
            ]
          }
        },
        {
          prop: 'passStatus',
          label: '通过状态',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择通过状态',
            options: [
              { label: '未通过', value: '0' },
              { label: '已通过', value: '1' }
            ]
          }
        }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          componentProps: {
            placeholder: '请选择状态',
            options: [
              { label: '未删除', value: '0' },
              { label: '已删除', value: '1' }
            ]
          }
        }
      ]
    }
  ];

  return new SearchConfigManager('qualificationExamRecord', fieldGroups);
}

export function createCoreSystemInspectionRecordSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'systemId', label: '制度ID', type: 'input', visible: true },
        { prop: 'systemName', label: '制度名称', type: 'input', visible: true },
        { prop: 'inspectorName', label: '检查人姓名', type: 'input', visible: true }
      ]
    },
    {
      name: 'inspection',
      label: '检查信息',
      fields: [
        {
          prop: 'inspectionTime',
          label: '检查时间',
          type: 'date',
          visible: true,
          componentProps: { type: 'datetime', valueFormat: 'YYYY-MM-DD HH:mm:ss', placeholder: '请选择检查时间' }
        },
        {
          prop: 'inspectionResult',
          label: '检查结果',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择检查结果',
            options: [
              { label: '合格', value: 1 },
              { label: '不合格', value: 0 }
            ]
          }
        }
      ]
    },
    {
      name: 'other',
      label: '其他',
      fields: [
        { prop: 'problemDescription', label: '问题描述', type: 'input', visible: false },
        { prop: 'rectificationSuggestion', label: '整改建议', type: 'input', visible: false },
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];

  return new SearchConfigManager('coreSystemInspectionRecord', fieldGroups);
}

export function createSurgeryTeamSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true },
        {
          prop: 'roleType',
          label: '角色类型',
          type: 'select',
          visible: true,
          options: [
            { label: '主刀', value: '主刀' },
            { label: '一助', value: '一助' },
            { label: '二助', value: '二助' },
            { label: '巡回护士', value: '巡回护士' },
            { label: '器械护士', value: '器械护士' },
            { label: '麻醉师', value: '麻醉师' }
          ]
        },
        {
          prop: 'qualificationVerify',
          label: '资格验证',
          type: 'select',
          visible: true,
          options: [
            { label: '已验证', value: '1' },
            { label: '未验证', value: '0' }
          ]
        },
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: true,
          options: [
            { label: '正常', value: '0' },
            { label: '已删除', value: '1' }
          ]
        }
      ]
    }
  ];
  return new SearchConfigManager('surgeryTeam', fieldGroups);
}

// 医师专业评级搜索配置
export function createDoctorProfessionalRatingSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医师ID', type: 'input', visible: true },
        { prop: 'doctorName', label: '医师姓名', type: 'input', visible: true },
        { prop: 'ratingYear', label: '评分年份', type: 'input', visible: true },
        {
          prop: 'ratingQuarter',
          label: '评分季度',
          type: 'select',
          visible: true,
          options: [
            { label: '第一季度', value: 1 },
            { label: '第二季度', value: 2 },
            { label: '第三季度', value: 3 },
            { label: '第四季度', value: 4 }
          ]
        }
      ]
    },
    {
      name: 'scores',
      label: '评分信息',
      fields: [
        { prop: 'baseScore', label: '基础分数', type: 'input', visible: true },
        { prop: 'complaintDeduction', label: '投诉扣分', type: 'input', visible: true },
        { prop: 'medicalQualityScore', label: '医疗质量评分', type: 'input', visible: true },
        { prop: 'patientSatisfaction', label: '患者满意度', type: 'input', visible: true },
        { prop: 'finalScore', label: '最终得分', type: 'input', visible: true }
      ]
    },
    {
      name: 'result',
      label: '评级结果',
      fields: [{ prop: 'ratingLevel', label: '评分等级', type: 'input', visible: true }]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          options: [
            { label: '否', value: '0' },
            { label: '是', value: '1' }
          ]
        }
      ]
    }
  ];
  return new SearchConfigManager('doctorProfessionalRating', fieldGroups);
}

export function createSurgeryRecordSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'patient',
      label: '患者信息',
      fields: [
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: true },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: false }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorName', label: '主刀医生姓名', type: 'input', visible: true },
        { prop: 'doctorId', label: '主刀医生ID', type: 'input', visible: false }
      ]
    },
    {
      name: 'department',
      label: '科室信息',
      fields: [
        { prop: 'departmentName', label: '手术科室名称', type: 'input', visible: true },
        { prop: 'departmentId', label: '手术科室ID', type: 'input', visible: false }
      ]
    },
    {
      name: 'surgery',
      label: '手术信息',
      fields: [
        { prop: 'surgeryCode', label: '手术编码', type: 'input', visible: true },
        { prop: 'surgeryName', label: '手术名称', type: 'input', visible: true },
        { prop: 'surgeryLevel', label: '手术等级', type: 'input', visible: true },
        { prop: 'surgeryType', label: '手术类型', type: 'input', visible: true },
        { prop: 'anesthesiaMethod', label: '麻醉方式', type: 'input', visible: true }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        {
          prop: 'surgeryStartTime',
          label: '手术开始时间',
          type: 'datetime',
          visible: true,
          componentProps: { type: 'datetime', valueFormat: 'YYYY-MM-DD HH:mm:ss', placeholder: '请选择手术开始时间' }
        },
        {
          prop: 'surgeryEndTime',
          label: '手术结束时间',
          type: 'datetime',
          visible: true,
          componentProps: { type: 'datetime', valueFormat: 'YYYY-MM-DD HH:mm:ss', placeholder: '请选择手术结束时间' }
        }
      ]
    },
    {
      name: 'medical',
      label: '医疗信息',
      fields: [
        { prop: 'asaGrade', label: 'ASA分级', type: 'input', visible: true },
        { prop: 'bloodLoss', label: '失血量(ml)', type: 'input', visible: true },
        { prop: 'surgeryDuration', label: '手术时长(分钟)', type: 'input', visible: true },
        {
          prop: 'complicationFlag',
          label: '是否有并发症',
          type: 'select',
          visible: true,
          options: [
            { label: '否', value: 0 },
            { label: '是', value: 1 }
          ]
        },
        {
          prop: 'surgeryStatus',
          label: '手术状态',
          type: 'input',
          visible: true
        }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'id', label: '主键ID', type: 'input', visible: false },
        { prop: 'surgeryRecordId', label: '手术记录ID', type: 'input', visible: false },
        { prop: 'applicationId', label: '手术申请ID', type: 'input', visible: false },
        {
          prop: 'delFlag',
          label: '删除标志',
          type: 'select',
          visible: false,
          options: [
            { label: '否', value: '0' },
            { label: '是', value: '1' }
          ]
        }
      ]
    }
  ];
  return new SearchConfigManager('surgeryRecord', fieldGroups);
}
