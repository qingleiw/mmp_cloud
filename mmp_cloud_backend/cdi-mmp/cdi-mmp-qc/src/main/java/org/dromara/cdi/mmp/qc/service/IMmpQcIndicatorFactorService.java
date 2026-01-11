package org.dromara.cdi.mmp.qc.service;

import org.dromara.cdi.mmp.qc.domain.vo.MmpQcIndicatorFactorVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcIndicatorFactorBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 指标计算因子Service接口
 *
 * @author Lion Li
 * @date 2025-12-30
 */
public interface IMmpQcIndicatorFactorService {

    /**
     * 查询指标计算因子
     *
     * @param id 主键
     * @return 指标计算因子
     */
    MmpQcIndicatorFactorVo queryById(Long id);

    /**
     * 分页查询指标计算因子列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 指标计算因子分页列表
     */
    TableDataInfo<MmpQcIndicatorFactorVo> queryPageList(MmpQcIndicatorFactorBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的指标计算因子列表
     *
     * @param bo 查询条件
     * @return 指标计算因子列表
     */
    List<MmpQcIndicatorFactorVo> queryList(MmpQcIndicatorFactorBo bo);

    /**
     * 新增指标计算因子
     *
     * @param bo 指标计算因子
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQcIndicatorFactorBo bo);

    /**
     * 修改指标计算因子
     *
     * @param bo 指标计算因子
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQcIndicatorFactorBo bo);

    /**
     * 校验并批量删除指标计算因子信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
