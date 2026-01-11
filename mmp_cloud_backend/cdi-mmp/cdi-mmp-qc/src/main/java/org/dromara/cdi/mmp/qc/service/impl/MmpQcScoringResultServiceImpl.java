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
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcScoringResultBo;
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcScoringResultVo;
import org.dromara.cdi.mmp.qc.domain.MmpQcScoringResult;
import org.dromara.cdi.mmp.qc.mapper.MmpQcScoringResultMapper;
import org.dromara.cdi.mmp.qc.service.IMmpQcScoringResultService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 评分结果Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQcScoringResultServiceImpl implements IMmpQcScoringResultService {

    private final MmpQcScoringResultMapper baseMapper;

    /**
     * 查询评分结果
     *
     * @param id 主键
     * @return 评分结果
     */
    @Override
    public MmpQcScoringResultVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询评分结果列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 评分结果分页列表
     */
    @Override
    public TableDataInfo<MmpQcScoringResultVo> queryPageList(MmpQcScoringResultBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQcScoringResult> lqw = buildQueryWrapper(bo);
        Page<MmpQcScoringResultVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的评分结果列表
     *
     * @param bo 查询条件
     * @return 评分结果列表
     */
    @Override
    public List<MmpQcScoringResultVo> queryList(MmpQcScoringResultBo bo) {
        LambdaQueryWrapper<MmpQcScoringResult> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQcScoringResult> buildQueryWrapper(MmpQcScoringResultBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQcScoringResult> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQcScoringResult::getId);
        lqw.eq(bo.getIndicatorValue() != null, MmpQcScoringResult::getIndicatorValue, bo.getIndicatorValue());
        lqw.eq(bo.getStandardValue() != null, MmpQcScoringResult::getStandardValue, bo.getStandardValue());
        lqw.eq(bo.getMaxScore() != null, MmpQcScoringResult::getMaxScore, bo.getMaxScore());
        lqw.eq(bo.getActualScore() != null, MmpQcScoringResult::getActualScore, bo.getActualScore());
        lqw.eq(bo.getScoreRate() != null, MmpQcScoringResult::getScoreRate, bo.getScoreRate());
        lqw.eq(StringUtils.isNotBlank(bo.getEvaluationLevel()), MmpQcScoringResult::getEvaluationLevel, bo.getEvaluationLevel());
        lqw.eq(bo.getCalculateTime() != null, MmpQcScoringResult::getCalculateTime, bo.getCalculateTime());
        lqw.eq(bo.getDelFlag() != null, MmpQcScoringResult::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增评分结果
     *
     * @param bo 评分结果
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQcScoringResultBo bo) {
        MmpQcScoringResult add = MapstructUtils.convert(bo, MmpQcScoringResult.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改评分结果
     *
     * @param bo 评分结果
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQcScoringResultBo bo) {
        MmpQcScoringResult update = MapstructUtils.convert(bo, MmpQcScoringResult.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQcScoringResult entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除评分结果信息
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
