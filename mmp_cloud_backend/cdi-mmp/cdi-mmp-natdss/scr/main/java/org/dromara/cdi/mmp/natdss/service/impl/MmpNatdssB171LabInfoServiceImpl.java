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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB171LabInfoBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB171LabInfoVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB171LabInfo;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB171LabInfoMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB171LabInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B17-1 常规检验记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB171LabInfoServiceImpl implements IMmpNatdssB171LabInfoService {

    private final MmpNatdssB171LabInfoMapper baseMapper;

    /**
     * 查询B17-1 常规检验记录
     *
     * @param id 主键
     * @return B17-1 常规检验记录
     */
    @Override
    public MmpNatdssB171LabInfoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B17-1 常规检验记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B17-1 常规检验记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB171LabInfoVo> queryPageList(MmpNatdssB171LabInfoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB171LabInfo> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB171LabInfoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B17-1 常规检验记录列表
     *
     * @param bo 查询条件
     * @return B17-1 常规检验记录列表
     */
    @Override
    public List<MmpNatdssB171LabInfoVo> queryList(MmpNatdssB171LabInfoBo bo) {
        LambdaQueryWrapper<MmpNatdssB171LabInfo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB171LabInfo> buildQueryWrapper(MmpNatdssB171LabInfoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB171LabInfo> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB171LabInfo::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB171LabInfo::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB171LabInfo::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB171LabInfo::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB171LabInfo::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB171LabInfo::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB171LabInfo::getVisitTimes, bo.getVisitTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB171LabInfo::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB171LabInfo::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB171LabInfo::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.like(StringUtils.isNotBlank(bo.getName()), MmpNatdssB171LabInfo::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getApplyNo()), MmpNatdssB171LabInfo::getApplyNo, bo.getApplyNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), MmpNatdssB171LabInfo::getOrderSn, bo.getOrderSn());
        lqw.eq(bo.getApplyDatetime() != null, MmpNatdssB171LabInfo::getApplyDatetime, bo.getApplyDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecimenTypeCode()), MmpNatdssB171LabInfo::getSpecimenTypeCode, bo.getSpecimenTypeCode());
        lqw.like(StringUtils.isNotBlank(bo.getSpecimenTypeName()), MmpNatdssB171LabInfo::getSpecimenTypeName, bo.getSpecimenTypeName());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecimenCode()), MmpNatdssB171LabInfo::getSpecimenCode, bo.getSpecimenCode());
        lqw.eq(StringUtils.isNotBlank(bo.getLabSn()), MmpNatdssB171LabInfo::getLabSn, bo.getLabSn());
        lqw.eq(bo.getTestDatetime() != null, MmpNatdssB171LabInfo::getTestDatetime, bo.getTestDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getTestMethodCode()), MmpNatdssB171LabInfo::getTestMethodCode, bo.getTestMethodCode());
        lqw.eq(StringUtils.isNotBlank(bo.getTestMethod()), MmpNatdssB171LabInfo::getTestMethod, bo.getTestMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getLabType()), MmpNatdssB171LabInfo::getLabType, bo.getLabType());
        lqw.eq(StringUtils.isNotBlank(bo.getItemGroupCode()), MmpNatdssB171LabInfo::getItemGroupCode, bo.getItemGroupCode());
        lqw.like(StringUtils.isNotBlank(bo.getItemGroupName()), MmpNatdssB171LabInfo::getItemGroupName, bo.getItemGroupName());
        lqw.eq(StringUtils.isNotBlank(bo.getItemCode()), MmpNatdssB171LabInfo::getItemCode, bo.getItemCode());
        lqw.like(StringUtils.isNotBlank(bo.getItemName()), MmpNatdssB171LabInfo::getItemName, bo.getItemName());
        lqw.eq(StringUtils.isNotBlank(bo.getItemNo()), MmpNatdssB171LabInfo::getItemNo, bo.getItemNo());
        lqw.eq(StringUtils.isNotBlank(bo.getResultQuantitative()), MmpNatdssB171LabInfo::getResultQuantitative, bo.getResultQuantitative());
        lqw.eq(StringUtils.isNotBlank(bo.getResultQualitative()), MmpNatdssB171LabInfo::getResultQualitative, bo.getResultQualitative());
        lqw.eq(StringUtils.isNotBlank(bo.getResultUnit()), MmpNatdssB171LabInfo::getResultUnit, bo.getResultUnit());
        lqw.eq(StringUtils.isNotBlank(bo.getReferenceRange()), MmpNatdssB171LabInfo::getReferenceRange, bo.getReferenceRange());
        lqw.eq(StringUtils.isNotBlank(bo.getReferenceRangeAlert()), MmpNatdssB171LabInfo::getReferenceRangeAlert, bo.getReferenceRangeAlert());
        lqw.eq(StringUtils.isNotBlank(bo.getReportNo()), MmpNatdssB171LabInfo::getReportNo, bo.getReportNo());
        lqw.eq(bo.getReportDatetime() != null, MmpNatdssB171LabInfo::getReportDatetime, bo.getReportDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB171LabInfo::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB171LabInfo::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB171LabInfo::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB171LabInfo::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB171LabInfo::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B17-1 常规检验记录
     *
     * @param bo B17-1 常规检验记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB171LabInfoBo bo) {
        MmpNatdssB171LabInfo add = MapstructUtils.convert(bo, MmpNatdssB171LabInfo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B17-1 常规检验记录
     *
     * @param bo B17-1 常规检验记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB171LabInfoBo bo) {
        MmpNatdssB171LabInfo update = MapstructUtils.convert(bo, MmpNatdssB171LabInfo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB171LabInfo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B17-1 常规检验记录信息
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
