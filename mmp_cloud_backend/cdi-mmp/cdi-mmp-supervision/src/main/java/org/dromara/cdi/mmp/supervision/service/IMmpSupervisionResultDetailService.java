package org.dromara.cdi.mmp.supervision.service;

import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionResultDetailVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionResultDetailBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 督查结果明细Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpSupervisionResultDetailService {

    /**
     * 查询督查结果明细
     *
     * @param id 主键
     * @return 督查结果明细
     */
    MmpSupervisionResultDetailVo queryById(Long id);

    /**
     * 分页查询督查结果明细列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查结果明细分页列表
     */
    TableDataInfo<MmpSupervisionResultDetailVo> queryPageList(MmpSupervisionResultDetailBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的督查结果明细列表
     *
     * @param bo 查询条件
     * @return 督查结果明细列表
     */
    List<MmpSupervisionResultDetailVo> queryList(MmpSupervisionResultDetailBo bo);

    /**
     * 新增督查结果明细
     *
     * @param bo 督查结果明细
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSupervisionResultDetailBo bo);

    /**
     * 修改督查结果明细
     *
     * @param bo 督查结果明细
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSupervisionResultDetailBo bo);

    /**
     * 校验并批量删除督查结果明细信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
