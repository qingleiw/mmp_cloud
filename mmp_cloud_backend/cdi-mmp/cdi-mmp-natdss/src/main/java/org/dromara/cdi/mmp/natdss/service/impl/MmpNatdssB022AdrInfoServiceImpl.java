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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB022AdrInfoBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB022AdrInfoVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB022AdrInfo;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB022AdrInfoMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB022AdrInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B02-2 患者药物不良反应记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB022AdrInfoServiceImpl implements IMmpNatdssB022AdrInfoService {

    private final MmpNatdssB022AdrInfoMapper baseMapper;

    /**
     * 查询B02-2 患者药物不良反应记录
     *
     * @param id 主键
     * @return B02-2 患者药物不良反应记录
     */
    @Override
    public MmpNatdssB022AdrInfoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B02-2 患者药物不良反应记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B02-2 患者药物不良反应记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB022AdrInfoVo> queryPageList(MmpNatdssB022AdrInfoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB022AdrInfo> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB022AdrInfoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B02-2 患者药物不良反应记录列表
     *
     * @param bo 查询条件
     * @return B02-2 患者药物不良反应记录列表
     */
    @Override
    public List<MmpNatdssB022AdrInfoVo> queryList(MmpNatdssB022AdrInfoBo bo) {
        LambdaQueryWrapper<MmpNatdssB022AdrInfo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB022AdrInfo> buildQueryWrapper(MmpNatdssB022AdrInfoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB022AdrInfo> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB022AdrInfo::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB022AdrInfo::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB022AdrInfo::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB022AdrInfo::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB022AdrInfo::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB022AdrInfo::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB022AdrInfo::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB022AdrInfo::getVisitTimes, bo.getVisitTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB022AdrInfo::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB022AdrInfo::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.like(StringUtils.isNotBlank(bo.getName()), MmpNatdssB022AdrInfo::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getAdrEventSn()), MmpNatdssB022AdrInfo::getAdrEventSn, bo.getAdrEventSn());
        lqw.eq(StringUtils.isNotBlank(bo.getAdrReportStatus()), MmpNatdssB022AdrInfo::getAdrReportStatus, bo.getAdrReportStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getAdrReportType()), MmpNatdssB022AdrInfo::getAdrReportType, bo.getAdrReportType());
        lqw.eq(bo.getAdrReportTime() != null, MmpNatdssB022AdrInfo::getAdrReportTime, bo.getAdrReportTime());
        lqw.eq(StringUtils.isNotBlank(bo.getAdrOriginalDisease()), MmpNatdssB022AdrInfo::getAdrOriginalDisease, bo.getAdrOriginalDisease());
        lqw.eq(StringUtils.isNotBlank(bo.getAdrDiseaseInfluence()), MmpNatdssB022AdrInfo::getAdrDiseaseInfluence, bo.getAdrDiseaseInfluence());
        lqw.eq(StringUtils.isNotBlank(bo.getAdrFamilyStatus()), MmpNatdssB022AdrInfo::getAdrFamilyStatus, bo.getAdrFamilyStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getAdrPastStatus()), MmpNatdssB022AdrInfo::getAdrPastStatus, bo.getAdrPastStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getAdrPastOther()), MmpNatdssB022AdrInfo::getAdrPastOther, bo.getAdrPastOther());
        lqw.like(StringUtils.isNotBlank(bo.getAdrEventName()), MmpNatdssB022AdrInfo::getAdrEventName, bo.getAdrEventName());
        lqw.eq(bo.getAdrEventTime() != null, MmpNatdssB022AdrInfo::getAdrEventTime, bo.getAdrEventTime());
        lqw.eq(StringUtils.isNotBlank(bo.getAdrEventContent()), MmpNatdssB022AdrInfo::getAdrEventContent, bo.getAdrEventContent());
        lqw.eq(StringUtils.isNotBlank(bo.getAdrEventResult()), MmpNatdssB022AdrInfo::getAdrEventResult, bo.getAdrEventResult());
        lqw.eq(StringUtils.isNotBlank(bo.getAdrStopStatus()), MmpNatdssB022AdrInfo::getAdrStopStatus, bo.getAdrStopStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getAdrReuseStatus()), MmpNatdssB022AdrInfo::getAdrReuseStatus, bo.getAdrReuseStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getSuspectDrugApprovalNo()), MmpNatdssB022AdrInfo::getSuspectDrugApprovalNo, bo.getSuspectDrugApprovalNo());
        lqw.eq(StringUtils.isNotBlank(bo.getSuspectDrugCode()), MmpNatdssB022AdrInfo::getSuspectDrugCode, bo.getSuspectDrugCode());
        lqw.like(StringUtils.isNotBlank(bo.getSuspectDrugTradeName()), MmpNatdssB022AdrInfo::getSuspectDrugTradeName, bo.getSuspectDrugTradeName());
        lqw.like(StringUtils.isNotBlank(bo.getSuspectDrugGenericName()), MmpNatdssB022AdrInfo::getSuspectDrugGenericName, bo.getSuspectDrugGenericName());
        lqw.eq(StringUtils.isNotBlank(bo.getSuspectDrugManufac()), MmpNatdssB022AdrInfo::getSuspectDrugManufac, bo.getSuspectDrugManufac());
        lqw.eq(StringUtils.isNotBlank(bo.getSuspectDrugBatchNo()), MmpNatdssB022AdrInfo::getSuspectDrugBatchNo, bo.getSuspectDrugBatchNo());
        lqw.eq(StringUtils.isNotBlank(bo.getSuspectDrugDosage()), MmpNatdssB022AdrInfo::getSuspectDrugDosage, bo.getSuspectDrugDosage());
        lqw.eq(StringUtils.isNotBlank(bo.getSuspectDrugMethod()), MmpNatdssB022AdrInfo::getSuspectDrugMethod, bo.getSuspectDrugMethod());
        lqw.eq(bo.getSuspectDrugStartTime() != null, MmpNatdssB022AdrInfo::getSuspectDrugStartTime, bo.getSuspectDrugStartTime());
        lqw.eq(bo.getSuspectDrugEndTime() != null, MmpNatdssB022AdrInfo::getSuspectDrugEndTime, bo.getSuspectDrugEndTime());
        lqw.eq(StringUtils.isNotBlank(bo.getSuspectDrugReason()), MmpNatdssB022AdrInfo::getSuspectDrugReason, bo.getSuspectDrugReason());
        lqw.eq(StringUtils.isNotBlank(bo.getConcomitantDrugApprovalNo()), MmpNatdssB022AdrInfo::getConcomitantDrugApprovalNo, bo.getConcomitantDrugApprovalNo());
        lqw.eq(StringUtils.isNotBlank(bo.getConcomitantDrugCode()), MmpNatdssB022AdrInfo::getConcomitantDrugCode, bo.getConcomitantDrugCode());
        lqw.like(StringUtils.isNotBlank(bo.getConcomitantDrugTradeName()), MmpNatdssB022AdrInfo::getConcomitantDrugTradeName, bo.getConcomitantDrugTradeName());
        lqw.like(StringUtils.isNotBlank(bo.getConcomitantDrugGenericName()), MmpNatdssB022AdrInfo::getConcomitantDrugGenericName, bo.getConcomitantDrugGenericName());
        lqw.eq(StringUtils.isNotBlank(bo.getConcomitantDrugManufac()), MmpNatdssB022AdrInfo::getConcomitantDrugManufac, bo.getConcomitantDrugManufac());
        lqw.eq(StringUtils.isNotBlank(bo.getConcomitantDrugBatchNo()), MmpNatdssB022AdrInfo::getConcomitantDrugBatchNo, bo.getConcomitantDrugBatchNo());
        lqw.eq(StringUtils.isNotBlank(bo.getConcomitantDrugDosage()), MmpNatdssB022AdrInfo::getConcomitantDrugDosage, bo.getConcomitantDrugDosage());
        lqw.eq(StringUtils.isNotBlank(bo.getConcomitantDrugMethod()), MmpNatdssB022AdrInfo::getConcomitantDrugMethod, bo.getConcomitantDrugMethod());
        lqw.eq(bo.getConcomitantDrugStartTime() != null, MmpNatdssB022AdrInfo::getConcomitantDrugStartTime, bo.getConcomitantDrugStartTime());
        lqw.eq(bo.getConcomitantDrugEndTime() != null, MmpNatdssB022AdrInfo::getConcomitantDrugEndTime, bo.getConcomitantDrugEndTime());
        lqw.eq(StringUtils.isNotBlank(bo.getConcomitantDrugReason()), MmpNatdssB022AdrInfo::getConcomitantDrugReason, bo.getConcomitantDrugReason());
        lqw.eq(StringUtils.isNotBlank(bo.getAdrReporterAppraise()), MmpNatdssB022AdrInfo::getAdrReporterAppraise, bo.getAdrReporterAppraise());
        lqw.eq(StringUtils.isNotBlank(bo.getAdrReportUnitAppraise()), MmpNatdssB022AdrInfo::getAdrReportUnitAppraise, bo.getAdrReportUnitAppraise());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB022AdrInfo::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB022AdrInfo::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB022AdrInfo::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB022AdrInfo::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB022AdrInfo::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B02-2 患者药物不良反应记录
     *
     * @param bo B02-2 患者药物不良反应记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB022AdrInfoBo bo) {
        MmpNatdssB022AdrInfo add = MapstructUtils.convert(bo, MmpNatdssB022AdrInfo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B02-2 患者药物不良反应记录
     *
     * @param bo B02-2 患者药物不良反应记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB022AdrInfoBo bo) {
        MmpNatdssB022AdrInfo update = MapstructUtils.convert(bo, MmpNatdssB022AdrInfo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB022AdrInfo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B02-2 患者药物不良反应记录信息
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
