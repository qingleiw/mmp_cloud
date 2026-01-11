package org.dromara.cdi.mmp.emergency.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyPlanApproval;
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
 * 应急预案审批视图对象 mmp_emergency_plan_approval
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpEmergencyPlanApproval.class)
public class MmpEmergencyPlanApprovalVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 审批阶段
     */
    @ExcelProperty(value = "审批阶段")
    private String approvalStage;

    /**
     * 审批人姓名
     */
    @ExcelProperty(value = "审批人姓名")
    private String approverName;

    /**
     * 审批意见
     */
    @ExcelProperty(value = "审批意见")
    private String approvalOpinion;

    /**
     * 审批结果：approved-通过，rejected-驳回
     */
    @ExcelProperty(value = "审批结果：approved-通过，rejected-驳回")
    private String approvalResult;

    /**
     * 审批时间
     */
    @ExcelProperty(value = "审批时间")
    private Date approvalTime;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
