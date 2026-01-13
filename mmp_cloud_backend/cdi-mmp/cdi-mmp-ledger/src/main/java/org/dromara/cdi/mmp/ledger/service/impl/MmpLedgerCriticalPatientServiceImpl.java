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
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerCriticalPatientBo;
import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerCriticalPatientVo;
import org.dromara.cdi.mmp.ledger.domain.MmpLedgerCriticalPatient;
import org.dromara.cdi.mmp.ledger.mapper.MmpLedgerCriticalPatientMapper;
import org.dromara.cdi.mmp.ledger.service.IMmpLedgerCriticalPatientService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 危重病人抢救登记本Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpLedgerCriticalPatientServiceImpl implements IMmpLedgerCriticalPatientService {

    private final MmpLedgerCriticalPatientMapper baseMapper;

    /**
     * 查询危重病人抢救登记本
     *
     * @param id 主键
     * @return 危重病人抢救登记本
     */
    @Override
    public MmpLedgerCriticalPatientVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询危重病人抢救登记本列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 危重病人抢救登记本分页列表
     */
    @Override
    public TableDataInfo<MmpLedgerCriticalPatientVo> queryPageList(MmpLedgerCriticalPatientBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpLedgerCriticalPatient> lqw = buildQueryWrapper(bo);
        Page<MmpLedgerCriticalPatientVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的危重病人抢救登记本列表
     *
     * @param bo 查询条件
     * @return 危重病人抢救登记本列表
     */
    @Override
    public List<MmpLedgerCriticalPatientVo> queryList(MmpLedgerCriticalPatientBo bo) {
        LambdaQueryWrapper<MmpLedgerCriticalPatient> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpLedgerCriticalPatient> buildQueryWrapper(MmpLedgerCriticalPatientBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpLedgerCriticalPatient> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpLedgerCriticalPatient::getId);
        lqw.like(StringUtils.isNotBlank(bo.getPatientName()), MmpLedgerCriticalPatient::getPatientName, bo.getPatientName());
        lqw.eq(bo.getAdmissionDate() != null, MmpLedgerCriticalPatient::getAdmissionDate, bo.getAdmissionDate());
        lqw.eq(bo.getRescueDate() != null, MmpLedgerCriticalPatient::getRescueDate, bo.getRescueDate());
        lqw.eq(StringUtils.isNotBlank(bo.getDepartment()), MmpLedgerCriticalPatient::getDepartment, bo.getDepartment());
        lqw.eq(StringUtils.isNotBlank(bo.getRescuePhysician()), MmpLedgerCriticalPatient::getRescuePhysician, bo.getRescuePhysician());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagnosis()), MmpLedgerCriticalPatient::getDiagnosis, bo.getDiagnosis());
        lqw.eq(StringUtils.isNotBlank(bo.getRescueReason()), MmpLedgerCriticalPatient::getRescueReason, bo.getRescueReason());
        lqw.eq(StringUtils.isNotBlank(bo.getRescueMeasures()), MmpLedgerCriticalPatient::getRescueMeasures, bo.getRescueMeasures());
        lqw.eq(bo.getRescueDuration() != null, MmpLedgerCriticalPatient::getRescueDuration, bo.getRescueDuration());
        lqw.eq(StringUtils.isNotBlank(bo.getRescueOutcome()), MmpLedgerCriticalPatient::getRescueOutcome, bo.getRescueOutcome());
        lqw.eq(StringUtils.isNotBlank(bo.getComplications()), MmpLedgerCriticalPatient::getComplications, bo.getComplications());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalEvaluation()), MmpLedgerCriticalPatient::getMedicalEvaluation, bo.getMedicalEvaluation());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpLedgerCriticalPatient::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增危重病人抢救登记本
     *
     * @param bo 危重病人抢救登记本
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpLedgerCriticalPatientBo bo) {
        MmpLedgerCriticalPatient add = MapstructUtils.convert(bo, MmpLedgerCriticalPatient.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改危重病人抢救登记本
     *
     * @param bo 危重病人抢救登记本
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpLedgerCriticalPatientBo bo) {
        MmpLedgerCriticalPatient update = MapstructUtils.convert(bo, MmpLedgerCriticalPatient.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpLedgerCriticalPatient entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除危重病人抢救登记本信息
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
