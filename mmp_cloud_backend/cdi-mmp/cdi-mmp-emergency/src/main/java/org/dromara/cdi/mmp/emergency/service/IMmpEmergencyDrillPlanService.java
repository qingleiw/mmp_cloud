package org.dromara.cdi.mmp.emergency.service;

import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyDrillPlanVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyDrillPlanBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 应急演练计划Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpEmergencyDrillPlanService {

    /**
     * 查询应急演练计划
     *
     * @param id 主键
     * @return 应急演练计划
     */
    MmpEmergencyDrillPlanVo queryById(Long id);

    /**
     * 分页查询应急演练计划列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 应急演练计划分页列表
     */
    TableDataInfo<MmpEmergencyDrillPlanVo> queryPageList(MmpEmergencyDrillPlanBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的应急演练计划列表
     *
     * @param bo 查询条件
     * @return 应急演练计划列表
     */
    List<MmpEmergencyDrillPlanVo> queryList(MmpEmergencyDrillPlanBo bo);

    /**
     * 新增应急演练计划
     *
     * @param bo 应急演练计划
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpEmergencyDrillPlanBo bo);

    /**
     * 修改应急演练计划
     *
     * @param bo 应急演练计划
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpEmergencyDrillPlanBo bo);

    /**
     * 校验并批量删除应急演练计划信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
