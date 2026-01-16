import { SearchConfigManager } from '../searchConfigManager';

// 医生基本信息搜索配置
export function createDoctorBasicInfoSearchConfig() {
  return new SearchConfigManager('doctorBasicInfo', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorCode', label: '医生工号', type: 'input', visible: true, placeholder: '请输入医生工号' },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' },
        { prop: 'gender', label: '性别', type: 'select', visible: true, placeholder: '请选择性别' },
        { prop: 'idCard', label: '身份证号', type: 'input', visible: true, placeholder: '请输入身份证号' }
      ]
    },
    {
      name: 'contact',
      label: '联系信息',
      fields: [
        { prop: 'phone', label: '联系电话', type: 'input', visible: true, placeholder: '请输入联系电话' },
        { prop: 'email', label: '电子邮箱', type: 'input', visible: true, placeholder: '请输入电子邮箱' }
      ]
    },
    {
      name: 'department',
      label: '科室信息',
      fields: [
        { prop: 'departmentName', label: '科室名称', type: 'input', visible: true, placeholder: '请输入科室名称' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'title', label: '职称', type: 'select', visible: true, placeholder: '请选择职称' },
        { prop: 'titleLevel', label: '职称级别', type: 'select', visible: true, placeholder: '请选择职称级别' },
        { prop: 'status', label: '工作状态', type: 'select', visible: true, placeholder: '请选择工作状态' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'entryDate', 
          label: '入职日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'entryDateStart', 
          endProp: 'entryDateEnd' 
        },
        { 
          prop: 'birthDate', 
          label: '出生日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'birthDateStart', 
          endProp: 'birthDateEnd' 
        }
      ]
    }
  ]);
}

// 医生工作经验搜索配置
export function createDoctorWorkExperienceSearchConfig() {
  return new SearchConfigManager('doctorWorkExperience', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'companyName', label: '工作单位', type: 'input', visible: true, placeholder: '请输入工作单位' },
        { prop: 'department', label: '科室/部门', type: 'input', visible: true, placeholder: '请输入科室/部门' },
        { prop: 'position', label: '职位', type: 'input', visible: true, placeholder: '请输入职位' }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'startDate', 
          label: '开始日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'startDateStart', 
          endProp: 'startDateEnd' 
        },
        { 
          prop: 'endDate', 
          label: '结束日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'endDateStart', 
          endProp: 'endDateEnd' 
        }
      ]
    }
  ]);
}

// 医生学历信息搜索配置
export function createDoctorEducationSearchConfig() {
  return new SearchConfigManager('doctorEducation', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'educationLevel', label: '学历层次', type: 'select', visible: true, placeholder: '请选择学历层次' },
        { prop: 'degree', label: '学位', type: 'select', visible: true, placeholder: '请选择学位' },
        { prop: 'major', label: '专业', type: 'input', visible: true, placeholder: '请输入专业' },
        { prop: 'schoolName', label: '学校名称', type: 'input', visible: true, placeholder: '请输入学校名称' }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'enrollmentDate', 
          label: '入学日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'enrollmentDateStart', 
          endProp: 'enrollmentDateEnd' 
        },
        { 
          prop: 'graduationDate', 
          label: '毕业日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'graduationDateStart', 
          endProp: 'graduationDateEnd' 
        }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'isHighest', label: '是否最高学历', type: 'select', visible: true, placeholder: '请选择是否最高学历' },
        { prop: 'verificationStatus', label: '验证状态', type: 'select', visible: true, placeholder: '请选择验证状态' }
      ]
    }
  ]);
}

// 医生培训记录搜索配置
export function createDoctorTrainingSearchConfig() {
  return new SearchConfigManager('doctorTraining', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'trainingName', label: '培训名称', type: 'input', visible: true, placeholder: '请输入培训名称' },
        { prop: 'trainingType', label: '培训类型', type: 'select', visible: true, placeholder: '请选择培训类型' },
        { prop: 'trainingInstitution', label: '培训机构', type: 'input', visible: true, placeholder: '请输入培训机构' },
        { prop: 'trainingLocation', label: '培训地点', type: 'input', visible: true, placeholder: '请输入培训地点' }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'startDate', 
          label: '开始日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'startDateStart', 
          endProp: 'startDateEnd' 
        },
        { 
          prop: 'endDate', 
          label: '结束日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'endDateStart', 
          endProp: 'endDateEnd' 
        }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'completionStatus', label: '完成状态', type: 'select', visible: true, placeholder: '请选择完成状态' },
        { prop: 'assessmentResult', label: '考核结果', type: 'select', visible: true, placeholder: '请选择考核结果' }
      ]
    }
  ]);
}

