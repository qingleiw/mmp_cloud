package org.dromara.cdi.mmp.surgery.service;

import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryTeamVo;
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryTeamBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 手术团队Service接口
 *
 * @author Lion Li
 * @date 2025-12-28
 */
public interface IMmpSurgeryTeamService {

    /**
     * 查询手术团队
     *
     * @param id 主键
     * @return 手术团队
     */
    MmpSurgeryTeamVo queryById(Long id);

    /**
     * 分页查询手术团队列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 手术团队分页列表
     */
    TableDataInfo<MmpSurgeryTeamVo> queryPageList(MmpSurgeryTeamBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的手术团队列表
     *
     * @param bo 查询条件
     * @return 手术团队列表
     */
    List<MmpSurgeryTeamVo> queryList(MmpSurgeryTeamBo bo);

    /**
     * 新增手术团队
     *
     * @param bo 手术团队
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSurgeryTeamBo bo);

    /**
     * 修改手术团队
     *
     * @param bo 手术团队
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSurgeryTeamBo bo);

    /**
     * 校验并批量删除手术团队信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
