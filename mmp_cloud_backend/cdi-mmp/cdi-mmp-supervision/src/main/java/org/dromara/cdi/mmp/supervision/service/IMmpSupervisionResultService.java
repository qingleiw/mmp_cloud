package org.dromara.cdi.mmp.supervision.service;

import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionResultVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionResultBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 督查结果Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpSupervisionResultService {

    /**
     * 查询督查结果
     *
     * @param id 主键
     * @return 督查结果
     */
    MmpSupervisionResultVo queryById(Long id);

    /**
     * 分页查询督查结果列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查结果分页列表
     */
    TableDataInfo<MmpSupervisionResultVo> queryPageList(MmpSupervisionResultBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的督查结果列表
     *
     * @param bo 查询条件
     * @return 督查结果列表
     */
    List<MmpSupervisionResultVo> queryList(MmpSupervisionResultBo bo);

    /**
     * 新增督查结果
     *
     * @param bo 督查结果
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSupervisionResultBo bo);

    /**
     * 修改督查结果
     *
     * @param bo 督查结果
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSupervisionResultBo bo);

    /**
     * 校验并批量删除督查结果信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
