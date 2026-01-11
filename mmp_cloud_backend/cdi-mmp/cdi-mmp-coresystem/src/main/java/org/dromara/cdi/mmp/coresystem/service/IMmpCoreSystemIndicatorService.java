package org.dromara.cdi.mmp.coresystem.service;

import org.dromara.cdi.mmp.coresystem.domain.vo.MmpCoreSystemIndicatorVo;
import org.dromara.cdi.mmp.coresystem.domain.bo.MmpCoreSystemIndicatorBo;


import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 核心制度指标Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpCoreSystemIndicatorService {

    /**
     * 查询核心制度指标
     *
     * @param id 主键
     * @return 核心制度指标
     */
    MmpCoreSystemIndicatorVo queryById(Long id);

    /**
     * 分页查询核心制度指标列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 核心制度指标分页列表
     */
    TableDataInfo<MmpCoreSystemIndicatorVo> queryPageList(MmpCoreSystemIndicatorBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的核心制度指标列表
     *
     * @param bo 查询条件
     * @return 核心制度指标列表
     */
    List<MmpCoreSystemIndicatorVo> queryList(MmpCoreSystemIndicatorBo bo);

    /**
     * 新增核心制度指标
     *
     * @param bo 核心制度指标
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpCoreSystemIndicatorBo bo);

    /**
     * 修改核心制度指标
     *
     * @param bo 核心制度指标
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpCoreSystemIndicatorBo bo);

    /**
     * 校验并批量删除核心制度指标信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
