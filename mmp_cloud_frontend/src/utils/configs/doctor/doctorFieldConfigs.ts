import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// doctorAbilityAssessment字段配置
export function createDoctorAbilityAssessmentFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'assessmentType', label: '评估类型', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'assessmentYear', label: '评估年度', visible: true, type: 'number', group: 'detail' },
        { prop: 'clinicalAbilityScore', label: '临床能力得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'teachingAbilityScore', label: '教学能力得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'researchAbilityScore', label: '科研能力得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'managementAbilityScore', label: '管理能力得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'totalScore', label: '总分', visible: true, type: 'number', group: 'detail' },
        { prop: 'assessmentResult', label: '评估结果 优秀/良好/合格/不合格', visible: true, type: 'input', group: 'detail' },
        { prop: 'assessor', label: '评估人', visible: true, type: 'input', group: 'detail' },
        { prop: 'assessmentDate', label: '评估日期', visible: true, type: 'date', group: 'detail' }
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

  return new FieldConfigManager('doctorAbilityAssessment', fieldGroups);
}


// doctorAcademicPosition字段配置
export function createDoctorAcademicPositionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'positionLevel', label: '职务级别', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'organization', label: '学术组织', visible: true, type: 'input', group: 'detail' },
        { prop: 'position', label: '职务', visible: true, type: 'input', group: 'detail' },
        { prop: 'startDate', label: '任职开始日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'endDate', label: '任职结束日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'isCurrent', label: '是否现任 1-是 0-否', visible: true, type: 'number', group: 'detail' },
        { prop: 'appointmentUrl', label: '任职证明URL', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('doctorAcademicPosition', fieldGroups);
}


// doctorAdverseRecord字段配置
export function createDoctorAdverseRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'recordType', label: '记录类型 医疗事故/差错/违规', visible: true, type: 'input', group: 'basic' },
        { prop: 'recordTitle', label: '记录标题', visible: true, type: 'input', group: 'basic' },
        { prop: 'recordStatus', label: '记录状态 待处理/处理中/已处理', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'occurDate', label: '发生日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'description', label: '事件描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'consequence', label: '后果', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'handlingMeasure', label: '处理措施', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'punishment', label: '处罚情况', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('doctorAdverseRecord', fieldGroups);
}


// doctorBasicInfo字段配置
export function createDoctorBasicInfoFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorCode', label: '医生工号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'idCard', label: '身份证号', visible: true, type: 'input', group: 'basic' },
        { prop: 'deptId', label: '科室ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'departmentName', label: '科室名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'title', label: '职称', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'gender', label: '性别 1-男 2-女', visible: true, type: 'number', group: 'detail' },
        { prop: 'birthDate', label: '出生日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'phone', label: '联系电话', visible: true, type: 'input', group: 'detail' },
        { prop: 'email', label: '电子邮箱', visible: true, type: 'input', group: 'detail' },
        { prop: 'photoUrl', label: '照片URL', visible: true, type: 'input', group: 'detail' },
        { prop: 'titleLevel', label: '职称级别 1-初级 2-中级 3-副高 4-正高', visible: true, type: 'number', group: 'detail' },
        { prop: 'status', label: '状态 1-在职 2-离职 3-退休', visible: true, type: 'number', group: 'detail' },
        { prop: 'entryDate', label: '入职日期', visible: true, type: 'date', group: 'detail' }
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

  return new FieldConfigManager('doctorBasicInfo', fieldGroups);
}


