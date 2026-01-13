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
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerUnplannedReoperationBo;
import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerUnplannedReoperationVo;
import org.dromara.cdi.mmp.ledger.domain.MmpLedgerUnplannedReoperation;
import org.dromara.cdi.mmp.ledger.mapper.MmpLedgerUnplannedReoperationMapper;
import org.dromara.cdi.mmp.ledger.service.IMmpLedgerUnplannedReoperationService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 非计划再次手术登记本Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpLedgerUnplannedReoperationServiceImpl implements IMmpLedgerUnplannedReoperationService {

    private final MmpLedgerUnplannedReoperationMapper baseMapper;

    /**
     * 查询非计划再次手术登记本
     *
     * @param id 主键
     * @return 非计划再次手术登记本
     */
    @Override
    public MmpLedgerUnplannedReoperationVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询非计划再次手术登记本列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 非计划再次手术登记本分页列表
     */
    @Override
    public TableDataInfo<MmpLedgerUnplannedReoperationVo> queryPageList(MmpLedgerUnplannedReoperationBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpLedgerUnplannedReoperation> lqw = buildQueryWrapper(bo);
        Page<MmpLedgerUnplannedReoperationVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的非计划再次手术登记本列表
     *
     * @param bo 查询条件
     * @return 非计划再次手术登记本列表
     */
    @Override
    public List<MmpLedgerUnplannedReoperationVo> queryList(MmpLedgerUnplannedReoperationBo bo) {
        LambdaQueryWrapper<MmpLedgerUnplannedReoperation> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpLedgerUnplannedReoperation> buildQueryWrapper(MmpLedgerUnplannedReoperationBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpLedgerUnplannedReoperation> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpLedgerUnplannedReoperation::getId);
        lqw.like(StringUtils.isNotBlank(bo.getPatientName()), MmpLedgerUnplannedReoperation::getPatientName, bo.getPatientName());
        lqw.eq(bo.getFirstOperationDate() != null, MmpLedgerUnplannedReoperation::getFirstOperationDate, bo.getFirstOperationDate());
        lqw.eq(bo.getReoperationDate() != null, MmpLedgerUnplannedReoperation::getReoperationDate, bo.getReoperationDate());
        lqw.eq(StringUtils.isNotBlank(bo.getDepartment()), MmpLedgerUnplannedReoperation::getDepartment, bo.getDepartment());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeon()), MmpLedgerUnplannedReoperation::getSurgeon, bo.getSurgeon());
        lqw.like(StringUtils.isNotBlank(bo.getFirstOperationName()), MmpLedgerUnplannedReoperation::getFirstOperationName, bo.getFirstOperationName());
        lqw.like(StringUtils.isNotBlank(bo.getReoperationName()), MmpLedgerUnplannedReoperation::getReoperationName, bo.getReoperationName());
        lqw.eq(StringUtils.isNotBlank(bo.getReoperationReason()), MmpLedgerUnplannedReoperation::getReoperationReason, bo.getReoperationReason());
        lqw.eq(StringUtils.isNotBlank(bo.getComplications()), MmpLedgerUnplannedReoperation::getComplications, bo.getComplications());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalEvaluation()), MmpLedgerUnplannedReoperation::getMedicalEvaluation, bo.getMedicalEvaluation());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpLedgerUnplannedReoperation::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增非计划再次手术登记本
     *
     * @param bo 非计划再次手术登记本
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpLedgerUnplannedReoperationBo bo) {
        MmpLedgerUnplannedReoperation add = MapstructUtils.convert(bo, MmpLedgerUnplannedReoperation.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改非计划再次手术登记本
     *
     * @param bo 非计划再次手术登记本
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpLedgerUnplannedReoperationBo bo) {
        MmpLedgerUnplannedReoperation update = MapstructUtils.convert(bo, MmpLedgerUnplannedReoperation.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpLedgerUnplannedReoperation entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除非计划再次手术登记本信息
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
