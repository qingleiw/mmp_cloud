package org.dromara.cdi.mmp.tumorqc.service.impl;

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
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcIndicatorRecordBo;
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcIndicatorRecordVo;
import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcIndicatorRecord;
import org.dromara.cdi.mmp.tumorqc.mapper.MmpTumorQcIndicatorRecordMapper;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcIndicatorRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 质控指标监测记录Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpTumorQcIndicatorRecordServiceImpl implements IMmpTumorQcIndicatorRecordService {

    private final MmpTumorQcIndicatorRecordMapper baseMapper;

    /**
     * 查询质控指标监测记录
     *
     * @param id 主键
     * @return 质控指标监测记录
     */
    @Override
    public MmpTumorQcIndicatorRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询质控指标监测记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 质控指标监测记录分页列表
     */
    @Override
    public TableDataInfo<MmpTumorQcIndicatorRecordVo> queryPageList(MmpTumorQcIndicatorRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpTumorQcIndicatorRecord> lqw = buildQueryWrapper(bo);
        Page<MmpTumorQcIndicatorRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的质控指标监测记录列表
     *
     * @param bo 查询条件
     * @return 质控指标监测记录列表
     */
    @Override
    public List<MmpTumorQcIndicatorRecordVo> queryList(MmpTumorQcIndicatorRecordBo bo) {
        LambdaQueryWrapper<MmpTumorQcIndicatorRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpTumorQcIndicatorRecord> buildQueryWrapper(MmpTumorQcIndicatorRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpTumorQcIndicatorRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpTumorQcIndicatorRecord::getId);
        lqw.eq(bo.getRecordDate() != null, MmpTumorQcIndicatorRecord::getRecordDate, bo.getRecordDate());
        lqw.eq(StringUtils.isNotBlank(bo.getCalculationCycle()), MmpTumorQcIndicatorRecord::getCalculationCycle, bo.getCalculationCycle());
        lqw.eq(bo.getDepartmentId() != null, MmpTumorQcIndicatorRecord::getDepartmentId, bo.getDepartmentId());
        lqw.like(StringUtils.isNotBlank(bo.getDepartmentName()), MmpTumorQcIndicatorRecord::getDepartmentName, bo.getDepartmentName());
        lqw.eq(bo.getIndicatorId() != null, MmpTumorQcIndicatorRecord::getIndicatorId, bo.getIndicatorId());
        lqw.eq(StringUtils.isNotBlank(bo.getIndicatorCode()), MmpTumorQcIndicatorRecord::getIndicatorCode, bo.getIndicatorCode());
        lqw.like(StringUtils.isNotBlank(bo.getIndicatorName()), MmpTumorQcIndicatorRecord::getIndicatorName, bo.getIndicatorName());
        lqw.eq(bo.getNumerator() != null, MmpTumorQcIndicatorRecord::getNumerator, bo.getNumerator());
        lqw.eq(bo.getDenominator() != null, MmpTumorQcIndicatorRecord::getDenominator, bo.getDenominator());
        lqw.eq(bo.getIndicatorValue() != null, MmpTumorQcIndicatorRecord::getIndicatorValue, bo.getIndicatorValue());
        lqw.eq(StringUtils.isNotBlank(bo.getTargetValue()), MmpTumorQcIndicatorRecord::getTargetValue, bo.getTargetValue());
        lqw.eq(StringUtils.isNotBlank(bo.getComplianceStatus()), MmpTumorQcIndicatorRecord::getComplianceStatus, bo.getComplianceStatus());
        lqw.eq(bo.getCompletionRate() != null, MmpTumorQcIndicatorRecord::getCompletionRate, bo.getCompletionRate());
        lqw.eq(bo.getRankInHospital() != null, MmpTumorQcIndicatorRecord::getRankInHospital, bo.getRankInHospital());
        lqw.eq(StringUtils.isNotBlank(bo.getTrendDirection()), MmpTumorQcIndicatorRecord::getTrendDirection, bo.getTrendDirection());
        lqw.eq(bo.getIsAbnormal() != null, MmpTumorQcIndicatorRecord::getIsAbnormal, bo.getIsAbnormal());
        lqw.eq(StringUtils.isNotBlank(bo.getDataSource()), MmpTumorQcIndicatorRecord::getDataSource, bo.getDataSource());
        lqw.eq(bo.getIsManual() != null, MmpTumorQcIndicatorRecord::getIsManual, bo.getIsManual());
        return lqw;
    }

    /**
     * 新增质控指标监测记录
     *
     * @param bo 质控指标监测记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpTumorQcIndicatorRecordBo bo) {
        MmpTumorQcIndicatorRecord add = MapstructUtils.convert(bo, MmpTumorQcIndicatorRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改质控指标监测记录
     *
     * @param bo 质控指标监测记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpTumorQcIndicatorRecordBo bo) {
        MmpTumorQcIndicatorRecord update = MapstructUtils.convert(bo, MmpTumorQcIndicatorRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpTumorQcIndicatorRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除质控指标监测记录信息
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
