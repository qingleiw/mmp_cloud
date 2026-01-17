/**
 * 从SQL建表语句生成字段配置和搜索配置
 * 读取docs/1.sql中的CREATE TABLE语句，生成真实的字段配置
 */

import fs from 'fs';
import path from 'path';

// 表名到模块的映射
const tableToModule: Record<string, { dir: string; varName: string }> = {
  // emergency
  'mmp_emergency_drill_plan': { dir: 'emergency', varName: 'emergencyDrillPlan' },
  'mmp_emergency_drill_summary': { dir: 'emergency', varName: 'emergencyDrillSummary' },
  'mmp_emergency_event': { dir: 'emergency', varName: 'emergencyEvent' },
  'mmp_emergency_event_response': { dir: 'emergency', varName: 'emergencyEventResponse' },
  'mmp_emergency_event_treatment': { dir: 'emergency', varName: 'emergencyEventTreatment' },
  'mmp_emergency_incident': { dir: 'emergency', varName: 'emergencyIncident' },
  'mmp_emergency_medical_support': { dir: 'emergency', varName: 'emergencyMedicalSupport' },
  'mmp_emergency_plan': { dir: 'emergency', varName: 'emergencyPlan' },
  'mmp_emergency_plan_approval': { dir: 'emergency', varName: 'emergencyPlanApproval' },
  'mmp_emergency_team': { dir: 'emergency', varName: 'emergencyTeam' },
  'mmp_emergency_team_member': { dir: 'emergency', varName: 'emergencyTeamMember' },
  'mmp_important_medical_event': { dir: 'emergency', varName: 'importantMedicalEvent' },
  
  // doctor
  'mmp_doctor_ability_assessment': { dir: 'doctor', varName: 'doctorAbilityAssessment' },
  'mmp_doctor_academic_position': { dir: 'doctor', varName: 'doctorAcademicPosition' },
  'mmp_doctor_adverse_record': { dir: 'doctor', varName: 'doctorAdverseRecord' },
  'mmp_doctor_basic_info': { dir: 'doctor', varName: 'doctorBasicInfo' },
  'mmp_doctor_certificate': { dir: 'doctor', varName: 'doctorCertificate' },
  'mmp_doctor_education': { dir: 'doctor', varName: 'doctorEducation' },
  'mmp_doctor_electronic_registration': { dir: 'doctor', varName: 'doctorElectronicRegistration' },
  'mmp_doctor_ethics_evaluation': { dir: 'doctor', varName: 'doctorEthicsEvaluation' },
  'mmp_doctor_honor': { dir: 'doctor', varName: 'doctorHonor' },
  'mmp_doctor_info': { dir: 'doctor', varName: 'doctorInfo' },
  'mmp_doctor_insurance_code': { dir: 'doctor', varName: 'doctorInsuranceCode' },
  'mmp_doctor_professional_rating': { dir: 'doctor', varName: 'doctorProfessionalRating' },
  'mmp_doctor_publication': { dir: 'doctor', varName: 'doctorPublication' },
  'mmp_doctor_qualification_catalog': { dir: 'doctor', varName: 'doctorQualificationCatalog' },
  'mmp_doctor_research_project': { dir: 'doctor', varName: 'doctorResearchProject' },
  'mmp_doctor_training': { dir: 'doctor', varName: 'doctorTraining' },
  'mmp_doctor_work_experience': { dir: 'doctor', varName: 'doctorWorkExperience' },
  
  // ntp
  'mmp_new_technology_project': { dir: 'ntp', varName: 'newTechnologyProject' },
  'mmp_new_technology_project_assessment': { dir: 'ntp', varName: 'newTechnologyProjectAssessment' },
  'mmp_new_technology_project_case': { dir: 'ntp', varName: 'newTechnologyProjectCase' },
  'mmp_new_technology_project_document': { dir: 'ntp', varName: 'newTechnologyProjectDocument' },
  'mmp_new_technology_project_extension': { dir: 'ntp', varName: 'newTechnologyProjectExtension' },
  'mmp_new_technology_project_implementation': { dir: 'ntp', varName: 'newTechnologyProjectImplementation' },
  'mmp_new_technology_project_mapping': { dir: 'ntp', varName: 'newTechnologyProjectMapping' },
  'mmp_new_technology_project_progress': { dir: 'ntp', varName: 'newTechnologyProjectProgress' },
  
  // qc
  'mmp_qc_data_collection': { dir: 'qc', varName: 'qcDataCollection' },
  'mmp_qc_indicator_collection_config': { dir: 'qc', varName: 'qcIndicatorCollectionConfig' },
  'mmp_qc_indicator_factor': { dir: 'qc', varName: 'qcIndicatorFactor' },
  'mmp_qc_manual_data': { dir: 'qc', varName: 'qcManualData' },
  'mmp_qc_quality_indicator': { dir: 'qc', varName: 'qcQualityIndicator' },
  'mmp_qc_scoring_result': { dir: 'qc', varName: 'qcScoringResult' },
  'mmp_qc_scoring_rule': { dir: 'qc', varName: 'qcScoringRule' },
  'mmp_qc_specialty_category': { dir: 'qc', varName: 'qcSpecialtyCategory' },
  
  // complaintdispute
  'mmp_complaint_dispute': { dir: 'complaintdispute', varName: 'complaintDispute' },
  'mmp_complaint_handling': { dir: 'complaintdispute', varName: 'complaintHandling' },
  'mmp_complaint_investigation': { dir: 'complaintdispute', varName: 'complaintInvestigation' },
  
  // coresystem
  'mmp_core_system_assessment_record': { dir: 'coresystem', varName: 'coreSystemAssessmentRecord' },
  'mmp_core_system_config': { dir: 'coresystem', varName: 'coreSystemConfig' },
  'mmp_core_system_execution_record': { dir: 'coresystem', varName: 'coreSystemExecutionRecord' },
  'mmp_core_system_indicator': { dir: 'coresystem', varName: 'coreSystemIndicator' },
  'mmp_core_system_inspection_record': { dir: 'coresystem', varName: 'coreSystemInspectionRecord' },
  'mmp_core_system_rectification_record': { dir: 'coresystem', varName: 'coreSystemRectificationRecord' },
  
  // tumorqc
  'mmp_tumor_qc_indicator_config': { dir: 'tumorqc', varName: 'tumorQcIndicatorConfig' },
  'mmp_tumor_qc_indicator_detail': { dir: 'tumorqc', varName: 'tumorQcIndicatorDetail' },
  'mmp_tumor_qc_indicator_record': { dir: 'tumorqc', varName: 'tumorQcIndicatorRecord' },
  'mmp_tumor_qc_inspection': { dir: 'tumorqc', varName: 'tumorQcInspection' },
  'mmp_tumor_qc_plan': { dir: 'tumorqc', varName: 'tumorQcPlan' },
  'mmp_tumor_qc_rectification': { dir: 'tumorqc', varName: 'tumorQcRectification' },
  'mmp_tumor_qc_report': { dir: 'tumorqc', varName: 'tumorQcReport' },
  'mmp_tumor_qc_result': { dir: 'tumorqc', varName: 'tumorQcResult' },
  
  // ledger
  'mmp_ledger_business_learning': { dir: 'ledger', varName: 'ledgerBusinessLearning' },
  'mmp_ledger_critical_patient': { dir: 'ledger', varName: 'ledgerCriticalPatient' },
  'mmp_ledger_long_stay_patient': { dir: 'ledger', varName: 'ledgerLongStayPatient' },
  'mmp_ledger_major_surgery': { dir: 'ledger', varName: 'ledgerMajorSurgery' },
  'mmp_ledger_patient_full_cycle': { dir: 'ledger', varName: 'ledgerPatientFullCycle' },
  'mmp_ledger_unplanned_reoperation': { dir: 'ledger', varName: 'ledgerUnplannedReoperation' },
  
  // natdss
  'mmp_natdss_b01_1_drug_purchase': { dir: 'natdss', varName: 'natdssB011DrugPurchase' },
  'mmp_natdss_b01_2_drug_use': { dir: 'natdss', varName: 'natdssB012DrugUse' },
  'mmp_natdss_b02_1_patient_info': { dir: 'natdss', varName: 'natdssB021PatientInfo' },
  'mmp_natdss_b02_2_adr_info': { dir: 'natdss', varName: 'natdssB022AdrInfo' },
  'mmp_natdss_b02_3_diag_info': { dir: 'natdss', varName: 'natdssB023DiagInfo' },
  'mmp_natdss_b03_1_inpatient_info': { dir: 'natdss', varName: 'natdssB031InpatientInfo' },
  'mmp_natdss_b05_1_emr_admission': { dir: 'natdss', varName: 'natdssB051EmrAdmission' },
  'mmp_natdss_b06_1_emr_progress_notes': { dir: 'natdss', varName: 'natdssB061EmrProgressNotes' },
  'mmp_natdss_b07_1_emr_discharge': { dir: 'natdss', varName: 'natdssB071EmrDischarge' },
  'mmp_natdss_b08_1_inpatient_surgical_record': { dir: 'natdss', varName: 'natdssB081InpatientSurgicalRecord' },
  'mmp_natdss_b09_1_inpatient_nursing_record': { dir: 'natdss', varName: 'natdssB091InpatientNursingRecord' },
  'mmp_natdss_b10_1_inpatient_order': { dir: 'natdss', varName: 'natdssB101InpatientOrder' },
  'mmp_natdss_b11_1_inpatient_expense_record': { dir: 'natdss', varName: 'natdssB111InpatientExpenseRecord' },
  'mmp_natdss_b12_1_outpatient_info': { dir: 'natdss', varName: 'natdssB121OutpatientInfo' },
  'mmp_natdss_b13_1_outpatient_diag_and_medrecord': { dir: 'natdss', varName: 'natdssB131OutpatientDiagAndMedrecord' },
  'mmp_natdss_b14_1_outpatient_order_and_pres': { dir: 'natdss', varName: 'natdssB141OutpatientOrderAndPres' },
  'mmp_natdss_b15_1_outpatient_expense_record': { dir: 'natdss', varName: 'natdssB151OutpatientExpenseRecord' },
  'mmp_natdss_b16_1_exam_info': { dir: 'natdss', varName: 'natdssB161ExamInfo' },
  'mmp_natdss_b17_1_lab_info': { dir: 'natdss', varName: 'natdssB171LabInfo' },
  'mmp_natdss_b18_1_rad_info': { dir: 'natdss', varName: 'natdssB181RadInfo' },
  'mmp_natdss_b19_1_follow_up': { dir: 'natdss', varName: 'natdssB191FollowUp' },
  
  // qualification
  'mmp_qualification_admission_condition': { dir: 'qualification', varName: 'qualificationAdmissionCondition' },
  'mmp_qualification_authorization_apply': { dir: 'qualification', varName: 'qualificationAuthorizationApply' },
  'mmp_qualification_authorization_record': { dir: 'qualification', varName: 'qualificationAuthorizationRecord' },
  'mmp_qualification_catalog': { dir: 'qualification', varName: 'qualificationCatalog' },
  'mmp_qualification_exam_arrangement': { dir: 'qualification', varName: 'qualificationExamArrangement' },
  'mmp_qualification_exam_paper': { dir: 'qualification', varName: 'qualificationExamPaper' },
  'mmp_qualification_exam_question': { dir: 'qualification', varName: 'qualificationExamQuestion' },
  'mmp_qualification_exam_record': { dir: 'qualification', varName: 'qualificationExamRecord' },
  'mmp_qualification_permission_adjustment': { dir: 'qualification', varName: 'qualificationPermissionAdjustment' },
  'mmp_qualification_risk_monitor': { dir: 'qualification', varName: 'qualificationRiskMonitor' },
  'mmp_qualification_usage_record': { dir: 'qualification', varName: 'qualificationUsageRecord' },
  
  // radiation
  'mmp_radiation_dose_alert': { dir: 'radiation', varName: 'radiationDoseAlert' },
  'mmp_radiation_dose_alert_record': { dir: 'radiation', varName: 'radiationDoseAlertRecord' },
  'mmp_radiation_dose_monitoring': { dir: 'radiation', varName: 'radiationDoseMonitoring' },
  'mmp_radiation_dose_record': { dir: 'radiation', varName: 'radiationDoseRecord' },
  'mmp_radiation_equipment_inspection': { dir: 'radiation', varName: 'radiationEquipmentInspection' },
  'mmp_radiation_health_exam': { dir: 'radiation', varName: 'radiationHealthExam' },
  'mmp_radiation_health_exam_plan': { dir: 'radiation', varName: 'radiationHealthExamPlan' },
  'mmp_radiation_health_exam_result': { dir: 'radiation', varName: 'radiationHealthExamResult' },
  'mmp_radiation_staff': { dir: 'radiation', varName: 'radiationStaff' },
  'mmp_radiation_training': { dir: 'radiation', varName: 'radiationTraining' },
  'mmp_radiation_training_participant': { dir: 'radiation', varName: 'radiationTrainingParticipant' },
  'mmp_radiation_training_plan': { dir: 'radiation', varName: 'radiationTrainingPlan' },
  'mmp_radiation_worker': { dir: 'radiation', varName: 'radiationWorker' },
  
  // supervision
  'mmp_supervision_expert_group': { dir: 'supervision', varName: 'supervisionExpertGroup' },
  'mmp_supervision_expert_member': { dir: 'supervision', varName: 'supervisionExpertMember' },
  'mmp_supervision_form': { dir: 'supervision', varName: 'supervisionForm' },
  'mmp_supervision_form_field': { dir: 'supervision', varName: 'supervisionFormField' },
  'mmp_supervision_issue': { dir: 'supervision', varName: 'supervisionIssue' },
  'mmp_supervision_plan': { dir: 'supervision', varName: 'supervisionPlan' },
  'mmp_supervision_plan_dept': { dir: 'supervision', varName: 'supervisionPlanDept' },
  'mmp_supervision_plan_form': { dir: 'supervision', varName: 'supervisionPlanForm' },
  'mmp_supervision_project': { dir: 'supervision', varName: 'supervisionProject' },
  'mmp_supervision_project_indicator': { dir: 'supervision', varName: 'supervisionProjectIndicator' },
  'mmp_supervision_rectification_progress': { dir: 'supervision', varName: 'supervisionRectificationProgress' },
  'mmp_supervision_rectification_task': { dir: 'supervision', varName: 'supervisionRectificationTask' },
  'mmp_supervision_result': { dir: 'supervision', varName: 'supervisionResult' },
  'mmp_supervision_result_detail': { dir: 'supervision', varName: 'supervisionResultDetail' },
  'mmp_supervision_review': { dir: 'supervision', varName: 'supervisionReview' },
  
  // surgery
  'mmp_surgery_approval_form': { dir: 'surgery', varName: 'surgeryApprovalForm' },
  'mmp_surgery_catalog': { dir: 'surgery', varName: 'surgeryCatalog' },
  'mmp_surgery_complication_record': { dir: 'surgery', varName: 'surgeryComplicationRecord' },
  'mmp_surgery_record': { dir: 'surgery', varName: 'surgeryRecord' },
  'mmp_surgery_team': { dir: 'surgery', varName: 'surgeryTeam' },
  'mmp_surgery_video': { dir: 'surgery', varName: 'surgeryVideo' },
  'mmp_surgery_workload_statistics': { dir: 'surgery', varName: 'surgeryWorkloadStatistics' },
};

