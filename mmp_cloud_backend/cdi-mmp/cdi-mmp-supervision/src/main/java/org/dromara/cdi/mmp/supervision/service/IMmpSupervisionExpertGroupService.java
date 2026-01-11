package org.dromara.cdi.mmp.supervision.service;

import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionExpertGroupVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionExpertGroupBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 专家组Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpSupervisionExpertGroupService {

    /**
     * 查询专家组
     *
     * @param id 主键
     * @return 专家组
     */
    MmpSupervisionExpertGroupVo queryById(Long id);

    /**
     * 分页查询专家组列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 专家组分页列表
     */
    TableDataInfo<MmpSupervisionExpertGroupVo> queryPageList(MmpSupervisionExpertGroupBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的专家组列表
     *
     * @param bo 查询条件
     * @return 专家组列表
     */
    List<MmpSupervisionExpertGroupVo> queryList(MmpSupervisionExpertGroupBo bo);

    /**
     * 新增专家组
     *
     * @param bo 专家组
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSupervisionExpertGroupBo bo);

    /**
     * 修改专家组
     *
     * @param bo 专家组
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSupervisionExpertGroupBo bo);

    /**
     * 校验并批量删除专家组信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
