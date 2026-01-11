package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorWorkExperienceVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorWorkExperienceBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 工作经历Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpDoctorWorkExperienceService {

    /**
     * 查询工作经历
     *
     * @param id 主键
     * @return 工作经历
     */
    MmpDoctorWorkExperienceVo queryById(Long id);

    /**
     * 分页查询工作经历列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 工作经历分页列表
     */
    TableDataInfo<MmpDoctorWorkExperienceVo> queryPageList(MmpDoctorWorkExperienceBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的工作经历列表
     *
     * @param bo 查询条件
     * @return 工作经历列表
     */
    List<MmpDoctorWorkExperienceVo> queryList(MmpDoctorWorkExperienceBo bo);

    /**
     * 新增工作经历
     *
     * @param bo 工作经历
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDoctorWorkExperienceBo bo);

    /**
     * 修改工作经历
     *
     * @param bo 工作经历
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDoctorWorkExperienceBo bo);

    /**
     * 校验并批量删除工作经历信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
