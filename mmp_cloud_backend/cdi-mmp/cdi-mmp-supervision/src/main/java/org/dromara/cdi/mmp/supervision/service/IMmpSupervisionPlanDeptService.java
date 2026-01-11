package org.dromara.cdi.mmp.supervision.service;

import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionPlanDeptVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionPlanDeptBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 督查计划科室关联Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpSupervisionPlanDeptService {

    /**
     * 查询督查计划科室关联
     *
     * @param id 主键
     * @return 督查计划科室关联
     */
    MmpSupervisionPlanDeptVo queryById(Long id);

    /**
     * 分页查询督查计划科室关联列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查计划科室关联分页列表
     */
    TableDataInfo<MmpSupervisionPlanDeptVo> queryPageList(MmpSupervisionPlanDeptBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的督查计划科室关联列表
     *
     * @param bo 查询条件
     * @return 督查计划科室关联列表
     */
    List<MmpSupervisionPlanDeptVo> queryList(MmpSupervisionPlanDeptBo bo);

    /**
     * 新增督查计划科室关联
     *
     * @param bo 督查计划科室关联
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSupervisionPlanDeptBo bo);

    /**
     * 修改督查计划科室关联
     *
     * @param bo 督查计划科室关联
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSupervisionPlanDeptBo bo);

    /**
     * 校验并批量删除督查计划科室关联信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
