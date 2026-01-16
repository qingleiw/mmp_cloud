import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

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
    }
  ];
  return new FieldConfigManager('doctorBasicInfo', fieldGroups);
}

// 医生工作经验字段配置
export function createDoctorWorkExperienceFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'basic' },
        { prop: 'companyName', label: '工作单位', visible: true, required: true, group: 'basic' },
        { prop: 'department', label: '科室/部门', visible: true, group: 'basic' },
        { prop: 'position', label: '职位', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'startDate', label: '开始日期', visible: true, width: '120', group: 'time' },
        { prop: 'endDate', label: '结束日期', visible: true, width: '120', group: 'time' },
        { prop: 'workYears', label: '工作年限', visible: true, group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'workContent', label: '工作内容', visible: true, group: 'detail' },
        { prop: 'achievement', label: '工作业绩', visible: true, group: 'detail' },
        { prop: 'reasonForLeaving', label: '离职原因', visible: true, group: 'detail' },
        { prop: 'referencePerson', label: '证明人', visible: true, group: 'detail' },
        { prop: 'referenceContact', label: '证明人联系方式', visible: true, group: 'detail' }
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
  return new FieldConfigManager('doctorWorkExperience', fieldGroups);
}

// 医生学历字段配置
export function createDoctorEducationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'basic' },
        { prop: 'schoolName', label: '学校名称', visible: true, required: true, group: 'basic' },
        { prop: 'major', label: '专业', visible: true, required: true, group: 'basic' },
        { prop: 'educationLevel', label: '学历层次', visible: true, required: true, group: 'basic' },
        { prop: 'degree', label: '学位', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'enrollmentDate', label: '入学日期', visible: true, width: '120', group: 'time' },
        { prop: 'graduationDate', label: '毕业日期', visible: true, width: '120', group: 'time' },
        { prop: 'studyYears', label: '学制年限', visible: true, group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'educationType', label: '教育类型', visible: true, group: 'detail' },
        { prop: 'isFullTime', label: '是否全日制', visible: true, group: 'detail' },
        { prop: 'certificateNo', label: '证书编号', visible: true, group: 'detail' },
        { prop: 'gpa', label: 'GPA成绩', visible: true, group: 'detail' },
        { prop: 'ranking', label: '专业排名', visible: true, group: 'detail' },
        { prop: 'honor', label: '获得荣誉', visible: true, group: 'detail' }
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
  return new FieldConfigManager('doctorEducation', fieldGroups);
}

// 医生培训记录字段配置
export function createDoctorTrainingFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'basic' },
        { prop: 'trainingName', label: '培训名称', visible: true, required: true, group: 'basic' },
        { prop: 'trainingType', label: '培训类型', visible: true, group: 'basic' },
        { prop: 'trainingInstitution', label: '培训机构', visible: true, group: 'basic' },
        { prop: 'trainingHours', label: '培训学时', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'startDate', label: '开始日期', visible: true, width: '120', group: 'time' },
        { prop: 'endDate', label: '结束日期', visible: true, width: '120', group: 'time' },
        { prop: 'certificateDate', label: '发证日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'trainingContent', label: '培训内容', visible: true, group: 'detail' },
        { prop: 'trainingResult', label: '培训结果', visible: true, group: 'detail' },
        { prop: 'certificateNo', label: '证书编号', visible: true, group: 'detail' },
        { prop: 'certificateUrl', label: '证书附件', visible: true, group: 'detail' },
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
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];
  return new FieldConfigManager('doctorTraining', fieldGroups);
}

// 医生不良记录字段配置
export function createDoctorAdverseRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'basic' },
        { prop: 'recordType', label: '记录类型', visible: true, required: true, group: 'basic' },
        { prop: 'recordDate', label: '记录日期', visible: true, width: '120', group: 'basic' },
        { prop: 'recordLevel', label: '记录等级', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'recordContent', label: '记录内容', visible: true, group: 'detail' },
        { prop: 'handlingResult', label: '处理结果', visible: true, group: 'detail' },
        { prop: 'handlingDepartment', label: '处理部门', visible: true, group: 'detail' },
        { prop: 'handlingDate', label: '处理日期', visible: true, width: '120', group: 'detail' },
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
  return new FieldConfigManager('doctorAdverseRecord', fieldGroups);
}