// doctorCertificate字段配置
export function createDoctorCertificateFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'certificateType', label: '证书类型 执业/资格/培训等', visible: true, type: 'input', group: 'basic' },
        { prop: 'certificateName', label: '证书名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'certificateNo', label: '证书编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'validDate', label: '有效期至', visible: true, type: 'date', group: 'basic' },
        { prop: 'status', label: '状态 1-有效 2-即将到期 3-已过期 4-已注销', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'issueUnit', label: '发证机构', visible: true, type: 'input', group: 'detail' },
        { prop: 'issueDate', label: '发证日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'isPermanent', label: '是否长期有效 1-是 0-否', visible: true, type: 'number', group: 'detail' },
        { prop: 'certificateUrl', label: '证书附件URL', visible: true, type: 'input', group: 'detail' },
        { prop: 'remindDays', label: '提前提醒天数', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('doctorCertificate', fieldGroups);
}


// doctorEducation字段配置
export function createDoctorEducationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'schoolName', label: '学校名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'educationLevel', label: '学历 本科/硕士/博士', visible: true, type: 'input', group: 'basic' },
        { prop: 'certificateNo', label: '证书编号', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'major', label: '专业', visible: true, type: 'input', group: 'detail' },
        { prop: 'degree', label: '学位', visible: true, type: 'input', group: 'detail' },
        { prop: 'startDate', label: '开始日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'endDate', label: '结束日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'isFullTime', label: '是否全日制 1-是 0-否', visible: true, type: 'number', group: 'detail' },
        { prop: 'certificateUrl', label: '证书附件URL', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('doctorEducation', fieldGroups);
}


// doctorElectronicRegistration字段配置
export function createDoctorElectronicRegistrationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'registrationNo', label: '注册编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'registrationType', label: '注册类型 首次注册/变更注册/多机构备案', visible: true, type: 'input', group: 'basic' },
        { prop: 'validDate', label: '有效期至', visible: true, type: 'date', group: 'basic' },
        { prop: 'registrationStatus', label: '注册状态 有效/注销/吊销', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'practiceCategory', label: '执业类别', visible: true, type: 'input', group: 'detail' },
        { prop: 'practiceScope', label: '执业范围', visible: true, type: 'input', group: 'detail' },
        { prop: 'practiceLocation', label: '执业地点', visible: true, type: 'input', group: 'detail' },
        { prop: 'issueDate', label: '发证日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'registrationAuthority', label: '注册机关', visible: true, type: 'input', group: 'detail' },
        { prop: 'multiInstitutionFlag', label: '是否多机构备案 1-是 0-否', visible: true, type: 'number', group: 'detail' },
        { prop: 'certificateUrl', label: '证书附件URL', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('doctorElectronicRegistration', fieldGroups);
}


// doctorEthicsEvaluation字段配置
export function createDoctorEthicsEvaluationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'evaluationYear', label: '考评年度', visible: true, type: 'number', group: 'detail' },
        { prop: 'evaluationCycle', label: '考评周期', visible: true, type: 'input', group: 'detail' },
        { prop: 'selfScore', label: '自评得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'peerScore', label: '同行评议得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'patientScore', label: '患者评价得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'departmentScore', label: '科室评价得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'hospitalScore', label: '医院评价得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'totalScore', label: '总分', visible: true, type: 'number', group: 'detail' },
        { prop: 'evaluationResult', label: '考评结果 优秀/良好/合格/不合格', visible: true, type: 'input', group: 'detail' },
        { prop: 'rewardPunishment', label: '奖惩情况', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('doctorEthicsEvaluation', fieldGroups);
}


// doctorHonor字段配置
export function createDoctorHonorFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'honorName', label: '荣誉名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'honorLevel', label: '荣誉级别 国家级/省级/市级/院级', visible: true, type: 'input', group: 'basic' },
        { prop: 'certificateNo', label: '证书编号', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'awardUnit', label: '授予单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'awardDate', label: '获得日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'certificateUrl', label: '证书附件URL', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('doctorHonor', fieldGroups);
}


// doctorInsuranceCode字段配置
export function createDoctorInsuranceCodeFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'insuranceCode', label: '医保医师码', visible: true, type: 'input', group: 'basic' },
        { prop: 'insuranceType', label: '医保类型 职工医保/居民医保/生育保险', visible: true, type: 'input', group: 'basic' },
        { prop: 'validDate', label: '有效期至', visible: true, type: 'date', group: 'basic' },
        { prop: 'status', label: '状态 有效/暂停/注销', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'applyDate', label: '申请日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'approveDate', label: '审批日期', visible: true, type: 'date', group: 'detail' }
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

  return new FieldConfigManager('doctorInsuranceCode', fieldGroups);
}


// doctorProfessionalRating字段配置
export function createDoctorProfessionalRatingFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医师ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'doctorName', label: '医师姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'ratingLevel', label: '评分等级', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'ratingYear', label: '评分年份', visible: true, type: 'number', group: 'detail' },
        { prop: 'ratingQuarter', label: '评分季度', visible: true, type: 'number', group: 'detail' },
        { prop: 'baseScore', label: '基础分数', visible: true, type: 'number', group: 'detail' },
        { prop: 'complaintDeduction', label: '投诉扣分', visible: true, type: 'number', group: 'detail' },
        { prop: 'medicalQualityScore', label: '医疗质量评分', visible: true, type: 'number', group: 'detail' },
        { prop: 'patientSatisfaction', label: '患者满意度', visible: true, type: 'number', group: 'detail' },
        { prop: 'finalScore', label: '最终得分', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('doctorProfessionalRating', fieldGroups);
}


// doctorPublication字段配置
export function createDoctorPublicationFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'publicationType', label: '类型 论文/论著/专利', visible: true, type: 'input', group: 'basic' },
        { prop: 'title', label: '标题', visible: true, type: 'input', group: 'basic' },
        { prop: 'journalName', label: '期刊名称/出版社', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'authors', label: '作者', visible: true, type: 'input', group: 'detail' },
        { prop: 'authorOrder', label: '作者排序', visible: true, type: 'number', group: 'detail' },
        { prop: 'publishDate', label: '发表日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'volume', label: '卷号', visible: true, type: 'input', group: 'detail' },
        { prop: 'issue', label: '期号', visible: true, type: 'input', group: 'detail' },
        { prop: 'pages', label: '页码', visible: true, type: 'input', group: 'detail' },
        { prop: 'doi', label: 'DOI', visible: true, type: 'input', group: 'detail' },
        { prop: 'impactFactor', label: '影响因子', visible: true, type: 'number', group: 'detail' },
        { prop: 'citationCount', label: '引用次数', visible: true, type: 'number', group: 'detail' },
        { prop: 'fullTextUrl', label: '全文URL', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('doctorPublication', fieldGroups);
}


// doctorQualificationCatalog字段配置
export function createDoctorQualificationCatalogFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'catalogCode', label: '资质编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'catalogName', label: '资质名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'parentId', label: '父级ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'catalogLevel', label: '目录层级 1-一级 2-二级 3-三级 4-四级', visible: true, type: 'number', group: 'basic' },
        { prop: 'catalogType', label: '资质类型 手术分级/有创操作/限制类技术/处方权/会诊权/其他', visible: true, type: 'input', group: 'basic' },
        { prop: 'subType', label: '资质子类型', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'operationCode', label: '手术操作编码（对应ICD-9-CM附加编码）', visible: true, type: 'input', group: 'detail' },
        { prop: 'category', label: '类别（手术/介入治疗）', visible: true, type: 'input', group: 'detail' },
        { prop: 'hospitalLevel', label: '院内手术等级（三级手术/四级手术）', visible: true, type: 'input', group: 'detail' },
        { prop: 'description', label: '资质描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'sortOrder', label: '排序', visible: true, type: 'number', group: 'detail' },
        { prop: 'isEnabled', label: '是否启用 1-是 0-否', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('doctorQualificationCatalog', fieldGroups);
}


// doctorResearchProject字段配置
export function createDoctorResearchProjectFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'projectName', label: '项目名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectNo', label: '项目编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectLevel', label: '项目级别 国家级/省级/市级/院级', visible: true, type: 'input', group: 'basic' },
        { prop: 'projectType', label: '项目类型', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '项目状态 在研/结题/终止', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'role', label: '承担角色 主持人/参与人', visible: true, type: 'input', group: 'detail' },
        { prop: 'startDate', label: '开始日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'endDate', label: '结束日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'fundingAmount', label: '资助金额', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('doctorResearchProject', fieldGroups);
}


// doctorTraining字段配置
export function createDoctorTrainingFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'trainingType', label: '培训类型 进修/继续教育/院内培训', visible: true, type: 'input', group: 'basic' },
        { prop: 'trainingName', label: '培训名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'certificateNo', label: '证书编号', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'trainingUnit', label: '培训单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'startDate', label: '开始日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'endDate', label: '结束日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'trainingHours', label: '培训学时', visible: true, type: 'number', group: 'detail' },
        { prop: 'trainingContent', label: '培训内容', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'trainingResult', label: '培训结果 合格/不合格', visible: true, type: 'input', group: 'detail' },
        { prop: 'certificateUrl', label: '证书附件URL', visible: true, type: 'input', group: 'detail' },
        { prop: 'credits', label: '学分', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('doctorTraining', fieldGroups);
}


// doctorWorkExperience字段配置
export function createDoctorWorkExperienceFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'organization', label: '工作单位', visible: true, type: 'input', group: 'detail' },
        { prop: 'department', label: '部门', visible: true, type: 'input', group: 'detail' },
        { prop: 'position', label: '职位', visible: true, type: 'input', group: 'detail' },
        { prop: 'startDate', label: '开始日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'endDate', label: '结束日期', visible: true, type: 'date', group: 'detail' },
        { prop: 'jobDescription', label: '工作描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'achievements', label: '工作业绩', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'referencePerson', label: '证明人', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('doctorWorkExperience', fieldGroups);
}
