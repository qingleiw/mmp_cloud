package org.dromara.cdi.mmp.natdss.service.impl;

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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB111InpatientExpenseRecordBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB111InpatientExpenseRecordVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB111InpatientExpenseRecord;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB111InpatientExpenseRecordMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB111InpatientExpenseRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B11-1 住院收费记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB111InpatientExpenseRecordServiceImpl implements IMmpNatdssB111InpatientExpenseRecordService {

    private final MmpNatdssB111InpatientExpenseRecordMapper baseMapper;

    /**
     * 查询B11-1 住院收费记录
     *
     * @param id 主键
     * @return B11-1 住院收费记录
     */
    @Override
    public MmpNatdssB111InpatientExpenseRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B11-1 住院收费记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B11-1 住院收费记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB111InpatientExpenseRecordVo> queryPageList(MmpNatdssB111InpatientExpenseRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB111InpatientExpenseRecord> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB111InpatientExpenseRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B11-1 住院收费记录列表
     *
     * @param bo 查询条件
     * @return B11-1 住院收费记录列表
     */
    @Override
    public List<MmpNatdssB111InpatientExpenseRecordVo> queryList(MmpNatdssB111InpatientExpenseRecordBo bo) {
        LambdaQueryWrapper<MmpNatdssB111InpatientExpenseRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB111InpatientExpenseRecord> buildQueryWrapper(MmpNatdssB111InpatientExpenseRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB111InpatientExpenseRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB111InpatientExpenseRecord::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB111InpatientExpenseRecord::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB111InpatientExpenseRecord::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB111InpatientExpenseRecord::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB111InpatientExpenseRecord::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB111InpatientExpenseRecord::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getExpenseSn()), MmpNatdssB111InpatientExpenseRecord::getExpenseSn, bo.getExpenseSn());
        lqw.eq(StringUtils.isNotBlank(bo.getReceiptNo()), MmpNatdssB111InpatientExpenseRecord::getReceiptNo, bo.getReceiptNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), MmpNatdssB111InpatientExpenseRecord::getOrderSn, bo.getOrderSn());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderType()), MmpNatdssB111InpatientExpenseRecord::getOrderType, bo.getOrderType());
        lqw.eq(bo.getExpenseDatetime() != null, MmpNatdssB111InpatientExpenseRecord::getExpenseDatetime, bo.getExpenseDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getTransactionTypeCode()), MmpNatdssB111InpatientExpenseRecord::getTransactionTypeCode, bo.getTransactionTypeCode());
        lqw.like(StringUtils.isNotBlank(bo.getTransactionTypeName()), MmpNatdssB111InpatientExpenseRecord::getTransactionTypeName, bo.getTransactionTypeName());
        lqw.eq(StringUtils.isNotBlank(bo.getItemTypeCode()), MmpNatdssB111InpatientExpenseRecord::getItemTypeCode, bo.getItemTypeCode());
        lqw.like(StringUtils.isNotBlank(bo.getItemTypeName()), MmpNatdssB111InpatientExpenseRecord::getItemTypeName, bo.getItemTypeName());
        lqw.eq(StringUtils.isNotBlank(bo.getItemCode()), MmpNatdssB111InpatientExpenseRecord::getItemCode, bo.getItemCode());
        lqw.like(StringUtils.isNotBlank(bo.getItemName()), MmpNatdssB111InpatientExpenseRecord::getItemName, bo.getItemName());
        lqw.eq(StringUtils.isNotBlank(bo.getItemUnit()), MmpNatdssB111InpatientExpenseRecord::getItemUnit, bo.getItemUnit());
        lqw.eq(bo.getItemUnitPrice() != null, MmpNatdssB111InpatientExpenseRecord::getItemUnitPrice, bo.getItemUnitPrice());
        lqw.eq(bo.getItemAmount() != null, MmpNatdssB111InpatientExpenseRecord::getItemAmount, bo.getItemAmount());
        lqw.eq(bo.getItemTotalPrice() != null, MmpNatdssB111InpatientExpenseRecord::getItemTotalPrice, bo.getItemTotalPrice());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB111InpatientExpenseRecord::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB111InpatientExpenseRecord::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB111InpatientExpenseRecord::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB111InpatientExpenseRecord::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB111InpatientExpenseRecord::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B11-1 住院收费记录
     *
     * @param bo B11-1 住院收费记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB111InpatientExpenseRecordBo bo) {
        MmpNatdssB111InpatientExpenseRecord add = MapstructUtils.convert(bo, MmpNatdssB111InpatientExpenseRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B11-1 住院收费记录
     *
     * @param bo B11-1 住院收费记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB111InpatientExpenseRecordBo bo) {
        MmpNatdssB111InpatientExpenseRecord update = MapstructUtils.convert(bo, MmpNatdssB111InpatientExpenseRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB111InpatientExpenseRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B11-1 住院收费记录信息
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
