package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB162PathologicalExamRecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB162PathologicalExamRecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B162 病理检查记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB162PathologicalExamRecordService {

    /**
     * 查询B162 病理检查记录
     *
     * @param id 主键
     * @return B162 病理检查记录
     */
    MmpNatdssB162PathologicalExamRecordVo queryById(Long id);

    /**
     * 分页查询B162 病理检查记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B162 病理检查记录分页列表
     */
    TableDataInfo<MmpNatdssB162PathologicalExamRecordVo> queryPageList(MmpNatdssB162PathologicalExamRecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B162 病理检查记录列表
     *
     * @param bo 查询条件
     * @return B162 病理检查记录列表
     */
    List<MmpNatdssB162PathologicalExamRecordVo> queryList(MmpNatdssB162PathologicalExamRecordBo bo);

    /**
     * 新增B162 病理检查记录
     *
     * @param bo B162 病理检查记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB162PathologicalExamRecordBo bo);

    /**
     * 修改B162 病理检查记录
     *
     * @param bo B162 病理检查记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB162PathologicalExamRecordBo bo);

    /**
     * 校验并批量删除B162 病理检查记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
