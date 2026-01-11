package org.dromara.cdi.mmp.emergency.service.impl;

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
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyIncidentBo;
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyIncidentVo;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyIncident;
import org.dromara.cdi.mmp.emergency.mapper.MmpEmergencyIncidentMapper;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyIncidentService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 突发事件记录Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpEmergencyIncidentServiceImpl implements IMmpEmergencyIncidentService {

    private final MmpEmergencyIncidentMapper baseMapper;

    /**
     * 查询突发事件记录
     *
     * @param id 主键
     * @return 突发事件记录
     */
    @Override
    public MmpEmergencyIncidentVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询突发事件记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 突发事件记录分页列表
     */
    @Override
    public TableDataInfo<MmpEmergencyIncidentVo> queryPageList(MmpEmergencyIncidentBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpEmergencyIncident> lqw = buildQueryWrapper(bo);
        Page<MmpEmergencyIncidentVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的突发事件记录列表
     *
     * @param bo 查询条件
     * @return 突发事件记录列表
     */
    @Override
    public List<MmpEmergencyIncidentVo> queryList(MmpEmergencyIncidentBo bo) {
        LambdaQueryWrapper<MmpEmergencyIncident> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpEmergencyIncident> buildQueryWrapper(MmpEmergencyIncidentBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpEmergencyIncident> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpEmergencyIncident::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getIncidentCode()), MmpEmergencyIncident::getIncidentCode, bo.getIncidentCode());
        lqw.eq(StringUtils.isNotBlank(bo.getIncidentTitle()), MmpEmergencyIncident::getIncidentTitle, bo.getIncidentTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getIncidentType()), MmpEmergencyIncident::getIncidentType, bo.getIncidentType());
        lqw.eq(StringUtils.isNotBlank(bo.getIncidentLevel()), MmpEmergencyIncident::getIncidentLevel, bo.getIncidentLevel());
        lqw.eq(bo.getOccurrenceTime() != null, MmpEmergencyIncident::getOccurrenceTime, bo.getOccurrenceTime());
        lqw.eq(StringUtils.isNotBlank(bo.getLocation()), MmpEmergencyIncident::getLocation, bo.getLocation());
        lqw.eq(StringUtils.isNotBlank(bo.getDescription()), MmpEmergencyIncident::getDescription, bo.getDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getAffectedPersons()), MmpEmergencyIncident::getAffectedPersons, bo.getAffectedPersons());
        lqw.eq(StringUtils.isNotBlank(bo.getResponseTeam()), MmpEmergencyIncident::getResponseTeam, bo.getResponseTeam());
        lqw.eq(StringUtils.isNotBlank(bo.getResponseMeasures()), MmpEmergencyIncident::getResponseMeasures, bo.getResponseMeasures());
        lqw.eq(bo.getResolutionTime() != null, MmpEmergencyIncident::getResolutionTime, bo.getResolutionTime());
        lqw.eq(StringUtils.isNotBlank(bo.getCasualties()), MmpEmergencyIncident::getCasualties, bo.getCasualties());
        lqw.eq(bo.getEconomicLoss() != null, MmpEmergencyIncident::getEconomicLoss, bo.getEconomicLoss());
        lqw.eq(StringUtils.isNotBlank(bo.getLessonsLearned()), MmpEmergencyIncident::getLessonsLearned, bo.getLessonsLearned());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpEmergencyIncident::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增突发事件记录
     *
     * @param bo 突发事件记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpEmergencyIncidentBo bo) {
        MmpEmergencyIncident add = MapstructUtils.convert(bo, MmpEmergencyIncident.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改突发事件记录
     *
     * @param bo 突发事件记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpEmergencyIncidentBo bo) {
        MmpEmergencyIncident update = MapstructUtils.convert(bo, MmpEmergencyIncident.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpEmergencyIncident entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除突发事件记录信息
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
