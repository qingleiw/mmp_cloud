package org.dromara.cdi.mmp.radiation.service.impl;

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
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationTrainingPlanBo;
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationTrainingPlanVo;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationTrainingPlan;
import org.dromara.cdi.mmp.radiation.mapper.MmpRadiationTrainingPlanMapper;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationTrainingPlanService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 职业健康培训计划Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpRadiationTrainingPlanServiceImpl implements IMmpRadiationTrainingPlanService {

    private final MmpRadiationTrainingPlanMapper baseMapper;

    /**
     * 查询职业健康培训计划
     *
     * @param id 主键
     * @return 职业健康培训计划
     */
    @Override
    public MmpRadiationTrainingPlanVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询职业健康培训计划列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 职业健康培训计划分页列表
     */
    @Override
    public TableDataInfo<MmpRadiationTrainingPlanVo> queryPageList(MmpRadiationTrainingPlanBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpRadiationTrainingPlan> lqw = buildQueryWrapper(bo);
        Page<MmpRadiationTrainingPlanVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的职业健康培训计划列表
     *
     * @param bo 查询条件
     * @return 职业健康培训计划列表
     */
    @Override
    public List<MmpRadiationTrainingPlanVo> queryList(MmpRadiationTrainingPlanBo bo) {
        LambdaQueryWrapper<MmpRadiationTrainingPlan> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpRadiationTrainingPlan> buildQueryWrapper(MmpRadiationTrainingPlanBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpRadiationTrainingPlan> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpRadiationTrainingPlan::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPlanCode()), MmpRadiationTrainingPlan::getPlanCode, bo.getPlanCode());
        lqw.like(StringUtils.isNotBlank(bo.getPlanName()), MmpRadiationTrainingPlan::getPlanName, bo.getPlanName());
        lqw.eq(StringUtils.isNotBlank(bo.getTrainingType()), MmpRadiationTrainingPlan::getTrainingType, bo.getTrainingType());
        lqw.eq(bo.getPlannedDate() != null, MmpRadiationTrainingPlan::getPlannedDate, bo.getPlannedDate());
        lqw.eq(bo.getPlannedTime() != null, MmpRadiationTrainingPlan::getPlannedTime, bo.getPlannedTime());
        lqw.eq(StringUtils.isNotBlank(bo.getLocation()), MmpRadiationTrainingPlan::getLocation, bo.getLocation());
        lqw.eq(StringUtils.isNotBlank(bo.getTrainer()), MmpRadiationTrainingPlan::getTrainer, bo.getTrainer());
        lqw.eq(StringUtils.isNotBlank(bo.getTrainingContent()), MmpRadiationTrainingPlan::getTrainingContent, bo.getTrainingContent());
        lqw.eq(StringUtils.isNotBlank(bo.getTargetAudience()), MmpRadiationTrainingPlan::getTargetAudience, bo.getTargetAudience());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpRadiationTrainingPlan::getStatus, bo.getStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getReminderSent()), MmpRadiationTrainingPlan::getReminderSent, bo.getReminderSent());
        lqw.eq(bo.getReminderTime() != null, MmpRadiationTrainingPlan::getReminderTime, bo.getReminderTime());
        return lqw;
    }

    /**
     * 新增职业健康培训计划
     *
     * @param bo 职业健康培训计划
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpRadiationTrainingPlanBo bo) {
        MmpRadiationTrainingPlan add = MapstructUtils.convert(bo, MmpRadiationTrainingPlan.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改职业健康培训计划
     *
     * @param bo 职业健康培训计划
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpRadiationTrainingPlanBo bo) {
        MmpRadiationTrainingPlan update = MapstructUtils.convert(bo, MmpRadiationTrainingPlan.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpRadiationTrainingPlan entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除职业健康培训计划信息
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
