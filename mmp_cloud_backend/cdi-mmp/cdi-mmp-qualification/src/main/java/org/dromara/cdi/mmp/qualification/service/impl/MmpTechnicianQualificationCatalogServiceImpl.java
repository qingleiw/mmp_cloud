package org.dromara.cdi.mmp.qualification.service.impl;

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
import org.dromara.cdi.mmp.qualification.domain.bo.MmpTechnicianQualificationCatalogBo;
import org.dromara.cdi.mmp.qualification.domain.vo.MmpTechnicianQualificationCatalogVo;
import org.dromara.cdi.mmp.qualification.domain.MmpTechnicianQualificationCatalog;
import org.dromara.cdi.mmp.qualification.mapper.MmpTechnicianQualificationCatalogMapper;
import org.dromara.cdi.mmp.qualification.service.IMmpTechnicianQualificationCatalogService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 医技资质目录Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpTechnicianQualificationCatalogServiceImpl implements IMmpTechnicianQualificationCatalogService {

    private final MmpTechnicianQualificationCatalogMapper baseMapper;

    /**
     * 查询医技资质目录
     *
     * @param id 主键
     * @return 医技资质目录
     */
    @Override
    public MmpTechnicianQualificationCatalogVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询医技资质目录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医技资质目录分页列表
     */
    @Override
    public TableDataInfo<MmpTechnicianQualificationCatalogVo> queryPageList(MmpTechnicianQualificationCatalogBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpTechnicianQualificationCatalog> lqw = buildQueryWrapper(bo);
        Page<MmpTechnicianQualificationCatalogVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的医技资质目录列表
     *
     * @param bo 查询条件
     * @return 医技资质目录列表
     */
    @Override
    public List<MmpTechnicianQualificationCatalogVo> queryList(MmpTechnicianQualificationCatalogBo bo) {
        LambdaQueryWrapper<MmpTechnicianQualificationCatalog> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpTechnicianQualificationCatalog> buildQueryWrapper(MmpTechnicianQualificationCatalogBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpTechnicianQualificationCatalog> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpTechnicianQualificationCatalog::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getCatalogCode()), MmpTechnicianQualificationCatalog::getCatalogCode, bo.getCatalogCode());
        lqw.like(StringUtils.isNotBlank(bo.getCatalogName()), MmpTechnicianQualificationCatalog::getCatalogName, bo.getCatalogName());
        lqw.eq(bo.getParentId() != null, MmpTechnicianQualificationCatalog::getParentId, bo.getParentId());
        lqw.eq(bo.getCatalogLevel() != null, MmpTechnicianQualificationCatalog::getCatalogLevel, bo.getCatalogLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getCatalogType()), MmpTechnicianQualificationCatalog::getCatalogType, bo.getCatalogType());
        lqw.eq(StringUtils.isNotBlank(bo.getDescription()), MmpTechnicianQualificationCatalog::getDescription, bo.getDescription());
        lqw.eq(bo.getSortOrder() != null, MmpTechnicianQualificationCatalog::getSortOrder, bo.getSortOrder());
        lqw.eq(bo.getIsEnabled() != null, MmpTechnicianQualificationCatalog::getIsEnabled, bo.getIsEnabled());
        lqw.eq(bo.getDelFlag() != null, MmpTechnicianQualificationCatalog::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增医技资质目录
     *
     * @param bo 医技资质目录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpTechnicianQualificationCatalogBo bo) {
        MmpTechnicianQualificationCatalog add = MapstructUtils.convert(bo, MmpTechnicianQualificationCatalog.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改医技资质目录
     *
     * @param bo 医技资质目录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpTechnicianQualificationCatalogBo bo) {
        MmpTechnicianQualificationCatalog update = MapstructUtils.convert(bo, MmpTechnicianQualificationCatalog.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpTechnicianQualificationCatalog entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除医技资质目录信息
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
