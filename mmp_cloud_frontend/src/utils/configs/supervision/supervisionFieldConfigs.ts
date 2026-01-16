import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// 监管检查记录字段配置
export function createSupervisionInspectionRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'inspectionNo', label: '检查编号', visible: true, required: true, group: 'basic' },
        { prop: 'inspectionTitle', label: '检查标题', visible: true, required: true, group: 'basic' },
        { prop: 'inspectionDate', label: '检查日期', visible: true, required: true, width: '120', group: 'basic' },
        { prop: 'inspectionType', label: '检查类型', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'organization',
      label: '组织信息',
      fields: [
        { prop: 'inspectedOrganization', label: '被检查单位', visible: true, required: true, group: 'organization' },
        { prop: 'organizationType', label: '单位类型', visible: true, group: 'organization' },
        { prop: 'organizationLevel', label: '单位等级', visible: true, group: 'organization' },
        { prop: 'contactPerson', label: '联系人', visible: true, group: 'organization' },
        { prop: 'contactPhone', label: '联系电话', visible: true, group: 'organization' }
      ]
    },
    {
      name: 'team',
      label: '检查团队',
      fields: [
        { prop: 'inspectionLeader', label: '检查组长', visible: true, required: true, group: 'team' },
        { prop: 'teamMembers', label: '检查组成员', visible: true, group: 'team' },
        { prop: 'expertMembers', label: '专家成员', visible: true, group: 'team' },
        { prop: 'supervisoryAuthority', label: '监管机构', visible: true, group: 'team' }
      ]
    },
    {
      name: 'content',
      label: '检查内容',
      fields: [
        { prop: 'inspectionScope', label: '检查范围', visible: true, group: 'content' },
        { prop: 'inspectionBasis', label: '检查依据', visible: true, group: 'content' },
        { prop: 'inspectionMethods', label: '检查方法', visible: true, group: 'content' },
        { prop: 'keyPoints', label: '重点检查事项', visible: true, group: 'content' }
      ]
    },
    {
      name: 'findings',
      label: '检查发现',
      fields: [
        { prop: 'findings', label: '检查发现', visible: true, group: 'findings' },
        { prop: 'problems', label: '存在问题', visible: true, group: 'findings' },
        { prop: 'violations', label: '违规情况', visible: true, group: 'findings' },
        { prop: 'evidence', label: '证据材料', visible: true, group: 'findings' }
      ]
    },
    {
      name: 'result',
      label: '检查结果',
      fields: [
        { prop: 'overallAssessment', label: '总体评价', visible: true, group: 'result' },
        { prop: 'inspectionGrade', label: '检查等级', visible: true, group: 'result' },
        { prop: 'rectificationRequired', label: '是否需要整改', visible: true, group: 'result' },
        { prop: 'rectificationDeadline', label: '整改期限', visible: true, width: '120', group: 'result' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionInspectionRecord', fieldGroups);
}

// 监管整改通知字段配置
export function createSupervisionRectificationNoticeFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'noticeNo', label: '通知编号', visible: true, required: true, group: 'basic' },
        { prop: 'noticeTitle', label: '通知标题', visible: true, required: true, group: 'basic' },
        { prop: 'noticeDate', label: '通知日期', visible: true, required: true, width: '120', group: 'basic' },
        { prop: 'inspectionId', label: '关联检查ID', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'organization',
      label: '被通知单位',
      fields: [
        { prop: 'notifiedOrganization', label: '被通知单位', visible: true, required: true, group: 'organization' },
        { prop: 'organizationType', label: '单位类型', visible: true, group: 'organization' },
        { prop: 'contactPerson', label: '联系人', visible: true, group: 'organization' },
        { prop: 'contactPhone', label: '联系电话', visible: true, group: 'organization' }
      ]
    },
    {
      name: 'issues',
      label: '问题清单',
      fields: [
        { prop: 'issuesList', label: '问题清单', visible: true, group: 'issues' },
        { prop: 'issueCategories', label: '问题分类', visible: true, group: 'issues' },
        { prop: 'severityLevels', label: '严重程度', visible: true, group: 'issues' },
        { prop: 'issueDescriptions', label: '问题描述', visible: true, group: 'issues' }
      ]
    },
    {
      name: 'requirements',
      label: '整改要求',
      fields: [
        { prop: 'rectificationRequirements', label: '整改要求', visible: true, required: true, group: 'requirements' },
        { prop: 'rectificationStandards', label: '整改标准', visible: true, group: 'requirements' },
        { prop: 'rectificationDeadline', label: '整改期限', visible: true, required: true, width: '120', group: 'requirements' },
        { prop: 'responsiblePerson', label: '责任人', visible: true, group: 'requirements' }
      ]
    },
    {
      name: 'followup',
      label: '后续跟踪',
      fields: [
        { prop: 'followupRequired', label: '是否需要跟踪', visible: true, group: 'followup' },
        { prop: 'followupSchedule', label: '跟踪计划', visible: true, group: 'followup' },
        { prop: 'reportingRequirements', label: '报告要求', visible: true, group: 'followup' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionRectificationNotice', fieldGroups);
}

// 监管整改报告字段配置
export function createSupervisionRectificationReportFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'reportNo', label: '报告编号', visible: true, required: true, group: 'basic' },
        { prop: 'reportTitle', label: '报告标题', visible: true, required: true, group: 'basic' },
        { prop: 'reportDate', label: '报告日期', visible: true, required: true, width: '120', group: 'basic' },
        { prop: 'noticeId', label: '关联通知ID', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'organization',
      label: '报告单位',
      fields: [
        { prop: 'reportingOrganization', label: '报告单位', visible: true, required: true, group: 'organization' },
        { prop: 'organizationType', label: '单位类型', visible: true, group: 'organization' },
        { prop: 'contactPerson', label: '联系人', visible: true, group: 'organization' },
        { prop: 'contactPhone', label: '联系电话', visible: true, group: 'organization' }
      ]
    },
    {
      name: 'progress',
      label: '整改进度',
      fields: [
        { prop: 'rectificationProgress', label: '整改进度', visible: true, group: 'progress' },
        { prop: 'completionRate', label: '完成率', visible: true, group: 'progress' },
        { prop: 'remainingIssues', label: '剩余问题', visible: true, group: 'progress' },
        { prop: 'expectedCompletionDate', label: '预计完成日期', visible: true, width: '120', group: 'progress' }
      ]
    },
    {
      name: 'measures',
      label: '整改措施',
      fields: [
        { prop: 'measuresTaken', label: '已采取措施', visible: true, group: 'measures' },
        { prop: 'effectiveness', label: '措施有效性', visible: true, group: 'measures' },
        { prop: 'difficulties', label: '遇到的困难', visible: true, group: 'measures' },
        { prop: 'supportNeeded', label: '需要的支持', visible: true, group: 'measures' }
      ]
    },
    {
      name: 'verification',
      label: '验收信息',
      fields: [
        { prop: 'selfAssessment', label: '自查评估', visible: true, group: 'verification' },
        { prop: 'verificationResult', label: '验收结果', visible: true, group: 'verification' },
        { prop: 'verifier', label: '验收人', visible: true, group: 'verification' },
        { prop: 'verificationDate', label: '验收日期', visible: true, width: '120', group: 'verification' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionRectificationReport', fieldGroups);
}

// 监管处罚决定字段配置
export function createSupervisionPenaltyDecisionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'decisionNo', label: '决定编号', visible: true, required: true, group: 'basic' },
        { prop: 'decisionTitle', label: '决定标题', visible: true, required: true, group: 'basic' },
        { prop: 'decisionDate', label: '决定日期', visible: true, required: true, width: '120', group: 'basic' },
        { prop: 'inspectionId', label: '关联检查ID', visible: true, group: 'basic' }
      ]
    },
    {
      name: 'organization',
      label: '被处罚单位',
      fields: [
        { prop: 'penalizedOrganization', label: '被处罚单位', visible: true, required: true, group: 'organization' },
        { prop: 'organizationType', label: '单位类型', visible: true, group: 'organization' },
        { prop: 'legalRepresentative', label: '法定代表人', visible: true, group: 'organization' },
        { prop: 'contactInfo', label: '联系方式', visible: true, group: 'organization' }
      ]
    },
    {
      name: 'violations',
      label: '违法事实',
      fields: [
        { prop: 'violations', label: '违法事实', visible: true, required: true, group: 'violations' },
        { prop: 'legalBasis', label: '法律依据', visible: true, required: true, group: 'violations' },
        { prop: 'violationCategory', label: '违法类别', visible: true, group: 'violations' },
        { prop: 'violationSeverity', label: '违法严重程度', visible: true, group: 'violations' }
      ]
    },
    {
      name: 'penalty',
      label: '处罚内容',
      fields: [
        { prop: 'penaltyType', label: '处罚类型', visible: true, required: true, group: 'penalty' },
        { prop: 'penaltyAmount', label: '罚款金额', visible: true, group: 'penalty' },
        { prop: 'penaltyDetails', label: '处罚详情', visible: true, group: 'penalty' },
        { prop: 'penaltyBasis', label: '处罚依据', visible: true, group: 'penalty' }
      ]
    },
    {
      name: 'execution',
      label: '执行信息',
      fields: [
        { prop: 'executionDeadline', label: '执行期限', visible: true, group: 'execution' },
        { prop: 'executionStatus', label: '执行状态', visible: true, group: 'execution' },
        { prop: 'executionDate', label: '执行日期', visible: true, width: '120', group: 'execution' },
        { prop: 'executionResult', label: '执行结果', visible: true, group: 'execution' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionPenaltyDecision', fieldGroups);
}

// 监管工作计划字段配置
export function createSupervisionWorkPlanFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'planNo', label: '计划编号', visible: true, required: true, group: 'basic' },
        { prop: 'planTitle', label: '计划标题', visible: true, required: true, group: 'basic' },
        { prop: 'planYear', label: '计划年度', visible: true, required: true, group: 'basic' },
        { prop: 'planType', label: '计划类型', visible: true, required: true, group: 'basic' }
      ]
    },
    {
      name: 'content',
      label: '计划内容',
      fields: [
        { prop: 'planObjectives', label: '计划目标', visible: true, group: 'content' },
        { prop: 'planScope', label: '计划范围', visible: true, group: 'content' },
        { prop: 'keyTasks', label: '重点任务', visible: true, group: 'content' },
        { prop: 'workRequirements', label: '工作要求', visible: true, group: 'content' }
      ]
    },
    {
      name: 'schedule',
      label: '时间安排',
      fields: [
        { prop: 'startDate', label: '开始日期', visible: true, width: '120', group: 'schedule' },
        { prop: 'endDate', label: '结束日期', visible: true, width: '120', group: 'schedule' },
        { prop: 'milestones', label: '里程碑', visible: true, group: 'schedule' },
        { prop: 'deadlines', label: '截止时间', visible: true, group: 'schedule' }
      ]
    },
    {
      name: 'resources',
      label: '资源配置',
      fields: [
        { prop: 'personnelAllocation', label: '人员配置', visible: true, group: 'resources' },
        { prop: 'budgetAllocation', label: '预算配置', visible: true, group: 'resources' },
        { prop: 'equipmentNeeds', label: '设备需求', visible: true, group: 'resources' },
        { prop: 'trainingNeeds', label: '培训需求', visible: true, group: 'resources' }
      ]
    },
    {
      name: 'monitoring',
      label: '监控评估',
      fields: [
        { prop: 'monitoringIndicators', label: '监控指标', visible: true, group: 'monitoring' },
        { prop: 'evaluationMethods', label: '评估方法', visible: true, group: 'monitoring' },
        { prop: 'reportingRequirements', label: '报告要求', visible: true, group: 'monitoring' },
        { prop: 'adjustmentMechanism', label: '调整机制', visible: true, group: 'monitoring' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionWorkPlan', fieldGroups);
}

// 监管统计报告字段配置
export function createSupervisionStatisticsReportFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, group: 'basic' },
        { prop: 'reportNo', label: '报告编号', visible: true, required: true, group: 'basic' },
        { prop: 'reportTitle', label: '报告标题', visible: true, required: true, group: 'basic' },
        { prop: 'reportPeriod', label: '报告周期', visible: true, required: true, group: 'basic' },
        { prop: 'reportDate', label: '报告日期', visible: true, required: true, width: '120', group: 'basic' }
      ]
    },
    {
      name: 'statistics',
      label: '统计数据',
      fields: [
        { prop: 'inspectionCount', label: '检查次数', visible: true, group: 'statistics' },
        { prop: 'organizationsInspected', label: '检查单位数', visible: true, group: 'statistics' },
        { prop: 'issuesFound', label: '发现问题数', visible: true, group: 'statistics' },
        { prop: 'rectificationNotices', label: '整改通知数', visible: true, group: 'statistics' },
        { prop: 'penaltyDecisions', label: '处罚决定数', visible: true, group: 'statistics' }
      ]
    },
    {
      name: 'analysis',
      label: '分析内容',
      fields: [
        { prop: 'trendAnalysis', label: '趋势分析', visible: true, group: 'analysis' },
        { prop: 'problemAnalysis', label: '问题分析', visible: true, group: 'analysis' },
        { prop: 'effectivenessAnalysis', label: '成效分析', visible: true, group: 'analysis' },
        { prop: 'recommendations', label: '建议措施', visible: true, group: 'analysis' }
      ]
    },
    {
      name: 'quality',
      label: '质量指标',
      fields: [
        { prop: 'complianceRate', label: '合规率', visible: true, group: 'quality' },
        { prop: 'rectificationCompletionRate', label: '整改完成率', visible: true, group: 'quality' },
        { prop: 'penaltyExecutionRate', label: '处罚执行率', visible: true, group: 'quality' },
        { prop: 'satisfactionRate', label: '满意度', visible: true, group: 'quality' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '删除标志', visible: true, group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, group: 'system' },
        { prop: 'createBy', label: '创建者', visible: true, group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, group: 'system' },
        { prop: 'updateBy', label: '更新者', visible: true, group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('supervisionStatisticsReport', fieldGroups);
}