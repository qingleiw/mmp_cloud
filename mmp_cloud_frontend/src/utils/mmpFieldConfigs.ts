import { FieldConfigManager, FieldGroup } from './fieldConfigManager';

// 医生基本信息字段配置
export function createDoctorBasicInfoFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'doctorCode', label: '医生工号', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, required: true, group: 'basic' },
        { prop: 'gender', label: '性别', visible: true, group: 'basic' },
        { prop: 'birthDate', label: '出生日期', visible: true, width: '120', group: 'basic' },
        { prop: 'idCard', label: '身份证号', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'contact',
      label: '联系信息',
      fields: [
        { prop: 'phone', label: '联系电话', visible: true, group: 'contact' },
        { prop: 'email', label: '电子邮箱', visible: true, group: 'contact' },
        { prop: 'photoUrl', label: '照片URL', visible: true, group: 'contact' }
      ]
    },
    {
      name: 'work',
      label: '工作信息',
      fields: [
        { prop: 'deptId', label: '科室ID', visible: true, group: 'work' },
        { prop: 'departmentName', label: '科室名称', visible: true, group: 'work' },
        { prop: 'title', label: '职称', visible: true, group: 'work' },
        { prop: 'titleLevel', label: '职称级别', visible: true, group: 'work' },
        { prop: 'status', label: '状态', visible: true, group: 'work' },
        { prop: 'entryDate', label: '入职日期', visible: true, width: '120', group: 'work' }
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
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [{ prop: 'remark', label: '备注', visible: true, group: 'detail' }]
    }
  ];

  return new FieldConfigManager('doctorBasicInfo', fieldGroups);
}

// 医生工作经历字段配置
export function createDoctorWorkExperienceFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, group: 'basic' },
        { prop: 'organization', label: '工作单位', visible: true, required: true, group: 'basic' },
        { prop: 'department', label: '部门', visible: true, group: 'basic' },
        { prop: 'position', label: '职位', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'startDate', label: '开始日期', visible: true, width: '120', group: 'time' },
        { prop: 'endDate', label: '结束日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'work',
      label: '工作信息',
      fields: [
        { prop: 'jobDescription', label: '工作描述', visible: true, group: 'work' },
        { prop: 'achievements', label: '工作业绩', visible: true, group: 'work' },
        { prop: 'referencePerson', label: '证明人', visible: true, group: 'work' }
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
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [{ prop: 'remark', label: '备注', visible: true, group: 'detail' }]
    }
  ];

  return new FieldConfigManager('doctorWorkExperience', fieldGroups);
}

// 医生能力评估字段配置
export function createDoctorSimpleAbilityAssessmentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, group: 'basic' },
        { prop: 'assessmentYear', label: '评估年度', visible: true, group: 'basic' },
        { prop: 'assessmentType', label: '评估类型', visible: true, group: 'basic' },
        { prop: 'assessmentDate', label: '评估日期', visible: true, width: '120', group: 'basic' },
        { prop: 'assessor', label: '评估人', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'scores',
      label: '能力评分',
      fields: [
        { prop: 'clinicalAbilityScore', label: '临床能力得分', visible: true, group: 'scores' },
        { prop: 'teachingAbilityScore', label: '教学能力得分', visible: true, group: 'scores' },
        { prop: 'researchAbilityScore', label: '科研能力得分', visible: true, group: 'scores' },
        { prop: 'managementAbilityScore', label: '管理能力得分', visible: true, group: 'scores' },
        { prop: 'totalScore', label: '总分', visible: true, group: 'scores' }
      ]
    },
    {
      name: 'result',
      label: '评估结果',
      fields: [{ prop: 'assessmentResult', label: '评估结果', visible: true, group: 'result' }]
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

  return new FieldConfigManager('doctorAbilityAssessment', fieldGroups);
}
// 医生不良记录字段配置
export function createDoctorAdverseRecordSimpleFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, group: 'basic' },
        { prop: 'recordType', label: '记录类型', visible: true, group: 'basic' },
        { prop: 'recordTitle', label: '记录标题', visible: true, group: 'basic' },
        { prop: 'occurDate', label: '发生日期', visible: true, width: '120', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'description', label: '事件描述', visible: true, group: 'detail' },
        { prop: 'consequence', label: '后果', visible: true, group: 'detail' },
        { prop: 'handlingMeasure', label: '处理措施', visible: true, group: 'detail' },
        { prop: 'punishment', label: '处罚情况', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [{ prop: 'recordStatus', label: '记录状态', visible: true, group: 'status' }]
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

  return new FieldConfigManager('doctorAdverseRecord', fieldGroups);
}

