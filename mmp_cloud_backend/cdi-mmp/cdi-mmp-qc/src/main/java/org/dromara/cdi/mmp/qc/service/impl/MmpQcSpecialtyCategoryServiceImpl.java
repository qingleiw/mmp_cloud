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
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcSpecialtyCategoryBo;
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcSpecialtyCategoryVo;
import org.dromara.cdi.mmp.qc.domain.MmpQcSpecialtyCategory;
import org.dromara.cdi.mmp.qc.mapper.MmpQcSpecialtyCategoryMapper;
import org.dromara.cdi.mmp.qc.service.IMmpQcSpecialtyCategoryService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 专业类别Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQcSpecialtyCategoryServiceImpl implements IMmpQcSpecialtyCategoryService {

    private final MmpQcSpecialtyCategoryMapper baseMapper;

    /**
     * 查询专业类别
     *
     * @param id 主键
     * @return 专业类别
     */
    @Override
    public MmpQcSpecialtyCategoryVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询专业类别列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 专业类别分页列表
     */
    @Override
    public TableDataInfo<MmpQcSpecialtyCategoryVo> queryPageList(MmpQcSpecialtyCategoryBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQcSpecialtyCategory> lqw = buildQueryWrapper(bo);
        Page<MmpQcSpecialtyCategoryVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的专业类别列表
     *
     * @param bo 查询条件
     * @return 专业类别列表
     */
    @Override
    public List<MmpQcSpecialtyCategoryVo> queryList(MmpQcSpecialtyCategoryBo bo) {
        LambdaQueryWrapper<MmpQcSpecialtyCategory> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQcSpecialtyCategory> buildQueryWrapper(MmpQcSpecialtyCategoryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQcSpecialtyCategory> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQcSpecialtyCategory::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getCategoryCode()), MmpQcSpecialtyCategory::getCategoryCode, bo.getCategoryCode());
        lqw.like(StringUtils.isNotBlank(bo.getCategoryName()), MmpQcSpecialtyCategory::getCategoryName, bo.getCategoryName());
        lqw.eq(bo.getPublishYear() != null, MmpQcSpecialtyCategory::getPublishYear, bo.getPublishYear());
        lqw.eq(bo.getSortOrder() != null, MmpQcSpecialtyCategory::getSortOrder, bo.getSortOrder());
        lqw.eq(bo.getStatus() != null, MmpQcSpecialtyCategory::getStatus, bo.getStatus());
        lqw.eq(bo.getDelFlag() != null, MmpQcSpecialtyCategory::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增专业类别
     *
     * @param bo 专业类别
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQcSpecialtyCategoryBo bo) {
        MmpQcSpecialtyCategory add = MapstructUtils.convert(bo, MmpQcSpecialtyCategory.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改专业类别
     *
     * @param bo 专业类别
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQcSpecialtyCategoryBo bo) {
        MmpQcSpecialtyCategory update = MapstructUtils.convert(bo, MmpQcSpecialtyCategory.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQcSpecialtyCategory entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除专业类别信息
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
