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
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectAssessmentBo;
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectAssessmentVo;
import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectAssessment;
import org.dromara.cdi.mmp.ntp.mapper.MmpNewTechnologyProjectAssessmentMapper;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectAssessmentService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 项目考核评估Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNewTechnologyProjectAssessmentServiceImpl implements IMmpNewTechnologyProjectAssessmentService {

    private final MmpNewTechnologyProjectAssessmentMapper baseMapper;

    /**
     * 查询项目考核评估
     *
     * @param id 主键
     * @return 项目考核评估
     */
    @Override
    public MmpNewTechnologyProjectAssessmentVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询项目考核评估列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 项目考核评估分页列表
     */
    @Override
    public TableDataInfo<MmpNewTechnologyProjectAssessmentVo> queryPageList(MmpNewTechnologyProjectAssessmentBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNewTechnologyProjectAssessment> lqw = buildQueryWrapper(bo);
        Page<MmpNewTechnologyProjectAssessmentVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的项目考核评估列表
     *
     * @param bo 查询条件
     * @return 项目考核评估列表
     */
    @Override
    public List<MmpNewTechnologyProjectAssessmentVo> queryList(MmpNewTechnologyProjectAssessmentBo bo) {
        LambdaQueryWrapper<MmpNewTechnologyProjectAssessment> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNewTechnologyProjectAssessment> buildQueryWrapper(MmpNewTechnologyProjectAssessmentBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNewTechnologyProjectAssessment> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNewTechnologyProjectAssessment::getId);
        lqw.eq(bo.getAssessmentYear() != null, MmpNewTechnologyProjectAssessment::getAssessmentYear, bo.getAssessmentYear());
        lqw.eq(StringUtils.isNotBlank(bo.getAssessmentType()), MmpNewTechnologyProjectAssessment::getAssessmentType, bo.getAssessmentType());
        lqw.eq(bo.getAssessmentDate() != null, MmpNewTechnologyProjectAssessment::getAssessmentDate, bo.getAssessmentDate());
        lqw.eq(StringUtils.isNotBlank(bo.getAssessor()), MmpNewTechnologyProjectAssessment::getAssessor, bo.getAssessor());
        lqw.eq(StringUtils.isNotBlank(bo.getAssessmentResult()), MmpNewTechnologyProjectAssessment::getAssessmentResult, bo.getAssessmentResult());
        lqw.eq(bo.getScore() != null, MmpNewTechnologyProjectAssessment::getScore, bo.getScore());
        lqw.eq(StringUtils.isNotBlank(bo.getAssessmentOpinion()), MmpNewTechnologyProjectAssessment::getAssessmentOpinion, bo.getAssessmentOpinion());
        lqw.eq(StringUtils.isNotBlank(bo.getImprovementMeasures()), MmpNewTechnologyProjectAssessment::getImprovementMeasures, bo.getImprovementMeasures());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpNewTechnologyProjectAssessment::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增项目考核评估
     *
     * @param bo 项目考核评估
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNewTechnologyProjectAssessmentBo bo) {
        MmpNewTechnologyProjectAssessment add = MapstructUtils.convert(bo, MmpNewTechnologyProjectAssessment.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改项目考核评估
     *
     * @param bo 项目考核评估
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNewTechnologyProjectAssessmentBo bo) {
        MmpNewTechnologyProjectAssessment update = MapstructUtils.convert(bo, MmpNewTechnologyProjectAssessment.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNewTechnologyProjectAssessment entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除项目考核评估信息
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
