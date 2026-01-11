package org.dromara.cdi.mmp.qc.service.impl;

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
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcScoringRuleBo;
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcScoringRuleVo;
import org.dromara.cdi.mmp.qc.domain.MmpQcScoringRule;
import org.dromara.cdi.mmp.qc.mapper.MmpQcScoringRuleMapper;
import org.dromara.cdi.mmp.qc.service.IMmpQcScoringRuleService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 评分规则Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQcScoringRuleServiceImpl implements IMmpQcScoringRuleService {

    private final MmpQcScoringRuleMapper baseMapper;

    /**
     * 查询评分规则
     *
     * @param id 主键
     * @return 评分规则
     */
    @Override
    public MmpQcScoringRuleVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询评分规则列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 评分规则分页列表
     */
    @Override
    public TableDataInfo<MmpQcScoringRuleVo> queryPageList(MmpQcScoringRuleBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQcScoringRule> lqw = buildQueryWrapper(bo);
        Page<MmpQcScoringRuleVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的评分规则列表
     *
     * @param bo 查询条件
     * @return 评分规则列表
     */
    @Override
    public List<MmpQcScoringRuleVo> queryList(MmpQcScoringRuleBo bo) {
        LambdaQueryWrapper<MmpQcScoringRule> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQcScoringRule> buildQueryWrapper(MmpQcScoringRuleBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQcScoringRule> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQcScoringRule::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getRuleType()), MmpQcScoringRule::getRuleType, bo.getRuleType());
        lqw.eq(bo.getMinValue() != null, MmpQcScoringRule::getMinValue, bo.getMinValue());
        lqw.eq(bo.getMaxValue() != null, MmpQcScoringRule::getMaxValue, bo.getMaxValue());
        lqw.eq(bo.getScore() != null, MmpQcScoringRule::getScore, bo.getScore());
        lqw.eq(bo.getScoreRate() != null, MmpQcScoringRule::getScoreRate, bo.getScoreRate());
        lqw.eq(StringUtils.isNotBlank(bo.getDescription()), MmpQcScoringRule::getDescription, bo.getDescription());
        lqw.eq(bo.getSortOrder() != null, MmpQcScoringRule::getSortOrder, bo.getSortOrder());
        lqw.eq(bo.getStatus() != null, MmpQcScoringRule::getStatus, bo.getStatus());
        lqw.eq(bo.getDelFlag() != null, MmpQcScoringRule::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增评分规则
     *
     * @param bo 评分规则
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQcScoringRuleBo bo) {
        MmpQcScoringRule add = MapstructUtils.convert(bo, MmpQcScoringRule.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改评分规则
     *
     * @param bo 评分规则
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQcScoringRuleBo bo) {
        MmpQcScoringRule update = MapstructUtils.convert(bo, MmpQcScoringRule.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQcScoringRule entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除评分规则信息
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
