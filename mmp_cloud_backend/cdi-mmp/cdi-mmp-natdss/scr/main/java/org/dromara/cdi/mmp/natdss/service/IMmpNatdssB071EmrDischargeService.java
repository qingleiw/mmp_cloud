package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB071EmrDischarge;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB071EmrDischargeVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB071EmrDischargeBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B07-1 出院记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB071EmrDischargeService {

    /**
     * 查询B07-1 出院记录
     *
     * @param id 主键
     * @return B07-1 出院记录
     */
    MmpNatdssB071EmrDischargeVo queryById(Long id);

    /**
     * 分页查询B07-1 出院记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B07-1 出院记录分页列表
     */
    TableDataInfo<MmpNatdssB071EmrDischargeVo> queryPageList(MmpNatdssB071EmrDischargeBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B07-1 出院记录列表
     *
     * @param bo 查询条件
     * @return B07-1 出院记录列表
     */
    List<MmpNatdssB071EmrDischargeVo> queryList(MmpNatdssB071EmrDischargeBo bo);

    /**
     * 新增B07-1 出院记录
     *
     * @param bo B07-1 出院记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB071EmrDischargeBo bo);

    /**
     * 修改B07-1 出院记录
     *
     * @param bo B07-1 出院记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB071EmrDischargeBo bo);

    /**
     * 校验并批量删除B07-1 出院记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
