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
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationDoseAlertRecordBo;
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationDoseAlertRecordVo;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationDoseAlertRecord;
import org.dromara.cdi.mmp.radiation.mapper.MmpRadiationDoseAlertRecordMapper;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationDoseAlertRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 剂量异常预警记录Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpRadiationDoseAlertRecordServiceImpl implements IMmpRadiationDoseAlertRecordService {

    private final MmpRadiationDoseAlertRecordMapper baseMapper;

    /**
     * 查询剂量异常预警记录
     *
     * @param id 主键
     * @return 剂量异常预警记录
     */
    @Override
    public MmpRadiationDoseAlertRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询剂量异常预警记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 剂量异常预警记录分页列表
     */
    @Override
    public TableDataInfo<MmpRadiationDoseAlertRecordVo> queryPageList(MmpRadiationDoseAlertRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpRadiationDoseAlertRecord> lqw = buildQueryWrapper(bo);
        Page<MmpRadiationDoseAlertRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的剂量异常预警记录列表
     *
     * @param bo 查询条件
     * @return 剂量异常预警记录列表
     */
    @Override
    public List<MmpRadiationDoseAlertRecordVo> queryList(MmpRadiationDoseAlertRecordBo bo) {
        LambdaQueryWrapper<MmpRadiationDoseAlertRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpRadiationDoseAlertRecord> buildQueryWrapper(MmpRadiationDoseAlertRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpRadiationDoseAlertRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpRadiationDoseAlertRecord::getId);
        lqw.like(StringUtils.isNotBlank(bo.getStaffName()), MmpRadiationDoseAlertRecord::getStaffName, bo.getStaffName());
        lqw.eq(bo.getAlertDate() != null, MmpRadiationDoseAlertRecord::getAlertDate, bo.getAlertDate());
        lqw.eq(StringUtils.isNotBlank(bo.getAlertType()), MmpRadiationDoseAlertRecord::getAlertType, bo.getAlertType());
        lqw.eq(bo.getCurrentDose() != null, MmpRadiationDoseAlertRecord::getCurrentDose, bo.getCurrentDose());
        lqw.eq(bo.getThresholdValue() != null, MmpRadiationDoseAlertRecord::getThresholdValue, bo.getThresholdValue());
        lqw.eq(StringUtils.isNotBlank(bo.getAlertLevel()), MmpRadiationDoseAlertRecord::getAlertLevel, bo.getAlertLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getAlertMessage()), MmpRadiationDoseAlertRecord::getAlertMessage, bo.getAlertMessage());
        lqw.eq(StringUtils.isNotBlank(bo.getIsHandled()), MmpRadiationDoseAlertRecord::getIsHandled, bo.getIsHandled());
        lqw.eq(StringUtils.isNotBlank(bo.getHandler()), MmpRadiationDoseAlertRecord::getHandler, bo.getHandler());
        lqw.eq(bo.getHandleTime() != null, MmpRadiationDoseAlertRecord::getHandleTime, bo.getHandleTime());
        lqw.eq(StringUtils.isNotBlank(bo.getHandleResult()), MmpRadiationDoseAlertRecord::getHandleResult, bo.getHandleResult());
        return lqw;
    }

    /**
     * 新增剂量异常预警记录
     *
     * @param bo 剂量异常预警记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpRadiationDoseAlertRecordBo bo) {
        MmpRadiationDoseAlertRecord add = MapstructUtils.convert(bo, MmpRadiationDoseAlertRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改剂量异常预警记录
     *
     * @param bo 剂量异常预警记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpRadiationDoseAlertRecordBo bo) {
        MmpRadiationDoseAlertRecord update = MapstructUtils.convert(bo, MmpRadiationDoseAlertRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpRadiationDoseAlertRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除剂量异常预警记录信息
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
