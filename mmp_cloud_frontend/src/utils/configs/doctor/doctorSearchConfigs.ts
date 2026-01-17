import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// doctorAbilityAssessment搜索配置
export function createDoctorAbilityAssessmentSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医生ID', type: 'number', visible: true, placeholder: '请输入医生ID' },
        { prop: 'assessmentType', label: '评估类型', type: 'input', visible: true, placeholder: '请输入评估类型' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'assessmentYear', label: '评估年度', type: 'number', visible: true, placeholder: '请输入评估年度' },
        { prop: 'clinicalAbilityScore', label: '临床能力得分', type: 'number', visible: false, placeholder: '请输入临床能力得分' },
        { prop: 'teachingAbilityScore', label: '教学能力得分', type: 'number', visible: false, placeholder: '请输入教学能力得分' },
        { prop: 'researchAbilityScore', label: '科研能力得分', type: 'number', visible: false, placeholder: '请输入科研能力得分' },
        { prop: 'managementAbilityScore', label: '管理能力得分', type: 'number', visible: false, placeholder: '请输入管理能力得分' },
        { prop: 'totalScore', label: '总分', type: 'number', visible: false, placeholder: '请输入总分' },
        { prop: 'assessmentResult', label: '评估结果 优秀/良好/合格/不合格', type: 'input', visible: false, placeholder: '请输入评估结果 优秀/良好/合格/不合格' },
        { prop: 'assessor', label: '评估人', type: 'input', visible: false, placeholder: '请输入评估人' },
        { prop: 'assessmentDate', label: '评估日期', type: 'daterange', visible: false, placeholder: '请输入评估日期', startProp: 'assessmentDateStart', endProp: 'assessmentDateEnd' }
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

  return new SearchConfigManager('doctorAbilityAssessment', searchFieldGroups);
}


// doctorAcademicPosition搜索配置
export function createDoctorAcademicPositionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医生ID', type: 'number', visible: true, placeholder: '请输入医生ID' },
        { prop: 'positionLevel', label: '职务级别', type: 'input', visible: true, placeholder: '请输入职务级别' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'organization', label: '学术组织', type: 'input', visible: true, placeholder: '请输入学术组织' },
        { prop: 'position', label: '职务', type: 'input', visible: false, placeholder: '请输入职务' },
        { prop: 'startDate', label: '任职开始日期', type: 'daterange', visible: false, placeholder: '请输入任职开始日期', startProp: 'startDateStart', endProp: 'startDateEnd' },
        { prop: 'endDate', label: '任职结束日期', type: 'daterange', visible: false, placeholder: '请输入任职结束日期', startProp: 'endDateStart', endProp: 'endDateEnd' },
        { prop: 'isCurrent', label: '是否现任 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否现任 1-是 0-否' },
        { prop: 'appointmentUrl', label: '任职证明URL', type: 'input', visible: false, placeholder: '请输入任职证明URL' }
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

  return new SearchConfigManager('doctorAcademicPosition', searchFieldGroups);
}


// doctorAdverseRecord搜索配置
export function createDoctorAdverseRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医生ID', type: 'number', visible: true, placeholder: '请输入医生ID' },
        { prop: 'recordType', label: '记录类型 医疗事故/差错/违规', type: 'input', visible: true, placeholder: '请输入记录类型 医疗事故/差错/违规' },
        { prop: 'recordTitle', label: '记录标题', type: 'input', visible: true, placeholder: '请输入记录标题' },
        { prop: 'recordStatus', label: '记录状态 待处理/处理中/已处理', type: 'input', visible: false, placeholder: '请输入记录状态 待处理/处理中/已处理' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'occurDate', label: '发生日期', type: 'daterange', visible: false, placeholder: '请输入发生日期', startProp: 'occurDateStart', endProp: 'occurDateEnd' },
        { prop: 'description', label: '事件描述', type: 'input', visible: false, placeholder: '请输入事件描述' },
        { prop: 'consequence', label: '后果', type: 'input', visible: false, placeholder: '请输入后果' },
        { prop: 'handlingMeasure', label: '处理措施', type: 'input', visible: false, placeholder: '请输入处理措施' },
        { prop: 'punishment', label: '处罚情况', type: 'input', visible: false, placeholder: '请输入处罚情况' }
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

  return new SearchConfigManager('doctorAdverseRecord', searchFieldGroups);
}