// 医生教育字段配置
export function createDoctorEducationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, group: 'basic' },
        { prop: 'schoolName', label: '学校名称', visible: true, group: 'basic' },
        { prop: 'major', label: '专业', visible: true, group: 'basic' },
        { prop: 'educationLevel', label: '学历', visible: true, group: 'basic' },
        { prop: 'degree', label: '学位', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'startDate', label: '入学日期', visible: true, width: '120', group: 'time' },
        { prop: 'endDate', label: '毕业日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'education',
      label: '教育信息',
      fields: [
        { prop: 'isFullTime', label: '是否全日制', visible: true, group: 'education' },
        { prop: 'certificateNo', label: '证书编号', visible: true, group: 'education' },
        { prop: 'certificateUrl', label: '证书附件URL', visible: true, group: 'education' }
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

  return new FieldConfigManager('doctorEducation', fieldGroups);
}

// 医生电子注册字段配置
export function createDoctorElectronicRegistrationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, group: 'basic' },
        { prop: 'registrationNo', label: '注册编号', visible: true, group: 'basic' },
        { prop: 'registrationType', label: '注册类型', visible: true, group: 'basic' },
        { prop: 'practiceCategory', label: '执业类别', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'practice',
      label: '执业信息',
      fields: [
        { prop: 'practiceScope', label: '执业范围', visible: true, group: 'practice' },
        { prop: 'practiceLocation', label: '执业地点', visible: true, group: 'practice' },
        { prop: 'multiInstitutionFlag', label: '是否多机构备案', visible: true, group: 'practice' }
      ]
    },
    {
      name: 'validity',
      label: '有效期信息',
      fields: [
        { prop: 'issueDate', label: '发证日期', visible: true, width: '120', group: 'validity' },
        { prop: 'validDate', label: '有效期至', visible: true, width: '120', group: 'validity' },
        { prop: 'registrationAuthority', label: '注册机关', visible: true, group: 'validity' },
        { prop: 'registrationStatus', label: '注册状态', visible: true, group: 'validity' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'certificateUrl', label: '证书附件URL', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
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

  return new FieldConfigManager('doctorElectronicRegistration', fieldGroups);
}

// 医生伦理评估字段配置
export function createDoctorEthicsEvaluationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, group: 'basic' },
        { prop: 'evaluationYear', label: '考评年度', visible: true, group: 'basic' },
        { prop: 'evaluationCycle', label: '考评周期', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'score',
      label: '评分信息',
      fields: [
        { prop: 'selfScore', label: '自评得分', visible: true, group: 'score' },
        { prop: 'peerScore', label: '同行评议得分', visible: true, group: 'score' },
        { prop: 'patientScore', label: '患者评价得分', visible: true, group: 'score' },
        { prop: 'departmentScore', label: '科室评价得分', visible: true, group: 'score' },
        { prop: 'hospitalScore', label: '医院评价得分', visible: true, group: 'score' },
        { prop: 'totalScore', label: '总分', visible: true, group: 'score' }
      ]
    },
    {
      name: 'result',
      label: '评估结果',
      fields: [
        { prop: 'evaluationResult', label: '考评结果', visible: true, group: 'result' },
        { prop: 'rewardPunishment', label: '奖惩情况', visible: true, group: 'result' }
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
        { prop: 'createBy', label: '创建人', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('doctorEthicsEvaluation', fieldGroups);
}

// 医生保险代码字段配置
export function createDoctorInsuranceCodeFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, required: true, group: 'basic' },
        { prop: 'insuranceCode', label: '保险代码', visible: true, required: true, group: 'basic' },
        { prop: 'insuranceType', label: '保险类型', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'validity',
      label: '有效期信息',
      fields: [
        { prop: 'issueDate', label: '发证日期', visible: true, width: '120', group: 'validity' },
        { prop: 'expiryDate', label: '到期日期', visible: true, width: '120', group: 'validity' },
        { prop: 'renewalDate', label: '续保日期', visible: true, width: '120', group: 'validity' },
        { prop: 'status', label: '状态', visible: true, group: 'validity' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'insuranceCompany', label: '保险公司', visible: true, group: 'detail' },
        { prop: 'coverageAmount', label: '保额', visible: true, group: 'detail' },
        { prop: 'premium', label: '保费', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
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

  return new FieldConfigManager('doctorInsuranceCode', fieldGroups);
}

// 医生发表字段配置
export function createDoctorPublicationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, group: 'basic' },
        { prop: 'publicationType', label: '发表类型', visible: true, group: 'basic' },
        { prop: 'title', label: '标题', visible: true, group: 'basic' },
        { prop: 'authors', label: '作者', visible: true, group: 'basic' },
        { prop: 'authorOrder', label: '作者排序', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'publication',
      label: '发表信息',
      fields: [
        { prop: 'journalName', label: '期刊名称', visible: true, group: 'publication' },
        { prop: 'publishDate', label: '发表日期', visible: true, width: '120', group: 'publication' },
        { prop: 'volume', label: '卷号', visible: true, group: 'publication' },
        { prop: 'issue', label: '期号', visible: true, group: 'publication' },
        { prop: 'pages', label: '页码', visible: true, group: 'publication' }
      ]
    },
    {
      name: 'metrics',
      label: '指标信息',
      fields: [
        { prop: 'doi', label: 'DOI', visible: true, group: 'metrics' },
        { prop: 'impactFactor', label: '影响因子', visible: true, group: 'metrics' },
        { prop: 'citationCount', label: '引用次数', visible: true, group: 'metrics' },
        { prop: 'fullTextUrl', label: '全文URL', visible: true, group: 'metrics' }
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

  return new FieldConfigManager('doctorPublication', fieldGroups);
}

// 医生研究项目字段配置
export function createDoctorResearchProjectFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, group: 'basic' },
        { prop: 'projectName', label: '项目名称', visible: true, group: 'basic' },
        { prop: 'projectNo', label: '项目编号', visible: true, group: 'basic' },
        { prop: 'projectLevel', label: '项目级别', visible: true, group: 'basic' },
        { prop: 'projectType', label: '项目类型', visible: true, group: 'basic' },
        { prop: 'role', label: '承担角色', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'funding',
      label: '经费信息',
      fields: [
        { prop: 'fundingAmount', label: '资助金额', visible: true, group: 'funding' },
        { prop: 'startDate', label: '开始日期', visible: true, width: '120', group: 'funding' },
        { prop: 'endDate', label: '结束日期', visible: true, width: '120', group: 'funding' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [{ prop: 'status', label: '项目状态', visible: true, group: 'status' }]
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

  return new FieldConfigManager('doctorResearchProject', fieldGroups);
}

// 医生培训字段配置
export function createDoctorTrainingFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, group: 'basic' },
        { prop: 'trainingType', label: '培训类型', visible: true, group: 'basic' },
        { prop: 'trainingName', label: '培训名称', visible: true, group: 'basic' },
        { prop: 'trainingUnit', label: '培训单位', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'schedule',
      label: '时间安排',
      fields: [
        { prop: 'startDate', label: '开始日期', visible: true, width: '120', group: 'schedule' },
        { prop: 'endDate', label: '结束日期', visible: true, width: '120', group: 'schedule' },
        { prop: 'trainingHours', label: '培训学时', visible: true, group: 'schedule' }
      ]
    },
    {
      name: 'content',
      label: '培训内容',
      fields: [
        { prop: 'trainingContent', label: '培训内容', visible: true, group: 'content' },
        { prop: 'trainingResult', label: '培训结果', visible: true, group: 'content' }
      ]
    },
    {
      name: 'certificate',
      label: '证书信息',
      fields: [
        { prop: 'certificateNo', label: '证书编号', visible: true, group: 'certificate' },
        { prop: 'certificateUrl', label: '证书附件URL', visible: true, group: 'certificate' },
        { prop: 'credits', label: '学分', visible: true, group: 'certificate' }
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

  return new FieldConfigManager('doctorTraining', fieldGroups);
}

// 医生资格目录字段配置
export function createDoctorQualificationCatalogFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'catalogCode', label: '资格编码', visible: true, group: 'basic' },
        { prop: 'catalogName', label: '资格名称', visible: true, group: 'basic' },
        { prop: 'parentId', label: '父级ID', visible: true, group: 'basic' },
        { prop: 'catalogLevel', label: '目录层级', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'qualification',
      label: '资格信息',
      fields: [
        { prop: 'catalogType', label: '资质类型', visible: true, group: 'qualification' },
        { prop: 'subType', label: '资质子类型', visible: true, group: 'qualification' },
        { prop: 'operationCode', label: '手术操作编码', visible: true, group: 'qualification' },
        { prop: 'category', label: '类别', visible: true, group: 'qualification' },
        { prop: 'hospitalLevel', label: '院内手术等级', visible: true, group: 'qualification' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'description', label: '资质描述', visible: true, group: 'detail' },
        { prop: 'sortOrder', label: '排序', visible: true, group: 'detail' },
        { prop: 'isEnabled', label: '是否启用', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
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

  return new FieldConfigManager('doctorQualificationCatalog', fieldGroups);
}

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

// 肿瘤质控指标记录字段配置
export function createTumorQcIndicatorRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, group: 'basic' },
        { prop: 'indicatorCode', label: '指标编码', visible: true, group: 'basic' },
        { prop: 'recordDate', label: '记录日期', visible: true, width: '120', group: 'basic' },
        { prop: 'calculationCycle', label: '计算周期', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'data',
      label: '数据信息',
      fields: [
        { prop: 'indicatorValue', label: '指标值', visible: true, group: 'data' },
        { prop: 'targetValue', label: '目标值', visible: true, group: 'data' },
        { prop: 'numerator', label: '分子', visible: true, group: 'data' },
        { prop: 'denominator', label: '分母', visible: true, group: 'data' },
        { prop: 'completionRate', label: '完成率', visible: true, group: 'data' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'complianceStatus', label: '达标状态', visible: true, group: 'status' },
        { prop: 'isAbnormal', label: '是否异常', visible: true, group: 'status' },
        { prop: 'rankInHospital', label: '医院排名', visible: true, group: 'status' },
        { prop: 'trendDirection', label: '趋势方向', visible: true, group: 'status' }
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
      name: 'source',
      label: '数据来源',
      fields: [
        { prop: 'dataSource', label: '数据来源', visible: true, group: 'source' },
        { prop: 'isManual', label: '是否手动录入', visible: true, group: 'source' }
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

  return new FieldConfigManager('tumorQcIndicatorRecord', fieldGroups);
}

// 肿瘤质控报告字段配置
export function createTumorQcReportFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'reportCode', label: '报告编码', visible: true, required: true, group: 'basic' },
        { prop: 'reportTitle', label: '报告标题', visible: true, group: 'basic' },
        { prop: 'reportType', label: '报告类型', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'period',
      label: '周期',
      fields: [
        { prop: 'periodStart', label: '报告周期开始', visible: true, width: '120', group: 'period' },
        { prop: 'periodEnd', label: '报告周期结束', visible: true, width: '120', group: 'period' }
      ]
    },
    {
      name: 'content',
      label: '内容',
      fields: [
        { prop: 'reportContent', label: '报告内容', visible: true, group: 'content' },
        { prop: 'summary', label: '报告摘要', visible: true, group: 'content' },
        { prop: 'recommendations', label: '建议措施', visible: true, group: 'content' }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [
        { prop: 'status', label: '状态', visible: true, group: 'status' },
        { prop: 'publishTime', label: '发布时间', visible: true, width: '120', group: 'status' }
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

  return new FieldConfigManager('tumorQcReport', fieldGroups);
}
// 系统指标监控记录字段配置
export function createSystemIndicatorMonitorRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, required: true, group: 'basic' },
        { prop: 'recordDate', label: '记录日期', visible: true, width: '120', group: 'basic' },
        { prop: 'calculationCycle', label: '计算周期', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'data',
      label: '监控数据',
      fields: [
        { prop: 'currentValue', label: '当前值', visible: true, group: 'data' },
        { prop: 'targetValue', label: '目标值', visible: true, group: 'data' },
        { prop: 'thresholdValue', label: '阈值', visible: true, group: 'data' },
        { prop: 'deviation', label: '偏差', visible: true, group: 'data' },
        { prop: 'completionRate', label: '完成率(%)', visible: true, group: 'data' }
      ]
    },
    {
      name: 'alert',
      label: '告警信息',
      fields: [
        { prop: 'alertLevel', label: '告警级别', visible: true, group: 'alert' },
        { prop: 'alertMessage', label: '告警信息', visible: true, group: 'alert' },
        { prop: 'isResolved', label: '是否已解决', visible: true, group: 'alert' },
        { prop: 'isAlert', label: '是否预警', visible: true, group: 'alert' }
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
      name: 'system',
      label: '制度信息',
      fields: [
        { prop: 'systemId', label: '制度ID', visible: true, group: 'system' },
        { prop: 'systemCode', label: '制度编码', visible: true, group: 'system' },
        { prop: 'systemName', label: '制度名称', visible: true, group: 'system' },
        { prop: 'systemScore', label: '制度得分', visible: true, group: 'system' }
      ]
    },
    {
      name: 'other',
      label: '其他信息',
      fields: [
        { prop: 'indicatorValue', label: '指标值', visible: true, group: 'other' },
        { prop: 'indicatorScore', label: '指标得分', visible: true, group: 'other' },
        { prop: 'defectCount', label: '缺陷数', visible: true, group: 'other' },
        { prop: 'rankInHospital', label: '院内排名', visible: true, group: 'other' },
        { prop: 'trendDirection', label: '趋势方向', visible: true, group: 'other' },
        { prop: 'trendValue', label: '趋势值', visible: true, group: 'other' }
      ]
    },
    {
      name: 'system_fields',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system_fields' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system_fields' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system_fields' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system_fields' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system_fields' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system_fields' }
      ]
    }
  ];

  return new FieldConfigManager('systemIndicatorMonitorRecord', fieldGroups);
}

// 肿瘤质控方案字段配置
export function createTumorQcPlanFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'planCode', label: '方案编码', visible: true, required: true, group: 'basic' },
        { prop: 'planName', label: '方案名称', visible: true, group: 'basic' },
        { prop: 'planType', label: '方案类型', visible: true, group: 'basic' },
        { prop: 'description', label: '方案描述', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        { prop: 'startDate', label: '开始日期', visible: true, width: '120', group: 'time' },
        { prop: 'endDate', label: '结束日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [
        { prop: 'status', label: '状态', visible: true, group: 'status' },
        { prop: 'approvalStatus', label: '审批状态', visible: true, group: 'status' }
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
  return new FieldConfigManager('tumorQcPlan', fieldGroups);
}

// 肿瘤质控检查字段配置
export function createTumorQcInspectionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'inspectionCode', label: '检查编码', visible: true, required: true, group: 'basic' },
        { prop: 'inspectionDate', label: '检查日期', visible: true, width: '120', group: 'basic' },
        { prop: 'inspectorName', label: '检查人姓名', visible: true, group: 'basic' },
        { prop: 'departmentName', label: '检查科室名称', visible: true, group: 'basic' },
        { prop: 'inspectionType', label: '检查类型', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'result',
      label: '结果',
      fields: [
        { prop: 'inspectionResult', label: '检查结果', visible: true, group: 'result' },
        { prop: 'problemDescription', label: '问题描述', visible: true, group: 'result' },
        { prop: 'suggestion', label: '整改建议', visible: true, group: 'result' }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [{ prop: 'status', label: '状态', visible: true, group: 'status' }]
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
  return new FieldConfigManager('tumorQcInspection', fieldGroups);
}

// 肿瘤质控整改字段配置
export function createTumorQcRectificationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'rectificationCode', label: '整改编码', visible: true, required: true, group: 'basic' },
        { prop: 'problemDescription', label: '问题描述', visible: true, group: 'basic' },
        { prop: 'rectificationMeasures', label: '整改措施', visible: true, group: 'basic' },
        { prop: 'responsiblePersonName', label: '负责人姓名', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        { prop: 'deadline', label: '整改期限', visible: true, width: '120', group: 'time' },
        { prop: 'completionTime', label: '完成时间', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'result',
      label: '结果',
      fields: [
        { prop: 'rectificationResult', label: '整改结果', visible: true, group: 'result' },
        { prop: 'verificationStatus', label: '验证状态', visible: true, group: 'result' }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [
        { prop: 'status', label: '状态', visible: true, group: 'status' },
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'status' }
      ]
    }
  ];
  return new FieldConfigManager('tumorQcRectification', fieldGroups);
}

// 重大手术申请字段配置
export function createMajorSurgeryApplicationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'applicationNo', label: '申请编号', visible: true, required: true, group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, group: 'basic' },
        { prop: 'doctorName', label: '申请医师姓名', visible: true, group: 'basic' },
        { prop: 'departmentName', label: '申请科室名称', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'surgery',
      label: '手术信息',
      fields: [
        { prop: 'surgeryName', label: '拟手术名称', visible: true, group: 'surgery' },
        { prop: 'surgeryReason', label: '手术原因', visible: true, group: 'surgery' },
        { prop: 'surgeryRisk', label: '手术风险', visible: true, group: 'surgery' },
        { prop: 'expectedTime', label: '预计手术时间', visible: true, width: '180', group: 'surgery' }
      ]
    },
    {
      name: 'approval',
      label: '审批信息',
      fields: [
        { prop: 'applicationStatus', label: '申请状态', visible: true, group: 'approval' },
        { prop: 'approvalOpinion', label: '审批意见', visible: true, group: 'approval' },
        { prop: 'approverName', label: '审批人姓名', visible: true, group: 'approval' },
        { prop: 'approvalTime', label: '审批时间', visible: true, width: '180', group: 'approval' }
      ]
    },
    {
      name: 'other',
      label: '其他',
      fields: [
        { prop: 'attachments', label: '附件', visible: true, group: 'other' },
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'other' }
      ]
    }
  ];
  return new FieldConfigManager('majorSurgeryApplication', fieldGroups);
}

