package org.dromara.cdi.mmp.emergency.service;

import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyDrillSummaryVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyDrillSummaryBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 应急演练总结Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpEmergencyDrillSummaryService {

    /**
     * 查询应急演练总结
     *
     * @param id 主键
     * @return 应急演练总结
     */
    MmpEmergencyDrillSummaryVo queryById(Long id);

    /**
     * 分页查询应急演练总结列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 应急演练总结分页列表
     */
    TableDataInfo<MmpEmergencyDrillSummaryVo> queryPageList(MmpEmergencyDrillSummaryBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的应急演练总结列表
     *
     * @param bo 查询条件
     * @return 应急演练总结列表
     */
    List<MmpEmergencyDrillSummaryVo> queryList(MmpEmergencyDrillSummaryBo bo);

    /**
     * 新增应急演练总结
     *
     * @param bo 应急演练总结
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpEmergencyDrillSummaryBo bo);

    /**
     * 修改应急演练总结
     *
     * @param bo 应急演练总结
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpEmergencyDrillSummaryBo bo);

    /**
     * 校验并批量删除应急演练总结信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
