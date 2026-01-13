package org.dromara.cdi.mmp.complaindispute.service.impl;

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
import org.dromara.cdi.mmp.complaindispute.domain.bo.MmpComplaintHandlingBo;
import org.dromara.cdi.mmp.complaindispute.domain.vo.MmpComplaintHandlingVo;
import org.dromara.cdi.mmp.complaindispute.domain.MmpComplaintHandling;
import org.dromara.cdi.mmp.complaindispute.mapper.MmpComplaintHandlingMapper;
import org.dromara.cdi.mmp.complaindispute.service.IMmpComplaintHandlingService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 投诉处理记录Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpComplaintHandlingServiceImpl implements IMmpComplaintHandlingService {

    private final MmpComplaintHandlingMapper baseMapper;

    /**
     * 查询投诉处理记录
     *
     * @param id 主键
     * @return 投诉处理记录
     */
    @Override
    public MmpComplaintHandlingVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询投诉处理记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 投诉处理记录分页列表
     */
    @Override
    public TableDataInfo<MmpComplaintHandlingVo> queryPageList(MmpComplaintHandlingBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpComplaintHandling> lqw = buildQueryWrapper(bo);
        Page<MmpComplaintHandlingVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的投诉处理记录列表
     *
     * @param bo 查询条件
     * @return 投诉处理记录列表
     */
    @Override
    public List<MmpComplaintHandlingVo> queryList(MmpComplaintHandlingBo bo) {
        LambdaQueryWrapper<MmpComplaintHandling> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpComplaintHandling> buildQueryWrapper(MmpComplaintHandlingBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpComplaintHandling> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpComplaintHandling::getId);
        lqw.like(StringUtils.isNotBlank(bo.getHandlerName()), MmpComplaintHandling::getHandlerName, bo.getHandlerName());
        lqw.eq(StringUtils.isNotBlank(bo.getHandlingMeasure()), MmpComplaintHandling::getHandlingMeasure, bo.getHandlingMeasure());
        lqw.eq(StringUtils.isNotBlank(bo.getHandlingResult()), MmpComplaintHandling::getHandlingResult, bo.getHandlingResult());
        lqw.eq(bo.getHandlingTime() != null, MmpComplaintHandling::getHandlingTime, bo.getHandlingTime());
        lqw.eq(StringUtils.isNotBlank(bo.getFeedbackContent()), MmpComplaintHandling::getFeedbackContent, bo.getFeedbackContent());
        lqw.eq(bo.getFeedbackTime() != null, MmpComplaintHandling::getFeedbackTime, bo.getFeedbackTime());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpComplaintHandling::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增投诉处理记录
     *
     * @param bo 投诉处理记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpComplaintHandlingBo bo) {
        MmpComplaintHandling add = MapstructUtils.convert(bo, MmpComplaintHandling.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改投诉处理记录
     *
     * @param bo 投诉处理记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpComplaintHandlingBo bo) {
        MmpComplaintHandling update = MapstructUtils.convert(bo, MmpComplaintHandling.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpComplaintHandling entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除投诉处理记录信息
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
