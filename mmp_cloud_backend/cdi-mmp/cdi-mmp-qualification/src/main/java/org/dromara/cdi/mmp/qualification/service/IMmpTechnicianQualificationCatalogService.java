package org.dromara.cdi.mmp.qualification.service;

import org.dromara.cdi.mmp.qualification.domain.vo.MmpTechnicianQualificationCatalogVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpTechnicianQualificationCatalogBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 医技资质目录Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpTechnicianQualificationCatalogService {

    /**
     * 查询医技资质目录
     *
     * @param id 主键
     * @return 医技资质目录
     */
    MmpTechnicianQualificationCatalogVo queryById(Long id);

    /**
     * 分页查询医技资质目录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医技资质目录分页列表
     */
    TableDataInfo<MmpTechnicianQualificationCatalogVo> queryPageList(MmpTechnicianQualificationCatalogBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的医技资质目录列表
     *
     * @param bo 查询条件
     * @return 医技资质目录列表
     */
    List<MmpTechnicianQualificationCatalogVo> queryList(MmpTechnicianQualificationCatalogBo bo);

    /**
     * 新增医技资质目录
     *
     * @param bo 医技资质目录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpTechnicianQualificationCatalogBo bo);

    /**
     * 修改医技资质目录
     *
     * @param bo 医技资质目录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpTechnicianQualificationCatalogBo bo);

    /**
     * 校验并批量删除医技资质目录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