// doctorBasicInfo搜索配置
export function createDoctorBasicInfoSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorCode', label: '医生工号', type: 'input', visible: true, placeholder: '请输入医生工号' },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' },
        { prop: 'idCard', label: '身份证号', type: 'input', visible: true, placeholder: '请输入身份证号' },
        { prop: 'deptId', label: '科室ID', type: 'number', visible: false, placeholder: '请输入科室ID' },
        { prop: 'departmentName', label: '科室名称', type: 'input', visible: false, placeholder: '请输入科室名称' },
        { prop: 'title', label: '职称', type: 'input', visible: false, placeholder: '请输入职称' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'gender', label: '性别 1-男 2-女', type: 'number', visible: false, placeholder: '请输入性别 1-男 2-女' },
        { prop: 'birthDate', label: '出生日期', type: 'daterange', visible: false, placeholder: '请输入出生日期', startProp: 'birthDateStart', endProp: 'birthDateEnd' },
        { prop: 'phone', label: '联系电话', type: 'input', visible: false, placeholder: '请输入联系电话' },
        { prop: 'email', label: '电子邮箱', type: 'input', visible: false, placeholder: '请输入电子邮箱' },
        { prop: 'photoUrl', label: '照片URL', type: 'input', visible: false, placeholder: '请输入照片URL' },
        { prop: 'titleLevel', label: '职称级别 1-初级 2-中级 3-副高 4-正高', type: 'number', visible: false, placeholder: '请输入职称级别 1-初级 2-中级 3-副高 4-正高' },
        { prop: 'status', label: '状态 1-在职 2-离职 3-退休', type: 'number', visible: false, placeholder: '请输入状态 1-在职 2-离职 3-退休' },
        { prop: 'entryDate', label: '入职日期', type: 'daterange', visible: false, placeholder: '请输入入职日期', startProp: 'entryDateStart', endProp: 'entryDateEnd' }
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

  return new SearchConfigManager('doctorBasicInfo', searchFieldGroups);
}


// doctorCertificate搜索配置
export function createDoctorCertificateSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医生ID', type: 'number', visible: true, placeholder: '请输入医生ID' },
        { prop: 'certificateType', label: '证书类型 执业/资格/培训等', type: 'input', visible: true, placeholder: '请输入证书类型 执业/资格/培训等' },
        { prop: 'certificateName', label: '证书名称', type: 'input', visible: true, placeholder: '请输入证书名称' },
        { prop: 'certificateNo', label: '证书编号', type: 'input', visible: false, placeholder: '请输入证书编号' },
        { prop: 'validDate', label: '有效期至', type: 'daterange', visible: false, placeholder: '请输入有效期至', startProp: 'validDateStart', endProp: 'validDateEnd' },
        { prop: 'status', label: '状态 1-有效 2-即将到期 3-已过期 4-已注销', type: 'number', visible: false, placeholder: '请输入状态 1-有效 2-即将到期 3-已过期 4-已注销' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'issueUnit', label: '发证机构', type: 'input', visible: false, placeholder: '请输入发证机构' },
        { prop: 'issueDate', label: '发证日期', type: 'daterange', visible: false, placeholder: '请输入发证日期', startProp: 'issueDateStart', endProp: 'issueDateEnd' },
        { prop: 'isPermanent', label: '是否长期有效 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否长期有效 1-是 0-否' },
        { prop: 'certificateUrl', label: '证书附件URL', type: 'input', visible: false, placeholder: '请输入证书附件URL' },
        { prop: 'remindDays', label: '提前提醒天数', type: 'number', visible: false, placeholder: '请输入提前提醒天数' }
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

  return new SearchConfigManager('doctorCertificate', searchFieldGroups);
}


