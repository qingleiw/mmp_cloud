package org.dromara.cdi.mmp.qualification.service;

import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationAuthorizationRecordVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationAuthorizationRecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 资质授权记录Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpQualificationAuthorizationRecordService {

    /**
     * 查询资质授权记录
     *
     * @param id 主键
     * @return 资质授权记录
     */
    MmpQualificationAuthorizationRecordVo queryById(Long id);

    /**
     * 分页查询资质授权记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质授权记录分页列表
     */
    TableDataInfo<MmpQualificationAuthorizationRecordVo> queryPageList(MmpQualificationAuthorizationRecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的资质授权记录列表
     *
     * @param bo 查询条件
     * @return 资质授权记录列表
     */
    List<MmpQualificationAuthorizationRecordVo> queryList(MmpQualificationAuthorizationRecordBo bo);

    /**
     * 新增资质授权记录
     *
     * @param bo 资质授权记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQualificationAuthorizationRecordBo bo);

    /**
     * 修改资质授权记录
     *
     * @param bo 资质授权记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQualificationAuthorizationRecordBo bo);

    /**
     * 校验并批量删除资质授权记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
