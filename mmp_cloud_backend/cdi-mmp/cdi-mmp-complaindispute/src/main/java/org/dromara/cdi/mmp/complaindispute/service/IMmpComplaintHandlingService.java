package org.dromara.cdi.mmp.complaindispute.service;

import org.dromara.cdi.mmp.complaindispute.domain.vo.MmpComplaintHandlingVo;
import org.dromara.cdi.mmp.complaindispute.domain.bo.MmpComplaintHandlingBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 投诉处理记录Service接口
 *
 * @author Lion Li
 * @date 2025-12-26
 */
public interface IMmpComplaintHandlingService {

    /**
     * 查询投诉处理记录
     *
     * @param id 主键
     * @return 投诉处理记录
     */
    MmpComplaintHandlingVo queryById(Long id);

    /**
     * 分页查询投诉处理记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 投诉处理记录分页列表
     */
    TableDataInfo<MmpComplaintHandlingVo> queryPageList(MmpComplaintHandlingBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的投诉处理记录列表
     *
     * @param bo 查询条件
     * @return 投诉处理记录列表
     */
    List<MmpComplaintHandlingVo> queryList(MmpComplaintHandlingBo bo);

    /**
     * 新增投诉处理记录
     *
     * @param bo 投诉处理记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpComplaintHandlingBo bo);

    /**
     * 修改投诉处理记录
     *
     * @param bo 投诉处理记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpComplaintHandlingBo bo);

    /**
     * 校验并批量删除投诉处理记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
