import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// qualificationAdmissionCondition搜索配置
export function createQualificationAdmissionConditionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'qualificationId', label: '资质ID', type: 'number', visible: true, placeholder: '请输入资质ID' },
        { prop: 'qualificationType', label: '资质类型 医师/医技', type: 'input', visible: true, placeholder: '请输入资质类型 医师/医技' },
        { prop: 'conditionType', label: '条件类型 学历/职称/工作年限/专业/培训/考核/证书', type: 'input', visible: true, placeholder: '请输入条件类型 学历/职称/工作年限/专业/培训/考核/证书' },
        { prop: 'conditionOperator', label: '条件运算符 =/>/</>=/<=/in', type: 'input', visible: false, placeholder: '请输入条件运算符 =/>/</>=/<=/in' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'conditionValue', label: '条件值', type: 'input', visible: false, placeholder: '请输入条件值' },
        { prop: 'conditionUnit', label: '条件单位', type: 'input', visible: false, placeholder: '请输入条件单位' },
        { prop: 'isRequired', label: '是否必须 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否必须 1-是 0-否' },
        { prop: 'logicRelation', label: '逻辑关系 AND/OR', type: 'input', visible: false, placeholder: '请输入逻辑关系 AND/OR' },
        { prop: 'sortOrder', label: '排序', type: 'number', visible: false, placeholder: '请输入排序' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationAdmissionCondition', searchFieldGroups);
}


// qualificationAuthorizationApply搜索配置
export function createQualificationAuthorizationApplySearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'applyNo', label: '申请单号', type: 'input', visible: true, placeholder: '请输入申请单号' },
        { prop: 'applicantId', label: '申请人ID', type: 'number', visible: true, placeholder: '请输入申请人ID' },
        { prop: 'applicantName', label: '申请人姓名', type: 'input', visible: true, placeholder: '请输入申请人姓名' },
        { prop: 'applicantType', label: '申请人类型 医师/医技', type: 'input', visible: false, placeholder: '请输入申请人类型 医师/医技' },
        { prop: 'departmentId', label: '科室ID', type: 'number', visible: false, placeholder: '请输入科室ID' },
        { prop: 'departmentName', label: '科室名称', type: 'input', visible: false, placeholder: '请输入科室名称' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'qualificationIds', label: '资质ID列表', type: 'input', visible: false, placeholder: '请输入资质ID列表' },
        { prop: 'applyReason', label: '申请理由', type: 'input', visible: false, placeholder: '请输入申请理由' },
        { prop: 'certificateIds', label: '关联证书ID', type: 'input', visible: false, placeholder: '请输入关联证书ID' },
        { prop: 'examScore', label: '考核成绩', type: 'number', visible: false, placeholder: '请输入考核成绩' },
        { prop: 'workQuantity', label: '工作量数据JSON', type: 'input', visible: false, placeholder: '请输入工作量数据JSON' },
        { prop: 'workQuality', label: '工作质量数据JSON', type: 'input', visible: false, placeholder: '请输入工作质量数据JSON' },
        { prop: 'applyStatus', label: '申请状态', type: 'input', visible: false, placeholder: '请输入申请状态' },
        { prop: 'currentNode', label: '当前审批节点', type: 'input', visible: false, placeholder: '请输入当前审批节点' },
        { prop: 'workflowInstanceId', label: '工作流实例ID', type: 'number', visible: false, placeholder: '请输入工作流实例ID' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationAuthorizationApply', searchFieldGroups);
}


