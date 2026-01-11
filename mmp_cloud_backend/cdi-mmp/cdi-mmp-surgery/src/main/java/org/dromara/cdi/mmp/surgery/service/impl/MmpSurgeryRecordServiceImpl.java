package org.dromara.cdi.mmp.surgery.service.impl;

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
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryRecordBo;
import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryRecordVo;
import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryRecord;
import org.dromara.cdi.mmp.surgery.mapper.MmpSurgeryRecordMapper;
import org.dromara.cdi.mmp.surgery.service.IMmpSurgeryRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 手术记录Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSurgeryRecordServiceImpl implements IMmpSurgeryRecordService {

    private final MmpSurgeryRecordMapper baseMapper;

    /**
     * 查询手术记录
     *
     * @param id 主键
     * @return 手术记录
     */
    @Override
    public MmpSurgeryRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询手术记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 手术记录分页列表
     */
    @Override
    public TableDataInfo<MmpSurgeryRecordVo> queryPageList(MmpSurgeryRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSurgeryRecord> lqw = buildQueryWrapper(bo);
        Page<MmpSurgeryRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的手术记录列表
     *
     * @param bo 查询条件
     * @return 手术记录列表
     */
    @Override
    public List<MmpSurgeryRecordVo> queryList(MmpSurgeryRecordBo bo) {
        LambdaQueryWrapper<MmpSurgeryRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSurgeryRecord> buildQueryWrapper(MmpSurgeryRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSurgeryRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSurgeryRecord::getId);
        lqw.like(StringUtils.isNotBlank(bo.getPatientName()), MmpSurgeryRecord::getPatientName, bo.getPatientName());
        lqw.like(StringUtils.isNotBlank(bo.getDoctorName()), MmpSurgeryRecord::getDoctorName, bo.getDoctorName());
        lqw.like(StringUtils.isNotBlank(bo.getDepartmentName()), MmpSurgeryRecord::getDepartmentName, bo.getDepartmentName());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryCode()), MmpSurgeryRecord::getSurgeryCode, bo.getSurgeryCode());
        lqw.like(StringUtils.isNotBlank(bo.getSurgeryName()), MmpSurgeryRecord::getSurgeryName, bo.getSurgeryName());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryLevel()), MmpSurgeryRecord::getSurgeryLevel, bo.getSurgeryLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryType()), MmpSurgeryRecord::getSurgeryType, bo.getSurgeryType());
        lqw.eq(StringUtils.isNotBlank(bo.getAnesthesiaMethod()), MmpSurgeryRecord::getAnesthesiaMethod, bo.getAnesthesiaMethod());
        lqw.eq(bo.getSurgeryStartTime() != null, MmpSurgeryRecord::getSurgeryStartTime, bo.getSurgeryStartTime());
        lqw.eq(bo.getSurgeryEndTime() != null, MmpSurgeryRecord::getSurgeryEndTime, bo.getSurgeryEndTime());
        lqw.eq(bo.getSurgeryDuration() != null, MmpSurgeryRecord::getSurgeryDuration, bo.getSurgeryDuration());
        lqw.eq(StringUtils.isNotBlank(bo.getAsaGrade()), MmpSurgeryRecord::getAsaGrade, bo.getAsaGrade());
        lqw.eq(bo.getBloodLoss() != null, MmpSurgeryRecord::getBloodLoss, bo.getBloodLoss());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryStatus()), MmpSurgeryRecord::getSurgeryStatus, bo.getSurgeryStatus());
        lqw.eq(bo.getComplicationFlag() != null, MmpSurgeryRecord::getComplicationFlag, bo.getComplicationFlag());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpSurgeryRecord::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增手术记录
     *
     * @param bo 手术记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSurgeryRecordBo bo) {
        MmpSurgeryRecord add = MapstructUtils.convert(bo, MmpSurgeryRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改手术记录
     *
     * @param bo 手术记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSurgeryRecordBo bo) {
        MmpSurgeryRecord update = MapstructUtils.convert(bo, MmpSurgeryRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSurgeryRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除手术记录信息
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
