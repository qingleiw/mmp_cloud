package org.dromara.cdi.mmp.emergency.service;

import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyMedicalSupportVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyMedicalSupportBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 医疗保障资源Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpEmergencyMedicalSupportService {

    /**
     * 查询医疗保障资源
     *
     * @param id 主键
     * @return 医疗保障资源
     */
    MmpEmergencyMedicalSupportVo queryById(Long id);

    /**
     * 分页查询医疗保障资源列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医疗保障资源分页列表
     */
    TableDataInfo<MmpEmergencyMedicalSupportVo> queryPageList(MmpEmergencyMedicalSupportBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的医疗保障资源列表
     *
     * @param bo 查询条件
     * @return 医疗保障资源列表
     */
    List<MmpEmergencyMedicalSupportVo> queryList(MmpEmergencyMedicalSupportBo bo);

    /**
     * 新增医疗保障资源
     *
     * @param bo 医疗保障资源
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpEmergencyMedicalSupportBo bo);

    /**
     * 修改医疗保障资源
     *
     * @param bo 医疗保障资源
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpEmergencyMedicalSupportBo bo);

    /**
     * 校验并批量删除医疗保障资源信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
