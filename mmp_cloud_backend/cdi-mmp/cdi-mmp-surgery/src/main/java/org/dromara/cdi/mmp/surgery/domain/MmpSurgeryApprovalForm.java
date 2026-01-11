package org.dromara.cdi.mmp.surgery.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 重大手术审批报告单对象 mmp_surgery_approval_form
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_surgery_approval_form")
public class MmpSurgeryApprovalForm extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 申报科室
     */
    private String deptName;

    /**
     * 申报日期
     */
    private String reportDate;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private Long age;

    /**
     * 住院号
     */
    private String hospitalNumber;

    /**
     * 术前诊断
     */
    private String preoperativeDiagnosis;

    /**
     * 手术名称
     */
    private String surgeryName;

    /**
     * 手术级别
     */
    private String surgeryLevel;

    /**
     * 麻醉方式
     */
    private String anesthesiaMethod;

    /**
     * 术者及职称
     */
    private String surgeon;

    /**
     * 助手及职称
     */
    private String assistant;

    /**
     * 术前讨论结果
     */
    private String discussionResult;

    /**
     * 报告医师
     */
    private String reportingPhysician;

    /**
     * 报告日期
     */
    private String reportingDate;

    /**
     * 患者或授权委托人知情同意情况
     */
    private String informedConsent;

    /**
     * 科室主任签字
     */
    private String departmentDirector;

    /**
     * 科室签字日期
     */
    private String departmentDate;

    /**
     * 医务部主任签字
     */
    private String medicalDirector;

    /**
     * 审批状态
     */
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private Long delFlag;


}
