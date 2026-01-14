package org.dromara.system.service.impl;

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
import org.dromara.system.domain.bo.MmpSurgeryCatalogBo;
import org.dromara.system.domain.vo.MmpSurgeryCatalogVo;
import org.dromara.system.domain.MmpSurgeryCatalog;
import org.dromara.system.mapper.MmpSurgeryCatalogMapper;
import org.dromara.system.service.IMmpSurgeryCatalogService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 手术目录Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-02
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSurgeryCatalogServiceImpl implements IMmpSurgeryCatalogService {

    private final MmpSurgeryCatalogMapper baseMapper;

    /**
     * 查询手术目录
     *
     * @param id 主键
     * @return 手术目录
     */
    @Override
    public MmpSurgeryCatalogVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询手术目录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 手术目录分页列表
     */
    @Override
    public TableDataInfo<MmpSurgeryCatalogVo> queryPageList(MmpSurgeryCatalogBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSurgeryCatalog> lqw = buildQueryWrapper(bo);
        Page<MmpSurgeryCatalogVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的手术目录列表
     *
     * @param bo 查询条件
     * @return 手术目录列表
     */
    @Override
    public List<MmpSurgeryCatalogVo> queryList(MmpSurgeryCatalogBo bo) {
        LambdaQueryWrapper<MmpSurgeryCatalog> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSurgeryCatalog> buildQueryWrapper(MmpSurgeryCatalogBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSurgeryCatalog> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSurgeryCatalog::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getAdditionalCode()), MmpSurgeryCatalog::getAdditionalCode, bo.getAdditionalCode());
        lqw.eq(StringUtils.isNotBlank(bo.getDetailCode()), MmpSurgeryCatalog::getDetailCode, bo.getDetailCode());
        lqw.like(StringUtils.isNotBlank(bo.getSurgeryName()), MmpSurgeryCatalog::getSurgeryName, bo.getSurgeryName());
        lqw.eq(StringUtils.isNotBlank(bo.getCategory()), MmpSurgeryCatalog::getCategory, bo.getCategory());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryLevel()), MmpSurgeryCatalog::getSurgeryLevel, bo.getSurgeryLevel());
        lqw.eq(bo.getIsEnabled() != null, MmpSurgeryCatalog::getIsEnabled, bo.getIsEnabled());
        lqw.eq(StringUtils.isNotBlank(bo.getDepartment()), MmpSurgeryCatalog::getDepartment, bo.getDepartment());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryCategory()), MmpSurgeryCatalog::getSurgeryCategory, bo.getSurgeryCategory());
        return lqw;
    }

    /**
     * 新增手术目录
     *
     * @param bo 手术目录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSurgeryCatalogBo bo) {
        MmpSurgeryCatalog add = MapstructUtils.convert(bo, MmpSurgeryCatalog.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改手术目录
     *
     * @param bo 手术目录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSurgeryCatalogBo bo) {
        MmpSurgeryCatalog update = MapstructUtils.convert(bo, MmpSurgeryCatalog.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSurgeryCatalog entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除手术目录信息
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
