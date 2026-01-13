package org.dromara.cdi.mmp.ledger.service;

import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerMajorSurgeryVo;
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerMajorSurgeryBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 重大疑难手术监测与管理Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpLedgerMajorSurgeryService {

    /**
     * 查询重大疑难手术监测与管理
     *
     * @param id 主键
     * @return 重大疑难手术监测与管理
     */
    MmpLedgerMajorSurgeryVo queryById(Long id);

    /**
     * 分页查询重大疑难手术监测与管理列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 重大疑难手术监测与管理分页列表
     */
    TableDataInfo<MmpLedgerMajorSurgeryVo> queryPageList(MmpLedgerMajorSurgeryBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的重大疑难手术监测与管理列表
     *
     * @param bo 查询条件
     * @return 重大疑难手术监测与管理列表
     */
    List<MmpLedgerMajorSurgeryVo> queryList(MmpLedgerMajorSurgeryBo bo);

    /**
     * 新增重大疑难手术监测与管理
     *
     * @param bo 重大疑难手术监测与管理
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpLedgerMajorSurgeryBo bo);

    /**
     * 修改重大疑难手术监测与管理
     *
     * @param bo 重大疑难手术监测与管理
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpLedgerMajorSurgeryBo bo);

    /**
     * 校验并批量删除重大疑难手术监测与管理信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
