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
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectMappingBo;
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectMappingVo;
import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectMapping;
import org.dromara.cdi.mmp.ntp.mapper.MmpNewTechnologyProjectMappingMapper;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectMappingService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 新技术项目对码Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNewTechnologyProjectMappingServiceImpl implements IMmpNewTechnologyProjectMappingService {

    private final MmpNewTechnologyProjectMappingMapper baseMapper;

    /**
     * 查询新技术项目对码
     *
     * @param id 主键
     * @return 新技术项目对码
     */
    @Override
    public MmpNewTechnologyProjectMappingVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询新技术项目对码列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 新技术项目对码分页列表
     */
    @Override
    public TableDataInfo<MmpNewTechnologyProjectMappingVo> queryPageList(MmpNewTechnologyProjectMappingBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNewTechnologyProjectMapping> lqw = buildQueryWrapper(bo);
        Page<MmpNewTechnologyProjectMappingVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的新技术项目对码列表
     *
     * @param bo 查询条件
     * @return 新技术项目对码列表
     */
    @Override
    public List<MmpNewTechnologyProjectMappingVo> queryList(MmpNewTechnologyProjectMappingBo bo) {
        LambdaQueryWrapper<MmpNewTechnologyProjectMapping> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNewTechnologyProjectMapping> buildQueryWrapper(MmpNewTechnologyProjectMappingBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNewTechnologyProjectMapping> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNewTechnologyProjectMapping::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getMappingType()), MmpNewTechnologyProjectMapping::getMappingType, bo.getMappingType());
        lqw.eq(StringUtils.isNotBlank(bo.getSourceCode()), MmpNewTechnologyProjectMapping::getSourceCode, bo.getSourceCode());
        lqw.like(StringUtils.isNotBlank(bo.getSourceName()), MmpNewTechnologyProjectMapping::getSourceName, bo.getSourceName());
        lqw.eq(StringUtils.isNotBlank(bo.getTargetSystem()), MmpNewTechnologyProjectMapping::getTargetSystem, bo.getTargetSystem());
        return lqw;
    }

    /**
     * 新增新技术项目对码
     *
     * @param bo 新技术项目对码
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNewTechnologyProjectMappingBo bo) {
        MmpNewTechnologyProjectMapping add = MapstructUtils.convert(bo, MmpNewTechnologyProjectMapping.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改新技术项目对码
     *
     * @param bo 新技术项目对码
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNewTechnologyProjectMappingBo bo) {
        MmpNewTechnologyProjectMapping update = MapstructUtils.convert(bo, MmpNewTechnologyProjectMapping.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNewTechnologyProjectMapping entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除新技术项目对码信息
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
