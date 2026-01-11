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
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyPlanBo;
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyPlanVo;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyPlan;
import org.dromara.cdi.mmp.emergency.mapper.MmpEmergencyPlanMapper;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyPlanService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 应急预案Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpEmergencyPlanServiceImpl implements IMmpEmergencyPlanService {

    private final MmpEmergencyPlanMapper baseMapper;

    /**
     * 查询应急预案
     *
     * @param id 主键
     * @return 应急预案
     */
    @Override
    public MmpEmergencyPlanVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询应急预案列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 应急预案分页列表
     */
    @Override
    public TableDataInfo<MmpEmergencyPlanVo> queryPageList(MmpEmergencyPlanBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpEmergencyPlan> lqw = buildQueryWrapper(bo);
        Page<MmpEmergencyPlanVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的应急预案列表
     *
     * @param bo 查询条件
     * @return 应急预案列表
     */
    @Override
    public List<MmpEmergencyPlanVo> queryList(MmpEmergencyPlanBo bo) {
        LambdaQueryWrapper<MmpEmergencyPlan> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpEmergencyPlan> buildQueryWrapper(MmpEmergencyPlanBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpEmergencyPlan> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpEmergencyPlan::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPlanCode()), MmpEmergencyPlan::getPlanCode, bo.getPlanCode());
        lqw.like(StringUtils.isNotBlank(bo.getPlanName()), MmpEmergencyPlan::getPlanName, bo.getPlanName());
        lqw.eq(StringUtils.isNotBlank(bo.getPlanType()), MmpEmergencyPlan::getPlanType, bo.getPlanType());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpEmergencyPlan::getStatus, bo.getStatus());
        lqw.eq(bo.getEffectiveDate() != null, MmpEmergencyPlan::getEffectiveDate, bo.getEffectiveDate());
        lqw.eq(bo.getReviewDate() != null, MmpEmergencyPlan::getReviewDate, bo.getReviewDate());
        lqw.eq(bo.getNextReviewDate() != null, MmpEmergencyPlan::getNextReviewDate, bo.getNextReviewDate());
        lqw.eq(StringUtils.isNotBlank(bo.getKeywords()), MmpEmergencyPlan::getKeywords, bo.getKeywords());
        lqw.eq(StringUtils.isNotBlank(bo.getFilePath()), MmpEmergencyPlan::getFilePath, bo.getFilePath());
        lqw.like(StringUtils.isNotBlank(bo.getFileName()), MmpEmergencyPlan::getFileName, bo.getFileName());
        lqw.eq(bo.getFileSize() != null, MmpEmergencyPlan::getFileSize, bo.getFileSize());
        lqw.eq(StringUtils.isNotBlank(bo.getUploadBy()), MmpEmergencyPlan::getUploadBy, bo.getUploadBy());
        lqw.eq(bo.getUploadTime() != null, MmpEmergencyPlan::getUploadTime, bo.getUploadTime());
        lqw.eq(StringUtils.isNotBlank(bo.getApproveBy()), MmpEmergencyPlan::getApproveBy, bo.getApproveBy());
        lqw.eq(bo.getApproveTime() != null, MmpEmergencyPlan::getApproveTime, bo.getApproveTime());
        return lqw;
    }

    /**
     * 新增应急预案
     *
     * @param bo 应急预案
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpEmergencyPlanBo bo) {
        MmpEmergencyPlan add = MapstructUtils.convert(bo, MmpEmergencyPlan.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改应急预案
     *
     * @param bo 应急预案
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpEmergencyPlanBo bo) {
        MmpEmergencyPlan update = MapstructUtils.convert(bo, MmpEmergencyPlan.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpEmergencyPlan entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除应急预案信息
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
