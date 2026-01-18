package org.dromara.cdi.mmp.complaintdispute.service;

import org.dromara.cdi.mmp.complaintdispute.domain.vo.MmpComplaintInvestigationVo;
import org.dromara.cdi.mmp.complaintdispute.domain.bo.MmpComplaintInvestigationBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 投诉调查记录Service接口
 *
 * @author Lion Li
 * @date 2025-12-26
 */
public interface IMmpComplaintInvestigationService {

    /**
     * 查询投诉调查记录
     *
     * @param id 主键
     * @return 投诉调查记录
     */
    MmpComplaintInvestigationVo queryById(Long id);

    /**
     * 分页查询投诉调查记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 投诉调查记录分页列表
     */
    TableDataInfo<MmpComplaintInvestigationVo> queryPageList(MmpComplaintInvestigationBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的投诉调查记录列表
     *
     * @param bo 查询条件
     * @return 投诉调查记录列表
     */
    List<MmpComplaintInvestigationVo> queryList(MmpComplaintInvestigationBo bo);

    /**
     * 新增投诉调查记录
     *
     * @param bo 投诉调查记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpComplaintInvestigationBo bo);

    /**
     * 修改投诉调查记录
     *
     * @param bo 投诉调查记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpComplaintInvestigationBo bo);

    /**
     * 校验并批量删除投诉调查记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
