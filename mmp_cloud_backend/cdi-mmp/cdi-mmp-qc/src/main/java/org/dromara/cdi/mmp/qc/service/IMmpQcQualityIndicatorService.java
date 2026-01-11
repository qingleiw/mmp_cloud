package org.dromara.cdi.mmp.qc.service;

import org.dromara.cdi.mmp.qc.domain.vo.MmpQcQualityIndicatorVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcQualityIndicatorBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 质量指标Service接口
 *
 * @author Lion Li
 * @date 2025-12-30
 */
public interface IMmpQcQualityIndicatorService {

    /**
     * 查询质量指标
     *
     * @param id 主键
     * @return 质量指标
     */
    MmpQcQualityIndicatorVo queryById(Long id);

    /**
     * 分页查询质量指标列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 质量指标分页列表
     */
    TableDataInfo<MmpQcQualityIndicatorVo> queryPageList(MmpQcQualityIndicatorBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的质量指标列表
     *
     * @param bo 查询条件
     * @return 质量指标列表
     */
    List<MmpQcQualityIndicatorVo> queryList(MmpQcQualityIndicatorBo bo);

    /**
     * 新增质量指标
     *
     * @param bo 质量指标
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQcQualityIndicatorBo bo);

    /**
     * 修改质量指标
     *
     * @param bo 质量指标
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQcQualityIndicatorBo bo);

    /**
     * 校验并批量删除质量指标信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