// qualificationAuthorizationRecord搜索配置
export function createQualificationAuthorizationRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'authorizationNo', label: '授权编号', type: 'input', visible: true, placeholder: '请输入授权编号' },
        { prop: 'staffId', label: '人员ID', type: 'number', visible: true, placeholder: '请输入人员ID' },
        { prop: 'staffName', label: '人员姓名', type: 'input', visible: true, placeholder: '请输入人员姓名' },
        { prop: 'staffType', label: '人员类型 医师/医技', type: 'input', visible: false, placeholder: '请输入人员类型 医师/医技' },
        { prop: 'qualificationId', label: '资质ID', type: 'number', visible: false, placeholder: '请输入资质ID' },
        { prop: 'qualificationCode', label: '资质编码', type: 'input', visible: false, placeholder: '请输入资质编码' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'qualificationName', label: '资质名称', type: 'input', visible: false, placeholder: '请输入资质名称' },
        { prop: 'authorizationType', label: '授权类型 首次授权/再授权/升级/降级/直接授权', type: 'input', visible: false, placeholder: '请输入授权类型 首次授权/再授权/升级/降级/直接授权' },
        { prop: 'authorizationLevel', label: '授权级别', type: 'input', visible: false, placeholder: '请输入授权级别' },
        { prop: 'validStartDate', label: '有效期开始', type: 'daterange', visible: false, placeholder: '请输入有效期开始', startProp: 'validStartDateStart', endProp: 'validStartDateEnd' },
        { prop: 'validEndDate', label: '有效期结束', type: 'daterange', visible: false, placeholder: '请输入有效期结束', startProp: 'validEndDateStart', endProp: 'validEndDateEnd' },
        { prop: 'authorizationStatus', label: '授权状态 有效/即将到期/已过期/已停用', type: 'input', visible: false, placeholder: '请输入授权状态 有效/即将到期/已过期/已停用' },
        { prop: 'applyId', label: '关联申请ID', type: 'number', visible: false, placeholder: '请输入关联申请ID' },
        { prop: 'specialCondition', label: '特殊限制条件', type: 'input', visible: false, placeholder: '请输入特殊限制条件' },
        { prop: 'patientId', label: '限定患者ID', type: 'number', visible: false, placeholder: '请输入限定患者ID' },
        { prop: 'authorizationReason', label: '授权理由', type: 'input', visible: false, placeholder: '请输入授权理由' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationAuthorizationRecord', searchFieldGroups);
}


// qualificationCatalog搜索配置
export function createQualificationCatalogSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医生ID', type: 'number', visible: true, placeholder: '请输入医生ID' },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' },
        { prop: 'title', label: '职称', type: 'input', visible: true, placeholder: '请输入职称' },
        { prop: 'authorizedLevel', label: '所授权手术级别', type: 'input', visible: false, placeholder: '请输入所授权手术级别' },
        { prop: 'level1', label: '一级手术授权（1=通过，0=未通过）', type: 'number', visible: false, placeholder: '请输入一级手术授权（1=通过，0=未通过）' },
        { prop: 'level2', label: '二级手术授权（1=通过，0=未通过）', type: 'number', visible: false, placeholder: '请输入二级手术授权（1=通过，0=未通过）' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'department', label: '科室', type: 'input', visible: false, placeholder: '请输入科室' },
        { prop: 'position', label: '职务', type: 'input', visible: false, placeholder: '请输入职务' },
        { prop: 'level3', label: '三级手术授权（1=通过，0=未通过）', type: 'number', visible: false, placeholder: '请输入三级手术授权（1=通过，0=未通过）' },
        { prop: 'level4', label: '四级手术授权（1=通过，0=未通过）', type: 'number', visible: false, placeholder: '请输入四级手术授权（1=通过，0=未通过）' },
        { prop: 'surgeryName', label: '手术名称', type: 'input', visible: false, placeholder: '请输入手术名称' },
        { prop: 'surgeryCode', label: '手术代码', type: 'input', visible: false, placeholder: '请输入手术代码' },
        { prop: 'surgeryLevel', label: '手术级别（三级/四级）', type: 'input', visible: false, placeholder: '请输入手术级别（三级/四级）' },
        { prop: 'qualificationType', label: '资质类型', type: 'input', visible: false, placeholder: '请输入资质类型' },
        { prop: 'validStartDate', label: '有效期开始', type: 'daterange', visible: false, placeholder: '请输入有效期开始', startProp: 'validStartDateStart', endProp: 'validStartDateEnd' },
        { prop: 'validEndDate', label: '有效期结束', type: 'daterange', visible: false, placeholder: '请输入有效期结束', startProp: 'validEndDateStart', endProp: 'validEndDateEnd' },
        { prop: 'status', label: '状态', type: 'input', visible: false, placeholder: '请输入状态' },
        { prop: 'dataSource', label: '数据来源', type: 'input', visible: false, placeholder: '请输入数据来源' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationCatalog', searchFieldGroups);
}


