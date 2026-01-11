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
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorEthicsEvaluationBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorEthicsEvaluationVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorEthicsEvaluation;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorEthicsEvaluationMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorEthicsEvaluationService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 医德医风考评Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorEthicsEvaluationServiceImpl implements IMmpDoctorEthicsEvaluationService {

    private final MmpDoctorEthicsEvaluationMapper baseMapper;

    /**
     * 查询医德医风考评
     *
     * @param id 主键
     * @return 医德医风考评
     */
    @Override
    public MmpDoctorEthicsEvaluationVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询医德医风考评列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医德医风考评分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorEthicsEvaluationVo> queryPageList(MmpDoctorEthicsEvaluationBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorEthicsEvaluation> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorEthicsEvaluationVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的医德医风考评列表
     *
     * @param bo 查询条件
     * @return 医德医风考评列表
     */
    @Override
    public List<MmpDoctorEthicsEvaluationVo> queryList(MmpDoctorEthicsEvaluationBo bo) {
        LambdaQueryWrapper<MmpDoctorEthicsEvaluation> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpDoctorEthicsEvaluation> buildQueryWrapper(MmpDoctorEthicsEvaluationBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorEthicsEvaluation> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorEthicsEvaluation::getId);
        lqw.eq(bo.getDoctorId() != null, MmpDoctorEthicsEvaluation::getDoctorId, bo.getDoctorId());
        lqw.eq(bo.getEvaluationYear() != null, MmpDoctorEthicsEvaluation::getEvaluationYear, bo.getEvaluationYear());
        lqw.eq(StringUtils.isNotBlank(bo.getEvaluationCycle()), MmpDoctorEthicsEvaluation::getEvaluationCycle, bo.getEvaluationCycle());
        lqw.eq(bo.getSelfScore() != null, MmpDoctorEthicsEvaluation::getSelfScore, bo.getSelfScore());
        lqw.eq(bo.getPeerScore() != null, MmpDoctorEthicsEvaluation::getPeerScore, bo.getPeerScore());
        lqw.eq(bo.getPatientScore() != null, MmpDoctorEthicsEvaluation::getPatientScore, bo.getPatientScore());
        lqw.eq(bo.getDepartmentScore() != null, MmpDoctorEthicsEvaluation::getDepartmentScore, bo.getDepartmentScore());
        lqw.eq(bo.getHospitalScore() != null, MmpDoctorEthicsEvaluation::getHospitalScore, bo.getHospitalScore());
        lqw.eq(bo.getTotalScore() != null, MmpDoctorEthicsEvaluation::getTotalScore, bo.getTotalScore());
        lqw.eq(StringUtils.isNotBlank(bo.getEvaluationResult()), MmpDoctorEthicsEvaluation::getEvaluationResult, bo.getEvaluationResult());
        lqw.eq(StringUtils.isNotBlank(bo.getRewardPunishment()), MmpDoctorEthicsEvaluation::getRewardPunishment, bo.getRewardPunishment());
        lqw.eq(bo.getDelFlag() != null, MmpDoctorEthicsEvaluation::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增医德医风考评
     *
     * @param bo 医德医风考评
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorEthicsEvaluationBo bo) {
        MmpDoctorEthicsEvaluation add = MapstructUtils.convert(bo, MmpDoctorEthicsEvaluation.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改医德医风考评
     *
     * @param bo 医德医风考评
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorEthicsEvaluationBo bo) {
        MmpDoctorEthicsEvaluation update = MapstructUtils.convert(bo, MmpDoctorEthicsEvaluation.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorEthicsEvaluation entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除医德医风考评信息
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
