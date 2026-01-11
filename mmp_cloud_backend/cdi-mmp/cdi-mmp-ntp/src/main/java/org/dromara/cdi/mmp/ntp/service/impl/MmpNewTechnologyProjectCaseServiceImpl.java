package org.dromara.cdi.mmp.ntp.service.impl;

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
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectCaseBo;
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectCaseVo;
import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectCase;
import org.dromara.cdi.mmp.ntp.mapper.MmpNewTechnologyProjectCaseMapper;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectCaseService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 新技术病例登记Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNewTechnologyProjectCaseServiceImpl implements IMmpNewTechnologyProjectCaseService {

    private final MmpNewTechnologyProjectCaseMapper baseMapper;

    /**
     * 查询新技术病例登记
     *
     * @param id 主键
     * @return 新技术病例登记
     */
    @Override
    public MmpNewTechnologyProjectCaseVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询新技术病例登记列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 新技术病例登记分页列表
     */
    @Override
    public TableDataInfo<MmpNewTechnologyProjectCaseVo> queryPageList(MmpNewTechnologyProjectCaseBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNewTechnologyProjectCase> lqw = buildQueryWrapper(bo);
        Page<MmpNewTechnologyProjectCaseVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的新技术病例登记列表
     *
     * @param bo 查询条件
     * @return 新技术病例登记列表
     */
    @Override
    public List<MmpNewTechnologyProjectCaseVo> queryList(MmpNewTechnologyProjectCaseBo bo) {
        LambdaQueryWrapper<MmpNewTechnologyProjectCase> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNewTechnologyProjectCase> buildQueryWrapper(MmpNewTechnologyProjectCaseBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNewTechnologyProjectCase> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNewTechnologyProjectCase::getId);
        lqw.like(StringUtils.isNotBlank(bo.getPatientName()), MmpNewTechnologyProjectCase::getPatientName, bo.getPatientName());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNewTechnologyProjectCase::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitNo()), MmpNewTechnologyProjectCase::getVisitNo, bo.getVisitNo());
        lqw.eq(bo.getVisitDate() != null, MmpNewTechnologyProjectCase::getVisitDate, bo.getVisitDate());
        lqw.like(StringUtils.isNotBlank(bo.getVisitDepartmentName()), MmpNewTechnologyProjectCase::getVisitDepartmentName, bo.getVisitDepartmentName());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagnosis()), MmpNewTechnologyProjectCase::getDiagnosis, bo.getDiagnosis());
        lqw.eq(StringUtils.isNotBlank(bo.getOperator()), MmpNewTechnologyProjectCase::getOperator, bo.getOperator());
        lqw.eq(bo.getOperationDate() != null, MmpNewTechnologyProjectCase::getOperationDate, bo.getOperationDate());
        lqw.eq(StringUtils.isNotBlank(bo.getEffectEvaluation()), MmpNewTechnologyProjectCase::getEffectEvaluation, bo.getEffectEvaluation());
        lqw.eq(StringUtils.isNotBlank(bo.getComplication()), MmpNewTechnologyProjectCase::getComplication, bo.getComplication());
        lqw.eq(StringUtils.isNotBlank(bo.getAdverseReaction()), MmpNewTechnologyProjectCase::getAdverseReaction, bo.getAdverseReaction());
        lqw.eq(StringUtils.isNotBlank(bo.getFollowUpStatus()), MmpNewTechnologyProjectCase::getFollowUpStatus, bo.getFollowUpStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getFollowUpResult()), MmpNewTechnologyProjectCase::getFollowUpResult, bo.getFollowUpResult());
        lqw.eq(bo.getIsReported() != null, MmpNewTechnologyProjectCase::getIsReported, bo.getIsReported());
        lqw.eq(bo.getReportTime() != null, MmpNewTechnologyProjectCase::getReportTime, bo.getReportTime());
        return lqw;
    }

    /**
     * 新增新技术病例登记
     *
     * @param bo 新技术病例登记
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNewTechnologyProjectCaseBo bo) {
        MmpNewTechnologyProjectCase add = MapstructUtils.convert(bo, MmpNewTechnologyProjectCase.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改新技术病例登记
     *
     * @param bo 新技术病例登记
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNewTechnologyProjectCaseBo bo) {
        MmpNewTechnologyProjectCase update = MapstructUtils.convert(bo, MmpNewTechnologyProjectCase.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNewTechnologyProjectCase entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除新技术病例登记信息
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
