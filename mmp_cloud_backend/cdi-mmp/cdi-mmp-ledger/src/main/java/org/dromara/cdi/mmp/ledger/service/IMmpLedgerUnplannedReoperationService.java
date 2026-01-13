package org.dromara.cdi.mmp.ledger.service;

import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerUnplannedReoperationVo;
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerUnplannedReoperationBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 非计划再次手术登记本Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpLedgerUnplannedReoperationService {

    /**
     * 查询非计划再次手术登记本
     *
     * @param id 主键
     * @return 非计划再次手术登记本
     */
    MmpLedgerUnplannedReoperationVo queryById(Long id);

    /**
     * 分页查询非计划再次手术登记本列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 非计划再次手术登记本分页列表
     */
    TableDataInfo<MmpLedgerUnplannedReoperationVo> queryPageList(MmpLedgerUnplannedReoperationBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的非计划再次手术登记本列表
     *
     * @param bo 查询条件
     * @return 非计划再次手术登记本列表
     */
    List<MmpLedgerUnplannedReoperationVo> queryList(MmpLedgerUnplannedReoperationBo bo);

    /**
     * 新增非计划再次手术登记本
     *
     * @param bo 非计划再次手术登记本
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpLedgerUnplannedReoperationBo bo);

    /**
     * 修改非计划再次手术登记本
     *
     * @param bo 非计划再次手术登记本
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpLedgerUnplannedReoperationBo bo);

    /**
     * 校验并批量删除非计划再次手术登记本信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
