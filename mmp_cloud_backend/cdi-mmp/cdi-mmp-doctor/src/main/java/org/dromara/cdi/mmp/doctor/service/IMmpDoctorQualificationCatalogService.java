package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorQualificationCatalogVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorQualificationCatalogBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 医师资质目录Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpDoctorQualificationCatalogService {

    /**
     * 查询医师资质目录
     *
     * @param id 主键
     * @return 医师资质目录
     */
    MmpDoctorQualificationCatalogVo queryById(Long id);

    /**
     * 分页查询医师资质目录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医师资质目录分页列表
     */
    TableDataInfo<MmpDoctorQualificationCatalogVo> queryPageList(MmpDoctorQualificationCatalogBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的医师资质目录列表
     *
     * @param bo 查询条件
     * @return 医师资质目录列表
     */
    List<MmpDoctorQualificationCatalogVo> queryList(MmpDoctorQualificationCatalogBo bo);

    /**
     * 新增医师资质目录
     *
     * @param bo 医师资质目录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDoctorQualificationCatalogBo bo);

    /**
     * 修改医师资质目录
     *
     * @param bo 医师资质目录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDoctorQualificationCatalogBo bo);

    /**
     * 校验并批量删除医师资质目录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
