package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorAdverseRecordVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorAdverseRecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 不良行为记录Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpDoctorAdverseRecordService {

    /**
     * 查询不良行为记录
     *
     * @param id 主键
     * @return 不良行为记录
     */
    MmpDoctorAdverseRecordVo queryById(Long id);

    /**
     * 分页查询不良行为记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 不良行为记录分页列表
     */
    TableDataInfo<MmpDoctorAdverseRecordVo> queryPageList(MmpDoctorAdverseRecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的不良行为记录列表
     *
     * @param bo 查询条件
     * @return 不良行为记录列表
     */
    List<MmpDoctorAdverseRecordVo> queryList(MmpDoctorAdverseRecordBo bo);

    /**
     * 新增不良行为记录
     *
     * @param bo 不良行为记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDoctorAdverseRecordBo bo);

    /**
     * 修改不良行为记录
     *
     * @param bo 不良行为记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDoctorAdverseRecordBo bo);

    /**
     * 校验并批量删除不良行为记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
