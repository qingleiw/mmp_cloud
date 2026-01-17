import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// surgeryApprovalForm搜索配置
export function createSurgeryApprovalFormSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'deptName', label: '申报科室', type: 'input', visible: true, placeholder: '请输入申报科室' },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: true, placeholder: '请输入患者姓名' },
        { prop: 'preoperativeDiagnosis', label: '术前诊断', type: 'input', visible: true, placeholder: '请输入术前诊断' },
        { prop: 'surgeryName', label: '手术名称', type: 'input', visible: false, placeholder: '请输入手术名称' },
        { prop: 'surgeryLevel', label: '手术级别', type: 'input', visible: false, placeholder: '请输入手术级别' },
        { prop: 'status', label: '审批状态', type: 'input', visible: false, placeholder: '请输入审批状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'reportDate', label: '申报日期', type: 'input', visible: false, placeholder: '请输入申报日期' },
        { prop: 'gender', label: '性别', type: 'input', visible: false, placeholder: '请输入性别' },
        { prop: 'age', label: '年龄', type: 'number', visible: false, placeholder: '请输入年龄' },
        { prop: 'hospitalNumber', label: '住院号', type: 'input', visible: false, placeholder: '请输入住院号' },
        { prop: 'anesthesiaMethod', label: '麻醉方式', type: 'input', visible: false, placeholder: '请输入麻醉方式' },
        { prop: 'surgeon', label: '术者及职称', type: 'input', visible: false, placeholder: '请输入术者及职称' },
        { prop: 'assistant', label: '助手及职称', type: 'input', visible: false, placeholder: '请输入助手及职称' },
        { prop: 'discussionResult', label: '术前讨论结果', type: 'input', visible: false, placeholder: '请输入术前讨论结果' },
        { prop: 'reportingPhysician', label: '报告医师', type: 'input', visible: false, placeholder: '请输入报告医师' },
        { prop: 'reportingDate', label: '报告日期', type: 'input', visible: false, placeholder: '请输入报告日期' },
        { prop: 'informedConsent', label: '患者或授权委托人知情同意情况', type: 'input', visible: false, placeholder: '请输入患者或授权委托人知情同意情况' },
        { prop: 'departmentDirector', label: '科室主任签字', type: 'input', visible: false, placeholder: '请输入科室主任签字' },
        { prop: 'departmentDate', label: '科室签字日期', type: 'input', visible: false, placeholder: '请输入科室签字日期' },
        { prop: 'medicalDirector', label: '医务部主任签字', type: 'input', visible: false, placeholder: '请输入医务部主任签字' }
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

  return new SearchConfigManager('surgeryApprovalForm', searchFieldGroups);
}


// surgeryCatalog搜索配置
export function createSurgeryCatalogSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'additionalCode', label: '附加编码', type: 'input', visible: true, placeholder: '请输入附加编码' },
        { prop: 'detailCode', label: '细目代码', type: 'input', visible: true, placeholder: '请输入细目代码' },
        { prop: 'surgeryName', label: '手术操作名称', type: 'input', visible: true, placeholder: '请输入手术操作名称' },
        { prop: 'surgeryLevel', label: '手术等级', type: 'input', visible: true, placeholder: '请输入手术等级' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'category', label: '类别', type: 'input', visible: false, placeholder: '请输入类别' },
        { prop: 'isEnabled', label: '是否启用', type: 'number', visible: false, placeholder: '请输入是否启用' },
        { prop: 'version', label: '版本号', type: 'input', visible: false, placeholder: '请输入版本号' },
        { prop: 'department', label: '所属科室', type: 'input', visible: false, placeholder: '请输入所属科室' },
        { prop: 'surgeryCategory', label: '手术分类', type: 'input', visible: false, placeholder: '请输入手术分类' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'updateTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('surgeryCatalog', searchFieldGroups);
}


