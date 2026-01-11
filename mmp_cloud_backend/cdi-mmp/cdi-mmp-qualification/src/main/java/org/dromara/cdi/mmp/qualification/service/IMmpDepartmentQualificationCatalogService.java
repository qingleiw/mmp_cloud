package org.dromara.cdi.mmp.qualification.service;

import org.dromara.cdi.mmp.qualification.domain.vo.MmpDepartmentQualificationCatalogVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpDepartmentQualificationCatalogBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 科室资质目录Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpDepartmentQualificationCatalogService {

    /**
     * 查询科室资质目录
     *
     * @param id 主键
     * @return 科室资质目录
     */
    MmpDepartmentQualificationCatalogVo queryById(Long id);

    /**
     * 分页查询科室资质目录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 科室资质目录分页列表
     */
    TableDataInfo<MmpDepartmentQualificationCatalogVo> queryPageList(MmpDepartmentQualificationCatalogBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的科室资质目录列表
     *
     * @param bo 查询条件
     * @return 科室资质目录列表
     */
    List<MmpDepartmentQualificationCatalogVo> queryList(MmpDepartmentQualificationCatalogBo bo);

    /**
     * 新增科室资质目录
     *
     * @param bo 科室资质目录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDepartmentQualificationCatalogBo bo);

    /**
     * 修改科室资质目录
     *
     * @param bo 科室资质目录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDepartmentQualificationCatalogBo bo);

    /**
     * 校验并批量删除科室资质目录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
