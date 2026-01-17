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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB151OutpatientExpenseRecordBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB151OutpatientExpenseRecordVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB151OutpatientExpenseRecord;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB151OutpatientExpenseRecordMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB151OutpatientExpenseRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B15-1 门诊收费记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB151OutpatientExpenseRecordServiceImpl implements IMmpNatdssB151OutpatientExpenseRecordService {

    private final MmpNatdssB151OutpatientExpenseRecordMapper baseMapper;

    /**
     * 查询B15-1 门诊收费记录
     *
     * @param id 主键
     * @return B15-1 门诊收费记录
     */
    @Override
    public MmpNatdssB151OutpatientExpenseRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B15-1 门诊收费记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B15-1 门诊收费记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB151OutpatientExpenseRecordVo> queryPageList(MmpNatdssB151OutpatientExpenseRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB151OutpatientExpenseRecord> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB151OutpatientExpenseRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B15-1 门诊收费记录列表
     *
     * @param bo 查询条件
     * @return B15-1 门诊收费记录列表
     */
    @Override
    public List<MmpNatdssB151OutpatientExpenseRecordVo> queryList(MmpNatdssB151OutpatientExpenseRecordBo bo) {
        LambdaQueryWrapper<MmpNatdssB151OutpatientExpenseRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB151OutpatientExpenseRecord> buildQueryWrapper(MmpNatdssB151OutpatientExpenseRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB151OutpatientExpenseRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB151OutpatientExpenseRecord::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB151OutpatientExpenseRecord::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB151OutpatientExpenseRecord::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB151OutpatientExpenseRecord::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB151OutpatientExpenseRecord::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB151OutpatientExpenseRecord::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB151OutpatientExpenseRecord::getVisitTimes, bo.getVisitTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getExpenseSn()), MmpNatdssB151OutpatientExpenseRecord::getExpenseSn, bo.getExpenseSn());
        lqw.eq(StringUtils.isNotBlank(bo.getReceiptNo()), MmpNatdssB151OutpatientExpenseRecord::getReceiptNo, bo.getReceiptNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), MmpNatdssB151OutpatientExpenseRecord::getOrderSn, bo.getOrderSn());
        lqw.eq(bo.getExpenseDatetime() != null, MmpNatdssB151OutpatientExpenseRecord::getExpenseDatetime, bo.getExpenseDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getTransactionTypeCode()), MmpNatdssB151OutpatientExpenseRecord::getTransactionTypeCode, bo.getTransactionTypeCode());
        lqw.like(StringUtils.isNotBlank(bo.getTransactionTypeName()), MmpNatdssB151OutpatientExpenseRecord::getTransactionTypeName, bo.getTransactionTypeName());
        lqw.eq(StringUtils.isNotBlank(bo.getItemTypeCode()), MmpNatdssB151OutpatientExpenseRecord::getItemTypeCode, bo.getItemTypeCode());
        lqw.like(StringUtils.isNotBlank(bo.getItemTypeName()), MmpNatdssB151OutpatientExpenseRecord::getItemTypeName, bo.getItemTypeName());
        lqw.eq(StringUtils.isNotBlank(bo.getItemCode()), MmpNatdssB151OutpatientExpenseRecord::getItemCode, bo.getItemCode());
        lqw.like(StringUtils.isNotBlank(bo.getItemName()), MmpNatdssB151OutpatientExpenseRecord::getItemName, bo.getItemName());
        lqw.eq(StringUtils.isNotBlank(bo.getItemUnit()), MmpNatdssB151OutpatientExpenseRecord::getItemUnit, bo.getItemUnit());
        lqw.eq(bo.getItemUnitPrice() != null, MmpNatdssB151OutpatientExpenseRecord::getItemUnitPrice, bo.getItemUnitPrice());
        lqw.eq(bo.getItemAmount() != null, MmpNatdssB151OutpatientExpenseRecord::getItemAmount, bo.getItemAmount());
        lqw.eq(bo.getItemTotalPrice() != null, MmpNatdssB151OutpatientExpenseRecord::getItemTotalPrice, bo.getItemTotalPrice());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB151OutpatientExpenseRecord::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB151OutpatientExpenseRecord::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB151OutpatientExpenseRecord::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB151OutpatientExpenseRecord::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB151OutpatientExpenseRecord::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B15-1 门诊收费记录
     *
     * @param bo B15-1 门诊收费记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB151OutpatientExpenseRecordBo bo) {
        MmpNatdssB151OutpatientExpenseRecord add = MapstructUtils.convert(bo, MmpNatdssB151OutpatientExpenseRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B15-1 门诊收费记录
     *
     * @param bo B15-1 门诊收费记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB151OutpatientExpenseRecordBo bo) {
        MmpNatdssB151OutpatientExpenseRecord update = MapstructUtils.convert(bo, MmpNatdssB151OutpatientExpenseRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB151OutpatientExpenseRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B15-1 门诊收费记录信息
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
