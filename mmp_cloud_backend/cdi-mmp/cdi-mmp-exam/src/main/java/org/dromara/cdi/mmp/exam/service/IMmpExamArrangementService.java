package org.dromara.cdi.mmp.exam.service;

import org.dromara.cdi.mmp.exam.domain.MmpExamArrangement;
import org.dromara.cdi.mmp.exam.domain.vo.MmpExamArrangementVo;
import org.dromara.cdi.mmp.exam.domain.bo.MmpExamArrangementBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 资质考试安排Service接口
 *
 * @author LionLi
 * @date 2026-01-18
 */
public interface IMmpExamArrangementService {

    /**
     * 查询资质考试安排
     *
     * @param id 主键
     * @return 资质考试安排
     */
    MmpExamArrangementVo queryById(Long id);

    /**
     * 分页查询资质考试安排列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质考试安排分页列表
     */
    TableDataInfo<MmpExamArrangementVo> queryPageList(MmpExamArrangementBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的资质考试安排列表
     *
     * @param bo 查询条件
     * @return 资质考试安排列表
     */
    List<MmpExamArrangementVo> queryList(MmpExamArrangementBo bo);

    /**
     * 新增资质考试安排
     *
     * @param bo 资质考试安排
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpExamArrangementBo bo);

    /**
     * 修改资质考试安排
     *
     * @param bo 资质考试安排
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpExamArrangementBo bo);

    /**
     * 校验并批量删除资质考试安排信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
