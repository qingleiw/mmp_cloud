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
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationHealthExamBo;
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationHealthExamVo;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationHealthExam;
import org.dromara.cdi.mmp.radiation.mapper.MmpRadiationHealthExamMapper;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationHealthExamService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 职业健康体检Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpRadiationHealthExamServiceImpl implements IMmpRadiationHealthExamService {

    private final MmpRadiationHealthExamMapper baseMapper;

    /**
     * 查询职业健康体检
     *
     * @param id 主键
     * @return 职业健康体检
     */
    @Override
    public MmpRadiationHealthExamVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询职业健康体检列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 职业健康体检分页列表
     */
    @Override
    public TableDataInfo<MmpRadiationHealthExamVo> queryPageList(MmpRadiationHealthExamBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpRadiationHealthExam> lqw = buildQueryWrapper(bo);
        Page<MmpRadiationHealthExamVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的职业健康体检列表
     *
     * @param bo 查询条件
     * @return 职业健康体检列表
     */
    @Override
    public List<MmpRadiationHealthExamVo> queryList(MmpRadiationHealthExamBo bo) {
        LambdaQueryWrapper<MmpRadiationHealthExam> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpRadiationHealthExam> buildQueryWrapper(MmpRadiationHealthExamBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpRadiationHealthExam> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpRadiationHealthExam::getId);
        lqw.eq(bo.getExamDate() != null, MmpRadiationHealthExam::getExamDate, bo.getExamDate());
        lqw.eq(StringUtils.isNotBlank(bo.getExamType()), MmpRadiationHealthExam::getExamType, bo.getExamType());
        lqw.eq(StringUtils.isNotBlank(bo.getExamHospital()), MmpRadiationHealthExam::getExamHospital, bo.getExamHospital());
        lqw.eq(StringUtils.isNotBlank(bo.getExamDoctor()), MmpRadiationHealthExam::getExamDoctor, bo.getExamDoctor());
        lqw.eq(StringUtils.isNotBlank(bo.getExamResults()), MmpRadiationHealthExam::getExamResults, bo.getExamResults());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagnosis()), MmpRadiationHealthExam::getDiagnosis, bo.getDiagnosis());
        lqw.eq(StringUtils.isNotBlank(bo.getRecommendations()), MmpRadiationHealthExam::getRecommendations, bo.getRecommendations());
        lqw.eq(StringUtils.isNotBlank(bo.getFollowUpRequired()), MmpRadiationHealthExam::getFollowUpRequired, bo.getFollowUpRequired());
        lqw.eq(bo.getNextExamDate() != null, MmpRadiationHealthExam::getNextExamDate, bo.getNextExamDate());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpRadiationHealthExam::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增职业健康体检
     *
     * @param bo 职业健康体检
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpRadiationHealthExamBo bo) {
        MmpRadiationHealthExam add = MapstructUtils.convert(bo, MmpRadiationHealthExam.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改职业健康体检
     *
     * @param bo 职业健康体检
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpRadiationHealthExamBo bo) {
        MmpRadiationHealthExam update = MapstructUtils.convert(bo, MmpRadiationHealthExam.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpRadiationHealthExam entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除职业健康体检信息
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
