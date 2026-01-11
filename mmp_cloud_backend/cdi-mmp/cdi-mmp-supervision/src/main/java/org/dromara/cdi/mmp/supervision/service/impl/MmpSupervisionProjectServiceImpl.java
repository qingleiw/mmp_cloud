package org.dromara.cdi.mmp.supervision.service.impl;

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
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionProjectBo;
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionProjectVo;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionProject;
import org.dromara.cdi.mmp.supervision.mapper.MmpSupervisionProjectMapper;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionProjectService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 督查项目Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSupervisionProjectServiceImpl implements IMmpSupervisionProjectService {

    private final MmpSupervisionProjectMapper baseMapper;

    /**
     * 查询督查项目
     *
     * @param id 主键
     * @return 督查项目
     */
    @Override
    public MmpSupervisionProjectVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询督查项目列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查项目分页列表
     */
    @Override
    public TableDataInfo<MmpSupervisionProjectVo> queryPageList(MmpSupervisionProjectBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSupervisionProject> lqw = buildQueryWrapper(bo);
        Page<MmpSupervisionProjectVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的督查项目列表
     *
     * @param bo 查询条件
     * @return 督查项目列表
     */
    @Override
    public List<MmpSupervisionProjectVo> queryList(MmpSupervisionProjectBo bo) {
        LambdaQueryWrapper<MmpSupervisionProject> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSupervisionProject> buildQueryWrapper(MmpSupervisionProjectBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSupervisionProject> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSupervisionProject::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getProjectCode()), MmpSupervisionProject::getProjectCode, bo.getProjectCode());
        lqw.like(StringUtils.isNotBlank(bo.getProjectName()), MmpSupervisionProject::getProjectName, bo.getProjectName());
        lqw.eq(StringUtils.isNotBlank(bo.getProjectType()), MmpSupervisionProject::getProjectType, bo.getProjectType());
        lqw.eq(StringUtils.isNotBlank(bo.getProjectDescription()), MmpSupervisionProject::getProjectDescription, bo.getProjectDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getSupervisionDepartment()), MmpSupervisionProject::getSupervisionDepartment, bo.getSupervisionDepartment());
        lqw.eq(StringUtils.isNotBlank(bo.getResponsiblePerson()), MmpSupervisionProject::getResponsiblePerson, bo.getResponsiblePerson());
        lqw.eq(StringUtils.isNotBlank(bo.getContactInfo()), MmpSupervisionProject::getContactInfo, bo.getContactInfo());
        lqw.eq(StringUtils.isNotBlank(bo.getSupervisionFrequency()), MmpSupervisionProject::getSupervisionFrequency, bo.getSupervisionFrequency());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpSupervisionProject::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增督查项目
     *
     * @param bo 督查项目
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSupervisionProjectBo bo) {
        MmpSupervisionProject add = MapstructUtils.convert(bo, MmpSupervisionProject.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改督查项目
     *
     * @param bo 督查项目
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSupervisionProjectBo bo) {
        MmpSupervisionProject update = MapstructUtils.convert(bo, MmpSupervisionProject.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSupervisionProject entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除督查项目信息
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
