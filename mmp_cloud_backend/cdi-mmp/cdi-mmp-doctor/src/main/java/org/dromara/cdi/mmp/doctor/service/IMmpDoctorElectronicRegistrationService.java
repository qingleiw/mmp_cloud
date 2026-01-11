package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorElectronicRegistrationVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorElectronicRegistrationBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 医师电子化注册Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpDoctorElectronicRegistrationService {

    /**
     * 查询医师电子化注册
     *
     * @param id 主键
     * @return 医师电子化注册
     */
    MmpDoctorElectronicRegistrationVo queryById(Long id);

    /**
     * 分页查询医师电子化注册列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医师电子化注册分页列表
     */
    TableDataInfo<MmpDoctorElectronicRegistrationVo> queryPageList(MmpDoctorElectronicRegistrationBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的医师电子化注册列表
     *
     * @param bo 查询条件
     * @return 医师电子化注册列表
     */
    List<MmpDoctorElectronicRegistrationVo> queryList(MmpDoctorElectronicRegistrationBo bo);

    /**
     * 新增医师电子化注册
     *
     * @param bo 医师电子化注册
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDoctorElectronicRegistrationBo bo);

    /**
     * 修改医师电子化注册
     *
     * @param bo 医师电子化注册
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDoctorElectronicRegistrationBo bo);

    /**
     * 校验并批量删除医师电子化注册信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
