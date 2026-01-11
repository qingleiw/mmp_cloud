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
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcIndicatorConfigBo;
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcIndicatorConfigVo;
import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcIndicatorConfig;
import org.dromara.cdi.mmp.tumorqc.mapper.MmpTumorQcIndicatorConfigMapper;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcIndicatorConfigService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 肿瘤质控指标配置Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpTumorQcIndicatorConfigServiceImpl implements IMmpTumorQcIndicatorConfigService {

    private final MmpTumorQcIndicatorConfigMapper baseMapper;

    /**
     * 查询肿瘤质控指标配置
     *
     * @param id 主键
     * @return 肿瘤质控指标配置
     */
    @Override
    public MmpTumorQcIndicatorConfigVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询肿瘤质控指标配置列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 肿瘤质控指标配置分页列表
     */
    @Override
    public TableDataInfo<MmpTumorQcIndicatorConfigVo> queryPageList(MmpTumorQcIndicatorConfigBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpTumorQcIndicatorConfig> lqw = buildQueryWrapper(bo);
        Page<MmpTumorQcIndicatorConfigVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的肿瘤质控指标配置列表
     *
     * @param bo 查询条件
     * @return 肿瘤质控指标配置列表
     */
    @Override
    public List<MmpTumorQcIndicatorConfigVo> queryList(MmpTumorQcIndicatorConfigBo bo) {
        LambdaQueryWrapper<MmpTumorQcIndicatorConfig> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpTumorQcIndicatorConfig> buildQueryWrapper(MmpTumorQcIndicatorConfigBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpTumorQcIndicatorConfig> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpTumorQcIndicatorConfig::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getIndicatorCode()), MmpTumorQcIndicatorConfig::getIndicatorCode, bo.getIndicatorCode());
        lqw.like(StringUtils.isNotBlank(bo.getIndicatorName()), MmpTumorQcIndicatorConfig::getIndicatorName, bo.getIndicatorName());
        lqw.eq(StringUtils.isNotBlank(bo.getIndicatorCategory()), MmpTumorQcIndicatorConfig::getIndicatorCategory, bo.getIndicatorCategory());
        lqw.eq(StringUtils.isNotBlank(bo.getTumorType()), MmpTumorQcIndicatorConfig::getTumorType, bo.getTumorType());
        lqw.eq(StringUtils.isNotBlank(bo.getIndicatorType()), MmpTumorQcIndicatorConfig::getIndicatorType, bo.getIndicatorType());
        lqw.eq(StringUtils.isNotBlank(bo.getCalculationFormula()), MmpTumorQcIndicatorConfig::getCalculationFormula, bo.getCalculationFormula());
        lqw.eq(StringUtils.isNotBlank(bo.getDataSource()), MmpTumorQcIndicatorConfig::getDataSource, bo.getDataSource());
        lqw.eq(StringUtils.isNotBlank(bo.getCollectionFrequency()), MmpTumorQcIndicatorConfig::getCollectionFrequency, bo.getCollectionFrequency());
        lqw.eq(StringUtils.isNotBlank(bo.getStandardValue()), MmpTumorQcIndicatorConfig::getStandardValue, bo.getStandardValue());
        lqw.eq(StringUtils.isNotBlank(bo.getTargetValue()), MmpTumorQcIndicatorConfig::getTargetValue, bo.getTargetValue());
        lqw.eq(bo.getEffectiveDate() != null, MmpTumorQcIndicatorConfig::getEffectiveDate, bo.getEffectiveDate());
        lqw.eq(StringUtils.isNotBlank(bo.getPolicyLevel()), MmpTumorQcIndicatorConfig::getPolicyLevel, bo.getPolicyLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getPolicySource()), MmpTumorQcIndicatorConfig::getPolicySource, bo.getPolicySource());
        lqw.eq(bo.getIsEnabled() != null, MmpTumorQcIndicatorConfig::getIsEnabled, bo.getIsEnabled());
        lqw.eq(bo.getDelFlag() != null, MmpTumorQcIndicatorConfig::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增肿瘤质控指标配置
     *
     * @param bo 肿瘤质控指标配置
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpTumorQcIndicatorConfigBo bo) {
        MmpTumorQcIndicatorConfig add = MapstructUtils.convert(bo, MmpTumorQcIndicatorConfig.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改肿瘤质控指标配置
     *
     * @param bo 肿瘤质控指标配置
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpTumorQcIndicatorConfigBo bo) {
        MmpTumorQcIndicatorConfig update = MapstructUtils.convert(bo, MmpTumorQcIndicatorConfig.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpTumorQcIndicatorConfig entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除肿瘤质控指标配置信息
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
