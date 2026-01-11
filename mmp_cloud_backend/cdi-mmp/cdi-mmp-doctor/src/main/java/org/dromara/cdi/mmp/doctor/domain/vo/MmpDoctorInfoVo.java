package org.dromara.cdi.mmp.doctor.domain.vo;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * 医师信息VO
 *
 * @author Lion Li
 * @date 2026-01-05
 */
@Data
public class MmpDoctorInfoVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 基本信息 */
    private MmpDoctorBasicInfoVo basicInfo;

    /** 资质证书 */
    private List<MmpDoctorCertificateVo> certificates;

    /** 培训经历 */
    private List<MmpDoctorTrainingVo> trainings;

    /** 继续教育 */
    private List<MmpDoctorTrainingVo> continuingEducations;

    /** 工作经历 */
    private List<MmpDoctorWorkExperienceVo> workExperiences;

    /** 教育经历 */
    private List<MmpDoctorEducationVo> educations;

    /** 获得荣誉 */
    private List<MmpDoctorHonorVo> honors;

    /** 学术任职 */
    private List<MmpDoctorAcademicPositionVo> academicPositions;

    /** 科研项目 */
    private List<MmpDoctorResearchProjectVo> researchProjects;

    /** 论文论著 */
    private List<MmpDoctorPublicationVo> publications;

    /** 医师能力评估 */
    private List<MmpDoctorAbilityAssessmentVo> abilityAssessments;

    /** 医德医风考评 */
    private List<MmpDoctorEthicsEvaluationVo> ethicsEvaluations;

    /** 电子化注册信息 */
    private List<MmpDoctorElectronicRegistrationVo> electronicRegistrations;

    /** 医保医师码信息 */
    private List<MmpDoctorInsuranceCodeVo> insuranceCodes;

    /** 职称评定 */
    private List<MmpDoctorProfessionalRatingVo> professionalRatings;

    /** 不良行为记录 */
    private List<MmpDoctorAdverseRecordVo> adverseRecords;

    // /** 资质授权记录 */
    // private List<MmpQualificationAuthorizationRecordVo> qualificationAuthorizationRecords;

}
