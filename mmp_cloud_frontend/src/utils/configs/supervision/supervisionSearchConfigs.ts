import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// 监管检查记录搜索配置
export function createSupervisionInspectionRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'inspectionNo', label: '检查编号', type: 'input', placeholder: '请输入检查编号' },
        { prop: 'inspectionTitle', label: '检查标题', type: 'input', placeholder: '请输入检查标题' },
        { prop: 'inspectionType', label: '检查类型', type: 'select', placeholder: '请选择检查类型' }
      ]
    },
    {
      name: 'organization',
      label: '组织信息',
      fields: [
        { prop: 'inspectedOrganization', label: '被检查单位', type: 'input', placeholder: '请输入被检查单位' },
        { prop: 'organizationType', label: '单位类型', type: 'select', placeholder: '请选择单位类型' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'inspectionDate', label: '检查日期', type: 'daterange', placeholder: '请选择检查日期范围' }
      ]
    },
    {
      name: 'team',
      label: '检查团队',
      fields: [
        { prop: 'inspectionLeader', label: '检查组长', type: 'input', placeholder: '请输入检查组长' },
        { prop: 'supervisoryAuthority', label: '监管机构', type: 'input', placeholder: '请输入监管机构' }
      ]
    },
    {
      name: 'result',
      label: '检查结果',
      fields: [
        { prop: 'inspectionGrade', label: '检查等级', type: 'select', placeholder: '请选择检查等级' },
        { prop: 'rectificationRequired', label: '是否需要整改', type: 'select', placeholder: '请选择是否需要整改' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionInspectionRecord', searchFieldGroups);
}

// 监管整改通知搜索配置
export function createSupervisionRectificationNoticeSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'noticeNo', label: '通知编号', type: 'input', placeholder: '请输入通知编号' },
        { prop: 'noticeTitle', label: '通知标题', type: 'input', placeholder: '请输入通知标题' }
      ]
    },
    {
      name: 'organization',
      label: '被通知单位',
      fields: [
        { prop: 'notifiedOrganization', label: '被通知单位', type: 'input', placeholder: '请输入被通知单位' },
        { prop: 'organizationType', label: '单位类型', type: 'select', placeholder: '请选择单位类型' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'noticeDate', label: '通知日期', type: 'daterange', placeholder: '请选择通知日期范围' },
        { prop: 'rectificationDeadline', label: '整改期限', type: 'daterange', placeholder: '请选择整改期限范围' }
      ]
    },
    {
      name: 'issues',
      label: '问题信息',
      fields: [
        { prop: 'severityLevels', label: '严重程度', type: 'select', placeholder: '请选择严重程度' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionRectificationNotice', searchFieldGroups);
}

// 监管整改报告搜索配置
export function createSupervisionRectificationReportSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'reportNo', label: '报告编号', type: 'input', placeholder: '请输入报告编号' },
        { prop: 'reportTitle', label: '报告标题', type: 'input', placeholder: '请输入报告标题' }
      ]
    },
    {
      name: 'organization',
      label: '报告单位',
      fields: [
        { prop: 'reportingOrganization', label: '报告单位', type: 'input', placeholder: '请输入报告单位' },
        { prop: 'organizationType', label: '单位类型', type: 'select', placeholder: '请选择单位类型' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'reportDate', label: '报告日期', type: 'daterange', placeholder: '请选择报告日期范围' },
        { prop: 'expectedCompletionDate', label: '预计完成日期', type: 'daterange', placeholder: '请选择预计完成日期范围' }
      ]
    },
    {
      name: 'progress',
      label: '整改进度',
      fields: [
        { prop: 'completionRate', label: '完成率', type: 'numberrange', placeholder: '请输入完成率范围' }
      ]
    },
    {
      name: 'verification',
      label: '验收信息',
      fields: [
        { prop: 'verificationResult', label: '验收结果', type: 'select', placeholder: '请选择验收结果' },
        { prop: 'verifier', label: '验收人', type: 'input', placeholder: '请输入验收人' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionRectificationReport', searchFieldGroups);
}

// 监管处罚决定搜索配置
export function createSupervisionPenaltyDecisionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'decisionNo', label: '决定编号', type: 'input', placeholder: '请输入决定编号' },
        { prop: 'decisionTitle', label: '决定标题', type: 'input', placeholder: '请输入决定标题' }
      ]
    },
    {
      name: 'organization',
      label: '被处罚单位',
      fields: [
        { prop: 'penalizedOrganization', label: '被处罚单位', type: 'input', placeholder: '请输入被处罚单位' },
        { prop: 'organizationType', label: '单位类型', type: 'select', placeholder: '请选择单位类型' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'decisionDate', label: '决定日期', type: 'daterange', placeholder: '请选择决定日期范围' },
        { prop: 'executionDeadline', label: '执行期限', type: 'daterange', placeholder: '请选择执行期限范围' }
      ]
    },
    {
      name: 'violations',
      label: '违法信息',
      fields: [
        { prop: 'violationCategory', label: '违法类别', type: 'select', placeholder: '请选择违法类别' },
        { prop: 'violationSeverity', label: '违法严重程度', type: 'select', placeholder: '请选择违法严重程度' }
      ]
    },
    {
      name: 'penalty',
      label: '处罚信息',
      fields: [
        { prop: 'penaltyType', label: '处罚类型', type: 'select', placeholder: '请选择处罚类型' },
        { prop: 'penaltyAmount', label: '罚款金额', type: 'numberrange', placeholder: '请输入罚款金额范围' }
      ]
    },
    {
      name: 'execution',
      label: '执行信息',
      fields: [
        { prop: 'executionStatus', label: '执行状态', type: 'select', placeholder: '请选择执行状态' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionPenaltyDecision', searchFieldGroups);
}

// 监管工作计划搜索配置
export function createSupervisionWorkPlanSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'planNo', label: '计划编号', type: 'input', placeholder: '请输入计划编号' },
        { prop: 'planTitle', label: '计划标题', type: 'input', placeholder: '请输入计划标题' },
        { prop: 'planYear', label: '计划年度', type: 'input', placeholder: '请输入计划年度' },
        { prop: 'planType', label: '计划类型', type: 'select', placeholder: '请选择计划类型' }
      ]
    },
    {
      name: 'schedule',
      label: '时间安排',
      fields: [
        { prop: 'startDate', label: '开始日期', type: 'daterange', placeholder: '请选择开始日期范围' },
        { prop: 'endDate', label: '结束日期', type: 'daterange', placeholder: '请选择结束日期范围' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionWorkPlan', searchFieldGroups);
}

// 监管统计报告搜索配置
export function createSupervisionStatisticsReportSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'reportNo', label: '报告编号', type: 'input', placeholder: '请输入报告编号' },
        { prop: 'reportTitle', label: '报告标题', type: 'input', placeholder: '请输入报告标题' },
        { prop: 'reportPeriod', label: '报告周期', type: 'select', placeholder: '请选择报告周期' }
      ]
    },
    {
      name: 'time',
      label: '时间范围',
      fields: [
        { prop: 'reportDate', label: '报告日期', type: 'daterange', placeholder: '请选择报告日期范围' }
      ]
    },
    {
      name: 'statistics',
      label: '统计数据',
      fields: [
        { prop: 'inspectionCount', label: '检查次数', type: 'numberrange', placeholder: '请输入检查次数范围' },
        { prop: 'organizationsInspected', label: '检查单位数', type: 'numberrange', placeholder: '请输入检查单位数范围' },
        { prop: 'issuesFound', label: '发现问题数', type: 'numberrange', placeholder: '请输入发现问题数范围' }
      ]
    },
    {
      name: 'quality',
      label: '质量指标',
      fields: [
        { prop: 'complianceRate', label: '合规率', type: 'numberrange', placeholder: '请输入合规率范围' },
        { prop: 'rectificationCompletionRate', label: '整改完成率', type: 'numberrange', placeholder: '请输入整改完成率范围' }
      ]
    }
  ];

  return new SearchConfigManager('supervisionStatisticsReport', searchFieldGroups);
}