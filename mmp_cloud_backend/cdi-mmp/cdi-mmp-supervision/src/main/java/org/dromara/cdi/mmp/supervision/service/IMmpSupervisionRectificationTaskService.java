package org.dromara.cdi.mmp.supervision.service;

import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionRectificationTaskVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionRectificationTaskBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 整改任务Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpSupervisionRectificationTaskService {

    /**
     * 查询整改任务
     *
     * @param id 主键
     * @return 整改任务
     */
    MmpSupervisionRectificationTaskVo queryById(Long id);

    /**
     * 分页查询整改任务列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 整改任务分页列表
     */
    TableDataInfo<MmpSupervisionRectificationTaskVo> queryPageList(MmpSupervisionRectificationTaskBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的整改任务列表
     *
     * @param bo 查询条件
     * @return 整改任务列表
     */
    List<MmpSupervisionRectificationTaskVo> queryList(MmpSupervisionRectificationTaskBo bo);

    /**
     * 新增整改任务
     *
     * @param bo 整改任务
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSupervisionRectificationTaskBo bo);

    /**
     * 修改整改任务
     *
     * @param bo 整改任务
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSupervisionRectificationTaskBo bo);

    /**
     * 校验并批量删除整改任务信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
