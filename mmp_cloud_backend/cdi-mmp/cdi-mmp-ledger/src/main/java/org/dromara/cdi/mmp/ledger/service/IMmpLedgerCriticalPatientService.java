package org.dromara.cdi.mmp.ledger.service;

import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerCriticalPatientVo;
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerCriticalPatientBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 危重病人抢救登记本Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpLedgerCriticalPatientService {

    /**
     * 查询危重病人抢救登记本
     *
     * @param id 主键
     * @return 危重病人抢救登记本
     */
    MmpLedgerCriticalPatientVo queryById(Long id);

    /**
     * 分页查询危重病人抢救登记本列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 危重病人抢救登记本分页列表
     */
    TableDataInfo<MmpLedgerCriticalPatientVo> queryPageList(MmpLedgerCriticalPatientBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的危重病人抢救登记本列表
     *
     * @param bo 查询条件
     * @return 危重病人抢救登记本列表
     */
    List<MmpLedgerCriticalPatientVo> queryList(MmpLedgerCriticalPatientBo bo);

    /**
     * 新增危重病人抢救登记本
     *
     * @param bo 危重病人抢救登记本
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpLedgerCriticalPatientBo bo);

    /**
     * 修改危重病人抢救登记本
     *
     * @param bo 危重病人抢救登记本
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpLedgerCriticalPatientBo bo);

    /**
     * 校验并批量删除危重病人抢救登记本信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
