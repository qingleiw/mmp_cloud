package org.dromara.cdi.mmp.qualification.service;

import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationPermissionAdjustmentVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationPermissionAdjustmentBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 资质权限调整历史Service接口
 *
 * @author Lion Li
 * @date 2025-12-26
 */
public interface IMmpQualificationPermissionAdjustmentService {

    /**
     * 查询资质权限调整历史
     *
     * @param id 主键
     * @return 资质权限调整历史
     */
    MmpQualificationPermissionAdjustmentVo queryById(Long id);

    /**
     * 分页查询资质权限调整历史列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质权限调整历史分页列表
     */
    TableDataInfo<MmpQualificationPermissionAdjustmentVo> queryPageList(MmpQualificationPermissionAdjustmentBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的资质权限调整历史列表
     *
     * @param bo 查询条件
     * @return 资质权限调整历史列表
     */
    List<MmpQualificationPermissionAdjustmentVo> queryList(MmpQualificationPermissionAdjustmentBo bo);

    /**
     * 新增资质权限调整历史
     *
     * @param bo 资质权限调整历史
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQualificationPermissionAdjustmentBo bo);

    /**
     * 修改资质权限调整历史
     *
     * @param bo 资质权限调整历史
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQualificationPermissionAdjustmentBo bo);

    /**
     * 校验并批量删除资质权限调整历史信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