// 手术工作量统计字段配置
export function createSurgeryWorkloadStatisticsFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorName', label: '医师姓名', visible: true, group: 'basic' },
        { prop: 'surgeryCode', label: '手术编码', visible: true, group: 'basic' },
        { prop: 'surgeryName', label: '手术名称', visible: true, group: 'basic' },
        { prop: 'surgeryLevel', label: '手术级别', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'workload',
      label: '工作量',
      fields: [
        { prop: 'surgeryCount', label: '手术数量', visible: true, group: 'workload' },
        { prop: 'mainOperatorCount', label: '主刀次数', visible: true, group: 'workload' },
        { prop: 'firstAssistantCount', label: '一助次数', visible: true, group: 'workload' }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        { prop: 'statisticsYear', label: '统计年份', visible: true, group: 'time' },
        { prop: 'statisticsMonth', label: '统计月份', visible: true, group: 'time' }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [{ prop: 'delFlag', label: '删除标志', visible: true, group: 'status' }]
    }
  ];
  return new FieldConfigManager('surgeryWorkloadStatistics', fieldGroups);
}
// 新技术案例字段配置
export function createNewTechnologyCaseFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'caseTitle', label: '案例标题', visible: true, required: true, group: 'basic' },
        { prop: 'caseCode', label: '案例编码', visible: true, group: 'basic' },
        { prop: 'technologyType', label: '技术类型', visible: true, group: 'basic' },
        { prop: 'difficultyLevel', label: '难度等级', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'caseDescription', label: '案例描述', visible: true, group: 'detail' },
        { prop: 'clinicalApplication', label: '临床应用', visible: true, group: 'detail' },
        { prop: 'technicalFeatures', label: '技术特点', visible: true, group: 'detail' },
        { prop: 'expectedOutcomes', label: '预期结果', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'operator',
      label: '操作信息',
      fields: [
        { prop: 'operator', label: '操作医生', visible: true, group: 'operator' },
        { prop: 'operationDate', label: '操作日期', visible: true, width: '120', group: 'operator' },
        { prop: 'operationTime', label: '操作时间', visible: true, width: '120', group: 'operator' }
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

  return new FieldConfigManager('newTechnologyCase', fieldGroups);
}

// 新技术目录字段配置
export function createNewTechnologyCatalogFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'catalogCode', label: '目录编码', visible: true, required: true, group: 'basic' },
        { prop: 'catalogName', label: '目录名称', visible: true, required: true, group: 'basic' },
        { prop: 'catalogLevel', label: '目录级别', visible: true, group: 'basic' },
        { prop: 'parentId', label: '父级ID', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'order',
      label: '排序信息',
      fields: [{ prop: 'orderNum', label: '排序号', visible: true, group: 'order' }]
    },
    {
      name: 'remark',
      label: '备注信息',
      fields: [{ prop: 'remark', label: '备注', visible: true, group: 'remark' }]
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

  return new FieldConfigManager('newTechnologyCatalog', fieldGroups);
}

