package org.dromara.cdi.mmp.doctor.service.impl;

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
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorQualificationCatalogBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorQualificationCatalogVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorQualificationCatalog;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorQualificationCatalogMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorQualificationCatalogService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 医师资质目录Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorQualificationCatalogServiceImpl implements IMmpDoctorQualificationCatalogService {

    private final MmpDoctorQualificationCatalogMapper baseMapper;

    /**
     * 查询医师资质目录
     *
     * @param id 主键
     * @return 医师资质目录
     */
    @Override
    public MmpDoctorQualificationCatalogVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询医师资质目录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医师资质目录分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorQualificationCatalogVo> queryPageList(MmpDoctorQualificationCatalogBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorQualificationCatalog> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorQualificationCatalogVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的医师资质目录列表
     *
     * @param bo 查询条件
     * @return 医师资质目录列表
     */
    @Override
    public List<MmpDoctorQualificationCatalogVo> queryList(MmpDoctorQualificationCatalogBo bo) {
        LambdaQueryWrapper<MmpDoctorQualificationCatalog> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpDoctorQualificationCatalog> buildQueryWrapper(MmpDoctorQualificationCatalogBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorQualificationCatalog> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorQualificationCatalog::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getCatalogCode()), MmpDoctorQualificationCatalog::getCatalogCode, bo.getCatalogCode());
        lqw.like(StringUtils.isNotBlank(bo.getCatalogName()), MmpDoctorQualificationCatalog::getCatalogName, bo.getCatalogName());
        lqw.eq(bo.getParentId() != null, MmpDoctorQualificationCatalog::getParentId, bo.getParentId());
        lqw.eq(bo.getCatalogLevel() != null, MmpDoctorQualificationCatalog::getCatalogLevel, bo.getCatalogLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getCatalogType()), MmpDoctorQualificationCatalog::getCatalogType, bo.getCatalogType());
        lqw.eq(StringUtils.isNotBlank(bo.getSubType()), MmpDoctorQualificationCatalog::getSubType, bo.getSubType());
        lqw.eq(StringUtils.isNotBlank(bo.getDescription()), MmpDoctorQualificationCatalog::getDescription, bo.getDescription());
        lqw.eq(bo.getSortOrder() != null, MmpDoctorQualificationCatalog::getSortOrder, bo.getSortOrder());
        lqw.eq(bo.getIsEnabled() != null, MmpDoctorQualificationCatalog::getIsEnabled, bo.getIsEnabled());
        lqw.eq(bo.getDelFlag() != null, MmpDoctorQualificationCatalog::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增医师资质目录
     *
     * @param bo 医师资质目录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorQualificationCatalogBo bo) {
        MmpDoctorQualificationCatalog add = MapstructUtils.convert(bo, MmpDoctorQualificationCatalog.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改医师资质目录
     *
     * @param bo 医师资质目录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorQualificationCatalogBo bo) {
        MmpDoctorQualificationCatalog update = MapstructUtils.convert(bo, MmpDoctorQualificationCatalog.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorQualificationCatalog entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除医师资质目录信息
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