interface FieldInfo {
  prop: string;
  label: string;
  type: string;
  required: boolean;
}

// SQL类型映射到前端类型
function sqlTypeToFieldType(sqlType: string): string {
  const lowerType = sqlType.toLowerCase();
  if (lowerType.includes('int') || lowerType.includes('decimal') || lowerType.includes('double') || lowerType.includes('float')) {
    return 'number';
  }
  if (lowerType.includes('datetime') || lowerType.includes('timestamp')) {
    return 'datetime';
  }
  if (lowerType.includes('date')) {
    return 'date';
  }
  if (lowerType.includes('text')) {
    return 'textarea';
  }
  if (lowerType.includes('char(1)') || lowerType.includes('tinyint(1)')) {
    return 'select';
  }
  return 'input';
}

// 下划线转驼峰
function toCamelCase(str: string): string {
  return str.replace(/_([a-z])/g, (_, letter) => letter.toUpperCase());
}

function getSearchType(fieldType: string): string {
  const map: Record<string, string> = {
    'input': 'input',
    'number': 'number',
    'select': 'select',
    'date': 'daterange',
    'datetime': 'daterange',
    'textarea': 'input',
    'switch': 'select'
  };
  return map[fieldType] || 'input';
}

// 解析CREATE TABLE语句
function parseCreateTable(sqlContent: string, tableName: string): FieldInfo[] {
  const fields: FieldInfo[] = [];
  
  // 匹配CREATE TABLE语句
  const tableRegex = new RegExp(`CREATE TABLE[^(]*\`${tableName}\`[^(]*\\(([^;]+)\\)`, 'is');
  const match = sqlContent.match(tableRegex);
  
  if (!match) {
    return fields;
  }
  
  const tableBody = match[1];
  
  // 按行分割，每行处理一个字段
  const lines = tableBody.split('\n').map(line => line.trim()).filter(line => line.startsWith('`'));
  
  for (const line of lines) {
    // 匹配字段定义: `field_name` type [constraints] COMMENT 'comment'
    const fieldMatch = line.match(/`(\w+)`\s+([^\s]+).*?COMMENT\s+'([^']+)'/i);
    if (!fieldMatch) continue;
    
    const [, fieldName, sqlType, comment] = fieldMatch;
    
    const fieldType = sqlTypeToFieldType(sqlType);
    const label = comment.replace(/\([^)]*\)/g, '').trim(); // 移除注释中的括号说明
    const camelCaseName = toCamelCase(fieldName); // 转换为驼峰命名
    
    fields.push({
      prop: camelCaseName,
      label,
      type: fieldType,
      required: false // 不强制必填，让用户自己决定
    });
  }
  
  return fields;
}

