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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorBasicInfoVo;
import org.springframework.stereotype.Service;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorCertificateBo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorBasicInfoBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorCertificateVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorCertificate;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorCertificateMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorCertificateService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorBasicInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 资质证书Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorCertificateServiceImpl implements IMmpDoctorCertificateService {

    private final MmpDoctorCertificateMapper baseMapper;

    private final IMmpDoctorBasicInfoService doctorInfoService;

    /**
     * 查询资质证书
     *
     * @param id 主键
     * @return 资质证书
     */
    @Override
    public MmpDoctorCertificateVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询资质证书列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质证书分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorCertificateVo> queryPageList(MmpDoctorCertificateBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorCertificate> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorCertificateVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        // 填充医生姓名
        fillDoctorNames(result.getRecords());
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的资质证书列表
     *
     * @param bo 查询条件
     * @return 资质证书列表
     */
    @Override
    public List<MmpDoctorCertificateVo> queryList(MmpDoctorCertificateBo bo) {
        LambdaQueryWrapper<MmpDoctorCertificate> lqw = buildQueryWrapper(bo);
        List<MmpDoctorCertificateVo> result = baseMapper.selectVoList(lqw);
        // 填充医生姓名
        fillDoctorNames(result);
        return result;
    }

    private LambdaQueryWrapper<MmpDoctorCertificate> buildQueryWrapper(MmpDoctorCertificateBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorCertificate> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorCertificate::getId);
        lqw.eq(bo.getDoctorId() != null, MmpDoctorCertificate::getDoctorId, bo.getDoctorId());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateType()), MmpDoctorCertificate::getCertificateType, bo.getCertificateType());
        lqw.like(StringUtils.isNotBlank(bo.getCertificateName()), MmpDoctorCertificate::getCertificateName, bo.getCertificateName());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateNo()), MmpDoctorCertificate::getCertificateNo, bo.getCertificateNo());
        lqw.eq(StringUtils.isNotBlank(bo.getIssueUnit()), MmpDoctorCertificate::getIssueUnit, bo.getIssueUnit());
        lqw.eq(bo.getIssueDate() != null, MmpDoctorCertificate::getIssueDate, bo.getIssueDate());
        lqw.eq(bo.getValidDate() != null, MmpDoctorCertificate::getValidDate, bo.getValidDate());
        lqw.eq(bo.getIsPermanent() != null, MmpDoctorCertificate::getIsPermanent, bo.getIsPermanent());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateUrl()), MmpDoctorCertificate::getCertificateUrl, bo.getCertificateUrl());
        lqw.eq(bo.getStatus() != null, MmpDoctorCertificate::getStatus, bo.getStatus());
        lqw.eq(bo.getRemindDays() != null, MmpDoctorCertificate::getRemindDays, bo.getRemindDays());
        lqw.eq(bo.getDelFlag() != null, MmpDoctorCertificate::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增资质证书
     *
     * @param bo 资质证书
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorCertificateBo bo) {
        MmpDoctorCertificate add = MapstructUtils.convert(bo, MmpDoctorCertificate.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改资质证书
     *
     * @param bo 资质证书
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorCertificateBo bo) {
        MmpDoctorCertificate update = MapstructUtils.convert(bo, MmpDoctorCertificate.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorCertificate entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除资质证书信息
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
     * 填充医生姓名
     *
     * @param certificateList 证书列表
     */
    private void fillDoctorNames(List<MmpDoctorCertificateVo> certificateList) {
        if (certificateList == null || certificateList.isEmpty()) {
            return;
        }

        // 获取所有医生ID
        List<Long> doctorIds = certificateList.stream()
            .map(MmpDoctorCertificateVo::getDoctorId)
            .distinct()
            .toList();

        // 批量查询医生信息
        Map<Long, String> doctorNameMap = doctorInfoService.queryList(new MmpDoctorBasicInfoBo())
            .stream()
            .filter(doctor -> doctorIds.contains(doctor.getId()))
            .collect(java.util.stream.Collectors.toMap(
                MmpDoctorBasicInfoVo::getId,
                MmpDoctorBasicInfoVo::getDoctorName
            ));

        // 填充医生姓名
        certificateList.forEach(certificate -> {
            String doctorName = doctorNameMap.get(certificate.getDoctorId());
            certificate.setDoctorName(doctorName != null ? doctorName : "");
        });
    }
}
