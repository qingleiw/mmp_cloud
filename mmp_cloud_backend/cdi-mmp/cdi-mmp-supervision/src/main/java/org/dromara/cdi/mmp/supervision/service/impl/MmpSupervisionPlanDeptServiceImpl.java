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
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionPlanDeptBo;
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionPlanDeptVo;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionPlanDept;
import org.dromara.cdi.mmp.supervision.mapper.MmpSupervisionPlanDeptMapper;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionPlanDeptService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 督查计划科室关联Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSupervisionPlanDeptServiceImpl implements IMmpSupervisionPlanDeptService {

    private final MmpSupervisionPlanDeptMapper baseMapper;

    /**
     * 查询督查计划科室关联
     *
     * @param id 主键
     * @return 督查计划科室关联
     */
    @Override
    public MmpSupervisionPlanDeptVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询督查计划科室关联列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查计划科室关联分页列表
     */
    @Override
    public TableDataInfo<MmpSupervisionPlanDeptVo> queryPageList(MmpSupervisionPlanDeptBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSupervisionPlanDept> lqw = buildQueryWrapper(bo);
        Page<MmpSupervisionPlanDeptVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的督查计划科室关联列表
     *
     * @param bo 查询条件
     * @return 督查计划科室关联列表
     */
    @Override
    public List<MmpSupervisionPlanDeptVo> queryList(MmpSupervisionPlanDeptBo bo) {
        LambdaQueryWrapper<MmpSupervisionPlanDept> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSupervisionPlanDept> buildQueryWrapper(MmpSupervisionPlanDeptBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSupervisionPlanDept> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSupervisionPlanDept::getId);
        lqw.eq(bo.getSupervisionDate() != null, MmpSupervisionPlanDept::getSupervisionDate, bo.getSupervisionDate());
        lqw.eq(StringUtils.isNotBlank(bo.getSupervisor()), MmpSupervisionPlanDept::getSupervisor, bo.getSupervisor());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpSupervisionPlanDept::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增督查计划科室关联
     *
     * @param bo 督查计划科室关联
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSupervisionPlanDeptBo bo) {
        MmpSupervisionPlanDept add = MapstructUtils.convert(bo, MmpSupervisionPlanDept.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改督查计划科室关联
     *
     * @param bo 督查计划科室关联
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSupervisionPlanDeptBo bo) {
        MmpSupervisionPlanDept update = MapstructUtils.convert(bo, MmpSupervisionPlanDept.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSupervisionPlanDept entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除督查计划科室关联信息
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
