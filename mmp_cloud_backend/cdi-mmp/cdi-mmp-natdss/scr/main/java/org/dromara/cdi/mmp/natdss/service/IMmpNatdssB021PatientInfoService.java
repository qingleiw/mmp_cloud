package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB021PatientInfo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB021PatientInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB021PatientInfoBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B02-1 患者就诊基本信息Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB021PatientInfoService {

    /**
     * 查询B02-1 患者就诊基本信息
     *
     * @param id 主键
     * @return B02-1 患者就诊基本信息
     */
    MmpNatdssB021PatientInfoVo queryById(Long id);

    /**
     * 分页查询B02-1 患者就诊基本信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B02-1 患者就诊基本信息分页列表
     */
    TableDataInfo<MmpNatdssB021PatientInfoVo> queryPageList(MmpNatdssB021PatientInfoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B02-1 患者就诊基本信息列表
     *
     * @param bo 查询条件
     * @return B02-1 患者就诊基本信息列表
     */
    List<MmpNatdssB021PatientInfoVo> queryList(MmpNatdssB021PatientInfoBo bo);

    /**
     * 新增B02-1 患者就诊基本信息
     *
     * @param bo B02-1 患者就诊基本信息
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB021PatientInfoBo bo);

    /**
     * 修改B02-1 患者就诊基本信息
     *
     * @param bo B02-1 患者就诊基本信息
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB021PatientInfoBo bo);

    /**
     * 校验并批量删除B02-1 患者就诊基本信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
