package org.dromara.cdi.mmp.ntp.service.impl;

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
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectProgressBo;
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectProgressVo;
import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectProgress;
import org.dromara.cdi.mmp.ntp.mapper.MmpNewTechnologyProjectProgressMapper;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectProgressService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 新技术进展报告Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNewTechnologyProjectProgressServiceImpl implements IMmpNewTechnologyProjectProgressService {

    private final MmpNewTechnologyProjectProgressMapper baseMapper;

    /**
     * 查询新技术进展报告
     *
     * @param id 主键
     * @return 新技术进展报告
     */
    @Override
    public MmpNewTechnologyProjectProgressVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询新技术进展报告列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 新技术进展报告分页列表
     */
    @Override
    public TableDataInfo<MmpNewTechnologyProjectProgressVo> queryPageList(MmpNewTechnologyProjectProgressBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNewTechnologyProjectProgress> lqw = buildQueryWrapper(bo);
        Page<MmpNewTechnologyProjectProgressVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的新技术进展报告列表
     *
     * @param bo 查询条件
     * @return 新技术进展报告列表
     */
    @Override
    public List<MmpNewTechnologyProjectProgressVo> queryList(MmpNewTechnologyProjectProgressBo bo) {
        LambdaQueryWrapper<MmpNewTechnologyProjectProgress> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNewTechnologyProjectProgress> buildQueryWrapper(MmpNewTechnologyProjectProgressBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNewTechnologyProjectProgress> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNewTechnologyProjectProgress::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getReportNo()), MmpNewTechnologyProjectProgress::getReportNo, bo.getReportNo());
        lqw.eq(StringUtils.isNotBlank(bo.getReportType()), MmpNewTechnologyProjectProgress::getReportType, bo.getReportType());
        lqw.eq(StringUtils.isNotBlank(bo.getReportPeriod()), MmpNewTechnologyProjectProgress::getReportPeriod, bo.getReportPeriod());
        lqw.eq(bo.getReportDate() != null, MmpNewTechnologyProjectProgress::getReportDate, bo.getReportDate());
        lqw.eq(bo.getCaseCount() != null, MmpNewTechnologyProjectProgress::getCaseCount, bo.getCaseCount());
        lqw.eq(bo.getSuccessCount() != null, MmpNewTechnologyProjectProgress::getSuccessCount, bo.getSuccessCount());
        lqw.eq(bo.getComplicationCount() != null, MmpNewTechnologyProjectProgress::getComplicationCount, bo.getComplicationCount());
        lqw.eq(bo.getAdverseReactionCount() != null, MmpNewTechnologyProjectProgress::getAdverseReactionCount, bo.getAdverseReactionCount());
        lqw.eq(bo.getMortalityCount() != null, MmpNewTechnologyProjectProgress::getMortalityCount, bo.getMortalityCount());
        lqw.eq(StringUtils.isNotBlank(bo.getEffectEvaluation()), MmpNewTechnologyProjectProgress::getEffectEvaluation, bo.getEffectEvaluation());
        lqw.eq(StringUtils.isNotBlank(bo.getExistingProblems()), MmpNewTechnologyProjectProgress::getExistingProblems, bo.getExistingProblems());
        lqw.eq(StringUtils.isNotBlank(bo.getImprovementMeasures()), MmpNewTechnologyProjectProgress::getImprovementMeasures, bo.getImprovementMeasures());
        lqw.eq(StringUtils.isNotBlank(bo.getNextPlan()), MmpNewTechnologyProjectProgress::getNextPlan, bo.getNextPlan());
        lqw.eq(StringUtils.isNotBlank(bo.getContinueStatus()), MmpNewTechnologyProjectProgress::getContinueStatus, bo.getContinueStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getMonitoringIndicators()), MmpNewTechnologyProjectProgress::getMonitoringIndicators, bo.getMonitoringIndicators());
        lqw.eq(StringUtils.isNotBlank(bo.getAttachmentUrls()), MmpNewTechnologyProjectProgress::getAttachmentUrls, bo.getAttachmentUrls());
        lqw.eq(StringUtils.isNotBlank(bo.getReportStatus()), MmpNewTechnologyProjectProgress::getReportStatus, bo.getReportStatus());
        return lqw;
    }

    /**
     * 新增新技术进展报告
     *
     * @param bo 新技术进展报告
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNewTechnologyProjectProgressBo bo) {
        MmpNewTechnologyProjectProgress add = MapstructUtils.convert(bo, MmpNewTechnologyProjectProgress.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改新技术进展报告
     *
     * @param bo 新技术进展报告
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNewTechnologyProjectProgressBo bo) {
        MmpNewTechnologyProjectProgress update = MapstructUtils.convert(bo, MmpNewTechnologyProjectProgress.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNewTechnologyProjectProgress entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除新技术进展报告信息
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
