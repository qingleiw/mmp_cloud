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
import org.dromara.cdi.mmp.qualification.domain.bo.MmpDepartmentQualificationCatalogBo;
import org.dromara.cdi.mmp.qualification.domain.vo.MmpDepartmentQualificationCatalogVo;
import org.dromara.cdi.mmp.qualification.domain.MmpDepartmentQualificationCatalog;
import org.dromara.cdi.mmp.qualification.mapper.MmpDepartmentQualificationCatalogMapper;
import org.dromara.cdi.mmp.qualification.service.IMmpDepartmentQualificationCatalogService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 科室资质目录Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDepartmentQualificationCatalogServiceImpl implements IMmpDepartmentQualificationCatalogService {

    private final MmpDepartmentQualificationCatalogMapper baseMapper;

    /**
     * 查询科室资质目录
     *
     * @param id 主键
     * @return 科室资质目录
     */
    @Override
    public MmpDepartmentQualificationCatalogVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询科室资质目录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 科室资质目录分页列表
     */
    @Override
    public TableDataInfo<MmpDepartmentQualificationCatalogVo> queryPageList(MmpDepartmentQualificationCatalogBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDepartmentQualificationCatalog> lqw = buildQueryWrapper(bo);
        Page<MmpDepartmentQualificationCatalogVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的科室资质目录列表
     *
     * @param bo 查询条件
     * @return 科室资质目录列表
     */
    @Override
    public List<MmpDepartmentQualificationCatalogVo> queryList(MmpDepartmentQualificationCatalogBo bo) {
        LambdaQueryWrapper<MmpDepartmentQualificationCatalog> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpDepartmentQualificationCatalog> buildQueryWrapper(MmpDepartmentQualificationCatalogBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDepartmentQualificationCatalog> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDepartmentQualificationCatalog::getId);
        lqw.eq(bo.getDepartmentId() != null, MmpDepartmentQualificationCatalog::getDepartmentId, bo.getDepartmentId());
        lqw.eq(bo.getQualificationId() != null, MmpDepartmentQualificationCatalog::getQualificationId, bo.getQualificationId());
        lqw.eq(StringUtils.isNotBlank(bo.getQualificationType()), MmpDepartmentQualificationCatalog::getQualificationType, bo.getQualificationType());
        lqw.eq(bo.getIsEnabled() != null, MmpDepartmentQualificationCatalog::getIsEnabled, bo.getIsEnabled());
        lqw.eq(StringUtils.isNotBlank(bo.getApproveStatus()), MmpDepartmentQualificationCatalog::getApproveStatus, bo.getApproveStatus());
        lqw.eq(bo.getApproveTime() != null, MmpDepartmentQualificationCatalog::getApproveTime, bo.getApproveTime());
        lqw.eq(StringUtils.isNotBlank(bo.getApproveBy()), MmpDepartmentQualificationCatalog::getApproveBy, bo.getApproveBy());
        lqw.eq(bo.getDelFlag() != null, MmpDepartmentQualificationCatalog::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增科室资质目录
     *
     * @param bo 科室资质目录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDepartmentQualificationCatalogBo bo) {
        MmpDepartmentQualificationCatalog add = MapstructUtils.convert(bo, MmpDepartmentQualificationCatalog.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改科室资质目录
     *
     * @param bo 科室资质目录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDepartmentQualificationCatalogBo bo) {
        MmpDepartmentQualificationCatalog update = MapstructUtils.convert(bo, MmpDepartmentQualificationCatalog.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDepartmentQualificationCatalog entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除科室资质目录信息
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
