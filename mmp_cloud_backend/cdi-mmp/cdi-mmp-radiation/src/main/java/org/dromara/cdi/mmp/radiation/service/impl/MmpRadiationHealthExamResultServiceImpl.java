package org.dromara.cdi.mmp.radiation.service.impl;

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
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationHealthExamResultBo;
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationHealthExamResultVo;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationHealthExamResult;
import org.dromara.cdi.mmp.radiation.mapper.MmpRadiationHealthExamResultMapper;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationHealthExamResultService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 体检结果记录Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpRadiationHealthExamResultServiceImpl implements IMmpRadiationHealthExamResultService {

    private final MmpRadiationHealthExamResultMapper baseMapper;

    /**
     * 查询体检结果记录
     *
     * @param id 主键
     * @return 体检结果记录
     */
    @Override
    public MmpRadiationHealthExamResultVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询体检结果记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 体检结果记录分页列表
     */
    @Override
    public TableDataInfo<MmpRadiationHealthExamResultVo> queryPageList(MmpRadiationHealthExamResultBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpRadiationHealthExamResult> lqw = buildQueryWrapper(bo);
        Page<MmpRadiationHealthExamResultVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的体检结果记录列表
     *
     * @param bo 查询条件
     * @return 体检结果记录列表
     */
    @Override
    public List<MmpRadiationHealthExamResultVo> queryList(MmpRadiationHealthExamResultBo bo) {
        LambdaQueryWrapper<MmpRadiationHealthExamResult> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpRadiationHealthExamResult> buildQueryWrapper(MmpRadiationHealthExamResultBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpRadiationHealthExamResult> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpRadiationHealthExamResult::getId);
        lqw.like(StringUtils.isNotBlank(bo.getStaffName()), MmpRadiationHealthExamResult::getStaffName, bo.getStaffName());
        lqw.eq(bo.getExamDate() != null, MmpRadiationHealthExamResult::getExamDate, bo.getExamDate());
        lqw.eq(StringUtils.isNotBlank(bo.getExamResult()), MmpRadiationHealthExamResult::getExamResult, bo.getExamResult());
        lqw.eq(StringUtils.isNotBlank(bo.getExamReportFile()), MmpRadiationHealthExamResult::getExamReportFile, bo.getExamReportFile());
        lqw.like(StringUtils.isNotBlank(bo.getExamReportName()), MmpRadiationHealthExamResult::getExamReportName, bo.getExamReportName());
        lqw.eq(StringUtils.isNotBlank(bo.getKeyFindings()), MmpRadiationHealthExamResult::getKeyFindings, bo.getKeyFindings());
        lqw.eq(StringUtils.isNotBlank(bo.getRecommendations()), MmpRadiationHealthExamResult::getRecommendations, bo.getRecommendations());
        lqw.eq(StringUtils.isNotBlank(bo.getFollowUpRequired()), MmpRadiationHealthExamResult::getFollowUpRequired, bo.getFollowUpRequired());
        lqw.eq(bo.getFollowUpDate() != null, MmpRadiationHealthExamResult::getFollowUpDate, bo.getFollowUpDate());
        return lqw;
    }

    /**
     * 新增体检结果记录
     *
     * @param bo 体检结果记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpRadiationHealthExamResultBo bo) {
        MmpRadiationHealthExamResult add = MapstructUtils.convert(bo, MmpRadiationHealthExamResult.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改体检结果记录
     *
     * @param bo 体检结果记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpRadiationHealthExamResultBo bo) {
        MmpRadiationHealthExamResult update = MapstructUtils.convert(bo, MmpRadiationHealthExamResult.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpRadiationHealthExamResult entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除体检结果记录信息
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
