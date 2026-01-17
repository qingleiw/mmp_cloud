package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB141OutpatientOrderAndPres;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB141OutpatientOrderAndPresVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB141OutpatientOrderAndPresBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B14-1 门诊医嘱处方记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB141OutpatientOrderAndPresService {

    /**
     * 查询B14-1 门诊医嘱处方记录
     *
     * @param id 主键
     * @return B14-1 门诊医嘱处方记录
     */
    MmpNatdssB141OutpatientOrderAndPresVo queryById(Long id);

    /**
     * 分页查询B14-1 门诊医嘱处方记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B14-1 门诊医嘱处方记录分页列表
     */
    TableDataInfo<MmpNatdssB141OutpatientOrderAndPresVo> queryPageList(MmpNatdssB141OutpatientOrderAndPresBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B14-1 门诊医嘱处方记录列表
     *
     * @param bo 查询条件
     * @return B14-1 门诊医嘱处方记录列表
     */
    List<MmpNatdssB141OutpatientOrderAndPresVo> queryList(MmpNatdssB141OutpatientOrderAndPresBo bo);

    /**
     * 新增B14-1 门诊医嘱处方记录
     *
     * @param bo B14-1 门诊医嘱处方记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB141OutpatientOrderAndPresBo bo);

    /**
     * 修改B14-1 门诊医嘱处方记录
     *
     * @param bo B14-1 门诊医嘱处方记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB141OutpatientOrderAndPresBo bo);

    /**
     * 校验并批量删除B14-1 门诊医嘱处方记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
