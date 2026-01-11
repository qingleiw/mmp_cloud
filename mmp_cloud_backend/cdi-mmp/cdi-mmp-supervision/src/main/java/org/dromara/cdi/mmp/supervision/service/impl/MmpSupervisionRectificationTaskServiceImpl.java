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
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionRectificationTaskBo;
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionRectificationTaskVo;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionRectificationTask;
import org.dromara.cdi.mmp.supervision.mapper.MmpSupervisionRectificationTaskMapper;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionRectificationTaskService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 整改任务Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSupervisionRectificationTaskServiceImpl implements IMmpSupervisionRectificationTaskService {

    private final MmpSupervisionRectificationTaskMapper baseMapper;

    /**
     * 查询整改任务
     *
     * @param id 主键
     * @return 整改任务
     */
    @Override
    public MmpSupervisionRectificationTaskVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询整改任务列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 整改任务分页列表
     */
    @Override
    public TableDataInfo<MmpSupervisionRectificationTaskVo> queryPageList(MmpSupervisionRectificationTaskBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSupervisionRectificationTask> lqw = buildQueryWrapper(bo);
        Page<MmpSupervisionRectificationTaskVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的整改任务列表
     *
     * @param bo 查询条件
     * @return 整改任务列表
     */
    @Override
    public List<MmpSupervisionRectificationTaskVo> queryList(MmpSupervisionRectificationTaskBo bo) {
        LambdaQueryWrapper<MmpSupervisionRectificationTask> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSupervisionRectificationTask> buildQueryWrapper(MmpSupervisionRectificationTaskBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSupervisionRectificationTask> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSupervisionRectificationTask::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getTaskDescription()), MmpSupervisionRectificationTask::getTaskDescription, bo.getTaskDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getResponsibleDept()), MmpSupervisionRectificationTask::getResponsibleDept, bo.getResponsibleDept());
        lqw.eq(StringUtils.isNotBlank(bo.getResponsiblePerson()), MmpSupervisionRectificationTask::getResponsiblePerson, bo.getResponsiblePerson());
        lqw.eq(bo.getDeadline() != null, MmpSupervisionRectificationTask::getDeadline, bo.getDeadline());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpSupervisionRectificationTask::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增整改任务
     *
     * @param bo 整改任务
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSupervisionRectificationTaskBo bo) {
        MmpSupervisionRectificationTask add = MapstructUtils.convert(bo, MmpSupervisionRectificationTask.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改整改任务
     *
     * @param bo 整改任务
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSupervisionRectificationTaskBo bo) {
        MmpSupervisionRectificationTask update = MapstructUtils.convert(bo, MmpSupervisionRectificationTask.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSupervisionRectificationTask entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除整改任务信息
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