// doctorEducation搜索配置
export function createDoctorEducationSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医生ID', type: 'number', visible: true, placeholder: '请输入医生ID' },
        { prop: 'schoolName', label: '学校名称', type: 'input', visible: true, placeholder: '请输入学校名称' },
        { prop: 'educationLevel', label: '学历 本科/硕士/博士', type: 'input', visible: true, placeholder: '请输入学历 本科/硕士/博士' },
        { prop: 'certificateNo', label: '证书编号', type: 'input', visible: false, placeholder: '请输入证书编号' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'major', label: '专业', type: 'input', visible: false, placeholder: '请输入专业' },
        { prop: 'degree', label: '学位', type: 'input', visible: false, placeholder: '请输入学位' },
        { prop: 'startDate', label: '开始日期', type: 'daterange', visible: false, placeholder: '请输入开始日期', startProp: 'startDateStart', endProp: 'startDateEnd' },
        { prop: 'endDate', label: '结束日期', type: 'daterange', visible: false, placeholder: '请输入结束日期', startProp: 'endDateStart', endProp: 'endDateEnd' },
        { prop: 'isFullTime', label: '是否全日制 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否全日制 1-是 0-否' },
        { prop: 'certificateUrl', label: '证书附件URL', type: 'input', visible: false, placeholder: '请输入证书附件URL' }
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

  return new SearchConfigManager('doctorEducation', searchFieldGroups);
}


// doctorElectronicRegistration搜索配置
export function createDoctorElectronicRegistrationSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医生ID', type: 'number', visible: true, placeholder: '请输入医生ID' },
        { prop: 'registrationNo', label: '注册编号', type: 'input', visible: true, placeholder: '请输入注册编号' },
        { prop: 'registrationType', label: '注册类型 首次注册/变更注册/多机构备案', type: 'input', visible: true, placeholder: '请输入注册类型 首次注册/变更注册/多机构备案' },
        { prop: 'validDate', label: '有效期至', type: 'daterange', visible: false, placeholder: '请输入有效期至', startProp: 'validDateStart', endProp: 'validDateEnd' },
        { prop: 'registrationStatus', label: '注册状态 有效/注销/吊销', type: 'input', visible: false, placeholder: '请输入注册状态 有效/注销/吊销' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'practiceCategory', label: '执业类别', type: 'input', visible: false, placeholder: '请输入执业类别' },
        { prop: 'practiceScope', label: '执业范围', type: 'input', visible: false, placeholder: '请输入执业范围' },
        { prop: 'practiceLocation', label: '执业地点', type: 'input', visible: false, placeholder: '请输入执业地点' },
        { prop: 'issueDate', label: '发证日期', type: 'daterange', visible: false, placeholder: '请输入发证日期', startProp: 'issueDateStart', endProp: 'issueDateEnd' },
        { prop: 'registrationAuthority', label: '注册机关', type: 'input', visible: false, placeholder: '请输入注册机关' },
        { prop: 'multiInstitutionFlag', label: '是否多机构备案 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否多机构备案 1-是 0-否' },
        { prop: 'certificateUrl', label: '证书附件URL', type: 'input', visible: false, placeholder: '请输入证书附件URL' }
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

  return new SearchConfigManager('doctorElectronicRegistration', searchFieldGroups);
}


// doctorEthicsEvaluation搜索配置
export function createDoctorEthicsEvaluationSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医生ID', type: 'number', visible: true, placeholder: '请输入医生ID' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'evaluationYear', label: '考评年度', type: 'number', visible: true, placeholder: '请输入考评年度' },
        { prop: 'evaluationCycle', label: '考评周期', type: 'input', visible: true, placeholder: '请输入考评周期' },
        { prop: 'selfScore', label: '自评得分', type: 'number', visible: false, placeholder: '请输入自评得分' },
        { prop: 'peerScore', label: '同行评议得分', type: 'number', visible: false, placeholder: '请输入同行评议得分' },
        { prop: 'patientScore', label: '患者评价得分', type: 'number', visible: false, placeholder: '请输入患者评价得分' },
        { prop: 'departmentScore', label: '科室评价得分', type: 'number', visible: false, placeholder: '请输入科室评价得分' },
        { prop: 'hospitalScore', label: '医院评价得分', type: 'number', visible: false, placeholder: '请输入医院评价得分' },
        { prop: 'totalScore', label: '总分', type: 'number', visible: false, placeholder: '请输入总分' },
        { prop: 'evaluationResult', label: '考评结果 优秀/良好/合格/不合格', type: 'input', visible: false, placeholder: '请输入考评结果 优秀/良好/合格/不合格' },
        { prop: 'rewardPunishment', label: '奖惩情况', type: 'input', visible: false, placeholder: '请输入奖惩情况' }
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

  return new SearchConfigManager('doctorEthicsEvaluation', searchFieldGroups);
}


