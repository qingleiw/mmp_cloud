package org.dromara.cdi.mmp.emergency.service;

import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyEventResponseVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyEventResponseBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 突发事件响应Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpEmergencyEventResponseService {

    /**
     * 查询突发事件响应
     *
     * @param id 主键
     * @return 突发事件响应
     */
    MmpEmergencyEventResponseVo queryById(Long id);

    /**
     * 分页查询突发事件响应列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 突发事件响应分页列表
     */
    TableDataInfo<MmpEmergencyEventResponseVo> queryPageList(MmpEmergencyEventResponseBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的突发事件响应列表
     *
     * @param bo 查询条件
     * @return 突发事件响应列表
     */
    List<MmpEmergencyEventResponseVo> queryList(MmpEmergencyEventResponseBo bo);

    /**
     * 新增突发事件响应
     *
     * @param bo 突发事件响应
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpEmergencyEventResponseBo bo);

    /**
     * 修改突发事件响应
     *
     * @param bo 突发事件响应
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpEmergencyEventResponseBo bo);

    /**
     * 校验并批量删除突发事件响应信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
