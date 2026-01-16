import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// 科室资格目录字段配置
export function createDepartmentQualificationDirectoryFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'departmentId', label: '科室ID', visible: true, group: 'basic' },
        { prop: 'departmentName', label: '科室名称', visible: true, required: true, group: 'basic' },
        { prop: 'qualificationName', label: '资格名称', visible: true, required: true, group: 'basic' },
        { prop: 'qualificationCode', label: '资格编码', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'description', label: '描述', visible: true, group: 'detail' },
        { prop: 'requirements', label: '要求条件', visible: true, group: 'detail' },
        { prop: 'validityPeriod', label: '有效期', visible: true, group: 'detail' },
        { prop: 'evaluationCriteria', label: '评估标准', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', visible: true, group: 'status' },
        { prop: 'isActive', label: '是否激活', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('departmentQualificationCatalog', fieldGroups);
}

// 资质准入条件字段配置
export function createQualificationAdmissionConditionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'qualificationId', label: '资质ID', visible: true, group: 'basic' },
        { prop: 'qualificationType', label: '资质类型', visible: true, required: true, group: 'basic' },
        { prop: 'conditionType', label: '条件类型', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'condition',
      label: '条件信息',
      fields: [
        { prop: 'conditionOperator', label: '条件运算符', visible: true, group: 'condition' },
        { prop: 'conditionValue', label: '条件值', visible: true, group: 'condition' },
        { prop: 'conditionUnit', label: '条件单位', visible: true, group: 'condition' },
        { prop: 'isRequired', label: '是否必须', visible: true, group: 'condition' }
      ]
    },
    {
      name: 'logic',
      label: '逻辑信息',
      fields: [
        { prop: 'logicRelation', label: '逻辑关系', visible: true, group: 'logic' },
        { prop: 'sortOrder', label: '排序', visible: true, group: 'logic' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'remark', label: '备注', visible: true, group: 'system' },
        { prop: 'delFlag', label: '是否删除', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationAdmissionCondition', fieldGroups);
}

// 资质授权申请字段配置
export function createQualificationAuthorizationApplyFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'applyNo', label: '申请单号', visible: true, required: true, group: 'basic' },
        { prop: 'applicantId', label: '申请人ID', visible: true, group: 'basic' },
        { prop: 'applicantName', label: '申请人姓名', visible: true, required: true, group: 'basic' },
        { prop: 'applicantType', label: '申请人类型', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'department',
      label: '科室信息',
      fields: [
        { prop: 'departmentId', label: '科室ID', visible: true, group: 'department' },
        { prop: 'departmentName', label: '科室名称', visible: true, group: 'department' }
      ]
    },
    {
      name: 'qualification',
      label: '资质信息',
      fields: [{ prop: 'qualificationIds', label: '资质ID列表', visible: true, group: 'qualification' }]
    },
    {
      name: 'application',
      label: '申请信息',
      fields: [
        { prop: 'applyReason', label: '申请理由', visible: true, group: 'application' },
        { prop: 'certificateIds', label: '关联证书ID', visible: true, group: 'application' },
        { prop: 'examScore', label: '考核成绩', visible: true, group: 'application' },
        { prop: 'workQuantity', label: '工作量数据', visible: true, group: 'application' },
        { prop: 'workQuality', label: '工作质量数据', visible: true, group: 'application' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'applyStatus', label: '申请状态', visible: true, group: 'status' },
        { prop: 'currentNode', label: '当前审批节点', visible: true, group: 'status' },
        { prop: 'workflowInstanceId', label: '工作流实例ID', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationAuthorizationApply', fieldGroups);
}

// 资质授权记录字段配置
export function createQualificationAuthorizationRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'authorizationNo', label: '授权编号', visible: true, required: true, group: 'basic' },
        { prop: 'staffId', label: '人员ID', visible: true, group: 'basic' },
        { prop: 'staffName', label: '人员姓名', visible: true, required: true, group: 'basic' },
        { prop: 'staffType', label: '人员类型', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'qualification',
      label: '资质信息',
      fields: [
        { prop: 'qualificationId', label: '资质ID', visible: true, group: 'qualification' },
        { prop: 'qualificationCode', label: '资质编码', visible: true, group: 'qualification' },
        { prop: 'qualificationName', label: '资质名称', visible: true, required: true, group: 'qualification' }
      ]
    },
    {
      name: 'authorization',
      label: '授权信息',
      fields: [
        { prop: 'authorizationType', label: '授权类型', visible: true, group: 'authorization' },
        { prop: 'authorizationLevel', label: '授权级别', visible: true, group: 'authorization' },
        { prop: 'validStartDate', label: '有效期开始', visible: true, width: '120', group: 'authorization' },
        { prop: 'validEndDate', label: '有效期结束', visible: true, width: '120', group: 'authorization' },
        { prop: 'authorizationStatus', label: '授权状态', visible: true, group: 'authorization' }
      ]
    },
    {
      name: 'details',
      label: '详细信息',
      fields: [
        { prop: 'applyId', label: '关联申请ID', visible: true, group: 'details' },
        { prop: 'specialCondition', label: '特殊限制条件', visible: true, group: 'details' },
        { prop: 'patientId', label: '限定患者ID', visible: true, group: 'details' },
        { prop: 'authorizationReason', label: '授权理由', visible: true, group: 'details' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationAuthorizationRecord', fieldGroups);
}

// 资质考试安排字段配置
export function createQualificationExamArrangementFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'examCode', label: '考试编号', visible: true, required: true, group: 'basic' },
        { prop: 'examName', label: '考试名称', visible: true, required: true, group: 'basic' },
        { prop: 'paperId', label: '试卷ID', visible: true, required: true, group: 'basic' },
        { prop: 'qualificationId', label: '资质ID', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'examStartTime', label: '考试开始时间', visible: true, required: true, width: '180', group: 'time' },
        { prop: 'examEndTime', label: '考试结束时间', visible: true, required: true, width: '180', group: 'time' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'examStatus', label: '考试状态', visible: true, required: true, group: 'status' },
        { prop: 'examineeIds', label: '考生ID列表', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationExamArrangement', fieldGroups);
}

// 资质风险监控字段配置
export function createQualificationRiskMonitorFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'riskNo', label: '风险编号', visible: true, required: true, group: 'basic' },
        { prop: 'staffId', label: '人员ID', visible: true, group: 'basic' },
        { prop: 'staffName', label: '人员姓名', visible: true, group: 'basic' },
        { prop: 'qualificationId', label: '资质ID', visible: true, group: 'basic' },
        { prop: 'qualificationName', label: '资质名称', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'risk',
      label: '风险信息',
      fields: [
        { prop: 'riskType', label: '风险类型 超权限/即将过期/质量问题/安全事件', visible: true, group: 'risk' },
        { prop: 'riskLevel', label: '风险等级 高/中/低', visible: true, group: 'risk' },
        { prop: 'riskDescription', label: '风险描述', visible: true, group: 'risk' },
        { prop: 'riskDate', label: '风险发生时间', visible: true, width: '180', group: 'risk' }
      ]
    },
    {
      name: 'related',
      label: '关联信息',
      fields: [
        { prop: 'relatedPatientId', label: '关联患者ID', visible: true, group: 'related' },
        { prop: 'relatedEventId', label: '关联事件ID', visible: true, group: 'related' }
      ]
    },
    {
      name: 'handle',
      label: '处理信息',
      fields: [
        { prop: 'handlingStatus', label: '处理状态', visible: true, group: 'handle' },
        { prop: 'handler', label: '处理人', visible: true, group: 'handle' },
        { prop: 'handleTime', label: '处理时间', visible: true, width: '180', group: 'handle' },
        { prop: 'handleResult', label: '处理结果', visible: true, group: 'handle' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [{ prop: 'delFlag', label: '是否删除', visible: true, group: 'system' }]
    }
  ];

  return new FieldConfigManager('qualificationRiskMonitor', fieldGroups);
}

// 资质使用记录字段配置
export function createQualificationUsageRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, required: true, group: 'basic' },
        { prop: 'qualificationId', label: '资质ID', visible: true, group: 'basic' },
        { prop: 'qualificationName', label: '资质名称', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'usage',
      label: '使用信息',
      fields: [
        { prop: 'usageDate', label: '使用日期', visible: true, width: '120', group: 'usage' },
        { prop: 'usageType', label: '使用类型', visible: true, group: 'usage' },
        { prop: 'usageLocation', label: '使用地点', visible: true, group: 'usage' },
        { prop: 'patientId', label: '患者ID', visible: true, group: 'usage' }
      ]
    },
    {
      name: 'result',
      label: '结果信息',
      fields: [
        { prop: 'outcome', label: '结果', visible: true, group: 'result' },
        { prop: 'notes', label: '备注', visible: true, group: 'result' },
        { prop: 'supervisor', label: '监督人', visible: true, group: 'result' },
        { prop: 'status', label: '状态', visible: true, group: 'result' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationUsageRecord', fieldGroups);
}

// 技师资质目录字段配置
export function createTechnicianQualificationCatalogFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'catalogCode', label: '资质编码', visible: true, required: true, group: 'basic' },
        { prop: 'catalogName', label: '资质名称', visible: true, required: true, group: 'basic' },
        { prop: 'parentId', label: '父级ID', visible: true, group: 'basic' },
        { prop: 'catalogLevel', label: '目录层级', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'catalogType', label: '资质类型', visible: true, group: 'detail' },
        { prop: 'description', label: '资质描述', visible: true, group: 'detail' },
        { prop: 'sortOrder', label: '排序', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [{ prop: 'isEnabled', label: '是否启用', visible: true, group: 'status' }]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('technicianQualificationCatalog', fieldGroups);
}

// 资质考核试卷字段配置
export function createQualificationExamPaperFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'paperCode', label: '试卷编号', visible: true, required: true, group: 'basic' },
        { prop: 'paperName', label: '试卷名称', visible: true, required: true, group: 'basic' },
        { prop: 'isEnabled', label: '是否启用', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'qualification',
      label: '资质信息',
      fields: [{ prop: 'qualificationId', label: '关联资质ID', visible: true, group: 'qualification' }]
    },
    {
      name: 'score',
      label: '分数设置',
      fields: [
        { prop: 'totalScore', label: '总分', visible: true, group: 'score' },
        { prop: 'passScore', label: '及格分', visible: true, group: 'score' }
      ]
    },
    {
      name: 'exam',
      label: '考试设置',
      fields: [
        { prop: 'examDuration', label: '考试时长(分钟)', visible: true, group: 'exam' },
        { prop: 'isRandom', label: '是否随机抽题 1-是 0-否', visible: true, group: 'exam' },
        { prop: 'randomRule', label: '随机规则JSON', visible: true, group: 'exam' }
      ]
    },
    {
      name: 'questions',
      label: '题目信息',
      fields: [{ prop: 'questionIds', label: '题目ID列表JSON', visible: true, group: 'questions' }]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [{ prop: 'delFlag', label: '是否删除', visible: true, group: 'system' }]
    }
  ];

  return new FieldConfigManager('qualificationExamPaper', fieldGroups);
}

