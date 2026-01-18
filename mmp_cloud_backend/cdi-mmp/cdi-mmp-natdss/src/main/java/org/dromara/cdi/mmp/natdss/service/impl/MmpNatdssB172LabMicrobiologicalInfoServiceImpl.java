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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB172LabMicrobiologicalInfoBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB172LabMicrobiologicalInfoVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB172LabMicrobiologicalInfo;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB172LabMicrobiologicalInfoMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB172LabMicrobiologicalInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B172 微生物检验记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB172LabMicrobiologicalInfoServiceImpl implements IMmpNatdssB172LabMicrobiologicalInfoService {

    private final MmpNatdssB172LabMicrobiologicalInfoMapper baseMapper;

    /**
     * 查询B172 微生物检验记录
     *
     * @param id 主键
     * @return B172 微生物检验记录
     */
    @Override
    public MmpNatdssB172LabMicrobiologicalInfoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B172 微生物检验记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B172 微生物检验记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB172LabMicrobiologicalInfoVo> queryPageList(MmpNatdssB172LabMicrobiologicalInfoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB172LabMicrobiologicalInfo> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB172LabMicrobiologicalInfoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B172 微生物检验记录列表
     *
     * @param bo 查询条件
     * @return B172 微生物检验记录列表
     */
    @Override
    public List<MmpNatdssB172LabMicrobiologicalInfoVo> queryList(MmpNatdssB172LabMicrobiologicalInfoBo bo) {
        LambdaQueryWrapper<MmpNatdssB172LabMicrobiologicalInfo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB172LabMicrobiologicalInfo> buildQueryWrapper(MmpNatdssB172LabMicrobiologicalInfoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB172LabMicrobiologicalInfo> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB172LabMicrobiologicalInfo::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB172LabMicrobiologicalInfo::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB172LabMicrobiologicalInfo::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB172LabMicrobiologicalInfo::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB172LabMicrobiologicalInfo::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB172LabMicrobiologicalInfo::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB172LabMicrobiologicalInfo::getVisitTimes, bo.getVisitTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB172LabMicrobiologicalInfo::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB172LabMicrobiologicalInfo::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB172LabMicrobiologicalInfo::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.like(StringUtils.isNotBlank(bo.getName()), MmpNatdssB172LabMicrobiologicalInfo::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getApplyNo()), MmpNatdssB172LabMicrobiologicalInfo::getApplyNo, bo.getApplyNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), MmpNatdssB172LabMicrobiologicalInfo::getOrderSn, bo.getOrderSn());
        lqw.eq(bo.getApplyDatetime() != null, MmpNatdssB172LabMicrobiologicalInfo::getApplyDatetime, bo.getApplyDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getLabSn()), MmpNatdssB172LabMicrobiologicalInfo::getLabSn, bo.getLabSn());
        lqw.eq(bo.getTestDatetime() != null, MmpNatdssB172LabMicrobiologicalInfo::getTestDatetime, bo.getTestDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getReportNo()), MmpNatdssB172LabMicrobiologicalInfo::getReportNo, bo.getReportNo());
        lqw.eq(bo.getReportDatetime() != null, MmpNatdssB172LabMicrobiologicalInfo::getReportDatetime, bo.getReportDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecimenCode()), MmpNatdssB172LabMicrobiologicalInfo::getSpecimenCode, bo.getSpecimenCode());
        lqw.eq(StringUtils.isNotBlank(bo.getSampleType()), MmpNatdssB172LabMicrobiologicalInfo::getSampleType, bo.getSampleType());
        lqw.eq(StringUtils.isNotBlank(bo.getTestMethodCode()), MmpNatdssB172LabMicrobiologicalInfo::getTestMethodCode, bo.getTestMethodCode());
        lqw.eq(StringUtils.isNotBlank(bo.getTestMethod()), MmpNatdssB172LabMicrobiologicalInfo::getTestMethod, bo.getTestMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getCultivationResult()), MmpNatdssB172LabMicrobiologicalInfo::getCultivationResult, bo.getCultivationResult());
        lqw.eq(StringUtils.isNotBlank(bo.getResultCode()), MmpNatdssB172LabMicrobiologicalInfo::getResultCode, bo.getResultCode());
        lqw.eq(StringUtils.isNotBlank(bo.getResultPosNeg()), MmpNatdssB172LabMicrobiologicalInfo::getResultPosNeg, bo.getResultPosNeg());
        lqw.eq(StringUtils.isNotBlank(bo.getSensTestMethod()), MmpNatdssB172LabMicrobiologicalInfo::getSensTestMethod, bo.getSensTestMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getResisMechanism()), MmpNatdssB172LabMicrobiologicalInfo::getResisMechanism, bo.getResisMechanism());
        lqw.eq(StringUtils.isNotBlank(bo.getAntibioticsCode()), MmpNatdssB172LabMicrobiologicalInfo::getAntibioticsCode, bo.getAntibioticsCode());
        lqw.eq(StringUtils.isNotBlank(bo.getAntibiotics()), MmpNatdssB172LabMicrobiologicalInfo::getAntibiotics, bo.getAntibiotics());
        lqw.eq(StringUtils.isNotBlank(bo.getAntibioResult()), MmpNatdssB172LabMicrobiologicalInfo::getAntibioResult, bo.getAntibioResult());
        lqw.eq(StringUtils.isNotBlank(bo.getSensitivityResult()), MmpNatdssB172LabMicrobiologicalInfo::getSensitivityResult, bo.getSensitivityResult());
        lqw.eq(StringUtils.isNotBlank(bo.getResultReference()), MmpNatdssB172LabMicrobiologicalInfo::getResultReference, bo.getResultReference());
        lqw.like(StringUtils.isNotBlank(bo.getMdroName()), MmpNatdssB172LabMicrobiologicalInfo::getMdroName, bo.getMdroName());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB172LabMicrobiologicalInfo::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB172LabMicrobiologicalInfo::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB172LabMicrobiologicalInfo::getRecordStatus, bo.getRecordStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getCultivationCode()), MmpNatdssB172LabMicrobiologicalInfo::getCultivationCode, bo.getCultivationCode());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB172LabMicrobiologicalInfo::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB172LabMicrobiologicalInfo::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B172 微生物检验记录
     *
     * @param bo B172 微生物检验记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB172LabMicrobiologicalInfoBo bo) {
        MmpNatdssB172LabMicrobiologicalInfo add = MapstructUtils.convert(bo, MmpNatdssB172LabMicrobiologicalInfo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B172 微生物检验记录
     *
     * @param bo B172 微生物检验记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB172LabMicrobiologicalInfoBo bo) {
        MmpNatdssB172LabMicrobiologicalInfo update = MapstructUtils.convert(bo, MmpNatdssB172LabMicrobiologicalInfo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB172LabMicrobiologicalInfo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B172 微生物检验记录信息
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
