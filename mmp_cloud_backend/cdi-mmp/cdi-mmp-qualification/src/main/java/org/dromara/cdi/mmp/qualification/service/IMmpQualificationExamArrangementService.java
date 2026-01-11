package org.dromara.cdi.mmp.qualification.service;

import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationExamArrangementVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationExamArrangementBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 资质考试安排Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpQualificationExamArrangementService {

    /**
     * 查询资质考试安排
     *
     * @param id 主键
     * @return 资质考试安排
     */
    MmpQualificationExamArrangementVo queryById(Long id);

    /**
     * 分页查询资质考试安排列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质考试安排分页列表
     */
    TableDataInfo<MmpQualificationExamArrangementVo> queryPageList(MmpQualificationExamArrangementBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的资质考试安排列表
     *
     * @param bo 查询条件
     * @return 资质考试安排列表
     */
    List<MmpQualificationExamArrangementVo> queryList(MmpQualificationExamArrangementBo bo);

    /**
     * 新增资质考试安排
     *
     * @param bo 资质考试安排
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQualificationExamArrangementBo bo);

    /**
     * 修改资质考试安排
     *
     * @param bo 资质考试安排
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQualificationExamArrangementBo bo);

    /**
     * 校验并批量删除资质考试安排信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
