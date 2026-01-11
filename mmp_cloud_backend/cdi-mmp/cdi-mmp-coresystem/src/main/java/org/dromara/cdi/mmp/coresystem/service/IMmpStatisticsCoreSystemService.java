package org.dromara.cdi.mmp.coresystem.service;

import org.dromara.cdi.mmp.coresystem.domain.vo.MmpStatisticsCoreSystemVo;
import org.dromara.cdi.mmp.coresystem.domain.bo.MmpStatisticsCoreSystemBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 核心制度落实情况监测Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpStatisticsCoreSystemService {

    /**
     * 查询核心制度落实情况监测
     *
     * @param id 主键
     * @return 核心制度落实情况监测
     */
    MmpStatisticsCoreSystemVo queryById(Long id);

    /**
     * 分页查询核心制度落实情况监测列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 核心制度落实情况监测分页列表
     */
    TableDataInfo<MmpStatisticsCoreSystemVo> queryPageList(MmpStatisticsCoreSystemBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的核心制度落实情况监测列表
     *
     * @param bo 查询条件
     * @return 核心制度落实情况监测列表
     */
    List<MmpStatisticsCoreSystemVo> queryList(MmpStatisticsCoreSystemBo bo);

    /**
     * 新增核心制度落实情况监测
     *
     * @param bo 核心制度落实情况监测
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpStatisticsCoreSystemBo bo);

    /**
     * 修改核心制度落实情况监测
     *
     * @param bo 核心制度落实情况监测
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpStatisticsCoreSystemBo bo);

    /**
     * 校验并批量删除核心制度落实情况监测信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
