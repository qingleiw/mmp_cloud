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
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationDoseRecordBo;
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationDoseRecordVo;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationDoseRecord;
import org.dromara.cdi.mmp.radiation.mapper.MmpRadiationDoseRecordMapper;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationDoseRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 个人剂量监测记录Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpRadiationDoseRecordServiceImpl implements IMmpRadiationDoseRecordService {

    private final MmpRadiationDoseRecordMapper baseMapper;

    /**
     * 查询个人剂量监测记录
     *
     * @param id 主键
     * @return 个人剂量监测记录
     */
    @Override
    public MmpRadiationDoseRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询个人剂量监测记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 个人剂量监测记录分页列表
     */
    @Override
    public TableDataInfo<MmpRadiationDoseRecordVo> queryPageList(MmpRadiationDoseRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpRadiationDoseRecord> lqw = buildQueryWrapper(bo);
        Page<MmpRadiationDoseRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的个人剂量监测记录列表
     *
     * @param bo 查询条件
     * @return 个人剂量监测记录列表
     */
    @Override
    public List<MmpRadiationDoseRecordVo> queryList(MmpRadiationDoseRecordBo bo) {
        LambdaQueryWrapper<MmpRadiationDoseRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpRadiationDoseRecord> buildQueryWrapper(MmpRadiationDoseRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpRadiationDoseRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpRadiationDoseRecord::getId);
        lqw.like(StringUtils.isNotBlank(bo.getStaffName()), MmpRadiationDoseRecord::getStaffName, bo.getStaffName());
        lqw.eq(bo.getRecordDate() != null, MmpRadiationDoseRecord::getRecordDate, bo.getRecordDate());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordPeriod()), MmpRadiationDoseRecord::getRecordPeriod, bo.getRecordPeriod());
        lqw.eq(bo.getDoseValue() != null, MmpRadiationDoseRecord::getDoseValue, bo.getDoseValue());
        lqw.eq(StringUtils.isNotBlank(bo.getDoseUnit()), MmpRadiationDoseRecord::getDoseUnit, bo.getDoseUnit());
        lqw.eq(StringUtils.isNotBlank(bo.getMeasurementMethod()), MmpRadiationDoseRecord::getMeasurementMethod, bo.getMeasurementMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getMeasurementDevice()), MmpRadiationDoseRecord::getMeasurementDevice, bo.getMeasurementDevice());
        lqw.eq(StringUtils.isNotBlank(bo.getRemarks()), MmpRadiationDoseRecord::getRemarks, bo.getRemarks());
        return lqw;
    }

    /**
     * 新增个人剂量监测记录
     *
     * @param bo 个人剂量监测记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpRadiationDoseRecordBo bo) {
        MmpRadiationDoseRecord add = MapstructUtils.convert(bo, MmpRadiationDoseRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改个人剂量监测记录
     *
     * @param bo 个人剂量监测记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpRadiationDoseRecordBo bo) {
        MmpRadiationDoseRecord update = MapstructUtils.convert(bo, MmpRadiationDoseRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpRadiationDoseRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除个人剂量监测记录信息
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
