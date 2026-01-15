import { SearchConfigManager, type SearchFieldGroup } from '../../searchConfig';

// 医生基本信息搜索配置
export function createDoctorBasicInfoSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorCode', label: '医生工号', type: 'input', visible: true },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true },
        { prop: 'gender', label: '性别', type: 'select', visible: true, options: [
          { label: '男', value: '1' },
          { label: '女', value: '2' }
        ]},
        {
          prop: 'birthDate',
          label: '出生日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择出生日期' }
        }
      ]
    },
    {
      name: 'contact',
      label: '联系信息',
      fields: [
        { prop: 'phone', label: '联系电话', type: 'input', visible: true },
        { prop: 'email', label: '电子邮箱', type: 'input', visible: true }
      ]
    },
    {
      name: 'work',
      label: '工作信息',
      fields: [
        { prop: 'departmentName', label: '科室名称', type: 'input', visible: true },
        { prop: 'title', label: '职称', type: 'input', visible: true },
        { prop: 'status', label: '状态', type: 'select', visible: true, options: [
          { label: '在职', value: '1' },
          { label: '离职', value: '0' }
        ]},
        {
          prop: 'entryDate',
          label: '入职日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择入职日期' }
        }
      ]
    }
  ];
  return new SearchConfigManager('doctorBasicInfo', fieldGroups);
}

// 医生工作经验搜索配置
export function createDoctorWorkExperienceSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true },
        { prop: 'companyName', label: '工作单位', type: 'input', visible: true },
        { prop: 'department', label: '科室/部门', type: 'input', visible: true },
        { prop: 'position', label: '职位', type: 'input', visible: true }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
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
    }
  ];
  return new SearchConfigManager('doctorWorkExperience', fieldGroups);
}

// 医生学历搜索配置
export function createDoctorEducationSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true },
        { prop: 'schoolName', label: '学校名称', type: 'input', visible: true },
        { prop: 'major', label: '专业', type: 'input', visible: true },
        { prop: 'educationLevel', label: '学历层次', type: 'input', visible: true },
        { prop: 'degree', label: '学位', type: 'input', visible: true }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        {
          prop: 'enrollmentDate',
          label: '入学日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择入学日期' }
        },
        {
          prop: 'graduationDate',
          label: '毕业日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择毕业日期' }
        }
      ]
    }
  ];
  return new SearchConfigManager('doctorEducation', fieldGroups);
}

// 医生培训记录搜索配置
export function createDoctorTrainingSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true },
        { prop: 'trainingName', label: '培训名称', type: 'input', visible: true },
        { prop: 'trainingType', label: '培训类型', type: 'input', visible: true },
        { prop: 'trainingInstitution', label: '培训机构', type: 'input', visible: true }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
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
    }
  ];
  return new SearchConfigManager('doctorTraining', fieldGroups);
}

// 医生不良记录搜索配置
export function createDoctorAdverseRecordSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true },
        { prop: 'recordType', label: '记录类型', type: 'input', visible: true },
        {
          prop: 'recordDate',
          label: '记录日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择记录日期' }
        },
        { prop: 'recordLevel', label: '记录等级', type: 'input', visible: true }
      ]
    }
  ];
  return new SearchConfigManager('doctorAdverseRecord', fieldGroups);
}

// 医生电子注册搜索配置
export function createDoctorElectronicRegistrationSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true },
        { prop: 'registrationNo', label: '注册编号', type: 'input', visible: true },
        { prop: 'registrationType', label: '注册类型', type: 'input', visible: true },
        { prop: 'practiceCategory', label: '执业类别', type: 'input', visible: true }
      ]
    },
    {
      name: 'validity',
      label: '有效期信息',
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
        },
        { prop: 'status', label: '状态', type: 'input', visible: true }
      ]
    }
  ];
  return new SearchConfigManager('doctorElectronicRegistration', fieldGroups);
}

// 医生伦理评估搜索配置
export function createDoctorEthicsEvaluationSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true },
        { prop: 'evaluationYear', label: '评估年份', type: 'input', visible: true },
        { prop: 'evaluationQuarter', label: '评估季度', type: 'input', visible: true },
        { prop: 'evaluationType', label: '评估类型', type: 'input', visible: true }
      ]
    },
    {
      name: 'score',
      label: '评分信息',
      fields: [
        { prop: 'professionalEthicsScore', label: '职业道德评分', type: 'input', visible: true },
        { prop: 'patientRightsScore', label: '患者权益评分', type: 'input', visible: true },
        { prop: 'medicalSafetyScore', label: '医疗安全评分', type: 'input', visible: true },
        { prop: 'totalScore', label: '总评分', type: 'input', visible: true },
        { prop: 'evaluationLevel', label: '评估等级', type: 'input', visible: true }
      ]
    }
  ];
  return new SearchConfigManager('doctorEthicsEvaluation', fieldGroups);
}

