package org.dromara.cdi.mmp.radiation.service;

import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationEquipmentInspectionVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationEquipmentInspectionBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 放射设备检测记录Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpRadiationEquipmentInspectionService {

    /**
     * 查询放射设备检测记录
     *
     * @param id 主键
     * @return 放射设备检测记录
     */
    MmpRadiationEquipmentInspectionVo queryById(Long id);

    /**
     * 分页查询放射设备检测记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 放射设备检测记录分页列表
     */
    TableDataInfo<MmpRadiationEquipmentInspectionVo> queryPageList(MmpRadiationEquipmentInspectionBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的放射设备检测记录列表
     *
     * @param bo 查询条件
     * @return 放射设备检测记录列表
     */
    List<MmpRadiationEquipmentInspectionVo> queryList(MmpRadiationEquipmentInspectionBo bo);

    /**
     * 新增放射设备检测记录
     *
     * @param bo 放射设备检测记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpRadiationEquipmentInspectionBo bo);

    /**
     * 修改放射设备检测记录
     *
     * @param bo 放射设备检测记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpRadiationEquipmentInspectionBo bo);

    /**
     * 校验并批量删除放射设备检测记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
