package org.dromara.cdi.mmp.exam.service;

import org.dromara.cdi.mmp.exam.domain.vo.MmpQualificationExamPaperVo;
import org.dromara.cdi.mmp.exam.domain.bo.MmpQualificationExamPaperBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 资质考核试卷Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpQualificationExamPaperService {

    /**
     * 查询资质考核试卷
     *
     * @param id 主键
     * @return 资质考核试卷
     */
    MmpQualificationExamPaperVo queryById(Long id);

    /**
     * 分页查询资质考核试卷列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质考核试卷分页列表
     */
    TableDataInfo<MmpQualificationExamPaperVo> queryPageList(MmpQualificationExamPaperBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的资质考核试卷列表
     *
     * @param bo 查询条件
     * @return 资质考核试卷列表
     */
    List<MmpQualificationExamPaperVo> queryList(MmpQualificationExamPaperBo bo);

    /**
     * 新增资质考核试卷
     *
     * @param bo 资质考核试卷
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQualificationExamPaperBo bo);

    /**
     * 修改资质考核试卷
     *
     * @param bo 资质考核试卷
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQualificationExamPaperBo bo);

    /**
     * 校验并批量删除资质考核试卷信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
