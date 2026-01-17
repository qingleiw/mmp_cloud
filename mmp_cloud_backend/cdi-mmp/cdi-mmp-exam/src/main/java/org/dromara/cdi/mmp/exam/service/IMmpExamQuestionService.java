package org.dromara.cdi.mmp.exam.service;

import org.dromara.cdi.mmp.exam.domain.vo.MmpQualificationExamQuestionVo;
import org.dromara.cdi.mmp.exam.domain.bo.MmpQualificationExamQuestionBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 资质考核题库Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpQualificationExamQuestionService {

    /**
     * 查询资质考核题库
     *
     * @param id 主键
     * @return 资质考核题库
     */
    MmpQualificationExamQuestionVo queryById(Long id);

    /**
     * 分页查询资质考核题库列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质考核题库分页列表
     */
    TableDataInfo<MmpQualificationExamQuestionVo> queryPageList(MmpQualificationExamQuestionBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的资质考核题库列表
     *
     * @param bo 查询条件
     * @return 资质考核题库列表
     */
    List<MmpQualificationExamQuestionVo> queryList(MmpQualificationExamQuestionBo bo);

    /**
     * 新增资质考核题库
     *
     * @param bo 资质考核题库
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQualificationExamQuestionBo bo);

    /**
     * 修改资质考核题库
     *
     * @param bo 资质考核题库
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQualificationExamQuestionBo bo);

    /**
     * 校验并批量删除资质考核题库信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