// 资质考试题目字段配置
export function createQualificationExamQuestionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'questionCode', label: '题目编号', visible: true, required: true, group: 'basic' },
        { prop: 'qualificationId', label: '关联资质ID', visible: true, required: true, group: 'basic' },
        { prop: 'questionType', label: '题型', visible: true, required: true, group: 'basic' },
        { prop: 'questionContent', label: '题目内容', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'options',
      label: '选项信息',
      fields: [
        { prop: 'optionA', label: '选项A', visible: true, group: 'options' },
        { prop: 'optionB', label: '选项B', visible: true, group: 'options' },
        { prop: 'optionC', label: '选项C', visible: true, group: 'options' },
        { prop: 'optionD', label: '选项D', visible: true, group: 'options' },
        { prop: 'optionE', label: '选项E', visible: true, group: 'options' }
      ]
    },
    {
      name: 'answer',
      label: '答案信息',
      fields: [
        { prop: 'correctAnswer', label: '正确答案', visible: true, required: true, group: 'answer' },
        { prop: 'answerAnalysis', label: '答案解析', visible: true, group: 'answer' }
      ]
    },
    {
      name: 'settings',
      label: '题目设置',
      fields: [
        { prop: 'difficultyLevel', label: '难度级别', visible: true, group: 'settings' },
        { prop: 'score', label: '分值', visible: true, group: 'settings' },
        { prop: 'isEnabled', label: '是否启用', visible: true, group: 'settings' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [{ prop: 'remark', label: '备注', visible: true, group: 'detail' }]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationExamQuestion', fieldGroups);
}

// 资质权限调整字段配置
export function createQualificationPermissionAdjustmentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'doctorName', label: '医师姓名', visible: true, group: 'basic' },
        { prop: 'qualificationType', label: '资质类型', visible: true, group: 'basic' },
        { prop: 'originalLevel', label: '原权限级别', visible: true, group: 'basic' },
        { prop: 'newLevel', label: '新权限级别', visible: true, group: 'basic' },
        { prop: 'adjustmentReason', label: '调整原因', visible: true, group: 'basic' },
        { prop: 'adjustmentBasis', label: '调整依据', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [{ prop: 'adjustmentTime', label: '调整时间', visible: true, width: '180', group: 'time' }]
    },
    {
      name: 'operator',
      label: '操作信息',
      fields: [
        { prop: 'operatorName', label: '操作人姓名', visible: true, group: 'operator' },
        { prop: 'isAutoAdjustment', label: '是否自动调整', visible: true, group: 'operator' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [{ prop: 'remark', label: '备注', visible: true, group: 'detail' }]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];
  return new FieldConfigManager('qualificationPermissionAdjustment', fieldGroups);
}