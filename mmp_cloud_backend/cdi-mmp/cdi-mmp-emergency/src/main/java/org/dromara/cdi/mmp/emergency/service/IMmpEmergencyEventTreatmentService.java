package org.dromara.cdi.mmp.emergency.service;

import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyEventTreatmentVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyEventTreatmentBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 突发事件救治Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpEmergencyEventTreatmentService {

    /**
     * 查询突发事件救治
     *
     * @param id 主键
     * @return 突发事件救治
     */
    MmpEmergencyEventTreatmentVo queryById(Long id);

    /**
     * 分页查询突发事件救治列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 突发事件救治分页列表
     */
    TableDataInfo<MmpEmergencyEventTreatmentVo> queryPageList(MmpEmergencyEventTreatmentBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的突发事件救治列表
     *
     * @param bo 查询条件
     * @return 突发事件救治列表
     */
    List<MmpEmergencyEventTreatmentVo> queryList(MmpEmergencyEventTreatmentBo bo);

    /**
     * 新增突发事件救治
     *
     * @param bo 突发事件救治
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpEmergencyEventTreatmentBo bo);

    /**
     * 修改突发事件救治
     *
     * @param bo 突发事件救治
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpEmergencyEventTreatmentBo bo);

    /**
     * 校验并批量删除突发事件救治信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
