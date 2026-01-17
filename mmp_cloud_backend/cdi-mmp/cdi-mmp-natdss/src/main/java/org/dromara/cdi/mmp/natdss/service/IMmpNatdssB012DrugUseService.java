package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB012DrugUse;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB012DrugUseVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB012DrugUseBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B01-2 抗肿瘤药物使用记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB012DrugUseService {

    /**
     * 查询B01-2 抗肿瘤药物使用记录
     *
     * @param id 主键
     * @return B01-2 抗肿瘤药物使用记录
     */
    MmpNatdssB012DrugUseVo queryById(Long id);

    /**
     * 分页查询B01-2 抗肿瘤药物使用记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B01-2 抗肿瘤药物使用记录分页列表
     */
    TableDataInfo<MmpNatdssB012DrugUseVo> queryPageList(MmpNatdssB012DrugUseBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B01-2 抗肿瘤药物使用记录列表
     *
     * @param bo 查询条件
     * @return B01-2 抗肿瘤药物使用记录列表
     */
    List<MmpNatdssB012DrugUseVo> queryList(MmpNatdssB012DrugUseBo bo);

    /**
     * 新增B01-2 抗肿瘤药物使用记录
     *
     * @param bo B01-2 抗肿瘤药物使用记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB012DrugUseBo bo);

    /**
     * 修改B01-2 抗肿瘤药物使用记录
     *
     * @param bo B01-2 抗肿瘤药物使用记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB012DrugUseBo bo);

    /**
     * 校验并批量删除B01-2 抗肿瘤药物使用记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
