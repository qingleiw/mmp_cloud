package org.dromara.cdi.mmp.surgery.service.impl;

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
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryWorkloadStatisticsBo;
import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryWorkloadStatisticsVo;
import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryWorkloadStatistics;
import org.dromara.cdi.mmp.surgery.mapper.MmpSurgeryWorkloadStatisticsMapper;
import org.dromara.cdi.mmp.surgery.service.IMmpSurgeryWorkloadStatisticsService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 手术工作量统计Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSurgeryWorkloadStatisticsServiceImpl implements IMmpSurgeryWorkloadStatisticsService {

    private final MmpSurgeryWorkloadStatisticsMapper baseMapper;

    /**
     * 查询手术工作量统计
     *
     * @param id 主键
     * @return 手术工作量统计
     */
    @Override
    public MmpSurgeryWorkloadStatisticsVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询手术工作量统计列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 手术工作量统计分页列表
     */
    @Override
    public TableDataInfo<MmpSurgeryWorkloadStatisticsVo> queryPageList(MmpSurgeryWorkloadStatisticsBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSurgeryWorkloadStatistics> lqw = buildQueryWrapper(bo);
        Page<MmpSurgeryWorkloadStatisticsVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的手术工作量统计列表
     *
     * @param bo 查询条件
     * @return 手术工作量统计列表
     */
    @Override
    public List<MmpSurgeryWorkloadStatisticsVo> queryList(MmpSurgeryWorkloadStatisticsBo bo) {
        LambdaQueryWrapper<MmpSurgeryWorkloadStatistics> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSurgeryWorkloadStatistics> buildQueryWrapper(MmpSurgeryWorkloadStatisticsBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSurgeryWorkloadStatistics> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSurgeryWorkloadStatistics::getId);
        lqw.like(StringUtils.isNotBlank(bo.getDoctorName()), MmpSurgeryWorkloadStatistics::getDoctorName, bo.getDoctorName());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryCode()), MmpSurgeryWorkloadStatistics::getSurgeryCode, bo.getSurgeryCode());
        lqw.like(StringUtils.isNotBlank(bo.getSurgeryName()), MmpSurgeryWorkloadStatistics::getSurgeryName, bo.getSurgeryName());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryLevel()), MmpSurgeryWorkloadStatistics::getSurgeryLevel, bo.getSurgeryLevel());
        lqw.eq(bo.getSurgeryCount() != null, MmpSurgeryWorkloadStatistics::getSurgeryCount, bo.getSurgeryCount());
        lqw.eq(bo.getMainOperatorCount() != null, MmpSurgeryWorkloadStatistics::getMainOperatorCount, bo.getMainOperatorCount());
        lqw.eq(bo.getFirstAssistantCount() != null, MmpSurgeryWorkloadStatistics::getFirstAssistantCount, bo.getFirstAssistantCount());
        lqw.eq(bo.getStatisticsYear() != null, MmpSurgeryWorkloadStatistics::getStatisticsYear, bo.getStatisticsYear());
        lqw.eq(bo.getStatisticsMonth() != null, MmpSurgeryWorkloadStatistics::getStatisticsMonth, bo.getStatisticsMonth());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpSurgeryWorkloadStatistics::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增手术工作量统计
     *
     * @param bo 手术工作量统计
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSurgeryWorkloadStatisticsBo bo) {
        MmpSurgeryWorkloadStatistics add = MapstructUtils.convert(bo, MmpSurgeryWorkloadStatistics.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改手术工作量统计
     *
     * @param bo 手术工作量统计
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSurgeryWorkloadStatisticsBo bo) {
        MmpSurgeryWorkloadStatistics update = MapstructUtils.convert(bo, MmpSurgeryWorkloadStatistics.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSurgeryWorkloadStatistics entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除手术工作量统计信息
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
