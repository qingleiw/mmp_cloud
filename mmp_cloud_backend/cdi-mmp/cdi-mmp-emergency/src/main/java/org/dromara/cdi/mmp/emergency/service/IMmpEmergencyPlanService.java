package org.dromara.cdi.mmp.emergency.service;

import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyPlanVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyPlanBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 应急预案Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpEmergencyPlanService {

    /**
     * 查询应急预案
     *
     * @param id 主键
     * @return 应急预案
     */
    MmpEmergencyPlanVo queryById(Long id);

    /**
     * 分页查询应急预案列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 应急预案分页列表
     */
    TableDataInfo<MmpEmergencyPlanVo> queryPageList(MmpEmergencyPlanBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的应急预案列表
     *
     * @param bo 查询条件
     * @return 应急预案列表
     */
    List<MmpEmergencyPlanVo> queryList(MmpEmergencyPlanBo bo);

    /**
     * 新增应急预案
     *
     * @param bo 应急预案
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpEmergencyPlanBo bo);

    /**
     * 修改应急预案
     *
     * @param bo 应急预案
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpEmergencyPlanBo bo);

    /**
     * 校验并批量删除应急预案信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
