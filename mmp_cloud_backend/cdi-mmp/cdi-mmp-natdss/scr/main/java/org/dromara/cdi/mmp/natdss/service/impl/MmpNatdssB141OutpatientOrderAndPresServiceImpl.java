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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB141OutpatientOrderAndPresBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB141OutpatientOrderAndPresVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB141OutpatientOrderAndPres;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB141OutpatientOrderAndPresMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB141OutpatientOrderAndPresService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B14-1 门诊医嘱处方记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB141OutpatientOrderAndPresServiceImpl implements IMmpNatdssB141OutpatientOrderAndPresService {

    private final MmpNatdssB141OutpatientOrderAndPresMapper baseMapper;

    /**
     * 查询B14-1 门诊医嘱处方记录
     *
     * @param id 主键
     * @return B14-1 门诊医嘱处方记录
     */
    @Override
    public MmpNatdssB141OutpatientOrderAndPresVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B14-1 门诊医嘱处方记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B14-1 门诊医嘱处方记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB141OutpatientOrderAndPresVo> queryPageList(MmpNatdssB141OutpatientOrderAndPresBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB141OutpatientOrderAndPres> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB141OutpatientOrderAndPresVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B14-1 门诊医嘱处方记录列表
     *
     * @param bo 查询条件
     * @return B14-1 门诊医嘱处方记录列表
     */
    @Override
    public List<MmpNatdssB141OutpatientOrderAndPresVo> queryList(MmpNatdssB141OutpatientOrderAndPresBo bo) {
        LambdaQueryWrapper<MmpNatdssB141OutpatientOrderAndPres> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB141OutpatientOrderAndPres> buildQueryWrapper(MmpNatdssB141OutpatientOrderAndPresBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB141OutpatientOrderAndPres> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB141OutpatientOrderAndPres::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB141OutpatientOrderAndPres::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB141OutpatientOrderAndPres::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB141OutpatientOrderAndPres::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB141OutpatientOrderAndPres::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB141OutpatientOrderAndPres::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB141OutpatientOrderAndPres::getVisitTimes, bo.getVisitTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), MmpNatdssB141OutpatientOrderAndPres::getOrderSn, bo.getOrderSn());
        lqw.eq(StringUtils.isNotBlank(bo.getRequestNo()), MmpNatdssB141OutpatientOrderAndPres::getRequestNo, bo.getRequestNo());
        lqw.eq(bo.getOrderGivenTime() != null, MmpNatdssB141OutpatientOrderAndPres::getOrderGivenTime, bo.getOrderGivenTime());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitDeptCode()), MmpNatdssB141OutpatientOrderAndPres::getVisitDeptCode, bo.getVisitDeptCode());
        lqw.like(StringUtils.isNotBlank(bo.getVisitDeptName()), MmpNatdssB141OutpatientOrderAndPres::getVisitDeptName, bo.getVisitDeptName());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderDeptCode()), MmpNatdssB141OutpatientOrderAndPres::getOrderDeptCode, bo.getOrderDeptCode());
        lqw.like(StringUtils.isNotBlank(bo.getOrderDeptName()), MmpNatdssB141OutpatientOrderAndPres::getOrderDeptName, bo.getOrderDeptName());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderDoctorNo()), MmpNatdssB141OutpatientOrderAndPres::getOrderDoctorNo, bo.getOrderDoctorNo());
        lqw.eq(StringUtils.isNotBlank(bo.getTechnicalTitle()), MmpNatdssB141OutpatientOrderAndPres::getTechnicalTitle, bo.getTechnicalTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getJobTitle()), MmpNatdssB141OutpatientOrderAndPres::getJobTitle, bo.getJobTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getExecutiveDeptCode()), MmpNatdssB141OutpatientOrderAndPres::getExecutiveDeptCode, bo.getExecutiveDeptCode());
        lqw.like(StringUtils.isNotBlank(bo.getExecutiveDeptName()), MmpNatdssB141OutpatientOrderAndPres::getExecutiveDeptName, bo.getExecutiveDeptName());
        lqw.eq(StringUtils.isNotBlank(bo.getPrescriptionClassCode()), MmpNatdssB141OutpatientOrderAndPres::getPrescriptionClassCode, bo.getPrescriptionClassCode());
        lqw.like(StringUtils.isNotBlank(bo.getPrescriptionClassName()), MmpNatdssB141OutpatientOrderAndPres::getPrescriptionClassName, bo.getPrescriptionClassName());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderClassCode()), MmpNatdssB141OutpatientOrderAndPres::getOrderClassCode, bo.getOrderClassCode());
        lqw.like(StringUtils.isNotBlank(bo.getOrderClassName()), MmpNatdssB141OutpatientOrderAndPres::getOrderClassName, bo.getOrderClassName());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderItemCode()), MmpNatdssB141OutpatientOrderAndPres::getOrderItemCode, bo.getOrderItemCode());
        lqw.like(StringUtils.isNotBlank(bo.getOrderItemName()), MmpNatdssB141OutpatientOrderAndPres::getOrderItemName, bo.getOrderItemName());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderGroupNo()), MmpNatdssB141OutpatientOrderAndPres::getOrderGroupNo, bo.getOrderGroupNo());
        lqw.eq(bo.getDose() != null, MmpNatdssB141OutpatientOrderAndPres::getDose, bo.getDose());
        lqw.eq(StringUtils.isNotBlank(bo.getDoseUnit()), MmpNatdssB141OutpatientOrderAndPres::getDoseUnit, bo.getDoseUnit());
        lqw.eq(StringUtils.isNotBlank(bo.getForm()), MmpNatdssB141OutpatientOrderAndPres::getForm, bo.getForm());
        lqw.eq(StringUtils.isNotBlank(bo.getSpec()), MmpNatdssB141OutpatientOrderAndPres::getSpec, bo.getSpec());
        lqw.eq(StringUtils.isNotBlank(bo.getFrequencyCode()), MmpNatdssB141OutpatientOrderAndPres::getFrequencyCode, bo.getFrequencyCode());
        lqw.eq(StringUtils.isNotBlank(bo.getFrequency()), MmpNatdssB141OutpatientOrderAndPres::getFrequency, bo.getFrequency());
        lqw.eq(StringUtils.isNotBlank(bo.getAdministrationRoute()), MmpNatdssB141OutpatientOrderAndPres::getAdministrationRoute, bo.getAdministrationRoute());
        lqw.eq(StringUtils.isNotBlank(bo.getLiquidConfiguration()), MmpNatdssB141OutpatientOrderAndPres::getLiquidConfiguration, bo.getLiquidConfiguration());
        lqw.eq(StringUtils.isNotBlank(bo.getInjectionType()), MmpNatdssB141OutpatientOrderAndPres::getInjectionType, bo.getInjectionType());
        lqw.eq(StringUtils.isNotBlank(bo.getDrugOrder()), MmpNatdssB141OutpatientOrderAndPres::getDrugOrder, bo.getDrugOrder());
        lqw.eq(StringUtils.isNotBlank(bo.getDrugCompatibility()), MmpNatdssB141OutpatientOrderAndPres::getDrugCompatibility, bo.getDrugCompatibility());
        lqw.eq(StringUtils.isNotBlank(bo.getInfusionDuration()), MmpNatdssB141OutpatientOrderAndPres::getInfusionDuration, bo.getInfusionDuration());
        lqw.eq(bo.getDaysOfMedication() != null, MmpNatdssB141OutpatientOrderAndPres::getDaysOfMedication, bo.getDaysOfMedication());
        lqw.eq(bo.getTotalDose() != null, MmpNatdssB141OutpatientOrderAndPres::getTotalDose, bo.getTotalDose());
        lqw.eq(StringUtils.isNotBlank(bo.getTotalDoseUnit()), MmpNatdssB141OutpatientOrderAndPres::getTotalDoseUnit, bo.getTotalDoseUnit());
        lqw.eq(StringUtils.isNotBlank(bo.getNumOfOrders()), MmpNatdssB141OutpatientOrderAndPres::getNumOfOrders, bo.getNumOfOrders());
        lqw.eq(StringUtils.isNotBlank(bo.getNumOfOrdersUnit()), MmpNatdssB141OutpatientOrderAndPres::getNumOfOrdersUnit, bo.getNumOfOrdersUnit());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderNote()), MmpNatdssB141OutpatientOrderAndPres::getOrderNote, bo.getOrderNote());
        lqw.eq(StringUtils.isNotBlank(bo.getHerbalNote()), MmpNatdssB141OutpatientOrderAndPres::getHerbalNote, bo.getHerbalNote());
        lqw.eq(StringUtils.isNotBlank(bo.getDrugFlag()), MmpNatdssB141OutpatientOrderAndPres::getDrugFlag, bo.getDrugFlag());
        lqw.eq(StringUtils.isNotBlank(bo.getManufac()), MmpNatdssB141OutpatientOrderAndPres::getManufac, bo.getManufac());
        lqw.like(StringUtils.isNotBlank(bo.getTradeName()), MmpNatdssB141OutpatientOrderAndPres::getTradeName, bo.getTradeName());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB141OutpatientOrderAndPres::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB141OutpatientOrderAndPres::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB141OutpatientOrderAndPres::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB141OutpatientOrderAndPres::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB141OutpatientOrderAndPres::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B14-1 门诊医嘱处方记录
     *
     * @param bo B14-1 门诊医嘱处方记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB141OutpatientOrderAndPresBo bo) {
        MmpNatdssB141OutpatientOrderAndPres add = MapstructUtils.convert(bo, MmpNatdssB141OutpatientOrderAndPres.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B14-1 门诊医嘱处方记录
     *
     * @param bo B14-1 门诊医嘱处方记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB141OutpatientOrderAndPresBo bo) {
        MmpNatdssB141OutpatientOrderAndPres update = MapstructUtils.convert(bo, MmpNatdssB141OutpatientOrderAndPres.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB141OutpatientOrderAndPres entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B14-1 门诊医嘱处方记录信息
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
