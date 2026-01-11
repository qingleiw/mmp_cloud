package org.dromara.cdi.mmp.emergency.service;

import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyEventVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyEventBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 突发事件记录Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpEmergencyEventService {

    /**
     * 查询突发事件记录
     *
     * @param id 主键
     * @return 突发事件记录
     */
    MmpEmergencyEventVo queryById(Long id);

    /**
     * 分页查询突发事件记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 突发事件记录分页列表
     */
    TableDataInfo<MmpEmergencyEventVo> queryPageList(MmpEmergencyEventBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的突发事件记录列表
     *
     * @param bo 查询条件
     * @return 突发事件记录列表
     */
    List<MmpEmergencyEventVo> queryList(MmpEmergencyEventBo bo);

    /**
     * 新增突发事件记录
     *
     * @param bo 突发事件记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpEmergencyEventBo bo);

    /**
     * 修改突发事件记录
     *
     * @param bo 突发事件记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpEmergencyEventBo bo);

    /**
     * 校验并批量删除突发事件记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
