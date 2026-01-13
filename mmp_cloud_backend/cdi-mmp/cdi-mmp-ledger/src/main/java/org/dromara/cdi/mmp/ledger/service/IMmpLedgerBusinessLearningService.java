package org.dromara.cdi.mmp.ledger.service;

import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerBusinessLearningVo;
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerBusinessLearningBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 业务学习记录本Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpLedgerBusinessLearningService {

    /**
     * 查询业务学习记录本
     *
     * @param id 主键
     * @return 业务学习记录本
     */
    MmpLedgerBusinessLearningVo queryById(Long id);

    /**
     * 分页查询业务学习记录本列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 业务学习记录本分页列表
     */
    TableDataInfo<MmpLedgerBusinessLearningVo> queryPageList(MmpLedgerBusinessLearningBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的业务学习记录本列表
     *
     * @param bo 查询条件
     * @return 业务学习记录本列表
     */
    List<MmpLedgerBusinessLearningVo> queryList(MmpLedgerBusinessLearningBo bo);

    /**
     * 新增业务学习记录本
     *
     * @param bo 业务学习记录本
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpLedgerBusinessLearningBo bo);

    /**
     * 修改业务学习记录本
     *
     * @param bo 业务学习记录本
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpLedgerBusinessLearningBo bo);

    /**
     * 校验并批量删除业务学习记录本信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