// surgeryComplicationRecord搜索配置
export function createSurgeryComplicationRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'surgeryRecordId', label: '手术记录ID（HIS系统ID）', type: 'input', visible: true, placeholder: '请输入手术记录ID（HIS系统ID）' },
        { prop: 'doctorId', label: '医师ID', type: 'number', visible: true, placeholder: '请输入医师ID' },
        { prop: 'doctorName', label: '医师姓名', type: 'input', visible: true, placeholder: '请输入医师姓名' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: false, placeholder: '请输入患者ID' },
        { prop: 'surgeryCode', label: '手术编码', type: 'input', visible: false, placeholder: '请输入手术编码' },
        { prop: 'surgeryName', label: '手术名称', type: 'input', visible: false, placeholder: '请输入手术名称' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'complicationType', label: '并发症类型', type: 'input', visible: false, placeholder: '请输入并发症类型' },
        { prop: 'complicationDescription', label: '并发症描述', type: 'input', visible: false, placeholder: '请输入并发症描述' },
        { prop: 'complicationLevel', label: '并发症等级', type: 'input', visible: false, placeholder: '请输入并发症等级' },
        { prop: 'occurrenceTime', label: '发生时间', type: 'daterange', visible: false, placeholder: '请输入发生时间', startProp: 'occurrenceTimeStart', endProp: 'occurrenceTimeEnd' },
        { prop: 'isPlannedSecondary', label: '是否为非计划二次手术', type: 'number', visible: false, placeholder: '请输入是否为非计划二次手术' }
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

  return new SearchConfigManager('surgeryComplicationRecord', searchFieldGroups);
}


// surgeryRecord搜索配置
export function createSurgeryRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'surgeryRecordId', label: '手术记录ID（HIS系统ID）', type: 'input', visible: true, placeholder: '请输入手术记录ID（HIS系统ID）' },
        { prop: 'applicationId', label: '手术申请ID', type: 'number', visible: true, placeholder: '请输入手术申请ID' },
        { prop: 'patientId', label: '患者ID', type: 'input', visible: true, placeholder: '请输入患者ID' },
        { prop: 'patientName', label: '患者姓名', type: 'input', visible: false, placeholder: '请输入患者姓名' },
        { prop: 'doctorId', label: '主刀医生ID', type: 'number', visible: false, placeholder: '请输入主刀医生ID' },
        { prop: 'doctorName', label: '主刀医生姓名', type: 'input', visible: false, placeholder: '请输入主刀医生姓名' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'departmentId', label: '手术科室ID', type: 'number', visible: false, placeholder: '请输入手术科室ID' },
        { prop: 'departmentName', label: '手术科室名称', type: 'input', visible: false, placeholder: '请输入手术科室名称' },
        { prop: 'surgeryCode', label: '手术编码', type: 'input', visible: false, placeholder: '请输入手术编码' },
        { prop: 'surgeryName', label: '手术名称', type: 'input', visible: false, placeholder: '请输入手术名称' },
        { prop: 'surgeryLevel', label: '手术等级', type: 'input', visible: false, placeholder: '请输入手术等级' },
        { prop: 'surgeryType', label: '手术类型', type: 'input', visible: false, placeholder: '请输入手术类型' },
        { prop: 'anesthesiaMethod', label: '麻醉方式', type: 'input', visible: false, placeholder: '请输入麻醉方式' },
        { prop: 'surgeryStartTime', label: '手术开始时间', type: 'daterange', visible: false, placeholder: '请输入手术开始时间', startProp: 'surgeryStartTimeStart', endProp: 'surgeryStartTimeEnd' },
        { prop: 'surgeryEndTime', label: '手术结束时间', type: 'daterange', visible: false, placeholder: '请输入手术结束时间', startProp: 'surgeryEndTimeStart', endProp: 'surgeryEndTimeEnd' },
        { prop: 'surgeryDuration', label: '手术时长', type: 'number', visible: false, placeholder: '请输入手术时长' },
        { prop: 'asaGrade', label: 'ASA分级', type: 'input', visible: false, placeholder: '请输入ASA分级' },
        { prop: 'bloodLoss', label: '失血量', type: 'number', visible: false, placeholder: '请输入失血量' },
        { prop: 'surgeryStatus', label: '手术状态', type: 'input', visible: false, placeholder: '请输入手术状态' },
        { prop: 'complicationFlag', label: '是否有并发症', type: 'number', visible: false, placeholder: '请输入是否有并发症' }
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

  return new SearchConfigManager('surgeryRecord', searchFieldGroups);
}


// surgeryTeam搜索配置
export function createSurgeryTeamSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'surgeryRecordId', label: '手术记录ID', type: 'input', visible: true, placeholder: '请输入手术记录ID' },
        { prop: 'doctorId', label: '医生ID', type: 'number', visible: true, placeholder: '请输入医生ID' },
        { prop: 'doctorName', label: '医生姓名', type: 'input', visible: true, placeholder: '请输入医生姓名' },
        { prop: 'roleType', label: '角色类型 主刀/一助/二助/巡回护士/器械护士/麻醉师', type: 'input', visible: false, placeholder: '请输入角色类型 主刀/一助/二助/巡回护士/器械护士/麻醉师' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'qualificationVerify', label: '资格验证 1-已验证 0-未验证', type: 'number', visible: false, placeholder: '请输入资格验证 1-已验证 0-未验证' }
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

  return new SearchConfigManager('surgeryTeam', searchFieldGroups);
}


