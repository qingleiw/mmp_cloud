package org.dromara.cdi.mmp.qualification.domain.vo;

import org.dromara.cdi.mmp.qualification.domain.MmpQualificationAuthorizationApply;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 资质授权申请视图对象 mmp_qualification_authorization_apply
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQualificationAuthorizationApply.class)
public class MmpQualificationAuthorizationApplyVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 申请单号
     */
    @ExcelProperty(value = "申请单号")
    private String applyNo;

    /**
     * 申请人ID
     */
    @ExcelProperty(value = "申请人ID")
    private Long applicantId;

    /**
     * 申请人姓名
     */
    @ExcelProperty(value = "申请人姓名")
    private String applicantName;

    /**
     * 申请人类型 医师/医技
     */
    @ExcelProperty(value = "申请人类型 医师/医技")
    private String applicantType;

    /**
     * 科室ID
     */
    @ExcelProperty(value = "科室ID")
    private Long departmentId;

    /**
     * 科室名称
     */
    @ExcelProperty(value = "科室名称")
    private String departmentName;

    /**
     * 资质ID列表(逗号分隔)
     */
    @ExcelProperty(value = "资质ID列表(逗号分隔)")
    private String qualificationIds;

    /**
     * 申请理由
     */
    @ExcelProperty(value = "申请理由")
    private String applyReason;

    /**
     * 关联证书ID
     */
    @ExcelProperty(value = "关联证书ID")
    private String certificateIds;

    /**
     * 考核成绩
     */
    @ExcelProperty(value = "考核成绩")
    private Long examScore;

    /**
     * 工作量数据JSON
     */
    @ExcelProperty(value = "工作量数据JSON")
    private String workQuantity;

    /**
     * 工作质量数据JSON
     */
    @ExcelProperty(value = "工作质量数据JSON")
    private String workQuality;

    /**
     * 申请状态
     */
    @ExcelProperty(value = "申请状态")
    private String applyStatus;

    /**
     * 当前审批节点
     */
    @ExcelProperty(value = "当前审批节点")
    private String currentNode;

    /**
     * 工作流实例ID
     */
    @ExcelProperty(value = "工作流实例ID")
    private Long workflowInstanceId;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
