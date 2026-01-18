package org.dromara.cdi.mmp.complaintdispute.service;

import org.dromara.cdi.mmp.complaintdispute.domain.vo.MmpComplaintDisputeVo;
import org.dromara.cdi.mmp.complaintdispute.domain.bo.MmpComplaintDisputeBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 投诉纠纷主Service接口
 *
 * @author Lion Li
 * @date 2025-12-26
 */
public interface IMmpComplaintDisputeService {

    /**
     * 查询投诉纠纷主
     *
     * @param id 主键
     * @return 投诉纠纷主
     */
    MmpComplaintDisputeVo queryById(Long id);

    /**
     * 分页查询投诉纠纷主列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 投诉纠纷主分页列表
     */
    TableDataInfo<MmpComplaintDisputeVo> queryPageList(MmpComplaintDisputeBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的投诉纠纷主列表
     *
     * @param bo 查询条件
     * @return 投诉纠纷主列表
     */
    List<MmpComplaintDisputeVo> queryList(MmpComplaintDisputeBo bo);

    /**
     * 新增投诉纠纷主
     *
     * @param bo 投诉纠纷主
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpComplaintDisputeBo bo);

    /**
     * 修改投诉纠纷主
     *
     * @param bo 投诉纠纷主
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpComplaintDisputeBo bo);

    /**
     * 校验并批量删除投诉纠纷主信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
