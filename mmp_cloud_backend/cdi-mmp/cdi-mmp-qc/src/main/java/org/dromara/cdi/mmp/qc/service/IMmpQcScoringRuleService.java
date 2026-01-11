package org.dromara.cdi.mmp.qc.service;

import org.dromara.cdi.mmp.qc.domain.vo.MmpQcScoringRuleVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcScoringRuleBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 评分规则Service接口
 *
 * @author Lion Li
 * @date 2025-12-30
 */
public interface IMmpQcScoringRuleService {

    /**
     * 查询评分规则
     *
     * @param id 主键
     * @return 评分规则
     */
    MmpQcScoringRuleVo queryById(Long id);

    /**
     * 分页查询评分规则列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 评分规则分页列表
     */
    TableDataInfo<MmpQcScoringRuleVo> queryPageList(MmpQcScoringRuleBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的评分规则列表
     *
     * @param bo 查询条件
     * @return 评分规则列表
     */
    List<MmpQcScoringRuleVo> queryList(MmpQcScoringRuleBo bo);

    /**
     * 新增评分规则
     *
     * @param bo 评分规则
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQcScoringRuleBo bo);

    /**
     * 修改评分规则
     *
     * @param bo 评分规则
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQcScoringRuleBo bo);

    /**
     * 校验并批量删除评分规则信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