// doctorHonor搜索配置
export function createDoctorHonorSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医生ID', type: 'number', visible: true, placeholder: '请输入医生ID' },
        { prop: 'honorName', label: '荣誉名称', type: 'input', visible: true, placeholder: '请输入荣誉名称' },
        { prop: 'honorLevel', label: '荣誉级别 国家级/省级/市级/院级', type: 'input', visible: true, placeholder: '请输入荣誉级别 国家级/省级/市级/院级' },
        { prop: 'certificateNo', label: '证书编号', type: 'input', visible: false, placeholder: '请输入证书编号' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'awardUnit', label: '授予单位', type: 'input', visible: false, placeholder: '请输入授予单位' },
        { prop: 'awardDate', label: '获得日期', type: 'daterange', visible: false, placeholder: '请输入获得日期', startProp: 'awardDateStart', endProp: 'awardDateEnd' },
        { prop: 'certificateUrl', label: '证书附件URL', type: 'input', visible: false, placeholder: '请输入证书附件URL' }
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

  return new SearchConfigManager('doctorHonor', searchFieldGroups);
}


// doctorInsuranceCode搜索配置
export function createDoctorInsuranceCodeSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医生ID', type: 'number', visible: true, placeholder: '请输入医生ID' },
        { prop: 'insuranceCode', label: '医保医师码', type: 'input', visible: true, placeholder: '请输入医保医师码' },
        { prop: 'insuranceType', label: '医保类型 职工医保/居民医保/生育保险', type: 'input', visible: true, placeholder: '请输入医保类型 职工医保/居民医保/生育保险' },
        { prop: 'validDate', label: '有效期至', type: 'daterange', visible: false, placeholder: '请输入有效期至', startProp: 'validDateStart', endProp: 'validDateEnd' },
        { prop: 'status', label: '状态 有效/暂停/注销', type: 'input', visible: false, placeholder: '请输入状态 有效/暂停/注销' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'applyDate', label: '申请日期', type: 'daterange', visible: false, placeholder: '请输入申请日期', startProp: 'applyDateStart', endProp: 'applyDateEnd' },
        { prop: 'approveDate', label: '审批日期', type: 'daterange', visible: false, placeholder: '请输入审批日期', startProp: 'approveDateStart', endProp: 'approveDateEnd' }
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

  return new SearchConfigManager('doctorInsuranceCode', searchFieldGroups);
}


// doctorProfessionalRating搜索配置
export function createDoctorProfessionalRatingSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医师ID', type: 'number', visible: true, placeholder: '请输入医师ID' },
        { prop: 'doctorName', label: '医师姓名', type: 'input', visible: true, placeholder: '请输入医师姓名' },
        { prop: 'ratingLevel', label: '评分等级', type: 'input', visible: true, placeholder: '请输入评分等级' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'ratingYear', label: '评分年份', type: 'number', visible: false, placeholder: '请输入评分年份' },
        { prop: 'ratingQuarter', label: '评分季度', type: 'number', visible: false, placeholder: '请输入评分季度' },
        { prop: 'baseScore', label: '基础分数', type: 'number', visible: false, placeholder: '请输入基础分数' },
        { prop: 'complaintDeduction', label: '投诉扣分', type: 'number', visible: false, placeholder: '请输入投诉扣分' },
        { prop: 'medicalQualityScore', label: '医疗质量评分', type: 'number', visible: false, placeholder: '请输入医疗质量评分' },
        { prop: 'patientSatisfaction', label: '患者满意度', type: 'number', visible: false, placeholder: '请输入患者满意度' },
        { prop: 'finalScore', label: '最终得分', type: 'number', visible: false, placeholder: '请输入最终得分' }
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

  return new SearchConfigManager('doctorProfessionalRating', searchFieldGroups);
}


