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
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcReportBo;
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcReportVo;
import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcReport;
import org.dromara.cdi.mmp.tumorqc.mapper.MmpTumorQcReportMapper;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcReportService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 肿瘤质控报告Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpTumorQcReportServiceImpl implements IMmpTumorQcReportService {

    private final MmpTumorQcReportMapper baseMapper;

    /**
     * 查询肿瘤质控报告
     *
     * @param id 主键
     * @return 肿瘤质控报告
     */
    @Override
    public MmpTumorQcReportVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询肿瘤质控报告列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 肿瘤质控报告分页列表
     */
    @Override
    public TableDataInfo<MmpTumorQcReportVo> queryPageList(MmpTumorQcReportBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpTumorQcReport> lqw = buildQueryWrapper(bo);
        Page<MmpTumorQcReportVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的肿瘤质控报告列表
     *
     * @param bo 查询条件
     * @return 肿瘤质控报告列表
     */
    @Override
    public List<MmpTumorQcReportVo> queryList(MmpTumorQcReportBo bo) {
        LambdaQueryWrapper<MmpTumorQcReport> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpTumorQcReport> buildQueryWrapper(MmpTumorQcReportBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpTumorQcReport> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpTumorQcReport::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getReportCode()), MmpTumorQcReport::getReportCode, bo.getReportCode());
        lqw.eq(StringUtils.isNotBlank(bo.getReportTitle()), MmpTumorQcReport::getReportTitle, bo.getReportTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getReportType()), MmpTumorQcReport::getReportType, bo.getReportType());
        lqw.eq(bo.getPeriodStart() != null, MmpTumorQcReport::getPeriodStart, bo.getPeriodStart());
        lqw.eq(bo.getPeriodEnd() != null, MmpTumorQcReport::getPeriodEnd, bo.getPeriodEnd());
        lqw.eq(StringUtils.isNotBlank(bo.getReportContent()), MmpTumorQcReport::getReportContent, bo.getReportContent());
        lqw.eq(StringUtils.isNotBlank(bo.getSummary()), MmpTumorQcReport::getSummary, bo.getSummary());
        lqw.eq(StringUtils.isNotBlank(bo.getRecommendations()), MmpTumorQcReport::getRecommendations, bo.getRecommendations());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpTumorQcReport::getStatus, bo.getStatus());
        lqw.eq(bo.getPublishTime() != null, MmpTumorQcReport::getPublishTime, bo.getPublishTime());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpTumorQcReport::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增肿瘤质控报告
     *
     * @param bo 肿瘤质控报告
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpTumorQcReportBo bo) {
        MmpTumorQcReport add = MapstructUtils.convert(bo, MmpTumorQcReport.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改肿瘤质控报告
     *
     * @param bo 肿瘤质控报告
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpTumorQcReportBo bo) {
        MmpTumorQcReport update = MapstructUtils.convert(bo, MmpTumorQcReport.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpTumorQcReport entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除肿瘤质控报告信息
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
