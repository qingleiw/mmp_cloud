package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorTrainingVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorTrainingBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 培训记录Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpDoctorTrainingService {

    /**
     * 查询培训记录
     *
     * @param id 主键
     * @return 培训记录
     */
    MmpDoctorTrainingVo queryById(Long id);

    /**
     * 分页查询培训记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 培训记录分页列表
     */
    TableDataInfo<MmpDoctorTrainingVo> queryPageList(MmpDoctorTrainingBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的培训记录列表
     *
     * @param bo 查询条件
     * @return 培训记录列表
     */
    List<MmpDoctorTrainingVo> queryList(MmpDoctorTrainingBo bo);

    /**
     * 新增培训记录
     *
     * @param bo 培训记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDoctorTrainingBo bo);

    /**
     * 修改培训记录
     *
     * @param bo 培训记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDoctorTrainingBo bo);

    /**
     * 校验并批量删除培训记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