// 资格考试记录字段配置
export function createQualificationExamRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'examId', label: '考试ID', visible: true, group: 'basic' },
        { prop: 'examName', label: '考试名称', visible: true, required: true, group: 'basic' },
        { prop: 'candidateId', label: '考生ID', visible: true, group: 'basic' },
        { prop: 'candidateName', label: '考生姓名', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'score',
      label: '成绩信息',
      fields: [
        { prop: 'totalScore', label: '总分', visible: true, group: 'score' },
        { prop: 'passingScore', label: '及格分数', visible: true, group: 'score' },
        { prop: 'scoreDetails', label: '分数详情', visible: true, group: 'score' },
        { prop: 'ranking', label: '排名', visible: true, group: 'score' }
      ]
    },
    {
      name: 'result',
      label: '考试结果',
      fields: [
        { prop: 'examResult', label: '考试结果', visible: true, group: 'result' },
        { prop: 'certificateNumber', label: '证书编号', visible: true, group: 'result' },
        { prop: 'issueDate', label: '发证日期', visible: true, width: '120', group: 'result' }
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

  return new FieldConfigManager('qualificationExamRecord', fieldGroups);
}

// 科室资质目录字段配置
export function createDepartmentQualificationCatalogFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, group: 'basic' },
        { prop: 'departmentId', label: '科室ID', visible: true, group: 'basic' },
        { prop: 'qualificationId', label: '资质ID', visible: true, group: 'basic' },
        { prop: 'qualificationType', label: '资质类型', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'isEnabled', label: '是否启用', visible: true, group: 'status' },
        { prop: 'approveStatus', label: '审批状态', visible: true, group: 'status' }
      ]
    },
    {
      name: 'approval',
      label: '审批信息',
      fields: [
        { prop: 'approveTime', label: '审批时间', visible: true, width: '180', group: 'approval' },
        { prop: 'approveBy', label: '审批人', visible: true, group: 'approval' }
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
        { prop: 'createBy', label: '创建人', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, group: 'system' }
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

// 肿瘤QC指标配置字段配置
export function createTumorQcIndicatorConfigFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, required: true, group: 'basic' },
        { prop: 'indicatorCode', label: '指标编码', visible: true, group: 'basic' },
        { prop: 'indicatorType', label: '指标类型', visible: true, group: 'basic' },
        { prop: 'category', label: '分类', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'standard',
      label: '标准信息',
      fields: [
        { prop: 'standardValue', label: '标准值', visible: true, group: 'standard' },
        { prop: 'upperLimit', label: '上限', visible: true, group: 'standard' },
        { prop: 'lowerLimit', label: '下限', visible: true, group: 'standard' },
        { prop: 'unit', label: '单位', visible: true, group: 'standard' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'description', label: '描述', visible: true, group: 'detail' },
        { prop: 'calculationMethod', label: '计算方法', visible: true, group: 'detail' },
        { prop: 'frequency', label: '频率', visible: true, group: 'detail' },
        { prop: 'status', label: '状态', visible: true, group: 'detail' }
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

  return new FieldConfigManager('tumorQcIndicatorConfig', fieldGroups);
}

// 肿瘤QC指标详情字段配置
export function createTumorQcIndicatorDetailFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'recordId', label: '监测记录ID', visible: true, group: 'basic' },
        { prop: 'indicatorId', label: '指标ID', visible: true, group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'medical',
      label: '医疗信息',
      fields: [
        { prop: 'visitNo', label: '就诊号', visible: true, group: 'medical' },
        { prop: 'diagnosis', label: '诊断', visible: true, group: 'medical' },
        { prop: 'indicatorResult', label: '指标结果', visible: true, group: 'medical' },
        { prop: 'resultDescription', label: '结果说明', visible: true, group: 'medical' },
        { prop: 'relatedData', label: '相关数据', visible: true, group: 'medical' }
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

  return new FieldConfigManager('tumorQcIndicatorDetail', fieldGroups);
}

// 医生能力评估字段配置
export function createDoctorAbilityAssessmentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'assessmentYear', label: '评估年度', visible: true, required: true, group: 'basic' },
        { prop: 'assessmentType', label: '评估类型', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'scores',
      label: '能力得分',
      fields: [
        { prop: 'clinicalAbilityScore', label: '临床能力得分', visible: true, group: 'scores' },
        { prop: 'teachingAbilityScore', label: '教学能力得分', visible: true, group: 'scores' },
        { prop: 'researchAbilityScore', label: '科研能力得分', visible: true, group: 'scores' },
        { prop: 'managementAbilityScore', label: '管理能力得分', visible: true, group: 'scores' },
        { prop: 'totalScore', label: '总分', visible: true, group: 'scores' }
      ]
    },
    {
      name: 'result',
      label: '评估结果',
      fields: [
        { prop: 'assessmentResult', label: '评估结果', visible: true, group: 'result' },
        { prop: 'assessor', label: '评估人', visible: true, group: 'result' },
        { prop: 'assessmentDate', label: '评估日期', visible: true, width: '180', group: 'result' },
        { prop: 'remark', label: '评估意见', visible: true, group: 'result' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, width: '180', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, width: '180', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('doctorAbilityAssessment', fieldGroups);
}
// 医生不良记录字段配置
export function createDoctorAdverseRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基本信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'basic' },
        { prop: 'recordType', label: '记录类型', visible: true, group: 'basic' },
        { prop: 'recordTitle', label: '记录标题', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细内容',
      fields: [
        { prop: 'occurDate', label: '发生日期', visible: true, width: '180', group: 'detail' },
        { prop: 'description', label: '事件描述', visible: true, group: 'detail' },
        { prop: 'consequence', label: '后果', visible: true, group: 'detail' },
        { prop: 'handlingMeasure', label: '处理措施', visible: true, group: 'detail' },
        { prop: 'punishment', label: '处罚结果', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [{ prop: 'recordStatus', label: '记录状态', visible: true, group: 'status' }]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, width: '180', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, width: '180', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('doctorAdverseRecord', fieldGroups);
}

// 医生证书字段配置
export function createDoctorCertificateFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基本信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, required: true, group: 'basic' },
        { prop: 'certificateName', label: '证书名称', visible: true, required: true, group: 'basic' },
        { prop: 'certificateNo', label: '证书号', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'issue',
      label: '发证信息',
      fields: [
        { prop: 'issueUnit', label: '发证单位', visible: true, group: 'issue' },
        { prop: 'issueDate', label: '发证日期', visible: true, width: '180', group: 'issue' },
        { prop: 'validDate', label: '有效日期', visible: true, width: '180', group: 'issue' },
        { prop: 'isPermanent', label: '是否永久有效', visible: true, group: 'issue' },
        { prop: 'remindDays', label: '提前提醒天数', visible: true, group: 'issue' }
      ]
    },
    {
      name: 'attachment',
      label: '附件信息',
      fields: [{ prop: 'certificateUrl', label: '证书附件URL', visible: true, group: 'attachment' }]
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
        { prop: 'createTime', label: '创建时间', visible: true, width: '180', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, width: '180', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('doctorCertificate', fieldGroups);
}

// 新技术延期申请字段配置
export function createNewTechnologyExtensionApplyFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'applyNo', label: '申请编号', visible: true, required: true, group: 'basic' },
        { prop: 'projectId', label: '项目ID', visible: true, group: 'basic' },
        { prop: 'originalEndDate', label: '原结束日期', visible: true, width: '120', group: 'basic' },
        { prop: 'extendDays', label: '延期天数', visible: true, group: 'basic' },
        { prop: 'newEndDate', label: '新结束日期', visible: true, width: '120', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'extensionReason', label: '延期理由', visible: true, group: 'detail' },
        { prop: 'applyStatus', label: '申请状态', visible: true, group: 'detail' },
        { prop: 'workflowInstanceId', label: '工作流实例ID', visible: true, group: 'detail' }
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

  return new FieldConfigManager('newTechnologyExtensionApply', fieldGroups);
}

// 新技术项目映射字段配置
export function createNewTechnologyMappingFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'projectId', label: '项目ID', visible: true, required: true, group: 'basic' },
        { prop: 'mappingType', label: '对码类型', visible: true, group: 'basic' },
        { prop: 'sourceCode', label: '源编码', visible: true, group: 'basic' },
        { prop: 'sourceName', label: '源名称', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'target',
      label: '目标信息',
      fields: [{ prop: 'targetSystem', label: '目标系统', visible: true, group: 'target' }]
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

  return new FieldConfigManager('newTechnologyMapping', fieldGroups);
}

// 新技术进展报告字段配置
export function createNewTechnologyProgressReportFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'reportNo', label: '报告编号', visible: true, required: true, group: 'basic' },
        { prop: 'projectId', label: '项目ID', visible: true, group: 'basic' },
        { prop: 'reportType', label: '报告类型', visible: true, group: 'basic' },
        { prop: 'reportPeriod', label: '报告期间', visible: true, group: 'basic' },
        { prop: 'reportDate', label: '报告日期', visible: true, width: '120', group: 'basic' }
      ]
    },
    {
      name: 'data',
      label: '数据统计',
      fields: [
        { prop: 'caseCount', label: '开展病例数', visible: true, group: 'data' },
        { prop: 'successCount', label: '成功病例数', visible: true, group: 'data' },
        { prop: 'complicationCount', label: '并发症例数', visible: true, group: 'data' },
        { prop: 'adverseReactionCount', label: '不良反应例数', visible: true, group: 'data' },
        { prop: 'mortalityCount', label: '死亡例数', visible: true, group: 'data' }
      ]
    },
    {
      name: 'evaluation',
      label: '评价信息',
      fields: [
        { prop: 'effectEvaluation', label: '效果评价', visible: true, group: 'evaluation' },
        { prop: 'existingProblems', label: '存在问题', visible: true, group: 'evaluation' },
        { prop: 'improvementMeasures', label: '改进措施', visible: true, group: 'evaluation' },
        { prop: 'nextPlan', label: '下步计划', visible: true, group: 'evaluation' },
        { prop: 'continueStatus', label: '继续状态', visible: true, group: 'evaluation' }
      ]
    },
    {
      name: 'attachment',
      label: '附件信息',
      fields: [
        { prop: 'monitoringIndicators', label: '运行监测指标JSON', visible: true, group: 'attachment' },
        { prop: 'attachmentUrls', label: '附件URLs', visible: true, group: 'attachment' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'reportStatus', label: '报告状态', visible: true, group: 'status' },
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

  return new FieldConfigManager('newTechnologyProgressReport', fieldGroups);
}

// 新技术项目字段配置
export function createNewTechnologyProjectFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'projectNo', label: '项目编号', visible: true, required: true, group: 'basic' },
        { prop: 'projectName', label: '项目名称', visible: true, required: true, group: 'basic' },
        { prop: 'projectType', label: '项目类型', visible: true, group: 'basic' },
        { prop: 'technologyCategory', label: '技术分类', visible: true, group: 'basic' },
        { prop: 'riskLevel', label: '风险等级', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'department',
      label: '科室信息',
      fields: [
        { prop: 'applyDepartmentId', label: '申请科室ID', visible: true, group: 'department' },
        { prop: 'applyDepartmentName', label: '申请科室名称', visible: true, group: 'department' }
      ]
    },
    {
      name: 'team',
      label: '团队信息',
      fields: [
        { prop: 'projectLeader', label: '项目负责人', visible: true, group: 'team' },
        { prop: 'projectTeam', label: '项目团队成员', visible: true, group: 'team' }
      ]
    },
    {
      name: 'technical',
      label: '技术信息',
      fields: [
        { prop: 'technologySource', label: '技术来源', visible: true, group: 'technical' },
        { prop: 'applyReason', label: '申请理由', visible: true, group: 'technical' },
        { prop: 'technologyDescription', label: '技术描述', visible: true, group: 'technical' },
        { prop: 'indication', label: '适应症', visible: true, group: 'technical' },
        { prop: 'contraindication', label: '禁忌症', visible: true, group: 'technical' },
        { prop: 'expectedEffect', label: '预期效果', visible: true, group: 'technical' }
      ]
    },
    {
      name: 'risk',
      label: '风险信息',
      fields: [
        { prop: 'potentialRisk', label: '潜在风险', visible: true, group: 'risk' },
        { prop: 'riskControlMeasure', label: '风险控制措施', visible: true, group: 'risk' }
      ]
    },
    {
      name: 'support',
      label: '支撑信息',
      fields: [
        { prop: 'literatureSupport', label: '文献支持', visible: true, group: 'support' },
        { prop: 'attachmentUrls', label: '附件URLs', visible: true, group: 'support' }
      ]
    },
    {
      name: 'schedule',
      label: '进度信息',
      fields: [
        { prop: 'operationCycleDays', label: '运行周期(天)', visible: true, group: 'schedule' },
        { prop: 'progressReportCycle', label: '进展报告周期', visible: true, group: 'schedule' },
        { prop: 'projectStatus', label: '项目状态', visible: true, group: 'schedule' },
        { prop: 'approveDate', label: '批准日期', visible: true, width: '120', group: 'schedule' },
        { prop: 'startDate', label: '开始日期', visible: true, width: '120', group: 'schedule' },
        { prop: 'endDate', label: '预计结束日期', visible: true, width: '120', group: 'schedule' },
        { prop: 'actualEndDate', label: '实际结束日期', visible: true, width: '120', group: 'schedule' },
        { prop: 'conclusionType', label: '结题类型', visible: true, group: 'schedule' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'workflowInstanceId', label: '工作流实例ID', visible: true, group: 'system' },
        { prop: 'delFlag', label: '是否删除', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('newTechnologyProject', fieldGroups);
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

// 待办任务字段配置
export function createTodoTaskFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'taskNo', label: '任务编号', visible: true, required: true, group: 'basic' },
        { prop: 'taskType', label: '任务类型', visible: true, group: 'basic' },
        { prop: 'taskCategory', label: '任务分类', visible: true, group: 'basic' },
        { prop: 'taskTitle', label: '任务标题', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'content',
      label: '内容信息',
      fields: [
        { prop: 'taskContent', label: '任务内容', visible: true, group: 'content' },
        { prop: 'taskDescription', label: '任务详细描述', visible: true, group: 'content' },
        { prop: 'taskSource', label: '任务来源模块', visible: true, group: 'content' },
        { prop: 'sourceBusinessType', label: '来源业务类型', visible: true, group: 'content' },
        { prop: 'handleOpinion', label: '处理意见', visible: true, group: 'content' },
        { prop: 'handleAttachmentUrls', label: '处理附件URLs', visible: true, group: 'content' },
        { prop: 'attachmentUrls', label: '任务附件URLs', visible: true, group: 'content' },
        { prop: 'tags', label: '任务标签', visible: true, group: 'content' },
        { prop: 'remark', label: '备注', visible: true, group: 'content' },
        { prop: 'extInfo', label: '扩展信息JSON', visible: true, group: 'content' }
      ]
    },
    {
      name: 'relation',
      label: '关联信息',
      fields: [
        { prop: 'relatedId', label: '关联业务主键ID', visible: true, group: 'relation' },
        { prop: 'relatedNo', label: '关联业务编号', visible: true, group: 'relation' },
        { prop: 'relatedUrl', label: '关联业务详情URL', visible: true, group: 'relation' },
        { prop: 'workflowInstanceId', label: '工作流实例ID', visible: true, group: 'relation' },
        { prop: 'workflowNodeId', label: '工作流节点ID', visible: true, group: 'relation' },
        { prop: 'workflowNodeName', label: '工作流节点名称', visible: true, group: 'relation' }
      ]
    },
    {
      name: 'assignment',
      label: '分配信息',
      fields: [
        { prop: 'assignFromUserId', label: '分配人ID', visible: true, group: 'assignment' },
        { prop: 'assignFromUserName', label: '分配人姓名', visible: true, group: 'assignment' },
        { prop: 'assignToUserId', label: '分配给用户ID', visible: true, group: 'assignment' },
        { prop: 'assignToUserName', label: '分配给用户姓名', visible: true, group: 'assignment' },
        { prop: 'assignToDepartmentId', label: '分配给科室ID', visible: true, group: 'assignment' },
        { prop: 'assignToDepartmentName', label: '分配给科室名称', visible: true, group: 'assignment' },
        { prop: 'assignTime', label: '分配时间', visible: true, width: '180', group: 'assignment' },
        { prop: 'delegateToUserId', label: '委托给用户ID', visible: true, group: 'assignment' },
        { prop: 'delegateToUserName', label: '委托给用户姓名', visible: true, group: 'assignment' },
        { prop: 'delegateTime', label: '委托时间', visible: true, width: '180', group: 'assignment' },
        { prop: 'delegateReason', label: '委托原因', visible: true, group: 'assignment' }
      ]
    },
    {
      name: 'schedule',
      label: '时间安排',
      fields: [
        { prop: 'startTime', label: '开始处理时间', visible: true, width: '180', group: 'schedule' },
        { prop: 'deadline', label: '截止时间', visible: true, width: '180', group: 'schedule' },
        { prop: 'remindTime', label: '提醒时间', visible: true, width: '180', group: 'schedule' },
        { prop: 'readTime', label: '阅读时间', visible: true, width: '180', group: 'schedule' },
        { prop: 'handleTime', label: '处理时间', visible: true, width: '180', group: 'schedule' },
        { prop: 'completeTime', label: '完成时间', visible: true, width: '180', group: 'schedule' },
        { prop: 'remindedTime', label: '提醒发送时间', visible: true, width: '180', group: 'schedule' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'taskStatus', label: '任务状态', visible: true, group: 'status' },
        { prop: 'processStatus', label: '处理进度状态', visible: true, group: 'status' },
        { prop: 'readStatus', label: '阅读状态', visible: true, group: 'status' },
        { prop: 'priority', label: '优先级', visible: true, group: 'status' },
        { prop: 'handleResult', label: '处理结果', visible: true, group: 'status' },
        { prop: 'completeDuration', label: '处理时长(分钟)', visible: true, group: 'status' },
        { prop: 'isOverdue', label: '是否逾期', visible: true, group: 'status' },
        { prop: 'overdueDuration', label: '逾期时长(分钟)', visible: true, group: 'status' },
        { prop: 'isDelegated', label: '是否已委托', visible: true, group: 'status' },
        { prop: 'isRemind', label: '是否提醒', visible: true, group: 'status' },
        { prop: 'remindType', label: '提醒方式', visible: true, group: 'status' },
        { prop: 'isReminded', label: '是否已提醒', visible: true, group: 'status' },
        { prop: 'remindCount', label: '提醒次数', visible: true, group: 'status' },
        { prop: 'progress', label: '进度', visible: true, group: 'status' }
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

  return new FieldConfigManager('todoTask', fieldGroups);
}

// 公告阅读记录字段配置
export function createAnnouncementReadRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'announcementId', label: '公告ID', visible: true, required: true, group: 'basic' },
        { prop: 'userId', label: '用户ID', visible: true, group: 'basic' },
        { prop: 'userName', label: '用户名', visible: true, group: 'basic' },
        { prop: 'readTime', label: '阅读时间', visible: true, width: '180', group: 'basic' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'readStatus', label: '阅读状态', visible: true, group: 'status' },
        { prop: 'isRead', label: '是否已读', visible: true, group: 'status' }
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

  return new FieldConfigManager('announcementReadRecord', fieldGroups);
}

// 肿瘤质控结果字段配置
export function createTumorQcResultFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'resultCode', label: '结果编码', visible: true, required: true, group: 'basic' },
        { prop: 'indicatorName', label: '指标名称', visible: true, group: 'basic' },
        { prop: 'periodStart', label: '统计周期开始', visible: true, width: '120', group: 'basic' },
        { prop: 'periodEnd', label: '统计周期结束', visible: true, width: '120', group: 'basic' }
      ]
    },
    {
      name: 'value',
      label: '数值',
      fields: [
        { prop: 'resultValue', label: '结果值', visible: true, group: 'value' },
        { prop: 'targetValue', label: '目标值', visible: true, group: 'value' },
        { prop: 'complianceRate', label: '达标率', visible: true, group: 'value' },
        { prop: 'analysis', label: '结果分析', visible: true, group: 'value' }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [
        { prop: 'status', label: '状态', visible: true, group: 'status' },
        { prop: 'delFlag', label: '是否删除', visible: true, group: 'status' }
      ]
    }
  ];
  return new FieldConfigManager('tumorQcResult', fieldGroups);
}
// 质控指标收集配置字段配置
export function createQcIndicatorCollectionConfigFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础',
      fields: [
        { prop: 'indicatorId', label: '指标ID', visible: true, required: true, group: 'basic' },
        { prop: 'sourceSystem', label: '来源系统', visible: true, group: 'basic' },
        { prop: 'sourceTable', label: '来源表', visible: true, group: 'basic' },
        { prop: 'sourceField', label: '来源字段', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'rule',
      label: '规则',
      fields: [
        { prop: 'extractionRule', label: '提取规则', visible: true, group: 'rule' },
        { prop: 'validationRule', label: '校验规则', visible: true, group: 'rule' },
        { prop: 'dataType', label: '数据类型', visible: true, group: 'rule' },
        { prop: 'defaultValue', label: '默认值', visible: true, group: 'rule' }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [
        { prop: 'isRequired', label: '是否必需', visible: true, group: 'status' },
        { prop: 'delFlag', label: '是否删除', visible: true, group: 'status' }
      ]
    }
  ];
  return new FieldConfigManager('qcIndicatorCollectionConfig', fieldGroups);
}

