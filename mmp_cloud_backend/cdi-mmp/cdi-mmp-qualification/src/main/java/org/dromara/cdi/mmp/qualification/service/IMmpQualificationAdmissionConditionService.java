package org.dromara.cdi.mmp.qualification.service;

import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationAdmissionConditionVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationAdmissionConditionBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 资质准入条件Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpQualificationAdmissionConditionService {

    /**
     * 查询资质准入条件
     *
     * @param id 主键
     * @return 资质准入条件
     */
    MmpQualificationAdmissionConditionVo queryById(Long id);

    /**
     * 分页查询资质准入条件列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质准入条件分页列表
     */
    TableDataInfo<MmpQualificationAdmissionConditionVo> queryPageList(MmpQualificationAdmissionConditionBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的资质准入条件列表
     *
     * @param bo 查询条件
     * @return 资质准入条件列表
     */
    List<MmpQualificationAdmissionConditionVo> queryList(MmpQualificationAdmissionConditionBo bo);

    /**
     * 新增资质准入条件
     *
     * @param bo 资质准入条件
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQualificationAdmissionConditionBo bo);

    /**
     * 修改资质准入条件
     *
     * @param bo 资质准入条件
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQualificationAdmissionConditionBo bo);

    /**
     * 校验并批量删除资质准入条件信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