// 生成FieldConfig
function generateFieldConfig(varName: string, fields: FieldInfo[]): string {
  const entityName = varName.charAt(0).toUpperCase() + varName.slice(1);
  
  // 系统字段名称列表
  const systemFieldNames = ['delFlag', 'createTime', 'createBy', 'updateTime', 'updateBy', 'createDept', 'remark'];
  
  // 按类型分组
  const basicFields = fields.filter(f => 
    ['code', 'name', 'title', 'no', 'type', 'level', 'status', 'id'].some(key => f.prop.toLowerCase().includes(key)) &&
    !systemFieldNames.includes(f.prop)
  ).slice(0, 8);
  
  const otherFields = fields.filter(f => !basicFields.includes(f) && !systemFieldNames.includes(f.prop));
  const systemFields = fields.filter(f => systemFieldNames.includes(f.prop));
  
  let result = `\n// ${varName}字段配置\n`;
  result += `export function create${entityName}FieldConfig() {\n`;
  result += `  const fieldGroups: FieldGroup[] = [\n`;
  
  if (basicFields.length > 0) {
    result += `    {\n`;
    result += `      name: 'basic',\n`;
    result += `      label: '基础信息',\n`;
    result += `      fields: [\n`;
    basicFields.forEach((field, index) => {
      result += `        { prop: '${field.prop}', label: '${field.label}', visible: true, type: '${field.type}', group: 'basic' }`;
      if (index < basicFields.length - 1) result += ',\n';
      else result += '\n';
    });
    result += `      ]\n`;
    result += `    }`;
    if (otherFields.length > 0 || systemFields.length > 0) result += ',\n';
    else result += '\n';
  }
  
  if (otherFields.length > 0) {
    result += `    {\n`;
    result += `      name: 'detail',\n`;
    result += `      label: '详细信息',\n`;
    result += `      fields: [\n`;
    otherFields.forEach((field, index) => {
      result += `        { prop: '${field.prop}', label: '${field.label}', visible: true, type: '${field.type}', group: 'detail' }`;
      if (index < otherFields.length - 1) result += ',\n';
      else result += '\n';
    });
    result += `      ]\n`;
    result += `    }`;
    if (systemFields.length > 0) result += ',\n';
    else result += '\n';
  }
  
  // 系统字段 - 使用实际从SQL解析出来的字段
  if (systemFields.length > 0) {
    result += `    {\n`;
    result += `      name: 'system',\n`;
    result += `      label: '系统字段',\n`;
    result += `      fields: [\n`;
    systemFields.forEach((field, index) => {
      result += `        { prop: '${field.prop}', label: '${field.label}', visible: true, type: '${field.type}', group: 'system' }`;
      if (index < systemFields.length - 1) result += ',\n';
      else result += '\n';
    });
    result += `      ]\n`;
    result += `    }\n`;
  }
  
  result += `  ];\n\n`;
  result += `  return new FieldConfigManager('${varName}', fieldGroups);\n`;
  result += `}\n`;
  
  return result;
}

