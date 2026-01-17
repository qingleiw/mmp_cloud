import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// qualificationAdmissionCondition字段配置
export function createQualificationAdmissionConditionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'qualificationId', label: '资质ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'qualificationType', label: '资质类型 医师/医技', visible: true, type: 'input', group: 'basic' },
        { prop: 'conditionType', label: '条件类型 学历/职称/工作年限/专业/培训/考核/证书', visible: true, type: 'input', group: 'basic' },
        { prop: 'conditionOperator', label: '条件运算符 =/>/</>=/<=/in', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'conditionValue', label: '条件值', visible: true, type: 'input', group: 'detail' },
        { prop: 'conditionUnit', label: '条件单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'isRequired', label: '是否必须 1-是 0-否', visible: true, type: 'number', group: 'detail' },
        { prop: 'logicRelation', label: '逻辑关系 AND/OR', visible: true, type: 'input', group: 'detail' },
        { prop: 'sortOrder', label: '排序', visible: true, type: 'number', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationAdmissionCondition', fieldGroups);
}


// qualificationAuthorizationApply字段配置
export function createQualificationAuthorizationApplyFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'applyNo', label: '申请单号', visible: true, type: 'input', group: 'basic' },
        { prop: 'applicantId', label: '申请人ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'applicantName', label: '申请人姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'applicantType', label: '申请人类型 医师/医技', visible: true, type: 'input', group: 'basic' },
        { prop: 'departmentId', label: '科室ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'departmentName', label: '科室名称', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'qualificationIds', label: '资质ID列表', visible: true, type: 'input', group: 'detail' },
        { prop: 'applyReason', label: '申请理由', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'certificateIds', label: '关联证书ID', visible: true, type: 'input', group: 'detail' },
        { prop: 'examScore', label: '考核成绩', visible: true, type: 'number', group: 'detail' },
        { prop: 'workQuantity', label: '工作量数据JSON', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'workQuality', label: '工作质量数据JSON', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'applyStatus', label: '申请状态', visible: true, type: 'input', group: 'detail' },
        { prop: 'currentNode', label: '当前审批节点', visible: true, type: 'input', group: 'detail' },
        { prop: 'workflowInstanceId', label: '工作流实例ID', visible: true, type: 'number', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationAuthorizationApply', fieldGroups);
}


// qualificationAuthorizationRecord字段配置
export function createQualificationAuthorizationRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'authorizationNo', label: '授权编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'staffId', label: '人员ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'staffName', label: '人员姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'staffType', label: '人员类型 医师/医技', visible: true, type: 'input', group: 'basic' },
        { prop: 'qualificationId', label: '资质ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'qualificationCode', label: '资质编码', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'qualificationName', label: '资质名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'authorizationType', label: '授权类型 首次授权/再授权/升级/降级/直接授权', visible: true, type: 'input', group: 'detail' },
        { prop: 'authorizationLevel', label: '授权级别', visible: true, type: 'input', group: 'detail' },
        { prop: 'validStartDate', label: '有效期开始', visible: true, type: 'date', group: 'detail' },
        { prop: 'validEndDate', label: '有效期结束', visible: true, type: 'date', group: 'detail' },
        { prop: 'authorizationStatus', label: '授权状态 有效/即将到期/已过期/已停用', visible: true, type: 'input', group: 'detail' },
        { prop: 'applyId', label: '关联申请ID', visible: true, type: 'number', group: 'detail' },
        { prop: 'specialCondition', label: '特殊限制条件', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'patientId', label: '限定患者ID', visible: true, type: 'number', group: 'detail' },
        { prop: 'authorizationReason', label: '授权理由', visible: true, type: 'textarea', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationAuthorizationRecord', fieldGroups);
}


// qualificationCatalog字段配置
export function createQualificationCatalogFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'title', label: '职称', visible: true, type: 'input', group: 'basic' },
        { prop: 'authorizedLevel', label: '所授权手术级别', visible: true, type: 'input', group: 'basic' },
        { prop: 'level1', label: '一级手术授权（1=通过，0=未通过）', visible: true, type: 'number', group: 'basic' },
        { prop: 'level2', label: '二级手术授权（1=通过，0=未通过）', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'department', label: '科室', visible: true, type: 'input', group: 'detail' },
        { prop: 'position', label: '职务', visible: true, type: 'input', group: 'detail' },
        { prop: 'level3', label: '三级手术授权（1=通过，0=未通过）', visible: true, type: 'number', group: 'detail' },
        { prop: 'level4', label: '四级手术授权（1=通过，0=未通过）', visible: true, type: 'number', group: 'detail' },
        { prop: 'surgeryName', label: '手术名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'surgeryCode', label: '手术代码', visible: true, type: 'input', group: 'detail' },
        { prop: 'surgeryLevel', label: '手术级别（三级/四级）', visible: true, type: 'input', group: 'detail' },
        { prop: 'qualificationType', label: '资质类型', visible: true, type: 'input', group: 'detail' },
        { prop: 'validStartDate', label: '有效期开始', visible: true, type: 'date', group: 'detail' },
        { prop: 'validEndDate', label: '有效期结束', visible: true, type: 'date', group: 'detail' },
        { prop: 'status', label: '状态', visible: true, type: 'input', group: 'detail' },
        { prop: 'dataSource', label: '数据来源', visible: true, type: 'input', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationCatalog', fieldGroups);
}


// qualificationExamArrangement字段配置
export function createQualificationExamArrangementFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'examCode', label: '考试编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'examName', label: '考试名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'paperId', label: '试卷ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'qualificationId', label: '资质ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'examineeIds', label: '考生ID列表', visible: true, type: 'textarea', group: 'basic' },
        { prop: 'examStatus', label: '考试状态 未开始/进行中/已结束', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'examStartTime', label: '考试开始时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'examEndTime', label: '考试结束时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationExamArrangement', fieldGroups);
}


