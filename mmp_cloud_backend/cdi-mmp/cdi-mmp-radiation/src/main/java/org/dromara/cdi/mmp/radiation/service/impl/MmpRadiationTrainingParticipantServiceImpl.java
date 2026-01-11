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
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationTrainingParticipantBo;
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationTrainingParticipantVo;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationTrainingParticipant;
import org.dromara.cdi.mmp.radiation.mapper.MmpRadiationTrainingParticipantMapper;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationTrainingParticipantService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 培训参与记录Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpRadiationTrainingParticipantServiceImpl implements IMmpRadiationTrainingParticipantService {

    private final MmpRadiationTrainingParticipantMapper baseMapper;

    /**
     * 查询培训参与记录
     *
     * @param id 主键
     * @return 培训参与记录
     */
    @Override
    public MmpRadiationTrainingParticipantVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询培训参与记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 培训参与记录分页列表
     */
    @Override
    public TableDataInfo<MmpRadiationTrainingParticipantVo> queryPageList(MmpRadiationTrainingParticipantBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpRadiationTrainingParticipant> lqw = buildQueryWrapper(bo);
        Page<MmpRadiationTrainingParticipantVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的培训参与记录列表
     *
     * @param bo 查询条件
     * @return 培训参与记录列表
     */
    @Override
    public List<MmpRadiationTrainingParticipantVo> queryList(MmpRadiationTrainingParticipantBo bo) {
        LambdaQueryWrapper<MmpRadiationTrainingParticipant> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpRadiationTrainingParticipant> buildQueryWrapper(MmpRadiationTrainingParticipantBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpRadiationTrainingParticipant> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpRadiationTrainingParticipant::getId);
        lqw.like(StringUtils.isNotBlank(bo.getStaffName()), MmpRadiationTrainingParticipant::getStaffName, bo.getStaffName());
        lqw.eq(StringUtils.isNotBlank(bo.getAttendanceStatus()), MmpRadiationTrainingParticipant::getAttendanceStatus, bo.getAttendanceStatus());
        lqw.eq(bo.getScore() != null, MmpRadiationTrainingParticipant::getScore, bo.getScore());
        lqw.eq(StringUtils.isNotBlank(bo.getEvaluation()), MmpRadiationTrainingParticipant::getEvaluation, bo.getEvaluation());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateIssued()), MmpRadiationTrainingParticipant::getCertificateIssued, bo.getCertificateIssued());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateNumber()), MmpRadiationTrainingParticipant::getCertificateNumber, bo.getCertificateNumber());
        return lqw;
    }

    /**
     * 新增培训参与记录
     *
     * @param bo 培训参与记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpRadiationTrainingParticipantBo bo) {
        MmpRadiationTrainingParticipant add = MapstructUtils.convert(bo, MmpRadiationTrainingParticipant.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改培训参与记录
     *
     * @param bo 培训参与记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpRadiationTrainingParticipantBo bo) {
        MmpRadiationTrainingParticipant update = MapstructUtils.convert(bo, MmpRadiationTrainingParticipant.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpRadiationTrainingParticipant entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除培训参与记录信息
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
