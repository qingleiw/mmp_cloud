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
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorResearchProjectBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorResearchProjectVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorResearchProject;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorResearchProjectMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorResearchProjectService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 科研项目Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorResearchProjectServiceImpl implements IMmpDoctorResearchProjectService {

    private final MmpDoctorResearchProjectMapper baseMapper;

    /**
     * 查询科研项目
     *
     * @param id 主键
     * @return 科研项目
     */
    @Override
    public MmpDoctorResearchProjectVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询科研项目列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 科研项目分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorResearchProjectVo> queryPageList(MmpDoctorResearchProjectBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorResearchProject> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorResearchProjectVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的科研项目列表
     *
     * @param bo 查询条件
     * @return 科研项目列表
     */
    @Override
    public List<MmpDoctorResearchProjectVo> queryList(MmpDoctorResearchProjectBo bo) {
        LambdaQueryWrapper<MmpDoctorResearchProject> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpDoctorResearchProject> buildQueryWrapper(MmpDoctorResearchProjectBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorResearchProject> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorResearchProject::getId);
        lqw.eq(bo.getDoctorId() != null, MmpDoctorResearchProject::getDoctorId, bo.getDoctorId());
        lqw.like(StringUtils.isNotBlank(bo.getProjectName()), MmpDoctorResearchProject::getProjectName, bo.getProjectName());
        lqw.eq(StringUtils.isNotBlank(bo.getProjectNo()), MmpDoctorResearchProject::getProjectNo, bo.getProjectNo());
        lqw.eq(StringUtils.isNotBlank(bo.getProjectLevel()), MmpDoctorResearchProject::getProjectLevel, bo.getProjectLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getProjectType()), MmpDoctorResearchProject::getProjectType, bo.getProjectType());
        lqw.eq(StringUtils.isNotBlank(bo.getRole()), MmpDoctorResearchProject::getRole, bo.getRole());
        lqw.eq(bo.getStartDate() != null, MmpDoctorResearchProject::getStartDate, bo.getStartDate());
        lqw.eq(bo.getEndDate() != null, MmpDoctorResearchProject::getEndDate, bo.getEndDate());
        lqw.eq(bo.getFundingAmount() != null, MmpDoctorResearchProject::getFundingAmount, bo.getFundingAmount());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpDoctorResearchProject::getStatus, bo.getStatus());
        lqw.eq(bo.getDelFlag() != null, MmpDoctorResearchProject::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增科研项目
     *
     * @param bo 科研项目
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorResearchProjectBo bo) {
        MmpDoctorResearchProject add = MapstructUtils.convert(bo, MmpDoctorResearchProject.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改科研项目
     *
     * @param bo 科研项目
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorResearchProjectBo bo) {
        MmpDoctorResearchProject update = MapstructUtils.convert(bo, MmpDoctorResearchProject.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorResearchProject entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除科研项目信息
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
