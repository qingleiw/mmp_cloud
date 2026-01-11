package org.dromara.cdi.mmp.ntp.service;

import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectImplementationVo;
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectImplementationBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 新技术实施Service接口
 *
 * @author Lion Li
 * @date 2026-01-07
 */
public interface IMmpNewTechnologyProjectImplementationService {

    /**
     * 查询新技术实施
     *
     * @param id 主键
     * @return 新技术实施
     */
    MmpNewTechnologyProjectImplementationVo queryById(Long id);

    /**
     * 分页查询新技术实施列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 新技术实施分页列表
     */
    TableDataInfo<MmpNewTechnologyProjectImplementationVo> queryPageList(MmpNewTechnologyProjectImplementationBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的新技术实施列表
     *
     * @param bo 查询条件
     * @return 新技术实施列表
     */
    List<MmpNewTechnologyProjectImplementationVo> queryList(MmpNewTechnologyProjectImplementationBo bo);

    /**
     * 新增新技术实施
     *
     * @param bo 新技术实施
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNewTechnologyProjectImplementationBo bo);

    /**
     * 修改新技术实施
     *
     * @param bo 新技术实施
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNewTechnologyProjectImplementationBo bo);

    /**
     * 校验并批量删除新技术实施信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
