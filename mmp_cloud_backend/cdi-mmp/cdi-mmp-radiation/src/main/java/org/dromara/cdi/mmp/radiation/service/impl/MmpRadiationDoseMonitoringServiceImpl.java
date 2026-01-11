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
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationDoseMonitoringBo;
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationDoseMonitoringVo;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationDoseMonitoring;
import org.dromara.cdi.mmp.radiation.mapper.MmpRadiationDoseMonitoringMapper;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationDoseMonitoringService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 个人剂量监测Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpRadiationDoseMonitoringServiceImpl implements IMmpRadiationDoseMonitoringService {

    private final MmpRadiationDoseMonitoringMapper baseMapper;

    /**
     * 查询个人剂量监测
     *
     * @param id 主键
     * @return 个人剂量监测
     */
    @Override
    public MmpRadiationDoseMonitoringVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询个人剂量监测列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 个人剂量监测分页列表
     */
    @Override
    public TableDataInfo<MmpRadiationDoseMonitoringVo> queryPageList(MmpRadiationDoseMonitoringBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpRadiationDoseMonitoring> lqw = buildQueryWrapper(bo);
        Page<MmpRadiationDoseMonitoringVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的个人剂量监测列表
     *
     * @param bo 查询条件
     * @return 个人剂量监测列表
     */
    @Override
    public List<MmpRadiationDoseMonitoringVo> queryList(MmpRadiationDoseMonitoringBo bo) {
        LambdaQueryWrapper<MmpRadiationDoseMonitoring> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpRadiationDoseMonitoring> buildQueryWrapper(MmpRadiationDoseMonitoringBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpRadiationDoseMonitoring> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpRadiationDoseMonitoring::getId);
        lqw.eq(bo.getMonitoringDate() != null, MmpRadiationDoseMonitoring::getMonitoringDate, bo.getMonitoringDate());
        lqw.eq(StringUtils.isNotBlank(bo.getMonitoringPeriod()), MmpRadiationDoseMonitoring::getMonitoringPeriod, bo.getMonitoringPeriod());
        lqw.eq(bo.getDoseValue() != null, MmpRadiationDoseMonitoring::getDoseValue, bo.getDoseValue());
        lqw.eq(StringUtils.isNotBlank(bo.getDoseUnit()), MmpRadiationDoseMonitoring::getDoseUnit, bo.getDoseUnit());
        lqw.eq(StringUtils.isNotBlank(bo.getMonitoringMethod()), MmpRadiationDoseMonitoring::getMonitoringMethod, bo.getMonitoringMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getMonitoringDevice()), MmpRadiationDoseMonitoring::getMonitoringDevice, bo.getMonitoringDevice());
        lqw.eq(StringUtils.isNotBlank(bo.getMonitoringPerson()), MmpRadiationDoseMonitoring::getMonitoringPerson, bo.getMonitoringPerson());
        lqw.eq(StringUtils.isNotBlank(bo.getIsExceeded()), MmpRadiationDoseMonitoring::getIsExceeded, bo.getIsExceeded());
        lqw.eq(StringUtils.isNotBlank(bo.getRemarks()), MmpRadiationDoseMonitoring::getRemarks, bo.getRemarks());
        return lqw;
    }

    /**
     * 新增个人剂量监测
     *
     * @param bo 个人剂量监测
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpRadiationDoseMonitoringBo bo) {
        MmpRadiationDoseMonitoring add = MapstructUtils.convert(bo, MmpRadiationDoseMonitoring.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改个人剂量监测
     *
     * @param bo 个人剂量监测
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpRadiationDoseMonitoringBo bo) {
        MmpRadiationDoseMonitoring update = MapstructUtils.convert(bo, MmpRadiationDoseMonitoring.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpRadiationDoseMonitoring entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除个人剂量监测信息
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
