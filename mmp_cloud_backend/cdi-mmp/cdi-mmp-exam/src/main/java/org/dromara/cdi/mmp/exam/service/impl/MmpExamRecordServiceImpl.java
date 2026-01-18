package org.dromara.cdi.mmp.exam.service.impl;

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
import org.dromara.cdi.mmp.exam.domain.bo.MmpExamRecordBo;
import org.dromara.cdi.mmp.exam.domain.vo.MmpExamRecordVo;
import org.dromara.cdi.mmp.exam.domain.MmpExamRecord;
import org.dromara.cdi.mmp.exam.mapper.MmpExamRecordMapper;
import org.dromara.cdi.mmp.exam.service.IMmpExamRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 资质考试记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpExamRecordServiceImpl implements IMmpExamRecordService {

    private final MmpExamRecordMapper baseMapper;

    /**
     * 查询资质考试记录
     *
     * @param id 主键
     * @return 资质考试记录
     */
    @Override
    public MmpExamRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询资质考试记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质考试记录分页列表
     */
    @Override
    public TableDataInfo<MmpExamRecordVo> queryPageList(MmpExamRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpExamRecord> lqw = buildQueryWrapper(bo);
        Page<MmpExamRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的资质考试记录列表
     *
     * @param bo 查询条件
     * @return 资质考试记录列表
     */
    @Override
    public List<MmpExamRecordVo> queryList(MmpExamRecordBo bo) {
        LambdaQueryWrapper<MmpExamRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpExamRecord> buildQueryWrapper(MmpExamRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpExamRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpExamRecord::getId);
        lqw.eq(bo.getExamId() != null, MmpExamRecord::getExamId, bo.getExamId());
        lqw.eq(bo.getExamineeId() != null, MmpExamRecord::getExamineeId, bo.getExamineeId());
        lqw.like(StringUtils.isNotBlank(bo.getExamineeName()), MmpExamRecord::getExamineeName, bo.getExamineeName());
        lqw.eq(bo.getPaperId() != null, MmpExamRecord::getPaperId, bo.getPaperId());
        lqw.eq(bo.getStartTime() != null, MmpExamRecord::getStartTime, bo.getStartTime());
        lqw.eq(bo.getSubmitTime() != null, MmpExamRecord::getSubmitTime, bo.getSubmitTime());
        lqw.eq(StringUtils.isNotBlank(bo.getAnswerSheet()), MmpExamRecord::getAnswerSheet, bo.getAnswerSheet());
        lqw.eq(bo.getObjectiveScore() != null, MmpExamRecord::getObjectiveScore, bo.getObjectiveScore());
        lqw.eq(bo.getSubjectiveScore() != null, MmpExamRecord::getSubjectiveScore, bo.getSubjectiveScore());
        lqw.eq(bo.getTotalScore() != null, MmpExamRecord::getTotalScore, bo.getTotalScore());
        lqw.eq(StringUtils.isNotBlank(bo.getExamResult()), MmpExamRecord::getExamResult, bo.getExamResult());
        lqw.eq(StringUtils.isNotBlank(bo.getMarkingStatus()), MmpExamRecord::getMarkingStatus, bo.getMarkingStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getMarker()), MmpExamRecord::getMarker, bo.getMarker());
        lqw.eq(bo.getMarkingTime() != null, MmpExamRecord::getMarkingTime, bo.getMarkingTime());
        return lqw;
    }

    /**
     * 新增资质考试记录
     *
     * @param bo 资质考试记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpExamRecordBo bo) {
        MmpExamRecord add = MapstructUtils.convert(bo, MmpExamRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改资质考试记录
     *
     * @param bo 资质考试记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpExamRecordBo bo) {
        MmpExamRecord update = MapstructUtils.convert(bo, MmpExamRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpExamRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除资质考试记录信息
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
