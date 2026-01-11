package org.dromara.cdi.mmp.ntp.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 新技术病例登记对象 mmp_new_technology_project_case
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_new_technology_project_case")
public class MmpNewTechnologyProjectCase extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 患者ID
     */
    private Long patientId;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 就诊类型 门诊/住院
     */
    private String visitType;

    /**
     * 就诊号
     */
    private String visitNo;

    /**
     * 就诊日期
     */
    private Date visitDate;

    /**
     * 就诊科室ID
     */
    private Long visitDepartmentId;

    /**
     * 就诊科室名称
     */
    private String visitDepartmentName;

    /**
     * 诊断
     */
    private String diagnosis;

    /**
     * 操作医生
     */
    private String operator;

    /**
     * 操作时间
     */
    private Date operationDate;

    /**
     * 效果评价
     */
    private String effectEvaluation;

    /**
     * 并发症
     */
    private String complication;

    /**
     * 不良反应
     */
    private String adverseReaction;

    /**
     * 随访状态
     */
    private String followUpStatus;

    /**
     * 随访结果
     */
    private String followUpResult;

    /**
     * 是否已报备 1-是 0-否
     */
    private Long isReported;

    /**
     * 报备时间
     */
    private Date reportTime;

    /**
     * 是否删除
     */
    @TableLogic
    private String delFlag;

    /**
     * 备注
     */
    private String remark;


}
