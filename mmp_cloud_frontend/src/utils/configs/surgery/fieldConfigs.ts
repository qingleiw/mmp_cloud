import { FieldConfigManager, FieldGroup } from '../../fieldConfigManager';

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

// 手术记录字段配置
export function createSurgeryRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基本信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: false, group: 'basic' },
        { prop: 'surgeryRecordId', label: '手术记录ID', visible: false, group: 'basic' },
        { prop: 'applicationId', label: '手术申请ID', visible: false, group: 'basic' },
        { prop: 'patientId', label: '患者ID', visible: false, group: 'basic' },
        { prop: 'patientName', label: '患者姓名', visible: true, required: true, group: 'basic' },
        { prop: 'doctorId', label: '主刀医生ID', visible: false, group: 'basic' },
        { prop: 'doctorName', label: '主刀医生姓名', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'department',
      label: '科室信息',
      fields: [
        { prop: 'departmentId', label: '手术科室ID', visible: false, group: 'department' },
        { prop: 'departmentName', label: '手术科室名称', visible: true, required: true, group: 'department' }
      ]
    },
    {
      name: 'surgery',
      label: '手术信息',
      fields: [
        { prop: 'surgeryCode', label: '手术编码', visible: true, required: true, group: 'surgery' },
        { prop: 'surgeryName', label: '手术名称', visible: true, required: true, group: 'surgery' },
        { prop: 'surgeryLevel', label: '手术等级', visible: true, group: 'surgery' },
        { prop: 'surgeryType', label: '手术类型', visible: true, group: 'surgery' },
        { prop: 'anesthesiaMethod', label: '麻醉方式', visible: true, group: 'surgery' }
      ]
    },
    {
      name: 'time',
      label: '时间信息',
      fields: [
        { prop: 'surgeryStartTime', label: '手术开始时间', visible: true, required: true, width: '180', group: 'time' },
        { prop: 'surgeryEndTime', label: '手术结束时间', visible: true, width: '180', group: 'time' },
        { prop: 'surgeryDuration', label: '手术时长(分钟)', visible: true, group: 'time' }
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

  return new FieldConfigManager('surgeryRecord', fieldGroups);
}