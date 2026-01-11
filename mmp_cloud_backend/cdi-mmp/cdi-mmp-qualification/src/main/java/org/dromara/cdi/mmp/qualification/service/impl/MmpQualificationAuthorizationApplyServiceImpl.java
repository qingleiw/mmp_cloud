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
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationAuthorizationApplyBo;
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationAuthorizationApplyVo;
import org.dromara.cdi.mmp.qualification.domain.MmpQualificationAuthorizationApply;
import org.dromara.cdi.mmp.qualification.mapper.MmpQualificationAuthorizationApplyMapper;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationAuthorizationApplyService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 资质授权申请Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQualificationAuthorizationApplyServiceImpl implements IMmpQualificationAuthorizationApplyService {

    private final MmpQualificationAuthorizationApplyMapper baseMapper;

    /**
     * 查询资质授权申请
     *
     * @param id 主键
     * @return 资质授权申请
     */
    @Override
    public MmpQualificationAuthorizationApplyVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询资质授权申请列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质授权申请分页列表
     */
    @Override
    public TableDataInfo<MmpQualificationAuthorizationApplyVo> queryPageList(MmpQualificationAuthorizationApplyBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQualificationAuthorizationApply> lqw = buildQueryWrapper(bo);
        Page<MmpQualificationAuthorizationApplyVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的资质授权申请列表
     *
     * @param bo 查询条件
     * @return 资质授权申请列表
     */
    @Override
    public List<MmpQualificationAuthorizationApplyVo> queryList(MmpQualificationAuthorizationApplyBo bo) {
        LambdaQueryWrapper<MmpQualificationAuthorizationApply> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQualificationAuthorizationApply> buildQueryWrapper(MmpQualificationAuthorizationApplyBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQualificationAuthorizationApply> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQualificationAuthorizationApply::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getApplyNo()), MmpQualificationAuthorizationApply::getApplyNo, bo.getApplyNo());
        lqw.eq(bo.getApplicantId() != null, MmpQualificationAuthorizationApply::getApplicantId, bo.getApplicantId());
        lqw.like(StringUtils.isNotBlank(bo.getApplicantName()), MmpQualificationAuthorizationApply::getApplicantName, bo.getApplicantName());
        lqw.eq(StringUtils.isNotBlank(bo.getApplicantType()), MmpQualificationAuthorizationApply::getApplicantType, bo.getApplicantType());
        lqw.eq(bo.getDepartmentId() != null, MmpQualificationAuthorizationApply::getDepartmentId, bo.getDepartmentId());
        lqw.like(StringUtils.isNotBlank(bo.getDepartmentName()), MmpQualificationAuthorizationApply::getDepartmentName, bo.getDepartmentName());
        lqw.eq(StringUtils.isNotBlank(bo.getQualificationIds()), MmpQualificationAuthorizationApply::getQualificationIds, bo.getQualificationIds());
        lqw.eq(StringUtils.isNotBlank(bo.getApplyReason()), MmpQualificationAuthorizationApply::getApplyReason, bo.getApplyReason());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateIds()), MmpQualificationAuthorizationApply::getCertificateIds, bo.getCertificateIds());
        lqw.eq(bo.getExamScore() != null, MmpQualificationAuthorizationApply::getExamScore, bo.getExamScore());
        lqw.eq(StringUtils.isNotBlank(bo.getWorkQuantity()), MmpQualificationAuthorizationApply::getWorkQuantity, bo.getWorkQuantity());
        lqw.eq(StringUtils.isNotBlank(bo.getWorkQuality()), MmpQualificationAuthorizationApply::getWorkQuality, bo.getWorkQuality());
        lqw.eq(StringUtils.isNotBlank(bo.getApplyStatus()), MmpQualificationAuthorizationApply::getApplyStatus, bo.getApplyStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getCurrentNode()), MmpQualificationAuthorizationApply::getCurrentNode, bo.getCurrentNode());
        lqw.eq(bo.getWorkflowInstanceId() != null, MmpQualificationAuthorizationApply::getWorkflowInstanceId, bo.getWorkflowInstanceId());
        lqw.eq(bo.getDelFlag() != null, MmpQualificationAuthorizationApply::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增资质授权申请
     *
     * @param bo 资质授权申请
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQualificationAuthorizationApplyBo bo) {
        MmpQualificationAuthorizationApply add = MapstructUtils.convert(bo, MmpQualificationAuthorizationApply.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改资质授权申请
     *
     * @param bo 资质授权申请
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQualificationAuthorizationApplyBo bo) {
        MmpQualificationAuthorizationApply update = MapstructUtils.convert(bo, MmpQualificationAuthorizationApply.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQualificationAuthorizationApply entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除资质授权申请信息
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