// qualificationExamArrangement搜索配置
export function createQualificationExamArrangementSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'examCode', label: '考试编号', type: 'input', visible: true, placeholder: '请输入考试编号' },
        { prop: 'examName', label: '考试名称', type: 'input', visible: true, placeholder: '请输入考试名称' },
        { prop: 'paperId', label: '试卷ID', type: 'number', visible: true, placeholder: '请输入试卷ID' },
        { prop: 'qualificationId', label: '资质ID', type: 'number', visible: false, placeholder: '请输入资质ID' },
        { prop: 'examineeIds', label: '考生ID列表', type: 'input', visible: false, placeholder: '请输入考生ID列表' },
        { prop: 'examStatus', label: '考试状态 未开始/进行中/已结束', type: 'input', visible: false, placeholder: '请输入考试状态 未开始/进行中/已结束' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'examStartTime', label: '考试开始时间', type: 'daterange', visible: false, placeholder: '请输入考试开始时间', startProp: 'examStartTimeStart', endProp: 'examStartTimeEnd' },
        { prop: 'examEndTime', label: '考试结束时间', type: 'daterange', visible: false, placeholder: '请输入考试结束时间', startProp: 'examEndTimeStart', endProp: 'examEndTimeEnd' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationExamArrangement', searchFieldGroups);
}


// qualificationExamPaper搜索配置
export function createQualificationExamPaperSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'paperCode', label: '试卷编号', type: 'input', visible: true, placeholder: '请输入试卷编号' },
        { prop: 'paperName', label: '试卷名称', type: 'input', visible: true, placeholder: '请输入试卷名称' },
        { prop: 'qualificationId', label: '关联资质ID', type: 'number', visible: true, placeholder: '请输入关联资质ID' },
        { prop: 'questionIds', label: '题目ID列表JSON', type: 'input', visible: false, placeholder: '请输入题目ID列表JSON' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'totalScore', label: '总分', type: 'number', visible: false, placeholder: '请输入总分' },
        { prop: 'passScore', label: '及格分', type: 'number', visible: false, placeholder: '请输入及格分' },
        { prop: 'examDuration', label: '考试时长', type: 'number', visible: false, placeholder: '请输入考试时长' },
        { prop: 'isRandom', label: '是否随机抽题 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否随机抽题 1-是 0-否' },
        { prop: 'randomRule', label: '随机规则JSON', type: 'input', visible: false, placeholder: '请输入随机规则JSON' },
        { prop: 'isEnabled', label: '是否启用', type: 'number', visible: false, placeholder: '请输入是否启用' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationExamPaper', searchFieldGroups);
}


// qualificationExamQuestion搜索配置
export function createQualificationExamQuestionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'questionCode', label: '题目编号', type: 'input', visible: true, placeholder: '请输入题目编号' },
        { prop: 'qualificationId', label: '关联资质ID', type: 'number', visible: true, placeholder: '请输入关联资质ID' },
        { prop: 'questionType', label: '题型 单选/多选/判断/简答', type: 'input', visible: true, placeholder: '请输入题型 单选/多选/判断/简答' },
        { prop: 'difficultyLevel', label: '难度级别 1-易 2-中 3-难', type: 'number', visible: false, placeholder: '请输入难度级别 1-易 2-中 3-难' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'questionContent', label: '题目内容', type: 'input', visible: false, placeholder: '请输入题目内容' },
        { prop: 'optionA', label: '选项A', type: 'input', visible: false, placeholder: '请输入选项A' },
        { prop: 'optionB', label: '选项B', type: 'input', visible: false, placeholder: '请输入选项B' },
        { prop: 'optionC', label: '选项C', type: 'input', visible: false, placeholder: '请输入选项C' },
        { prop: 'optionD', label: '选项D', type: 'input', visible: false, placeholder: '请输入选项D' },
        { prop: 'optionE', label: '选项E', type: 'input', visible: false, placeholder: '请输入选项E' },
        { prop: 'correctAnswer', label: '正确答案', type: 'input', visible: false, placeholder: '请输入正确答案' },
        { prop: 'answerAnalysis', label: '答案解析', type: 'input', visible: false, placeholder: '请输入答案解析' },
        { prop: 'score', label: '分值', type: 'number', visible: false, placeholder: '请输入分值' },
        { prop: 'isEnabled', label: '是否启用', type: 'number', visible: false, placeholder: '请输入是否启用' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationExamQuestion', searchFieldGroups);
}


