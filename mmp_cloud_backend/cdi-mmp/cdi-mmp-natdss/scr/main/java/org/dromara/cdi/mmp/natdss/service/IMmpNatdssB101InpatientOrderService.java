package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB101InpatientOrder;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB101InpatientOrderVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB101InpatientOrderBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B10-1 住院医嘱记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB101InpatientOrderService {

    /**
     * 查询B10-1 住院医嘱记录
     *
     * @param id 主键
     * @return B10-1 住院医嘱记录
     */
    MmpNatdssB101InpatientOrderVo queryById(Long id);

    /**
     * 分页查询B10-1 住院医嘱记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B10-1 住院医嘱记录分页列表
     */
    TableDataInfo<MmpNatdssB101InpatientOrderVo> queryPageList(MmpNatdssB101InpatientOrderBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B10-1 住院医嘱记录列表
     *
     * @param bo 查询条件
     * @return B10-1 住院医嘱记录列表
     */
    List<MmpNatdssB101InpatientOrderVo> queryList(MmpNatdssB101InpatientOrderBo bo);

    /**
     * 新增B10-1 住院医嘱记录
     *
     * @param bo B10-1 住院医嘱记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB101InpatientOrderBo bo);

    /**
     * 修改B10-1 住院医嘱记录
     *
     * @param bo B10-1 住院医嘱记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB101InpatientOrderBo bo);

    /**
     * 校验并批量删除B10-1 住院医嘱记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
