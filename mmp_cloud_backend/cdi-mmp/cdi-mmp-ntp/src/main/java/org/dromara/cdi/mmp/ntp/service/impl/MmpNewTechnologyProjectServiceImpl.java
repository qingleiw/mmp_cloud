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
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectBo;
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectVo;
import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProject;
import org.dromara.cdi.mmp.ntp.mapper.MmpNewTechnologyProjectMapper;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 新技术项目基本信息Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNewTechnologyProjectServiceImpl implements IMmpNewTechnologyProjectService {

    private final MmpNewTechnologyProjectMapper baseMapper;

    /**
     * 查询新技术项目基本信息
     *
     * @param id 主键
     * @return 新技术项目基本信息
     */
    @Override
    public MmpNewTechnologyProjectVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询新技术项目基本信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 新技术项目基本信息分页列表
     */
    @Override
    public TableDataInfo<MmpNewTechnologyProjectVo> queryPageList(MmpNewTechnologyProjectBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNewTechnologyProject> lqw = buildQueryWrapper(bo);
        Page<MmpNewTechnologyProjectVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的新技术项目基本信息列表
     *
     * @param bo 查询条件
     * @return 新技术项目基本信息列表
     */
    @Override
    public List<MmpNewTechnologyProjectVo> queryList(MmpNewTechnologyProjectBo bo) {
        LambdaQueryWrapper<MmpNewTechnologyProject> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNewTechnologyProject> buildQueryWrapper(MmpNewTechnologyProjectBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNewTechnologyProject> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNewTechnologyProject::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getProjectNo()), MmpNewTechnologyProject::getProjectNo, bo.getProjectNo());
        lqw.like(StringUtils.isNotBlank(bo.getProjectName()), MmpNewTechnologyProject::getProjectName, bo.getProjectName());
        lqw.eq(StringUtils.isNotBlank(bo.getProjectType()), MmpNewTechnologyProject::getProjectType, bo.getProjectType());
        lqw.eq(StringUtils.isNotBlank(bo.getTechnologyCategory()), MmpNewTechnologyProject::getTechnologyCategory, bo.getTechnologyCategory());
        lqw.eq(StringUtils.isNotBlank(bo.getRiskLevel()), MmpNewTechnologyProject::getRiskLevel, bo.getRiskLevel());
        lqw.eq(bo.getApplyDepartmentId() != null, MmpNewTechnologyProject::getApplyDepartmentId, bo.getApplyDepartmentId());
        lqw.like(StringUtils.isNotBlank(bo.getApplyDepartmentName()), MmpNewTechnologyProject::getApplyDepartmentName, bo.getApplyDepartmentName());
        lqw.eq(StringUtils.isNotBlank(bo.getProjectLeader()), MmpNewTechnologyProject::getProjectLeader, bo.getProjectLeader());
        lqw.eq(StringUtils.isNotBlank(bo.getProjectTeam()), MmpNewTechnologyProject::getProjectTeam, bo.getProjectTeam());
        lqw.eq(StringUtils.isNotBlank(bo.getTechnologySource()), MmpNewTechnologyProject::getTechnologySource, bo.getTechnologySource());
        lqw.eq(StringUtils.isNotBlank(bo.getApplyReason()), MmpNewTechnologyProject::getApplyReason, bo.getApplyReason());
        lqw.eq(StringUtils.isNotBlank(bo.getTechnologyDescription()), MmpNewTechnologyProject::getTechnologyDescription, bo.getTechnologyDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getIndication()), MmpNewTechnologyProject::getIndication, bo.getIndication());
        lqw.eq(StringUtils.isNotBlank(bo.getContraindication()), MmpNewTechnologyProject::getContraindication, bo.getContraindication());
        lqw.eq(StringUtils.isNotBlank(bo.getExpectedEffect()), MmpNewTechnologyProject::getExpectedEffect, bo.getExpectedEffect());
        lqw.eq(StringUtils.isNotBlank(bo.getPotentialRisk()), MmpNewTechnologyProject::getPotentialRisk, bo.getPotentialRisk());
        lqw.eq(StringUtils.isNotBlank(bo.getRiskControlMeasure()), MmpNewTechnologyProject::getRiskControlMeasure, bo.getRiskControlMeasure());
        lqw.eq(StringUtils.isNotBlank(bo.getLiteratureSupport()), MmpNewTechnologyProject::getLiteratureSupport, bo.getLiteratureSupport());
        lqw.eq(StringUtils.isNotBlank(bo.getAttachmentUrls()), MmpNewTechnologyProject::getAttachmentUrls, bo.getAttachmentUrls());
        lqw.eq(bo.getOperationCycleDays() != null, MmpNewTechnologyProject::getOperationCycleDays, bo.getOperationCycleDays());
        lqw.eq(StringUtils.isNotBlank(bo.getProgressReportCycle()), MmpNewTechnologyProject::getProgressReportCycle, bo.getProgressReportCycle());
        lqw.eq(StringUtils.isNotBlank(bo.getProjectStatus()), MmpNewTechnologyProject::getProjectStatus, bo.getProjectStatus());
        lqw.eq(bo.getApproveDate() != null, MmpNewTechnologyProject::getApproveDate, bo.getApproveDate());
        lqw.eq(bo.getStartDate() != null, MmpNewTechnologyProject::getStartDate, bo.getStartDate());
        lqw.eq(bo.getEndDate() != null, MmpNewTechnologyProject::getEndDate, bo.getEndDate());
        lqw.eq(bo.getActualEndDate() != null, MmpNewTechnologyProject::getActualEndDate, bo.getActualEndDate());
        lqw.eq(StringUtils.isNotBlank(bo.getConclusionType()), MmpNewTechnologyProject::getConclusionType, bo.getConclusionType());
        lqw.eq(bo.getWorkflowInstanceId() != null, MmpNewTechnologyProject::getWorkflowInstanceId, bo.getWorkflowInstanceId());
        return lqw;
    }

    /**
     * 新增新技术项目基本信息
     *
     * @param bo 新技术项目基本信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNewTechnologyProjectBo bo) {
        MmpNewTechnologyProject add = MapstructUtils.convert(bo, MmpNewTechnologyProject.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改新技术项目基本信息
     *
     * @param bo 新技术项目基本信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNewTechnologyProjectBo bo) {
        MmpNewTechnologyProject update = MapstructUtils.convert(bo, MmpNewTechnologyProject.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNewTechnologyProject entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除新技术项目基本信息信息
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