// qualificationExamRecord搜索配置
export function createQualificationExamRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'examId', label: '考试安排ID', type: 'number', visible: true, placeholder: '请输入考试安排ID' },
        { prop: 'examineeId', label: '考生ID', type: 'number', visible: true, placeholder: '请输入考生ID' },
        { prop: 'examineeName', label: '考生姓名', type: 'input', visible: true, placeholder: '请输入考生姓名' },
        { prop: 'paperId', label: '试卷ID', type: 'number', visible: false, placeholder: '请输入试卷ID' },
        { prop: 'markingStatus', label: '阅卷状态', type: 'input', visible: false, placeholder: '请输入阅卷状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'startTime', label: '开始时间', type: 'daterange', visible: false, placeholder: '请输入开始时间', startProp: 'startTimeStart', endProp: 'startTimeEnd' },
        { prop: 'submitTime', label: '提交时间', type: 'daterange', visible: false, placeholder: '请输入提交时间', startProp: 'submitTimeStart', endProp: 'submitTimeEnd' },
        { prop: 'answerSheet', label: '答题卡JSON', type: 'input', visible: false, placeholder: '请输入答题卡JSON' },
        { prop: 'objectiveScore', label: '客观题得分', type: 'number', visible: false, placeholder: '请输入客观题得分' },
        { prop: 'subjectiveScore', label: '主观题得分', type: 'number', visible: false, placeholder: '请输入主观题得分' },
        { prop: 'totalScore', label: '总分', type: 'number', visible: false, placeholder: '请输入总分' },
        { prop: 'examResult', label: '考试结果 及格/不及格', type: 'input', visible: false, placeholder: '请输入考试结果 及格/不及格' },
        { prop: 'marker', label: '阅卷人', type: 'input', visible: false, placeholder: '请输入阅卷人' },
        { prop: 'markingTime', label: '阅卷时间', type: 'daterange', visible: false, placeholder: '请输入阅卷时间', startProp: 'markingTimeStart', endProp: 'markingTimeEnd' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationExamRecord', searchFieldGroups);
}


// qualificationPermissionAdjustment搜索配置
export function createQualificationPermissionAdjustmentSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医师ID', type: 'number', visible: true, placeholder: '请输入医师ID' },
        { prop: 'doctorName', label: '医师姓名', type: 'input', visible: true, placeholder: '请输入医师姓名' },
        { prop: 'qualificationId', label: 'qualification_id', type: 'number', visible: true, placeholder: '请输入qualification_id' },
        { prop: 'qualificationType', label: '资质类型（手术权限、抗菌药物权限等）', type: 'input', visible: false, placeholder: '请输入资质类型（手术权限、抗菌药物权限等）' },
        { prop: 'originalLevel', label: '原权限级别', type: 'input', visible: false, placeholder: '请输入原权限级别' },
        { prop: 'newLevel', label: '新权限级别', type: 'input', visible: false, placeholder: '请输入新权限级别' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'adjustmentReason', label: '调整原因', type: 'input', visible: false, placeholder: '请输入调整原因' },
        { prop: 'adjustmentBasis', label: '调整依据（JSON格式，包含工作量、并发症等数据）', type: 'input', visible: false, placeholder: '请输入调整依据（JSON格式，包含工作量、并发症等数据）' },
        { prop: 'adjustmentTime', label: '调整时间', type: 'daterange', visible: false, placeholder: '请输入调整时间', startProp: 'adjustmentTimeStart', endProp: 'adjustmentTimeEnd' },
        { prop: 'operatorId', label: '操作人ID', type: 'number', visible: false, placeholder: '请输入操作人ID' },
        { prop: 'operatorName', label: '操作人姓名', type: 'input', visible: false, placeholder: '请输入操作人姓名' },
        { prop: 'isAutoAdjustment', label: '是否自动调整', type: 'number', visible: false, placeholder: '请输入是否自动调整' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationPermissionAdjustment', searchFieldGroups);
}


// qualificationRiskMonitor搜索配置
export function createQualificationRiskMonitorSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'riskNo', label: '风险编号', type: 'input', visible: true, placeholder: '请输入风险编号' },
        { prop: 'staffId', label: '人员ID', type: 'number', visible: true, placeholder: '请输入人员ID' },
        { prop: 'staffName', label: '人员姓名', type: 'input', visible: true, placeholder: '请输入人员姓名' },
        { prop: 'qualificationId', label: '资质ID', type: 'number', visible: false, placeholder: '请输入资质ID' },
        { prop: 'qualificationName', label: '资质名称', type: 'input', visible: false, placeholder: '请输入资质名称' },
        { prop: 'riskType', label: '风险类型 超权限/即将过期/质量问题/安全事件', type: 'input', visible: false, placeholder: '请输入风险类型 超权限/即将过期/质量问题/安全事件' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'riskLevel', label: '风险等级 高/中/低', type: 'input', visible: false, placeholder: '请输入风险等级 高/中/低' },
        { prop: 'riskDescription', label: '风险描述', type: 'input', visible: false, placeholder: '请输入风险描述' },
        { prop: 'riskDate', label: '风险发生时间', type: 'daterange', visible: false, placeholder: '请输入风险发生时间', startProp: 'riskDateStart', endProp: 'riskDateEnd' },
        { prop: 'relatedPatientId', label: '关联患者ID', type: 'number', visible: false, placeholder: '请输入关联患者ID' },
        { prop: 'relatedEventId', label: '关联事件ID', type: 'number', visible: false, placeholder: '请输入关联事件ID' },
        { prop: 'handlingStatus', label: '处理状态', type: 'input', visible: false, placeholder: '请输入处理状态' },
        { prop: 'handler', label: '处理人', type: 'input', visible: false, placeholder: '请输入处理人' },
        { prop: 'handleTime', label: '处理时间', type: 'daterange', visible: false, placeholder: '请输入处理时间', startProp: 'handleTimeStart', endProp: 'handleTimeEnd' },
        { prop: 'handleResult', label: '处理结果', type: 'input', visible: false, placeholder: '请输入处理结果' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationRiskMonitor', searchFieldGroups);
}


