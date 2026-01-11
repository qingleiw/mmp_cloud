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
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionPlanBo;
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionPlanVo;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionPlan;
import org.dromara.cdi.mmp.supervision.mapper.MmpSupervisionPlanMapper;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionPlanService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 督查计划Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSupervisionPlanServiceImpl implements IMmpSupervisionPlanService {

    private final MmpSupervisionPlanMapper baseMapper;

    /**
     * 查询督查计划
     *
     * @param id 主键
     * @return 督查计划
     */
    @Override
    public MmpSupervisionPlanVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询督查计划列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查计划分页列表
     */
    @Override
    public TableDataInfo<MmpSupervisionPlanVo> queryPageList(MmpSupervisionPlanBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSupervisionPlan> lqw = buildQueryWrapper(bo);
        Page<MmpSupervisionPlanVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的督查计划列表
     *
     * @param bo 查询条件
     * @return 督查计划列表
     */
    @Override
    public List<MmpSupervisionPlanVo> queryList(MmpSupervisionPlanBo bo) {
        LambdaQueryWrapper<MmpSupervisionPlan> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSupervisionPlan> buildQueryWrapper(MmpSupervisionPlanBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSupervisionPlan> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSupervisionPlan::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPlanCode()), MmpSupervisionPlan::getPlanCode, bo.getPlanCode());
        lqw.like(StringUtils.isNotBlank(bo.getPlanName()), MmpSupervisionPlan::getPlanName, bo.getPlanName());
        lqw.eq(StringUtils.isNotBlank(bo.getPlanType()), MmpSupervisionPlan::getPlanType, bo.getPlanType());
        lqw.eq(StringUtils.isNotBlank(bo.getSupervisionPeriod()), MmpSupervisionPlan::getSupervisionPeriod, bo.getSupervisionPeriod());
        lqw.eq(bo.getStartDate() != null, MmpSupervisionPlan::getStartDate, bo.getStartDate());
        lqw.eq(bo.getEndDate() != null, MmpSupervisionPlan::getEndDate, bo.getEndDate());
        lqw.eq(StringUtils.isNotBlank(bo.getResponsiblePerson()), MmpSupervisionPlan::getResponsiblePerson, bo.getResponsiblePerson());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpSupervisionPlan::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增督查计划
     *
     * @param bo 督查计划
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSupervisionPlanBo bo) {
        MmpSupervisionPlan add = MapstructUtils.convert(bo, MmpSupervisionPlan.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改督查计划
     *
     * @param bo 督查计划
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSupervisionPlanBo bo) {
        MmpSupervisionPlan update = MapstructUtils.convert(bo, MmpSupervisionPlan.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSupervisionPlan entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除督查计划信息
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