// 医生电子注册字段配置
export function createDoctorElectronicRegistrationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'basic' },
        { prop: 'registrationNo', label: '注册编号', visible: true, required: true, group: 'basic' },
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
        { prop: 'status', label: '状态', visible: true, group: 'validity' }
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
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'basic' },
        { prop: 'evaluationYear', label: '评估年份', visible: true, required: true, group: 'basic' },
        { prop: 'evaluationQuarter', label: '评估季度', visible: true, group: 'basic' },
        { prop: 'evaluationType', label: '评估类型', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'score',
      label: '评分信息',
      fields: [
        { prop: 'professionalEthicsScore', label: '职业道德评分', visible: true, group: 'score' },
        { prop: 'patientRightsScore', label: '患者权益评分', visible: true, group: 'score' },
        { prop: 'medicalSafetyScore', label: '医疗安全评分', visible: true, group: 'score' },
        { prop: 'totalScore', label: '总评分', visible: true, group: 'score' },
        { prop: 'evaluationLevel', label: '评估等级', visible: true, group: 'score' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'evaluationContent', label: '评估内容', visible: true, group: 'detail' },
        { prop: 'evaluationResult', label: '评估结果', visible: true, group: 'detail' },
        { prop: 'improvementSuggestion', label: '改进建议', visible: true, group: 'detail' },
        { prop: 'evaluator', label: '评估人', visible: true, group: 'detail' },
        { prop: 'evaluationDate', label: '评估日期', visible: true, width: '120', group: 'detail' }
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
  return new FieldConfigManager('doctorEthicsEvaluation', fieldGroups);
}

// 医生医保医师码字段配置
export function createDoctorInsuranceCodeFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'basic' },
        { prop: 'insuranceCode', label: '医保医师码', visible: true, required: true, group: 'basic' },
        { prop: 'insuranceType', label: '医保类型', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'validity',
      label: '有效期信息',
      fields: [
        { prop: 'validDate', label: '有效期至', visible: true, width: '120', group: 'validity' },
        { prop: 'status', label: '状态', visible: true, group: 'validity' },
        { prop: 'applyDate', label: '申请日期', visible: true, width: '120', group: 'validity' },
        { prop: 'approveDate', label: '批准日期', visible: true, width: '120', group: 'validity' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
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
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];
  return new FieldConfigManager('doctorInsuranceCode', fieldGroups);
}

// 医生职业评分字段配置
export function createDoctorProfessionalRatingFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'basic' },
        { prop: 'ratingYear', label: '评分年份', visible: true, required: true, group: 'basic' },
        { prop: 'ratingQuarter', label: '评分季度', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'score',
      label: '评分信息',
      fields: [
        { prop: 'baseScore', label: '基础得分', visible: true, group: 'score' },
        { prop: 'complaintDeduction', label: '投诉扣分', visible: true, group: 'score' },
        { prop: 'medicalQualityScore', label: '医疗质量得分', visible: true, group: 'score' },
        { prop: 'patientSatisfaction', label: '患者满意度', visible: true, group: 'score' },
        { prop: 'finalScore', label: '最终得分', visible: true, required: true, group: 'score' },
        { prop: 'ratingLevel', label: '评分等级', visible: true, group: 'score' }
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
  return new FieldConfigManager('doctorProfessionalRating', fieldGroups);
}

// 医生出版物字段配置
export function createDoctorPublicationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'basic' },
        { prop: 'publicationTitle', label: '发表标题', visible: true, required: true, group: 'basic' },
        { prop: 'publicationType', label: '发表类型', visible: true, group: 'basic' },
        { prop: 'journalName', label: '期刊名称', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'authors', label: '作者', visible: true, group: 'detail' },
        { prop: 'correspondingAuthor', label: '通讯作者', visible: true, group: 'detail' },
        { prop: 'publicationDate', label: '发表日期', visible: true, width: '120', group: 'detail' },
        { prop: 'volume', label: '卷号', visible: true, group: 'detail' },
        { prop: 'issue', label: '期号', visible: true, group: 'detail' },
        { prop: 'pageRange', label: '页码范围', visible: true, group: 'detail' },
        { prop: 'doi', label: 'DOI', visible: true, group: 'detail' },
        { prop: 'impactFactor', label: '影响因子', visible: true, group: 'detail' }
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
  return new FieldConfigManager('doctorPublication', fieldGroups);
}

// 医生资质目录字段配置
export function createDoctorQualificationCatalogFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'catalogCode', label: '资质编码', visible: true, required: true, group: 'basic' },
        { prop: 'catalogName', label: '资质名称', visible: true, required: true, group: 'basic' },
        { prop: 'parentId', label: '父级ID', visible: true, group: 'basic' },
        { prop: 'catalogLevel', label: '资质等级', visible: true, group: 'basic' },
        { prop: 'catalogType', label: '资质类型', visible: true, group: 'basic' },
        { prop: 'subType', label: '子类型', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'description', label: '描述', visible: true, group: 'detail' },
        { prop: 'sortOrder', label: '排序', visible: true, group: 'detail' },
        { prop: 'isEnabled', label: '是否启用', visible: true, group: 'detail' }
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
  return new FieldConfigManager('doctorQualificationCatalog', fieldGroups);
}