// 核心制度指标字段配置
export function createCoreSystemIndicatorFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, group: 'basic' },
        { prop: 'indicatorCode', label: '指标编码', visible: true, required: true, group: 'basic', minWidth: 120 },
        { prop: 'indicatorName', label: '指标名称', visible: true, required: true, group: 'basic', minWidth: 150 },
        { prop: 'systemId', label: '所属制度ID', visible: true, group: 'basic' },
        { prop: 'parentId', label: '父指标ID', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'calculation',
      label: '计算信息',
      fields: [
        { prop: 'indicatorType', label: '指标类型', visible: true, group: 'calculation', minWidth: 100 },
        { prop: 'calculationFormula', label: '计算公式', visible: true, group: 'calculation', minWidth: 200 },
        { prop: 'calculationCycle', label: '计算周期', visible: true, group: 'calculation', minWidth: 100 },
        { prop: 'dataSource', label: '数据来源', visible: true, group: 'calculation', minWidth: 150 }
      ]
    },
    {
      name: 'target',
      label: '目标信息',
      fields: [
        { prop: 'targetValue', label: '目标值', visible: true, group: 'target', minWidth: 100 },
        { prop: 'indicatorScore', label: '指标分值', visible: true, group: 'target', minWidth: 100 },
        { prop: 'isReverse', label: '是否反向指标', visible: true, group: 'target', minWidth: 120 },
        { prop: 'alertThreshold', label: '预警阈值', visible: true, group: 'target', minWidth: 100 }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'isEnabled', label: '是否启用', visible: true, group: 'status', minWidth: 100 },
        { prop: 'isCustom', label: '是否自定义', visible: true, group: 'status', minWidth: 120 }
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
        { prop: 'createTime', label: '创建时间', visible: true, width: '180', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, width: '180', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('coreSystemIndicator', fieldGroups);
}

// 公告字段配置
export function createAnnouncementFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, group: 'basic' },
        { prop: 'announcementNo', label: '公告编号', visible: true, required: true, group: 'basic' },
        { prop: 'announcementType', label: '公告类型', visible: true, group: 'basic' },
        { prop: 'announcementTitle', label: '公告标题', visible: true, group: 'basic' },
        { prop: 'announcementContent', label: '公告内容', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'publish',
      label: '发布信息',
      fields: [
        { prop: 'publishScope', label: '发布范围', visible: true, group: 'publish' },
        { prop: 'targetDepartments', label: '目标科室', visible: true, group: 'publish' },
        { prop: 'targetUsers', label: '目标人员', visible: true, group: 'publish' },
        { prop: 'priority', label: '优先级', visible: true, group: 'publish' },
        { prop: 'publishTime', label: '发布时间', visible: true, width: '180', group: 'publish' },
        { prop: 'expireTime', label: '过期时间', visible: true, width: '180', group: 'publish' },
        { prop: 'publisher', label: '发布人', visible: true, group: 'publish' }
      ]
    },
    {
      name: 'attachment',
      label: '附件信息',
      fields: [
        { prop: 'attachmentUrls', label: '附件', visible: true, group: 'attachment' },
        { prop: 'isPopup', label: '是否弹窗', visible: true, group: 'attachment' },
        { prop: 'readCount', label: '阅读数', visible: true, group: 'attachment' },
        { prop: 'status', label: '状态', visible: true, group: 'attachment' }
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
        { prop: 'delFlag', label: '是否删除', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, width: '180', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, width: '180', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('announcement', fieldGroups);
}

// 手术记录字段配置
export function createSurgeryRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '主刀医生姓名', visible: true, group: 'basic' },
        { prop: 'departmentName', label: '手术科室名称', visible: true, group: 'basic' },
        { prop: 'surgeryCode', label: '手术编码', visible: true, group: 'basic' },
        { prop: 'surgeryName', label: '手术名称', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'surgery',
      label: '手术信息',
      fields: [
        { prop: 'surgeryLevel', label: '手术等级', visible: true, group: 'surgery' },
        { prop: 'surgeryType', label: '手术类型', visible: true, group: 'surgery' },
        { prop: 'anesthesiaMethod', label: '麻醉方式', visible: true, group: 'surgery' },
        { prop: 'surgeryStartTime', label: '手术开始时间', visible: true, width: '180', group: 'surgery' },
        { prop: 'surgeryEndTime', label: '手术结束时间', visible: true, width: '180', group: 'surgery' },
        { prop: 'surgeryDuration', label: '手术时长(分钟)', visible: true, group: 'surgery' }
      ]
    },
    {
      name: 'medical',
      label: '医疗信息',
      fields: [
        { prop: 'asaGrade', label: 'ASA分级', visible: true, group: 'medical' },
        { prop: 'bloodLoss', label: '失血量(ml)', visible: true, group: 'medical' },
        { prop: 'surgeryStatus', label: '手术状态', visible: true, group: 'medical' },
        { prop: 'complicationFlag', label: '是否有并发症', visible: true, group: 'medical' }
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

  return new FieldConfigManager('surgeryRecord', fieldGroups);
}

// 手术并发症记录字段配置
export function createSurgeryComplicationRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'surgeryRecordId', label: '手术记录ID', visible: true, group: 'basic' },
        { prop: 'doctorName', label: '医师姓名', visible: true, group: 'basic' },
        { prop: 'surgeryCode', label: '手术编码', visible: true, group: 'basic' },
        { prop: 'surgeryName', label: '手术名称', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'complication',
      label: '并发症信息',
      fields: [
        { prop: 'complicationType', label: '并发症类型', visible: true, group: 'complication' },
        { prop: 'complicationDescription', label: '并发症描述', visible: true, group: 'complication' },
        { prop: 'complicationLevel', label: '并发症等级', visible: true, group: 'complication' },
        { prop: 'occurrenceTime', label: '发生时间', visible: true, width: '180', group: 'complication' },
        { prop: 'isPlannedSecondary', label: '是否为非计划二次手术', visible: true, group: 'complication' }
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

  return new FieldConfigManager('surgeryComplicationRecord', fieldGroups);
}

// 手术团队字段配置
export function createSurgeryTeamFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'surgeryRecordId', label: '手术记录ID', visible: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'basic' },
        { prop: 'roleType', label: '角色类型 主刀/一助/二助/巡回护士/器械护士/麻醉师', visible: true, group: 'basic' },
        { prop: 'qualificationVerify', label: '资格验证 1-已验证 0-未验证', visible: true, group: 'basic' }
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

  return new FieldConfigManager('surgeryTeam', fieldGroups);
}

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

