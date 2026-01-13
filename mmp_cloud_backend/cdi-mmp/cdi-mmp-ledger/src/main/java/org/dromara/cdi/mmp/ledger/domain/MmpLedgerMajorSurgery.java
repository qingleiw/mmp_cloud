package org.dromara.cdi.mmp.ledger.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 重大疑难手术监测与管理对象 mmp_ledger_major_surgery
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_ledger_major_surgery")
public class MmpLedgerMajorSurgery extends TenantEntity {

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
     * 手术日期
     */
    private Date operationDate;

    /**
     * 手术科室
     */
    private String department;

    /**
     * 主刀医师
     */
    private String surgeon;

    /**
     * 手术名称
     */
    private String operationName;

    /**
     * 手术等级
     */
    private String operationLevel;

    /**
     * 术前诊断
     */
    private String preoperativeDiagnosis;

    /**
     * 术后诊断
     */
    private String postoperativeDiagnosis;

    /**
     * 手术时长(分钟)
     */
    private Long operationDuration;

    /**
     * 麻醉方式
     */
    private String anesthesiaMethod;

    /**
     * 术中并发症
     */
    private String complications;

    /**
     * 手术结局
     */
    private String outcome;

    /**
     * 随访结果
     */
    private String followUpResults;

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
