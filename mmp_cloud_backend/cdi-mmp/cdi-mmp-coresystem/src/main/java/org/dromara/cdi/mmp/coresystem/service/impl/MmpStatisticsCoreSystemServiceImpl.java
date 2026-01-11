package org.dromara.cdi.mmp.coresystem.service.impl;

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
import org.dromara.cdi.mmp.coresystem.domain.bo.MmpStatisticsCoreSystemBo;
import org.dromara.cdi.mmp.coresystem.domain.vo.MmpStatisticsCoreSystemVo;
import org.dromara.cdi.mmp.coresystem.domain.MmpStatisticsCoreSystem;
import org.dromara.cdi.mmp.coresystem.mapper.MmpStatisticsCoreSystemMapper;
import org.dromara.cdi.mmp.coresystem.service.IMmpStatisticsCoreSystemService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 核心制度落实情况监测Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpStatisticsCoreSystemServiceImpl implements IMmpStatisticsCoreSystemService {

    private final MmpStatisticsCoreSystemMapper baseMapper;

    /**
     * 查询核心制度落实情况监测
     *
     * @param id 主键
     * @return 核心制度落实情况监测
     */
    @Override
    public MmpStatisticsCoreSystemVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询核心制度落实情况监测列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 核心制度落实情况监测分页列表
     */
    @Override
    public TableDataInfo<MmpStatisticsCoreSystemVo> queryPageList(MmpStatisticsCoreSystemBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpStatisticsCoreSystem> lqw = buildQueryWrapper(bo);
        Page<MmpStatisticsCoreSystemVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的核心制度落实情况监测列表
     *
     * @param bo 查询条件
     * @return 核心制度落实情况监测列表
     */
    @Override
    public List<MmpStatisticsCoreSystemVo> queryList(MmpStatisticsCoreSystemBo bo) {
        LambdaQueryWrapper<MmpStatisticsCoreSystem> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpStatisticsCoreSystem> buildQueryWrapper(MmpStatisticsCoreSystemBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpStatisticsCoreSystem> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpStatisticsCoreSystem::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getSystemCode()), MmpStatisticsCoreSystem::getSystemCode, bo.getSystemCode());
        lqw.like(StringUtils.isNotBlank(bo.getSystemName()), MmpStatisticsCoreSystem::getSystemName, bo.getSystemName());
        lqw.eq(StringUtils.isNotBlank(bo.getDepartment()), MmpStatisticsCoreSystem::getDepartment, bo.getDepartment());
        lqw.eq(bo.getMonitoringDate() != null, MmpStatisticsCoreSystem::getMonitoringDate, bo.getMonitoringDate());
        lqw.eq(bo.getComplianceRate() != null, MmpStatisticsCoreSystem::getComplianceRate, bo.getComplianceRate());
        lqw.eq(bo.getExecutionCount() != null, MmpStatisticsCoreSystem::getExecutionCount, bo.getExecutionCount());
        lqw.eq(bo.getQualifiedCount() != null, MmpStatisticsCoreSystem::getQualifiedCount, bo.getQualifiedCount());
        lqw.eq(StringUtils.isNotBlank(bo.getIssuesFound()), MmpStatisticsCoreSystem::getIssuesFound, bo.getIssuesFound());
        lqw.eq(StringUtils.isNotBlank(bo.getImprovementMeasures()), MmpStatisticsCoreSystem::getImprovementMeasures, bo.getImprovementMeasures());
        lqw.eq(bo.getNextMonitoringDate() != null, MmpStatisticsCoreSystem::getNextMonitoringDate, bo.getNextMonitoringDate());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpStatisticsCoreSystem::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增核心制度落实情况监测
     *
     * @param bo 核心制度落实情况监测
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpStatisticsCoreSystemBo bo) {
        MmpStatisticsCoreSystem add = MapstructUtils.convert(bo, MmpStatisticsCoreSystem.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改核心制度落实情况监测
     *
     * @param bo 核心制度落实情况监测
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpStatisticsCoreSystemBo bo) {
        MmpStatisticsCoreSystem update = MapstructUtils.convert(bo, MmpStatisticsCoreSystem.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpStatisticsCoreSystem entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除核心制度落实情况监测信息
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
