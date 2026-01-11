package org.dromara.cdi.mmp.supervision.service;

import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionPlanVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionPlanBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 督查计划Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpSupervisionPlanService {

    /**
     * 查询督查计划
     *
     * @param id 主键
     * @return 督查计划
     */
    MmpSupervisionPlanVo queryById(Long id);

    /**
     * 分页查询督查计划列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查计划分页列表
     */
    TableDataInfo<MmpSupervisionPlanVo> queryPageList(MmpSupervisionPlanBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的督查计划列表
     *
     * @param bo 查询条件
     * @return 督查计划列表
     */
    List<MmpSupervisionPlanVo> queryList(MmpSupervisionPlanBo bo);

    /**
     * 新增督查计划
     *
     * @param bo 督查计划
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSupervisionPlanBo bo);

    /**
     * 修改督查计划
     *
     * @param bo 督查计划
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSupervisionPlanBo bo);

    /**
     * 校验并批量删除督查计划信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
