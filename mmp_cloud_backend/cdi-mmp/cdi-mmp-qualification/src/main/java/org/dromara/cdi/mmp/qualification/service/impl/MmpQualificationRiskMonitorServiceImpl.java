package org.dromara.cdi.mmp.qualification.service.impl;

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
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationRiskMonitorBo;
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationRiskMonitorVo;
import org.dromara.cdi.mmp.qualification.domain.MmpQualificationRiskMonitor;
import org.dromara.cdi.mmp.qualification.mapper.MmpQualificationRiskMonitorMapper;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationRiskMonitorService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 资质风险监测Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQualificationRiskMonitorServiceImpl implements IMmpQualificationRiskMonitorService {

    private final MmpQualificationRiskMonitorMapper baseMapper;

    /**
     * 查询资质风险监测
     *
     * @param id 主键
     * @return 资质风险监测
     */
    @Override
    public MmpQualificationRiskMonitorVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询资质风险监测列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质风险监测分页列表
     */
    @Override
    public TableDataInfo<MmpQualificationRiskMonitorVo> queryPageList(MmpQualificationRiskMonitorBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQualificationRiskMonitor> lqw = buildQueryWrapper(bo);
        Page<MmpQualificationRiskMonitorVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的资质风险监测列表
     *
     * @param bo 查询条件
     * @return 资质风险监测列表
     */
    @Override
    public List<MmpQualificationRiskMonitorVo> queryList(MmpQualificationRiskMonitorBo bo) {
        LambdaQueryWrapper<MmpQualificationRiskMonitor> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQualificationRiskMonitor> buildQueryWrapper(MmpQualificationRiskMonitorBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQualificationRiskMonitor> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQualificationRiskMonitor::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getRiskNo()), MmpQualificationRiskMonitor::getRiskNo, bo.getRiskNo());
        lqw.eq(bo.getStaffId() != null, MmpQualificationRiskMonitor::getStaffId, bo.getStaffId());
        lqw.like(StringUtils.isNotBlank(bo.getStaffName()), MmpQualificationRiskMonitor::getStaffName, bo.getStaffName());
        lqw.eq(bo.getQualificationId() != null, MmpQualificationRiskMonitor::getQualificationId, bo.getQualificationId());
        lqw.like(StringUtils.isNotBlank(bo.getQualificationName()), MmpQualificationRiskMonitor::getQualificationName, bo.getQualificationName());
        lqw.eq(StringUtils.isNotBlank(bo.getRiskType()), MmpQualificationRiskMonitor::getRiskType, bo.getRiskType());
        lqw.eq(StringUtils.isNotBlank(bo.getRiskLevel()), MmpQualificationRiskMonitor::getRiskLevel, bo.getRiskLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getRiskDescription()), MmpQualificationRiskMonitor::getRiskDescription, bo.getRiskDescription());
        lqw.eq(bo.getRiskDate() != null, MmpQualificationRiskMonitor::getRiskDate, bo.getRiskDate());
        lqw.eq(bo.getRelatedPatientId() != null, MmpQualificationRiskMonitor::getRelatedPatientId, bo.getRelatedPatientId());
        lqw.eq(bo.getRelatedEventId() != null, MmpQualificationRiskMonitor::getRelatedEventId, bo.getRelatedEventId());
        lqw.eq(StringUtils.isNotBlank(bo.getHandlingStatus()), MmpQualificationRiskMonitor::getHandlingStatus, bo.getHandlingStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getHandler()), MmpQualificationRiskMonitor::getHandler, bo.getHandler());
        lqw.eq(bo.getHandleTime() != null, MmpQualificationRiskMonitor::getHandleTime, bo.getHandleTime());
        lqw.eq(StringUtils.isNotBlank(bo.getHandleResult()), MmpQualificationRiskMonitor::getHandleResult, bo.getHandleResult());
        lqw.eq(bo.getDelFlag() != null, MmpQualificationRiskMonitor::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增资质风险监测
     *
     * @param bo 资质风险监测
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQualificationRiskMonitorBo bo) {
        MmpQualificationRiskMonitor add = MapstructUtils.convert(bo, MmpQualificationRiskMonitor.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改资质风险监测
     *
     * @param bo 资质风险监测
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQualificationRiskMonitorBo bo) {
        MmpQualificationRiskMonitor update = MapstructUtils.convert(bo, MmpQualificationRiskMonitor.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQualificationRiskMonitor entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除资质风险监测信息
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
