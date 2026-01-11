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
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationTrainingBo;
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationTrainingVo;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationTraining;
import org.dromara.cdi.mmp.radiation.mapper.MmpRadiationTrainingMapper;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationTrainingService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 职业健康培训Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpRadiationTrainingServiceImpl implements IMmpRadiationTrainingService {

    private final MmpRadiationTrainingMapper baseMapper;

    /**
     * 查询职业健康培训
     *
     * @param id 主键
     * @return 职业健康培训
     */
    @Override
    public MmpRadiationTrainingVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询职业健康培训列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 职业健康培训分页列表
     */
    @Override
    public TableDataInfo<MmpRadiationTrainingVo> queryPageList(MmpRadiationTrainingBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpRadiationTraining> lqw = buildQueryWrapper(bo);
        Page<MmpRadiationTrainingVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的职业健康培训列表
     *
     * @param bo 查询条件
     * @return 职业健康培训列表
     */
    @Override
    public List<MmpRadiationTrainingVo> queryList(MmpRadiationTrainingBo bo) {
        LambdaQueryWrapper<MmpRadiationTraining> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpRadiationTraining> buildQueryWrapper(MmpRadiationTrainingBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpRadiationTraining> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpRadiationTraining::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getTrainingCode()), MmpRadiationTraining::getTrainingCode, bo.getTrainingCode());
        lqw.like(StringUtils.isNotBlank(bo.getTrainingName()), MmpRadiationTraining::getTrainingName, bo.getTrainingName());
        lqw.eq(StringUtils.isNotBlank(bo.getTrainingType()), MmpRadiationTraining::getTrainingType, bo.getTrainingType());
        lqw.eq(bo.getTrainingDate() != null, MmpRadiationTraining::getTrainingDate, bo.getTrainingDate());
        lqw.eq(StringUtils.isNotBlank(bo.getTrainer()), MmpRadiationTraining::getTrainer, bo.getTrainer());
        lqw.eq(StringUtils.isNotBlank(bo.getParticipants()), MmpRadiationTraining::getParticipants, bo.getParticipants());
        lqw.eq(StringUtils.isNotBlank(bo.getTrainingContent()), MmpRadiationTraining::getTrainingContent, bo.getTrainingContent());
        lqw.eq(bo.getTrainingHours() != null, MmpRadiationTraining::getTrainingHours, bo.getTrainingHours());
        lqw.eq(StringUtils.isNotBlank(bo.getEvaluationResults()), MmpRadiationTraining::getEvaluationResults, bo.getEvaluationResults());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpRadiationTraining::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增职业健康培训
     *
     * @param bo 职业健康培训
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpRadiationTrainingBo bo) {
        MmpRadiationTraining add = MapstructUtils.convert(bo, MmpRadiationTraining.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改职业健康培训
     *
     * @param bo 职业健康培训
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpRadiationTrainingBo bo) {
        MmpRadiationTraining update = MapstructUtils.convert(bo, MmpRadiationTraining.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpRadiationTraining entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除职业健康培训信息
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
