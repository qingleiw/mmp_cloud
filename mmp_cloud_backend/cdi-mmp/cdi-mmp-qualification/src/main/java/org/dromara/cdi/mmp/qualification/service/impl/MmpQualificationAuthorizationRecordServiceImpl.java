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
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationAuthorizationRecordBo;
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationAuthorizationRecordVo;
import org.dromara.cdi.mmp.qualification.domain.MmpQualificationAuthorizationRecord;
import org.dromara.cdi.mmp.qualification.mapper.MmpQualificationAuthorizationRecordMapper;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationAuthorizationRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 资质授权记录Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQualificationAuthorizationRecordServiceImpl implements IMmpQualificationAuthorizationRecordService {

    private final MmpQualificationAuthorizationRecordMapper baseMapper;

    /**
     * 查询资质授权记录
     *
     * @param id 主键
     * @return 资质授权记录
     */
    @Override
    public MmpQualificationAuthorizationRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询资质授权记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质授权记录分页列表
     */
    @Override
    public TableDataInfo<MmpQualificationAuthorizationRecordVo> queryPageList(MmpQualificationAuthorizationRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQualificationAuthorizationRecord> lqw = buildQueryWrapper(bo);
        Page<MmpQualificationAuthorizationRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的资质授权记录列表
     *
     * @param bo 查询条件
     * @return 资质授权记录列表
     */
    @Override
    public List<MmpQualificationAuthorizationRecordVo> queryList(MmpQualificationAuthorizationRecordBo bo) {
        LambdaQueryWrapper<MmpQualificationAuthorizationRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQualificationAuthorizationRecord> buildQueryWrapper(MmpQualificationAuthorizationRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQualificationAuthorizationRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQualificationAuthorizationRecord::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getAuthorizationNo()), MmpQualificationAuthorizationRecord::getAuthorizationNo, bo.getAuthorizationNo());
        lqw.eq(bo.getStaffId() != null, MmpQualificationAuthorizationRecord::getStaffId, bo.getStaffId());
        lqw.like(StringUtils.isNotBlank(bo.getStaffName()), MmpQualificationAuthorizationRecord::getStaffName, bo.getStaffName());
        lqw.eq(StringUtils.isNotBlank(bo.getStaffType()), MmpQualificationAuthorizationRecord::getStaffType, bo.getStaffType());
        lqw.eq(bo.getQualificationId() != null, MmpQualificationAuthorizationRecord::getQualificationId, bo.getQualificationId());
        lqw.eq(StringUtils.isNotBlank(bo.getQualificationCode()), MmpQualificationAuthorizationRecord::getQualificationCode, bo.getQualificationCode());
        lqw.like(StringUtils.isNotBlank(bo.getQualificationName()), MmpQualificationAuthorizationRecord::getQualificationName, bo.getQualificationName());
        lqw.eq(StringUtils.isNotBlank(bo.getAuthorizationType()), MmpQualificationAuthorizationRecord::getAuthorizationType, bo.getAuthorizationType());
        lqw.eq(StringUtils.isNotBlank(bo.getAuthorizationLevel()), MmpQualificationAuthorizationRecord::getAuthorizationLevel, bo.getAuthorizationLevel());
        lqw.eq(bo.getValidStartDate() != null, MmpQualificationAuthorizationRecord::getValidStartDate, bo.getValidStartDate());
        lqw.eq(bo.getValidEndDate() != null, MmpQualificationAuthorizationRecord::getValidEndDate, bo.getValidEndDate());
        lqw.eq(StringUtils.isNotBlank(bo.getAuthorizationStatus()), MmpQualificationAuthorizationRecord::getAuthorizationStatus, bo.getAuthorizationStatus());
        lqw.eq(bo.getApplyId() != null, MmpQualificationAuthorizationRecord::getApplyId, bo.getApplyId());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecialCondition()), MmpQualificationAuthorizationRecord::getSpecialCondition, bo.getSpecialCondition());
        lqw.eq(bo.getPatientId() != null, MmpQualificationAuthorizationRecord::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getAuthorizationReason()), MmpQualificationAuthorizationRecord::getAuthorizationReason, bo.getAuthorizationReason());
        lqw.eq(bo.getDelFlag() != null, MmpQualificationAuthorizationRecord::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增资质授权记录
     *
     * @param bo 资质授权记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQualificationAuthorizationRecordBo bo) {
        MmpQualificationAuthorizationRecord add = MapstructUtils.convert(bo, MmpQualificationAuthorizationRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改资质授权记录
     *
     * @param bo 资质授权记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQualificationAuthorizationRecordBo bo) {
        MmpQualificationAuthorizationRecord update = MapstructUtils.convert(bo, MmpQualificationAuthorizationRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQualificationAuthorizationRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除资质授权记录信息
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
