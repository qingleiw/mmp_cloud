package org.dromara.cdi.mmp.qualification.service;

import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationCatalogVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationCatalogBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 医生手术授权目录Service接口
 *
 * @author Lion Li
 * @date 2025-12-30
 */
public interface IMmpQualificationCatalogService {

    /**
     * 查询医生手术授权目录
     *
     * @param id 主键
     * @return 医生手术授权目录
     */
    MmpQualificationCatalogVo queryById(Long id);

    /**
     * 分页查询医生手术授权目录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医生手术授权目录分页列表
     */
    TableDataInfo<MmpQualificationCatalogVo> queryPageList(MmpQualificationCatalogBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的医生手术授权目录列表
     *
     * @param bo 查询条件
     * @return 医生手术授权目录列表
     */
    List<MmpQualificationCatalogVo> queryList(MmpQualificationCatalogBo bo);

    /**
     * 新增医生手术授权目录
     *
     * @param bo 医生手术授权目录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQualificationCatalogBo bo);

    /**
     * 修改医生手术授权目录
     *
     * @param bo 医生手术授权目录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQualificationCatalogBo bo);

    /**
     * 校验并批量删除医生手术授权目录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
