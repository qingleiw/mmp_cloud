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
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationPermissionAdjustmentBo;
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationPermissionAdjustmentVo;
import org.dromara.cdi.mmp.qualification.domain.MmpQualificationPermissionAdjustment;
import org.dromara.cdi.mmp.qualification.mapper.MmpQualificationPermissionAdjustmentMapper;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationPermissionAdjustmentService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 资质权限调整历史Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQualificationPermissionAdjustmentServiceImpl implements IMmpQualificationPermissionAdjustmentService {

    private final MmpQualificationPermissionAdjustmentMapper baseMapper;

    /**
     * 查询资质权限调整历史
     *
     * @param id 主键
     * @return 资质权限调整历史
     */
    @Override
    public MmpQualificationPermissionAdjustmentVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询资质权限调整历史列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质权限调整历史分页列表
     */
    @Override
    public TableDataInfo<MmpQualificationPermissionAdjustmentVo> queryPageList(MmpQualificationPermissionAdjustmentBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQualificationPermissionAdjustment> lqw = buildQueryWrapper(bo);
        Page<MmpQualificationPermissionAdjustmentVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的资质权限调整历史列表
     *
     * @param bo 查询条件
     * @return 资质权限调整历史列表
     */
    @Override
    public List<MmpQualificationPermissionAdjustmentVo> queryList(MmpQualificationPermissionAdjustmentBo bo) {
        LambdaQueryWrapper<MmpQualificationPermissionAdjustment> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQualificationPermissionAdjustment> buildQueryWrapper(MmpQualificationPermissionAdjustmentBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQualificationPermissionAdjustment> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQualificationPermissionAdjustment::getId);
        lqw.like(StringUtils.isNotBlank(bo.getDoctorName()), MmpQualificationPermissionAdjustment::getDoctorName, bo.getDoctorName());
        lqw.eq(StringUtils.isNotBlank(bo.getQualificationType()), MmpQualificationPermissionAdjustment::getQualificationType, bo.getQualificationType());
        lqw.eq(StringUtils.isNotBlank(bo.getOriginalLevel()), MmpQualificationPermissionAdjustment::getOriginalLevel, bo.getOriginalLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getNewLevel()), MmpQualificationPermissionAdjustment::getNewLevel, bo.getNewLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getAdjustmentReason()), MmpQualificationPermissionAdjustment::getAdjustmentReason, bo.getAdjustmentReason());
        lqw.eq(StringUtils.isNotBlank(bo.getAdjustmentBasis()), MmpQualificationPermissionAdjustment::getAdjustmentBasis, bo.getAdjustmentBasis());
        lqw.eq(bo.getAdjustmentTime() != null, MmpQualificationPermissionAdjustment::getAdjustmentTime, bo.getAdjustmentTime());
        lqw.like(StringUtils.isNotBlank(bo.getOperatorName()), MmpQualificationPermissionAdjustment::getOperatorName, bo.getOperatorName());
        lqw.eq(bo.getIsAutoAdjustment() != null, MmpQualificationPermissionAdjustment::getIsAutoAdjustment, bo.getIsAutoAdjustment());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpQualificationPermissionAdjustment::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增资质权限调整历史
     *
     * @param bo 资质权限调整历史
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQualificationPermissionAdjustmentBo bo) {
        MmpQualificationPermissionAdjustment add = MapstructUtils.convert(bo, MmpQualificationPermissionAdjustment.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改资质权限调整历史
     *
     * @param bo 资质权限调整历史
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQualificationPermissionAdjustmentBo bo) {
        MmpQualificationPermissionAdjustment update = MapstructUtils.convert(bo, MmpQualificationPermissionAdjustment.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQualificationPermissionAdjustment entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除资质权限调整历史信息
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