// 生成SearchConfig
function generateSearchConfig(varName: string, fields: FieldInfo[]): string {
  const entityName = varName.charAt(0).toUpperCase() + varName.slice(1);
  
  // 系统字段名称列表
  const systemFieldNames = ['delFlag', 'createTime', 'createBy', 'updateTime', 'updateBy', 'createDept', 'remark'];
  
  // 按类型分组，与FieldConfig保持一致
  const basicFields = fields.filter(f => 
    ['code', 'name', 'title', 'no', 'type', 'level', 'status', 'id'].some(key => f.prop.toLowerCase().includes(key)) &&
    !systemFieldNames.includes(f.prop)
  ).slice(0, 8);
  
  const detailFields = fields.filter(f => !basicFields.includes(f) && !systemFieldNames.includes(f.prop));
  const systemFields = fields.filter(f => systemFieldNames.includes(f.prop));
  
  // 前5个字段默认可见
  let visibleCount = 0;
  const maxVisible = 5;
  
  let result = `\n// ${varName}搜索配置\n`;
  result += `export function create${entityName}SearchConfig() {\n`;
  result += `  const searchFieldGroups: SearchFieldGroup[] = [\n`;
  
  // 基础信息组
  if (basicFields.length > 0) {
    result += `    {\n`;
    result += `      name: 'basic',\n`;
    result += `      label: '基础信息',\n`;
    result += `      fields: [\n`;
    basicFields.forEach((field, index) => {
      const searchType = getSearchType(field.type);
      const isVisible = visibleCount < maxVisible;
      if (isVisible) visibleCount++;
      
      let fieldDef = `        { prop: '${field.prop}', label: '${field.label}', type: '${searchType}', visible: ${isVisible}, placeholder: '请输入${field.label}'`;
      
      if (searchType === 'daterange') {
        fieldDef += `, startProp: '${field.prop}Start', endProp: '${field.prop}End'`;
      }
      
      fieldDef += ' }';
      if (index < basicFields.length - 1) fieldDef += ',\n';
      else fieldDef += '\n';
      
      result += fieldDef;
    });
    result += `      ]\n`;
    result += `    }`;
    if (detailFields.length > 0 || systemFields.length > 0) result += ',\n';
    else result += '\n';
  }
  
  // 详细信息组
  if (detailFields.length > 0) {
    result += `    {\n`;
    result += `      name: 'detail',\n`;
    result += `      label: '详细信息',\n`;
    result += `      fields: [\n`;
    detailFields.forEach((field, index) => {
      const searchType = getSearchType(field.type);
      const isVisible = visibleCount < maxVisible;
      if (isVisible) visibleCount++;
      
      let fieldDef = `        { prop: '${field.prop}', label: '${field.label}', type: '${searchType}', visible: ${isVisible}, placeholder: '请输入${field.label}'`;
      
      if (searchType === 'daterange') {
        fieldDef += `, startProp: '${field.prop}Start', endProp: '${field.prop}End'`;
      }
      
      fieldDef += ' }';
      if (index < detailFields.length - 1) fieldDef += ',\n';
      else fieldDef += '\n';
      
      result += fieldDef;
    });
    result += `      ]\n`;
    result += `    }`;
    if (systemFields.length > 0) result += ',\n';
    else result += '\n';
  }
  
  // 系统字段组
  if (systemFields.length > 0) {
    result += `    {\n`;
    result += `      name: 'system',\n`;
    result += `      label: '系统字段',\n`;
    result += `      fields: [\n`;
    systemFields.forEach((field, index) => {
      const searchType = getSearchType(field.type);
      // 系统字段默认不可见
      const isVisible = false;
      
      let fieldDef = `        { prop: '${field.prop}', label: '${field.label}', type: '${searchType}', visible: ${isVisible}, placeholder: '请输入${field.label}'`;
      
      if (searchType === 'daterange') {
        fieldDef += `, startProp: '${field.prop}Start', endProp: '${field.prop}End'`;
      }
      
      fieldDef += ' }';
      if (index < systemFields.length - 1) fieldDef += ',\n';
      else fieldDef += '\n';
      
      result += fieldDef;
    });
    result += `      ]\n`;
    result += `    }\n`;
  }
  
  result += `  ];\n\n`;
  result += `  return new SearchConfigManager('${varName}', searchFieldGroups);\n`;
  result += `}\n`;
  
  return result;
}

