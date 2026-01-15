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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB012DrugUseBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB012DrugUseVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB012DrugUse;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB012DrugUseMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB012DrugUseService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B01-2 抗肿瘤药物使用记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB012DrugUseServiceImpl implements IMmpNatdssB012DrugUseService {

    private final MmpNatdssB012DrugUseMapper baseMapper;

    /**
     * 查询B01-2 抗肿瘤药物使用记录
     *
     * @param id 主键
     * @return B01-2 抗肿瘤药物使用记录
     */
    @Override
    public MmpNatdssB012DrugUseVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B01-2 抗肿瘤药物使用记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B01-2 抗肿瘤药物使用记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB012DrugUseVo> queryPageList(MmpNatdssB012DrugUseBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB012DrugUse> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB012DrugUseVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B01-2 抗肿瘤药物使用记录列表
     *
     * @param bo 查询条件
     * @return B01-2 抗肿瘤药物使用记录列表
     */
    @Override
    public List<MmpNatdssB012DrugUseVo> queryList(MmpNatdssB012DrugUseBo bo) {
        LambdaQueryWrapper<MmpNatdssB012DrugUse> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB012DrugUse> buildQueryWrapper(MmpNatdssB012DrugUseBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB012DrugUse> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB012DrugUse::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPresSn()), MmpNatdssB012DrugUse::getPresSn, bo.getPresSn());
        lqw.eq(StringUtils.isNotBlank(bo.getHosDrugCode()), MmpNatdssB012DrugUse::getHosDrugCode, bo.getHosDrugCode());
        lqw.like(StringUtils.isNotBlank(bo.getGenericName()), MmpNatdssB012DrugUse::getGenericName, bo.getGenericName());
        lqw.like(StringUtils.isNotBlank(bo.getTradeName()), MmpNatdssB012DrugUse::getTradeName, bo.getTradeName());
        lqw.eq(StringUtils.isNotBlank(bo.getManufac()), MmpNatdssB012DrugUse::getManufac, bo.getManufac());
        lqw.eq(StringUtils.isNotBlank(bo.getApprovalNo()), MmpNatdssB012DrugUse::getApprovalNo, bo.getApprovalNo());
        lqw.eq(StringUtils.isNotBlank(bo.getForm()), MmpNatdssB012DrugUse::getForm, bo.getForm());
        lqw.eq(StringUtils.isNotBlank(bo.getSpec()), MmpNatdssB012DrugUse::getSpec, bo.getSpec());
        lqw.eq(StringUtils.isNotBlank(bo.getPackingQuantity()), MmpNatdssB012DrugUse::getPackingQuantity, bo.getPackingQuantity());
        lqw.eq(StringUtils.isNotBlank(bo.getPackingUnit()), MmpNatdssB012DrugUse::getPackingUnit, bo.getPackingUnit());
        lqw.eq(bo.getPresUnitPrice() != null, MmpNatdssB012DrugUse::getPresUnitPrice, bo.getPresUnitPrice());
        lqw.eq(bo.getPresQuantity() != null, MmpNatdssB012DrugUse::getPresQuantity, bo.getPresQuantity());
        lqw.eq(bo.getPresTotalPrice() != null, MmpNatdssB012DrugUse::getPresTotalPrice, bo.getPresTotalPrice());
        lqw.eq(StringUtils.isNotBlank(bo.getPresOrigin()), MmpNatdssB012DrugUse::getPresOrigin, bo.getPresOrigin());
        lqw.eq(bo.getPresDate() != null, MmpNatdssB012DrugUse::getPresDate, bo.getPresDate());
        lqw.eq(StringUtils.isNotBlank(bo.getInsuranceType()), MmpNatdssB012DrugUse::getInsuranceType, bo.getInsuranceType());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB012DrugUse::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB012DrugUse::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B01-2 抗肿瘤药物使用记录
     *
     * @param bo B01-2 抗肿瘤药物使用记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB012DrugUseBo bo) {
        MmpNatdssB012DrugUse add = MapstructUtils.convert(bo, MmpNatdssB012DrugUse.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B01-2 抗肿瘤药物使用记录
     *
     * @param bo B01-2 抗肿瘤药物使用记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB012DrugUseBo bo) {
        MmpNatdssB012DrugUse update = MapstructUtils.convert(bo, MmpNatdssB012DrugUse.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB012DrugUse entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B01-2 抗肿瘤药物使用记录信息
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
