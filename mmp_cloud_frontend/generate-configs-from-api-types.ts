/**
 * 从API types文件生成字段配置和搜索配置
 * 读取实际的VO接口定义，生成真实的字段配置
 */

import fs from 'fs';
import path from 'path';
import * as ts from 'typescript';

// 目录和模块映射
const modules = [
  // emergency
  { dir: 'emergency', varName: 'emergencyDrillPlan', apiPath: 'emergency/emergencyDrillPlan' },
  { dir: 'emergency', varName: 'emergencyDrillSummary', apiPath: 'emergency/emergencyDrillSummary' },
  { dir: 'emergency', varName: 'emergencyEvent', apiPath: 'emergency/emergencyEvent' },
  { dir: 'emergency', varName: 'emergencyEventResponse', apiPath: 'emergency/emergencyEventResponse' },
  { dir: 'emergency', varName: 'emergencyEventTreatment', apiPath: 'emergency/emergencyEventTreatment' },
  { dir: 'emergency', varName: 'emergencyIncident', apiPath: 'emergency/emergencyIncident' },
  { dir: 'emergency', varName: 'emergencyMedicalSupport', apiPath: 'emergency/emergencyMedicalSupport' },
  { dir: 'emergency', varName: 'emergencyPlan', apiPath: 'emergency/emergencyPlan' },
  { dir: 'emergency', varName: 'emergencyPlanApproval', apiPath: 'emergency/emergencyPlanApproval' },
  { dir: 'emergency', varName: 'emergencyTeam', apiPath: 'emergency/emergencyTeam' },
  { dir: 'emergency', varName: 'emergencyTeamMember', apiPath: 'emergency/emergencyTeamMember' },
  { dir: 'emergency', varName: 'importantMedicalEvent', apiPath: 'emergency/importantMedicalEvent' },
  
  // doctor
  { dir: 'doctor', varName: 'doctorAbilityAssessment', apiPath: 'doctor/doctorAbilityAssessment' },
  { dir: 'doctor', varName: 'doctorAcademicPosition', apiPath: 'doctor/doctorAcademicPosition' },
  { dir: 'doctor', varName: 'doctorAdverseRecord', apiPath: 'doctor/doctorAdverseRecord' },
  { dir: 'doctor', varName: 'doctorBasicInfo', apiPath: 'doctor/doctorBasicInfo' },
  { dir: 'doctor', varName: 'doctorCertificate', apiPath: 'doctor/doctorCertificate' },
  { dir: 'doctor', varName: 'doctorEducation', apiPath: 'doctor/doctorEducation' },
  { dir: 'doctor', varName: 'doctorElectronicRegistration', apiPath: 'doctor/doctorElectronicRegistration' },
  { dir: 'doctor', varName: 'doctorEthicsEvaluation', apiPath: 'doctor/doctorEthicsEvaluation' },
  { dir: 'doctor', varName: 'doctorHonor', apiPath: 'doctor/doctorHonor' },
  { dir: 'doctor', varName: 'doctorInfo', apiPath: 'doctor/doctorInfo' },
  { dir: 'doctor', varName: 'doctorInsuranceCode', apiPath: 'doctor/doctorInsuranceCode' },
  { dir: 'doctor', varName: 'doctorProfessionalRating', apiPath: 'doctor/doctorProfessionalRating' },
  { dir: 'doctor', varName: 'doctorPublication', apiPath: 'doctor/doctorPublication' },
  { dir: 'doctor', varName: 'doctorQualificationCatalog', apiPath: 'doctor/doctorQualificationCatalog' },
  { dir: 'doctor', varName: 'doctorResearchProject', apiPath: 'doctor/doctorResearchProject' },
  { dir: 'doctor', varName: 'doctorTraining', apiPath: 'doctor/doctorTraining' },
  { dir: 'doctor', varName: 'doctorWorkExperience', apiPath: 'doctor/doctorWorkExperience' },
  
  // ntp
  { dir: 'ntp', varName: 'newTechnologyProject', apiPath: 'ntp/newTechnologyProject' },
  { dir: 'ntp', varName: 'newTechnologyProjectAssessment', apiPath: 'ntp/newTechnologyProjectAssessment' },
  { dir: 'ntp', varName: 'newTechnologyProjectCase', apiPath: 'ntp/newTechnologyProjectCase' },
  { dir: 'ntp', varName: 'newTechnologyProjectDocument', apiPath: 'ntp/newTechnologyProjectDocument' },
  { dir: 'ntp', varName: 'newTechnologyProjectExtension', apiPath: 'ntp/newTechnologyProjectExtension' },
  { dir: 'ntp', varName: 'newTechnologyProjectImplementation', apiPath: 'ntp/newTechnologyProjectImplementation' },
  { dir: 'ntp', varName: 'newTechnologyProjectMapping', apiPath: 'ntp/newTechnologyProjectMapping' },
  { dir: 'ntp', varName: 'newTechnologyProjectProgress', apiPath: 'ntp/newTechnologyProjectProgress' },
  
  // qc
  { dir: 'qc', varName: 'qcDataCollection', apiPath: 'qc/qcDataCollection' },
  { dir: 'qc', varName: 'qcIndicatorCollectionConfig', apiPath: 'qc/qcIndicatorCollectionConfig' },
  { dir: 'qc', varName: 'qcIndicatorFactor', apiPath: 'qc/qcIndicatorFactor' },
  { dir: 'qc', varName: 'qcManualData', apiPath: 'qc/qcManualData' },
  { dir: 'qc', varName: 'qcQualityIndicator', apiPath: 'qc/qcQualityIndicator' },
  { dir: 'qc', varName: 'qcScoringResult', apiPath: 'qc/qcScoringResult' },
  { dir: 'qc', varName: 'qcScoringRule', apiPath: 'qc/qcScoringRule' },
  { dir: 'qc', varName: 'qcSpecialtyCategory', apiPath: 'qc/qcSpecialtyCategory' },
  
  // complaintdispute
  { dir: 'complaintdispute', varName: 'complaintDispute', apiPath: 'complaintdispute/complaintDispute' },
  { dir: 'complaintdispute', varName: 'complaintHandling', apiPath: 'complaintdispute/complaintHandling' },
  { dir: 'complaintdispute', varName: 'complaintInvestigation', apiPath: 'complaintdispute/complaintInvestigation' },
  
  // coresystem
  { dir: 'coresystem', varName: 'coreSystemAssessmentRecord', apiPath: 'coresystem/coreSystemAssessmentRecord' },
  { dir: 'coresystem', varName: 'coreSystemConfig', apiPath: 'coresystem/coreSystemConfig' },
  { dir: 'coresystem', varName: 'coreSystemExecutionRecord', apiPath: 'coresystem/coreSystemExecutionRecord' },
  { dir: 'coresystem', varName: 'coreSystemIndicator', apiPath: 'coresystem/coreSystemIndicator' },
  { dir: 'coresystem', varName: 'coreSystemInspectionRecord', apiPath: 'coresystem/coreSystemInspectionRecord' },
  { dir: 'coresystem', varName: 'coreSystemRectificationRecord', apiPath: 'coresystem/coreSystemRectificationRecord' },
  
  // tumorqc
  { dir: 'tumorqc', varName: 'tumorQcIndicatorConfig', apiPath: 'tumorqc/tumorQcIndicatorConfig' },
  { dir: 'tumorqc', varName: 'tumorQcIndicatorDetail', apiPath: 'tumorqc/tumorQcIndicatorDetail' },
  { dir: 'tumorqc', varName: 'tumorQcIndicatorRecord', apiPath: 'tumorqc/tumorQcIndicatorRecord' },
  { dir: 'tumorqc', varName: 'tumorQcInspection', apiPath: 'tumorqc/tumorQcInspection' },
  { dir: 'tumorqc', varName: 'tumorQcPlan', apiPath: 'tumorqc/tumorQcPlan' },
  { dir: 'tumorqc', varName: 'tumorQcRectification', apiPath: 'tumorqc/tumorQcRectification' },
  { dir: 'tumorqc', varName: 'tumorQcReport', apiPath: 'tumorqc/tumorQcReport' },
  { dir: 'tumorqc', varName: 'tumorQcResult', apiPath: 'tumorqc/tumorQcResult' },
  
  // ledger
  { dir: 'ledger', varName: 'deathCaseDiscussion', apiPath: 'ledger/deathCaseDiscussion' },
  { dir: 'ledger', varName: 'ledgerBusinessLearning', apiPath: 'ledger/ledgerBusinessLearning' },
  { dir: 'ledger', varName: 'ledgerCriticalPatient', apiPath: 'ledger/ledgerCriticalPatient' },
  { dir: 'ledger', varName: 'ledgerLongStayPatient', apiPath: 'ledger/ledgerLongStayPatient' },
  { dir: 'ledger', varName: 'ledgerMajorSurgery', apiPath: 'ledger/ledgerMajorSurgery' },
  { dir: 'ledger', varName: 'ledgerPatientFullCycle', apiPath: 'ledger/ledgerPatientFullCycle' },
  { dir: 'ledger', varName: 'ledgerUnplannedReoperation', apiPath: 'ledger/ledgerUnplannedReoperation' },
  { dir: 'ledger', varName: 'medicalStats', apiPath: 'ledger/medicalStats' },
  
  // qualification
  { dir: 'qualification', varName: 'qualificationAdmissionCondition', apiPath: 'qualification/qualificationAdmissionCondition' },
  { dir: 'qualification', varName: 'qualificationAuthorizationApply', apiPath: 'qualification/qualificationAuthorizationApply' },
  { dir: 'qualification', varName: 'qualificationAuthorizationRecord', apiPath: 'qualification/qualificationAuthorizationRecord' },
  { dir: 'qualification', varName: 'qualificationCatalog', apiPath: 'qualification/qualificationCatalog' },
  { dir: 'qualification', varName: 'qualificationExamArrangement', apiPath: 'qualification/qualificationExamArrangement' },
  { dir: 'qualification', varName: 'qualificationExamPaper', apiPath: 'qualification/qualificationExamPaper' },
  { dir: 'qualification', varName: 'qualificationExamQuestion', apiPath: 'qualification/qualificationExamQuestion' },
  { dir: 'qualification', varName: 'qualificationExamRecord', apiPath: 'qualification/qualificationExamRecord' },
  { dir: 'qualification', varName: 'qualificationPermissionAdjustment', apiPath: 'qualification/qualificationPermissionAdjustment' },
  { dir: 'qualification', varName: 'qualificationRiskMonitor', apiPath: 'qualification/qualificationRiskMonitor' },
  { dir: 'qualification', varName: 'qualificationUsageRecord', apiPath: 'qualification/qualificationUsageRecord' },
  { dir: 'qualification', varName: 'technicianQualificationCatalog', apiPath: 'qualification/technicianQualificationCatalog' },
  
  // radiation
  { dir: 'radiation', varName: 'radiationDoseAlert', apiPath: 'radiation/radiationDoseAlert' },
  { dir: 'radiation', varName: 'radiationDoseAlertRecord', apiPath: 'radiation/radiationDoseAlertRecord' },
  { dir: 'radiation', varName: 'radiationDoseMonitoring', apiPath: 'radiation/radiationDoseMonitoring' },
  { dir: 'radiation', varName: 'radiationDoseRecord', apiPath: 'radiation/radiationDoseRecord' },
  { dir: 'radiation', varName: 'radiationEquipmentInspection', apiPath: 'radiation/radiationEquipmentInspection' },
  { dir: 'radiation', varName: 'radiationHealthExam', apiPath: 'radiation/radiationHealthExam' },
  { dir: 'radiation', varName: 'radiationHealthExamPlan', apiPath: 'radiation/radiationHealthExamPlan' },
  { dir: 'radiation', varName: 'radiationHealthExamResult', apiPath: 'radiation/radiationHealthExamResult' },
  { dir: 'radiation', varName: 'radiationStaff', apiPath: 'radiation/radiationStaff' },
  { dir: 'radiation', varName: 'radiationTraining', apiPath: 'radiation/radiationTraining' },
  { dir: 'radiation', varName: 'radiationTrainingParticipant', apiPath: 'radiation/radiationTrainingParticipant' },
  { dir: 'radiation', varName: 'radiationTrainingPlan', apiPath: 'radiation/radiationTrainingPlan' },
  { dir: 'radiation', varName: 'radiationWorker', apiPath: 'radiation/radiationWorker' },
  
  // supervision  
  { dir: 'supervision', varName: 'supervisionExpertGroup', apiPath: 'supervision/supervisionExpertGroup' },
  { dir: 'supervision', varName: 'supervisionExpertMember', apiPath: 'supervision/supervisionExpertMember' },
  { dir: 'supervision', varName: 'supervisionForm', apiPath: 'supervision/supervisionForm' },
  { dir: 'supervision', varName: 'supervisionFormField', apiPath: 'supervision/supervisionFormField' },
  { dir: 'supervision', varName: 'supervisionIssue', apiPath: 'supervision/supervisionIssue' },
  { dir: 'supervision', varName: 'supervisionPlan', apiPath: 'supervision/supervisionPlan' },
  { dir: 'supervision', varName: 'supervisionPlanDept', apiPath: 'supervision/supervisionPlanDept' },
  { dir: 'supervision', varName: 'supervisionPlanForm', apiPath: 'supervision/supervisionPlanForm' },
  { dir: 'supervision', varName: 'supervisionProject', apiPath: 'supervision/supervisionProject' },
  { dir: 'supervision', varName: 'supervisionProjectIndicator', apiPath: 'supervision/supervisionProjectIndicator' },
  { dir: 'supervision', varName: 'supervisionRectificationProgress', apiPath: 'supervision/supervisionRectificationProgress' },
  { dir: 'supervision', varName: 'supervisionRectificationTask', apiPath: 'supervision/supervisionRectificationTask' },
  { dir: 'supervision', varName: 'supervisionResult', apiPath: 'supervision/supervisionResult' },
  { dir: 'supervision', varName: 'supervisionResultDetail', apiPath: 'supervision/supervisionResultDetail' },
  { dir: 'supervision', varName: 'supervisionReview', apiPath: 'supervision/supervisionReview' },
  
  // surgery
  { dir: 'surgery', varName: 'surgeryApprovalForm', apiPath: 'surgery/surgeryApprovalForm' },
  { dir: 'surgery', varName: 'surgeryCatalog', apiPath: 'surgery/surgeryCatalog' },
  { dir: 'surgery', varName: 'surgeryComplicationRecord', apiPath: 'surgery/surgeryComplicationRecord' },
  { dir: 'surgery', varName: 'surgeryRecord', apiPath: 'surgery/surgeryRecord' },
  { dir: 'surgery', varName: 'surgeryTeam', apiPath: 'surgery/surgeryTeam' },
  { dir: 'surgery', varName: 'surgeryVideo', apiPath: 'surgery/surgeryVideo' },
  { dir: 'surgery', varName: 'surgeryWorkloadStatistics', apiPath: 'surgery/surgeryWorkloadStatistics' },
  
  // natdss
  { dir: 'natdss', varName: 'natdssB011DrugPurchase', apiPath: 'natdss/natdssB011DrugPurchase' },
  { dir: 'natdss', varName: 'natdssB012DrugUse', apiPath: 'natdss/natdssB012DrugUse' },
  { dir: 'natdss', varName: 'natdssB021PatientInfo', apiPath: 'natdss/natdssB021PatientInfo' },
  { dir: 'natdss', varName: 'natdssB022AdrInfo', apiPath: 'natdss/natdssB022AdrInfo' },
  { dir: 'natdss', varName: 'natdssB023DiagInfo', apiPath: 'natdss/natdssB023DiagInfo' },
  { dir: 'natdss', varName: 'natdssB031InpatientInfo', apiPath: 'natdss/natdssB031InpatientInfo' },
  { dir: 'natdss', varName: 'natdssB051EmrAdmission', apiPath: 'natdss/natdssB051EmrAdmission' },
  { dir: 'natdss', varName: 'natdssB061EmrProgressNotes', apiPath: 'natdss/natdssB061EmrProgressNotes' },
  { dir: 'natdss', varName: 'natdssB071EmrDischarge', apiPath: 'natdss/natdssB071EmrDischarge' },
  { dir: 'natdss', varName: 'natdssB081InpatientSurgicalRecord', apiPath: 'natdss/natdssB081InpatientSurgicalRecord' },
  { dir: 'natdss', varName: 'natdssB091InpatientNursingRecord', apiPath: 'natdss/natdssB091InpatientNursingRecord' },
  { dir: 'natdss', varName: 'natdssB101InpatientOrder', apiPath: 'natdss/natdssB101InpatientOrder' },
  { dir: 'natdss', varName: 'natdssB111InpatientExpenseRecord', apiPath: 'natdss/natdssB111InpatientExpenseRecord' },
  { dir: 'natdss', varName: 'natdssB121OutpatientInfo', apiPath: 'natdss/natdssB121OutpatientInfo' },
  { dir: 'natdss', varName: 'natdssB131OutpatientDiagAndMedrecord', apiPath: 'natdss/natdssB131OutpatientDiagAndMedrecord' },
  { dir: 'natdss', varName: 'natdssB141OutpatientOrderAndPres', apiPath: 'natdss/natdssB141OutpatientOrderAndPres' },
  { dir: 'natdss', varName: 'natdssB151OutpatientExpenseRecord', apiPath: 'natdss/natdssB151OutpatientExpenseRecord' },
  { dir: 'natdss', varName: 'natdssB162PathologicalExamRecord', apiPath: 'natdss/natdssB162PathologicalExamRecord' },
  { dir: 'natdss', varName: 'natdssB163MolecularPathologyExamRecord', apiPath: 'natdss/natdssB163MolecularPathologyExamRecord' },
  { dir: 'natdss', varName: 'natdssB161ExamInfo', apiPath: 'natdss/natdssB161ExamInfo' },
  { dir: 'natdss', varName: 'natdssB172LabMicrobiologicalInfo', apiPath: 'natdss/natdssB172LabMicrobiologicalInfo' },
  { dir: 'natdss', varName: 'natdssB171LabInfo', apiPath: 'natdss/natdssB171LabInfo' },
  { dir: 'natdss', varName: 'natdssB181RadInfo', apiPath: 'natdss/natdssB181RadInfo' },
  { dir: 'natdss', varName: 'natdssB191FollowUp', apiPath: 'natdss/natdssB191FollowUp' }
];

