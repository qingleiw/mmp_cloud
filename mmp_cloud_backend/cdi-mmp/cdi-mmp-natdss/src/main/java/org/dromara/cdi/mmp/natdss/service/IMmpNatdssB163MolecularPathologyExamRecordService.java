package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB163MolecularPathologyExamRecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB163MolecularPathologyExamRecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B163 分子病理检测记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB163MolecularPathologyExamRecordService {

    /**
     * 查询B163 分子病理检测记录
     *
     * @param id 主键
     * @return B163 分子病理检测记录
     */
    MmpNatdssB163MolecularPathologyExamRecordVo queryById(Long id);

    /**
     * 分页查询B163 分子病理检测记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B163 分子病理检测记录分页列表
     */
    TableDataInfo<MmpNatdssB163MolecularPathologyExamRecordVo> queryPageList(MmpNatdssB163MolecularPathologyExamRecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B163 分子病理检测记录列表
     *
     * @param bo 查询条件
     * @return B163 分子病理检测记录列表
     */
    List<MmpNatdssB163MolecularPathologyExamRecordVo> queryList(MmpNatdssB163MolecularPathologyExamRecordBo bo);

    /**
     * 新增B163 分子病理检测记录
     *
     * @param bo B163 分子病理检测记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB163MolecularPathologyExamRecordBo bo);

    /**
     * 修改B163 分子病理检测记录
     *
     * @param bo B163 分子病理检测记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB163MolecularPathologyExamRecordBo bo);

    /**
     * 校验并批量删除B163 分子病理检测记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
