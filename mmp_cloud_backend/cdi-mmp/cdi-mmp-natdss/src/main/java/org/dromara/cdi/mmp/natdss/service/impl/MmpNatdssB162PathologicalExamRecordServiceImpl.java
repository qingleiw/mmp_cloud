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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB162PathologicalExamRecordBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB162PathologicalExamRecordVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB162PathologicalExamRecord;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB162PathologicalExamRecordMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB162PathologicalExamRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B162 病理检查记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB162PathologicalExamRecordServiceImpl implements IMmpNatdssB162PathologicalExamRecordService {

    private final MmpNatdssB162PathologicalExamRecordMapper baseMapper;

    /**
     * 查询B162 病理检查记录
     *
     * @param id 主键
     * @return B162 病理检查记录
     */
    @Override
    public MmpNatdssB162PathologicalExamRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B162 病理检查记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B162 病理检查记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB162PathologicalExamRecordVo> queryPageList(MmpNatdssB162PathologicalExamRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB162PathologicalExamRecord> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB162PathologicalExamRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B162 病理检查记录列表
     *
     * @param bo 查询条件
     * @return B162 病理检查记录列表
     */
    @Override
    public List<MmpNatdssB162PathologicalExamRecordVo> queryList(MmpNatdssB162PathologicalExamRecordBo bo) {
        LambdaQueryWrapper<MmpNatdssB162PathologicalExamRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB162PathologicalExamRecord> buildQueryWrapper(MmpNatdssB162PathologicalExamRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB162PathologicalExamRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB162PathologicalExamRecord::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB162PathologicalExamRecord::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB162PathologicalExamRecord::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB162PathologicalExamRecord::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB162PathologicalExamRecord::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB162PathologicalExamRecord::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB162PathologicalExamRecord::getVisitTimes, bo.getVisitTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB162PathologicalExamRecord::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB162PathologicalExamRecord::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB162PathologicalExamRecord::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.like(StringUtils.isNotBlank(bo.getName()), MmpNatdssB162PathologicalExamRecord::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getGender()), MmpNatdssB162PathologicalExamRecord::getGender, bo.getGender());
        lqw.eq(bo.getAge() != null, MmpNatdssB162PathologicalExamRecord::getAge, bo.getAge());
        lqw.eq(bo.getDateOfBirth() != null, MmpNatdssB162PathologicalExamRecord::getDateOfBirth, bo.getDateOfBirth());
        lqw.eq(StringUtils.isNotBlank(bo.getApplyNo()), MmpNatdssB162PathologicalExamRecord::getApplyNo, bo.getApplyNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), MmpNatdssB162PathologicalExamRecord::getOrderSn, bo.getOrderSn());
        lqw.eq(bo.getApplyDatetime() != null, MmpNatdssB162PathologicalExamRecord::getApplyDatetime, bo.getApplyDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getPathologyNo()), MmpNatdssB162PathologicalExamRecord::getPathologyNo, bo.getPathologyNo());
        lqw.eq(StringUtils.isNotBlank(bo.getPathologySn()), MmpNatdssB162PathologicalExamRecord::getPathologySn, bo.getPathologySn());
        lqw.eq(bo.getExamDatetime() != null, MmpNatdssB162PathologicalExamRecord::getExamDatetime, bo.getExamDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getPathologyTestTypeCode()), MmpNatdssB162PathologicalExamRecord::getPathologyTestTypeCode, bo.getPathologyTestTypeCode());
        lqw.eq(StringUtils.isNotBlank(bo.getPathologyTestType()), MmpNatdssB162PathologicalExamRecord::getPathologyTestType, bo.getPathologyTestType());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecimenSite()), MmpNatdssB162PathologicalExamRecord::getSpecimenSite, bo.getSpecimenSite());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecimenObtainMethod()), MmpNatdssB162PathologicalExamRecord::getSpecimenObtainMethod, bo.getSpecimenObtainMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecimenType()), MmpNatdssB162PathologicalExamRecord::getSpecimenType, bo.getSpecimenType());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecimenCode()), MmpNatdssB162PathologicalExamRecord::getSpecimenCode, bo.getSpecimenCode());
        lqw.eq(bo.getCollectedDatetime() != null, MmpNatdssB162PathologicalExamRecord::getCollectedDatetime, bo.getCollectedDatetime());
        lqw.eq(bo.getReceivedDatetime() != null, MmpNatdssB162PathologicalExamRecord::getReceivedDatetime, bo.getReceivedDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getReportNo()), MmpNatdssB162PathologicalExamRecord::getReportNo, bo.getReportNo());
        lqw.eq(bo.getReportDatetime() != null, MmpNatdssB162PathologicalExamRecord::getReportDatetime, bo.getReportDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getStagingVersion()), MmpNatdssB162PathologicalExamRecord::getStagingVersion, bo.getStagingVersion());
        lqw.eq(StringUtils.isNotBlank(bo.getClinicalStage()), MmpNatdssB162PathologicalExamRecord::getClinicalStage, bo.getClinicalStage());
        lqw.eq(StringUtils.isNotBlank(bo.getPathoTStaging()), MmpNatdssB162PathologicalExamRecord::getPathoTStaging, bo.getPathoTStaging());
        lqw.eq(StringUtils.isNotBlank(bo.getPathoNStaging()), MmpNatdssB162PathologicalExamRecord::getPathoNStaging, bo.getPathoNStaging());
        lqw.eq(StringUtils.isNotBlank(bo.getPathoMStaging()), MmpNatdssB162PathologicalExamRecord::getPathoMStaging, bo.getPathoMStaging());
        lqw.eq(StringUtils.isNotBlank(bo.getGrossDescription()), MmpNatdssB162PathologicalExamRecord::getGrossDescription, bo.getGrossDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getMicroDescription()), MmpNatdssB162PathologicalExamRecord::getMicroDescription, bo.getMicroDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getPathoDiagConclusion()), MmpNatdssB162PathologicalExamRecord::getPathoDiagConclusion, bo.getPathoDiagConclusion());
        lqw.eq(StringUtils.isNotBlank(bo.getIhcResults()), MmpNatdssB162PathologicalExamRecord::getIhcResults, bo.getIhcResults());
        lqw.eq(StringUtils.isNotBlank(bo.getMolTestMark()), MmpNatdssB162PathologicalExamRecord::getMolTestMark, bo.getMolTestMark());
        lqw.eq(StringUtils.isNotBlank(bo.getMolTestGeneAndMethod()), MmpNatdssB162PathologicalExamRecord::getMolTestGeneAndMethod, bo.getMolTestGeneAndMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getMolTestResult()), MmpNatdssB162PathologicalExamRecord::getMolTestResult, bo.getMolTestResult());
        lqw.eq(StringUtils.isNotBlank(bo.getDifferentiationDegree()), MmpNatdssB162PathologicalExamRecord::getDifferentiationDegree, bo.getDifferentiationDegree());
        lqw.eq(StringUtils.isNotBlank(bo.getBloodVesselInfil()), MmpNatdssB162PathologicalExamRecord::getBloodVesselInfil, bo.getBloodVesselInfil());
        lqw.eq(StringUtils.isNotBlank(bo.getLymphInfilt()), MmpNatdssB162PathologicalExamRecord::getLymphInfilt, bo.getLymphInfilt());
        lqw.eq(StringUtils.isNotBlank(bo.getLymphMet()), MmpNatdssB162PathologicalExamRecord::getLymphMet, bo.getLymphMet());
        lqw.eq(StringUtils.isNotBlank(bo.getVascTumourThrombus()), MmpNatdssB162PathologicalExamRecord::getVascTumourThrombus, bo.getVascTumourThrombus());
        lqw.eq(StringUtils.isNotBlank(bo.getNerveInvasion()), MmpNatdssB162PathologicalExamRecord::getNerveInvasion, bo.getNerveInvasion());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB162PathologicalExamRecord::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB162PathologicalExamRecord::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB162PathologicalExamRecord::getRecordStatus, bo.getRecordStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getIntraoperativeFreezingResult()), MmpNatdssB162PathologicalExamRecord::getIntraoperativeFreezingResult, bo.getIntraoperativeFreezingResult());
        lqw.eq(StringUtils.isNotBlank(bo.getRecorder1()), MmpNatdssB162PathologicalExamRecord::getRecorder1, bo.getRecorder1());
        lqw.eq(StringUtils.isNotBlank(bo.getRecorder2()), MmpNatdssB162PathologicalExamRecord::getRecorder2, bo.getRecorder2());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB162PathologicalExamRecord::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB162PathologicalExamRecord::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B162 病理检查记录
     *
     * @param bo B162 病理检查记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB162PathologicalExamRecordBo bo) {
        MmpNatdssB162PathologicalExamRecord add = MapstructUtils.convert(bo, MmpNatdssB162PathologicalExamRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B162 病理检查记录
     *
     * @param bo B162 病理检查记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB162PathologicalExamRecordBo bo) {
        MmpNatdssB162PathologicalExamRecord update = MapstructUtils.convert(bo, MmpNatdssB162PathologicalExamRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB162PathologicalExamRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B162 病理检查记录信息
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
