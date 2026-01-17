import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// surgeryApprovalForm字段配置
export function createSurgeryApprovalFormFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'deptName', label: '申报科室', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'preoperativeDiagnosis', label: '术前诊断', visible: true, type: 'textarea', group: 'basic' },
        { prop: 'surgeryName', label: '手术名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'surgeryLevel', label: '手术级别', visible: true, type: 'input', group: 'basic' },
        { prop: 'status', label: '审批状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'reportDate', label: '申报日期', visible: true, type: 'input', group: 'detail' },
        { prop: 'gender', label: '性别', visible: true, type: 'input', group: 'detail' },
        { prop: 'age', label: '年龄', visible: true, type: 'number', group: 'detail' },
        { prop: 'hospitalNumber', label: '住院号', visible: true, type: 'input', group: 'detail' },
        { prop: 'anesthesiaMethod', label: '麻醉方式', visible: true, type: 'input', group: 'detail' },
        { prop: 'surgeon', label: '术者及职称', visible: true, type: 'input', group: 'detail' },
        { prop: 'assistant', label: '助手及职称', visible: true, type: 'input', group: 'detail' },
        { prop: 'discussionResult', label: '术前讨论结果', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'reportingPhysician', label: '报告医师', visible: true, type: 'input', group: 'detail' },
        { prop: 'reportingDate', label: '报告日期', visible: true, type: 'input', group: 'detail' },
        { prop: 'informedConsent', label: '患者或授权委托人知情同意情况', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'departmentDirector', label: '科室主任签字', visible: true, type: 'input', group: 'detail' },
        { prop: 'departmentDate', label: '科室签字日期', visible: true, type: 'input', group: 'detail' },
        { prop: 'medicalDirector', label: '医务部主任签字', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('surgeryApprovalForm', fieldGroups);
}


// surgeryCatalog字段配置
export function createSurgeryCatalogFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'additionalCode', label: '附加编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'detailCode', label: '细目代码', visible: true, type: 'input', group: 'basic' },
        { prop: 'surgeryName', label: '手术操作名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'surgeryLevel', label: '手术等级', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'category', label: '类别', visible: true, type: 'input', group: 'detail' },
        { prop: 'isEnabled', label: '是否启用', visible: true, type: 'number', group: 'detail' },
        { prop: 'version', label: '版本号', visible: true, type: 'input', group: 'detail' },
        { prop: 'department', label: '所属科室', visible: true, type: 'input', group: 'detail' },
        { prop: 'surgeryCategory', label: '手术分类', visible: true, type: 'input', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('surgeryCatalog', fieldGroups);
}


// surgeryComplicationRecord字段配置
export function createSurgeryComplicationRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'surgeryRecordId', label: '手术记录ID（HIS系统ID）', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医师ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'doctorName', label: '医师姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'surgeryCode', label: '手术编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'surgeryName', label: '手术名称', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'complicationType', label: '并发症类型', visible: true, type: 'input', group: 'detail' },
        { prop: 'complicationDescription', label: '并发症描述', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'complicationLevel', label: '并发症等级', visible: true, type: 'input', group: 'detail' },
        { prop: 'occurrenceTime', label: '发生时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'isPlannedSecondary', label: '是否为非计划二次手术', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('surgeryComplicationRecord', fieldGroups);
}


// surgeryRecord字段配置
export function createSurgeryRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'surgeryRecordId', label: '手术记录ID（HIS系统ID）', visible: true, type: 'input', group: 'basic' },
        { prop: 'applicationId', label: '手术申请ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '主刀医生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'doctorName', label: '主刀医生姓名', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'departmentId', label: '手术科室ID', visible: true, type: 'number', group: 'detail' },
        { prop: 'departmentName', label: '手术科室名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'surgeryCode', label: '手术编码', visible: true, type: 'input', group: 'detail' },
        { prop: 'surgeryName', label: '手术名称', visible: true, type: 'input', group: 'detail' },
        { prop: 'surgeryLevel', label: '手术等级', visible: true, type: 'input', group: 'detail' },
        { prop: 'surgeryType', label: '手术类型', visible: true, type: 'input', group: 'detail' },
        { prop: 'anesthesiaMethod', label: '麻醉方式', visible: true, type: 'input', group: 'detail' },
        { prop: 'surgeryStartTime', label: '手术开始时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'surgeryEndTime', label: '手术结束时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'surgeryDuration', label: '手术时长', visible: true, type: 'number', group: 'detail' },
        { prop: 'asaGrade', label: 'ASA分级', visible: true, type: 'input', group: 'detail' },
        { prop: 'bloodLoss', label: '失血量', visible: true, type: 'number', group: 'detail' },
        { prop: 'surgeryStatus', label: '手术状态', visible: true, type: 'input', group: 'detail' },
        { prop: 'complicationFlag', label: '是否有并发症', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('surgeryRecord', fieldGroups);
}


// surgeryTeam字段配置
export function createSurgeryTeamFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'surgeryRecordId', label: '手术记录ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'doctorName', label: '医生姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'roleType', label: '角色类型 主刀/一助/二助/巡回护士/器械护士/麻醉师', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'qualificationVerify', label: '资格验证 1-已验证 0-未验证', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('surgeryTeam', fieldGroups);
}


// surgeryVideo字段配置
export function createSurgeryVideoFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'surgeryRecordId', label: '手术记录ID', visible: true, type: 'input', group: 'basic' },
        { prop: 'videoNo', label: '视频编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'videoTitle', label: '视频标题', visible: true, type: 'input', group: 'basic' },
        { prop: 'videoType', label: '视频类型 手术全程/关键步骤/教学片段', visible: true, type: 'input', group: 'basic' },
        { prop: 'videoUrl', label: '视频URL', visible: true, type: 'input', group: 'basic' },
        { prop: 'videoDuration', label: '视频时长', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'videoSize', label: '视频大小', visible: true, type: 'number', group: 'detail' },
        { prop: 'videoFormat', label: '视频格式', visible: true, type: 'input', group: 'detail' },
        { prop: 'recordingDevice', label: '录制设备', visible: true, type: 'input', group: 'detail' },
        { prop: 'recordingDoctorId', label: '录制医生ID', visible: true, type: 'number', group: 'detail' },
        { prop: 'recordingDoctorName', label: '录制医生姓名', visible: true, type: 'input', group: 'detail' },
        { prop: 'uploadTime', label: '上传时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'reviewStatus', label: '审核状态 pending-待审核 approved-已通过 rejected-已拒绝', visible: true, type: 'input', group: 'detail' },
        { prop: 'reviewerId', label: '审核人ID', visible: true, type: 'number', group: 'detail' },
        { prop: 'reviewTime', label: '审核时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'reviewComment', label: '审核意见', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'accessLevel', label: '访问级别 internal-院内 public-公开 restricted-受限', visible: true, type: 'input', group: 'detail' }
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

  return new FieldConfigManager('surgeryVideo', fieldGroups);
}


// surgeryWorkloadStatistics字段配置
export function createSurgeryWorkloadStatisticsFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'doctorId', label: '医师ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'doctorName', label: '医师姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'surgeryCode', label: '手术编码', visible: true, type: 'input', group: 'basic' },
        { prop: 'surgeryName', label: '手术名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'surgeryLevel', label: '手术级别', visible: true, type: 'input', group: 'basic' },
        { prop: 'mainOperatorCount', label: '主刀次数', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'surgeryCount', label: '手术数量', visible: true, type: 'number', group: 'detail' },
        { prop: 'firstAssistantCount', label: '一助次数', visible: true, type: 'number', group: 'detail' },
        { prop: 'statisticsYear', label: '统计年份', visible: true, type: 'number', group: 'detail' },
        { prop: 'statisticsMonth', label: '统计月份', visible: true, type: 'number', group: 'detail' }
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

  return new FieldConfigManager('surgeryWorkloadStatistics', fieldGroups);
}
