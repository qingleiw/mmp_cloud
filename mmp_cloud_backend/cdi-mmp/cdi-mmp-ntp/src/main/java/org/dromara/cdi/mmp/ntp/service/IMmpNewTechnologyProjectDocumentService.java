package org.dromara.cdi.mmp.ntp.service;

import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectDocumentVo;
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectDocumentBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 项目文档Service接口
 *
 * @author Lion Li
 * @date 2026-01-07
 */
public interface IMmpNewTechnologyProjectDocumentService {

    /**
     * 查询项目文档
     *
     * @param id 主键
     * @return 项目文档
     */
    MmpNewTechnologyProjectDocumentVo queryById(Long id);

    /**
     * 分页查询项目文档列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 项目文档分页列表
     */
    TableDataInfo<MmpNewTechnologyProjectDocumentVo> queryPageList(MmpNewTechnologyProjectDocumentBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的项目文档列表
     *
     * @param bo 查询条件
     * @return 项目文档列表
     */
    List<MmpNewTechnologyProjectDocumentVo> queryList(MmpNewTechnologyProjectDocumentBo bo);

    /**
     * 新增项目文档
     *
     * @param bo 项目文档
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNewTechnologyProjectDocumentBo bo);

    /**
     * 修改项目文档
     *
     * @param bo 项目文档
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNewTechnologyProjectDocumentBo bo);

    /**
     * 校验并批量删除项目文档信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