// qualificationUsageRecord搜索配置
export function createQualificationUsageRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'authorizationId', label: '授权记录ID', type: 'number', visible: true, placeholder: '请输入授权记录ID' },
        { prop: 'staffId', label: '人员ID', type: 'number', visible: true, placeholder: '请输入人员ID' },
        { prop: 'qualificationId', label: '资质ID', type: 'number', visible: true, placeholder: '请输入资质ID' },
        { prop: 'patientId', label: '患者ID', type: 'number', visible: false, placeholder: '请输入患者ID' },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: false, placeholder: '请输入患者姓名' },
        { prop: 'operationCode', label: '操作编码', type: 'input', visible: false, placeholder: '请输入操作编码' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'usageDate', label: '使用时间', type: 'daterange', visible: false, placeholder: '请输入使用时间', startProp: 'usageDateStart', endProp: 'usageDateEnd' },
        { prop: 'operationName', label: '操作名称', type: 'input', visible: false, placeholder: '请输入操作名称' },
        { prop: 'usageResult', label: '使用结果 正常/异常', type: 'input', visible: false, placeholder: '请输入使用结果 正常/异常' },
        { prop: 'isOverAuthority', label: '是否超权限 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否超权限 1-是 0-否' },
        { prop: 'sourceSystem', label: '来源系统', type: 'input', visible: false, placeholder: '请输入来源系统' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('qualificationUsageRecord', searchFieldGroups);
}
