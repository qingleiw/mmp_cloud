package org.dromara.cdi.mmp.radiation.service;

import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationHealthExamPlanVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationHealthExamPlanBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 职业健康体检计划Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpRadiationHealthExamPlanService {

    /**
     * 查询职业健康体检计划
     *
     * @param id 主键
     * @return 职业健康体检计划
     */
    MmpRadiationHealthExamPlanVo queryById(Long id);

    /**
     * 分页查询职业健康体检计划列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 职业健康体检计划分页列表
     */
    TableDataInfo<MmpRadiationHealthExamPlanVo> queryPageList(MmpRadiationHealthExamPlanBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的职业健康体检计划列表
     *
     * @param bo 查询条件
     * @return 职业健康体检计划列表
     */
    List<MmpRadiationHealthExamPlanVo> queryList(MmpRadiationHealthExamPlanBo bo);

    /**
     * 新增职业健康体检计划
     *
     * @param bo 职业健康体检计划
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpRadiationHealthExamPlanBo bo);

    /**
     * 修改职业健康体检计划
     *
     * @param bo 职业健康体检计划
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpRadiationHealthExamPlanBo bo);

    /**
     * 校验并批量删除职业健康体检计划信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
