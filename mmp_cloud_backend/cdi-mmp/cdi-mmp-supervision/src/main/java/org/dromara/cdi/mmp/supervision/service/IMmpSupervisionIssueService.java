package org.dromara.cdi.mmp.supervision.service;

import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionIssueVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionIssueBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 督导问题Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpSupervisionIssueService {

    /**
     * 查询督导问题
     *
     * @param id 主键
     * @return 督导问题
     */
    MmpSupervisionIssueVo queryById(Long id);

    /**
     * 分页查询督导问题列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督导问题分页列表
     */
    TableDataInfo<MmpSupervisionIssueVo> queryPageList(MmpSupervisionIssueBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的督导问题列表
     *
     * @param bo 查询条件
     * @return 督导问题列表
     */
    List<MmpSupervisionIssueVo> queryList(MmpSupervisionIssueBo bo);

    /**
     * 新增督导问题
     *
     * @param bo 督导问题
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSupervisionIssueBo bo);

    /**
     * 修改督导问题
     *
     * @param bo 督导问题
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSupervisionIssueBo bo);

    /**
     * 校验并批量删除督导问题信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
