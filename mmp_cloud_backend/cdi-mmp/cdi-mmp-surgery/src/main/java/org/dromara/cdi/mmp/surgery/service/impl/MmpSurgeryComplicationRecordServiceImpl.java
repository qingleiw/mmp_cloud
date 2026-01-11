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
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryComplicationRecordBo;
import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryComplicationRecordVo;
import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryComplicationRecord;
import org.dromara.cdi.mmp.surgery.mapper.MmpSurgeryComplicationRecordMapper;
import org.dromara.cdi.mmp.surgery.service.IMmpSurgeryComplicationRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 手术并发症记录Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSurgeryComplicationRecordServiceImpl implements IMmpSurgeryComplicationRecordService {

    private final MmpSurgeryComplicationRecordMapper baseMapper;

    /**
     * 查询手术并发症记录
     *
     * @param id 主键
     * @return 手术并发症记录
     */
    @Override
    public MmpSurgeryComplicationRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询手术并发症记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 手术并发症记录分页列表
     */
    @Override
    public TableDataInfo<MmpSurgeryComplicationRecordVo> queryPageList(MmpSurgeryComplicationRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSurgeryComplicationRecord> lqw = buildQueryWrapper(bo);
        Page<MmpSurgeryComplicationRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的手术并发症记录列表
     *
     * @param bo 查询条件
     * @return 手术并发症记录列表
     */
    @Override
    public List<MmpSurgeryComplicationRecordVo> queryList(MmpSurgeryComplicationRecordBo bo) {
        LambdaQueryWrapper<MmpSurgeryComplicationRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSurgeryComplicationRecord> buildQueryWrapper(MmpSurgeryComplicationRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSurgeryComplicationRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSurgeryComplicationRecord::getId);
        lqw.like(StringUtils.isNotBlank(bo.getDoctorName()), MmpSurgeryComplicationRecord::getDoctorName, bo.getDoctorName());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryCode()), MmpSurgeryComplicationRecord::getSurgeryCode, bo.getSurgeryCode());
        lqw.like(StringUtils.isNotBlank(bo.getSurgeryName()), MmpSurgeryComplicationRecord::getSurgeryName, bo.getSurgeryName());
        lqw.eq(StringUtils.isNotBlank(bo.getComplicationType()), MmpSurgeryComplicationRecord::getComplicationType, bo.getComplicationType());
        lqw.eq(StringUtils.isNotBlank(bo.getComplicationDescription()), MmpSurgeryComplicationRecord::getComplicationDescription, bo.getComplicationDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getComplicationLevel()), MmpSurgeryComplicationRecord::getComplicationLevel, bo.getComplicationLevel());
        lqw.eq(bo.getOccurrenceTime() != null, MmpSurgeryComplicationRecord::getOccurrenceTime, bo.getOccurrenceTime());
        lqw.eq(bo.getIsPlannedSecondary() != null, MmpSurgeryComplicationRecord::getIsPlannedSecondary, bo.getIsPlannedSecondary());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpSurgeryComplicationRecord::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增手术并发症记录
     *
     * @param bo 手术并发症记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSurgeryComplicationRecordBo bo) {
        MmpSurgeryComplicationRecord add = MapstructUtils.convert(bo, MmpSurgeryComplicationRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改手术并发症记录
     *
     * @param bo 手术并发症记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSurgeryComplicationRecordBo bo) {
        MmpSurgeryComplicationRecord update = MapstructUtils.convert(bo, MmpSurgeryComplicationRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSurgeryComplicationRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除手术并发症记录信息
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
