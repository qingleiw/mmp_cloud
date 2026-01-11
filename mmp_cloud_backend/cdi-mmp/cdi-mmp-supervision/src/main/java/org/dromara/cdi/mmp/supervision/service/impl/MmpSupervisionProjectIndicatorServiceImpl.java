package org.dromara.cdi.mmp.supervision.service.impl;

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
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionProjectIndicatorBo;
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionProjectIndicatorVo;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionProjectIndicator;
import org.dromara.cdi.mmp.supervision.mapper.MmpSupervisionProjectIndicatorMapper;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionProjectIndicatorService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 督查项目指标Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSupervisionProjectIndicatorServiceImpl implements IMmpSupervisionProjectIndicatorService {

    private final MmpSupervisionProjectIndicatorMapper baseMapper;

    /**
     * 查询督查项目指标
     *
     * @param id 主键
     * @return 督查项目指标
     */
    @Override
    public MmpSupervisionProjectIndicatorVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询督查项目指标列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查项目指标分页列表
     */
    @Override
    public TableDataInfo<MmpSupervisionProjectIndicatorVo> queryPageList(MmpSupervisionProjectIndicatorBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSupervisionProjectIndicator> lqw = buildQueryWrapper(bo);
        Page<MmpSupervisionProjectIndicatorVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的督查项目指标列表
     *
     * @param bo 查询条件
     * @return 督查项目指标列表
     */
    @Override
    public List<MmpSupervisionProjectIndicatorVo> queryList(MmpSupervisionProjectIndicatorBo bo) {
        LambdaQueryWrapper<MmpSupervisionProjectIndicator> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSupervisionProjectIndicator> buildQueryWrapper(MmpSupervisionProjectIndicatorBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSupervisionProjectIndicator> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSupervisionProjectIndicator::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getIndicatorCode()), MmpSupervisionProjectIndicator::getIndicatorCode, bo.getIndicatorCode());
        lqw.like(StringUtils.isNotBlank(bo.getIndicatorName()), MmpSupervisionProjectIndicator::getIndicatorName, bo.getIndicatorName());
        lqw.eq(StringUtils.isNotBlank(bo.getIndicatorType()), MmpSupervisionProjectIndicator::getIndicatorType, bo.getIndicatorType());
        lqw.eq(StringUtils.isNotBlank(bo.getIndicatorDescription()), MmpSupervisionProjectIndicator::getIndicatorDescription, bo.getIndicatorDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getScoringStandard()), MmpSupervisionProjectIndicator::getScoringStandard, bo.getScoringStandard());
        lqw.eq(bo.getWeight() != null, MmpSupervisionProjectIndicator::getWeight, bo.getWeight());
        lqw.eq(bo.getMaxScore() != null, MmpSupervisionProjectIndicator::getMaxScore, bo.getMaxScore());
        lqw.eq(bo.getSortOrder() != null, MmpSupervisionProjectIndicator::getSortOrder, bo.getSortOrder());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpSupervisionProjectIndicator::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增督查项目指标
     *
     * @param bo 督查项目指标
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSupervisionProjectIndicatorBo bo) {
        MmpSupervisionProjectIndicator add = MapstructUtils.convert(bo, MmpSupervisionProjectIndicator.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改督查项目指标
     *
     * @param bo 督查项目指标
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSupervisionProjectIndicatorBo bo) {
        MmpSupervisionProjectIndicator update = MapstructUtils.convert(bo, MmpSupervisionProjectIndicator.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSupervisionProjectIndicator entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除督查项目指标信息
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
