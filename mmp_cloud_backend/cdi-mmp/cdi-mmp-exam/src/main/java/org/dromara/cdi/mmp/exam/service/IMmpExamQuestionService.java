package org.dromara.cdi.mmp.exam.service;

import org.dromara.cdi.mmp.exam.domain.MmpExamQuestion;
import org.dromara.cdi.mmp.exam.domain.vo.MmpExamQuestionVo;
import org.dromara.cdi.mmp.exam.domain.bo.MmpExamQuestionBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 资质考核题库Service接口
 *
 * @author LionLi
 * @date 2026-01-18
 */
public interface IMmpExamQuestionService {

    /**
     * 查询资质考核题库
     *
     * @param id 主键
     * @return 资质考核题库
     */
    MmpExamQuestionVo queryById(Long id);

    /**
     * 分页查询资质考核题库列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质考核题库分页列表
     */
    TableDataInfo<MmpExamQuestionVo> queryPageList(MmpExamQuestionBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的资质考核题库列表
     *
     * @param bo 查询条件
     * @return 资质考核题库列表
     */
    List<MmpExamQuestionVo> queryList(MmpExamQuestionBo bo);

    /**
     * 新增资质考核题库
     *
     * @param bo 资质考核题库
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpExamQuestionBo bo);

    /**
     * 修改资质考核题库
     *
     * @param bo 资质考核题库
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpExamQuestionBo bo);

    /**
     * 校验并批量删除资质考核题库信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
