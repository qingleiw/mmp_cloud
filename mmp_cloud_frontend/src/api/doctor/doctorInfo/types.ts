import type { BaseEntity, PageQuery } from '@/types/global';
import type { QualificationAuthorizationRecordVO } from '@/api/doctor/qualificationAuthorizationRecord/types';
import type { DoctorBasicInfoVO } from '@/api/doctor/doctorBasicInfo/types';
import type { DoctorCertificateVO } from '@/api/doctor/doctorCertificate/types';
import type { DoctorTrainingVO } from '@/api/doctor/doctorTraining/types';
import type { DoctorWorkExperienceVO } from '@/api/doctor/doctorWorkExperience/types';
import type { DoctorEducationVO } from '@/api/doctor/doctorEducation/types';
import type { DoctorHonorVO } from '@/api/doctor/doctorHonor/types';
import type { DoctorAcademicPositionVO } from '@/api/doctor/doctorAcademicPosition/types';
import type { DoctorResearchProjectVO } from '@/api/doctor/doctorResearchProject/types';
import type { DoctorPublicationVO } from '@/api/doctor/doctorPublication/types';
import type { DoctorAbilityAssessmentVO } from '@/api/doctor/doctorAbilityAssessment/types';
import type { DoctorEthicsEvaluationVO } from '@/api/doctor/doctorEthicsEvaluation/types';
import type { DoctorElectronicRegistrationVO } from '@/api/doctor/doctorElectronicRegistration/types';
import type { DoctorInsuranceCodeVO } from '@/api/doctor/doctorInsuranceCode/types';
import type { DoctorProfessionalRatingVO } from '@/api/doctor/doctorProfessionalRating/types';
import type { DoctorAdverseRecordVO } from '@/api/doctor/doctorAdverseRecord/types';

export interface DoctorInfoForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生工号
   */
  doctorCode?: string;

  /**
   * 医生姓名
   */
  doctorName?: string;

  /**
   * 性别 1-男 2-女
   */
  gender?: number;

  /**
   * 出生日期
   */
  birthDate?: string;

  /**
   * 身份证号
   */
  idCard?: string | number;

  /**
   * 联系电话
   */
  phone?: string;

  /**
   * 电子邮箱
   */
  email?: string;

  /**
   * 照片URL
   */
  photoUrl?: string;

  /**
   * 科室ID
   */
  deptId?: string | number;

  /**
   * 科室名称
   */
  departmentName?: string;

  /**
   * 职称
   */
  title?: string;

  /**
   * 职称级别 1-初级 2-中级 3-副高 4-正高
   */
  titleLevel?: number;

  /**
   * 状态 1-在职 2-离职 3-退休
   */
  status?: number;

  /**
   * 入职日期
   */
  entryDate?: string;

  /**
   * 是否删除 0-否 1-是
   */
  delFlag?: string;
}

export interface DoctorInfoQuery extends PageQuery {
  /**
   * 医生工号
   */
  doctorCode?: string;

  /**
   * 医生姓名
   */
  doctorName?: string;

  /**
   * 性别 1-男 2-女
   */
  gender?: number;

  /**
   * 出生日期
   */
  birthDate?: string;

  /**
   * 身份证号
   */
  idCard?: string | number;

  /**
   * 联系电话
   */
  phone?: string;

  /**
   * 电子邮箱
   */
  email?: string;

  /**
   * 照片URL
   */
  photoUrl?: string;

  /**
   * 科室ID
   */
  deptId?: string | number;

  /**
   * 科室名称
   */
  departmentName?: string;

  /**
   * 职称
   */
  title?: string;

  /**
   * 职称级别 1-初级 2-中级 3-副高 4-正高
   */
  titleLevel?: number;

  /**
   * 状态 1-在职 2-离职 3-退休
   */
  status?: number;

  /**
   * 入职日期
   */
  entryDate?: string;

  /**
   * 是否删除 0-否 1-是
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}

/**
 * 医师信息 - 继承基础信息并包含所有相关数据
 */
export interface DoctorInfoVO extends DoctorBasicInfoVO {
  /**
   * 资质证书
   */
  certificates: DoctorCertificateVO[];

  /**
   * 培训经历
   */
  trainings: DoctorTrainingVO[];

  /**
   * 继续教育
   */
  continuingEducations: DoctorTrainingVO[];

  /**
   * 工作经历
   */
  workExperiences: DoctorWorkExperienceVO[];

  /**
   * 教育经历
   */
  educations: DoctorEducationVO[];

  /**
   * 获得荣誉
   */
  honors: DoctorHonorVO[];

  /**
   * 学术任职
   */
  academicPositions: DoctorAcademicPositionVO[];

  /**
   * 科研项目
   */
  researchProjects: DoctorResearchProjectVO[];

  /**
   * 论文论著
   */
  publications: DoctorPublicationVO[];

  /**
   * 医师能力评估
   */
  abilityAssessments: DoctorAbilityAssessmentVO[];

  /**
   * 医德医风考评
   */
  ethicsEvaluations: DoctorEthicsEvaluationVO[];

  /**
   * 电子化注册信息
   */
  electronicRegistrations: DoctorElectronicRegistrationVO[];

  /**
   * 医保医师码信息
   */
  insuranceCodes: DoctorInsuranceCodeVO[];

  /**
   * 职称评定
   */
  professionalRatings: DoctorProfessionalRatingVO[];

  /**
   * 不良行为记录
   */
  adverseRecords: DoctorAdverseRecordVO[];

  /**
   * 资质授权记录
   */
  qualificationAuthorizationRecords: QualificationAuthorizationRecordVO[];
}
