package org.dromara.cdi.mmp.qualification.service;

import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationAuthorizationApplyVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationAuthorizationApplyBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 资质授权申请Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpQualificationAuthorizationApplyService {

    /**
     * 查询资质授权申请
     *
     * @param id 主键
     * @return 资质授权申请
     */
    MmpQualificationAuthorizationApplyVo queryById(Long id);

    /**
     * 分页查询资质授权申请列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质授权申请分页列表
     */
    TableDataInfo<MmpQualificationAuthorizationApplyVo> queryPageList(MmpQualificationAuthorizationApplyBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的资质授权申请列表
     *
     * @param bo 查询条件
     * @return 资质授权申请列表
     */
    List<MmpQualificationAuthorizationApplyVo> queryList(MmpQualificationAuthorizationApplyBo bo);

    /**
     * 新增资质授权申请
     *
     * @param bo 资质授权申请
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQualificationAuthorizationApplyBo bo);

    /**
     * 修改资质授权申请
     *
     * @param bo 资质授权申请
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQualificationAuthorizationApplyBo bo);

    /**
     * 校验并批量删除资质授权申请信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
