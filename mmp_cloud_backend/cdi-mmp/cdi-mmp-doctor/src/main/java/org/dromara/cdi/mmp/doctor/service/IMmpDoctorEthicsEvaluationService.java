package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorEthicsEvaluationVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorEthicsEvaluationBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 医德医风考评Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpDoctorEthicsEvaluationService {

    /**
     * 查询医德医风考评
     *
     * @param id 主键
     * @return 医德医风考评
     */
    MmpDoctorEthicsEvaluationVo queryById(Long id);

    /**
     * 分页查询医德医风考评列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医德医风考评分页列表
     */
    TableDataInfo<MmpDoctorEthicsEvaluationVo> queryPageList(MmpDoctorEthicsEvaluationBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的医德医风考评列表
     *
     * @param bo 查询条件
     * @return 医德医风考评列表
     */
    List<MmpDoctorEthicsEvaluationVo> queryList(MmpDoctorEthicsEvaluationBo bo);

    /**
     * 新增医德医风考评
     *
     * @param bo 医德医风考评
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDoctorEthicsEvaluationBo bo);

    /**
     * 修改医德医风考评
     *
     * @param bo 医德医风考评
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDoctorEthicsEvaluationBo bo);

    /**
     * 校验并批量删除医德医风考评信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
