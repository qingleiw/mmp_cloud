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
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationCatalogBo;
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationCatalogVo;
import org.dromara.cdi.mmp.qualification.domain.MmpQualificationCatalog;
import org.dromara.cdi.mmp.qualification.mapper.MmpQualificationCatalogMapper;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationCatalogService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 医生手术授权目录Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQualificationCatalogServiceImpl implements IMmpQualificationCatalogService {

    private final MmpQualificationCatalogMapper baseMapper;

    /**
     * 查询医生手术授权目录
     *
     * @param id 主键
     * @return 医生手术授权目录
     */
    @Override
    public MmpQualificationCatalogVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询医生手术授权目录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医生手术授权目录分页列表
     */
    @Override
    public TableDataInfo<MmpQualificationCatalogVo> queryPageList(MmpQualificationCatalogBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQualificationCatalog> lqw = buildQueryWrapper(bo);
        Page<MmpQualificationCatalogVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的医生手术授权目录列表
     *
     * @param bo 查询条件
     * @return 医生手术授权目录列表
     */
    @Override
    public List<MmpQualificationCatalogVo> queryList(MmpQualificationCatalogBo bo) {
        LambdaQueryWrapper<MmpQualificationCatalog> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQualificationCatalog> buildQueryWrapper(MmpQualificationCatalogBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQualificationCatalog> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQualificationCatalog::getId);
        lqw.like(StringUtils.isNotBlank(bo.getDoctorName()), MmpQualificationCatalog::getDoctorName, bo.getDoctorName());
        lqw.eq(StringUtils.isNotBlank(bo.getDepartment()), MmpQualificationCatalog::getDepartment, bo.getDepartment());
        lqw.eq(StringUtils.isNotBlank(bo.getPosition()), MmpQualificationCatalog::getPosition, bo.getPosition());
        lqw.eq(StringUtils.isNotBlank(bo.getTitle()), MmpQualificationCatalog::getTitle, bo.getTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getAuthorizedLevel()), MmpQualificationCatalog::getAuthorizedLevel, bo.getAuthorizedLevel());
        lqw.eq(bo.getLevel1() != null, MmpQualificationCatalog::getLevel1, bo.getLevel1());
        lqw.eq(bo.getLevel2() != null, MmpQualificationCatalog::getLevel2, bo.getLevel2());
        lqw.eq(bo.getLevel3() != null, MmpQualificationCatalog::getLevel3, bo.getLevel3());
        lqw.eq(bo.getLevel4() != null, MmpQualificationCatalog::getLevel4, bo.getLevel4());
        lqw.like(StringUtils.isNotBlank(bo.getSurgeryName()), MmpQualificationCatalog::getSurgeryName, bo.getSurgeryName());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryCode()), MmpQualificationCatalog::getSurgeryCode, bo.getSurgeryCode());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryLevel()), MmpQualificationCatalog::getSurgeryLevel, bo.getSurgeryLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getQualificationType()), MmpQualificationCatalog::getQualificationType, bo.getQualificationType());
        lqw.eq(bo.getValidStartDate() != null, MmpQualificationCatalog::getValidStartDate, bo.getValidStartDate());
        lqw.eq(bo.getValidEndDate() != null, MmpQualificationCatalog::getValidEndDate, bo.getValidEndDate());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpQualificationCatalog::getStatus, bo.getStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getDataSource()), MmpQualificationCatalog::getDataSource, bo.getDataSource());
        lqw.eq(bo.getDelFlag() != null, MmpQualificationCatalog::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增医生手术授权目录
     *
     * @param bo 医生手术授权目录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQualificationCatalogBo bo) {
        MmpQualificationCatalog add = MapstructUtils.convert(bo, MmpQualificationCatalog.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改医生手术授权目录
     *
     * @param bo 医生手术授权目录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQualificationCatalogBo bo) {
        MmpQualificationCatalog update = MapstructUtils.convert(bo, MmpQualificationCatalog.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQualificationCatalog entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除医生手术授权目录信息
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
