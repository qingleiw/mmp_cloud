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
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationUsageRecordBo;
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationUsageRecordVo;
import org.dromara.cdi.mmp.qualification.domain.MmpQualificationUsageRecord;
import org.dromara.cdi.mmp.qualification.mapper.MmpQualificationUsageRecordMapper;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationUsageRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 资质使用记录Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQualificationUsageRecordServiceImpl implements IMmpQualificationUsageRecordService {

    private final MmpQualificationUsageRecordMapper baseMapper;

    /**
     * 查询资质使用记录
     *
     * @param id 主键
     * @return 资质使用记录
     */
    @Override
    public MmpQualificationUsageRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询资质使用记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质使用记录分页列表
     */
    @Override
    public TableDataInfo<MmpQualificationUsageRecordVo> queryPageList(MmpQualificationUsageRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQualificationUsageRecord> lqw = buildQueryWrapper(bo);
        Page<MmpQualificationUsageRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的资质使用记录列表
     *
     * @param bo 查询条件
     * @return 资质使用记录列表
     */
    @Override
    public List<MmpQualificationUsageRecordVo> queryList(MmpQualificationUsageRecordBo bo) {
        LambdaQueryWrapper<MmpQualificationUsageRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQualificationUsageRecord> buildQueryWrapper(MmpQualificationUsageRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQualificationUsageRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQualificationUsageRecord::getId);
        lqw.eq(bo.getAuthorizationId() != null, MmpQualificationUsageRecord::getAuthorizationId, bo.getAuthorizationId());
        lqw.eq(bo.getStaffId() != null, MmpQualificationUsageRecord::getStaffId, bo.getStaffId());
        lqw.eq(bo.getQualificationId() != null, MmpQualificationUsageRecord::getQualificationId, bo.getQualificationId());
        lqw.eq(bo.getUsageDate() != null, MmpQualificationUsageRecord::getUsageDate, bo.getUsageDate());
        lqw.eq(bo.getPatientId() != null, MmpQualificationUsageRecord::getPatientId, bo.getPatientId());
        lqw.like(StringUtils.isNotBlank(bo.getPatientName()), MmpQualificationUsageRecord::getPatientName, bo.getPatientName());
        lqw.eq(StringUtils.isNotBlank(bo.getOperationCode()), MmpQualificationUsageRecord::getOperationCode, bo.getOperationCode());
        lqw.like(StringUtils.isNotBlank(bo.getOperationName()), MmpQualificationUsageRecord::getOperationName, bo.getOperationName());
        lqw.eq(StringUtils.isNotBlank(bo.getUsageResult()), MmpQualificationUsageRecord::getUsageResult, bo.getUsageResult());
        lqw.eq(bo.getIsOverAuthority() != null, MmpQualificationUsageRecord::getIsOverAuthority, bo.getIsOverAuthority());
        lqw.eq(StringUtils.isNotBlank(bo.getSourceSystem()), MmpQualificationUsageRecord::getSourceSystem, bo.getSourceSystem());
        return lqw;
    }

    /**
     * 新增资质使用记录
     *
     * @param bo 资质使用记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQualificationUsageRecordBo bo) {
        MmpQualificationUsageRecord add = MapstructUtils.convert(bo, MmpQualificationUsageRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改资质使用记录
     *
     * @param bo 资质使用记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQualificationUsageRecordBo bo) {
        MmpQualificationUsageRecord update = MapstructUtils.convert(bo, MmpQualificationUsageRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQualificationUsageRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除资质使用记录信息
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
