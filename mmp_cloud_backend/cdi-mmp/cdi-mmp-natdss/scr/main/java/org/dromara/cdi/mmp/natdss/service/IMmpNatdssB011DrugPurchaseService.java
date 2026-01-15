package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB011DrugPurchase;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB011DrugPurchaseVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB011DrugPurchaseBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B01-1 抗肿瘤药物采购记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB011DrugPurchaseService {

    /**
     * 查询B01-1 抗肿瘤药物采购记录
     *
     * @param id 主键
     * @return B01-1 抗肿瘤药物采购记录
     */
    MmpNatdssB011DrugPurchaseVo queryById(Long id);

    /**
     * 分页查询B01-1 抗肿瘤药物采购记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B01-1 抗肿瘤药物采购记录分页列表
     */
    TableDataInfo<MmpNatdssB011DrugPurchaseVo> queryPageList(MmpNatdssB011DrugPurchaseBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B01-1 抗肿瘤药物采购记录列表
     *
     * @param bo 查询条件
     * @return B01-1 抗肿瘤药物采购记录列表
     */
    List<MmpNatdssB011DrugPurchaseVo> queryList(MmpNatdssB011DrugPurchaseBo bo);

    /**
     * 新增B01-1 抗肿瘤药物采购记录
     *
     * @param bo B01-1 抗肿瘤药物采购记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB011DrugPurchaseBo bo);

    /**
     * 修改B01-1 抗肿瘤药物采购记录
     *
     * @param bo B01-1 抗肿瘤药物采购记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB011DrugPurchaseBo bo);

    /**
     * 校验并批量删除B01-1 抗肿瘤药物采购记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