// doctorPublication搜索配置
export function createDoctorPublicationSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医生ID', type: 'number', visible: true, placeholder: '请输入医生ID' },
        { prop: 'publicationType', label: '类型 论文/论著/专利', type: 'input', visible: true, placeholder: '请输入类型 论文/论著/专利' },
        { prop: 'title', label: '标题', type: 'input', visible: true, placeholder: '请输入标题' },
        { prop: 'journalName', label: '期刊名称/出版社', type: 'input', visible: false, placeholder: '请输入期刊名称/出版社' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'authors', label: '作者', type: 'input', visible: false, placeholder: '请输入作者' },
        { prop: 'authorOrder', label: '作者排序', type: 'number', visible: false, placeholder: '请输入作者排序' },
        { prop: 'publishDate', label: '发表日期', type: 'daterange', visible: false, placeholder: '请输入发表日期', startProp: 'publishDateStart', endProp: 'publishDateEnd' },
        { prop: 'volume', label: '卷号', type: 'input', visible: false, placeholder: '请输入卷号' },
        { prop: 'issue', label: '期号', type: 'input', visible: false, placeholder: '请输入期号' },
        { prop: 'pages', label: '页码', type: 'input', visible: false, placeholder: '请输入页码' },
        { prop: 'doi', label: 'DOI', type: 'input', visible: false, placeholder: '请输入DOI' },
        { prop: 'impactFactor', label: '影响因子', type: 'number', visible: false, placeholder: '请输入影响因子' },
        { prop: 'citationCount', label: '引用次数', type: 'number', visible: false, placeholder: '请输入引用次数' },
        { prop: 'fullTextUrl', label: '全文URL', type: 'input', visible: false, placeholder: '请输入全文URL' }
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

  return new SearchConfigManager('doctorPublication', searchFieldGroups);
}


// doctorQualificationCatalog搜索配置
export function createDoctorQualificationCatalogSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'catalogCode', label: '资质编码', type: 'input', visible: true, placeholder: '请输入资质编码' },
        { prop: 'catalogName', label: '资质名称', type: 'input', visible: true, placeholder: '请输入资质名称' },
        { prop: 'parentId', label: '父级ID', type: 'number', visible: true, placeholder: '请输入父级ID' },
        { prop: 'catalogLevel', label: '目录层级 1-一级 2-二级 3-三级 4-四级', type: 'number', visible: false, placeholder: '请输入目录层级 1-一级 2-二级 3-三级 4-四级' },
        { prop: 'catalogType', label: '资质类型 手术分级/有创操作/限制类技术/处方权/会诊权/其他', type: 'input', visible: false, placeholder: '请输入资质类型 手术分级/有创操作/限制类技术/处方权/会诊权/其他' },
        { prop: 'subType', label: '资质子类型', type: 'input', visible: false, placeholder: '请输入资质子类型' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'operationCode', label: '手术操作编码（对应ICD-9-CM附加编码）', type: 'input', visible: false, placeholder: '请输入手术操作编码（对应ICD-9-CM附加编码）' },
        { prop: 'category', label: '类别（手术/介入治疗）', type: 'input', visible: false, placeholder: '请输入类别（手术/介入治疗）' },
        { prop: 'hospitalLevel', label: '院内手术等级（三级手术/四级手术）', type: 'input', visible: false, placeholder: '请输入院内手术等级（三级手术/四级手术）' },
        { prop: 'description', label: '资质描述', type: 'input', visible: false, placeholder: '请输入资质描述' },
        { prop: 'sortOrder', label: '排序', type: 'number', visible: false, placeholder: '请输入排序' },
        { prop: 'isEnabled', label: '是否启用 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否启用 1-是 0-否' }
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

  return new SearchConfigManager('doctorQualificationCatalog', searchFieldGroups);
}


