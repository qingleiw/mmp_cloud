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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB101InpatientOrderBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB101InpatientOrderVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB101InpatientOrder;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB101InpatientOrderMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB101InpatientOrderService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B10-1 住院医嘱记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB101InpatientOrderServiceImpl implements IMmpNatdssB101InpatientOrderService {

    private final MmpNatdssB101InpatientOrderMapper baseMapper;

    /**
     * 查询B10-1 住院医嘱记录
     *
     * @param id 主键
     * @return B10-1 住院医嘱记录
     */
    @Override
    public MmpNatdssB101InpatientOrderVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B10-1 住院医嘱记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B10-1 住院医嘱记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB101InpatientOrderVo> queryPageList(MmpNatdssB101InpatientOrderBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB101InpatientOrder> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB101InpatientOrderVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B10-1 住院医嘱记录列表
     *
     * @param bo 查询条件
     * @return B10-1 住院医嘱记录列表
     */
    @Override
    public List<MmpNatdssB101InpatientOrderVo> queryList(MmpNatdssB101InpatientOrderBo bo) {
        LambdaQueryWrapper<MmpNatdssB101InpatientOrder> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB101InpatientOrder> buildQueryWrapper(MmpNatdssB101InpatientOrderBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB101InpatientOrder> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB101InpatientOrder::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB101InpatientOrder::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB101InpatientOrder::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB101InpatientOrder::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB101InpatientOrder::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB101InpatientOrder::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), MmpNatdssB101InpatientOrder::getOrderSn, bo.getOrderSn());
        lqw.eq(StringUtils.isNotBlank(bo.getRequestNo()), MmpNatdssB101InpatientOrder::getRequestNo, bo.getRequestNo());
        lqw.eq(bo.getOrderGivenTime() != null, MmpNatdssB101InpatientOrder::getOrderGivenTime, bo.getOrderGivenTime());
        lqw.eq(bo.getOrderConfirmTime() != null, MmpNatdssB101InpatientOrder::getOrderConfirmTime, bo.getOrderConfirmTime());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderDeptCode()), MmpNatdssB101InpatientOrder::getOrderDeptCode, bo.getOrderDeptCode());
        lqw.like(StringUtils.isNotBlank(bo.getOrderDeptName()), MmpNatdssB101InpatientOrder::getOrderDeptName, bo.getOrderDeptName());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderDoctorNo()), MmpNatdssB101InpatientOrder::getOrderDoctorNo, bo.getOrderDoctorNo());
        lqw.eq(StringUtils.isNotBlank(bo.getTechnicalTitle()), MmpNatdssB101InpatientOrder::getTechnicalTitle, bo.getTechnicalTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getJobTitle()), MmpNatdssB101InpatientOrder::getJobTitle, bo.getJobTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitDeptCode()), MmpNatdssB101InpatientOrder::getVisitDeptCode, bo.getVisitDeptCode());
        lqw.like(StringUtils.isNotBlank(bo.getVisitDeptName()), MmpNatdssB101InpatientOrder::getVisitDeptName, bo.getVisitDeptName());
        lqw.eq(bo.getOrderStartDatetime() != null, MmpNatdssB101InpatientOrder::getOrderStartDatetime, bo.getOrderStartDatetime());
        lqw.eq(bo.getOrderEndDatetime() != null, MmpNatdssB101InpatientOrder::getOrderEndDatetime, bo.getOrderEndDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getExecutiveDeptCode()), MmpNatdssB101InpatientOrder::getExecutiveDeptCode, bo.getExecutiveDeptCode());
        lqw.like(StringUtils.isNotBlank(bo.getExecutiveDeptName()), MmpNatdssB101InpatientOrder::getExecutiveDeptName, bo.getExecutiveDeptName());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderType()), MmpNatdssB101InpatientOrder::getOrderType, bo.getOrderType());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderClassCode()), MmpNatdssB101InpatientOrder::getOrderClassCode, bo.getOrderClassCode());
        lqw.like(StringUtils.isNotBlank(bo.getOrderClassName()), MmpNatdssB101InpatientOrder::getOrderClassName, bo.getOrderClassName());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderItemCode()), MmpNatdssB101InpatientOrder::getOrderItemCode, bo.getOrderItemCode());
        lqw.like(StringUtils.isNotBlank(bo.getOrderItemName()), MmpNatdssB101InpatientOrder::getOrderItemName, bo.getOrderItemName());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderGroupNo()), MmpNatdssB101InpatientOrder::getOrderGroupNo, bo.getOrderGroupNo());
        lqw.eq(StringUtils.isNotBlank(bo.getDose()), MmpNatdssB101InpatientOrder::getDose, bo.getDose());
        lqw.eq(StringUtils.isNotBlank(bo.getDoseUnit()), MmpNatdssB101InpatientOrder::getDoseUnit, bo.getDoseUnit());
        lqw.eq(StringUtils.isNotBlank(bo.getForm()), MmpNatdssB101InpatientOrder::getForm, bo.getForm());
        lqw.eq(StringUtils.isNotBlank(bo.getSpec()), MmpNatdssB101InpatientOrder::getSpec, bo.getSpec());
        lqw.eq(StringUtils.isNotBlank(bo.getFrequencyCode()), MmpNatdssB101InpatientOrder::getFrequencyCode, bo.getFrequencyCode());
        lqw.like(StringUtils.isNotBlank(bo.getFrequencyName()), MmpNatdssB101InpatientOrder::getFrequencyName, bo.getFrequencyName());
        lqw.eq(StringUtils.isNotBlank(bo.getAdministrationRoute()), MmpNatdssB101InpatientOrder::getAdministrationRoute, bo.getAdministrationRoute());
        lqw.eq(StringUtils.isNotBlank(bo.getLiquidConfiguration()), MmpNatdssB101InpatientOrder::getLiquidConfiguration, bo.getLiquidConfiguration());
        lqw.eq(StringUtils.isNotBlank(bo.getInjectionType()), MmpNatdssB101InpatientOrder::getInjectionType, bo.getInjectionType());
        lqw.eq(StringUtils.isNotBlank(bo.getDrugOrder()), MmpNatdssB101InpatientOrder::getDrugOrder, bo.getDrugOrder());
        lqw.eq(StringUtils.isNotBlank(bo.getDrugCompatibility()), MmpNatdssB101InpatientOrder::getDrugCompatibility, bo.getDrugCompatibility());
        lqw.eq(StringUtils.isNotBlank(bo.getInfusionDuration()), MmpNatdssB101InpatientOrder::getInfusionDuration, bo.getInfusionDuration());
        lqw.eq(StringUtils.isNotBlank(bo.getNumOfOrder()), MmpNatdssB101InpatientOrder::getNumOfOrder, bo.getNumOfOrder());
        lqw.eq(StringUtils.isNotBlank(bo.getNumOfOrderUnit()), MmpNatdssB101InpatientOrder::getNumOfOrderUnit, bo.getNumOfOrderUnit());
        lqw.eq(StringUtils.isNotBlank(bo.getHerbalNote()), MmpNatdssB101InpatientOrder::getHerbalNote, bo.getHerbalNote());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderNote()), MmpNatdssB101InpatientOrder::getOrderNote, bo.getOrderNote());
        lqw.eq(StringUtils.isNotBlank(bo.getDrugFlag()), MmpNatdssB101InpatientOrder::getDrugFlag, bo.getDrugFlag());
        lqw.eq(StringUtils.isNotBlank(bo.getManufac()), MmpNatdssB101InpatientOrder::getManufac, bo.getManufac());
        lqw.like(StringUtils.isNotBlank(bo.getTradeName()), MmpNatdssB101InpatientOrder::getTradeName, bo.getTradeName());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB101InpatientOrder::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB101InpatientOrder::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB101InpatientOrder::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB101InpatientOrder::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB101InpatientOrder::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B10-1 住院医嘱记录
     *
     * @param bo B10-1 住院医嘱记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB101InpatientOrderBo bo) {
        MmpNatdssB101InpatientOrder add = MapstructUtils.convert(bo, MmpNatdssB101InpatientOrder.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B10-1 住院医嘱记录
     *
     * @param bo B10-1 住院医嘱记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB101InpatientOrderBo bo) {
        MmpNatdssB101InpatientOrder update = MapstructUtils.convert(bo, MmpNatdssB101InpatientOrder.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB101InpatientOrder entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B10-1 住院医嘱记录信息
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