// 医生证书信息搜索配置
export function createDoctorCertificateSearchConfig() {
  return new SearchConfigManager('doctorCertificate', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'certificateName', label: '证书名称', type: 'input', visible: true, placeholder: '请输入证书名称' },
        { prop: 'certificateType', label: '证书类型', type: 'select', visible: true, placeholder: '请选择证书类型' },
        { prop: 'certificateNo', label: '证书编号', type: 'input', visible: true, placeholder: '请输入证书编号' },
        { prop: 'issueUnit', label: '发证单位', type: 'input', visible: true, placeholder: '请输入发证单位' }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true, placeholder: '请输入医生ID' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'issueDate', 
          label: '发证日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'issueDateStart', 
          endProp: 'issueDateEnd' 
        },
        { 
          prop: 'validDate', 
          label: '到期日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'validDateStart', 
          endProp: 'validDateEnd' 
        }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '证书状态', type: 'select', visible: true, placeholder: '请选择证书状态' },
        { prop: 'isPermanent', label: '是否长期有效', type: 'select', visible: true, placeholder: '请选择是否长期有效' }
      ]
    }
  ]);
}

// 医生学术职位搜索配置
export function createDoctorAcademicPositionSearchConfig() {
  return new SearchConfigManager('doctorAcademicPosition', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'positionName', label: '职位名称', type: 'input', visible: true, placeholder: '请输入职位名称' },
        { prop: 'positionLevel', label: '职位级别', type: 'select', visible: true, placeholder: '请选择职位级别' },
        { prop: 'organizationName', label: '所属机构', type: 'input', visible: true, placeholder: '请输入所属机构' },
        { prop: 'department', label: '所属部门', type: 'input', visible: true, placeholder: '请输入所属部门' }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'startDate', 
          label: '任职开始日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'startDateStart', 
          endProp: 'startDateEnd' 
        },
        { 
          prop: 'endDate', 
          label: '任职结束日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'endDateStart', 
          endProp: 'endDateEnd' 
        }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '职位状态', type: 'select', visible: true, placeholder: '请选择职位状态' },
        { prop: 'isCurrent', label: '是否现任', type: 'select', visible: true, placeholder: '请选择是否现任' }
      ]
    }
  ]);
}

// 医生荣誉信息搜索配置
export function createDoctorHonorSearchConfig() {
  return new SearchConfigManager('doctorHonor', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'honorName', label: '荣誉名称', type: 'input', visible: true, placeholder: '请输入荣誉名称' },
        { prop: 'honorType', label: '荣誉类型', type: 'select', visible: true, placeholder: '请选择荣誉类型' },
        { prop: 'honorLevel', label: '荣誉级别', type: 'select', visible: true, placeholder: '请选择荣誉级别' },
        { prop: 'issuingAuthority', label: '颁发机构', type: 'input', visible: true, placeholder: '请输入颁发机构' }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'awardDate', 
          label: '获奖日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'awardDateStart', 
          endProp: 'awardDateEnd' 
        }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '荣誉状态', type: 'select', visible: true, placeholder: '请选择荣誉状态' }
      ]
    }
  ]);
}

// 医生科研项目搜索配置
export function createDoctorResearchProjectSearchConfig() {
  return new SearchConfigManager('doctorResearchProject', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'projectName', label: '项目名称', type: 'input', visible: true, placeholder: '请输入项目名称' },
        { prop: 'projectType', label: '项目类型', type: 'select', visible: true, placeholder: '请选择项目类型' },
        { prop: 'projectLevel', label: '项目级别', type: 'select', visible: true, placeholder: '请选择项目级别' },
        { prop: 'projectNo', label: '项目编号', type: 'input', visible: true, placeholder: '请输入项目编号' }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' }
      ]
    },
    {
      name: 'organization',
      label: '机构信息',
      fields: [
        { prop: 'organizationName', label: '承担单位', type: 'input', visible: true, placeholder: '请输入承担单位' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'startDate', 
          label: '开始日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'startDateStart', 
          endProp: 'startDateEnd' 
        },
        { 
          prop: 'endDate', 
          label: '结束日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'endDateStart', 
          endProp: 'endDateEnd' 
        }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'projectStatus', label: '项目状态', type: 'select', visible: true, placeholder: '请选择项目状态' },
        { prop: 'approvalStatus', label: '审批状态', type: 'select', visible: true, placeholder: '请选择审批状态' }
      ]
    }
  ]);
}

