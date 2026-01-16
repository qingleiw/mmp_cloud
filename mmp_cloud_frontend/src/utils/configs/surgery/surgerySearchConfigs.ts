import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// 重大手术申请搜索配置
export function createMajorSurgeryApplicationSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'applicationNo', label: '申请编号', type: 'input', placeholder: '请输入申请编号' },
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' },
        { prop: 'doctorName', label: '申请医师姓名', type: 'input', placeholder: '请输入申请医师姓名' }
      ]
    },
    {
      name: 'department',
      label: '科室信息',
      fields: [
        { prop: 'departmentName', label: '申请科室名称', type: 'input', placeholder: '请输入申请科室名称' }
      ]
    },
    {
      name: 'surgery',
      label: '手术信息',
      fields: [
        { prop: 'surgeryName', label: '拟手术名称', type: 'input', placeholder: '请输入拟手术名称' },
        { prop: 'surgeryRisk', label: '手术风险', type: 'select', placeholder: '请选择手术风险' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'expectedTime', label: '预计手术时间', type: 'daterange', placeholder: '请选择预计手术时间范围' },
        { prop: 'applicationTime', label: '申请时间', type: 'daterange', placeholder: '请选择申请时间范围' }
      ]
    },
    {
      name: 'approval',
      label: '审批信息',
      fields: [
        { prop: 'applicationStatus', label: '申请状态', type: 'select', placeholder: '请选择申请状态' },
        { prop: 'approverName', label: '审批人姓名', type: 'input', placeholder: '请输入审批人姓名' }
      ]
    }
  ];

  return new SearchConfigManager('majorSurgeryApplication', searchFieldGroups);
}

// 手术工作量统计搜索配置
export function createSurgeryWorkloadStatisticsSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'statisticsNo', label: '统计编号', type: 'input', placeholder: '请输入统计编号' },
        { prop: 'departmentName', label: '科室名称', type: 'input', placeholder: '请输入科室名称' }
      ]
    },
    {
      name: 'workload',
      label: '工作量信息',
      fields: [
        { prop: 'surgeryCount', label: '手术数量', type: 'numberrange', placeholder: '请输入手术数量范围' },
        { prop: 'totalWorkload', label: '总工作量', type: 'numberrange', placeholder: '请输入总工作量范围' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'statisticsDate', label: '统计日期', type: 'daterange', placeholder: '请选择统计日期范围' },
        { prop: 'statisticsPeriod', label: '统计周期', type: 'select', placeholder: '请选择统计周期' }
      ]
    },
    {
      name: 'personnel',
      label: '人员信息',
      fields: [
        { prop: 'doctorName', label: '医师姓名', type: 'input', placeholder: '请输入医师姓名' },
        { prop: 'nurseName', label: '护士姓名', type: 'input', placeholder: '请输入护士姓名' }
      ]
    }
  ];

  return new SearchConfigManager('surgeryWorkloadStatistics', searchFieldGroups);
}

// 手术并发症记录搜索配置
export function createSurgeryComplicationRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'recordNo', label: '记录编号', type: 'input', placeholder: '请输入记录编号' },
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' },
        { prop: 'doctorName', label: '手术医师姓名', type: 'input', placeholder: '请输入手术医师姓名' }
      ]
    },
    {
      name: 'complication',
      label: '并发症信息',
      fields: [
        { prop: 'complicationType', label: '并发症类型', type: 'select', placeholder: '请选择并发症类型' },
        { prop: 'complicationGrade', label: '并发症等级', type: 'select', placeholder: '请选择并发症等级' },
        { prop: 'complicationDescription', label: '并发症描述', type: 'input', placeholder: '请输入并发症描述' }
      ]
    },
    {
      name: 'surgery',
      label: '手术信息',
      fields: [
        { prop: 'surgeryName', label: '手术名称', type: 'input', placeholder: '请输入手术名称' },
        { prop: 'surgeryDate', label: '手术日期', type: 'daterange', placeholder: '请选择手术日期范围' }
      ]
    },
    {
      name: 'treatment',
      label: '治疗信息',
      fields: [
        { prop: 'treatmentResult', label: '治疗结果', type: 'select', placeholder: '请选择治疗结果' },
        { prop: 'treatmentMethod', label: '治疗方法', type: 'input', placeholder: '请输入治疗方法' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'occurrenceTime', label: '发生时间', type: 'daterange', placeholder: '请选择发生时间范围' }
      ]
    }
  ];

  return new SearchConfigManager('surgeryComplicationRecord', searchFieldGroups);
}

