package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B04非中医院-补充信息（其他手术+费用+扩展信息）Service接口
 *
 * @author LionLi
 * @date 2026-01-18
 */
public interface IMmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementService {

    /**
     * 查询B04非中医院-补充信息（其他手术+费用+扩展信息）
     *
     * @param patientId 主键
     * @return B04非中医院-补充信息（其他手术+费用+扩展信息）
     */
    MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementVo queryById(String patientId);

    /**
     * 分页查询B04非中医院-补充信息（其他手术+费用+扩展信息）列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B04非中医院-补充信息（其他手术+费用+扩展信息）分页列表
     */
    TableDataInfo<MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementVo> queryPageList(MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B04非中医院-补充信息（其他手术+费用+扩展信息）列表
     *
     * @param bo 查询条件
     * @return B04非中医院-补充信息（其他手术+费用+扩展信息）列表
     */
    List<MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementVo> queryList(MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo bo);

    /**
     * 新增B04非中医院-补充信息（其他手术+费用+扩展信息）
     *
     * @param bo B04非中医院-补充信息（其他手术+费用+扩展信息）
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo bo);

    /**
     * 修改B04非中医院-补充信息（其他手术+费用+扩展信息）
     *
     * @param bo B04非中医院-补充信息（其他手术+费用+扩展信息）
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo bo);

    /**
     * 校验并批量删除B04非中医院-补充信息（其他手术+费用+扩展信息）信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid);
}