// 医生论文发表搜索配置
export function createDoctorPublicationSearchConfig() {
  return new SearchConfigManager('doctorPublication', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'title', label: '论文标题', type: 'input', visible: true, placeholder: '请输入论文标题' },
        { prop: 'publicationType', label: '发表类型', type: 'select', visible: true, placeholder: '请选择发表类型' },
        { prop: 'journalName', label: '期刊名称', type: 'input', visible: true, placeholder: '请输入期刊名称' },
        { prop: 'publicationNo', label: '发表号', type: 'input', visible: true, placeholder: '请输入发表号' }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' },
        { prop: 'correspondingAuthor', label: '通讯作者', type: 'input', visible: true, placeholder: '请输入通讯作者' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'publicationDate', 
          label: '发表日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'publicationDateStart', 
          endProp: 'publicationDateEnd' 
        },
        { 
          prop: 'acceptanceDate', 
          label: '接收日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'acceptanceDateStart', 
          endProp: 'acceptanceDateEnd' 
        }
      ]
    },
    {
      name: 'metrics',
      label: '指标信息',
      fields: [
        { prop: 'citationCount', label: '引用次数', type: 'numberrange', visible: true, placeholder: '请输入引用次数范围' },
        { prop: 'impactFactor', label: '影响因子', type: 'numberrange', visible: true, placeholder: '请输入影响因子范围' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'publicationStatus', label: '发表状态', type: 'select', visible: true, placeholder: '请选择发表状态' },
        { prop: 'peerReviewStatus', label: '同行评审状态', type: 'select', visible: true, placeholder: '请选择同行评审状态' }
      ]
    }
  ]);
}

// 医生能力评估搜索配置
export function createDoctorAbilityAssessmentSearchConfig() {
  return new SearchConfigManager('doctorAbilityAssessment', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'assessmentName', label: '评估名称', type: 'input', visible: true, placeholder: '请输入评估名称' },
        { prop: 'assessmentType', label: '评估类型', type: 'select', visible: true, placeholder: '请选择评估类型' },
        { prop: 'assessmentPeriod', label: '评估周期', type: 'select', visible: true, placeholder: '请选择评估周期' }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' }
      ]
    },
    {
      name: 'evaluator',
      label: '评估人信息',
      fields: [
        { prop: 'assessorName', label: '评估人姓名', type: 'input', visible: true, placeholder: '请输入评估人姓名' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'assessmentDate', 
          label: '评估日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'assessmentDateStart', 
          endProp: 'assessmentDateEnd' 
        }
      ]
    },
    {
      name: 'score',
      label: '评分信息',
      fields: [
        { prop: 'score', label: '得分', type: 'numberrange', visible: true, placeholder: '请输入得分范围' },
        { prop: 'grade', label: '等级', type: 'select', visible: true, placeholder: '请选择等级' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '评估状态', type: 'select', visible: true, placeholder: '请选择评估状态' }
      ]
    }
  ]);
}

// 医生资格目录搜索配置
export function createDoctorQualificationCatalogSearchConfig() {
  return new SearchConfigManager('doctorQualificationCatalog', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'qualificationName', label: '资格名称', type: 'input', visible: true, placeholder: '请输入资格名称' },
        { prop: 'qualificationType', label: '资格类型', type: 'select', visible: true, placeholder: '请选择资格类型' },
        { prop: 'qualificationLevel', label: '资格级别', type: 'select', visible: true, placeholder: '请选择资格级别' },
        { prop: 'qualificationNo', label: '资格编号', type: 'input', visible: true, placeholder: '请输入资格编号' }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' }
      ]
    },
    {
      name: 'authority',
      label: '机构信息',
      fields: [
        { prop: 'issuingAuthority', label: '发证机构', type: 'input', visible: true, placeholder: '请输入发证机构' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'issueDate', 
          label: '发证日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'issueDateStart', 
          endProp: 'issueDateEnd' 
        },
        { 
          prop: 'expiryDate', 
          label: '到期日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'expiryDateStart', 
          endProp: 'expiryDateEnd' 
        }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '资格状态', type: 'select', visible: true, placeholder: '请选择资格状态' },
        { prop: 'isValid', label: '是否有效', type: 'select', visible: true, placeholder: '请选择是否有效' }
      ]
    }
  ]);
}

