package org.dromara.cdi.mmp.supervision.service;

import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionProjectIndicatorVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionProjectIndicatorBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 督查项目指标Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpSupervisionProjectIndicatorService {

    /**
     * 查询督查项目指标
     *
     * @param id 主键
     * @return 督查项目指标
     */
    MmpSupervisionProjectIndicatorVo queryById(Long id);

    /**
     * 分页查询督查项目指标列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查项目指标分页列表
     */
    TableDataInfo<MmpSupervisionProjectIndicatorVo> queryPageList(MmpSupervisionProjectIndicatorBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的督查项目指标列表
     *
     * @param bo 查询条件
     * @return 督查项目指标列表
     */
    List<MmpSupervisionProjectIndicatorVo> queryList(MmpSupervisionProjectIndicatorBo bo);

    /**
     * 新增督查项目指标
     *
     * @param bo 督查项目指标
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSupervisionProjectIndicatorBo bo);

    /**
     * 修改督查项目指标
     *
     * @param bo 督查项目指标
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSupervisionProjectIndicatorBo bo);

    /**
     * 校验并批量删除督查项目指标信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
