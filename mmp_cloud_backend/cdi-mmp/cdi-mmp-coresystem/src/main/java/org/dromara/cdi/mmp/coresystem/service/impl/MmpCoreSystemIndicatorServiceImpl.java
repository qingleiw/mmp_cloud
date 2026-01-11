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
import org.dromara.cdi.mmp.coresystem.domain.bo.MmpCoreSystemIndicatorBo;
import org.dromara.cdi.mmp.coresystem.domain.vo.MmpCoreSystemIndicatorVo;
import org.dromara.cdi.mmp.coresystem.domain.MmpCoreSystemIndicator;
import org.dromara.cdi.mmp.coresystem.mapper.MmpCoreSystemIndicatorMapper;
import org.dromara.cdi.mmp.coresystem.service.IMmpCoreSystemIndicatorService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 核心制度指标Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpCoreSystemIndicatorServiceImpl implements IMmpCoreSystemIndicatorService {

    private final MmpCoreSystemIndicatorMapper baseMapper;

    /**
     * 查询核心制度指标
     *
     * @param id 主键
     * @return 核心制度指标
     */
    @Override
    public MmpCoreSystemIndicatorVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询核心制度指标列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 核心制度指标分页列表
     */
    @Override
    public TableDataInfo<MmpCoreSystemIndicatorVo> queryPageList(MmpCoreSystemIndicatorBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpCoreSystemIndicator> lqw = buildQueryWrapper(bo);
        Page<MmpCoreSystemIndicatorVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的核心制度指标列表
     *
     * @param bo 查询条件
     * @return 核心制度指标列表
     */
    @Override
    public List<MmpCoreSystemIndicatorVo> queryList(MmpCoreSystemIndicatorBo bo) {
        LambdaQueryWrapper<MmpCoreSystemIndicator> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpCoreSystemIndicator> buildQueryWrapper(MmpCoreSystemIndicatorBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpCoreSystemIndicator> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpCoreSystemIndicator::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getIndicatorCode()), MmpCoreSystemIndicator::getIndicatorCode, bo.getIndicatorCode());
        lqw.like(StringUtils.isNotBlank(bo.getIndicatorName()), MmpCoreSystemIndicator::getIndicatorName, bo.getIndicatorName());
        lqw.eq(bo.getSystemId() != null, MmpCoreSystemIndicator::getSystemId, bo.getSystemId());
        lqw.eq(bo.getParentId() != null, MmpCoreSystemIndicator::getParentId, bo.getParentId());
        lqw.eq(StringUtils.isNotBlank(bo.getIndicatorType()), MmpCoreSystemIndicator::getIndicatorType, bo.getIndicatorType());
        lqw.eq(StringUtils.isNotBlank(bo.getCalculationFormula()), MmpCoreSystemIndicator::getCalculationFormula, bo.getCalculationFormula());
        lqw.eq(StringUtils.isNotBlank(bo.getCalculationCycle()), MmpCoreSystemIndicator::getCalculationCycle, bo.getCalculationCycle());
        lqw.eq(StringUtils.isNotBlank(bo.getDataSource()), MmpCoreSystemIndicator::getDataSource, bo.getDataSource());
        lqw.eq(StringUtils.isNotBlank(bo.getTargetValue()), MmpCoreSystemIndicator::getTargetValue, bo.getTargetValue());
        lqw.eq(bo.getIndicatorScore() != null, MmpCoreSystemIndicator::getIndicatorScore, bo.getIndicatorScore());
        lqw.eq(bo.getIsReverse() != null, MmpCoreSystemIndicator::getIsReverse, bo.getIsReverse());
        lqw.eq(StringUtils.isNotBlank(bo.getAlertThreshold()), MmpCoreSystemIndicator::getAlertThreshold, bo.getAlertThreshold());
        lqw.eq(bo.getIsEnabled() != null, MmpCoreSystemIndicator::getIsEnabled, bo.getIsEnabled());
        lqw.eq(bo.getIsCustom() != null, MmpCoreSystemIndicator::getIsCustom, bo.getIsCustom());
        lqw.eq(bo.getDelFlag() != null, MmpCoreSystemIndicator::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增核心制度指标
     *
     * @param bo 核心制度指标
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpCoreSystemIndicatorBo bo) {
        MmpCoreSystemIndicator add = MapstructUtils.convert(bo, MmpCoreSystemIndicator.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改核心制度指标
     *
     * @param bo 核心制度指标
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpCoreSystemIndicatorBo bo) {
        MmpCoreSystemIndicator update = MapstructUtils.convert(bo, MmpCoreSystemIndicator.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpCoreSystemIndicator entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除核心制度指标信息
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
