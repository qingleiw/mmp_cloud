package org.dromara.cdi.mmp.emergency.service.impl;

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
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyDrillSummaryBo;
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyDrillSummaryVo;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyDrillSummary;
import org.dromara.cdi.mmp.emergency.mapper.MmpEmergencyDrillSummaryMapper;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyDrillSummaryService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 应急演练总结Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpEmergencyDrillSummaryServiceImpl implements IMmpEmergencyDrillSummaryService {

    private final MmpEmergencyDrillSummaryMapper baseMapper;

    /**
     * 查询应急演练总结
     *
     * @param id 主键
     * @return 应急演练总结
     */
    @Override
    public MmpEmergencyDrillSummaryVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询应急演练总结列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 应急演练总结分页列表
     */
    @Override
    public TableDataInfo<MmpEmergencyDrillSummaryVo> queryPageList(MmpEmergencyDrillSummaryBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpEmergencyDrillSummary> lqw = buildQueryWrapper(bo);
        Page<MmpEmergencyDrillSummaryVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的应急演练总结列表
     *
     * @param bo 查询条件
     * @return 应急演练总结列表
     */
    @Override
    public List<MmpEmergencyDrillSummaryVo> queryList(MmpEmergencyDrillSummaryBo bo) {
        LambdaQueryWrapper<MmpEmergencyDrillSummary> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpEmergencyDrillSummary> buildQueryWrapper(MmpEmergencyDrillSummaryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpEmergencyDrillSummary> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpEmergencyDrillSummary::getId);
        lqw.eq(bo.getActualStartTime() != null, MmpEmergencyDrillSummary::getActualStartTime, bo.getActualStartTime());
        lqw.eq(bo.getActualEndTime() != null, MmpEmergencyDrillSummary::getActualEndTime, bo.getActualEndTime());
        lqw.eq(bo.getParticipantsCount() != null, MmpEmergencyDrillSummary::getParticipantsCount, bo.getParticipantsCount());
        lqw.eq(StringUtils.isNotBlank(bo.getDrillProcess()), MmpEmergencyDrillSummary::getDrillProcess, bo.getDrillProcess());
        lqw.eq(StringUtils.isNotBlank(bo.getProblemsFound()), MmpEmergencyDrillSummary::getProblemsFound, bo.getProblemsFound());
        lqw.eq(StringUtils.isNotBlank(bo.getLessonsLearned()), MmpEmergencyDrillSummary::getLessonsLearned, bo.getLessonsLearned());
        lqw.eq(StringUtils.isNotBlank(bo.getImprovementMeasures()), MmpEmergencyDrillSummary::getImprovementMeasures, bo.getImprovementMeasures());
        lqw.eq(bo.getEvaluationScore() != null, MmpEmergencyDrillSummary::getEvaluationScore, bo.getEvaluationScore());
        lqw.like(StringUtils.isNotBlank(bo.getEvaluatorName()), MmpEmergencyDrillSummary::getEvaluatorName, bo.getEvaluatorName());
        lqw.eq(bo.getEvaluationTime() != null, MmpEmergencyDrillSummary::getEvaluationTime, bo.getEvaluationTime());
        return lqw;
    }

    /**
     * 新增应急演练总结
     *
     * @param bo 应急演练总结
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpEmergencyDrillSummaryBo bo) {
        MmpEmergencyDrillSummary add = MapstructUtils.convert(bo, MmpEmergencyDrillSummary.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改应急演练总结
     *
     * @param bo 应急演练总结
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpEmergencyDrillSummaryBo bo) {
        MmpEmergencyDrillSummary update = MapstructUtils.convert(bo, MmpEmergencyDrillSummary.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpEmergencyDrillSummary entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除应急演练总结信息
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
