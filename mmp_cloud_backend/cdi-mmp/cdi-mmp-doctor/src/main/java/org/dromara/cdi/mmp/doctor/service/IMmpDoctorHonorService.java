package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorHonorVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorHonorBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 荣誉奖励Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpDoctorHonorService {

    /**
     * 查询荣誉奖励
     *
     * @param id 主键
     * @return 荣誉奖励
     */
    MmpDoctorHonorVo queryById(Long id);

    /**
     * 分页查询荣誉奖励列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 荣誉奖励分页列表
     */
    TableDataInfo<MmpDoctorHonorVo> queryPageList(MmpDoctorHonorBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的荣誉奖励列表
     *
     * @param bo 查询条件
     * @return 荣誉奖励列表
     */
    List<MmpDoctorHonorVo> queryList(MmpDoctorHonorBo bo);

    /**
     * 新增荣誉奖励
     *
     * @param bo 荣誉奖励
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDoctorHonorBo bo);

    /**
     * 修改荣誉奖励
     *
     * @param bo 荣誉奖励
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDoctorHonorBo bo);

    /**
     * 校验并批量删除荣誉奖励信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
