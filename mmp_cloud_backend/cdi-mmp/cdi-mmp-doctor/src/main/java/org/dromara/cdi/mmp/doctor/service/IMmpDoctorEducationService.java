package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorEducationVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorEducationBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 教育经历Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpDoctorEducationService {

    /**
     * 查询教育经历
     *
     * @param id 主键
     * @return 教育经历
     */
    MmpDoctorEducationVo queryById(Long id);

    /**
     * 分页查询教育经历列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 教育经历分页列表
     */
    TableDataInfo<MmpDoctorEducationVo> queryPageList(MmpDoctorEducationBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的教育经历列表
     *
     * @param bo 查询条件
     * @return 教育经历列表
     */
    List<MmpDoctorEducationVo> queryList(MmpDoctorEducationBo bo);

    /**
     * 新增教育经历
     *
     * @param bo 教育经历
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDoctorEducationBo bo);

    /**
     * 修改教育经历
     *
     * @param bo 教育经历
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDoctorEducationBo bo);

    /**
     * 校验并批量删除教育经历信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
