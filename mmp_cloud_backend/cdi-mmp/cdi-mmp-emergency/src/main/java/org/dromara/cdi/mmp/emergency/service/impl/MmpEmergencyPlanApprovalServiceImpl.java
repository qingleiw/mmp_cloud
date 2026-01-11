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
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyPlanApprovalBo;
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyPlanApprovalVo;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyPlanApproval;
import org.dromara.cdi.mmp.emergency.mapper.MmpEmergencyPlanApprovalMapper;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyPlanApprovalService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 应急预案审批Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpEmergencyPlanApprovalServiceImpl implements IMmpEmergencyPlanApprovalService {

    private final MmpEmergencyPlanApprovalMapper baseMapper;

    /**
     * 查询应急预案审批
     *
     * @param id 主键
     * @return 应急预案审批
     */
    @Override
    public MmpEmergencyPlanApprovalVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询应急预案审批列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 应急预案审批分页列表
     */
    @Override
    public TableDataInfo<MmpEmergencyPlanApprovalVo> queryPageList(MmpEmergencyPlanApprovalBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpEmergencyPlanApproval> lqw = buildQueryWrapper(bo);
        Page<MmpEmergencyPlanApprovalVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的应急预案审批列表
     *
     * @param bo 查询条件
     * @return 应急预案审批列表
     */
    @Override
    public List<MmpEmergencyPlanApprovalVo> queryList(MmpEmergencyPlanApprovalBo bo) {
        LambdaQueryWrapper<MmpEmergencyPlanApproval> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpEmergencyPlanApproval> buildQueryWrapper(MmpEmergencyPlanApprovalBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpEmergencyPlanApproval> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpEmergencyPlanApproval::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getApprovalStage()), MmpEmergencyPlanApproval::getApprovalStage, bo.getApprovalStage());
        lqw.like(StringUtils.isNotBlank(bo.getApproverName()), MmpEmergencyPlanApproval::getApproverName, bo.getApproverName());
        lqw.eq(StringUtils.isNotBlank(bo.getApprovalOpinion()), MmpEmergencyPlanApproval::getApprovalOpinion, bo.getApprovalOpinion());
        lqw.eq(StringUtils.isNotBlank(bo.getApprovalResult()), MmpEmergencyPlanApproval::getApprovalResult, bo.getApprovalResult());
        lqw.eq(bo.getApprovalTime() != null, MmpEmergencyPlanApproval::getApprovalTime, bo.getApprovalTime());
        return lqw;
    }

    /**
     * 新增应急预案审批
     *
     * @param bo 应急预案审批
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpEmergencyPlanApprovalBo bo) {
        MmpEmergencyPlanApproval add = MapstructUtils.convert(bo, MmpEmergencyPlanApproval.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改应急预案审批
     *
     * @param bo 应急预案审批
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpEmergencyPlanApprovalBo bo) {
        MmpEmergencyPlanApproval update = MapstructUtils.convert(bo, MmpEmergencyPlanApproval.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpEmergencyPlanApproval entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除应急预案审批信息
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
