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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB011DrugPurchaseBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB011DrugPurchaseVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB011DrugPurchase;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB011DrugPurchaseMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB011DrugPurchaseService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B01-1 抗肿瘤药物采购记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB011DrugPurchaseServiceImpl implements IMmpNatdssB011DrugPurchaseService {

    private final MmpNatdssB011DrugPurchaseMapper baseMapper;

    /**
     * 查询B01-1 抗肿瘤药物采购记录
     *
     * @param id 主键
     * @return B01-1 抗肿瘤药物采购记录
     */
    @Override
    public MmpNatdssB011DrugPurchaseVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B01-1 抗肿瘤药物采购记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B01-1 抗肿瘤药物采购记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB011DrugPurchaseVo> queryPageList(MmpNatdssB011DrugPurchaseBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB011DrugPurchase> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB011DrugPurchaseVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B01-1 抗肿瘤药物采购记录列表
     *
     * @param bo 查询条件
     * @return B01-1 抗肿瘤药物采购记录列表
     */
    @Override
    public List<MmpNatdssB011DrugPurchaseVo> queryList(MmpNatdssB011DrugPurchaseBo bo) {
        LambdaQueryWrapper<MmpNatdssB011DrugPurchase> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB011DrugPurchase> buildQueryWrapper(MmpNatdssB011DrugPurchaseBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB011DrugPurchase> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB011DrugPurchase::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPurSn()), MmpNatdssB011DrugPurchase::getPurSn, bo.getPurSn());
        lqw.eq(StringUtils.isNotBlank(bo.getHosDrugCode()), MmpNatdssB011DrugPurchase::getHosDrugCode, bo.getHosDrugCode());
        lqw.like(StringUtils.isNotBlank(bo.getGenericName()), MmpNatdssB011DrugPurchase::getGenericName, bo.getGenericName());
        lqw.like(StringUtils.isNotBlank(bo.getTradeName()), MmpNatdssB011DrugPurchase::getTradeName, bo.getTradeName());
        lqw.eq(StringUtils.isNotBlank(bo.getManufac()), MmpNatdssB011DrugPurchase::getManufac, bo.getManufac());
        lqw.eq(StringUtils.isNotBlank(bo.getApprovalNo()), MmpNatdssB011DrugPurchase::getApprovalNo, bo.getApprovalNo());
        lqw.eq(StringUtils.isNotBlank(bo.getForm()), MmpNatdssB011DrugPurchase::getForm, bo.getForm());
        lqw.eq(StringUtils.isNotBlank(bo.getSpec()), MmpNatdssB011DrugPurchase::getSpec, bo.getSpec());
        lqw.eq(StringUtils.isNotBlank(bo.getPackingQuantity()), MmpNatdssB011DrugPurchase::getPackingQuantity, bo.getPackingQuantity());
        lqw.eq(StringUtils.isNotBlank(bo.getPackingUnit()), MmpNatdssB011DrugPurchase::getPackingUnit, bo.getPackingUnit());
        lqw.eq(bo.getPurUnitPrice() != null, MmpNatdssB011DrugPurchase::getPurUnitPrice, bo.getPurUnitPrice());
        lqw.eq(bo.getPurQuantity() != null, MmpNatdssB011DrugPurchase::getPurQuantity, bo.getPurQuantity());
        lqw.eq(bo.getPurTotalPrice() != null, MmpNatdssB011DrugPurchase::getPurTotalPrice, bo.getPurTotalPrice());
        lqw.eq(bo.getPurDate() != null, MmpNatdssB011DrugPurchase::getPurDate, bo.getPurDate());
        lqw.eq(StringUtils.isNotBlank(bo.getInsuranceType()), MmpNatdssB011DrugPurchase::getInsuranceType, bo.getInsuranceType());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB011DrugPurchase::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB011DrugPurchase::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B01-1 抗肿瘤药物采购记录
     *
     * @param bo B01-1 抗肿瘤药物采购记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB011DrugPurchaseBo bo) {
        MmpNatdssB011DrugPurchase add = MapstructUtils.convert(bo, MmpNatdssB011DrugPurchase.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B01-1 抗肿瘤药物采购记录
     *
     * @param bo B01-1 抗肿瘤药物采购记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB011DrugPurchaseBo bo) {
        MmpNatdssB011DrugPurchase update = MapstructUtils.convert(bo, MmpNatdssB011DrugPurchase.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB011DrugPurchase entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B01-1 抗肿瘤药物采购记录信息
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
