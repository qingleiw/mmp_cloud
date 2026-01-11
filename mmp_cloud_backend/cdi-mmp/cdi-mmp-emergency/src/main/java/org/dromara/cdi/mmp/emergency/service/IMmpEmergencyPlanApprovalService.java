package org.dromara.cdi.mmp.emergency.service;

import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyPlanApprovalVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyPlanApprovalBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 应急预案审批Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpEmergencyPlanApprovalService {

    /**
     * 查询应急预案审批
     *
     * @param id 主键
     * @return 应急预案审批
     */
    MmpEmergencyPlanApprovalVo queryById(Long id);

    /**
     * 分页查询应急预案审批列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 应急预案审批分页列表
     */
    TableDataInfo<MmpEmergencyPlanApprovalVo> queryPageList(MmpEmergencyPlanApprovalBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的应急预案审批列表
     *
     * @param bo 查询条件
     * @return 应急预案审批列表
     */
    List<MmpEmergencyPlanApprovalVo> queryList(MmpEmergencyPlanApprovalBo bo);

    /**
     * 新增应急预案审批
     *
     * @param bo 应急预案审批
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpEmergencyPlanApprovalBo bo);

    /**
     * 修改应急预案审批
     *
     * @param bo 应急预案审批
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpEmergencyPlanApprovalBo bo);

    /**
     * 校验并批量删除应急预案审批信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
