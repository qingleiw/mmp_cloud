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
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorProfessionalRatingBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorProfessionalRatingVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorProfessionalRating;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorProfessionalRatingMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorProfessionalRatingService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 医师职业评分Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorProfessionalRatingServiceImpl implements IMmpDoctorProfessionalRatingService {

    private final MmpDoctorProfessionalRatingMapper baseMapper;

    /**
     * 查询医师职业评分
     *
     * @param id 主键
     * @return 医师职业评分
     */
    @Override
    public MmpDoctorProfessionalRatingVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询医师职业评分列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医师职业评分分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorProfessionalRatingVo> queryPageList(MmpDoctorProfessionalRatingBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorProfessionalRating> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorProfessionalRatingVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的医师职业评分列表
     *
     * @param bo 查询条件
     * @return 医师职业评分列表
     */
    @Override
    public List<MmpDoctorProfessionalRatingVo> queryList(MmpDoctorProfessionalRatingBo bo) {
        LambdaQueryWrapper<MmpDoctorProfessionalRating> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpDoctorProfessionalRating> buildQueryWrapper(MmpDoctorProfessionalRatingBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorProfessionalRating> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorProfessionalRating::getId);
        lqw.like(StringUtils.isNotBlank(bo.getDoctorName()), MmpDoctorProfessionalRating::getDoctorName, bo.getDoctorName());
        lqw.eq(bo.getRatingYear() != null, MmpDoctorProfessionalRating::getRatingYear, bo.getRatingYear());
        lqw.eq(bo.getRatingQuarter() != null, MmpDoctorProfessionalRating::getRatingQuarter, bo.getRatingQuarter());
        lqw.eq(bo.getBaseScore() != null, MmpDoctorProfessionalRating::getBaseScore, bo.getBaseScore());
        lqw.eq(bo.getComplaintDeduction() != null, MmpDoctorProfessionalRating::getComplaintDeduction, bo.getComplaintDeduction());
        lqw.eq(bo.getMedicalQualityScore() != null, MmpDoctorProfessionalRating::getMedicalQualityScore, bo.getMedicalQualityScore());
        lqw.eq(bo.getPatientSatisfaction() != null, MmpDoctorProfessionalRating::getPatientSatisfaction, bo.getPatientSatisfaction());
        lqw.eq(bo.getFinalScore() != null, MmpDoctorProfessionalRating::getFinalScore, bo.getFinalScore());
        lqw.eq(StringUtils.isNotBlank(bo.getRatingLevel()), MmpDoctorProfessionalRating::getRatingLevel, bo.getRatingLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpDoctorProfessionalRating::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增医师职业评分
     *
     * @param bo 医师职业评分
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorProfessionalRatingBo bo) {
        MmpDoctorProfessionalRating add = MapstructUtils.convert(bo, MmpDoctorProfessionalRating.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改医师职业评分
     *
     * @param bo 医师职业评分
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorProfessionalRatingBo bo) {
        MmpDoctorProfessionalRating update = MapstructUtils.convert(bo, MmpDoctorProfessionalRating.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorProfessionalRating entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除医师职业评分信息
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
