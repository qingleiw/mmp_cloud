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
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerLongStayPatientBo;
import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerLongStayPatientVo;
import org.dromara.cdi.mmp.ledger.domain.MmpLedgerLongStayPatient;
import org.dromara.cdi.mmp.ledger.mapper.MmpLedgerLongStayPatientMapper;
import org.dromara.cdi.mmp.ledger.service.IMmpLedgerLongStayPatientService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 住院超30天患者登记本Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpLedgerLongStayPatientServiceImpl implements IMmpLedgerLongStayPatientService {

    private final MmpLedgerLongStayPatientMapper baseMapper;

    /**
     * 查询住院超30天患者登记本
     *
     * @param id 主键
     * @return 住院超30天患者登记本
     */
    @Override
    public MmpLedgerLongStayPatientVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询住院超30天患者登记本列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 住院超30天患者登记本分页列表
     */
    @Override
    public TableDataInfo<MmpLedgerLongStayPatientVo> queryPageList(MmpLedgerLongStayPatientBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpLedgerLongStayPatient> lqw = buildQueryWrapper(bo);
        Page<MmpLedgerLongStayPatientVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的住院超30天患者登记本列表
     *
     * @param bo 查询条件
     * @return 住院超30天患者登记本列表
     */
    @Override
    public List<MmpLedgerLongStayPatientVo> queryList(MmpLedgerLongStayPatientBo bo) {
        LambdaQueryWrapper<MmpLedgerLongStayPatient> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpLedgerLongStayPatient> buildQueryWrapper(MmpLedgerLongStayPatientBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpLedgerLongStayPatient> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpLedgerLongStayPatient::getId);
        lqw.like(StringUtils.isNotBlank(bo.getPatientName()), MmpLedgerLongStayPatient::getPatientName, bo.getPatientName());
        lqw.eq(bo.getAdmissionDate() != null, MmpLedgerLongStayPatient::getAdmissionDate, bo.getAdmissionDate());
        lqw.eq(bo.getDischargeDate() != null, MmpLedgerLongStayPatient::getDischargeDate, bo.getDischargeDate());
        lqw.eq(bo.getHospitalDays() != null, MmpLedgerLongStayPatient::getHospitalDays, bo.getHospitalDays());
        lqw.eq(StringUtils.isNotBlank(bo.getDepartment()), MmpLedgerLongStayPatient::getDepartment, bo.getDepartment());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagnosis()), MmpLedgerLongStayPatient::getDiagnosis, bo.getDiagnosis());
        lqw.eq(StringUtils.isNotBlank(bo.getTreatmentPlan()), MmpLedgerLongStayPatient::getTreatmentPlan, bo.getTreatmentPlan());
        lqw.eq(StringUtils.isNotBlank(bo.getComplications()), MmpLedgerLongStayPatient::getComplications, bo.getComplications());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecialReasons()), MmpLedgerLongStayPatient::getSpecialReasons, bo.getSpecialReasons());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalEvaluation()), MmpLedgerLongStayPatient::getMedicalEvaluation, bo.getMedicalEvaluation());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpLedgerLongStayPatient::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增住院超30天患者登记本
     *
     * @param bo 住院超30天患者登记本
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpLedgerLongStayPatientBo bo) {
        MmpLedgerLongStayPatient add = MapstructUtils.convert(bo, MmpLedgerLongStayPatient.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改住院超30天患者登记本
     *
     * @param bo 住院超30天患者登记本
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpLedgerLongStayPatientBo bo) {
        MmpLedgerLongStayPatient update = MapstructUtils.convert(bo, MmpLedgerLongStayPatient.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpLedgerLongStayPatient entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除住院超30天患者登记本信息
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
