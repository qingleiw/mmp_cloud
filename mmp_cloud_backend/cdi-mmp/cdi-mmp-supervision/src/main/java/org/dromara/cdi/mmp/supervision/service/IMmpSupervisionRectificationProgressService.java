package org.dromara.cdi.mmp.supervision.service;

import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionRectificationProgressVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionRectificationProgressBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 整改进度Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpSupervisionRectificationProgressService {

    /**
     * 查询整改进度
     *
     * @param id 主键
     * @return 整改进度
     */
    MmpSupervisionRectificationProgressVo queryById(Long id);

    /**
     * 分页查询整改进度列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 整改进度分页列表
     */
    TableDataInfo<MmpSupervisionRectificationProgressVo> queryPageList(MmpSupervisionRectificationProgressBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的整改进度列表
     *
     * @param bo 查询条件
     * @return 整改进度列表
     */
    List<MmpSupervisionRectificationProgressVo> queryList(MmpSupervisionRectificationProgressBo bo);

    /**
     * 新增整改进度
     *
     * @param bo 整改进度
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSupervisionRectificationProgressBo bo);

    /**
     * 修改整改进度
     *
     * @param bo 整改进度
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSupervisionRectificationProgressBo bo);

    /**
     * 校验并批量删除整改进度信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
