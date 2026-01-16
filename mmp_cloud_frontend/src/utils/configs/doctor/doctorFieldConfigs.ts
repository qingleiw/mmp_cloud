import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// 医生基本信息字段配置
export function createDoctorBasicInfoFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '医生ID', visible: false, group: 'basic' },
        { prop: 'doctorCode', label: '医生工号', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, required: true, group: 'basic' },
        { prop: 'gender', label: '性别', visible: true, group: 'basic' },
        { prop: 'idCard', label: '身份证号', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'phone', label: '联系电话', visible: true, group: 'detail' },
        { prop: 'email', label: '电子邮箱', visible: true, group: 'detail' },
        { prop: 'photoUrl', label: '照片URL', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'deptId', label: '科室ID', visible: false, required: true, group: 'association' },
        { prop: 'departmentName', label: '科室名称', visible: true, group: 'association' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'birthDate', label: '出生日期', visible: true, width: '120', group: 'time' },
        { prop: 'entryDate', label: '入职日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'title', label: '职称', visible: true, group: 'status' },
        { prop: 'titleLevel', label: '职称级别', visible: true, group: 'status' },
        { prop: 'status', label: '工作状态', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生工作经验字段配置
export function createDoctorWorkExperienceFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '工作经验ID', visible: false, group: 'basic' },
        { prop: 'companyName', label: '工作单位', visible: true, required: true, group: 'basic' },
        { prop: 'department', label: '科室/部门', visible: true, group: 'basic' },
        { prop: 'position', label: '职位', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', visible: false, required: true, group: 'association' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'association' }
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
        { prop: 'performance', label: '工作业绩', visible: true, group: 'detail' },
        { prop: 'reasonForLeaving', label: '离职原因', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生学历信息字段配置
export function createDoctorEducationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '学历ID', visible: false, group: 'basic' },
        { prop: 'educationLevel', label: '学历层次', visible: true, required: true, group: 'basic' },
        { prop: 'degree', label: '学位', visible: true, group: 'basic' },
        { prop: 'major', label: '专业', visible: true, required: true, group: 'basic' },
        { prop: 'schoolName', label: '学校名称', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', visible: false, required: true, group: 'association' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'association' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'enrollmentDate', label: '入学日期', visible: true, width: '120', group: 'time' },
        { prop: 'graduationDate', label: '毕业日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'educationType', label: '教育类型', visible: true, group: 'detail' },
        { prop: 'studyMode', label: '学习方式', visible: true, group: 'detail' },
        { prop: 'certificateNo', label: '证书编号', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'isHighest', label: '是否最高学历', visible: true, group: 'status' },
        { prop: 'verificationStatus', label: '验证状态', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生培训记录字段配置
export function createDoctorTrainingFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '培训ID', visible: false, group: 'basic' },
        { prop: 'trainingName', label: '培训名称', visible: true, required: true, group: 'basic' },
        { prop: 'trainingType', label: '培训类型', visible: true, required: true, group: 'basic' },
        { prop: 'trainingInstitution', label: '培训机构', visible: true, required: true, group: 'basic' },
        { prop: 'trainingLocation', label: '培训地点', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', visible: false, required: true, group: 'association' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'association' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'startDate', label: '开始日期', visible: true, width: '120', group: 'time' },
        { prop: 'endDate', label: '结束日期', visible: true, width: '120', group: 'time' },
        { prop: 'trainingHours', label: '培训学时', visible: true, group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'trainingContent', label: '培训内容', visible: true, group: 'detail' },
        { prop: 'trainingMethod', label: '培训方式', visible: true, group: 'detail' },
        { prop: 'certificateNo', label: '证书编号', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'completionStatus', label: '完成状态', visible: true, group: 'status' },
        { prop: 'assessmentResult', label: '考核结果', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生证书信息字段配置
export function createDoctorCertificateFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '证书ID', visible: false, group: 'basic' },
        { prop: 'certificateName', label: '证书名称', visible: true, required: true, group: 'basic' },
        { prop: 'certificateType', label: '证书类型', visible: true, required: true, group: 'basic' },
        { prop: 'certificateNo', label: '证书编号', visible: true, required: true, group: 'basic' },
        { prop: 'issuingAuthority', label: '发证机构', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', visible: false, required: true, group: 'association' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'association' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'issueDate', label: '发证日期', visible: true, width: '120', group: 'time' },
        { prop: 'expiryDate', label: '到期日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'certificateLevel', label: '证书等级', visible: true, group: 'detail' },
        { prop: 'certificateScope', label: '证书范围', visible: true, group: 'detail' },
        { prop: 'attachmentUrl', label: '附件URL', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '证书状态', visible: true, group: 'status' },
        { prop: 'isValid', label: '是否有效', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生学术职位字段配置
export function createDoctorAcademicPositionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '职位ID', visible: false, group: 'basic' },
        { prop: 'positionName', label: '职位名称', visible: true, required: true, group: 'basic' },
        { prop: 'positionLevel', label: '职位级别', visible: true, required: true, group: 'basic' },
        { prop: 'organizationName', label: '所属机构', visible: true, required: true, group: 'basic' },
        { prop: 'department', label: '所属部门', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', visible: false, required: true, group: 'association' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'association' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'startDate', label: '任职开始日期', visible: true, width: '120', group: 'time' },
        { prop: 'endDate', label: '任职结束日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'responsibilities', label: '职责描述', visible: true, group: 'detail' },
        { prop: 'achievements', label: '主要成就', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '职位状态', visible: true, group: 'status' },
        { prop: 'isCurrent', label: '是否现任', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生荣誉信息字段配置
export function createDoctorHonorFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '荣誉ID', visible: false, group: 'basic' },
        { prop: 'honorName', label: '荣誉名称', visible: true, required: true, group: 'basic' },
        { prop: 'honorType', label: '荣誉类型', visible: true, required: true, group: 'basic' },
        { prop: 'honorLevel', label: '荣誉等级', visible: true, group: 'basic' },
        { prop: 'issuingAuthority', label: '颁发机构', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', visible: false, required: true, group: 'association' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'association' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'awardDate', label: '获奖日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'honorDescription', label: '荣誉描述', visible: true, group: 'detail' },
        { prop: 'certificateNo', label: '证书编号', visible: true, group: 'detail' },
        { prop: 'attachmentUrl', label: '附件URL', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '荣誉状态', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生科研项目字段配置
export function createDoctorResearchProjectFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '项目ID', visible: false, group: 'basic' },
        { prop: 'projectName', label: '项目名称', visible: true, required: true, group: 'basic' },
        { prop: 'projectType', label: '项目类型', visible: true, required: true, group: 'basic' },
        { prop: 'projectLevel', label: '项目等级', visible: true, group: 'basic' },
        { prop: 'projectNo', label: '项目编号', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', visible: false, required: true, group: 'association' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'association' },
        { prop: 'organizationName', label: '承担单位', visible: true, group: 'association' }
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
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'projectDescription', label: '项目描述', visible: true, group: 'detail' },
        { prop: 'researchContent', label: '研究内容', visible: true, group: 'detail' },
        { prop: 'expectedResults', label: '预期成果', visible: true, group: 'detail' },
        { prop: 'fundingAmount', label: '资助金额', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'projectStatus', label: '项目状态', visible: true, group: 'status' },
        { prop: 'approvalStatus', label: '审批状态', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生论文发表字段配置
export function createDoctorPublicationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '论文ID', visible: false, group: 'basic' },
        { prop: 'title', label: '论文标题', visible: true, required: true, group: 'basic' },
        { prop: 'publicationType', label: '发表类型', visible: true, required: true, group: 'basic' },
        { prop: 'journalName', label: '期刊名称', visible: true, group: 'basic' },
        { prop: 'publicationNo', label: '发表号', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', visible: false, required: true, group: 'association' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'association' },
        { prop: 'correspondingAuthor', label: '通讯作者', visible: true, group: 'association' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'publicationDate', label: '发表日期', visible: true, width: '120', group: 'time' },
        { prop: 'acceptanceDate', label: '接收日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'abstract', label: '摘要', visible: true, group: 'detail' },
        { prop: 'keywords', label: '关键词', visible: true, group: 'detail' },
        { prop: 'doi', label: 'DOI', visible: true, group: 'detail' },
        { prop: 'citationCount', label: '引用次数', visible: true, group: 'detail' },
        { prop: 'impactFactor', label: '影响因子', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'publicationStatus', label: '发表状态', visible: true, group: 'status' },
        { prop: 'peerReviewStatus', label: '同行评审状态', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生能力评估字段配置
export function createDoctorAbilityAssessmentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '评估ID', visible: false, group: 'basic' },
        { prop: 'assessmentName', label: '评估名称', visible: true, required: true, group: 'basic' },
        { prop: 'assessmentType', label: '评估类型', visible: true, required: true, group: 'basic' },
        { prop: 'assessmentPeriod', label: '评估周期', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', visible: false, required: true, group: 'association' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'association' },
        { prop: 'assessorName', label: '评估人姓名', visible: true, group: 'association' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'assessmentDate', label: '评估日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'assessmentContent', label: '评估内容', visible: true, group: 'detail' },
        { prop: 'assessmentCriteria', label: '评估标准', visible: true, group: 'detail' },
        { prop: 'assessmentResult', label: '评估结果', visible: true, group: 'detail' },
        { prop: 'score', label: '得分', visible: true, group: 'detail' },
        { prop: 'grade', label: '等级', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '评估状态', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生职业资格字段配置
export function createDoctorQualificationCatalogFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '资格ID', visible: false, group: 'basic' },
        { prop: 'qualificationName', label: '资格名称', visible: true, required: true, group: 'basic' },
        { prop: 'qualificationType', label: '资格类型', visible: true, required: true, group: 'basic' },
        { prop: 'qualificationLevel', label: '资格等级', visible: true, group: 'basic' },
        { prop: 'qualificationNo', label: '资格编号', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', visible: false, required: true, group: 'association' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'association' },
        { prop: 'issuingAuthority', label: '发证机构', visible: true, group: 'association' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'issueDate', label: '发证日期', visible: true, width: '120', group: 'time' },
        { prop: 'expiryDate', label: '到期日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'qualificationScope', label: '资格范围', visible: true, group: 'detail' },
        { prop: 'qualificationDescription', label: '资格描述', visible: true, group: 'detail' },
        { prop: 'certificateUrl', label: '证书URL', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '资格状态', visible: true, group: 'status' },
        { prop: 'isValid', label: '是否有效', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生专业评分字段配置
export function createDoctorProfessionalRatingFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '评分ID', visible: false, group: 'basic' },
        { prop: 'ratingName', label: '评分名称', visible: true, required: true, group: 'basic' },
        { prop: 'ratingType', label: '评分类型', visible: true, required: true, group: 'basic' },
        { prop: 'ratingPeriod', label: '评分周期', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', visible: false, required: true, group: 'association' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'association' },
        { prop: 'raterName', label: '评分人姓名', visible: true, group: 'association' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'ratingDate', label: '评分日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'ratingCriteria', label: '评分标准', visible: true, group: 'detail' },
        { prop: 'ratingResult', label: '评分结果', visible: true, group: 'detail' },
        { prop: 'totalScore', label: '总分', visible: true, group: 'detail' },
        { prop: 'grade', label: '等级', visible: true, group: 'detail' },
        { prop: 'feedback', label: '反馈意见', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '评分状态', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生不良记录字段配置
export function createDoctorAdverseRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '记录ID', visible: false, group: 'basic' },
        { prop: 'recordType', label: '记录类型', visible: true, required: true, group: 'basic' },
        { prop: 'incidentDescription', label: '事件描述', visible: true, required: true, group: 'basic' },
        { prop: 'severityLevel', label: '严重程度', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', visible: false, required: true, group: 'association' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'association' },
        { prop: 'reporterName', label: '报告人姓名', visible: true, group: 'association' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'incidentDate', label: '事件日期', visible: true, width: '120', group: 'time' },
        { prop: 'reportDate', label: '报告日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'incidentDetails', label: '事件详情', visible: true, group: 'detail' },
        { prop: 'consequences', label: '后果影响', visible: true, group: 'detail' },
        { prop: 'correctiveActions', label: '纠正措施', visible: true, group: 'detail' },
        { prop: 'preventiveMeasures', label: '预防措施', visible: true, group: 'detail' },
        { prop: 'attachmentUrl', label: '附件URL', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '处理状态', visible: true, group: 'status' },
        { prop: 'investigationResult', label: '调查结果', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生伦理评估字段配置
export function createDoctorEthicsEvaluationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '评估ID', visible: false, group: 'basic' },
        { prop: 'evaluationName', label: '评估名称', visible: true, required: true, group: 'basic' },
        { prop: 'evaluationType', label: '评估类型', visible: true, required: true, group: 'basic' },
        { prop: 'evaluationPeriod', label: '评估周期', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', visible: false, required: true, group: 'association' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'association' },
        { prop: 'evaluatorName', label: '评估人姓名', visible: true, group: 'association' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'evaluationDate', label: '评估日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'evaluationContent', label: '评估内容', visible: true, group: 'detail' },
        { prop: 'evaluationCriteria', label: '评估标准', visible: true, group: 'detail' },
        { prop: 'evaluationResult', label: '评估结果', visible: true, group: 'detail' },
        { prop: 'score', label: '得分', visible: true, group: 'detail' },
        { prop: 'grade', label: '等级', visible: true, group: 'detail' },
        { prop: 'recommendations', label: '建议意见', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '评估状态', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生电子注册字段配置
export function createDoctorElectronicRegistrationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '注册ID', visible: false, group: 'basic' },
        { prop: 'registrationNo', label: '注册编号', visible: true, required: true, group: 'basic' },
        { prop: 'registrationType', label: '注册类型', visible: true, required: true, group: 'basic' },
        { prop: 'registrationLevel', label: '注册等级', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', visible: false, required: true, group: 'association' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'association' },
        { prop: 'registrationAuthority', label: '注册机构', visible: true, group: 'association' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'registrationDate', label: '注册日期', visible: true, width: '120', group: 'time' },
        { prop: 'expiryDate', label: '到期日期', visible: true, width: '120', group: 'time' },
        { prop: 'renewalDate', label: '续展日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'registrationScope', label: '注册范围', visible: true, group: 'detail' },
        { prop: 'registrationConditions', label: '注册条件', visible: true, group: 'detail' },
        { prop: 'certificateUrl', label: '证书URL', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '注册状态', visible: true, group: 'status' },
        { prop: 'isValid', label: '是否有效', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生保险代码字段配置
export function createDoctorInsuranceCodeFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '保险ID', visible: false, group: 'basic' },
        { prop: 'insuranceType', label: '保险类型', visible: true, required: true, group: 'basic' },
        { prop: 'insuranceCode', label: '保险代码', visible: true, required: true, group: 'basic' },
        { prop: 'insuranceName', label: '保险名称', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', visible: false, required: true, group: 'association' },
        { prop: 'doctorName', label: '医生姓名', visible: true, group: 'association' },
        { prop: 'insuranceCompany', label: '保险公司', visible: true, group: 'association' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'effectiveDate', label: '生效日期', visible: true, width: '120', group: 'time' },
        { prop: 'expiryDate', label: '到期日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'coverageAmount', label: '保额', visible: true, group: 'detail' },
        { prop: 'premiumAmount', label: '保费', visible: true, group: 'detail' },
        { prop: 'insuranceDescription', label: '保险描述', visible: true, group: 'detail' },
        { prop: 'policyUrl', label: '保单URL', visible: true, group: 'detail' },
        { prop: 'remark', label: '备注', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '保险状态', visible: true, group: 'status' },
        { prop: 'isActive', label: '是否激活', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}

// 医生信息字段配置
export function createDoctorInfoFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '医生ID', visible: false, group: 'basic' },
        { prop: 'doctorCode', label: '医生工号', visible: true, required: true, group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, required: true, group: 'basic' },
        { prop: 'gender', label: '性别', visible: true, group: 'basic' },
        { prop: 'birthDate', label: '出生日期', visible: true, width: '120', group: 'basic' },
        { prop: 'idCard', label: '身份证号', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'phone', label: '联系电话', visible: true, group: 'detail' },
        { prop: 'email', label: '电子邮箱', visible: true, group: 'detail' },
        { prop: 'photoUrl', label: '照片URL', visible: true, group: 'detail' },
        { prop: 'address', label: '地址', visible: true, group: 'detail' },
        { prop: 'emergencyContact', label: '紧急联系人', visible: true, group: 'detail' },
        { prop: 'emergencyPhone', label: '紧急联系电话', visible: true, group: 'detail' }
      ]
    },
    {
      name: 'association',
      label: '关联信息',
      fields: [
        { prop: 'deptId', label: '科室ID', visible: false, required: true, group: 'association' },
        { prop: 'departmentName', label: '科室名称', visible: true, group: 'association' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'entryDate', label: '入职日期', visible: true, width: '120', group: 'time' },
        { prop: 'graduationDate', label: '毕业日期', visible: true, width: '120', group: 'time' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'title', label: '职称', visible: true, group: 'status' },
        { prop: 'titleLevel', label: '职称级别', visible: true, group: 'status' },
        { prop: 'status', label: '工作状态', visible: true, group: 'status' },
        { prop: 'maritalStatus', label: '婚姻状况', visible: true, group: 'status' },
        { prop: 'politicalStatus', label: '政治面貌', visible: true, group: 'status' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: false, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: false, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: false, group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: false, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: false, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: false, group: 'system' }
      ]
    }
  ];

  return fieldGroups;
}