// 手术视频字段配置
export function createSurgeryVideoFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'videoNo', label: '视频编号', visible: true, group: 'basic' },
        { prop: 'videoTitle', label: '视频标题', visible: true, group: 'basic' },
        { prop: 'videoType', label: '视频类型 手术全程/关键步骤/教学片段', visible: true, group: 'basic' },
        { prop: 'videoUrl', label: '视频URL', visible: true, group: 'basic' },
        { prop: 'videoDuration', label: '视频时长(秒)', visible: true, group: 'basic' },
        { prop: 'videoSize', label: '视频大小(字节)', visible: true, group: 'basic' },
        { prop: 'videoFormat', label: '视频格式', visible: true, group: 'basic' },
        { prop: 'recordingDevice', label: '录制设备', visible: true, group: 'basic' },
        { prop: 'recordingDoctorName', label: '录制医生姓名', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间',
      fields: [
        { prop: 'uploadTime', label: '上传时间', visible: true, width: '180', group: 'time' },
        { prop: 'reviewTime', label: '审核时间', visible: true, width: '180', group: 'time' }
      ]
    },
    {
      name: 'status',
      label: '状态',
      fields: [
        { prop: 'reviewStatus', label: '审核状态 pending-待审核 approved-已通过 rejected-已拒绝', visible: true, group: 'status' },
        { prop: 'accessLevel', label: '访问级别 internal-院内 public-公开 restricted-受限', visible: true, group: 'status' }
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

  return new FieldConfigManager('surgeryVideo', fieldGroups);
}

// 重要医疗事件字段配置
export function createImportantMedicalEventFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'eventNo', label: '事件编号', visible: true, group: 'basic' },
        { prop: 'eventType', label: '事件类型', visible: true, group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, group: 'basic' },
        { prop: 'visitNo', label: '就诊号', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'medical',
      label: '医疗信息',
      fields: [
        { prop: 'departmentId', label: '科室ID', visible: true, group: 'medical' },
        { prop: 'departmentName', label: '科室名称', visible: true, group: 'medical' },
        { prop: 'responsibleDoctor', label: '责任医生', visible: true, group: 'medical' },
        { prop: 'eventTime', label: '事件时间', visible: true, width: '180', group: 'medical' },
        { prop: 'eventDescription', label: '事件描述', visible: true, group: 'medical' },
        { prop: 'eventLevel', label: '事件级别', visible: true, group: 'medical' }
      ]
    },
    {
      name: 'notification',
      label: '通知信息',
      fields: [{ prop: 'notifyUsers', label: '通知人员', visible: true, group: 'notification' }]
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

  return new FieldConfigManager('importantMedicalEvent', fieldGroups);
}