// 医生研究项目字段配置
export function createDoctorResearchProjectFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'basic' },
        { prop: 'projectName', label: '项目名称', visible: true, required: true, group: 'basic' },
        { prop: 'projectCode', label: '项目编号', visible: true, group: 'basic' },
        { prop: 'projectType', label: '项目类型', visible: true, group: 'basic' },
        { prop: 'projectLevel', label: '项目等级', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'funding',
      label: '经费信息',
      fields: [
        { prop: 'fundingSource', label: '经费来源', visible: true, group: 'funding' },
        { prop: 'totalFunding', label: '总经费', visible: true, group: 'funding' },
        { prop: 'personalFunding', label: '个人经费', visible: true, group: 'funding' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'startDate', label: '开始日期', visible: true, width: '120', group: 'time' },
        { prop: 'endDate', label: '结束日期', visible: true, width: '120', group: 'time' },
        { prop: 'expectedEndDate', label: '预计结束日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'projectStatus', label: '项目状态', visible: true, group: 'status' },
        { prop: 'progress', label: '进度', visible: true, group: 'status' },
        { prop: 'completionRate', label: '完成率', visible: true, group: 'status' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'projectDescription', label: '项目描述', visible: true, group: 'detail' },
        { prop: 'researchContent', label: '研究内容', visible: true, group: 'detail' },
        { prop: 'expectedResults', label: '预期成果', visible: true, group: 'detail' },
        { prop: 'actualResults', label: '实际成果', visible: true, group: 'detail' },
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
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];
  return new FieldConfigManager('doctorResearchProject', fieldGroups);
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
        { prop: 'doctorId', label: '医生ID', visible: false, group: 'basic' },
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

// 医生学术职称字段配置
export function createDoctorAcademicPositionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'tenantId', label: '租户ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'organization', label: '任职机构', visible: true, required: true, group: 'basic' },
        { prop: 'position', label: '学术职务', visible: true, required: true, group: 'basic' },
        { prop: 'positionLevel', label: '职务级别', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'startDate', label: '开始日期', visible: true, type: 'date', width: '120', group: 'time' },
        { prop: 'endDate', label: '结束日期', visible: true, type: 'date', width: '120', group: 'time' },
        { prop: 'isCurrent', label: '是否当前', visible: true, type: 'switch', group: 'time' }
      ]
    },
    {
      name: 'attachment',
      label: '附件信息',
      fields: [
        { prop: 'appointmentUrl', label: '任命书URL', visible: true, group: 'attachment' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('doctorAcademicPosition', fieldGroups);
}

// 医生荣誉字段配置
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
        { prop: 'honorLevel', label: '荣誉等级', visible: true, group: 'basic' },
        { prop: 'awardUnit', label: '授予单位', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'awardDate', label: '获得日期', visible: true, type: 'date', width: '120', group: 'time' }
      ]
    },
    {
      name: 'certificate',
      label: '证书信息',
      fields: [
        { prop: 'certificateNo', label: '证书编号', visible: true, group: 'certificate' },
        { prop: 'certificateUrl', label: '证书附件URL', visible: true, group: 'certificate' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'detail' }
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

  return new FieldConfigManager('doctorHonor', fieldGroups);
}

// 医生能力评估字段配置
export function createDoctorAbilityAssessmentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, required: true, group: 'basic' },
        { prop: 'assessmentYear', label: '评估年度', visible: true, required: true, group: 'basic' },
        { prop: 'assessmentType', label: '评估类型', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'scores',
      label: '能力评分',
      fields: [
        { prop: 'clinicalAbilityScore', label: '临床能力评分', visible: true, group: 'scores' },
        { prop: 'teachingAbilityScore', label: '教学能力评分', visible: true, group: 'scores' },
        { prop: 'researchAbilityScore', label: '科研能力评分', visible: true, group: 'scores' },
        { prop: 'managementAbilityScore', label: '管理能力评分', visible: true, group: 'scores' },
        { prop: 'totalScore', label: '总评分', visible: true, group: 'scores' }
      ]
    },
    {
      name: 'result',
      label: '评估结果',
      fields: [
        { prop: 'assessmentResult', label: '评估结果', visible: true, group: 'result' },
        { prop: 'assessor', label: '评估人', visible: true, group: 'result' },
        { prop: 'assessmentDate', label: '评估日期', visible: true, type: 'date', width: '120', group: 'result' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'remark', label: '备注', visible: true, type: 'textarea', group: 'detail' }
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