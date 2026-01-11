package org.dromara.cdi.mmp.coresystem.service.impl;

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
import org.dromara.cdi.mmp.coresystem.domain.bo.MmpCoreSystemConfigBo;
import org.dromara.cdi.mmp.coresystem.domain.vo.MmpCoreSystemConfigVo;
import org.dromara.cdi.mmp.coresystem.domain.MmpCoreSystemConfig;
import org.dromara.cdi.mmp.coresystem.mapper.MmpCoreSystemConfigMapper;
import org.dromara.cdi.mmp.coresystem.service.IMmpCoreSystemConfigService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 核心制度配置Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpCoreSystemConfigServiceImpl implements IMmpCoreSystemConfigService {

    private final MmpCoreSystemConfigMapper baseMapper;

    /**
     * 查询核心制度配置
     *
     * @param id 主键
     * @return 核心制度配置
     */
    @Override
    public MmpCoreSystemConfigVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询核心制度配置列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 核心制度配置分页列表
     */
    @Override
    public TableDataInfo<MmpCoreSystemConfigVo> queryPageList(MmpCoreSystemConfigBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpCoreSystemConfig> lqw = buildQueryWrapper(bo);
        Page<MmpCoreSystemConfigVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的核心制度配置列表
     *
     * @param bo 查询条件
     * @return 核心制度配置列表
     */
    @Override
    public List<MmpCoreSystemConfigVo> queryList(MmpCoreSystemConfigBo bo) {
        LambdaQueryWrapper<MmpCoreSystemConfig> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpCoreSystemConfig> buildQueryWrapper(MmpCoreSystemConfigBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpCoreSystemConfig> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpCoreSystemConfig::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getSystemCode()), MmpCoreSystemConfig::getSystemCode, bo.getSystemCode());
        lqw.like(StringUtils.isNotBlank(bo.getSystemName()), MmpCoreSystemConfig::getSystemName, bo.getSystemName());
        lqw.eq(StringUtils.isNotBlank(bo.getSystemType()), MmpCoreSystemConfig::getSystemType, bo.getSystemType());
        lqw.eq(StringUtils.isNotBlank(bo.getSystemDescription()), MmpCoreSystemConfig::getSystemDescription, bo.getSystemDescription());
        lqw.eq(bo.getTotalScore() != null, MmpCoreSystemConfig::getTotalScore, bo.getTotalScore());
        lqw.eq(bo.getWeight() != null, MmpCoreSystemConfig::getWeight, bo.getWeight());
        lqw.eq(bo.getIsEnabled() != null, MmpCoreSystemConfig::getIsEnabled, bo.getIsEnabled());
        lqw.eq(bo.getIsCustom() != null, MmpCoreSystemConfig::getIsCustom, bo.getIsCustom());
        lqw.eq(bo.getDelFlag() != null, MmpCoreSystemConfig::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增核心制度配置
     *
     * @param bo 核心制度配置
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpCoreSystemConfigBo bo) {
        MmpCoreSystemConfig add = MapstructUtils.convert(bo, MmpCoreSystemConfig.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改核心制度配置
     *
     * @param bo 核心制度配置
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpCoreSystemConfigBo bo) {
        MmpCoreSystemConfig update = MapstructUtils.convert(bo, MmpCoreSystemConfig.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpCoreSystemConfig entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除核心制度配置信息
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
