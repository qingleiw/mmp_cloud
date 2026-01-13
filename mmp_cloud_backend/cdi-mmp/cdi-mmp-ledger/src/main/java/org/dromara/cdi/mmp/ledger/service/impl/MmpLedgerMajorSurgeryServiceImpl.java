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
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerMajorSurgeryBo;
import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerMajorSurgeryVo;
import org.dromara.cdi.mmp.ledger.domain.MmpLedgerMajorSurgery;
import org.dromara.cdi.mmp.ledger.mapper.MmpLedgerMajorSurgeryMapper;
import org.dromara.cdi.mmp.ledger.service.IMmpLedgerMajorSurgeryService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 重大疑难手术监测与管理Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpLedgerMajorSurgeryServiceImpl implements IMmpLedgerMajorSurgeryService {

    private final MmpLedgerMajorSurgeryMapper baseMapper;

    /**
     * 查询重大疑难手术监测与管理
     *
     * @param id 主键
     * @return 重大疑难手术监测与管理
     */
    @Override
    public MmpLedgerMajorSurgeryVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询重大疑难手术监测与管理列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 重大疑难手术监测与管理分页列表
     */
    @Override
    public TableDataInfo<MmpLedgerMajorSurgeryVo> queryPageList(MmpLedgerMajorSurgeryBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpLedgerMajorSurgery> lqw = buildQueryWrapper(bo);
        Page<MmpLedgerMajorSurgeryVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的重大疑难手术监测与管理列表
     *
     * @param bo 查询条件
     * @return 重大疑难手术监测与管理列表
     */
    @Override
    public List<MmpLedgerMajorSurgeryVo> queryList(MmpLedgerMajorSurgeryBo bo) {
        LambdaQueryWrapper<MmpLedgerMajorSurgery> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpLedgerMajorSurgery> buildQueryWrapper(MmpLedgerMajorSurgeryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpLedgerMajorSurgery> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpLedgerMajorSurgery::getId);
        lqw.like(StringUtils.isNotBlank(bo.getPatientName()), MmpLedgerMajorSurgery::getPatientName, bo.getPatientName());
        lqw.eq(bo.getOperationDate() != null, MmpLedgerMajorSurgery::getOperationDate, bo.getOperationDate());
        lqw.eq(StringUtils.isNotBlank(bo.getDepartment()), MmpLedgerMajorSurgery::getDepartment, bo.getDepartment());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeon()), MmpLedgerMajorSurgery::getSurgeon, bo.getSurgeon());
        lqw.like(StringUtils.isNotBlank(bo.getOperationName()), MmpLedgerMajorSurgery::getOperationName, bo.getOperationName());
        lqw.eq(StringUtils.isNotBlank(bo.getOperationLevel()), MmpLedgerMajorSurgery::getOperationLevel, bo.getOperationLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getPreoperativeDiagnosis()), MmpLedgerMajorSurgery::getPreoperativeDiagnosis, bo.getPreoperativeDiagnosis());
        lqw.eq(StringUtils.isNotBlank(bo.getPostoperativeDiagnosis()), MmpLedgerMajorSurgery::getPostoperativeDiagnosis, bo.getPostoperativeDiagnosis());
        lqw.eq(bo.getOperationDuration() != null, MmpLedgerMajorSurgery::getOperationDuration, bo.getOperationDuration());
        lqw.eq(StringUtils.isNotBlank(bo.getAnesthesiaMethod()), MmpLedgerMajorSurgery::getAnesthesiaMethod, bo.getAnesthesiaMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getComplications()), MmpLedgerMajorSurgery::getComplications, bo.getComplications());
        lqw.eq(StringUtils.isNotBlank(bo.getOutcome()), MmpLedgerMajorSurgery::getOutcome, bo.getOutcome());
        lqw.eq(StringUtils.isNotBlank(bo.getFollowUpResults()), MmpLedgerMajorSurgery::getFollowUpResults, bo.getFollowUpResults());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalEvaluation()), MmpLedgerMajorSurgery::getMedicalEvaluation, bo.getMedicalEvaluation());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpLedgerMajorSurgery::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增重大疑难手术监测与管理
     *
     * @param bo 重大疑难手术监测与管理
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpLedgerMajorSurgeryBo bo) {
        MmpLedgerMajorSurgery add = MapstructUtils.convert(bo, MmpLedgerMajorSurgery.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改重大疑难手术监测与管理
     *
     * @param bo 重大疑难手术监测与管理
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpLedgerMajorSurgeryBo bo) {
        MmpLedgerMajorSurgery update = MapstructUtils.convert(bo, MmpLedgerMajorSurgery.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpLedgerMajorSurgery entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除重大疑难手术监测与管理信息
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
