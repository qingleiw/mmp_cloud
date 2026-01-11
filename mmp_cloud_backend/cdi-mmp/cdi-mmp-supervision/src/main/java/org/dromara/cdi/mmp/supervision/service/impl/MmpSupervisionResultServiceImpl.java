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
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionResultBo;
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionResultVo;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionResult;
import org.dromara.cdi.mmp.supervision.mapper.MmpSupervisionResultMapper;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionResultService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 督查结果Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSupervisionResultServiceImpl implements IMmpSupervisionResultService {

    private final MmpSupervisionResultMapper baseMapper;

    /**
     * 查询督查结果
     *
     * @param id 主键
     * @return 督查结果
     */
    @Override
    public MmpSupervisionResultVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询督查结果列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查结果分页列表
     */
    @Override
    public TableDataInfo<MmpSupervisionResultVo> queryPageList(MmpSupervisionResultBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSupervisionResult> lqw = buildQueryWrapper(bo);
        Page<MmpSupervisionResultVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的督查结果列表
     *
     * @param bo 查询条件
     * @return 督查结果列表
     */
    @Override
    public List<MmpSupervisionResultVo> queryList(MmpSupervisionResultBo bo) {
        LambdaQueryWrapper<MmpSupervisionResult> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSupervisionResult> buildQueryWrapper(MmpSupervisionResultBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSupervisionResult> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSupervisionResult::getId);
        lqw.eq(bo.getSupervisionDate() != null, MmpSupervisionResult::getSupervisionDate, bo.getSupervisionDate());
        lqw.eq(StringUtils.isNotBlank(bo.getSupervisor()), MmpSupervisionResult::getSupervisor, bo.getSupervisor());
        lqw.eq(bo.getTotalScore() != null, MmpSupervisionResult::getTotalScore, bo.getTotalScore());
        lqw.eq(StringUtils.isNotBlank(bo.getGrade()), MmpSupervisionResult::getGrade, bo.getGrade());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpSupervisionResult::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增督查结果
     *
     * @param bo 督查结果
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSupervisionResultBo bo) {
        MmpSupervisionResult add = MapstructUtils.convert(bo, MmpSupervisionResult.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改督查结果
     *
     * @param bo 督查结果
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSupervisionResultBo bo) {
        MmpSupervisionResult update = MapstructUtils.convert(bo, MmpSupervisionResult.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSupervisionResult entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除督查结果信息
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