// 医生医保医师码搜索配置
export function createDoctorInsuranceCodeSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true },
        { prop: 'insuranceCode', label: '医保医师码', type: 'input', visible: true },
        { prop: 'insuranceType', label: '医保类型', type: 'input', visible: true }
      ]
    },
    {
      name: 'validity',
      label: '有效期信息',
      fields: [
        {
          prop: 'validDate',
          label: '有效期至',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择有效期至' }
        },
        { prop: 'status', label: '状态', type: 'input', visible: true },
        {
          prop: 'applyDate',
          label: '申请日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择申请日期' }
        },
        {
          prop: 'approveDate',
          label: '批准日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择批准日期' }
        }
      ]
    }
  ];
  return new SearchConfigManager('doctorInsuranceCode', fieldGroups);
}

// 医生职业评分搜索配置
export function createDoctorProfessionalRatingSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true },
        { prop: 'ratingYear', label: '评分年份', type: 'input', visible: true },
        { prop: 'ratingQuarter', label: '评分季度', type: 'input', visible: true }
      ]
    },
    {
      name: 'score',
      label: '评分信息',
      fields: [
        { prop: 'baseScore', label: '基础得分', type: 'input', visible: true },
        { prop: 'complaintDeduction', label: '投诉扣分', type: 'input', visible: true },
        { prop: 'medicalQualityScore', label: '医疗质量得分', type: 'input', visible: true },
        { prop: 'patientSatisfaction', label: '患者满意度', type: 'input', visible: true },
        { prop: 'finalScore', label: '最终得分', type: 'input', visible: true },
        { prop: 'ratingLevel', label: '评分等级', type: 'input', visible: true }
      ]
    }
  ];
  return new SearchConfigManager('doctorProfessionalRating', fieldGroups);
}

// 医生出版物搜索配置
export function createDoctorPublicationSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true },
        { prop: 'publicationTitle', label: '发表标题', type: 'input', visible: true },
        { prop: 'publicationType', label: '发表类型', type: 'input', visible: true },
        { prop: 'journalName', label: '期刊名称', type: 'input', visible: true }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'authors', label: '作者', type: 'input', visible: true },
        { prop: 'correspondingAuthor', label: '通讯作者', type: 'input', visible: true },
        {
          prop: 'publicationDate',
          label: '发表日期',
          type: 'date',
          visible: true,
          componentProps: { type: 'date', valueFormat: 'YYYY-MM-DD', placeholder: '请选择发表日期' }
        },
        { prop: 'doi', label: 'DOI', type: 'input', visible: true },
        { prop: 'impactFactor', label: '影响因子', type: 'input', visible: true }
      ]
    }
  ];
  return new SearchConfigManager('doctorPublication', fieldGroups);
}

// 医生资质目录搜索配置
export function createDoctorQualificationCatalogSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'catalogCode', label: '资质编码', type: 'input', visible: true },
        { prop: 'catalogName', label: '资质名称', type: 'input', visible: true },
        { prop: 'catalogLevel', label: '资质等级', type: 'input', visible: true },
        { prop: 'catalogType', label: '资质类型', type: 'input', visible: true },
        { prop: 'subType', label: '子类型', type: 'input', visible: true }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'description', label: '描述', type: 'input', visible: true },
        { prop: 'isEnabled', label: '是否启用', type: 'select', visible: true, options: [
          { label: '启用', value: '1' },
          { label: '禁用', value: '0' }
        ]}
      ]
    }
  ];
  return new SearchConfigManager('doctorQualificationCatalog', fieldGroups);
}

// 医生研究项目搜索配置
export function createDoctorResearchProjectSearchConfig() {
  const fieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'doctorId', label: '医生ID', type: 'input', visible: true },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true },
        { prop: 'projectName', label: '项目名称', type: 'input', visible: true },
        { prop: 'projectCode', label: '项目编号', type: 'input', visible: true },
        { prop: 'projectType', label: '项目类型', type: 'input', visible: true },
        { prop: 'projectLevel', label: '项目等级', type: 'input', visible: true }
      ]
    },
    {
      name: 'funding',
      label: '经费信息',
      fields: [
        { prop: 'fundingSource', label: '经费来源', type: 'input', visible: true },
        { prop: 'totalFunding', label: '总经费', type: 'input', visible: true },
        { prop: 'personalFunding', label: '个人经费', type: 'input', visible: true }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
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
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'projectStatus', label: '项目状态', type: 'input', visible: true },
        { prop: 'progress', label: '进度', type: 'input', visible: true },
        { prop: 'completionRate', label: '完成率', type: 'input', visible: true }
      ]
    }
  ];
  return new SearchConfigManager('doctorResearchProject', fieldGroups);
}

// 医生证书搜索配置
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

