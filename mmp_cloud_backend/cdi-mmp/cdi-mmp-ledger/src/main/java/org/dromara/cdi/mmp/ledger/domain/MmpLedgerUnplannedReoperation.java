package org.dromara.cdi.mmp.ledger.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 非计划再次手术登记本对象 mmp_ledger_unplanned_reoperation
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_ledger_unplanned_reoperation")
public class MmpLedgerUnplannedReoperation extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 患者ID
     */
    private String patientId;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 第一次手术日期
     */
    private Date firstOperationDate;

    /**
     * 再次手术日期
     */
    private Date reoperationDate;

    /**
     * 手术科室
     */
    private String department;

    /**
     * 手术医师
     */
    private String surgeon;

    /**
     * 第一次手术名称
     */
    private String firstOperationName;

    /**
     * 再次手术名称
     */
    private String reoperationName;

    /**
     * 再次手术原因
     */
    private String reoperationReason;

    /**
     * 并发症
     */
    private String complications;

    /**
     * 医疗评价
     */
    private String medicalEvaluation;

    /**
     * 状态
     */
    private String status;

    /**
     * 是否删除
     */
    @TableLogic
    private Long delFlag;

    /**
     * 备注
     */
    private String remark;


}
