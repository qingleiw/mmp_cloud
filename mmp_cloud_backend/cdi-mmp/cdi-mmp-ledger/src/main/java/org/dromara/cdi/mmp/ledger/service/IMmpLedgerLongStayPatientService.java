package org.dromara.cdi.mmp.ledger.service;

import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerLongStayPatientVo;
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerLongStayPatientBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 住院超30天患者登记本Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpLedgerLongStayPatientService {

    /**
     * 查询住院超30天患者登记本
     *
     * @param id 主键
     * @return 住院超30天患者登记本
     */
    MmpLedgerLongStayPatientVo queryById(Long id);

    /**
     * 分页查询住院超30天患者登记本列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 住院超30天患者登记本分页列表
     */
    TableDataInfo<MmpLedgerLongStayPatientVo> queryPageList(MmpLedgerLongStayPatientBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的住院超30天患者登记本列表
     *
     * @param bo 查询条件
     * @return 住院超30天患者登记本列表
     */
    List<MmpLedgerLongStayPatientVo> queryList(MmpLedgerLongStayPatientBo bo);

    /**
     * 新增住院超30天患者登记本
     *
     * @param bo 住院超30天患者登记本
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpLedgerLongStayPatientBo bo);

    /**
     * 修改住院超30天患者登记本
     *
     * @param bo 住院超30天患者登记本
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpLedgerLongStayPatientBo bo);

    /**
     * 校验并批量删除住院超30天患者登记本信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
