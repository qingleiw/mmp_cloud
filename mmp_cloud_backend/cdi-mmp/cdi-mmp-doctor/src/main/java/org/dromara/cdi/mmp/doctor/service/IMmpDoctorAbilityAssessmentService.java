package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorAbilityAssessmentVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorAbilityAssessmentBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 医师能力评估Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpDoctorAbilityAssessmentService {

    /**
     * 查询医师能力评估
     *
     * @param id 主键
     * @return 医师能力评估
     */
    MmpDoctorAbilityAssessmentVo queryById(Long id);

    /**
     * 分页查询医师能力评估列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医师能力评估分页列表
     */
    TableDataInfo<MmpDoctorAbilityAssessmentVo> queryPageList(MmpDoctorAbilityAssessmentBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的医师能力评估列表
     *
     * @param bo 查询条件
     * @return 医师能力评估列表
     */
    List<MmpDoctorAbilityAssessmentVo> queryList(MmpDoctorAbilityAssessmentBo bo);

    /**
     * 新增医师能力评估
     *
     * @param bo 医师能力评估
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDoctorAbilityAssessmentBo bo);

    /**
     * 修改医师能力评估
     *
     * @param bo 医师能力评估
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDoctorAbilityAssessmentBo bo);

    /**
     * 校验并批量删除医师能力评估信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
