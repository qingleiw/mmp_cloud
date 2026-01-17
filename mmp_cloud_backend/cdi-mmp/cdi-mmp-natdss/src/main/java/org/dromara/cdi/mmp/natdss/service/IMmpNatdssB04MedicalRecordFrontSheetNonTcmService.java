package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB04MedicalRecordFrontSheetNonTcm;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB04MedicalRecordFrontSheetNonTcmVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB04MedicalRecordFrontSheetNonTcmBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B04病历首页-核心信息-非中医院（基础+诊断+主要手术）Service接口
 *
 * @author LionLi
 * @date 2026-01-18
 */
public interface IMmpNatdssB04MedicalRecordFrontSheetNonTcmService {

    /**
     * 查询B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
     *
     * @param patientId 主键
     * @return B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
     */
    MmpNatdssB04MedicalRecordFrontSheetNonTcmVo queryById(String patientId);

    /**
     * 分页查询B04病历首页-核心信息-非中医院（基础+诊断+主要手术）列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B04病历首页-核心信息-非中医院（基础+诊断+主要手术）分页列表
     */
    TableDataInfo<MmpNatdssB04MedicalRecordFrontSheetNonTcmVo> queryPageList(MmpNatdssB04MedicalRecordFrontSheetNonTcmBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B04病历首页-核心信息-非中医院（基础+诊断+主要手术）列表
     *
     * @param bo 查询条件
     * @return B04病历首页-核心信息-非中医院（基础+诊断+主要手术）列表
     */
    List<MmpNatdssB04MedicalRecordFrontSheetNonTcmVo> queryList(MmpNatdssB04MedicalRecordFrontSheetNonTcmBo bo);

    /**
     * 新增B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
     *
     * @param bo B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB04MedicalRecordFrontSheetNonTcmBo bo);

    /**
     * 修改B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
     *
     * @param bo B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB04MedicalRecordFrontSheetNonTcmBo bo);

    /**
     * 校验并批量删除B04病历首页-核心信息-非中医院（基础+诊断+主要手术）信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid);
}
