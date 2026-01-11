package org.dromara.cdi.mmp.doctor.service.impl;

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
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorBasicInfoBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorBasicInfoVo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorInfoVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorBasicInfo;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorBasicInfoMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorBasicInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 医师基本信息Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorBasicInfoServiceImpl implements IMmpDoctorBasicInfoService {

    private final MmpDoctorBasicInfoMapper baseMapper;

    /**
     * 查询医师基本信息
     *
     * @param id 主键
     * @return 医师基本信息
     */
    @Override
    public MmpDoctorBasicInfoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询医师基本信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医师基本信息分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorBasicInfoVo> queryPageList(MmpDoctorBasicInfoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorBasicInfo> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorBasicInfoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的医师基本信息列表
     *
     * @param bo 查询条件
     * @return 医师基本信息列表
     */
    @Override
    public List<MmpDoctorBasicInfoVo> queryList(MmpDoctorBasicInfoBo bo) {
        LambdaQueryWrapper<MmpDoctorBasicInfo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpDoctorBasicInfo> buildQueryWrapper(MmpDoctorBasicInfoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorBasicInfo> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorBasicInfo::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getDoctorCode()), MmpDoctorBasicInfo::getDoctorCode, bo.getDoctorCode());
        lqw.like(StringUtils.isNotBlank(bo.getDoctorName()), MmpDoctorBasicInfo::getDoctorName, bo.getDoctorName());
        lqw.eq(bo.getGender() != null, MmpDoctorBasicInfo::getGender, bo.getGender());
        lqw.eq(bo.getBirthDate() != null, MmpDoctorBasicInfo::getBirthDate, bo.getBirthDate());
        lqw.eq(StringUtils.isNotBlank(bo.getIdCard()), MmpDoctorBasicInfo::getIdCard, bo.getIdCard());
        lqw.eq(StringUtils.isNotBlank(bo.getPhone()), MmpDoctorBasicInfo::getPhone, bo.getPhone());
        lqw.eq(StringUtils.isNotBlank(bo.getEmail()), MmpDoctorBasicInfo::getEmail, bo.getEmail());
        lqw.eq(StringUtils.isNotBlank(bo.getPhotoUrl()), MmpDoctorBasicInfo::getPhotoUrl, bo.getPhotoUrl());
        lqw.eq(bo.getDeptId() != null, MmpDoctorBasicInfo::getDeptId, bo.getDeptId());
        lqw.like(StringUtils.isNotBlank(bo.getDepartmentName()), MmpDoctorBasicInfo::getDepartmentName, bo.getDepartmentName());
        lqw.eq(StringUtils.isNotBlank(bo.getTitle()), MmpDoctorBasicInfo::getTitle, bo.getTitle());
        lqw.eq(bo.getTitleLevel() != null, MmpDoctorBasicInfo::getTitleLevel, bo.getTitleLevel());
        lqw.eq(bo.getStatus() != null, MmpDoctorBasicInfo::getStatus, bo.getStatus());
        lqw.eq(bo.getEntryDate() != null, MmpDoctorBasicInfo::getEntryDate, bo.getEntryDate());
        lqw.eq(bo.getDelFlag() != null, MmpDoctorBasicInfo::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增医师基本信息
     *
     * @param bo 医师基本信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorBasicInfoBo bo) {
        MmpDoctorBasicInfo add = MapstructUtils.convert(bo, MmpDoctorBasicInfo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改医师基本信息
     *
     * @param bo 医师基本信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorBasicInfoBo bo) {
        MmpDoctorBasicInfo update = MapstructUtils.convert(bo, MmpDoctorBasicInfo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorBasicInfo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除医师基本信息信息
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
        archive.setBasicInfo(queryById(doctorId));
        // TODO: 集成其他模块的数据
        // archive.setCertificates(certificateService.queryList(new MmpDoctorCertificateBo().setDoctorId(doctorId)));
        // 暂时设置为空
        archive.setCertificates(null);
        archive.setTrainings(null);
        archive.setContinuingEducations(null);
        archive.setWorkExperiences(null);
        archive.setEducations(null);
        archive.setHonors(null);
        archive.setAcademicPositions(null);
        archive.setResearchProjects(null);
        archive.setPublications(null);
        archive.setAbilityAssessments(null);
        archive.setEthicsEvaluations(null);
        archive.setElectronicRegistrations(null);
        archive.setInsuranceCodes(null);
        archive.setProfessionalRatings(null);
        archive.setAdverseRecords(null);
        // archive.setQualificationAuthorizationRecords(null);
        return archive;
    }
}
