package org.dromara.cdi.mmp.surgery.service;

import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryCatalogVo;
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryCatalogBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 手术目录Service接口
 *
 * @author Lion Li
 * @date 2026-01-02
 */
public interface IMmpSurgeryCatalogService {

    /**
     * 查询手术目录
     *
     * @param id 主键
     * @return 手术目录
     */
    MmpSurgeryCatalogVo queryById(Long id);

    /**
     * 分页查询手术目录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 手术目录分页列表
     */
    TableDataInfo<MmpSurgeryCatalogVo> queryPageList(MmpSurgeryCatalogBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的手术目录列表
     *
     * @param bo 查询条件
     * @return 手术目录列表
     */
    List<MmpSurgeryCatalogVo> queryList(MmpSurgeryCatalogBo bo);

    /**
     * 新增手术目录
     *
     * @param bo 手术目录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSurgeryCatalogBo bo);

    /**
     * 修改手术目录
     *
     * @param bo 手术目录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSurgeryCatalogBo bo);

    /**
     * 校验并批量删除手术目录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
