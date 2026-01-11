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
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcIndicatorCollectionConfigBo;
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcIndicatorCollectionConfigVo;
import org.dromara.cdi.mmp.qc.domain.MmpQcIndicatorCollectionConfig;
import org.dromara.cdi.mmp.qc.mapper.MmpQcIndicatorCollectionConfigMapper;
import org.dromara.cdi.mmp.qc.service.IMmpQcIndicatorCollectionConfigService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 质控指标数据采集配置Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQcIndicatorCollectionConfigServiceImpl implements IMmpQcIndicatorCollectionConfigService {

    private final MmpQcIndicatorCollectionConfigMapper baseMapper;

    /**
     * 查询质控指标数据采集配置
     *
     * @param id 主键
     * @return 质控指标数据采集配置
     */
    @Override
    public MmpQcIndicatorCollectionConfigVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询质控指标数据采集配置列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 质控指标数据采集配置分页列表
     */
    @Override
    public TableDataInfo<MmpQcIndicatorCollectionConfigVo> queryPageList(MmpQcIndicatorCollectionConfigBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQcIndicatorCollectionConfig> lqw = buildQueryWrapper(bo);
        Page<MmpQcIndicatorCollectionConfigVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的质控指标数据采集配置列表
     *
     * @param bo 查询条件
     * @return 质控指标数据采集配置列表
     */
    @Override
    public List<MmpQcIndicatorCollectionConfigVo> queryList(MmpQcIndicatorCollectionConfigBo bo) {
        LambdaQueryWrapper<MmpQcIndicatorCollectionConfig> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQcIndicatorCollectionConfig> buildQueryWrapper(MmpQcIndicatorCollectionConfigBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQcIndicatorCollectionConfig> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQcIndicatorCollectionConfig::getId);
        lqw.eq(bo.getIndicatorId() != null, MmpQcIndicatorCollectionConfig::getIndicatorId, bo.getIndicatorId());
        lqw.eq(StringUtils.isNotBlank(bo.getSourceSystem()), MmpQcIndicatorCollectionConfig::getSourceSystem, bo.getSourceSystem());
        lqw.eq(StringUtils.isNotBlank(bo.getSourceTable()), MmpQcIndicatorCollectionConfig::getSourceTable, bo.getSourceTable());
        lqw.eq(StringUtils.isNotBlank(bo.getSourceField()), MmpQcIndicatorCollectionConfig::getSourceField, bo.getSourceField());
        lqw.eq(StringUtils.isNotBlank(bo.getExtractionRule()), MmpQcIndicatorCollectionConfig::getExtractionRule, bo.getExtractionRule());
        lqw.eq(StringUtils.isNotBlank(bo.getDataType()), MmpQcIndicatorCollectionConfig::getDataType, bo.getDataType());
        lqw.eq(bo.getIsRequired() != null, MmpQcIndicatorCollectionConfig::getIsRequired, bo.getIsRequired());
        lqw.eq(StringUtils.isNotBlank(bo.getDefaultValue()), MmpQcIndicatorCollectionConfig::getDefaultValue, bo.getDefaultValue());
        lqw.eq(StringUtils.isNotBlank(bo.getValidationRule()), MmpQcIndicatorCollectionConfig::getValidationRule, bo.getValidationRule());
        lqw.eq(bo.getDelFlag() != null, MmpQcIndicatorCollectionConfig::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增质控指标数据采集配置
     *
     * @param bo 质控指标数据采集配置
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQcIndicatorCollectionConfigBo bo) {
        MmpQcIndicatorCollectionConfig add = MapstructUtils.convert(bo, MmpQcIndicatorCollectionConfig.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改质控指标数据采集配置
     *
     * @param bo 质控指标数据采集配置
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQcIndicatorCollectionConfigBo bo) {
        MmpQcIndicatorCollectionConfig update = MapstructUtils.convert(bo, MmpQcIndicatorCollectionConfig.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQcIndicatorCollectionConfig entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除质控指标数据采集配置信息
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
