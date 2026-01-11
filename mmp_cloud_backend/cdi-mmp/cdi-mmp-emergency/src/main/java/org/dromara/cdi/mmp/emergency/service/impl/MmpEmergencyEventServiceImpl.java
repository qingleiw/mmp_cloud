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
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyEventBo;
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyEventVo;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyEvent;
import org.dromara.cdi.mmp.emergency.mapper.MmpEmergencyEventMapper;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyEventService;

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
public class MmpEmergencyEventServiceImpl implements IMmpEmergencyEventService {

    private final MmpEmergencyEventMapper baseMapper;

    /**
     * 查询突发事件记录
     *
     * @param id 主键
     * @return 突发事件记录
     */
    @Override
    public MmpEmergencyEventVo queryById(Long id){
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
    public TableDataInfo<MmpEmergencyEventVo> queryPageList(MmpEmergencyEventBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpEmergencyEvent> lqw = buildQueryWrapper(bo);
        Page<MmpEmergencyEventVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的突发事件记录列表
     *
     * @param bo 查询条件
     * @return 突发事件记录列表
     */
    @Override
    public List<MmpEmergencyEventVo> queryList(MmpEmergencyEventBo bo) {
        LambdaQueryWrapper<MmpEmergencyEvent> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpEmergencyEvent> buildQueryWrapper(MmpEmergencyEventBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpEmergencyEvent> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpEmergencyEvent::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getEventCode()), MmpEmergencyEvent::getEventCode, bo.getEventCode());
        lqw.eq(StringUtils.isNotBlank(bo.getEventTitle()), MmpEmergencyEvent::getEventTitle, bo.getEventTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getEventType()), MmpEmergencyEvent::getEventType, bo.getEventType());
        lqw.eq(StringUtils.isNotBlank(bo.getEventLevel()), MmpEmergencyEvent::getEventLevel, bo.getEventLevel());
        lqw.eq(bo.getOccurrenceTime() != null, MmpEmergencyEvent::getOccurrenceTime, bo.getOccurrenceTime());
        lqw.eq(bo.getDiscoveryTime() != null, MmpEmergencyEvent::getDiscoveryTime, bo.getDiscoveryTime());
        lqw.eq(bo.getReportTime() != null, MmpEmergencyEvent::getReportTime, bo.getReportTime());
        lqw.eq(StringUtils.isNotBlank(bo.getReporter()), MmpEmergencyEvent::getReporter, bo.getReporter());
        lqw.eq(StringUtils.isNotBlank(bo.getLocation()), MmpEmergencyEvent::getLocation, bo.getLocation());
        lqw.eq(StringUtils.isNotBlank(bo.getAffectedPersons()), MmpEmergencyEvent::getAffectedPersons, bo.getAffectedPersons());
        lqw.eq(StringUtils.isNotBlank(bo.getEventDescription()), MmpEmergencyEvent::getEventDescription, bo.getEventDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getImmediateMeasures()), MmpEmergencyEvent::getImmediateMeasures, bo.getImmediateMeasures());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpEmergencyEvent::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增突发事件记录
     *
     * @param bo 突发事件记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpEmergencyEventBo bo) {
        MmpEmergencyEvent add = MapstructUtils.convert(bo, MmpEmergencyEvent.class);
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
    public Boolean updateByBo(MmpEmergencyEventBo bo) {
        MmpEmergencyEvent update = MapstructUtils.convert(bo, MmpEmergencyEvent.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpEmergencyEvent entity){
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
