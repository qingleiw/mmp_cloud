package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB151OutpatientExpenseRecord;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB151OutpatientExpenseRecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB151OutpatientExpenseRecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B15-1 门诊收费记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB151OutpatientExpenseRecordService {

    /**
     * 查询B15-1 门诊收费记录
     *
     * @param id 主键
     * @return B15-1 门诊收费记录
     */
    MmpNatdssB151OutpatientExpenseRecordVo queryById(Long id);

    /**
     * 分页查询B15-1 门诊收费记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B15-1 门诊收费记录分页列表
     */
    TableDataInfo<MmpNatdssB151OutpatientExpenseRecordVo> queryPageList(MmpNatdssB151OutpatientExpenseRecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B15-1 门诊收费记录列表
     *
     * @param bo 查询条件
     * @return B15-1 门诊收费记录列表
     */
    List<MmpNatdssB151OutpatientExpenseRecordVo> queryList(MmpNatdssB151OutpatientExpenseRecordBo bo);

    /**
     * 新增B15-1 门诊收费记录
     *
     * @param bo B15-1 门诊收费记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB151OutpatientExpenseRecordBo bo);

    /**
     * 修改B15-1 门诊收费记录
     *
     * @param bo B15-1 门诊收费记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB151OutpatientExpenseRecordBo bo);

    /**
     * 校验并批量删除B15-1 门诊收费记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
