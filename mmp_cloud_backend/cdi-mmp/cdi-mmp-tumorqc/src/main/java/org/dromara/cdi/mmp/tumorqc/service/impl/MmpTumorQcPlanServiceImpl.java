package org.dromara.cdi.mmp.tumorqc.service.impl;

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
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcPlanBo;
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcPlanVo;
import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcPlan;
import org.dromara.cdi.mmp.tumorqc.mapper.MmpTumorQcPlanMapper;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcPlanService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 肿瘤质控方案Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpTumorQcPlanServiceImpl implements IMmpTumorQcPlanService {

    private final MmpTumorQcPlanMapper baseMapper;

    /**
     * 查询肿瘤质控方案
     *
     * @param id 主键
     * @return 肿瘤质控方案
     */
    @Override
    public MmpTumorQcPlanVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询肿瘤质控方案列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 肿瘤质控方案分页列表
     */
    @Override
    public TableDataInfo<MmpTumorQcPlanVo> queryPageList(MmpTumorQcPlanBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpTumorQcPlan> lqw = buildQueryWrapper(bo);
        Page<MmpTumorQcPlanVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的肿瘤质控方案列表
     *
     * @param bo 查询条件
     * @return 肿瘤质控方案列表
     */
    @Override
    public List<MmpTumorQcPlanVo> queryList(MmpTumorQcPlanBo bo) {
        LambdaQueryWrapper<MmpTumorQcPlan> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpTumorQcPlan> buildQueryWrapper(MmpTumorQcPlanBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpTumorQcPlan> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpTumorQcPlan::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPlanCode()), MmpTumorQcPlan::getPlanCode, bo.getPlanCode());
        lqw.like(StringUtils.isNotBlank(bo.getPlanName()), MmpTumorQcPlan::getPlanName, bo.getPlanName());
        lqw.eq(StringUtils.isNotBlank(bo.getPlanType()), MmpTumorQcPlan::getPlanType, bo.getPlanType());
        lqw.eq(StringUtils.isNotBlank(bo.getDescription()), MmpTumorQcPlan::getDescription, bo.getDescription());
        lqw.eq(bo.getStartDate() != null, MmpTumorQcPlan::getStartDate, bo.getStartDate());
        lqw.eq(bo.getEndDate() != null, MmpTumorQcPlan::getEndDate, bo.getEndDate());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpTumorQcPlan::getStatus, bo.getStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getApprovalStatus()), MmpTumorQcPlan::getApprovalStatus, bo.getApprovalStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpTumorQcPlan::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增肿瘤质控方案
     *
     * @param bo 肿瘤质控方案
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpTumorQcPlanBo bo) {
        MmpTumorQcPlan add = MapstructUtils.convert(bo, MmpTumorQcPlan.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改肿瘤质控方案
     *
     * @param bo 肿瘤质控方案
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpTumorQcPlanBo bo) {
        MmpTumorQcPlan update = MapstructUtils.convert(bo, MmpTumorQcPlan.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpTumorQcPlan entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除肿瘤质控方案信息
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
