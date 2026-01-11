package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorBasicInfoVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorBasicInfoBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorInfoVo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 医师基本信息Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpDoctorBasicInfoService {

    /**
     * 查询医师基本信息
     *
     * @param id 主键
     * @return 医师基本信息
     */
    MmpDoctorBasicInfoVo queryById(Long id);

    /**
     * 分页查询医师基本信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医师基本信息分页列表
     */
    TableDataInfo<MmpDoctorBasicInfoVo> queryPageList(MmpDoctorBasicInfoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的医师基本信息列表
     *
     * @param bo 查询条件
     * @return 医师基本信息列表
     */
    List<MmpDoctorBasicInfoVo> queryList(MmpDoctorBasicInfoBo bo);

    /**
     * 新增医师基本信息
     *
     * @param bo 医师基本信息
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDoctorBasicInfoBo bo);

    /**
     * 修改医师基本信息
     *
     * @param bo 医师基本信息
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDoctorBasicInfoBo bo);

    /**
     * 校验并批量删除医师基本信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

    /**
     * 获取医师档案信息
     *
     * @param doctorId 医师ID
     * @return 医师档案信息
     */
    MmpDoctorInfoVo getDoctorArchive(Long doctorId);
}