interface FieldInfo {
  prop: string;
  label: string;
  type: string;
  required: boolean;
}

// 类型映射
function getTsTypeToFieldType(tsType: string): string {
  if (tsType.includes('number')) return 'number';
  if (tsType.includes('boolean')) return 'select';
  if (tsType.includes('Date') || tsType.toLowerCase().includes('time') || tsType.toLowerCase().includes('date')) return 'datetime';
  return 'input';
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

// 解析VO接口
function parseVOInterface(typesFilePath: string, interfaceName: string): FieldInfo[] {
  if (!fs.existsSync(typesFilePath)) {
    console.log(`⚠️  types文件不存在: ${typesFilePath}`);
    return [];
  }

  const sourceCode = fs.readFileSync(typesFilePath, 'utf-8');
  const sourceFile = ts.createSourceFile(
    typesFilePath,
    sourceCode,
    ts.ScriptTarget.Latest,
    true
  );

  const fields: FieldInfo[] = [];
  
  function visit(node: ts.Node) {
    if (ts.isInterfaceDeclaration(node) && node.name.text === interfaceName) {
      node.members.forEach(member => {
        if (ts.isPropertySignature(member) && member.name && ts.isIdentifier(member.name)) {
          const propName = member.name.text;
          
          // 跳过某些字段
          if (['id', 'delFlag', 'createTime', 'createBy', 'createDept', 'updateTime', 'updateBy'].includes(propName)) {
            return;
          }
          
          // 获取注释
          const jsDoc = (member as any).jsDoc;
          let label = propName;
          if (jsDoc && jsDoc[0] && jsDoc[0].comment) {
            label = jsDoc[0].comment.replace(/\n/g, '');
          }
          
          // 获取类型
          let tsType = 'string';
          if (member.type) {
            tsType = member.type.getText(sourceFile);
          }
          
          const fieldType = getTsTypeToFieldType(tsType);
          // 不自动设置required，让用户在实际使用时根据业务需求决定
          const required = false;
          
          fields.push({
            prop: propName,
            label,
            type: fieldType,
            required
          });
        }
      });
    }
    
    ts.forEachChild(node, visit);
  }
  
  visit(sourceFile);
  return fields;
}

// 生成FieldConfig
function generateFieldConfig(varName: string, fields: FieldInfo[]): string {
  const entityName = varName.charAt(0).toUpperCase() + varName.slice(1);
  
  // 按类型分组
  const basicFields = fields.filter(f => 
    ['code', 'name', 'title', 'no', 'type', 'level', 'status'].some(key => f.prop.toLowerCase().includes(key))
  ).slice(0, 8);
  
  const otherFields = fields.filter(f => !basicFields.includes(f));
  
  let result = `\n// ${fields[0]?.label ? varName : varName}字段配置\n`;
  result += `export function create${entityName}FieldConfig() {\n`;
  result += `  const fieldGroups: FieldGroup[] = [\n`;
  
  if (basicFields.length > 0) {
    result += `    {\n`;
    result += `      name: 'basic',\n`;
    result += `      label: '基础信息',\n`;
    result += `      fields: [\n`;
    basicFields.forEach((field, index) => {
      result += `        { prop: '${field.prop}', label: '${field.label}', visible: true, ${field.required ? 'required: true, ' : ''}type: '${field.type}', group: 'basic' }`;
      if (index < basicFields.length - 1) result += ',\n';
      else result += '\n';
    });
    result += `      ]\n`;
    result += `    }`;
    if (otherFields.length > 0) result += ',\n';
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
    result += `    },\n`;
  }
  
  // 系统字段
  result += `    {\n`;
  result += `      name: 'system',\n`;
  result += `      label: '系统字段',\n`;
  result += `      fields: [\n`;
  result += `        { prop: 'delFlag', label: '删除标志', visible: true, type: 'select', group: 'system' },\n`;
  result += `        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },\n`;
  result += `        { prop: 'createBy', label: '创建者', visible: true, type: 'input', group: 'system' },\n`;
  result += `        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },\n`;
  result += `        { prop: 'updateBy', label: '更新者', visible: true, type: 'input', group: 'system' }\n`;
  result += `      ]\n`;
  result += `    }\n`;
  result += `  ];\n\n`;
  result += `  return new FieldConfigManager('${varName}', fieldGroups);\n`;
  result += `}\n`;
  
  return result;
}

// 生成SearchConfig
function generateSearchConfig(varName: string, fields: FieldInfo[]): string {
  const entityName = varName.charAt(0).toUpperCase() + varName.slice(1);
  
  let result = `\n// ${varName}搜索配置\n`;
  result += `export function create${entityName}SearchConfig() {\n`;
  result += `  const searchFieldGroups: SearchFieldGroup[] = [\n`;
  result += `    {\n`;
  result += `      name: 'search',\n`;
  result += `      label: '搜索条件',\n`;
  result += `      fields: [\n`;
  
  fields.forEach((field, index) => {
    const searchType = getSearchType(field.type);
    let fieldDef = `        { prop: '${field.prop}', label: '${field.label}', type: '${searchType}', visible: false, placeholder: '请输入${field.label}'`;
    
    if (searchType === 'daterange') {
      fieldDef += `, startProp: '${field.prop}Start', endProp: '${field.prop}End'`;
    }
    
    fieldDef += ' }';
    if (index < fields.length - 1) fieldDef += ',\n';
    else fieldDef += '\n';
    
    result += fieldDef;
  });
  
  result += `      ]\n`;
  result += `    }\n`;
  result += `  ];\n\n`;
  result += `  return new SearchConfigManager('${varName}', searchFieldGroups);\n`;
  result += `}\n`;
  
  return result;
}

// 处理每个模块
function processModule(module: typeof modules[0]) {
  const { dir, varName, apiPath } = module;
  
  const typesFilePath = path.join(process.cwd(), 'src', 'api', ...apiPath.split('/'), 'types.ts');
  
  // 优先使用Form接口，如果没有则使用VO接口
  const formInterfaceName = varName.charAt(0).toUpperCase() + varName.slice(1) + 'Form';
  const voInterfaceName = varName.charAt(0).toUpperCase() + varName.slice(1) + 'VO';
  
  console.log(`处理: ${varName}`);
  
  let fields = parseVOInterface(typesFilePath, formInterfaceName);
  let interfaceName = formInterfaceName;
  
  if (fields.length === 0) {
    console.log(`  未找到 ${formInterfaceName}，尝试 ${voInterfaceName}`);
    fields = parseVOInterface(typesFilePath, voInterfaceName);
    interfaceName = voInterfaceName;
  }
  
  if (fields.length === 0) {
    console.log(`  ⚠️  未找到字段定义`);
    return { dir, fieldConfig: '', searchConfig: '' };
  }
  
  console.log(`  ✓ 使用 ${interfaceName}，找到 ${fields.length} 个字段`);
  
  const fieldConfig = generateFieldConfig(varName, fields);
  const searchConfig = generateSearchConfig(varName, fields);
  
  return { dir, fieldConfig, searchConfig };
}

// 主函数
function main() {
  console.log('🚀 从API types生成配置...\n');
  
  const configsByDir: Record<string, { fieldConfigs: string[], searchConfigs: string[] }> = {};
  
  modules.forEach(module => {
    const { dir, fieldConfig, searchConfig } = processModule(module);
    
    if (!configsByDir[dir]) {
      configsByDir[dir] = { fieldConfigs: [], searchConfigs: [] };
    }
    
    if (fieldConfig) configsByDir[dir].fieldConfigs.push(fieldConfig);
    if (searchConfig) configsByDir[dir].searchConfigs.push(searchConfig);
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
  
  console.log('\n✨ 生成完成！所有配置都基于实际的API types定义');
}

main();
