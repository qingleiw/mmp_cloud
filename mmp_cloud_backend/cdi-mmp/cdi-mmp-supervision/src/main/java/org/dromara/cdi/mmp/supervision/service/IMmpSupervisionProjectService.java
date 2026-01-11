package org.dromara.cdi.mmp.supervision.service;

import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionProjectVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionProjectBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 督查项目Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpSupervisionProjectService {

    /**
     * 查询督查项目
     *
     * @param id 主键
     * @return 督查项目
     */
    MmpSupervisionProjectVo queryById(Long id);

    /**
     * 分页查询督查项目列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查项目分页列表
     */
    TableDataInfo<MmpSupervisionProjectVo> queryPageList(MmpSupervisionProjectBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的督查项目列表
     *
     * @param bo 查询条件
     * @return 督查项目列表
     */
    List<MmpSupervisionProjectVo> queryList(MmpSupervisionProjectBo bo);

    /**
     * 新增督查项目
     *
     * @param bo 督查项目
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSupervisionProjectBo bo);

    /**
     * 修改督查项目
     *
     * @param bo 督查项目
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSupervisionProjectBo bo);

    /**
     * 校验并批量删除督查项目信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
