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
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorElectronicRegistrationBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorElectronicRegistrationVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorElectronicRegistration;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorElectronicRegistrationMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorElectronicRegistrationService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 医师电子化注册Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorElectronicRegistrationServiceImpl implements IMmpDoctorElectronicRegistrationService {

    private final MmpDoctorElectronicRegistrationMapper baseMapper;

    /**
     * 查询医师电子化注册
     *
     * @param id 主键
     * @return 医师电子化注册
     */
    @Override
    public MmpDoctorElectronicRegistrationVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询医师电子化注册列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医师电子化注册分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorElectronicRegistrationVo> queryPageList(MmpDoctorElectronicRegistrationBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorElectronicRegistration> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorElectronicRegistrationVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的医师电子化注册列表
     *
     * @param bo 查询条件
     * @return 医师电子化注册列表
     */
    @Override
    public List<MmpDoctorElectronicRegistrationVo> queryList(MmpDoctorElectronicRegistrationBo bo) {
        LambdaQueryWrapper<MmpDoctorElectronicRegistration> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpDoctorElectronicRegistration> buildQueryWrapper(MmpDoctorElectronicRegistrationBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorElectronicRegistration> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorElectronicRegistration::getId);
        lqw.eq(bo.getDoctorId() != null, MmpDoctorElectronicRegistration::getDoctorId, bo.getDoctorId());
        lqw.eq(StringUtils.isNotBlank(bo.getRegistrationNo()), MmpDoctorElectronicRegistration::getRegistrationNo, bo.getRegistrationNo());
        lqw.eq(StringUtils.isNotBlank(bo.getRegistrationType()), MmpDoctorElectronicRegistration::getRegistrationType, bo.getRegistrationType());
        lqw.eq(StringUtils.isNotBlank(bo.getPracticeCategory()), MmpDoctorElectronicRegistration::getPracticeCategory, bo.getPracticeCategory());
        lqw.eq(StringUtils.isNotBlank(bo.getPracticeScope()), MmpDoctorElectronicRegistration::getPracticeScope, bo.getPracticeScope());
        lqw.eq(StringUtils.isNotBlank(bo.getPracticeLocation()), MmpDoctorElectronicRegistration::getPracticeLocation, bo.getPracticeLocation());
        lqw.eq(bo.getIssueDate() != null, MmpDoctorElectronicRegistration::getIssueDate, bo.getIssueDate());
        lqw.eq(bo.getValidDate() != null, MmpDoctorElectronicRegistration::getValidDate, bo.getValidDate());
        lqw.eq(StringUtils.isNotBlank(bo.getRegistrationAuthority()), MmpDoctorElectronicRegistration::getRegistrationAuthority, bo.getRegistrationAuthority());
        lqw.eq(StringUtils.isNotBlank(bo.getRegistrationStatus()), MmpDoctorElectronicRegistration::getRegistrationStatus, bo.getRegistrationStatus());
        lqw.eq(bo.getMultiInstitutionFlag() != null, MmpDoctorElectronicRegistration::getMultiInstitutionFlag, bo.getMultiInstitutionFlag());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateUrl()), MmpDoctorElectronicRegistration::getCertificateUrl, bo.getCertificateUrl());
        lqw.eq(bo.getDelFlag() != null, MmpDoctorElectronicRegistration::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增医师电子化注册
     *
     * @param bo 医师电子化注册
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorElectronicRegistrationBo bo) {
        MmpDoctorElectronicRegistration add = MapstructUtils.convert(bo, MmpDoctorElectronicRegistration.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改医师电子化注册
     *
     * @param bo 医师电子化注册
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorElectronicRegistrationBo bo) {
        MmpDoctorElectronicRegistration update = MapstructUtils.convert(bo, MmpDoctorElectronicRegistration.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorElectronicRegistration entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除医师电子化注册信息
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
