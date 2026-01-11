package org.dromara.cdi.mmp.ntp.service;

import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectProgressVo;
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectProgressBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 新技术进展报告Service接口
 *
 * @author Lion Li
 * @date 2026-01-07
 */
public interface IMmpNewTechnologyProjectProgressService {

    /**
     * 查询新技术进展报告
     *
     * @param id 主键
     * @return 新技术进展报告
     */
    MmpNewTechnologyProjectProgressVo queryById(Long id);

    /**
     * 分页查询新技术进展报告列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 新技术进展报告分页列表
     */
    TableDataInfo<MmpNewTechnologyProjectProgressVo> queryPageList(MmpNewTechnologyProjectProgressBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的新技术进展报告列表
     *
     * @param bo 查询条件
     * @return 新技术进展报告列表
     */
    List<MmpNewTechnologyProjectProgressVo> queryList(MmpNewTechnologyProjectProgressBo bo);

    /**
     * 新增新技术进展报告
     *
     * @param bo 新技术进展报告
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNewTechnologyProjectProgressBo bo);

    /**
     * 修改新技术进展报告
     *
     * @param bo 新技术进展报告
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNewTechnologyProjectProgressBo bo);

    /**
     * 校验并批量删除新技术进展报告信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
