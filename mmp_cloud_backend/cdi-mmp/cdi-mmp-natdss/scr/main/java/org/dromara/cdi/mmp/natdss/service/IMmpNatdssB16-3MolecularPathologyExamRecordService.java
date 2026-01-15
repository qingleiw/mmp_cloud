package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB16-3MolecularPathologyExamRecord;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB16-3MolecularPathologyExamRecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB16-3MolecularPathologyExamRecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B16-3 分子病理检测记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB16-3MolecularPathologyExamRecordService {

    /**
     * 查询B16-3 分子病理检测记录
     *
     * @param id 主键
     * @return B16-3 分子病理检测记录
     */
    MmpNatdssB16-3MolecularPathologyExamRecordVo queryById(Long id);

    /**
     * 分页查询B16-3 分子病理检测记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B16-3 分子病理检测记录分页列表
     */
    TableDataInfo<MmpNatdssB16-3MolecularPathologyExamRecordVo> queryPageList(MmpNatdssB16-3MolecularPathologyExamRecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B16-3 分子病理检测记录列表
     *
     * @param bo 查询条件
     * @return B16-3 分子病理检测记录列表
     */
    List<MmpNatdssB16-3MolecularPathologyExamRecordVo> queryList(MmpNatdssB16-3MolecularPathologyExamRecordBo bo);

    /**
     * 新增B16-3 分子病理检测记录
     *
     * @param bo B16-3 分子病理检测记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB16-3MolecularPathologyExamRecordBo bo);

    /**
     * 修改B16-3 分子病理检测记录
     *
     * @param bo B16-3 分子病理检测记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB16-3MolecularPathologyExamRecordBo bo);

    /**
     * 校验并批量删除B16-3 分子病理检测记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
