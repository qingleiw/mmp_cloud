package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorAcademicPositionVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorAcademicPositionBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 学术任职Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpDoctorAcademicPositionService {

    /**
     * 查询学术任职
     *
     * @param id 主键
     * @return 学术任职
     */
    MmpDoctorAcademicPositionVo queryById(Long id);

    /**
     * 分页查询学术任职列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 学术任职分页列表
     */
    TableDataInfo<MmpDoctorAcademicPositionVo> queryPageList(MmpDoctorAcademicPositionBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的学术任职列表
     *
     * @param bo 查询条件
     * @return 学术任职列表
     */
    List<MmpDoctorAcademicPositionVo> queryList(MmpDoctorAcademicPositionBo bo);

    /**
     * 新增学术任职
     *
     * @param bo 学术任职
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDoctorAcademicPositionBo bo);

    /**
     * 修改学术任职
     *
     * @param bo 学术任职
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDoctorAcademicPositionBo bo);

    /**
     * 校验并批量删除学术任职信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
