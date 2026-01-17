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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB16-2PathologicalExamRecordBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB16-2PathologicalExamRecordVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB16-2PathologicalExamRecord;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB16-2PathologicalExamRecordMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB16-2PathologicalExamRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B16-2 病理检查记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB16-2PathologicalExamRecordServiceImpl implements IMmpNatdssB16-2PathologicalExamRecordService {

    private final MmpNatdssB16-2PathologicalExamRecordMapper baseMapper;

    /**
     * 查询B16-2 病理检查记录
     *
     * @param id 主键
     * @return B16-2 病理检查记录
     */
    @Override
    public MmpNatdssB16-2PathologicalExamRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B16-2 病理检查记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B16-2 病理检查记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB16-2PathologicalExamRecordVo> queryPageList(MmpNatdssB16-2PathologicalExamRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB16-2PathologicalExamRecord> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB16-2PathologicalExamRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B16-2 病理检查记录列表
     *
     * @param bo 查询条件
     * @return B16-2 病理检查记录列表
     */
    @Override
    public List<MmpNatdssB16-2PathologicalExamRecordVo> queryList(MmpNatdssB16-2PathologicalExamRecordBo bo) {
        LambdaQueryWrapper<MmpNatdssB16-2PathologicalExamRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB16-2PathologicalExamRecord> buildQueryWrapper(MmpNatdssB16-2PathologicalExamRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB16-2PathologicalExamRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB16-2PathologicalExamRecord::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB16-2PathologicalExamRecord::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB16-2PathologicalExamRecord::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB16-2PathologicalExamRecord::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB16-2PathologicalExamRecord::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB16-2PathologicalExamRecord::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB16-2PathologicalExamRecord::getVisitTimes, bo.getVisitTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB16-2PathologicalExamRecord::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB16-2PathologicalExamRecord::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB16-2PathologicalExamRecord::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.like(StringUtils.isNotBlank(bo.getName()), MmpNatdssB16-2PathologicalExamRecord::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getGender()), MmpNatdssB16-2PathologicalExamRecord::getGender, bo.getGender());
        lqw.eq(bo.getAge() != null, MmpNatdssB16-2PathologicalExamRecord::getAge, bo.getAge());
        lqw.eq(bo.getDateOfBirth() != null, MmpNatdssB16-2PathologicalExamRecord::getDateOfBirth, bo.getDateOfBirth());
        lqw.eq(StringUtils.isNotBlank(bo.getApplyNo()), MmpNatdssB16-2PathologicalExamRecord::getApplyNo, bo.getApplyNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), MmpNatdssB16-2PathologicalExamRecord::getOrderSn, bo.getOrderSn());
        lqw.eq(bo.getApplyDatetime() != null, MmpNatdssB16-2PathologicalExamRecord::getApplyDatetime, bo.getApplyDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getPathologyNo()), MmpNatdssB16-2PathologicalExamRecord::getPathologyNo, bo.getPathologyNo());
        lqw.eq(StringUtils.isNotBlank(bo.getPathologySn()), MmpNatdssB16-2PathologicalExamRecord::getPathologySn, bo.getPathologySn());
        lqw.eq(bo.getExamDatetime() != null, MmpNatdssB16-2PathologicalExamRecord::getExamDatetime, bo.getExamDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getPathologyTestTypeCode()), MmpNatdssB16-2PathologicalExamRecord::getPathologyTestTypeCode, bo.getPathologyTestTypeCode());
        lqw.eq(StringUtils.isNotBlank(bo.getPathologyTestType()), MmpNatdssB16-2PathologicalExamRecord::getPathologyTestType, bo.getPathologyTestType());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecimenSite()), MmpNatdssB16-2PathologicalExamRecord::getSpecimenSite, bo.getSpecimenSite());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecimenObtainMethod()), MmpNatdssB16-2PathologicalExamRecord::getSpecimenObtainMethod, bo.getSpecimenObtainMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecimenType()), MmpNatdssB16-2PathologicalExamRecord::getSpecimenType, bo.getSpecimenType());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecimenCode()), MmpNatdssB16-2PathologicalExamRecord::getSpecimenCode, bo.getSpecimenCode());
        lqw.eq(bo.getCollectedDatetime() != null, MmpNatdssB16-2PathologicalExamRecord::getCollectedDatetime, bo.getCollectedDatetime());
        lqw.eq(bo.getReceivedDatetime() != null, MmpNatdssB16-2PathologicalExamRecord::getReceivedDatetime, bo.getReceivedDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getReportNo()), MmpNatdssB16-2PathologicalExamRecord::getReportNo, bo.getReportNo());
        lqw.eq(bo.getReportDatetime() != null, MmpNatdssB16-2PathologicalExamRecord::getReportDatetime, bo.getReportDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getStagingVersion()), MmpNatdssB16-2PathologicalExamRecord::getStagingVersion, bo.getStagingVersion());
        lqw.eq(StringUtils.isNotBlank(bo.getClinicalStage()), MmpNatdssB16-2PathologicalExamRecord::getClinicalStage, bo.getClinicalStage());
        lqw.eq(StringUtils.isNotBlank(bo.getPathoTStaging()), MmpNatdssB16-2PathologicalExamRecord::getPathoTStaging, bo.getPathoTStaging());
        lqw.eq(StringUtils.isNotBlank(bo.getPathoNStaging()), MmpNatdssB16-2PathologicalExamRecord::getPathoNStaging, bo.getPathoNStaging());
        lqw.eq(StringUtils.isNotBlank(bo.getPathoMStaging()), MmpNatdssB16-2PathologicalExamRecord::getPathoMStaging, bo.getPathoMStaging());
        lqw.eq(StringUtils.isNotBlank(bo.getGrossDescription()), MmpNatdssB16-2PathologicalExamRecord::getGrossDescription, bo.getGrossDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getMicroDescription()), MmpNatdssB16-2PathologicalExamRecord::getMicroDescription, bo.getMicroDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getPathoDiagConclusion()), MmpNatdssB16-2PathologicalExamRecord::getPathoDiagConclusion, bo.getPathoDiagConclusion());
        lqw.eq(StringUtils.isNotBlank(bo.getIhcResults()), MmpNatdssB16-2PathologicalExamRecord::getIhcResults, bo.getIhcResults());
        lqw.eq(StringUtils.isNotBlank(bo.getMolTestMark()), MmpNatdssB16-2PathologicalExamRecord::getMolTestMark, bo.getMolTestMark());
        lqw.eq(StringUtils.isNotBlank(bo.getMolTestGeneAndMethod()), MmpNatdssB16-2PathologicalExamRecord::getMolTestGeneAndMethod, bo.getMolTestGeneAndMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getMolTestResult()), MmpNatdssB16-2PathologicalExamRecord::getMolTestResult, bo.getMolTestResult());
        lqw.eq(StringUtils.isNotBlank(bo.getDifferentiationDegree()), MmpNatdssB16-2PathologicalExamRecord::getDifferentiationDegree, bo.getDifferentiationDegree());
        lqw.eq(StringUtils.isNotBlank(bo.getBloodVesselInfil()), MmpNatdssB16-2PathologicalExamRecord::getBloodVesselInfil, bo.getBloodVesselInfil());
        lqw.eq(StringUtils.isNotBlank(bo.getLymphInfilt()), MmpNatdssB16-2PathologicalExamRecord::getLymphInfilt, bo.getLymphInfilt());
        lqw.eq(StringUtils.isNotBlank(bo.getLymphMet()), MmpNatdssB16-2PathologicalExamRecord::getLymphMet, bo.getLymphMet());
        lqw.eq(StringUtils.isNotBlank(bo.getVascTumourThrombus()), MmpNatdssB16-2PathologicalExamRecord::getVascTumourThrombus, bo.getVascTumourThrombus());
        lqw.eq(StringUtils.isNotBlank(bo.getNerveInvasion()), MmpNatdssB16-2PathologicalExamRecord::getNerveInvasion, bo.getNerveInvasion());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB16-2PathologicalExamRecord::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB16-2PathologicalExamRecord::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB16-2PathologicalExamRecord::getRecordStatus, bo.getRecordStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getIntraoperativeFreezingResult()), MmpNatdssB16-2PathologicalExamRecord::getIntraoperativeFreezingResult, bo.getIntraoperativeFreezingResult());
        lqw.eq(StringUtils.isNotBlank(bo.getRecorder1()), MmpNatdssB16-2PathologicalExamRecord::getRecorder1, bo.getRecorder1());
        lqw.eq(StringUtils.isNotBlank(bo.getRecorder2()), MmpNatdssB16-2PathologicalExamRecord::getRecorder2, bo.getRecorder2());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB16-2PathologicalExamRecord::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB16-2PathologicalExamRecord::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B16-2 病理检查记录
     *
     * @param bo B16-2 病理检查记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB16-2PathologicalExamRecordBo bo) {
        MmpNatdssB16-2PathologicalExamRecord add = MapstructUtils.convert(bo, MmpNatdssB16-2PathologicalExamRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B16-2 病理检查记录
     *
     * @param bo B16-2 病理检查记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB16-2PathologicalExamRecordBo bo) {
        MmpNatdssB16-2PathologicalExamRecord update = MapstructUtils.convert(bo, MmpNatdssB16-2PathologicalExamRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB16-2PathologicalExamRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B16-2 病理检查记录信息
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