// qualificationExamPaper字段配置
export function createQualificationExamPaperFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'paperCode', label: '试卷编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'paperName', label: '试卷名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'qualificationId', label: '关联资质ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'questionIds', label: '题目ID列表JSON', visible: true, type: 'textarea', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'totalScore', label: '总分', visible: true, type: 'number', group: 'detail' },
        { prop: 'passScore', label: '及格分', visible: true, type: 'number', group: 'detail' },
        { prop: 'examDuration', label: '考试时长', visible: true, type: 'number', group: 'detail' },
        { prop: 'isRandom', label: '是否随机抽题 1-是 0-否', visible: true, type: 'number', group: 'detail' },
        { prop: 'randomRule', label: '随机规则JSON', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'isEnabled', label: '是否启用', visible: true, type: 'number', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationExamPaper', fieldGroups);
}


// qualificationExamQuestion字段配置
export function createQualificationExamQuestionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'questionCode', label: '题目编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'qualificationId', label: '关联资质ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'questionType', label: '题型 单选/多选/判断/简答', visible: true, type: 'input', group: 'basic' },
        { prop: 'difficultyLevel', label: '难度级别 1-易 2-中 3-难', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'questionContent', label: '题目内容', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'optionA', label: '选项A', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'optionB', label: '选项B', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'optionC', label: '选项C', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'optionD', label: '选项D', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'optionE', label: '选项E', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'correctAnswer', label: '正确答案', visible: true, type: 'input', group: 'detail' },
        { prop: 'answerAnalysis', label: '答案解析', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'score', label: '分值', visible: true, type: 'number', group: 'detail' },
        { prop: 'isEnabled', label: '是否启用', visible: true, type: 'number', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationExamQuestion', fieldGroups);
}


// qualificationExamRecord字段配置
export function createQualificationExamRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'examId', label: '考试安排ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'examineeId', label: '考生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'examineeName', label: '考生姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'paperId', label: '试卷ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'markingStatus', label: '阅卷状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'startTime', label: '开始时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'submitTime', label: '提交时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'answerSheet', label: '答题卡JSON', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'objectiveScore', label: '客观题得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'subjectiveScore', label: '主观题得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'totalScore', label: '总分', visible: true, type: 'number', group: 'detail' },
        { prop: 'examResult', label: '考试结果 及格/不及格', visible: true, type: 'input', group: 'detail' },
        { prop: 'marker', label: '阅卷人', visible: true, type: 'input', group: 'detail' },
        { prop: 'markingTime', label: '阅卷时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationExamRecord', fieldGroups);
}


// qualificationPermissionAdjustment字段配置
export function createQualificationPermissionAdjustmentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医师ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'doctorName', label: '医师姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'qualificationId', label: 'qualification_id', visible: true, type: 'number', group: 'basic' },
        { prop: 'qualificationType', label: '资质类型（手术权限、抗菌药物权限等）', visible: true, type: 'input', group: 'basic' },
        { prop: 'originalLevel', label: '原权限级别', visible: true, type: 'input', group: 'basic' },
        { prop: 'newLevel', label: '新权限级别', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'adjustmentReason', label: '调整原因', visible: true, type: 'input', group: 'detail' },
        { prop: 'adjustmentBasis', label: '调整依据（JSON格式，包含工作量、并发症等数据）', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'adjustmentTime', label: '调整时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'operatorId', label: '操作人ID', visible: true, type: 'number', group: 'detail' },
        { prop: 'operatorName', label: '操作人姓名', visible: true, type: 'input', group: 'detail' },
        { prop: 'isAutoAdjustment', label: '是否自动调整', visible: true, type: 'number', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationPermissionAdjustment', fieldGroups);
}


// qualificationRiskMonitor字段配置
export function createQualificationRiskMonitorFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'riskNo', label: '风险编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'staffId', label: '人员ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'staffName', label: '人员姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'qualificationId', label: '资质ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'qualificationName', label: '资质名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'riskType', label: '风险类型 超权限/即将过期/质量问题/安全事件', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'riskLevel', label: '风险等级 高/中/低', visible: true, type: 'input', group: 'detail' },
        { prop: 'riskDescription', label: '风险描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'riskDate', label: '风险发生时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'relatedPatientId', label: '关联患者ID', visible: true, type: 'number', group: 'detail' },
        { prop: 'relatedEventId', label: '关联事件ID', visible: true, type: 'number', group: 'detail' },
        { prop: 'handlingStatus', label: '处理状态', visible: true, type: 'input', group: 'detail' },
        { prop: 'handler', label: '处理人', visible: true, type: 'input', group: 'detail' },
        { prop: 'handleTime', label: '处理时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'handleResult', label: '处理结果', visible: true, type: 'textarea', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationRiskMonitor', fieldGroups);
}


// qualificationUsageRecord字段配置
export function createQualificationUsageRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'authorizationId', label: '授权记录ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'staffId', label: '人员ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'qualificationId', label: '资质ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'operationCode', label: '操作编码', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'usageDate', label: '使用时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'operationName', label: '操作名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'usageResult', label: '使用结果 正常/异常', visible: true, type: 'input', group: 'detail' },
        { prop: 'isOverAuthority', label: '是否超权限 1-是 0-否', visible: true, type: 'number', group: 'detail' },
        { prop: 'sourceSystem', label: '来源系统', visible: true, type: 'input', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('qualificationUsageRecord', fieldGroups);
}