// 医生专业评分搜索配置
export function createDoctorProfessionalRatingSearchConfig() {
  return new SearchConfigManager('doctorProfessionalRating', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'ratingName', label: '评分名称', type: 'input', visible: true, placeholder: '请输入评分名称' },
        { prop: 'ratingType', label: '评分类型', type: 'select', visible: true, placeholder: '请选择评分类型' },
        { prop: 'ratingPeriod', label: '评分周期', type: 'select', visible: true, placeholder: '请选择评分周期' }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' }
      ]
    },
    {
      name: 'rater',
      label: '评分人信息',
      fields: [
        { prop: 'raterName', label: '评分人姓名', type: 'input', visible: true, placeholder: '请输入评分人姓名' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'ratingDate', 
          label: '评分日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'ratingDateStart', 
          endProp: 'ratingDateEnd' 
        }
      ]
    },
    {
      name: 'score',
      label: '评分信息',
      fields: [
        { prop: 'totalScore', label: '总分', type: 'numberrange', visible: true, placeholder: '请输入总分范围' },
        { prop: 'grade', label: '等级', type: 'select', visible: true, placeholder: '请选择等级' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '评分状态', type: 'select', visible: true, placeholder: '请选择评分状态' }
      ]
    }
  ]);
}

// 医生不良记录搜索配置
export function createDoctorAdverseRecordSearchConfig() {
  return new SearchConfigManager('doctorAdverseRecord', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'recordType', label: '记录类型', type: 'select', visible: true, placeholder: '请选择记录类型' },
        { prop: 'incidentDescription', label: '事件描述', type: 'input', visible: true, placeholder: '请输入事件描述' },
        { prop: 'severityLevel', label: '严重程度', type: 'select', visible: true, placeholder: '请选择严重程度' }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' }
      ]
    },
    {
      name: 'reporter',
      label: '报告人信息',
      fields: [
        { prop: 'reporterName', label: '报告人姓名', type: 'input', visible: true, placeholder: '请输入报告人姓名' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'incidentDate', 
          label: '事件日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'incidentDateStart', 
          endProp: 'incidentDateEnd' 
        },
        { 
          prop: 'reportDate', 
          label: '报告日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'reportDateStart', 
          endProp: 'reportDateEnd' 
        }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '处理状态', type: 'select', visible: true, placeholder: '请选择处理状态' },
        { prop: 'investigationResult', label: '调查结果', type: 'select', visible: true, placeholder: '请选择调查结果' }
      ]
    }
  ]);
}

// 医生伦理评估搜索配置
export function createDoctorEthicsEvaluationSearchConfig() {
  return new SearchConfigManager('doctorEthicsEvaluation', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'evaluationName', label: '评估名称', type: 'input', visible: true, placeholder: '请输入评估名称' },
        { prop: 'evaluationType', label: '评估类型', type: 'select', visible: true, placeholder: '请选择评估类型' },
        { prop: 'evaluationPeriod', label: '评估周期', type: 'select', visible: true, placeholder: '请选择评估周期' }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' }
      ]
    },
    {
      name: 'evaluator',
      label: '评估人信息',
      fields: [
        { prop: 'evaluatorName', label: '评估人姓名', type: 'input', visible: true, placeholder: '请输入评估人姓名' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'evaluationDate', 
          label: '评估日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'evaluationDateStart', 
          endProp: 'evaluationDateEnd' 
        }
      ]
    },
    {
      name: 'score',
      label: '评分信息',
      fields: [
        { prop: 'score', label: '得分', type: 'numberrange', visible: true, placeholder: '请输入得分范围' },
        { prop: 'grade', label: '等级', type: 'select', visible: true, placeholder: '请选择等级' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '评估状态', type: 'select', visible: true, placeholder: '请选择评估状态' }
      ]
    }
  ]);
}

// 医生电子注册搜索配置
export function createDoctorElectronicRegistrationSearchConfig() {
  return new SearchConfigManager('doctorElectronicRegistration', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'registrationNo', label: '注册编号', type: 'input', visible: true, placeholder: '请输入注册编号' },
        { prop: 'registrationType', label: '注册类型', type: 'select', visible: true, placeholder: '请选择注册类型' },
        { prop: 'registrationLevel', label: '注册级别', type: 'select', visible: true, placeholder: '请选择注册级别' }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' }
      ]
    },
    {
      name: 'authority',
      label: '机构信息',
      fields: [
        { prop: 'registrationAuthority', label: '注册机构', type: 'input', visible: true, placeholder: '请输入注册机构' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'registrationDate', 
          label: '注册日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'registrationDateStart', 
          endProp: 'registrationDateEnd' 
        },
        { 
          prop: 'expiryDate', 
          label: '到期日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'expiryDateStart', 
          endProp: 'expiryDateEnd' 
        },
        { 
          prop: 'renewalDate', 
          label: '续展日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'renewalDateStart', 
          endProp: 'renewalDateEnd' 
        }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '注册状态', type: 'select', visible: true, placeholder: '请选择注册状态' },
        { prop: 'isValid', label: '是否有效', type: 'select', visible: true, placeholder: '请选择是否有效' }
      ]
    }
  ]);
}

