package org.dromara.cdi.mmp.ledger.service;

import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerPatientFullCycleVo;
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerPatientFullCycleBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 患者医疗全周期信息管理Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpLedgerPatientFullCycleService {

    /**
     * 查询患者医疗全周期信息管理
     *
     * @param id 主键
     * @return 患者医疗全周期信息管理
     */
    MmpLedgerPatientFullCycleVo queryById(Long id);

    /**
     * 分页查询患者医疗全周期信息管理列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 患者医疗全周期信息管理分页列表
     */
    TableDataInfo<MmpLedgerPatientFullCycleVo> queryPageList(MmpLedgerPatientFullCycleBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的患者医疗全周期信息管理列表
     *
     * @param bo 查询条件
     * @return 患者医疗全周期信息管理列表
     */
    List<MmpLedgerPatientFullCycleVo> queryList(MmpLedgerPatientFullCycleBo bo);

    /**
     * 新增患者医疗全周期信息管理
     *
     * @param bo 患者医疗全周期信息管理
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpLedgerPatientFullCycleBo bo);

    /**
     * 修改患者医疗全周期信息管理
     *
     * @param bo 患者医疗全周期信息管理
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpLedgerPatientFullCycleBo bo);

    /**
     * 校验并批量删除患者医疗全周期信息管理信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
