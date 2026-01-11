package org.dromara.cdi.mmp.emergency.service;

import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyTeamVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyTeamBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 应急队伍Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpEmergencyTeamService {

    /**
     * 查询应急队伍
     *
     * @param id 主键
     * @return 应急队伍
     */
    MmpEmergencyTeamVo queryById(Long id);

    /**
     * 分页查询应急队伍列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 应急队伍分页列表
     */
    TableDataInfo<MmpEmergencyTeamVo> queryPageList(MmpEmergencyTeamBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的应急队伍列表
     *
     * @param bo 查询条件
     * @return 应急队伍列表
     */
    List<MmpEmergencyTeamVo> queryList(MmpEmergencyTeamBo bo);

    /**
     * 新增应急队伍
     *
     * @param bo 应急队伍
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpEmergencyTeamBo bo);

    /**
     * 修改应急队伍
     *
     * @param bo 应急队伍
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpEmergencyTeamBo bo);

    /**
     * 校验并批量删除应急队伍信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
