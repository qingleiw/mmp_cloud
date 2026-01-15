package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB191FollowUp;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB191FollowUpVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB191FollowUpBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B19-1 随访记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB191FollowUpService {

    /**
     * 查询B19-1 随访记录
     *
     * @param id 主键
     * @return B19-1 随访记录
     */
    MmpNatdssB191FollowUpVo queryById(Long id);

    /**
     * 分页查询B19-1 随访记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B19-1 随访记录分页列表
     */
    TableDataInfo<MmpNatdssB191FollowUpVo> queryPageList(MmpNatdssB191FollowUpBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B19-1 随访记录列表
     *
     * @param bo 查询条件
     * @return B19-1 随访记录列表
     */
    List<MmpNatdssB191FollowUpVo> queryList(MmpNatdssB191FollowUpBo bo);

    /**
     * 新增B19-1 随访记录
     *
     * @param bo B19-1 随访记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB191FollowUpBo bo);

    /**
     * 修改B19-1 随访记录
     *
     * @param bo B19-1 随访记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB191FollowUpBo bo);

    /**
     * 校验并批量删除B19-1 随访记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
