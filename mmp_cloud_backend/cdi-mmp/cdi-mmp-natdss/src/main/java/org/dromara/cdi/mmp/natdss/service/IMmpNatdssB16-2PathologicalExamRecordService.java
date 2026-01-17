package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB16-2PathologicalExamRecord;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB16-2PathologicalExamRecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB16-2PathologicalExamRecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B16-2 病理检查记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB16-2PathologicalExamRecordService {

    /**
     * 查询B16-2 病理检查记录
     *
     * @param id 主键
     * @return B16-2 病理检查记录
     */
    MmpNatdssB16-2PathologicalExamRecordVo queryById(Long id);

    /**
     * 分页查询B16-2 病理检查记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B16-2 病理检查记录分页列表
     */
    TableDataInfo<MmpNatdssB16-2PathologicalExamRecordVo> queryPageList(MmpNatdssB16-2PathologicalExamRecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B16-2 病理检查记录列表
     *
     * @param bo 查询条件
     * @return B16-2 病理检查记录列表
     */
    List<MmpNatdssB16-2PathologicalExamRecordVo> queryList(MmpNatdssB16-2PathologicalExamRecordBo bo);

    /**
     * 新增B16-2 病理检查记录
     *
     * @param bo B16-2 病理检查记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB16-2PathologicalExamRecordBo bo);

    /**
     * 修改B16-2 病理检查记录
     *
     * @param bo B16-2 病理检查记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB16-2PathologicalExamRecordBo bo);

    /**
     * 校验并批量删除B16-2 病理检查记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
