package org.dromara.cdi.mmp.doctor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorInfoVo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorInfoService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorBasicInfoService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorCertificateService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorTrainingService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorWorkExperienceService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorEducationService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorHonorService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorAcademicPositionService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorResearchProjectService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorPublicationService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorAbilityAssessmentService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorEthicsEvaluationService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorElectronicRegistrationService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorInsuranceCodeService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorProfessionalRatingService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorAdverseRecordService;
// import  org.dromara.cdi.mmp.doctor.service.IMmpQualificationAuthorizationRecordService;

/**
 * 医师信息Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-05
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorInfoServiceImpl implements IMmpDoctorInfoService {

    private final IMmpDoctorBasicInfoService basicInfoService;
    private final IMmpDoctorCertificateService certificateService;
    private final IMmpDoctorTrainingService trainingService;
    private final IMmpDoctorWorkExperienceService workExperienceService;
    private final IMmpDoctorEducationService educationService;
    private final IMmpDoctorHonorService honorService;
    private final IMmpDoctorAcademicPositionService academicPositionService;
    private final IMmpDoctorResearchProjectService researchProjectService;
    private final IMmpDoctorPublicationService publicationService;
    private final IMmpDoctorAbilityAssessmentService abilityAssessmentService;
    private final IMmpDoctorEthicsEvaluationService ethicsEvaluationService;
    private final IMmpDoctorElectronicRegistrationService electronicRegistrationService;
    private final IMmpDoctorInsuranceCodeService insuranceCodeService;
    private final IMmpDoctorProfessionalRatingService professionalRatingService;
    private final IMmpDoctorAdverseRecordService adverseRecordService;
    // private final IMmpQualificationAuthorizationRecordService qualificationAuthorizationRecordService;

    /**
     * 获取医师档案信息
     *
     * @param doctorId 医师ID
     * @return 医师档案信息
     */
    @Override
    public MmpDoctorInfoVo getDoctorArchive(Long doctorId) {
        MmpDoctorInfoVo archive = new MmpDoctorInfoVo();
        // 获取基本信息
        archive.setBasicInfo(basicInfoService.queryById(doctorId));
        // 获取证书信息
        archive.setCertificates(certificateService.queryList(null).stream()
            .filter(cert -> cert.getDoctorId().equals(doctorId)).toList());
        // 获取培训信息
        archive.setTrainings(trainingService.queryList(null).stream()
            .filter(training -> training.getDoctorId().equals(doctorId)).toList());
        // 获取工作经验
        archive.setWorkExperiences(workExperienceService.queryList(null).stream()
            .filter(exp -> exp.getDoctorId().equals(doctorId)).toList());
        // 获取教育信息
        archive.setEducations(educationService.queryList(null).stream()
            .filter(edu -> edu.getDoctorId().equals(doctorId)).toList());
        // 获取荣誉信息
        archive.setHonors(honorService.queryList(null).stream()
            .filter(honor -> honor.getDoctorId().equals(doctorId)).toList());
        // 获取学术职位
        archive.setAcademicPositions(academicPositionService.queryList(null).stream()
            .filter(pos -> pos.getDoctorId().equals(doctorId)).toList());
        // 获取科研项目
        archive.setResearchProjects(researchProjectService.queryList(null).stream()
            .filter(proj -> proj.getDoctorId().equals(doctorId)).toList());
        // 获取发表作品
        archive.setPublications(publicationService.queryList(null).stream()
            .filter(pub -> pub.getDoctorId().equals(doctorId)).toList());
        // 获取能力评估
        archive.setAbilityAssessments(abilityAssessmentService.queryList(null).stream()
            .filter(assess -> assess.getDoctorId().equals(doctorId)).toList());
        // 获取伦理评价
        archive.setEthicsEvaluations(ethicsEvaluationService.queryList(null).stream()
            .filter(eval -> eval.getDoctorId().equals(doctorId)).toList());
        // 获取电子注册
        archive.setElectronicRegistrations(electronicRegistrationService.queryList(null).stream()
            .filter(reg -> reg.getDoctorId().equals(doctorId)).toList());
        // 获取保险代码
        archive.setInsuranceCodes(insuranceCodeService.queryList(null).stream()
            .filter(code -> code.getDoctorId().equals(doctorId)).toList());
        // 获取职称评定
        archive.setProfessionalRatings(professionalRatingService.queryList(null).stream()
            .filter(rating -> rating.getDoctorId().equals(doctorId)).toList());
        // 获取不良记录
        archive.setAdverseRecords(adverseRecordService.queryList(null).stream()
            .filter(record -> record.getDoctorId().equals(doctorId)).toList());
        // 获取资质授权记录
        // archive.setQualificationAuthorizationRecords(qualificationAuthorizationRecordService.queryList(null).stream()
        //     .filter(record -> record.getStaffId().equals(doctorId)).toList());
        return archive;
    }
}
