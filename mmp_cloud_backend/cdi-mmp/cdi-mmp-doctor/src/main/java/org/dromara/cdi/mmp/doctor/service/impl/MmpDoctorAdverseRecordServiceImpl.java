package org.dromara.cdi.mmp.doctor.service.impl;

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
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorAdverseRecordBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorAdverseRecordVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorAdverseRecord;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorAdverseRecordMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorAdverseRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 不良行为记录Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorAdverseRecordServiceImpl implements IMmpDoctorAdverseRecordService {

    private final MmpDoctorAdverseRecordMapper baseMapper;

    /**
     * 查询不良行为记录
     *
     * @param id 主键
     * @return 不良行为记录
     */
    @Override
    public MmpDoctorAdverseRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询不良行为记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 不良行为记录分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorAdverseRecordVo> queryPageList(MmpDoctorAdverseRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorAdverseRecord> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorAdverseRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的不良行为记录列表
     *
     * @param bo 查询条件
     * @return 不良行为记录列表
     */
    @Override
    public List<MmpDoctorAdverseRecordVo> queryList(MmpDoctorAdverseRecordBo bo) {
        LambdaQueryWrapper<MmpDoctorAdverseRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpDoctorAdverseRecord> buildQueryWrapper(MmpDoctorAdverseRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorAdverseRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorAdverseRecord::getId);
        lqw.eq(bo.getDoctorId() != null, MmpDoctorAdverseRecord::getDoctorId, bo.getDoctorId());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordType()), MmpDoctorAdverseRecord::getRecordType, bo.getRecordType());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordTitle()), MmpDoctorAdverseRecord::getRecordTitle, bo.getRecordTitle());
        lqw.eq(bo.getOccurDate() != null, MmpDoctorAdverseRecord::getOccurDate, bo.getOccurDate());
        lqw.eq(StringUtils.isNotBlank(bo.getDescription()), MmpDoctorAdverseRecord::getDescription, bo.getDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getConsequence()), MmpDoctorAdverseRecord::getConsequence, bo.getConsequence());
        lqw.eq(StringUtils.isNotBlank(bo.getHandlingMeasure()), MmpDoctorAdverseRecord::getHandlingMeasure, bo.getHandlingMeasure());
        lqw.eq(StringUtils.isNotBlank(bo.getPunishment()), MmpDoctorAdverseRecord::getPunishment, bo.getPunishment());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordStatus()), MmpDoctorAdverseRecord::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getDelFlag() != null, MmpDoctorAdverseRecord::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增不良行为记录
     *
     * @param bo 不良行为记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorAdverseRecordBo bo) {
        MmpDoctorAdverseRecord add = MapstructUtils.convert(bo, MmpDoctorAdverseRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改不良行为记录
     *
     * @param bo 不良行为记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorAdverseRecordBo bo) {
        MmpDoctorAdverseRecord update = MapstructUtils.convert(bo, MmpDoctorAdverseRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorAdverseRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除不良行为记录信息
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