// 医生学术职称搜索配置
export function createDoctorAcademicPositionSearchConfig() {
  const fieldGroups: SearchGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        {
          prop: 'doctorId',
          label: '医生ID',
          type: 'input',
          visible: true,
          componentProps: { placeholder: '请输入医生ID' }
        },
        {
          prop: 'organization',
          label: '任职机构',
          type: 'input',
          visible: true,
          componentProps: { placeholder: '请输入任职机构' }
        },
        {
          prop: 'position',
          label: '学术职务',
          type: 'input',
          visible: true,
          componentProps: { placeholder: '请输入学术职务' }
        },
        {
          prop: 'positionLevel',
          label: '职务级别',
          type: 'input',
          visible: true,
          componentProps: { placeholder: '请输入职务级别' }
        }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
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
        },
        {
          prop: 'isCurrent',
          label: '是否当前',
          type: 'select',
          visible: true,
          componentProps: {
            placeholder: '请选择是否当前',
            options: [
              { label: '是', value: 1 },
              { label: '否', value: 0 }
            ]
          }
        }
      ]
    },
    {
      name: 'attachment',
      label: '附件信息',
      fields: [
        {
          prop: 'appointmentUrl',
          label: '任命书URL',
          type: 'input',
          visible: false,
          componentProps: { placeholder: '请输入任命书URL' }
        }
      ]
    },
    {
      name: 'other',
      label: '其他',
      fields: [
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];

  return new SearchConfigManager('doctorAcademicPosition', fieldGroups);
}

// 医生荣誉搜索配置
export function createDoctorHonorSearchConfig() {
  const fieldGroups: SearchGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        {
          prop: 'doctorId',
          label: '医生ID',
          type: 'input',
          visible: true,
          componentProps: { placeholder: '请输入医生ID' }
        },
        {
          prop: 'honorName',
          label: '荣誉名称',
          type: 'input',
          visible: true,
          componentProps: { placeholder: '请输入荣誉名称' }
        },
        {
          prop: 'honorLevel',
          label: '荣誉等级',
          type: 'input',
          visible: true,
          componentProps: { placeholder: '请输入荣誉等级' }
        },
        {
          prop: 'awardUnit',
          label: '授予单位',
          type: 'input',
          visible: true,
          componentProps: { placeholder: '请输入授予单位' }
        }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
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
      name: 'certificate',
      label: '证书信息',
      fields: [
        {
          prop: 'certificateNo',
          label: '证书编号',
          type: 'input',
          visible: false,
          componentProps: { placeholder: '请输入证书编号' }
        },
        {
          prop: 'certificateUrl',
          label: '证书附件URL',
          type: 'input',
          visible: false,
          componentProps: { placeholder: '请输入证书附件URL' }
        }
      ]
    },
    {
      name: 'other',
      label: '其他',
      fields: [
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];

  return new SearchConfigManager('doctorHonor', fieldGroups);
}

// 医生能力评估搜索配置
export function createDoctorAbilityAssessmentSearchConfig() {
  const fieldGroups: SearchGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        {
          prop: 'doctorId',
          label: '医生ID',
          type: 'input',
          visible: true,
          componentProps: { placeholder: '请输入医生ID' }
        },
        {
          prop: 'assessmentYear',
          label: '评估年度',
          type: 'input',
          visible: true,
          componentProps: { placeholder: '请输入评估年度' }
        },
        {
          prop: 'assessmentType',
          label: '评估类型',
          type: 'input',
          visible: true,
          componentProps: { placeholder: '请输入评估类型' }
        }
      ]
    },
    {
      name: 'scores',
      label: '能力评分',
      fields: [
        {
          prop: 'clinicalAbilityScore',
          label: '临床能力评分',
          type: 'input',
          visible: false,
          componentProps: { placeholder: '请输入临床能力评分' }
        },
        {
          prop: 'teachingAbilityScore',
          label: '教学能力评分',
          type: 'input',
          visible: false,
          componentProps: { placeholder: '请输入教学能力评分' }
        },
        {
          prop: 'researchAbilityScore',
          label: '科研能力评分',
          type: 'input',
          visible: false,
          componentProps: { placeholder: '请输入科研能力评分' }
        },
        {
          prop: 'managementAbilityScore',
          label: '管理能力评分',
          type: 'input',
          visible: false,
          componentProps: { placeholder: '请输入管理能力评分' }
        },
        {
          prop: 'totalScore',
          label: '总评分',
          type: 'input',
          visible: true,
          componentProps: { placeholder: '请输入总评分' }
        }
      ]
    },
    {
      name: 'result',
      label: '评估结果',
      fields: [
        {
          prop: 'assessmentResult',
          label: '评估结果',
          type: 'input',
          visible: true,
          componentProps: { placeholder: '请输入评估结果' }
        },
        {
          prop: 'assessor',
          label: '评估人',
          type: 'input',
          visible: true,
          componentProps: { placeholder: '请输入评估人' }
        },
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
      name: 'other',
      label: '其他',
      fields: [
        { prop: 'delFlag', label: '删除标志', type: 'input', visible: false }
      ]
    }
  ];

  return new SearchConfigManager('doctorAbilityAssessment', fieldGroups);
}