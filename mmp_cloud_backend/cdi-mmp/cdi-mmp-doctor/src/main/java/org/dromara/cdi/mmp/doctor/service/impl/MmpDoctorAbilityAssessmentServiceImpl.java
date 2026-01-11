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
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorAbilityAssessmentBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorAbilityAssessmentVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorAbilityAssessment;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorAbilityAssessmentMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorAbilityAssessmentService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 医师能力评估Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorAbilityAssessmentServiceImpl implements IMmpDoctorAbilityAssessmentService {

    private final MmpDoctorAbilityAssessmentMapper baseMapper;

    /**
     * 查询医师能力评估
     *
     * @param id 主键
     * @return 医师能力评估
     */
    @Override
    public MmpDoctorAbilityAssessmentVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询医师能力评估列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医师能力评估分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorAbilityAssessmentVo> queryPageList(MmpDoctorAbilityAssessmentBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorAbilityAssessment> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorAbilityAssessmentVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的医师能力评估列表
     *
     * @param bo 查询条件
     * @return 医师能力评估列表
     */
    @Override
    public List<MmpDoctorAbilityAssessmentVo> queryList(MmpDoctorAbilityAssessmentBo bo) {
        LambdaQueryWrapper<MmpDoctorAbilityAssessment> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpDoctorAbilityAssessment> buildQueryWrapper(MmpDoctorAbilityAssessmentBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorAbilityAssessment> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorAbilityAssessment::getId);
        lqw.eq(bo.getDoctorId() != null, MmpDoctorAbilityAssessment::getDoctorId, bo.getDoctorId());
        lqw.eq(bo.getAssessmentYear() != null, MmpDoctorAbilityAssessment::getAssessmentYear, bo.getAssessmentYear());
        lqw.eq(StringUtils.isNotBlank(bo.getAssessmentType()), MmpDoctorAbilityAssessment::getAssessmentType, bo.getAssessmentType());
        lqw.eq(bo.getClinicalAbilityScore() != null, MmpDoctorAbilityAssessment::getClinicalAbilityScore, bo.getClinicalAbilityScore());
        lqw.eq(bo.getTeachingAbilityScore() != null, MmpDoctorAbilityAssessment::getTeachingAbilityScore, bo.getTeachingAbilityScore());
        lqw.eq(bo.getResearchAbilityScore() != null, MmpDoctorAbilityAssessment::getResearchAbilityScore, bo.getResearchAbilityScore());
        lqw.eq(bo.getManagementAbilityScore() != null, MmpDoctorAbilityAssessment::getManagementAbilityScore, bo.getManagementAbilityScore());
        lqw.eq(bo.getTotalScore() != null, MmpDoctorAbilityAssessment::getTotalScore, bo.getTotalScore());
        lqw.eq(StringUtils.isNotBlank(bo.getAssessmentResult()), MmpDoctorAbilityAssessment::getAssessmentResult, bo.getAssessmentResult());
        lqw.eq(StringUtils.isNotBlank(bo.getAssessor()), MmpDoctorAbilityAssessment::getAssessor, bo.getAssessor());
        lqw.eq(bo.getAssessmentDate() != null, MmpDoctorAbilityAssessment::getAssessmentDate, bo.getAssessmentDate());
        lqw.eq(bo.getDelFlag() != null, MmpDoctorAbilityAssessment::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增医师能力评估
     *
     * @param bo 医师能力评估
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorAbilityAssessmentBo bo) {
        MmpDoctorAbilityAssessment add = MapstructUtils.convert(bo, MmpDoctorAbilityAssessment.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改医师能力评估
     *
     * @param bo 医师能力评估
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorAbilityAssessmentBo bo) {
        MmpDoctorAbilityAssessment update = MapstructUtils.convert(bo, MmpDoctorAbilityAssessment.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorAbilityAssessment entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除医师能力评估信息
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
