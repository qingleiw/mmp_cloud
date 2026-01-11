package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorProfessionalRatingVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorProfessionalRatingBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 医师职业评分Service接口
 *
 * @author Lion Li
 * @date 2025-12-26
 */
public interface IMmpDoctorProfessionalRatingService {

    /**
     * 查询医师职业评分
     *
     * @param id 主键
     * @return 医师职业评分
     */
    MmpDoctorProfessionalRatingVo queryById(Long id);

    /**
     * 分页查询医师职业评分列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医师职业评分分页列表
     */
    TableDataInfo<MmpDoctorProfessionalRatingVo> queryPageList(MmpDoctorProfessionalRatingBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的医师职业评分列表
     *
     * @param bo 查询条件
     * @return 医师职业评分列表
     */
    List<MmpDoctorProfessionalRatingVo> queryList(MmpDoctorProfessionalRatingBo bo);

    /**
     * 新增医师职业评分
     *
     * @param bo 医师职业评分
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDoctorProfessionalRatingBo bo);

    /**
     * 修改医师职业评分
     *
     * @param bo 医师职业评分
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDoctorProfessionalRatingBo bo);

    /**
     * 校验并批量删除医师职业评分信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