// surgeryVideo搜索配置
export function createSurgeryVideoSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'surgeryRecordId', label: '手术记录ID', type: 'input', visible: true, placeholder: '请输入手术记录ID' },
        { prop: 'videoNo', label: '视频编号', type: 'input', visible: true, placeholder: '请输入视频编号' },
        { prop: 'videoTitle', label: '视频标题', type: 'input', visible: true, placeholder: '请输入视频标题' },
        { prop: 'videoType', label: '视频类型 手术全程/关键步骤/教学片段', type: 'input', visible: false, placeholder: '请输入视频类型 手术全程/关键步骤/教学片段' },
        { prop: 'videoUrl', label: '视频URL', type: 'input', visible: false, placeholder: '请输入视频URL' },
        { prop: 'videoDuration', label: '视频时长', type: 'number', visible: false, placeholder: '请输入视频时长' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'videoSize', label: '视频大小', type: 'number', visible: false, placeholder: '请输入视频大小' },
        { prop: 'videoFormat', label: '视频格式', type: 'input', visible: false, placeholder: '请输入视频格式' },
        { prop: 'recordingDevice', label: '录制设备', type: 'input', visible: false, placeholder: '请输入录制设备' },
        { prop: 'recordingDoctorId', label: '录制医生ID', type: 'number', visible: false, placeholder: '请输入录制医生ID' },
        { prop: 'recordingDoctorName', label: '录制医生姓名', type: 'input', visible: false, placeholder: '请输入录制医生姓名' },
        { prop: 'uploadTime', label: '上传时间', type: 'daterange', visible: false, placeholder: '请输入上传时间', startProp: 'uploadTimeStart', endProp: 'uploadTimeEnd' },
        { prop: 'reviewStatus', label: '审核状态 pending-待审核 approved-已通过 rejected-已拒绝', type: 'input', visible: false, placeholder: '请输入审核状态 pending-待审核 approved-已通过 rejected-已拒绝' },
        { prop: 'reviewerId', label: '审核人ID', type: 'number', visible: false, placeholder: '请输入审核人ID' },
        { prop: 'reviewTime', label: '审核时间', type: 'daterange', visible: false, placeholder: '请输入审核时间', startProp: 'reviewTimeStart', endProp: 'reviewTimeEnd' },
        { prop: 'reviewComment', label: '审核意见', type: 'input', visible: false, placeholder: '请输入审核意见' },
        { prop: 'accessLevel', label: '访问级别 internal-院内 public-公开 restricted-受限', type: 'input', visible: false, placeholder: '请输入访问级别 internal-院内 public-公开 restricted-受限' }
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

  return new SearchConfigManager('surgeryVideo', searchFieldGroups);
}


// surgeryWorkloadStatistics搜索配置
export function createSurgeryWorkloadStatisticsSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'doctorId', label: '医师ID', type: 'number', visible: true, placeholder: '请输入医师ID' },
        { prop: 'doctorName', label: '医师姓名', type: 'input', visible: true, placeholder: '请输入医师姓名' },
        { prop: 'surgeryCode', label: '手术编码', type: 'input', visible: true, placeholder: '请输入手术编码' },
        { prop: 'surgeryName', label: '手术名称', type: 'input', visible: false, placeholder: '请输入手术名称' },
        { prop: 'surgeryLevel', label: '手术级别', type: 'input', visible: false, placeholder: '请输入手术级别' },
        { prop: 'mainOperatorCount', label: '主刀次数', type: 'number', visible: false, placeholder: '请输入主刀次数' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'surgeryCount', label: '手术数量', type: 'number', visible: false, placeholder: '请输入手术数量' },
        { prop: 'firstAssistantCount', label: '一助次数', type: 'number', visible: false, placeholder: '请输入一助次数' },
        { prop: 'statisticsYear', label: '统计年份', type: 'number', visible: false, placeholder: '请输入统计年份' },
        { prop: 'statisticsMonth', label: '统计月份', type: 'number', visible: false, placeholder: '请输入统计月份' }
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

  return new SearchConfigManager('surgeryWorkloadStatistics', searchFieldGroups);
}
