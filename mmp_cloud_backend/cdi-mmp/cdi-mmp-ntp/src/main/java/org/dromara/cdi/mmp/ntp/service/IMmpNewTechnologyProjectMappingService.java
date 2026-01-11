package org.dromara.cdi.mmp.ntp.service;

import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectMappingVo;
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectMappingBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 新技术项目对码Service接口
 *
 * @author Lion Li
 * @date 2026-01-07
 */
public interface IMmpNewTechnologyProjectMappingService {

    /**
     * 查询新技术项目对码
     *
     * @param id 主键
     * @return 新技术项目对码
     */
    MmpNewTechnologyProjectMappingVo queryById(Long id);

    /**
     * 分页查询新技术项目对码列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 新技术项目对码分页列表
     */
    TableDataInfo<MmpNewTechnologyProjectMappingVo> queryPageList(MmpNewTechnologyProjectMappingBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的新技术项目对码列表
     *
     * @param bo 查询条件
     * @return 新技术项目对码列表
     */
    List<MmpNewTechnologyProjectMappingVo> queryList(MmpNewTechnologyProjectMappingBo bo);

    /**
     * 新增新技术项目对码
     *
     * @param bo 新技术项目对码
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNewTechnologyProjectMappingBo bo);

    /**
     * 修改新技术项目对码
     *
     * @param bo 新技术项目对码
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNewTechnologyProjectMappingBo bo);

    /**
     * 校验并批量删除新技术项目对码信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
