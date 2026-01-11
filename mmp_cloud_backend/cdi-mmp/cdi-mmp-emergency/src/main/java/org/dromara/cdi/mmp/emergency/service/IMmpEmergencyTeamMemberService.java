package org.dromara.cdi.mmp.emergency.service;

import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyTeamMemberVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyTeamMemberBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 应急队伍成员Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpEmergencyTeamMemberService {

    /**
     * 查询应急队伍成员
     *
     * @param id 主键
     * @return 应急队伍成员
     */
    MmpEmergencyTeamMemberVo queryById(Long id);

    /**
     * 分页查询应急队伍成员列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 应急队伍成员分页列表
     */
    TableDataInfo<MmpEmergencyTeamMemberVo> queryPageList(MmpEmergencyTeamMemberBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的应急队伍成员列表
     *
     * @param bo 查询条件
     * @return 应急队伍成员列表
     */
    List<MmpEmergencyTeamMemberVo> queryList(MmpEmergencyTeamMemberBo bo);

    /**
     * 新增应急队伍成员
     *
     * @param bo 应急队伍成员
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpEmergencyTeamMemberBo bo);

    /**
     * 修改应急队伍成员
     *
     * @param bo 应急队伍成员
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpEmergencyTeamMemberBo bo);

    /**
     * 校验并批量删除应急队伍成员信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
