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
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyDrillPlanBo;
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyDrillPlanVo;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyDrillPlan;
import org.dromara.cdi.mmp.emergency.mapper.MmpEmergencyDrillPlanMapper;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyDrillPlanService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 应急演练计划Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpEmergencyDrillPlanServiceImpl implements IMmpEmergencyDrillPlanService {

    private final MmpEmergencyDrillPlanMapper baseMapper;

    /**
     * 查询应急演练计划
     *
     * @param id 主键
     * @return 应急演练计划
     */
    @Override
    public MmpEmergencyDrillPlanVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询应急演练计划列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 应急演练计划分页列表
     */
    @Override
    public TableDataInfo<MmpEmergencyDrillPlanVo> queryPageList(MmpEmergencyDrillPlanBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpEmergencyDrillPlan> lqw = buildQueryWrapper(bo);
        Page<MmpEmergencyDrillPlanVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的应急演练计划列表
     *
     * @param bo 查询条件
     * @return 应急演练计划列表
     */
    @Override
    public List<MmpEmergencyDrillPlanVo> queryList(MmpEmergencyDrillPlanBo bo) {
        LambdaQueryWrapper<MmpEmergencyDrillPlan> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpEmergencyDrillPlan> buildQueryWrapper(MmpEmergencyDrillPlanBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpEmergencyDrillPlan> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpEmergencyDrillPlan::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPlanCode()), MmpEmergencyDrillPlan::getPlanCode, bo.getPlanCode());
        lqw.like(StringUtils.isNotBlank(bo.getPlanName()), MmpEmergencyDrillPlan::getPlanName, bo.getPlanName());
        lqw.eq(StringUtils.isNotBlank(bo.getDrillType()), MmpEmergencyDrillPlan::getDrillType, bo.getDrillType());
        lqw.eq(StringUtils.isNotBlank(bo.getDrillScenario()), MmpEmergencyDrillPlan::getDrillScenario, bo.getDrillScenario());
        lqw.eq(bo.getPlannedDate() != null, MmpEmergencyDrillPlan::getPlannedDate, bo.getPlannedDate());
        lqw.eq(bo.getActualDate() != null, MmpEmergencyDrillPlan::getActualDate, bo.getActualDate());
        lqw.eq(StringUtils.isNotBlank(bo.getLocation()), MmpEmergencyDrillPlan::getLocation, bo.getLocation());
        lqw.eq(StringUtils.isNotBlank(bo.getOrganizer()), MmpEmergencyDrillPlan::getOrganizer, bo.getOrganizer());
        lqw.eq(StringUtils.isNotBlank(bo.getParticipants()), MmpEmergencyDrillPlan::getParticipants, bo.getParticipants());
        lqw.eq(StringUtils.isNotBlank(bo.getObjectives()), MmpEmergencyDrillPlan::getObjectives, bo.getObjectives());
        lqw.eq(StringUtils.isNotBlank(bo.getProcedures()), MmpEmergencyDrillPlan::getProcedures, bo.getProcedures());
        lqw.eq(StringUtils.isNotBlank(bo.getEvaluationCriteria()), MmpEmergencyDrillPlan::getEvaluationCriteria, bo.getEvaluationCriteria());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpEmergencyDrillPlan::getStatus, bo.getStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getDrillResult()), MmpEmergencyDrillPlan::getDrillResult, bo.getDrillResult());
        lqw.eq(StringUtils.isNotBlank(bo.getLessonsLearned()), MmpEmergencyDrillPlan::getLessonsLearned, bo.getLessonsLearned());
        return lqw;
    }

    /**
     * 新增应急演练计划
     *
     * @param bo 应急演练计划
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpEmergencyDrillPlanBo bo) {
        MmpEmergencyDrillPlan add = MapstructUtils.convert(bo, MmpEmergencyDrillPlan.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改应急演练计划
     *
     * @param bo 应急演练计划
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpEmergencyDrillPlanBo bo) {
        MmpEmergencyDrillPlan update = MapstructUtils.convert(bo, MmpEmergencyDrillPlan.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpEmergencyDrillPlan entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除应急演练计划信息
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
