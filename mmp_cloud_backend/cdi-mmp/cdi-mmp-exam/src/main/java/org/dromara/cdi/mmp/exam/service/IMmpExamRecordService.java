package org.dromara.cdi.mmp.exam.service;

import org.dromara.cdi.mmp.exam.domain.MmpExamRecord;
import org.dromara.cdi.mmp.exam.domain.vo.MmpExamRecordVo;
import org.dromara.cdi.mmp.exam.domain.bo.MmpExamRecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 资质考试记录Service接口
 *
 * @author LionLi
 * @date 2026-01-18
 */
public interface IMmpExamRecordService {

    /**
     * 查询资质考试记录
     *
     * @param id 主键
     * @return 资质考试记录
     */
    MmpExamRecordVo queryById(Long id);

    /**
     * 分页查询资质考试记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质考试记录分页列表
     */
    TableDataInfo<MmpExamRecordVo> queryPageList(MmpExamRecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的资质考试记录列表
     *
     * @param bo 查询条件
     * @return 资质考试记录列表
     */
    List<MmpExamRecordVo> queryList(MmpExamRecordBo bo);

    /**
     * 新增资质考试记录
     *
     * @param bo 资质考试记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpExamRecordBo bo);

    /**
     * 修改资质考试记录
     *
     * @param bo 资质考试记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpExamRecordBo bo);

    /**
     * 校验并批量删除资质考试记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
