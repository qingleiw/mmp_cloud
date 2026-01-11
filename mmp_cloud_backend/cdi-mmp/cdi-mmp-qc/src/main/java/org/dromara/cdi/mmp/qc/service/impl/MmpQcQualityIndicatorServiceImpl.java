package org.dromara.cdi.mmp.qc.service.impl;

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
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcQualityIndicatorBo;
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcQualityIndicatorVo;
import org.dromara.cdi.mmp.qc.domain.MmpQcQualityIndicator;
import org.dromara.cdi.mmp.qc.mapper.MmpQcQualityIndicatorMapper;
import org.dromara.cdi.mmp.qc.service.IMmpQcQualityIndicatorService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 质量指标Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQcQualityIndicatorServiceImpl implements IMmpQcQualityIndicatorService {

    private final MmpQcQualityIndicatorMapper baseMapper;

    /**
     * 查询质量指标
     *
     * @param id 主键
     * @return 质量指标
     */
    @Override
    public MmpQcQualityIndicatorVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询质量指标列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 质量指标分页列表
     */
    @Override
    public TableDataInfo<MmpQcQualityIndicatorVo> queryPageList(MmpQcQualityIndicatorBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQcQualityIndicator> lqw = buildQueryWrapper(bo);
        Page<MmpQcQualityIndicatorVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的质量指标列表
     *
     * @param bo 查询条件
     * @return 质量指标列表
     */
    @Override
    public List<MmpQcQualityIndicatorVo> queryList(MmpQcQualityIndicatorBo bo) {
        LambdaQueryWrapper<MmpQcQualityIndicator> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQcQualityIndicator> buildQueryWrapper(MmpQcQualityIndicatorBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQcQualityIndicator> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQcQualityIndicator::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getIndicatorCode()), MmpQcQualityIndicator::getIndicatorCode, bo.getIndicatorCode());
        lqw.like(StringUtils.isNotBlank(bo.getIndicatorName()), MmpQcQualityIndicator::getIndicatorName, bo.getIndicatorName());
        lqw.eq(bo.getIndicatorLevel() != null, MmpQcQualityIndicator::getIndicatorLevel, bo.getIndicatorLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getDefinition()), MmpQcQualityIndicator::getDefinition, bo.getDefinition());
        lqw.eq(StringUtils.isNotBlank(bo.getFormula()), MmpQcQualityIndicator::getFormula, bo.getFormula());
        lqw.eq(StringUtils.isNotBlank(bo.getSignificance()), MmpQcQualityIndicator::getSignificance, bo.getSignificance());
        lqw.eq(StringUtils.isNotBlank(bo.getUnit()), MmpQcQualityIndicator::getUnit, bo.getUnit());
        lqw.eq(StringUtils.isNotBlank(bo.getDataType()), MmpQcQualityIndicator::getDataType, bo.getDataType());
        lqw.eq(bo.getStandardValue() != null, MmpQcQualityIndicator::getStandardValue, bo.getStandardValue());
        lqw.eq(bo.getMaxScore() != null, MmpQcQualityIndicator::getMaxScore, bo.getMaxScore());
        lqw.eq(bo.getSortOrder() != null, MmpQcQualityIndicator::getSortOrder, bo.getSortOrder());
        lqw.eq(bo.getStatus() != null, MmpQcQualityIndicator::getStatus, bo.getStatus());
        lqw.eq(bo.getDelFlag() != null, MmpQcQualityIndicator::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增质量指标
     *
     * @param bo 质量指标
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQcQualityIndicatorBo bo) {
        MmpQcQualityIndicator add = MapstructUtils.convert(bo, MmpQcQualityIndicator.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改质量指标
     *
     * @param bo 质量指标
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQcQualityIndicatorBo bo) {
        MmpQcQualityIndicator update = MapstructUtils.convert(bo, MmpQcQualityIndicator.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQcQualityIndicator entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除质量指标信息
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