// 主函数
function main() {
  console.log('🚀 从SQL建表语句生成配置...\n');
  
  const sqlFilePath = path.join(process.cwd(), '..', 'docs', '1.sql');
  
  if (!fs.existsSync(sqlFilePath)) {
    console.error('❌ 找不到SQL文件:', sqlFilePath);
    return;
  }
  
  const sqlContent = fs.readFileSync(sqlFilePath, 'utf-8');
  
  const configsByDir: Record<string, { fieldConfigs: string[], searchConfigs: string[] }> = {};
  
  Object.entries(tableToModule).forEach(([tableName, { dir, varName }]) => {
    console.log(`处理: ${tableName} -> ${varName}`);
    
    const fields = parseCreateTable(sqlContent, tableName);
    
    if (fields.length === 0) {
      console.log(`  ⚠️  未找到表定义或字段`);
      return;
    }
    
    console.log(`  ✓ 找到 ${fields.length} 个字段:`, fields.map(f => f.prop).join(', '));
    
    if (!configsByDir[dir]) {
      configsByDir[dir] = { fieldConfigs: [], searchConfigs: [] };
    }
    
    const fieldConfig = generateFieldConfig(varName, fields);
    const searchConfig = generateSearchConfig(varName, fields);
    
    configsByDir[dir].fieldConfigs.push(fieldConfig);
    configsByDir[dir].searchConfigs.push(searchConfig);
  });
  
  // 写入文件
  Object.keys(configsByDir).forEach(dir => {
    const { fieldConfigs, searchConfigs } = configsByDir[dir];
    
    // 写入FieldConfigs
    const fieldConfigPath = path.join(process.cwd(), 'src', 'utils', 'configs', dir, `${dir}FieldConfigs.ts`);
    let fieldContent = `import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';\n`;
    fieldContent += fieldConfigs.join('\n');
    fs.writeFileSync(fieldConfigPath, fieldContent, 'utf-8');
    console.log(`\n✅ 已更新 ${dir}FieldConfigs.ts，包含 ${fieldConfigs.length} 个函数`);
    
    // 写入SearchConfigs
    const searchConfigPath = path.join(process.cwd(), 'src', 'utils', 'configs', dir, `${dir}SearchConfigs.ts`);
    let searchContent = `import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';\n`;
    searchContent += searchConfigs.join('\n');
    fs.writeFileSync(searchConfigPath, searchContent, 'utf-8');
    console.log(`✅ 已更新 ${dir}SearchConfigs.ts，包含 ${searchConfigs.length} 个函数`);
  });
  
  console.log('\n✨ 生成完成！所有配置都基于SQL建表语句');
}

main();