// 医生保险代码搜索配置
export function createDoctorInsuranceCodeSearchConfig() {
  return new SearchConfigManager('doctorInsuranceCode', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'insuranceType', label: '保险类型', type: 'select', visible: true, placeholder: '请选择保险类型' },
        { prop: 'insuranceCode', label: '保险代码', type: 'input', visible: true, placeholder: '请输入保险代码' },
        { prop: 'insuranceName', label: '保险名称', type: 'input', visible: true, placeholder: '请输入保险名称' }
      ]
    },
    {
      name: 'doctor',
      label: '医生信息',
      fields: [
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' }
      ]
    },
    {
      name: 'company',
      label: '保险公司信息',
      fields: [
        { prop: 'insuranceCompany', label: '保险公司', type: 'input', visible: true, placeholder: '请输入保险公司' }
      ]
    },
    {
      name: 'amount',
      label: '金额信息',
      fields: [
        { prop: 'coverageAmount', label: '保额', type: 'numberrange', visible: true, placeholder: '请输入保额范围' },
        { prop: 'premiumAmount', label: '保费', type: 'numberrange', visible: true, placeholder: '请输入保费范围' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'effectiveDate', 
          label: '生效日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'effectiveDateStart', 
          endProp: 'effectiveDateEnd' 
        },
        { 
          prop: 'expiryDate', 
          label: '到期日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'expiryDateStart', 
          endProp: 'expiryDateEnd' 
        }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '保险状态', type: 'select', visible: true, placeholder: '请选择保险状态' },
        { prop: 'isActive', label: '是否激活', type: 'select', visible: true, placeholder: '请选择是否激活' }
      ]
    }
  ]);
}

// 医生信息总览搜索配置
export function createDoctorInfoSearchConfig() {
  return new SearchConfigManager('doctorInfo', [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorCode', label: '医生工号', type: 'input', visible: true, placeholder: '请输入医生工号' },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' },
        { prop: 'gender', label: '性别', type: 'select', visible: true, placeholder: '请选择性别' },
        { prop: 'idCard', label: '身份证号', type: 'input', visible: true, placeholder: '请输入身份证号' }
      ]
    },
    {
      name: 'contact',
      label: '联系信息',
      fields: [
        { prop: 'phone', label: '联系电话', type: 'input', visible: true, placeholder: '请输入联系电话' },
        { prop: 'email', label: '电子邮箱', type: 'input', visible: true, placeholder: '请输入电子邮箱' }
      ]
    },
    {
      name: 'department',
      label: '科室信息',
      fields: [
        { prop: 'departmentName', label: '科室名称', type: 'input', visible: true, placeholder: '请输入科室名称' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'title', label: '职称', type: 'select', visible: true, placeholder: '请选择职称' },
        { prop: 'titleLevel', label: '职称级别', type: 'select', visible: true, placeholder: '请选择职称级别' },
        { prop: 'status', label: '工作状态', type: 'select', visible: true, placeholder: '请选择工作状态' },
        { prop: 'maritalStatus', label: '婚姻状况', type: 'select', visible: true, placeholder: '请选择婚姻状况' },
        { prop: 'politicalStatus', label: '政治面貌', type: 'select', visible: true, placeholder: '请选择政治面貌' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { 
          prop: 'entryDate', 
          label: '入职日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'entryDateStart', 
          endProp: 'entryDateEnd' 
        },
        { 
          prop: 'birthDate', 
          label: '出生日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'birthDateStart', 
          endProp: 'birthDateEnd' 
        },
        { 
          prop: 'graduationDate', 
          label: '毕业日期', 
          type: 'daterange', 
          visible: true, 
          startPlaceholder: '开始日期',
          endPlaceholder: '结束日期',
          startProp: 'graduationDateStart', 
          endProp: 'graduationDateEnd' 
        }
      ]
    }
  ]);
}