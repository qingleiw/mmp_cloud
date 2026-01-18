package org.dromara.cdi.mmp.complaintdispute.service.impl;

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
import org.dromara.cdi.mmp.complaintdispute.domain.bo.MmpComplaintDisputeBo;
import org.dromara.cdi.mmp.complaintdispute.domain.vo.MmpComplaintDisputeVo;
import org.dromara.cdi.mmp.complaintdispute.domain.MmpComplaintDispute;
import org.dromara.cdi.mmp.complaintdispute.mapper.MmpComplaintDisputeMapper;
import org.dromara.cdi.mmp.complaintdispute.service.IMmpComplaintDisputeService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 投诉纠纷主Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpComplaintDisputeServiceImpl implements IMmpComplaintDisputeService {

    private final MmpComplaintDisputeMapper baseMapper;

    /**
     * 查询投诉纠纷主
     *
     * @param id 主键
     * @return 投诉纠纷主
     */
    @Override
    public MmpComplaintDisputeVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询投诉纠纷主列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 投诉纠纷主分页列表
     */
    @Override
    public TableDataInfo<MmpComplaintDisputeVo> queryPageList(MmpComplaintDisputeBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpComplaintDispute> lqw = buildQueryWrapper(bo);
        Page<MmpComplaintDisputeVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的投诉纠纷主列表
     *
     * @param bo 查询条件
     * @return 投诉纠纷主列表
     */
    @Override
    public List<MmpComplaintDisputeVo> queryList(MmpComplaintDisputeBo bo) {
        LambdaQueryWrapper<MmpComplaintDispute> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpComplaintDispute> buildQueryWrapper(MmpComplaintDisputeBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpComplaintDispute> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpComplaintDispute::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getComplaintNo()), MmpComplaintDispute::getComplaintNo, bo.getComplaintNo());
        lqw.eq(StringUtils.isNotBlank(bo.getComplaintType()), MmpComplaintDispute::getComplaintType, bo.getComplaintType());
        lqw.eq(StringUtils.isNotBlank(bo.getComplaintSource()), MmpComplaintDispute::getComplaintSource, bo.getComplaintSource());
        lqw.like(StringUtils.isNotBlank(bo.getComplainantName()), MmpComplaintDispute::getComplainantName, bo.getComplainantName());
        lqw.eq(StringUtils.isNotBlank(bo.getComplainantContact()), MmpComplaintDispute::getComplainantContact, bo.getComplainantContact());
        lqw.like(StringUtils.isNotBlank(bo.getPatientName()), MmpComplaintDispute::getPatientName, bo.getPatientName());
        lqw.like(StringUtils.isNotBlank(bo.getDoctorName()), MmpComplaintDispute::getDoctorName, bo.getDoctorName());
        lqw.like(StringUtils.isNotBlank(bo.getDepartmentName()), MmpComplaintDispute::getDepartmentName, bo.getDepartmentName());
        lqw.eq(StringUtils.isNotBlank(bo.getComplaintContent()), MmpComplaintDispute::getComplaintContent, bo.getComplaintContent());
        lqw.eq(bo.getComplaintTime() != null, MmpComplaintDispute::getComplaintTime, bo.getComplaintTime());
        lqw.eq(StringUtils.isNotBlank(bo.getCurrentStatus()), MmpComplaintDispute::getCurrentStatus, bo.getCurrentStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getPriorityLevel()), MmpComplaintDispute::getPriorityLevel, bo.getPriorityLevel());
        lqw.eq(bo.getIsDispute() != null, MmpComplaintDispute::getIsDispute, bo.getIsDispute());
        lqw.eq(StringUtils.isNotBlank(bo.getDisputeConfirmation()), MmpComplaintDispute::getDisputeConfirmation, bo.getDisputeConfirmation());
        lqw.eq(StringUtils.isNotBlank(bo.getFinalResult()), MmpComplaintDispute::getFinalResult, bo.getFinalResult());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpComplaintDispute::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增投诉纠纷主
     *
     * @param bo 投诉纠纷主
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpComplaintDisputeBo bo) {
        MmpComplaintDispute add = MapstructUtils.convert(bo, MmpComplaintDispute.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改投诉纠纷主
     *
     * @param bo 投诉纠纷主
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpComplaintDisputeBo bo) {
        MmpComplaintDispute update = MapstructUtils.convert(bo, MmpComplaintDispute.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpComplaintDispute entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除投诉纠纷主信息
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