// 移动设备字段配置
export function createMobileDeviceFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'userId', label: '用户ID', visible: true, group: 'basic' },
        { prop: 'deviceId', label: '设备ID', visible: true, group: 'basic' },
        { prop: 'deviceType', label: '设备类型', visible: true, group: 'basic' },
        { prop: 'deviceModel', label: '设备型号', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'version',
      label: '版本信息',
      fields: [
        { prop: 'osVersion', label: '操作系统版本', visible: true, group: 'version' },
        { prop: 'appVersion', label: 'APP版本', visible: true, group: 'version' }
      ]
    },
    {
      name: 'login',
      label: '登录信息',
      fields: [
        { prop: 'deviceToken', label: '推送Token', visible: true, group: 'login' },
        { prop: 'lastLoginTime', label: '最后登录时间', visible: true, width: '180', group: 'login' },
        { prop: 'lastLoginIp', label: '最后登录IP', visible: true, group: 'login' },
        { prop: 'isActive', label: '是否活跃', visible: true, group: 'login' }
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

  return new FieldConfigManager('mobileDevice', fieldGroups);
}

// 核心制度评估记录字段配置
export function createCoreSystemAssessmentRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'assessmentId', label: '考核ID', visible: true, required: true, group: 'basic' },
        { prop: 'systemId', label: '制度ID', visible: true, required: true, group: 'basic' },
        { prop: 'systemName', label: '制度名称', visible: true, required: true, group: 'basic' },
        { prop: 'assessorId', label: '考核人ID', visible: true, required: true, group: 'basic' },
        { prop: 'assessorName', label: '考核人名称', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'assessment',
      label: '考核信息',
      fields: [
        { prop: 'assessmentTime', label: '考核时间', visible: true, required: true, width: '180', group: 'assessment' },
        { prop: 'assessmentCycle', label: '考核周期', visible: true, required: true, group: 'assessment' },
        { prop: 'assessmentScore', label: '考核分数', visible: true, required: true, group: 'assessment' },
        { prop: 'assessmentGrade', label: '考核等级', visible: true, required: true, group: 'assessment' },
        { prop: 'assessmentResult', label: '考核结果', visible: true, required: true, group: 'assessment' },
        { prop: 'assessmentOpinion', label: '考核意见', visible: true, group: 'assessment' }
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

  return new FieldConfigManager('coreSystemAssessmentRecord', fieldGroups);
}

// 核心制度执行记录字段配置
export function createCoreSystemExecutionRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '执行ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'systemId', label: '制度ID', visible: true, required: true, group: 'basic' },
        { prop: 'systemName', label: '制度名称', visible: true, required: true, group: 'basic' },
        { prop: 'executorId', label: '执行人ID', visible: true, required: true, group: 'basic' },
        { prop: 'executorName', label: '执行人姓名', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'execution',
      label: '执行信息',
      fields: [
        { prop: 'executionTime', label: '执行时间', visible: true, required: true, width: '180', group: 'execution' },
        { prop: 'executionResult', label: '执行结果', visible: true, required: true, group: 'execution' }
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
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('coreSystemExecutionRecord', fieldGroups);
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

// 新技术实施字段配置
export function createNewTechnologyImplementationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'projectNo', label: '项目编号', visible: true, required: true, group: 'basic' },
        { prop: 'projectName', label: '项目名称', visible: true, group: 'basic' },
        { prop: 'implementDoctor', label: '实施医生', visible: true, group: 'basic' },
        { prop: 'implementationStatus', label: '实施状态', visible: true, group: 'basic' },
        { prop: 'implementationDate', label: '实施日期', visible: true, width: '180', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'patientCount', label: '患者数量', visible: true, group: 'detail' },
        { prop: 'successCount', label: '成功数量', visible: true, group: 'detail' },
        { prop: 'complicationCount', label: '并发症数量', visible: true, group: 'detail' },
        { prop: 'notes', label: '备注', visible: true, group: 'detail' }
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

  return new FieldConfigManager('newTechnologyImplementation', fieldGroups);
}

// 核心制度检查记录字段配置
export function createCoreSystemInspectionRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'systemId', label: '制度ID', visible: true, required: true, group: 'basic' },
        { prop: 'systemName', label: '制度名称', visible: true, required: true, group: 'basic' },
        { prop: 'inspectorId', label: '检查人ID', visible: true, required: true, group: 'basic' },
        { prop: 'inspectorName', label: '检查人姓名', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'inspection',
      label: '检查信息',
      fields: [
        { prop: 'inspectionTime', label: '检查时间', visible: true, width: '180', group: 'inspection' },
        { prop: 'inspectionResult', label: '检查结果', visible: true, group: 'inspection' },
        { prop: 'problemDescription', label: '问题描述', visible: true, group: 'inspection' },
        { prop: 'rectificationSuggestion', label: '整改建议', visible: true, group: 'inspection' }
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

  return new FieldConfigManager('coreSystemInspectionRecord', fieldGroups);
}

// 投诉纠纷字段配置
export function createComplaintDisputeFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, group: 'basic' },
        { prop: 'complaintNo', label: '投诉编号', visible: true, required: true, group: 'basic' },
        { prop: 'complaintType', label: '投诉类型', visible: true, required: true, group: 'basic' },
        { prop: 'complaintSource', label: '投诉来源', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'complainant',
      label: '投诉人信息',
      fields: [
        { prop: 'complainantName', label: '投诉人姓名', visible: true, group: 'complainant' },
        { prop: 'complainantContact', label: '投诉人联系方式', visible: true, group: 'complainant' }
      ]
    },
    {
      name: 'patient',
      label: '患者信息',
      fields: [
        { prop: 'patientName', label: '患者姓名', visible: true, group: 'patient' },
        { prop: 'patientId', label: '患者ID', visible: true, group: 'patient' }
      ]
    },
    {
      name: 'involved',
      label: '涉及人员',
      fields: [
        { prop: 'doctorId', label: '涉及医师ID', visible: true, group: 'involved' },
        { prop: 'doctorName', label: '涉及医师姓名', visible: true, group: 'involved' },
        { prop: 'departmentId', label: '涉及科室ID', visible: true, group: 'involved' },
        { prop: 'departmentName', label: '涉及科室名称', visible: true, group: 'involved' }
      ]
    },
    {
      name: 'content',
      label: '投诉内容',
      fields: [
        { prop: 'complaintContent', label: '投诉内容', visible: true, required: true, group: 'content' },
        { prop: 'complaintTime', label: '投诉时间', visible: true, required: true, width: '180', group: 'content' },
        { prop: 'currentStatus', label: '当前状态', visible: true, required: true, group: 'content' },
        { prop: 'priorityLevel', label: '优先级', visible: true, group: 'content' }
      ]
    },
    {
      name: 'dispute',
      label: '纠纷信息',
      fields: [
        { prop: 'isDispute', label: '是否构成纠纷', visible: true, group: 'dispute' },
        { prop: 'disputeConfirmation', label: '纠纷确认说明', visible: true, group: 'dispute' },
        { prop: 'finalResult', label: '最终处理结果', visible: true, group: 'dispute' }
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
        { prop: 'delFlag', label: '是否删除', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, width: '180', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, width: '180', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('complaintDispute', fieldGroups);
}

// 核心制度整改记录字段配置
export function createCoreSystemRectificationRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: false, group: 'basic' },
        { prop: 'rectificationId', label: '整改编号', visible: true, group: 'basic' },
        { prop: 'systemId', label: '制度ID', visible: false, group: 'basic' },
        { prop: 'systemName', label: '制度名称', visible: true, group: 'basic' },
        { prop: 'rectifierId', label: '整改人ID', visible: false, group: 'basic' },
        { prop: 'rectifierName', label: '整改人名称', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'status',
      label: '整改状态',
      fields: [
        { prop: 'rectificationStatus', label: '整改状态', visible: true, group: 'status' },
        { prop: 'rectificationStartTime', label: '开始时间', visible: true, width: '180', group: 'status' },
        { prop: 'rectificationEndTime', label: '完成时间', visible: true, width: '180', group: 'status' }
      ]
    },
    {
      name: 'content',
      label: '整改内容',
      fields: [
        { prop: 'rectificationContent', label: '整改内容', visible: true, group: 'content' },
        { prop: 'rectificationMeasures', label: '整改措施', visible: true, group: 'content' }
      ]
    },
    {
      name: 'result',
      label: '验收结果',
      fields: [
        { prop: 'acceptanceResult', label: '验收结果', visible: true, group: 'result' },
        { prop: 'acceptanceOpinion', label: '验收意见', visible: true, group: 'result' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, width: '180', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, width: '180', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: false, group: 'system' },
        { prop: 'remark', label: '备注', visible: false, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('coreSystemRectificationRecord', fieldGroups);
}

// 不良事件调查字段配置
export function createAdverseEventInvestigationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: false, group: 'basic' },
        { prop: 'reportId', label: '报告ID', visible: true, group: 'basic' },
        { prop: 'investigationCode', label: '调查编码', visible: true, group: 'basic' },
        { prop: 'investigationTeam', label: '调查小组', visible: true, group: 'basic' },
        { prop: 'status', label: '状态', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'investigationStartDate', label: '调查开始日期', visible: true, width: '180', group: 'time' },
        { prop: 'investigationEndDate', label: '调查结束日期', visible: true, width: '180', group: 'time' }
      ]
    },
    {
      name: 'investigation',
      label: '调查内容',
      fields: [
        { prop: 'investigationMethods', label: '调查方法', visible: true, group: 'investigation' },
        { prop: 'investigationFindings', label: '调查发现', visible: true, group: 'investigation' },
        { prop: 'rootCauses', label: '根本原因', visible: true, group: 'investigation' },
        { prop: 'contributingFactors', label: '促成因素', visible: true, group: 'investigation' },
        { prop: 'recommendations', label: '建议措施', visible: true, group: 'investigation' },
        { prop: 'investigationReport', label: '调查报告', visible: true, group: 'investigation' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, width: '180', group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, width: '180', group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' },
        { prop: 'remark', label: '备注', visible: false, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('adverseEventInvestigation', fieldGroups);
}

// 医师专业评级字段配置
export function createDoctorProfessionalRatingFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: false, group: 'basic' },
        { prop: 'doctorId', label: '医师ID', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '医师姓名', visible: true, required: true, group: 'basic' },
        { prop: 'ratingYear', label: '评分年份', visible: true, required: true, group: 'basic' },
        { prop: 'ratingQuarter', label: '评分季度', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'scores',
      label: '评分信息',
      fields: [
        { prop: 'baseScore', label: '基础分数', visible: true, group: 'scores' },
        { prop: 'complaintDeduction', label: '投诉扣分', visible: true, group: 'scores' },
        { prop: 'medicalQualityScore', label: '医疗质量评分', visible: true, group: 'scores' },
        { prop: 'patientSatisfaction', label: '患者满意度', visible: true, group: 'scores' },
        { prop: 'finalScore', label: '最终得分', visible: true, group: 'scores' }
      ]
    },
    {
      name: 'result',
      label: '评级结果',
      fields: [{ prop: 'ratingLevel', label: '评分等级', visible: true, group: 'result' }]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, width: '180', group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, width: '180', group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' },
        { prop: 'remark', label: '备注', visible: false, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('doctorProfessionalRating', fieldGroups);
}

// 医生学术任职字段配置
export function createDoctorAcademicPositionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'organization', label: '学术组织', visible: true, required: true, group: 'basic' },
        { prop: 'position', label: '职务', visible: true, required: true, group: 'basic' },
        { prop: 'positionLevel', label: '职务级别', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'startDate', label: '任职开始日期', visible: true, width: '180', group: 'time' },
        { prop: 'endDate', label: '任职结束日期', visible: true, width: '180', group: 'time' },
        { prop: 'isCurrent', label: '是否现任', visible: true, group: 'time' }
      ]
    },
    {
      name: 'document',
      label: '文档信息',
      fields: [
        { prop: 'appointmentUrl', label: '任职证明URL', visible: true, group: 'document' },
        { prop: 'remark', label: '备注', visible: true, group: 'document' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, width: '180', group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, width: '180', group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('doctorAcademicPosition', fieldGroups);
}

// 医生荣誉奖励字段配置
export function createDoctorHonorFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'honorName', label: '荣誉名称', visible: true, required: true, group: 'basic' },
        { prop: 'honorLevel', label: '荣誉级别', visible: true, group: 'basic' },
        { prop: 'awardUnit', label: '授予单位', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'award',
      label: '获奖信息',
      fields: [
        { prop: 'awardDate', label: '获得日期', visible: true, width: '180', group: 'award' },
        { prop: 'certificateNo', label: '证书编号', visible: true, group: 'award' },
        { prop: 'certificateUrl', label: '证书附件URL', visible: true, group: 'award' }
      ]
    },
    {
      name: 'other',
      label: '其他信息',
      fields: [{ prop: 'remark', label: '备注', visible: true, group: 'other' }]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, width: '180', group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, width: '180', group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('doctorHonor', fieldGroups);
}
