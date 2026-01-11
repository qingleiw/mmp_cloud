package org.dromara.cdi.mmp.surgery.service;

import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryApprovalFormVo;
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryApprovalFormBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 重大手术审批报告单Service接口
 *
 * @author Lion Li
 * @date 2025-12-28
 */
public interface IMmpSurgeryApprovalFormService {

    /**
     * 查询重大手术审批报告单
     *
     * @param id 主键
     * @return 重大手术审批报告单
     */
    MmpSurgeryApprovalFormVo queryById(Long id);

    /**
     * 分页查询重大手术审批报告单列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 重大手术审批报告单分页列表
     */
    TableDataInfo<MmpSurgeryApprovalFormVo> queryPageList(MmpSurgeryApprovalFormBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的重大手术审批报告单列表
     *
     * @param bo 查询条件
     * @return 重大手术审批报告单列表
     */
    List<MmpSurgeryApprovalFormVo> queryList(MmpSurgeryApprovalFormBo bo);

    /**
     * 新增重大手术审批报告单
     *
     * @param bo 重大手术审批报告单
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSurgeryApprovalFormBo bo);

    /**
     * 修改重大手术审批报告单
     *
     * @param bo 重大手术审批报告单
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSurgeryApprovalFormBo bo);

    /**
     * 校验并批量删除重大手术审批报告单信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
