package org.dromara.cdi.mmp.ntp.service;

import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectAssessmentVo;
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectAssessmentBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 项目考核评估Service接口
 *
 * @author Lion Li
 * @date 2026-01-07
 */
public interface IMmpNewTechnologyProjectAssessmentService {

    /**
     * 查询项目考核评估
     *
     * @param id 主键
     * @return 项目考核评估
     */
    MmpNewTechnologyProjectAssessmentVo queryById(Long id);

    /**
     * 分页查询项目考核评估列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 项目考核评估分页列表
     */
    TableDataInfo<MmpNewTechnologyProjectAssessmentVo> queryPageList(MmpNewTechnologyProjectAssessmentBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的项目考核评估列表
     *
     * @param bo 查询条件
     * @return 项目考核评估列表
     */
    List<MmpNewTechnologyProjectAssessmentVo> queryList(MmpNewTechnologyProjectAssessmentBo bo);

    /**
     * 新增项目考核评估
     *
     * @param bo 项目考核评估
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNewTechnologyProjectAssessmentBo bo);

    /**
     * 修改项目考核评估
     *
     * @param bo 项目考核评估
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNewTechnologyProjectAssessmentBo bo);

    /**
     * 校验并批量删除项目考核评估信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
