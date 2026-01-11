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
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationHealthExamPlanBo;
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationHealthExamPlanVo;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationHealthExamPlan;
import org.dromara.cdi.mmp.radiation.mapper.MmpRadiationHealthExamPlanMapper;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationHealthExamPlanService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 职业健康体检计划Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpRadiationHealthExamPlanServiceImpl implements IMmpRadiationHealthExamPlanService {

    private final MmpRadiationHealthExamPlanMapper baseMapper;

    /**
     * 查询职业健康体检计划
     *
     * @param id 主键
     * @return 职业健康体检计划
     */
    @Override
    public MmpRadiationHealthExamPlanVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询职业健康体检计划列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 职业健康体检计划分页列表
     */
    @Override
    public TableDataInfo<MmpRadiationHealthExamPlanVo> queryPageList(MmpRadiationHealthExamPlanBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpRadiationHealthExamPlan> lqw = buildQueryWrapper(bo);
        Page<MmpRadiationHealthExamPlanVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的职业健康体检计划列表
     *
     * @param bo 查询条件
     * @return 职业健康体检计划列表
     */
    @Override
    public List<MmpRadiationHealthExamPlanVo> queryList(MmpRadiationHealthExamPlanBo bo) {
        LambdaQueryWrapper<MmpRadiationHealthExamPlan> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpRadiationHealthExamPlan> buildQueryWrapper(MmpRadiationHealthExamPlanBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpRadiationHealthExamPlan> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpRadiationHealthExamPlan::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPlanCode()), MmpRadiationHealthExamPlan::getPlanCode, bo.getPlanCode());
        lqw.like(StringUtils.isNotBlank(bo.getPlanName()), MmpRadiationHealthExamPlan::getPlanName, bo.getPlanName());
        lqw.eq(StringUtils.isNotBlank(bo.getExamType()), MmpRadiationHealthExamPlan::getExamType, bo.getExamType());
        lqw.eq(bo.getPlannedDate() != null, MmpRadiationHealthExamPlan::getPlannedDate, bo.getPlannedDate());
        lqw.eq(StringUtils.isNotBlank(bo.getLocation()), MmpRadiationHealthExamPlan::getLocation, bo.getLocation());
        lqw.eq(StringUtils.isNotBlank(bo.getExamAgency()), MmpRadiationHealthExamPlan::getExamAgency, bo.getExamAgency());
        lqw.eq(StringUtils.isNotBlank(bo.getTargetStaff()), MmpRadiationHealthExamPlan::getTargetStaff, bo.getTargetStaff());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpRadiationHealthExamPlan::getStatus, bo.getStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getReminderSent()), MmpRadiationHealthExamPlan::getReminderSent, bo.getReminderSent());
        lqw.eq(bo.getReminderTime() != null, MmpRadiationHealthExamPlan::getReminderTime, bo.getReminderTime());
        return lqw;
    }

    /**
     * 新增职业健康体检计划
     *
     * @param bo 职业健康体检计划
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpRadiationHealthExamPlanBo bo) {
        MmpRadiationHealthExamPlan add = MapstructUtils.convert(bo, MmpRadiationHealthExamPlan.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改职业健康体检计划
     *
     * @param bo 职业健康体检计划
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpRadiationHealthExamPlanBo bo) {
        MmpRadiationHealthExamPlan update = MapstructUtils.convert(bo, MmpRadiationHealthExamPlan.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpRadiationHealthExamPlan entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除职业健康体检计划信息
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