// 手术团队搜索配置
export function createSurgeryTeamSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'teamNo', label: '团队编号', type: 'input', placeholder: '请输入团队编号' },
        { prop: 'teamName', label: '团队名称', type: 'input', placeholder: '请输入团队名称' },
        { prop: 'teamType', label: '团队类型', type: 'select', placeholder: '请选择团队类型' }
      ]
    },
    {
      name: 'members',
      label: '成员信息',
      fields: [
        { prop: 'leaderName', label: '团队负责人', type: 'input', placeholder: '请输入团队负责人' },
        { prop: 'memberCount', label: '成员数量', type: 'numberrange', placeholder: '请输入成员数量范围' }
      ]
    },
    {
      name: 'specialty',
      label: '专业信息',
      fields: [
        { prop: 'specialty', label: '专业方向', type: 'select', placeholder: '请选择专业方向' },
        { prop: 'skillLevel', label: '技能等级', type: 'select', placeholder: '请选择技能等级' }
      ]
    },
    {
      name: 'status',
      label: '状态信息',
      fields: [
        { prop: 'status', label: '状态', type: 'select', placeholder: '请选择状态' }
      ]
    }
  ];

  return new SearchConfigManager('surgeryTeam', searchFieldGroups);
}

// 手术视频搜索配置
export function createSurgeryVideoSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'videoNo', label: '视频编号', type: 'input', placeholder: '请输入视频编号' },
        { prop: 'videoTitle', label: '视频标题', type: 'input', placeholder: '请输入视频标题' },
        { prop: 'videoType', label: '视频类型', type: 'select', placeholder: '请选择视频类型' }
      ]
    },
    {
      name: 'surgery',
      label: '手术信息',
      fields: [
        { prop: 'surgeryName', label: '手术名称', type: 'input', placeholder: '请输入手术名称' },
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' },
        { prop: 'doctorName', label: '手术医师', type: 'input', placeholder: '请输入手术医师' }
      ]
    },
    {
      name: 'video',
      label: '视频信息',
      fields: [
        { prop: 'duration', label: '视频时长', type: 'numberrange', placeholder: '请输入视频时长范围(分钟)' },
        { prop: 'fileSize', label: '文件大小', type: 'numberrange', placeholder: '请输入文件大小范围(MB)' },
        { prop: 'quality', label: '视频质量', type: 'select', placeholder: '请选择视频质量' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'recordDate', label: '录制日期', type: 'daterange', placeholder: '请选择录制日期范围' },
        { prop: 'uploadDate', label: '上传日期', type: 'daterange', placeholder: '请选择上传日期范围' }
      ]
    },
    {
      name: 'usage',
      label: '使用信息',
      fields: [
        { prop: 'viewCount', label: '观看次数', type: 'numberrange', placeholder: '请输入观看次数范围' },
        { prop: 'downloadCount', label: '下载次数', type: 'numberrange', placeholder: '请输入下载次数范围' }
      ]
    }
  ];

  return new SearchConfigManager('surgeryVideo', searchFieldGroups);
}

// 手术记录搜索配置
export function createSurgeryRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'recordNo', label: '记录编号', type: 'input', placeholder: '请输入记录编号' },
        { prop: 'patientName', label: '患者姓名', type: 'input', placeholder: '请输入患者姓名' },
        { prop: 'patientNo', label: '患者编号', type: 'input', placeholder: '请输入患者编号' }
      ]
    },
    {
      name: 'surgery',
      label: '手术信息',
      fields: [
        { prop: 'surgeryName', label: '手术名称', type: 'input', placeholder: '请输入手术名称' },
        { prop: 'surgeryType', label: '手术类型', type: 'select', placeholder: '请选择手术类型' },
        { prop: 'surgeryLevel', label: '手术等级', type: 'select', placeholder: '请选择手术等级' },
        { prop: 'anesthesiaMethod', label: '麻醉方式', type: 'select', placeholder: '请选择麻醉方式' }
      ]
    },
    {
      name: 'personnel',
      label: '人员信息',
      fields: [
        { prop: 'surgeonName', label: '主刀医师', type: 'input', placeholder: '请输入主刀医师' },
        { prop: 'assistantName', label: '助手医师', type: 'input', placeholder: '请输入助手医师' },
        { prop: 'anesthesiologistName', label: '麻醉医师', type: '请输入麻醉医师' },
        { prop: 'nurseName', label: '手术护士', type: 'input', placeholder: '请输入手术护士' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'surgeryDate', label: '手术日期', type: 'daterange', placeholder: '请选择手术日期范围' },
        { prop: 'startTime', label: '手术开始时间', type: 'daterange', placeholder: '请选择手术开始时间范围' },
        { prop: 'endTime', label: '手术结束时间', type: 'daterange', placeholder: '请选择手术结束时间范围' }
      ]
    },
    {
      name: 'outcome',
      label: '手术结果',
      fields: [
        { prop: 'surgeryResult', label: '手术结果', type: 'select', placeholder: '请选择手术结果' },
        { prop: 'complications', label: '并发症', type: 'select', placeholder: '请选择并发症情况' },
        { prop: 'recoveryStatus', label: '恢复情况', type: 'select', placeholder: '请选择恢复情况' }
      ]
    },
    {
      name: 'department',
      label: '科室信息',
      fields: [
        { prop: 'departmentName', label: '手术科室', type: 'input', placeholder: '请输入手术科室' }
      ]
    }
  ];

  return new SearchConfigManager('surgeryRecord', searchFieldGroups);
}