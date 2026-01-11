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
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionPlanFormBo;
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionPlanFormVo;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionPlanForm;
import org.dromara.cdi.mmp.supervision.mapper.MmpSupervisionPlanFormMapper;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionPlanFormService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 督查计划单关联Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSupervisionPlanFormServiceImpl implements IMmpSupervisionPlanFormService {

    private final MmpSupervisionPlanFormMapper baseMapper;

    /**
     * 查询督查计划单关联
     *
     * @param id 主键
     * @return 督查计划单关联
     */
    @Override
    public MmpSupervisionPlanFormVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询督查计划单关联列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查计划单关联分页列表
     */
    @Override
    public TableDataInfo<MmpSupervisionPlanFormVo> queryPageList(MmpSupervisionPlanFormBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSupervisionPlanForm> lqw = buildQueryWrapper(bo);
        Page<MmpSupervisionPlanFormVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的督查计划单关联列表
     *
     * @param bo 查询条件
     * @return 督查计划单关联列表
     */
    @Override
    public List<MmpSupervisionPlanFormVo> queryList(MmpSupervisionPlanFormBo bo) {
        LambdaQueryWrapper<MmpSupervisionPlanForm> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSupervisionPlanForm> buildQueryWrapper(MmpSupervisionPlanFormBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSupervisionPlanForm> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSupervisionPlanForm::getId);
        lqw.eq(bo.getSortOrder() != null, MmpSupervisionPlanForm::getSortOrder, bo.getSortOrder());
        return lqw;
    }

    /**
     * 新增督查计划单关联
     *
     * @param bo 督查计划单关联
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSupervisionPlanFormBo bo) {
        MmpSupervisionPlanForm add = MapstructUtils.convert(bo, MmpSupervisionPlanForm.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改督查计划单关联
     *
     * @param bo 督查计划单关联
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSupervisionPlanFormBo bo) {
        MmpSupervisionPlanForm update = MapstructUtils.convert(bo, MmpSupervisionPlanForm.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSupervisionPlanForm entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除督查计划单关联信息
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
