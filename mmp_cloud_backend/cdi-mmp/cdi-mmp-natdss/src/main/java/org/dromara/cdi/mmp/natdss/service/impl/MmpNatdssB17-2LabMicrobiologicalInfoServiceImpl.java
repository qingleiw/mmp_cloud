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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB17-2LabMicrobiologicalInfoBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB17-2LabMicrobiologicalInfoVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB17-2LabMicrobiologicalInfo;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB17-2LabMicrobiologicalInfoMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB17-2LabMicrobiologicalInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B17-2 微生物检验记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB17-2LabMicrobiologicalInfoServiceImpl implements IMmpNatdssB17-2LabMicrobiologicalInfoService {

    private final MmpNatdssB17-2LabMicrobiologicalInfoMapper baseMapper;

    /**
     * 查询B17-2 微生物检验记录
     *
     * @param id 主键
     * @return B17-2 微生物检验记录
     */
    @Override
    public MmpNatdssB17-2LabMicrobiologicalInfoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B17-2 微生物检验记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B17-2 微生物检验记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB17-2LabMicrobiologicalInfoVo> queryPageList(MmpNatdssB17-2LabMicrobiologicalInfoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB17-2LabMicrobiologicalInfo> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB17-2LabMicrobiologicalInfoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B17-2 微生物检验记录列表
     *
     * @param bo 查询条件
     * @return B17-2 微生物检验记录列表
     */
    @Override
    public List<MmpNatdssB17-2LabMicrobiologicalInfoVo> queryList(MmpNatdssB17-2LabMicrobiologicalInfoBo bo) {
        LambdaQueryWrapper<MmpNatdssB17-2LabMicrobiologicalInfo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB17-2LabMicrobiologicalInfo> buildQueryWrapper(MmpNatdssB17-2LabMicrobiologicalInfoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB17-2LabMicrobiologicalInfo> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB17-2LabMicrobiologicalInfo::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB17-2LabMicrobiologicalInfo::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB17-2LabMicrobiologicalInfo::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB17-2LabMicrobiologicalInfo::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB17-2LabMicrobiologicalInfo::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB17-2LabMicrobiologicalInfo::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB17-2LabMicrobiologicalInfo::getVisitTimes, bo.getVisitTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB17-2LabMicrobiologicalInfo::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB17-2LabMicrobiologicalInfo::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB17-2LabMicrobiologicalInfo::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.like(StringUtils.isNotBlank(bo.getName()), MmpNatdssB17-2LabMicrobiologicalInfo::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getApplyNo()), MmpNatdssB17-2LabMicrobiologicalInfo::getApplyNo, bo.getApplyNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), MmpNatdssB17-2LabMicrobiologicalInfo::getOrderSn, bo.getOrderSn());
        lqw.eq(bo.getApplyDatetime() != null, MmpNatdssB17-2LabMicrobiologicalInfo::getApplyDatetime, bo.getApplyDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getLabSn()), MmpNatdssB17-2LabMicrobiologicalInfo::getLabSn, bo.getLabSn());
        lqw.eq(bo.getTestDatetime() != null, MmpNatdssB17-2LabMicrobiologicalInfo::getTestDatetime, bo.getTestDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getReportNo()), MmpNatdssB17-2LabMicrobiologicalInfo::getReportNo, bo.getReportNo());
        lqw.eq(bo.getReportDatetime() != null, MmpNatdssB17-2LabMicrobiologicalInfo::getReportDatetime, bo.getReportDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecimenCode()), MmpNatdssB17-2LabMicrobiologicalInfo::getSpecimenCode, bo.getSpecimenCode());
        lqw.eq(StringUtils.isNotBlank(bo.getSampleType()), MmpNatdssB17-2LabMicrobiologicalInfo::getSampleType, bo.getSampleType());
        lqw.eq(StringUtils.isNotBlank(bo.getTestMethodCode()), MmpNatdssB17-2LabMicrobiologicalInfo::getTestMethodCode, bo.getTestMethodCode());
        lqw.eq(StringUtils.isNotBlank(bo.getTestMethod()), MmpNatdssB17-2LabMicrobiologicalInfo::getTestMethod, bo.getTestMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getCultivationResult()), MmpNatdssB17-2LabMicrobiologicalInfo::getCultivationResult, bo.getCultivationResult());
        lqw.eq(StringUtils.isNotBlank(bo.getResultCode()), MmpNatdssB17-2LabMicrobiologicalInfo::getResultCode, bo.getResultCode());
        lqw.eq(StringUtils.isNotBlank(bo.getResultPosNeg()), MmpNatdssB17-2LabMicrobiologicalInfo::getResultPosNeg, bo.getResultPosNeg());
        lqw.eq(StringUtils.isNotBlank(bo.getSensTestMethod()), MmpNatdssB17-2LabMicrobiologicalInfo::getSensTestMethod, bo.getSensTestMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getResisMechanism()), MmpNatdssB17-2LabMicrobiologicalInfo::getResisMechanism, bo.getResisMechanism());
        lqw.eq(StringUtils.isNotBlank(bo.getAntibioticsCode()), MmpNatdssB17-2LabMicrobiologicalInfo::getAntibioticsCode, bo.getAntibioticsCode());
        lqw.eq(StringUtils.isNotBlank(bo.getAntibiotics()), MmpNatdssB17-2LabMicrobiologicalInfo::getAntibiotics, bo.getAntibiotics());
        lqw.eq(StringUtils.isNotBlank(bo.getAntibioResult()), MmpNatdssB17-2LabMicrobiologicalInfo::getAntibioResult, bo.getAntibioResult());
        lqw.eq(StringUtils.isNotBlank(bo.getSensitivityResult()), MmpNatdssB17-2LabMicrobiologicalInfo::getSensitivityResult, bo.getSensitivityResult());
        lqw.eq(StringUtils.isNotBlank(bo.getResultReference()), MmpNatdssB17-2LabMicrobiologicalInfo::getResultReference, bo.getResultReference());
        lqw.like(StringUtils.isNotBlank(bo.getMdroName()), MmpNatdssB17-2LabMicrobiologicalInfo::getMdroName, bo.getMdroName());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB17-2LabMicrobiologicalInfo::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB17-2LabMicrobiologicalInfo::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB17-2LabMicrobiologicalInfo::getRecordStatus, bo.getRecordStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getCultivationCode()), MmpNatdssB17-2LabMicrobiologicalInfo::getCultivationCode, bo.getCultivationCode());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB17-2LabMicrobiologicalInfo::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB17-2LabMicrobiologicalInfo::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B17-2 微生物检验记录
     *
     * @param bo B17-2 微生物检验记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB17-2LabMicrobiologicalInfoBo bo) {
        MmpNatdssB17-2LabMicrobiologicalInfo add = MapstructUtils.convert(bo, MmpNatdssB17-2LabMicrobiologicalInfo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B17-2 微生物检验记录
     *
     * @param bo B17-2 微生物检验记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB17-2LabMicrobiologicalInfoBo bo) {
        MmpNatdssB17-2LabMicrobiologicalInfo update = MapstructUtils.convert(bo, MmpNatdssB17-2LabMicrobiologicalInfo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB17-2LabMicrobiologicalInfo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B17-2 微生物检验记录信息
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
