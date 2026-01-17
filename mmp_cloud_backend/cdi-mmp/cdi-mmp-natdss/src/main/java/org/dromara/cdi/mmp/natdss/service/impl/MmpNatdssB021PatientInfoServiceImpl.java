package org.dromara.cdi.mmp.natdss.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB021PatientInfoBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB021PatientInfoVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB021PatientInfo;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB021PatientInfoMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB021PatientInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B02-1 患者就诊基本信息Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB021PatientInfoServiceImpl implements IMmpNatdssB021PatientInfoService {

    private final MmpNatdssB021PatientInfoMapper baseMapper;

    /**
     * 查询B02-1 患者就诊基本信息
     *
     * @param id 主键
     * @return B02-1 患者就诊基本信息
     */
    @Override
    public MmpNatdssB021PatientInfoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B02-1 患者就诊基本信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B02-1 患者就诊基本信息分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB021PatientInfoVo> queryPageList(MmpNatdssB021PatientInfoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB021PatientInfo> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB021PatientInfoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B02-1 患者就诊基本信息列表
     *
     * @param bo 查询条件
     * @return B02-1 患者就诊基本信息列表
     */
    @Override
    public List<MmpNatdssB021PatientInfoVo> queryList(MmpNatdssB021PatientInfoBo bo) {
        LambdaQueryWrapper<MmpNatdssB021PatientInfo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB021PatientInfo> buildQueryWrapper(MmpNatdssB021PatientInfoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB021PatientInfo> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB021PatientInfo::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB021PatientInfo::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB021PatientInfo::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB021PatientInfo::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB021PatientInfo::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB021PatientInfo::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB021PatientInfo::getVisitTimes, bo.getVisitTimes());
        lqw.eq(bo.getVisitDatetime() != null, MmpNatdssB021PatientInfo::getVisitDatetime, bo.getVisitDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB021PatientInfo::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB021PatientInfo::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB021PatientInfo::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.eq(bo.getAdmissionDatetime() != null, MmpNatdssB021PatientInfo::getAdmissionDatetime, bo.getAdmissionDatetime());
        lqw.eq(bo.getDischargeDatetime() != null, MmpNatdssB021PatientInfo::getDischargeDatetime, bo.getDischargeDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitDoctorNo()), MmpNatdssB021PatientInfo::getVisitDoctorNo, bo.getVisitDoctorNo());
        lqw.like(StringUtils.isNotBlank(bo.getName()), MmpNatdssB021PatientInfo::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getGender()), MmpNatdssB021PatientInfo::getGender, bo.getGender());
        lqw.eq(bo.getDateOfBirth() != null, MmpNatdssB021PatientInfo::getDateOfBirth, bo.getDateOfBirth());
        lqw.eq(StringUtils.isNotBlank(bo.getOccupationCode()), MmpNatdssB021PatientInfo::getOccupationCode, bo.getOccupationCode());
        lqw.like(StringUtils.isNotBlank(bo.getOccupationName()), MmpNatdssB021PatientInfo::getOccupationName, bo.getOccupationName());
        lqw.eq(StringUtils.isNotBlank(bo.getNationality()), MmpNatdssB021PatientInfo::getNationality, bo.getNationality());
        lqw.eq(StringUtils.isNotBlank(bo.getEthnicity()), MmpNatdssB021PatientInfo::getEthnicity, bo.getEthnicity());
        lqw.eq(StringUtils.isNotBlank(bo.getEducation()), MmpNatdssB021PatientInfo::getEducation, bo.getEducation());
        lqw.eq(StringUtils.isNotBlank(bo.getMaritalStatus()), MmpNatdssB021PatientInfo::getMaritalStatus, bo.getMaritalStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getNewbronMark()), MmpNatdssB021PatientInfo::getNewbronMark, bo.getNewbronMark());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateType()), MmpNatdssB021PatientInfo::getCertificateType, bo.getCertificateType());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateNo()), MmpNatdssB021PatientInfo::getCertificateNo, bo.getCertificateNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHealthCardType()), MmpNatdssB021PatientInfo::getHealthCardType, bo.getHealthCardType());
        lqw.eq(StringUtils.isNotBlank(bo.getHealthCardNo()), MmpNatdssB021PatientInfo::getHealthCardNo, bo.getHealthCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInsuranceType()), MmpNatdssB021PatientInfo::getInsuranceType, bo.getInsuranceType());
        lqw.eq(StringUtils.isNotBlank(bo.getInsuranceNo()), MmpNatdssB021PatientInfo::getInsuranceNo, bo.getInsuranceNo());
        lqw.eq(StringUtils.isNotBlank(bo.getResidenceProvince()), MmpNatdssB021PatientInfo::getResidenceProvince, bo.getResidenceProvince());
        lqw.eq(StringUtils.isNotBlank(bo.getResidenceCity()), MmpNatdssB021PatientInfo::getResidenceCity, bo.getResidenceCity());
        lqw.eq(StringUtils.isNotBlank(bo.getResidenceCounty()), MmpNatdssB021PatientInfo::getResidenceCounty, bo.getResidenceCounty());
        lqw.eq(StringUtils.isNotBlank(bo.getCurrentAddress()), MmpNatdssB021PatientInfo::getCurrentAddress, bo.getCurrentAddress());
        lqw.eq(StringUtils.isNotBlank(bo.getPhoneNo()), MmpNatdssB021PatientInfo::getPhoneNo, bo.getPhoneNo());
        lqw.eq(StringUtils.isNotBlank(bo.getPhoneNo2()), MmpNatdssB021PatientInfo::getPhoneNo2, bo.getPhoneNo2());
        lqw.eq(StringUtils.isNotBlank(bo.getEmail()), MmpNatdssB021PatientInfo::getEmail, bo.getEmail());
        lqw.eq(StringUtils.isNotBlank(bo.getWeixin()), MmpNatdssB021PatientInfo::getWeixin, bo.getWeixin());
        lqw.eq(StringUtils.isNotBlank(bo.getContactPerson1()), MmpNatdssB021PatientInfo::getContactPerson1, bo.getContactPerson1());
        lqw.eq(StringUtils.isNotBlank(bo.getContactPhoneNo1()), MmpNatdssB021PatientInfo::getContactPhoneNo1, bo.getContactPhoneNo1());
        lqw.eq(StringUtils.isNotBlank(bo.getContactPerson2()), MmpNatdssB021PatientInfo::getContactPerson2, bo.getContactPerson2());
        lqw.eq(StringUtils.isNotBlank(bo.getContactPhoneNo2()), MmpNatdssB021PatientInfo::getContactPhoneNo2, bo.getContactPhoneNo2());
        lqw.eq(StringUtils.isNotBlank(bo.getAboBloodType()), MmpNatdssB021PatientInfo::getAboBloodType, bo.getAboBloodType());
        lqw.eq(StringUtils.isNotBlank(bo.getRhBloodType()), MmpNatdssB021PatientInfo::getRhBloodType, bo.getRhBloodType());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB021PatientInfo::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB021PatientInfo::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB021PatientInfo::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB021PatientInfo::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB021PatientInfo::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B02-1 患者就诊基本信息
     *
     * @param bo B02-1 患者就诊基本信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB021PatientInfoBo bo) {
        MmpNatdssB021PatientInfo add = MapstructUtils.convert(bo, MmpNatdssB021PatientInfo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B02-1 患者就诊基本信息
     *
     * @param bo B02-1 患者就诊基本信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB021PatientInfoBo bo) {
        MmpNatdssB021PatientInfo update = MapstructUtils.convert(bo, MmpNatdssB021PatientInfo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB021PatientInfo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B02-1 患者就诊基本信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
