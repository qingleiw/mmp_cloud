package org.dromara.cdi.mmp.ledger.service.impl;

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
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerPatientFullCycleBo;
import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerPatientFullCycleVo;
import org.dromara.cdi.mmp.ledger.domain.MmpLedgerPatientFullCycle;
import org.dromara.cdi.mmp.ledger.mapper.MmpLedgerPatientFullCycleMapper;
import org.dromara.cdi.mmp.ledger.service.IMmpLedgerPatientFullCycleService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 患者医疗全周期信息管理Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpLedgerPatientFullCycleServiceImpl implements IMmpLedgerPatientFullCycleService {

    private final MmpLedgerPatientFullCycleMapper baseMapper;

    /**
     * 查询患者医疗全周期信息管理
     *
     * @param id 主键
     * @return 患者医疗全周期信息管理
     */
    @Override
    public MmpLedgerPatientFullCycleVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询患者医疗全周期信息管理列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 患者医疗全周期信息管理分页列表
     */
    @Override
    public TableDataInfo<MmpLedgerPatientFullCycleVo> queryPageList(MmpLedgerPatientFullCycleBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpLedgerPatientFullCycle> lqw = buildQueryWrapper(bo);
        Page<MmpLedgerPatientFullCycleVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的患者医疗全周期信息管理列表
     *
     * @param bo 查询条件
     * @return 患者医疗全周期信息管理列表
     */
    @Override
    public List<MmpLedgerPatientFullCycleVo> queryList(MmpLedgerPatientFullCycleBo bo) {
        LambdaQueryWrapper<MmpLedgerPatientFullCycle> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpLedgerPatientFullCycle> buildQueryWrapper(MmpLedgerPatientFullCycleBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpLedgerPatientFullCycle> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpLedgerPatientFullCycle::getId);
        lqw.like(StringUtils.isNotBlank(bo.getPatientName()), MmpLedgerPatientFullCycle::getPatientName, bo.getPatientName());
        lqw.eq(bo.getAdmissionDate() != null, MmpLedgerPatientFullCycle::getAdmissionDate, bo.getAdmissionDate());
        lqw.eq(bo.getDischargeDate() != null, MmpLedgerPatientFullCycle::getDischargeDate, bo.getDischargeDate());
        lqw.eq(StringUtils.isNotBlank(bo.getDepartment()), MmpLedgerPatientFullCycle::getDepartment, bo.getDepartment());
        lqw.eq(StringUtils.isNotBlank(bo.getAttendingPhysician()), MmpLedgerPatientFullCycle::getAttendingPhysician, bo.getAttendingPhysician());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagnosis()), MmpLedgerPatientFullCycle::getDiagnosis, bo.getDiagnosis());
        lqw.eq(StringUtils.isNotBlank(bo.getTreatmentRecords()), MmpLedgerPatientFullCycle::getTreatmentRecords, bo.getTreatmentRecords());
        lqw.eq(StringUtils.isNotBlank(bo.getExaminationResults()), MmpLedgerPatientFullCycle::getExaminationResults, bo.getExaminationResults());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicationRecords()), MmpLedgerPatientFullCycle::getMedicationRecords, bo.getMedicationRecords());
        lqw.eq(StringUtils.isNotBlank(bo.getFollowUpRecords()), MmpLedgerPatientFullCycle::getFollowUpRecords, bo.getFollowUpRecords());
        lqw.eq(StringUtils.isNotBlank(bo.getOutcome()), MmpLedgerPatientFullCycle::getOutcome, bo.getOutcome());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalEvaluation()), MmpLedgerPatientFullCycle::getMedicalEvaluation, bo.getMedicalEvaluation());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpLedgerPatientFullCycle::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增患者医疗全周期信息管理
     *
     * @param bo 患者医疗全周期信息管理
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpLedgerPatientFullCycleBo bo) {
        MmpLedgerPatientFullCycle add = MapstructUtils.convert(bo, MmpLedgerPatientFullCycle.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改患者医疗全周期信息管理
     *
     * @param bo 患者医疗全周期信息管理
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpLedgerPatientFullCycleBo bo) {
        MmpLedgerPatientFullCycle update = MapstructUtils.convert(bo, MmpLedgerPatientFullCycle.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpLedgerPatientFullCycle entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除患者医疗全周期信息管理信息
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
