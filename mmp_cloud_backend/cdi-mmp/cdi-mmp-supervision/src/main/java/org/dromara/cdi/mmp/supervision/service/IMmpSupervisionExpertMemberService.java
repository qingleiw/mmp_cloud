package org.dromara.cdi.mmp.supervision.service;

import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionExpertMemberVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionExpertMemberBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 专家组成员Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpSupervisionExpertMemberService {

    /**
     * 查询专家组成员
     *
     * @param id 主键
     * @return 专家组成员
     */
    MmpSupervisionExpertMemberVo queryById(Long id);

    /**
     * 分页查询专家组成员列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 专家组成员分页列表
     */
    TableDataInfo<MmpSupervisionExpertMemberVo> queryPageList(MmpSupervisionExpertMemberBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的专家组成员列表
     *
     * @param bo 查询条件
     * @return 专家组成员列表
     */
    List<MmpSupervisionExpertMemberVo> queryList(MmpSupervisionExpertMemberBo bo);

    /**
     * 新增专家组成员
     *
     * @param bo 专家组成员
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSupervisionExpertMemberBo bo);

    /**
     * 修改专家组成员
     *
     * @param bo 专家组成员
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSupervisionExpertMemberBo bo);

    /**
     * 校验并批量删除专家组成员信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
