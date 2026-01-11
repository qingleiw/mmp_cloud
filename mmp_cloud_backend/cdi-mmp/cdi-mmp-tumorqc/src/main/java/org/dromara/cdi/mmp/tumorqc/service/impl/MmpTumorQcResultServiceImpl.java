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
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcResultBo;
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcResultVo;
import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcResult;
import org.dromara.cdi.mmp.tumorqc.mapper.MmpTumorQcResultMapper;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcResultService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 肿瘤质控结果Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpTumorQcResultServiceImpl implements IMmpTumorQcResultService {

    private final MmpTumorQcResultMapper baseMapper;

    /**
     * 查询肿瘤质控结果
     *
     * @param id 主键
     * @return 肿瘤质控结果
     */
    @Override
    public MmpTumorQcResultVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询肿瘤质控结果列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 肿瘤质控结果分页列表
     */
    @Override
    public TableDataInfo<MmpTumorQcResultVo> queryPageList(MmpTumorQcResultBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpTumorQcResult> lqw = buildQueryWrapper(bo);
        Page<MmpTumorQcResultVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的肿瘤质控结果列表
     *
     * @param bo 查询条件
     * @return 肿瘤质控结果列表
     */
    @Override
    public List<MmpTumorQcResultVo> queryList(MmpTumorQcResultBo bo) {
        LambdaQueryWrapper<MmpTumorQcResult> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpTumorQcResult> buildQueryWrapper(MmpTumorQcResultBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpTumorQcResult> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpTumorQcResult::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getResultCode()), MmpTumorQcResult::getResultCode, bo.getResultCode());
        lqw.like(StringUtils.isNotBlank(bo.getIndicatorName()), MmpTumorQcResult::getIndicatorName, bo.getIndicatorName());
        lqw.eq(bo.getResultValue() != null, MmpTumorQcResult::getResultValue, bo.getResultValue());
        lqw.eq(bo.getTargetValue() != null, MmpTumorQcResult::getTargetValue, bo.getTargetValue());
        lqw.eq(bo.getComplianceRate() != null, MmpTumorQcResult::getComplianceRate, bo.getComplianceRate());
        lqw.eq(StringUtils.isNotBlank(bo.getAnalysis()), MmpTumorQcResult::getAnalysis, bo.getAnalysis());
        lqw.eq(bo.getPeriodStart() != null, MmpTumorQcResult::getPeriodStart, bo.getPeriodStart());
        lqw.eq(bo.getPeriodEnd() != null, MmpTumorQcResult::getPeriodEnd, bo.getPeriodEnd());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpTumorQcResult::getStatus, bo.getStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpTumorQcResult::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增肿瘤质控结果
     *
     * @param bo 肿瘤质控结果
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpTumorQcResultBo bo) {
        MmpTumorQcResult add = MapstructUtils.convert(bo, MmpTumorQcResult.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改肿瘤质控结果
     *
     * @param bo 肿瘤质控结果
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpTumorQcResultBo bo) {
        MmpTumorQcResult update = MapstructUtils.convert(bo, MmpTumorQcResult.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpTumorQcResult entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除肿瘤质控结果信息
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