// doctorResearchProject搜索配置
export function createDoctorResearchProjectSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医生ID', type: 'number', visible: true, placeholder: '请输入医生ID' },
        { prop: 'projectName', label: '项目名称', type: 'input', visible: true, placeholder: '请输入项目名称' },
        { prop: 'projectNo', label: '项目编号', type: 'input', visible: true, placeholder: '请输入项目编号' },
        { prop: 'projectLevel', label: '项目级别 国家级/省级/市级/院级', type: 'input', visible: false, placeholder: '请输入项目级别 国家级/省级/市级/院级' },
        { prop: 'projectType', label: '项目类型', type: 'input', visible: false, placeholder: '请输入项目类型' },
        { prop: 'status', label: '项目状态 在研/结题/终止', type: 'input', visible: false, placeholder: '请输入项目状态 在研/结题/终止' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'role', label: '承担角色 主持人/参与人', type: 'input', visible: false, placeholder: '请输入承担角色 主持人/参与人' },
        { prop: 'startDate', label: '开始日期', type: 'daterange', visible: false, placeholder: '请输入开始日期', startProp: 'startDateStart', endProp: 'startDateEnd' },
        { prop: 'endDate', label: '结束日期', type: 'daterange', visible: false, placeholder: '请输入结束日期', startProp: 'endDateStart', endProp: 'endDateEnd' },
        { prop: 'fundingAmount', label: '资助金额', type: 'number', visible: false, placeholder: '请输入资助金额' }
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

  return new SearchConfigManager('doctorResearchProject', searchFieldGroups);
}


// doctorTraining搜索配置
export function createDoctorTrainingSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医生ID', type: 'number', visible: true, placeholder: '请输入医生ID' },
        { prop: 'trainingType', label: '培训类型 进修/继续教育/院内培训', type: 'input', visible: true, placeholder: '请输入培训类型 进修/继续教育/院内培训' },
        { prop: 'trainingName', label: '培训名称', type: 'input', visible: true, placeholder: '请输入培训名称' },
        { prop: 'certificateNo', label: '证书编号', type: 'input', visible: false, placeholder: '请输入证书编号' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'trainingUnit', label: '培训单位', type: 'input', visible: false, placeholder: '请输入培训单位' },
        { prop: 'startDate', label: '开始日期', type: 'daterange', visible: false, placeholder: '请输入开始日期', startProp: 'startDateStart', endProp: 'startDateEnd' },
        { prop: 'endDate', label: '结束日期', type: 'daterange', visible: false, placeholder: '请输入结束日期', startProp: 'endDateStart', endProp: 'endDateEnd' },
        { prop: 'trainingHours', label: '培训学时', type: 'number', visible: false, placeholder: '请输入培训学时' },
        { prop: 'trainingContent', label: '培训内容', type: 'input', visible: false, placeholder: '请输入培训内容' },
        { prop: 'trainingResult', label: '培训结果 合格/不合格', type: 'input', visible: false, placeholder: '请输入培训结果 合格/不合格' },
        { prop: 'certificateUrl', label: '证书附件URL', type: 'input', visible: false, placeholder: '请输入证书附件URL' },
        { prop: 'credits', label: '学分', type: 'number', visible: false, placeholder: '请输入学分' }
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

  return new SearchConfigManager('doctorTraining', searchFieldGroups);
}


// doctorWorkExperience搜索配置
export function createDoctorWorkExperienceSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医生ID', type: 'number', visible: true, placeholder: '请输入医生ID' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'organization', label: '工作单位', type: 'input', visible: true, placeholder: '请输入工作单位' },
        { prop: 'department', label: '部门', type: 'input', visible: true, placeholder: '请输入部门' },
        { prop: 'position', label: '职位', type: 'input', visible: false, placeholder: '请输入职位' },
        { prop: 'startDate', label: '开始日期', type: 'daterange', visible: false, placeholder: '请输入开始日期', startProp: 'startDateStart', endProp: 'startDateEnd' },
        { prop: 'endDate', label: '结束日期', type: 'daterange', visible: false, placeholder: '请输入结束日期', startProp: 'endDateStart', endProp: 'endDateEnd' },
        { prop: 'jobDescription', label: '工作描述', type: 'input', visible: false, placeholder: '请输入工作描述' },
        { prop: 'achievements', label: '工作业绩', type: 'input', visible: false, placeholder: '请输入工作业绩' },
        { prop: 'referencePerson', label: '证明人', type: 'input', visible: false, placeholder: '请输入证明人' }
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

  return new SearchConfigManager('doctorWorkExperience', searchFieldGroups);
}
