import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

// 读取模板文件
const templatePath = path.join(__dirname, 'src/views/emergency/emergencyDrillPlan/index.vue');
const template = fs.readFileSync(templatePath, 'utf-8');

// 文件配置：定义每个文件需要替换的变量
// 注意：只包含需要重构的模块，其他模块已经重构完成
const configs = [
  // qualification 目录 - 11个文件
  {
    dir: 'qualification',
    file: 'qualificationAdmissionCondition',
    file: 'emergencyDrillPlan',
    title: '应急演练计划管理',
    desc: '管理应急演练计划的创建、执行和评估等全流程',
    icon: 'i-ep-document',
    listTitle: '应急演练计划列表',
    apiPath: 'emergency:emergencyDrillPlan',
    entityName: 'EmergencyDrillPlan',
    varName: 'emergencyDrillPlan',
    formFields: ['planCode', 'planName']
  },
  {
    dir: 'emergency',
    file: 'emergencyDrillSummary',
    title: '应急演练总结管理',
    desc: '管理应急演练的总结和改进建议',
    icon: 'i-ep-document-checked',
    listTitle: '应急演练总结列表',
    apiPath: 'emergency:emergencyDrillSummary',
    entityName: 'EmergencyDrillSummary',
    varName: 'emergencyDrillSummary',
    formFields: ['summaryCode', 'summaryTitle']
  },
  {
    dir: 'emergency',
    file: 'emergencyEvent',
    title: '应急事件管理',
    desc: '管理应急事件的记录和处理流程',
    icon: 'i-ep-bell',
    listTitle: '应急事件列表',
    apiPath: 'emergency:emergencyEvent',
    entityName: 'EmergencyEvent',
    varName: 'emergencyEvent',
    formFields: ['eventCode', 'eventName']
  },
  {
    dir: 'emergency',
    file: 'emergencyEventResponse',
    title: '应急事件响应管理',
    desc: '管理应急事件的响应措施和处理流程',
    icon: 'i-ep-warning',
    listTitle: '应急事件响应列表',
    apiPath: 'emergency:emergencyEventResponse',
    entityName: 'EmergencyEventResponse',
    varName: 'emergencyEventResponse',
    formFields: ['responseCode', 'responseName']
  },
  {
    dir: 'emergency',
    file: 'emergencyEventTreatment',
    title: '应急事件处置管理',
    desc: '管理应急事件的处置过程和结果记录',
    icon: 'i-ep-first-aid-kit',
    listTitle: '应急事件处置列表',
    apiPath: 'emergency:emergencyEventTreatment',
    entityName: 'EmergencyEventTreatment',
    varName: 'emergencyEventTreatment',
    formFields: ['treatmentCode', 'treatmentTitle']
  },
  {
    dir: 'emergency',
    file: 'emergencyIncident',
    title: '应急突发事件管理',
    desc: '管理突发应急事件的登记和跟踪',
    icon: 'i-ep-warning-filled',
    listTitle: '应急突发事件列表',
    apiPath: 'emergency:emergencyIncident',
    entityName: 'EmergencyIncident',
    varName: 'emergencyIncident',
    formFields: ['incidentCode', 'incidentTitle']
  },
  {
    dir: 'emergency',
    file: 'emergencyMedicalSupport',
    title: '应急医疗保障管理',
    desc: '管理应急医疗保障资源和调度',
    icon: 'i-ep-coordinate',
    listTitle: '应急医疗保障列表',
    apiPath: 'emergency:emergencyMedicalSupport',
    entityName: 'EmergencyMedicalSupport',
    varName: 'emergencyMedicalSupport',
    formFields: ['supportCode', 'supportName']
  },
  {
    dir: 'emergency',
    file: 'emergencyPlan',
    title: '应急预案管理',
    desc: '管理应急预案的制定和维护',
    icon: 'i-ep-document-add',
    listTitle: '应急预案列表',
    apiPath: 'emergency:emergencyPlan',
    entityName: 'EmergencyPlan',
    varName: 'emergencyPlan',
    formFields: ['planCode', 'planName']
  },
  {
    dir: 'emergency',
    file: 'emergencyPlanApproval',
    title: '应急预案审批管理',
    desc: '管理应急预案的审批流程和记录',
    icon: 'i-ep-circle-check',
    listTitle: '应急预案审批列表',
    apiPath: 'emergency:emergencyPlanApproval',
    entityName: 'EmergencyPlanApproval',
    varName: 'emergencyPlanApproval',
    formFields: ['approvalCode', 'approvalTitle']
  },
  {
    dir: 'emergency',
    file: 'emergencyTeam',
    title: '应急团队管理',
    desc: '管理应急响应团队的组建和配置',
    icon: 'i-ep-user-filled',
    listTitle: '应急团队列表',
    apiPath: 'emergency:emergencyTeam',
    entityName: 'EmergencyTeam',
    varName: 'emergencyTeam',
    formFields: ['teamCode', 'teamName']
  },
  {
    dir: 'emergency',
    file: 'emergencyTeamMember',
    title: '应急团队成员管理',
    desc: '管理应急团队成员信息和职责',
    icon: 'i-ep-avatar',
    listTitle: '应急团队成员列表',
    apiPath: 'emergency:emergencyTeamMember',
    entityName: 'EmergencyTeamMember',
    varName: 'emergencyTeamMember',
    formFields: ['memberCode', 'memberName']
  },
  {
    dir: 'emergency',
    file: 'importantMedicalEvent',
    title: '重大医疗事件管理',
    desc: '管理重大医疗事件的记录和上报',
    icon: 'i-ep-medal',
    listTitle: '重大医疗事件列表',
    apiPath: 'emergency:importantMedicalEvent',
    entityName: 'ImportantMedicalEvent',
    varName: 'importantMedicalEvent',
    formFields: ['eventCode', 'eventTitle']
  },
  
  // qc 目录 - 8个文件
  {
    dir: 'qc',
    file: 'qcDataCollection',
    title: '质控数据采集管理',
    desc: '管理质控数据的采集和录入',
    icon: 'i-ep-document',
    listTitle: '质控数据采集列表',
    apiPath: 'qc:qcDataCollection',
    entityName: 'QcDataCollection',
    varName: 'qcDataCollection',
    formFields: ['collectionCode', 'collectionName']
  },
  {
    dir: 'qc',
    file: 'qcIndicatorCollectionConfig',
    title: '质控指标采集配置管理',
    desc: '管理质控指标的采集配置规则',
    icon: 'i-ep-setting',
    listTitle: '质控指标采集配置列表',
    apiPath: 'qc:qcIndicatorCollectionConfig',
    entityName: 'QcIndicatorCollectionConfig',
    varName: 'qcIndicatorCollectionConfig',
    formFields: ['configCode', 'configName']
  },
  {
    dir: 'qc',
    file: 'qcIndicatorFactor',
    title: '质控指标因素管理',
    desc: '管理质控指标的影响因素和权重',
    icon: 'i-ep-histogram',
    listTitle: '质控指标因素列表',
    apiPath: 'qc:qcIndicatorFactor',
    entityName: 'QcIndicatorFactor',
    varName: 'qcIndicatorFactor',
    formFields: ['factorCode', 'factorName']
  },
  {
    dir: 'qc',
    file: 'qcManualData',
    title: '质控手工数据管理',
    desc: '管理质控手工录入的数据',
    icon: 'i-ep-edit',
    listTitle: '质控手工数据列表',
    apiPath: 'qc:qcManualData',
    entityName: 'QcManualData',
    varName: 'qcManualData',
    formFields: ['dataCode', 'dataName']
  },
  {
    dir: 'qc',
    file: 'qcQualityIndicator',
    title: '质控质量指标管理',
    desc: '管理质控质量指标的定义和标准',
    icon: 'i-ep-data-analysis',
    listTitle: '质控质量指标列表',
    apiPath: 'qc:qcQualityIndicator',
    entityName: 'QcQualityIndicator',
    varName: 'qcQualityIndicator',
    formFields: ['indicatorCode', 'indicatorName']
  },
  {
    dir: 'qc',
    file: 'qcScoringResult',
    title: '质控评分结果管理',
    desc: '管理质控评分的结果和分析',
    icon: 'i-ep-trophy',
    listTitle: '质控评分结果列表',
    apiPath: 'qc:qcScoringResult',
    entityName: 'QcScoringResult',
    varName: 'qcScoringResult',
    formFields: ['resultCode', 'resultTitle']
  },
  {
    dir: 'qc',
    file: 'qcScoringRule',
    title: '质控评分规则管理',
    desc: '管理质控评分的规则和标准',
    icon: 'i-ep-document-checked',
    listTitle: '质控评分规则列表',
    apiPath: 'qc:qcScoringRule',
    entityName: 'QcScoringRule',
    varName: 'qcScoringRule',
    formFields: ['ruleCode', 'ruleName']
  },
  {
    dir: 'qc',
    file: 'qcSpecialtyCategory',
    title: '质控专科分类管理',
    desc: '管理质控专科的分类和层级',
    icon: 'i-ep-folder',
    listTitle: '质控专科分类列表',
    apiPath: 'qc:qcSpecialtyCategory',
    entityName: 'QcSpecialtyCategory',
    varName: 'qcSpecialtyCategory',
    formFields: ['categoryCode', 'categoryName']
  },
  
  // radiation 目录 - 13个文件
  {
    dir: 'radiation',
    file: 'radiationDoseAlert',
    title: '辐射剂量预警管理',
    desc: '管理辐射剂量的预警规则和阈值',
    icon: 'i-ep-bell',
    listTitle: '辐射剂量预警列表',
    apiPath: 'radiation:radiationDoseAlert',
    entityName: 'RadiationDoseAlert',
    varName: 'radiationDoseAlert',
    formFields: ['alertCode', 'alertName']
  },
  {
    dir: 'radiation',
    file: 'radiationDoseAlertRecord',
    title: '辐射剂量预警记录管理',
    desc: '管理辐射剂量预警的记录和处理',
    icon: 'i-ep-warning',
    listTitle: '辐射剂量预警记录列表',
    apiPath: 'radiation:radiationDoseAlertRecord',
    entityName: 'RadiationDoseAlertRecord',
    varName: 'radiationDoseAlertRecord',
    formFields: ['recordCode', 'recordTitle']
  },
  {
    dir: 'radiation',
    file: 'radiationDoseMonitoring',
    title: '辐射剂量监测管理',
    desc: '管理辐射剂量的监测和分析',
    icon: 'i-ep-monitor',
    listTitle: '辐射剂量监测列表',
    apiPath: 'radiation:radiationDoseMonitoring',
    entityName: 'RadiationDoseMonitoring',
    varName: 'radiationDoseMonitoring',
    formFields: ['monitoringCode', 'monitoringName']
  },
  {
    dir: 'radiation',
    file: 'radiationDoseRecord',
    title: '辐射剂量记录管理',
    desc: '管理辐射剂量的记录和统计',
    icon: 'i-ep-document',
    listTitle: '辐射剂量记录列表',
    apiPath: 'radiation:radiationDoseRecord',
    entityName: 'RadiationDoseRecord',
    varName: 'radiationDoseRecord',
    formFields: ['recordCode', 'recordTitle']
  },
  {
    dir: 'radiation',
    file: 'radiationEquipmentInspection',
    title: '辐射设备检查管理',
    desc: '管理辐射设备的检查和维护',
    icon: 'i-ep-box',
    listTitle: '辐射设备检查列表',
    apiPath: 'radiation:radiationEquipmentInspection',
    entityName: 'RadiationEquipmentInspection',
    varName: 'radiationEquipmentInspection',
    formFields: ['inspectionCode', 'inspectionTitle']
  },
  {
    dir: 'radiation',
    file: 'radiationHealthExam',
    title: '辐射健康体检管理',
    desc: '管理辐射工作人员的健康体检',
    icon: 'i-ep-document-checked',
    listTitle: '辐射健康体检列表',
    apiPath: 'radiation:radiationHealthExam',
    entityName: 'RadiationHealthExam',
    varName: 'radiationHealthExam',
    formFields: ['examCode', 'examTitle']
  },
  {
    dir: 'radiation',
    file: 'radiationHealthExamPlan',
    title: '辐射健康体检计划管理',
    desc: '管理辐射健康体检的计划和安排',
    icon: 'i-ep-calendar',
    listTitle: '辐射健康体检计划列表',
    apiPath: 'radiation:radiationHealthExamPlan',
    entityName: 'RadiationHealthExamPlan',
    varName: 'radiationHealthExamPlan',
    formFields: ['planCode', 'planName']
  },
  {
    dir: 'radiation',
    file: 'radiationHealthExamResult',
    title: '辐射健康体检结果管理',
    desc: '管理辐射健康体检的结果和分析',
    icon: 'i-ep-data-analysis',
    listTitle: '辐射健康体检结果列表',
    apiPath: 'radiation:radiationHealthExamResult',
    entityName: 'RadiationHealthExamResult',
    varName: 'radiationHealthExamResult',
    formFields: ['resultCode', 'resultTitle']
  },
  {
    dir: 'radiation',
    file: 'radiationStaff',
    title: '辐射工作人员管理',
    desc: '管理辐射工作人员的信息和档案',
    icon: 'i-ep-user',
    listTitle: '辐射工作人员列表',
    apiPath: 'radiation:radiationStaff',
    entityName: 'RadiationStaff',
    varName: 'radiationStaff',
    formFields: ['staffCode', 'staffName']
  },
  {
    dir: 'radiation',
    file: 'radiationTraining',
    title: '辐射培训管理',
    desc: '管理辐射安全培训的组织和实施',
    icon: 'i-ep-reading',
    listTitle: '辐射培训列表',
    apiPath: 'radiation:radiationTraining',
    entityName: 'RadiationTraining',
    varName: 'radiationTraining',
    formFields: ['trainingCode', 'trainingName']
  },
  {
    dir: 'radiation',
    file: 'radiationTrainingParticipant',
    title: '辐射培训参与人员管理',
    desc: '管理辐射培训的参与人员和记录',
    icon: 'i-ep-avatar',
    listTitle: '辐射培训参与人员列表',
    apiPath: 'radiation:radiationTrainingParticipant',
    entityName: 'RadiationTrainingParticipant',
    varName: 'radiationTrainingParticipant',
    formFields: ['participantCode', 'participantName']
  },
  {
    dir: 'radiation',
    file: 'radiationTrainingPlan',
    title: '辐射培训计划管理',
    desc: '管理辐射培训的计划和安排',
    icon: 'i-ep-notebook',
    listTitle: '辐射培训计划列表',
    apiPath: 'radiation:radiationTrainingPlan',
    entityName: 'RadiationTrainingPlan',
    varName: 'radiationTrainingPlan',
    formFields: ['planCode', 'planName']
  },
  {
    dir: 'radiation',
    file: 'radiationWorker',
    title: '辐射工作者管理',
    desc: '管理辐射工作者的资质和信息',
    icon: 'i-ep-user-filled',
    listTitle: '辐射工作者列表',
    apiPath: 'radiation:radiationWorker',
    entityName: 'RadiationWorker',
    varName: 'radiationWorker',
    formFields: ['workerCode', 'workerName']
  },
  
  // supervision 目录 - 15个文件
  {
    dir: 'supervision',
    file: 'supervisionExpertGroup',
    title: '督导专家组管理',
    desc: '管理督导专家组的组建和配置',
    icon: 'i-ep-office-building',
    listTitle: '督导专家组列表',
    apiPath: 'supervision:supervisionExpertGroup',
    entityName: 'SupervisionExpertGroup',
    varName: 'supervisionExpertGroup',
    formFields: ['groupCode', 'groupName']
  },
  {
    dir: 'supervision',
    file: 'supervisionExpertMember',
    title: '督导专家成员管理',
    desc: '管理督导专家成员的信息和职责',
    icon: 'i-ep-user',
    listTitle: '督导专家成员列表',
    apiPath: 'supervision:supervisionExpertMember',
    entityName: 'SupervisionExpertMember',
    varName: 'supervisionExpertMember',
    formFields: ['memberCode', 'memberName']
  },
  {
    dir: 'supervision',
    file: 'supervisionForm',
    title: '督导表单管理',
    desc: '管理督导检查的表单模板',
    icon: 'i-ep-document',
    listTitle: '督导表单列表',
    apiPath: 'supervision:supervisionForm',
    entityName: 'SupervisionForm',
    varName: 'supervisionForm',
    formFields: ['formCode', 'formName']
  },
  {
    dir: 'supervision',
    file: 'supervisionFormField',
    title: '督导表单字段管理',
    desc: '管理督导表单的字段配置',
    icon: 'i-ep-setting',
    listTitle: '督导表单字段列表',
    apiPath: 'supervision:supervisionFormField',
    entityName: 'SupervisionFormField',
    varName: 'supervisionFormField',
    formFields: ['fieldCode', 'fieldName']
  },
  {
    dir: 'supervision',
    file: 'supervisionIssue',
    title: '督导问题管理',
    desc: '管理督导检查发现的问题',
    icon: 'i-ep-warning',
    listTitle: '督导问题列表',
    apiPath: 'supervision:supervisionIssue',
    entityName: 'SupervisionIssue',
    varName: 'supervisionIssue',
    formFields: ['issueCode', 'issueTitle']
  },
  {
    dir: 'supervision',
    file: 'supervisionPlan',
    title: '督导计划管理',
    desc: '管理督导检查的计划和安排',
    icon: 'i-ep-calendar',
    listTitle: '督导计划列表',
    apiPath: 'supervision:supervisionPlan',
    entityName: 'SupervisionPlan',
    varName: 'supervisionPlan',
    formFields: ['planCode', 'planName']
  },
  {
    dir: 'supervision',
    file: 'supervisionPlanDept',
    title: '督导计划科室管理',
    desc: '管理督导计划涉及的科室',
    icon: 'i-ep-office-building',
    listTitle: '督导计划科室列表',
    apiPath: 'supervision:supervisionPlanDept',
    entityName: 'SupervisionPlanDept',
    varName: 'supervisionPlanDept',
    formFields: ['planDeptCode', 'deptName']
  },
  {
    dir: 'supervision',
    file: 'supervisionPlanForm',
    title: '督导计划表单管理',
    desc: '管理督导计划使用的表单',
    icon: 'i-ep-document-copy',
    listTitle: '督导计划表单列表',
    apiPath: 'supervision:supervisionPlanForm',
    entityName: 'SupervisionPlanForm',
    varName: 'supervisionPlanForm',
    formFields: ['planFormCode', 'formName']
  },
  {
    dir: 'supervision',
    file: 'supervisionProject',
    title: '督导项目管理',
    desc: '管理督导项目的定义和配置',
    icon: 'i-ep-folder-opened',
    listTitle: '督导项目列表',
    apiPath: 'supervision:supervisionProject',
    entityName: 'SupervisionProject',
    varName: 'supervisionProject',
    formFields: ['projectCode', 'projectName']
  },
  {
    dir: 'supervision',
    file: 'supervisionProjectIndicator',
    title: '督导项目指标管理',
    desc: '管理督导项目的考核指标',
    icon: 'i-ep-data-analysis',
    listTitle: '督导项目指标列表',
    apiPath: 'supervision:supervisionProjectIndicator',
    entityName: 'SupervisionProjectIndicator',
    varName: 'supervisionProjectIndicator',
    formFields: ['indicatorCode', 'indicatorName']
  },
  {
    dir: 'supervision',
    file: 'supervisionRectificationProgress',
    title: '督导整改进度管理',
    desc: '管理督导问题的整改进度跟踪',
    icon: 'i-ep-trend-charts',
    listTitle: '督导整改进度列表',
    apiPath: 'supervision:supervisionRectificationProgress',
    entityName: 'SupervisionRectificationProgress',
    varName: 'supervisionRectificationProgress',
    formFields: ['progressCode', 'progressTitle']
  },
  {
    dir: 'supervision',
    file: 'supervisionRectificationTask',
    title: '督导整改任务管理',
    desc: '管理督导问题的整改任务',
    icon: 'i-ep-document-checked',
    listTitle: '督导整改任务列表',
    apiPath: 'supervision:supervisionRectificationTask',
    entityName: 'SupervisionRectificationTask',
    varName: 'supervisionRectificationTask',
    formFields: ['taskCode', 'taskTitle']
  },
  {
    dir: 'supervision',
    file: 'supervisionResult',
    title: '督导结果管理',
    desc: '管理督导检查的结果和评价',
    icon: 'i-ep-trophy',
    listTitle: '督导结果列表',
    apiPath: 'supervision:supervisionResult',
    entityName: 'SupervisionResult',
    varName: 'supervisionResult',
    formFields: ['resultCode', 'resultTitle']
  },
  {
    dir: 'supervision',
    file: 'supervisionResultDetail',
    title: '督导结果明细管理',
    desc: '管理督导结果的详细记录',
    icon: 'i-ep-document',
    listTitle: '督导结果明细列表',
    apiPath: 'supervision:supervisionResultDetail',
    entityName: 'SupervisionResultDetail',
    varName: 'supervisionResultDetail',
    formFields: ['detailCode', 'detailTitle']
  },
  {
    dir: 'supervision',
    file: 'supervisionReview',
    title: '督导复查管理',
    desc: '管理督导整改的复查和验收',
    icon: 'i-ep-circle-check',
    listTitle: '督导复查列表',
    apiPath: 'supervision:supervisionReview',
    entityName: 'SupervisionReview',
    varName: 'supervisionReview',
    formFields: ['reviewCode', 'reviewTitle']
  },
  
  // surgery 目录 - 7个文件
  {
    dir: 'surgery',
    file: 'surgeryApprovalForm',
    title: '手术审批单管理',
    desc: '管理手术审批单的提交和审核',
    icon: 'i-ep-document-checked',
    listTitle: '手术审批单列表',
    apiPath: 'surgery:surgeryApprovalForm',
    entityName: 'SurgeryApprovalForm',
    varName: 'surgeryApprovalForm',
    formFields: ['approvalCode', 'patientName']
  },
  {
    dir: 'surgery',
    file: 'surgeryCatalog',
    title: '手术目录管理',
    desc: '管理手术项目的目录和分类',
    icon: 'i-ep-menu',
    listTitle: '手术目录列表',
    apiPath: 'surgery:surgeryCatalog',
    entityName: 'SurgeryCatalog',
    varName: 'surgeryCatalog',
    formFields: ['catalogCode', 'catalogName']
  },
  {
    dir: 'surgery',
    file: 'surgeryComplicationRecord',
    title: '手术并发症记录管理',
    desc: '管理手术并发症的记录和分析',
    icon: 'i-ep-warning',
    listTitle: '手术并发症记录列表',
    apiPath: 'surgery:surgeryComplicationRecord',
    entityName: 'SurgeryComplicationRecord',
    varName: 'surgeryComplicationRecord',
    formFields: ['recordCode', 'patientName']
  },
  {
    dir: 'surgery',
    file: 'surgeryRecord',
    title: '手术记录管理',
    desc: '管理手术过程的记录和归档',
    icon: 'i-ep-document',
    listTitle: '手术记录列表',
    apiPath: 'surgery:surgeryRecord',
    entityName: 'SurgeryRecord',
    varName: 'surgeryRecord',
    formFields: ['recordCode', 'patientName']
  },
  {
    dir: 'surgery',
    file: 'surgeryTeam',
    title: '手术团队管理',
    desc: '管理手术团队的配置和人员',
    icon: 'i-ep-user-filled',
    listTitle: '手术团队列表',
    apiPath: 'surgery:surgeryTeam',
    entityName: 'SurgeryTeam',
    varName: 'surgeryTeam',
    formFields: ['teamCode', 'teamName']
  },
  {
    dir: 'surgery',
    file: 'surgeryVideo',
    title: '手术视频管理',
    desc: '管理手术视频的录制和存储',
    icon: 'i-ep-video-camera',
    listTitle: '手术视频列表',
    apiPath: 'surgery:surgeryVideo',
    entityName: 'SurgeryVideo',
    varName: 'surgeryVideo',
    formFields: ['videoCode', 'videoTitle']
  },
  {
    dir: 'surgery',
    file: 'surgeryWorkloadStatistics',
    title: '手术工作量统计管理',
    desc: '管理手术工作量的统计和分析',
    icon: 'i-ep-data-line',
    listTitle: '手术工作量统计列表',
    apiPath: 'surgery:surgeryWorkloadStatistics',
    entityName: 'SurgeryWorkloadStatistics',
    varName: 'surgeryWorkloadStatistics',
    formFields: ['statisticsCode', 'statisticsTitle']
  },
  
  // tumorqc 目录 - 8个文件
  {
    dir: 'tumorqc',
    file: 'tumorQcIndicatorConfig',
    title: '肿瘤质控指标配置管理',
    desc: '管理肿瘤质控指标的配置规则',
    icon: 'i-ep-setting',
    listTitle: '肿瘤质控指标配置列表',
    apiPath: 'tumorqc:tumorQcIndicatorConfig',
    entityName: 'TumorQcIndicatorConfig',
    varName: 'tumorQcIndicatorConfig',
    formFields: ['configCode', 'configName']
  },
  {
    dir: 'tumorqc',
    file: 'tumorQcIndicatorDetail',
    title: '肿瘤质控指标明细管理',
    desc: '管理肿瘤质控指标的详细信息',
    icon: 'i-ep-document',
    listTitle: '肿瘤质控指标明细列表',
    apiPath: 'tumorqc:tumorQcIndicatorDetail',
    entityName: 'TumorQcIndicatorDetail',
    varName: 'tumorQcIndicatorDetail',
    formFields: ['detailCode', 'detailName']
  },
  {
    dir: 'tumorqc',
    file: 'tumorQcIndicatorRecord',
    title: '肿瘤质控指标记录管理',
    desc: '管理肿瘤质控指标的记录数据',
    icon: 'i-ep-document-copy',
    listTitle: '肿瘤质控指标记录列表',
    apiPath: 'tumorqc:tumorQcIndicatorRecord',
    entityName: 'TumorQcIndicatorRecord',
    varName: 'tumorQcIndicatorRecord',
    formFields: ['recordCode', 'recordTitle']
  },
  {
    dir: 'tumorqc',
    file: 'tumorQcInspection',
    title: '肿瘤质控检查管理',
    desc: '管理肿瘤质控检查的执行和记录',
    icon: 'i-ep-zoom-in',
    listTitle: '肿瘤质控检查列表',
    apiPath: 'tumorqc:tumorQcInspection',
    entityName: 'TumorQcInspection',
    varName: 'tumorQcInspection',
    formFields: ['inspectionCode', 'inspectionTitle']
  },
  {
    dir: 'tumorqc',
    file: 'tumorQcPlan',
    title: '肿瘤质控计划管理',
    desc: '管理肿瘤质控的计划和安排',
    icon: 'i-ep-calendar',
    listTitle: '肿瘤质控计划列表',
    apiPath: 'tumorqc:tumorQcPlan',
    entityName: 'TumorQcPlan',
    varName: 'tumorQcPlan',
    formFields: ['planCode', 'planName']
  },
  {
    dir: 'tumorqc',
    file: 'tumorQcRectification',
    title: '肿瘤质控整改管理',
    desc: '管理肿瘤质控问题的整改跟踪',
    icon: 'i-ep-document-checked',
    listTitle: '肿瘤质控整改列表',
    apiPath: 'tumorqc:tumorQcRectification',
    entityName: 'TumorQcRectification',
    varName: 'tumorQcRectification',
    formFields: ['rectificationCode', 'rectificationTitle']
  },
  {
    dir: 'tumorqc',
    file: 'tumorQcReport',
    title: '肿瘤质控报告管理',
    desc: '管理肿瘤质控的报告生成',
    icon: 'i-ep-document',
    listTitle: '肿瘤质控报告列表',
    apiPath: 'tumorqc:tumorQcReport',
    entityName: 'TumorQcReport',
    varName: 'tumorQcReport',
    formFields: ['reportCode', 'reportTitle']
  },
  {
    dir: 'tumorqc',
    file: 'tumorQcResult',
    title: '肿瘤质控结果管理',
    desc: '管理肿瘤质控的结果和评价',
    icon: 'i-ep-trophy',
    listTitle: '肿瘤质控结果列表',
    apiPath: 'tumorqc:tumorQcResult',
    entityName: 'TumorQcResult',
    varName: 'tumorQcResult',
    formFields: ['resultCode', 'resultTitle']
  },
  
  // natdss 目录 - 24个文件
  {
    dir: 'natdss',
    file: 'natdssB011DrugPurchase',
    title: '药品采购信息管理',
    desc: '管理药品采购的记录和统计',
    icon: 'i-ep-shopping-cart',
    listTitle: '药品采购信息列表',
    apiPath: 'natdss:natdssB011DrugPurchase',
    entityName: 'NatdssB011DrugPurchase',
    varName: 'natdssB011DrugPurchase',
    formFields: ['purchaseCode', 'drugName']
  },
  {
    dir: 'natdss',
    file: 'natdssB012DrugUse',
    title: '药品使用信息管理',
    desc: '管理药品使用的记录和分析',
    icon: 'i-ep-medicine-box',
    listTitle: '药品使用信息列表',
    apiPath: 'natdss:natdssB012DrugUse',
    entityName: 'NatdssB012DrugUse',
    varName: 'natdssB012DrugUse',
    formFields: ['useCode', 'drugName']
  },
  {
    dir: 'natdss',
    file: 'natdssB021PatientInfo',
    title: '患者基本信息管理',
    desc: '管理患者的基本信息和档案',
    icon: 'i-ep-user',
    listTitle: '患者基本信息列表',
    apiPath: 'natdss:natdssB021PatientInfo',
    entityName: 'NatdssB021PatientInfo',
    varName: 'natdssB021PatientInfo',
    formFields: ['patientCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB022AdrInfo',
    title: '药物不良反应信息管理',
    desc: '管理药物不良反应的记录和上报',
    icon: 'i-ep-warning',
    listTitle: '药物不良反应信息列表',
    apiPath: 'natdss:natdssB022AdrInfo',
    entityName: 'NatdssB022AdrInfo',
    varName: 'natdssB022AdrInfo',
    formFields: ['adrCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB023DiagInfo',
    title: '诊断信息管理',
    desc: '管理患者的诊断信息',
    icon: 'i-ep-document',
    listTitle: '诊断信息列表',
    apiPath: 'natdss:natdssB023DiagInfo',
    entityName: 'NatdssB023DiagInfo',
    varName: 'natdssB023DiagInfo',
    formFields: ['diagCode', 'diagName']
  },
  {
    dir: 'natdss',
    file: 'natdssB031InpatientInfo',
    title: '住院患者信息管理',
    desc: '管理住院患者的基本信息',
    icon: 'i-ep-house',
    listTitle: '住院患者信息列表',
    apiPath: 'natdss:natdssB031InpatientInfo',
    entityName: 'NatdssB031InpatientInfo',
    varName: 'natdssB031InpatientInfo',
    formFields: ['inpatientCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB051EmrAdmission',
    title: '入院记录管理',
    desc: '管理患者的入院记录信息',
    icon: 'i-ep-document-add',
    listTitle: '入院记录列表',
    apiPath: 'natdss:natdssB051EmrAdmission',
    entityName: 'NatdssB051EmrAdmission',
    varName: 'natdssB051EmrAdmission',
    formFields: ['admissionCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB061EmrProgressNotes',
    title: '病程记录管理',
    desc: '管理患者的病程记录信息',
    icon: 'i-ep-edit',
    listTitle: '病程记录列表',
    apiPath: 'natdss:natdssB061EmrProgressNotes',
    entityName: 'NatdssB061EmrProgressNotes',
    varName: 'natdssB061EmrProgressNotes',
    formFields: ['noteCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB071EmrDischarge',
    title: '出院记录管理',
    desc: '管理患者的出院记录信息',
    icon: 'i-ep-document-checked',
    listTitle: '出院记录列表',
    apiPath: 'natdss:natdssB071EmrDischarge',
    entityName: 'NatdssB071EmrDischarge',
    varName: 'natdssB071EmrDischarge',
    formFields: ['dischargeCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB081InpatientSurgicalRecord',
    title: '住院手术记录管理',
    desc: '管理住院患者的手术记录',
    icon: 'i-ep-first-aid-kit',
    listTitle: '住院手术记录列表',
    apiPath: 'natdss:natdssB081InpatientSurgicalRecord',
    entityName: 'NatdssB081InpatientSurgicalRecord',
    varName: 'natdssB081InpatientSurgicalRecord',
    formFields: ['recordCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB091InpatientNursingRecord',
    title: '住院护理记录管理',
    desc: '管理住院患者的护理记录',
    icon: 'i-ep-notebook',
    listTitle: '住院护理记录列表',
    apiPath: 'natdss:natdssB091InpatientNursingRecord',
    entityName: 'NatdssB091InpatientNursingRecord',
    varName: 'natdssB091InpatientNursingRecord',
    formFields: ['recordCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB101InpatientOrder',
    title: '住院医嘱管理',
    desc: '管理住院患者的医嘱信息',
    icon: 'i-ep-document-copy',
    listTitle: '住院医嘱列表',
    apiPath: 'natdss:natdssB101InpatientOrder',
    entityName: 'NatdssB101InpatientOrder',
    varName: 'natdssB101InpatientOrder',
    formFields: ['orderCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB111InpatientExpenseRecord',
    title: '住院费用记录管理',
    desc: '管理住院患者的费用记录',
    icon: 'i-ep-money',
    listTitle: '住院费用记录列表',
    apiPath: 'natdss:natdssB111InpatientExpenseRecord',
    entityName: 'NatdssB111InpatientExpenseRecord',
    varName: 'natdssB111InpatientExpenseRecord',
    formFields: ['expenseCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB121OutpatientInfo',
    title: '门诊患者信息管理',
    desc: '管理门诊患者的基本信息',
    icon: 'i-ep-user',
    listTitle: '门诊患者信息列表',
    apiPath: 'natdss:natdssB121OutpatientInfo',
    entityName: 'NatdssB121OutpatientInfo',
    varName: 'natdssB121OutpatientInfo',
    formFields: ['outpatientCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB131OutpatientDiagAndMedrecord',
    title: '门诊诊断和病历管理',
    desc: '管理门诊患者的诊断和病历',
    icon: 'i-ep-document',
    listTitle: '门诊诊断和病历列表',
    apiPath: 'natdss:natdssB131OutpatientDiagAndMedrecord',
    entityName: 'NatdssB131OutpatientDiagAndMedrecord',
    varName: 'natdssB131OutpatientDiagAndMedrecord',
    formFields: ['recordCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB141OutpatientOrderAndPres',
    title: '门诊医嘱和处方管理',
    desc: '管理门诊患者的医嘱和处方',
    icon: 'i-ep-document-copy',
    listTitle: '门诊医嘱和处方列表',
    apiPath: 'natdss:natdssB141OutpatientOrderAndPres',
    entityName: 'NatdssB141OutpatientOrderAndPres',
    varName: 'natdssB141OutpatientOrderAndPres',
    formFields: ['orderCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB151OutpatientExpenseRecord',
    title: '门诊费用记录管理',
    desc: '管理门诊患者的费用记录',
    icon: 'i-ep-money',
    listTitle: '门诊费用记录列表',
    apiPath: 'natdss:natdssB151OutpatientExpenseRecord',
    entityName: 'NatdssB151OutpatientExpenseRecord',
    varName: 'natdssB151OutpatientExpenseRecord',
    formFields: ['expenseCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB162PathologicalExamRecord',
    title: '病理检查记录管理',
    desc: '管理病理检查的记录信息',
    icon: 'i-ep-document',
    listTitle: '病理检查记录列表',
    apiPath: 'natdss:natdssB162PathologicalExamRecord',
    entityName: 'NatdssB162PathologicalExamRecord',
    varName: 'natdssB162PathologicalExamRecord',
    formFields: ['examCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB163MolecularPathologyExamRecord',
    title: '分子病理检查记录管理',
    desc: '管理分子病理检查的记录',
    icon: 'i-ep-document',
    listTitle: '分子病理检查记录列表',
    apiPath: 'natdss:natdssB163MolecularPathologyExamRecord',
    entityName: 'NatdssB163MolecularPathologyExamRecord',
    varName: 'natdssB163MolecularPathologyExamRecord',
    formFields: ['examCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB161ExamInfo',
    title: '检查信息管理',
    desc: '管理患者的检查信息记录',
    icon: 'i-ep-zoom-in',
    listTitle: '检查信息列表',
    apiPath: 'natdss:natdssB161ExamInfo',
    entityName: 'NatdssB161ExamInfo',
    varName: 'natdssB161ExamInfo',
    formFields: ['examCode', 'examName']
  },
  {
    dir: 'natdss',
    file: 'natdssB172LabMicrobiologicalInfo',
    title: '微生物检验信息管理',
    desc: '管理微生物检验的信息记录',
    icon: 'i-ep-document',
    listTitle: '微生物检验信息列表',
    apiPath: 'natdss:natdssB172LabMicrobiologicalInfo',
    entityName: 'NatdssB172LabMicrobiologicalInfo',
    varName: 'natdssB172LabMicrobiologicalInfo',
    formFields: ['labCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB171LabInfo',
    title: '检验信息管理',
    desc: '管理患者的检验信息记录',
    icon: 'i-ep-document',
    listTitle: '检验信息列表',
    apiPath: 'natdss:natdssB171LabInfo',
    entityName: 'NatdssB171LabInfo',
    varName: 'natdssB171LabInfo',
    formFields: ['labCode', 'labName']
  },
  {
    dir: 'natdss',
    file: 'natdssB181RadInfo',
    title: '放射信息管理',
    desc: '管理患者的放射检查信息',
    icon: 'i-ep-picture',
    listTitle: '放射信息列表',
    apiPath: 'natdss:natdssB181RadInfo',
    entityName: 'NatdssB181RadInfo',
    varName: 'natdssB181RadInfo',
    formFields: ['radCode', 'patientName']
  },
  {
    dir: 'natdss',
    file: 'natdssB191FollowUp',
    title: '随访信息管理',
    desc: '管理患者的随访信息记录',
    icon: 'i-ep-phone',
    listTitle: '随访信息列表',
    apiPath: 'natdss:natdssB191FollowUp',
    entityName: 'NatdssB191FollowUp',
    varName: 'natdssB191FollowUp',
    formFields: ['followUpCode', 'patientName']
  },
  
  // qualification 目录 - 11个文件
  {
    dir: 'qualification',
    file: 'qualificationAdmissionCondition',
    title: '技术准入条件管理',
    desc: '管理医疗技术的准入条件和要求',
    icon: 'i-ep-document',
    listTitle: '准入条件列表',
    apiPath: 'qualification:qualificationAdmissionCondition',
    entityName: 'QualificationAdmissionCondition',
    varName: 'qualificationAdmissionCondition',
    formFields: ['conditionCode', 'conditionName']
  },
  {
    dir: 'qualification',
    file: 'qualificationAuthorizationApply',
    title: '技术授权申请管理',
    desc: '管理医疗技术的授权申请流程',
    icon: 'i-ep-document-add',
    listTitle: '授权申请列表',
    apiPath: 'qualification:qualificationAuthorizationApply',
    entityName: 'QualificationAuthorizationApply',
    varName: 'qualificationAuthorizationApply',
    formFields: ['applyCode', 'doctorName']
  },
  {
    dir: 'qualification',
    file: 'qualificationAuthorizationRecord',
    title: '技术授权记录管理',
    desc: '管理医疗技术的授权记录',
    icon: 'i-ep-document-checked',
    listTitle: '授权记录列表',
    apiPath: 'qualification:qualificationAuthorizationRecord',
    entityName: 'QualificationAuthorizationRecord',
    varName: 'qualificationAuthorizationRecord',
    formFields: ['recordCode', 'doctorName']
  },
  {
    dir: 'qualification',
    file: 'qualificationCatalog',
    title: '技术目录管理',
    desc: '管理医疗技术目录和分类',
    icon: 'i-ep-menu',
    listTitle: '技术目录列表',
    apiPath: 'qualification:qualificationCatalog',
    entityName: 'QualificationCatalog',
    varName: 'qualificationCatalog',
    formFields: ['catalogCode', 'catalogName']
  },
  {
    dir: 'qualification',
    file: 'qualificationExamArrangement',
    title: '资质考核安排管理',
    desc: '管理医护人员的资质考核安排',
    icon: 'i-ep-calendar',
    listTitle: '考核安排列表',
    apiPath: 'qualification:qualificationExamArrangement',
    entityName: 'QualificationExamArrangement',
    varName: 'qualificationExamArrangement',
    formFields: ['examCode', 'examName']
  },
  {
    dir: 'qualification',
    file: 'qualificationExamPaper',
    title: '考核试卷管理',
    desc: '管理资质考核的试卷内容',
    icon: 'i-ep-document-copy',
    listTitle: '考核试卷列表',
    apiPath: 'qualification:qualificationExamPaper',
    entityName: 'QualificationExamPaper',
    varName: 'qualificationExamPaper',
    formFields: ['paperCode', 'paperName']
  },
  {
    dir: 'qualification',
    file: 'qualificationExamQuestion',
    title: '考核题目管理',
    desc: '管理资质考核的题目内容',
    icon: 'i-ep-edit',
    listTitle: '考核题目列表',
    apiPath: 'qualification:qualificationExamQuestion',
    entityName: 'QualificationExamQuestion',
    varName: 'qualificationExamQuestion',
    formFields: ['questionCode', 'questionContent']
  },
  {
    dir: 'qualification',
    file: 'qualificationExamRecord',
    title: '考核记录管理',
    desc: '管理资质考核的考试记录',
    icon: 'i-ep-list',
    listTitle: '考核记录列表',
    apiPath: 'qualification:qualificationExamRecord',
    entityName: 'QualificationExamRecord',
    varName: 'qualificationExamRecord',
    formFields: ['examCode', 'doctorName']
  },
  {
    dir: 'qualification',
    file: 'qualificationPermissionAdjustment',
    title: '权限调整管理',
    desc: '管理医护人员的技术权限调整',
    icon: 'i-ep-setting',
    listTitle: '权限调整列表',
    apiPath: 'qualification:qualificationPermissionAdjustment',
    entityName: 'QualificationPermissionAdjustment',
    varName: 'qualificationPermissionAdjustment',
    formFields: ['adjustCode', 'doctorName']
  },
  {
    dir: 'qualification',
    file: 'qualificationRiskMonitor',
    title: '风险监控管理',
    desc: '管理技术使用的风险监控',
    icon: 'i-ep-warning',
    listTitle: '风险监控列表',
    apiPath: 'qualification:qualificationRiskMonitor',
    entityName: 'QualificationRiskMonitor',
    varName: 'qualificationRiskMonitor',
    formFields: ['monitorCode', 'doctorName']
  },
  {
    dir: 'qualification',
    file: 'qualificationUsageRecord',
    title: '技术使用记录管理',
    desc: '管理医疗技术的使用记录',
    icon: 'i-ep-tickets',
    listTitle: '使用记录列表',
    apiPath: 'qualification:qualificationUsageRecord',
    entityName: 'QualificationUsageRecord',
    varName: 'qualificationUsageRecord',
    formFields: ['recordCode', 'doctorName']
  },
  
  // ledger 目录 - 6个文件
  {
    dir: 'ledger',
    file: 'ledgerBusinessLearning',
    title: '业务学习记录管理',
    desc: '管理科室的业务学习记录',
    icon: 'i-ep-reading',
    listTitle: '业务学习记录列表',
    apiPath: 'ledger:ledgerBusinessLearning',
    entityName: 'LedgerBusinessLearning',
    varName: 'ledgerBusinessLearning',
    formFields: ['learningDate', 'learningTopic']
  },
  {
    dir: 'ledger',
    file: 'ledgerCriticalPatient',
    title: '危重患者登记管理',
    desc: '管理危重患者的登记和跟踪',
    icon: 'i-ep-warning-filled',
    listTitle: '危重患者登记列表',
    apiPath: 'ledger:ledgerCriticalPatient',
    entityName: 'LedgerCriticalPatient',
    varName: 'ledgerCriticalPatient',
    formFields: ['patientId', 'patientName']
  },
  {
    dir: 'ledger',
    file: 'ledgerLongStayPatient',
    title: '长期滞留患者管理',
    desc: '管理长期住院患者的记录',
    icon: 'i-ep-timer',
    listTitle: '长期滞留患者列表',
    apiPath: 'ledger:ledgerLongStayPatient',
    entityName: 'LedgerLongStayPatient',
    varName: 'ledgerLongStayPatient',
    formFields: ['patientId', 'patientName']
  },
  {
    dir: 'ledger',
    file: 'ledgerMajorSurgery',
    title: '重大手术记录管理',
    desc: '管理重大手术的详细记录',
    icon: 'i-ep-first-aid-kit',
    listTitle: '重大手术记录列表',
    apiPath: 'ledger:ledgerMajorSurgery',
    entityName: 'LedgerMajorSurgery',
    varName: 'ledgerMajorSurgery',
    formFields: ['patientId', 'surgeryName']
  },
  {
    dir: 'ledger',
    file: 'ledgerPatientFullCycle',
    title: '患者全周期管理',
    desc: '管理患者从入院到出院的全周期记录',
    icon: 'i-ep-circle-check',
    listTitle: '患者全周期列表',
    apiPath: 'ledger:ledgerPatientFullCycle',
    entityName: 'LedgerPatientFullCycle',
    varName: 'ledgerPatientFullCycle',
    formFields: ['patientId', 'patientName']
  },
  {
    dir: 'ledger',
    file: 'ledgerUnplannedReoperation',
    title: '非计划再次手术管理',
    desc: '管理非计划再次手术的记录',
    icon: 'i-ep-warning',
    listTitle: '非计划再次手术列表',
    apiPath: 'ledger:ledgerUnplannedReoperation',
    entityName: 'LedgerUnplannedReoperation',
    varName: 'ledgerUnplannedReoperation',
    formFields: ['patientId', 'surgeryName']
  }
];

// 执行替换的函数
function replaceTemplate(config: typeof configs[0]): string {
  let result = template;
  
  // 1. 先替换 API 导入路径（在替换变量名之前）
  result = result.replace(
    /@\/api\/emergency\/emergencyDrillPlan/g,
    `@/api/${config.dir}/${config.varName}`
  );
  
  // 2. 替换配置工具导入路径（在替换类名和变量名之前）
  result = result.replace(
    /createEmergencyDrillPlanFieldConfig/g,
    `create${config.entityName}FieldConfig`
  );
  result = result.replace(
    /createEmergencyDrillPlanSearchConfig/g,
    `create${config.entityName}SearchConfig`
  );
  result = result.replace(
    /@\/utils\/configs\/emergency\/emergencyFieldConfigs/g,
    `@/utils/configs/${config.dir}/${config.dir}FieldConfigs`
  );
  result = result.replace(
    /@\/utils\/configs\/emergency\/emergencySearchConfigs/g,
    `@/utils/configs/${config.dir}/${config.dir}SearchConfigs`
  );
  
  // 3. 替换页面标题和描述
  result = result.replace(/应急演练计划管理/g, config.title);
  result = result.replace(/管理应急演练计划的创建、执行和评估等全流程/g, config.desc);
  
  // 4. 替换图标
  result = result.replace(/<i-ep-document class="title-icon"><\/i-ep-document>/g, `<${config.icon} class="title-icon"></${config.icon}>`);
  
  // 5. 替换列表标题
  result = result.replace(/应急演练计划列表/g, config.listTitle);
  
  // 6. 替换权限路径
  result = result.replace(/emergency:emergencyDrillPlan/g, config.apiPath);
  
  // 7. 替换实体名称（类名）
  result = result.replace(/EmergencyDrillPlan/g, config.entityName);
  
  // 8. 替换变量名（小驼峰）
  result = result.replace(/emergencyDrillPlan/g, config.varName);
  
  // 9. 替换 script setup name
  result = result.replace(
    /name="EmergencyDrillPlan"/g,
    `name="${config.entityName}"`
  );
  
  // 10. 替换必填字段验证规则（简化为前两个字段）
  const [field1, field2] = config.formFields;
  result = result.replace(
    /planCode: \[{ required: true, message: '计划编码不能为空', trigger: 'blur' }\],\s*planName: \[{ required: true, message: '计划名称不能为空', trigger: 'blur' }\]/,
    `${field1}: [{ required: true, message: '${field1}不能为空', trigger: 'blur' }],\n  ${field2}: [{ required: true, message: '${field2}不能为空', trigger: 'blur' }]`
  );
  
  return result;
}

// 主执行函数
function main() {
  console.log('开始基于模板重构文件...\n');
  
  let successCount = 0;
  let failCount = 0;
  
  for (const config of configs) {
    try {
      const targetPath = path.join(
        __dirname,
        'src/views',
        config.dir,
        config.file,
        'index.vue'
      );
      
      // 检查目标文件是否存在
      if (!fs.existsSync(targetPath)) {
        console.log(`⚠ 跳过：${config.dir}/${config.file} (文件不存在)`);
        continue;
      }
      
      console.log(`处理：${config.dir}/${config.file}`);
      
      // 生成新内容
      const newContent = replaceTemplate(config);
      
      // 写入文件
      fs.writeFileSync(targetPath, newContent, 'utf-8');
      
      console.log(`  ✓ 完成\n`);
      successCount++;
    } catch (error) {
      console.error(`  ✗ 失败：${error}\n`);
      failCount++;
    }
  }
  
  console.log(`\n重构完成！`);
  console.log(`成功：${successCount} 个文件`);
  console.log(`失败：${failCount} 个文件`);
}

main();
