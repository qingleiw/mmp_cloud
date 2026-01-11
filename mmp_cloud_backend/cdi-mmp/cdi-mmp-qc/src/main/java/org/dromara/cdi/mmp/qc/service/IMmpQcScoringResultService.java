package org.dromara.cdi.mmp.qc.service;

import org.dromara.cdi.mmp.qc.domain.vo.MmpQcScoringResultVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcScoringResultBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 评分结果Service接口
 *
 * @author Lion Li
 * @date 2025-12-30
 */
public interface IMmpQcScoringResultService {

    /**
     * 查询评分结果
     *
     * @param id 主键
     * @return 评分结果
     */
    MmpQcScoringResultVo queryById(Long id);

    /**
     * 分页查询评分结果列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 评分结果分页列表
     */
    TableDataInfo<MmpQcScoringResultVo> queryPageList(MmpQcScoringResultBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的评分结果列表
     *
     * @param bo 查询条件
     * @return 评分结果列表
     */
    List<MmpQcScoringResultVo> queryList(MmpQcScoringResultBo bo);

    /**
     * 新增评分结果
     *
     * @param bo 评分结果
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQcScoringResultBo bo);

    /**
     * 修改评分结果
     *
     * @param bo 评分结果
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQcScoringResultBo bo);

    /**
     * 校验并批量删除评分结果信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
