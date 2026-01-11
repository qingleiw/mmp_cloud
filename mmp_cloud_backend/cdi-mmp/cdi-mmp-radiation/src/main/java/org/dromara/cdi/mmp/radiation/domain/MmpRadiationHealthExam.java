package org.dromara.cdi.mmp.radiation.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 职业健康体检对象 mmp_radiation_health_exam
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_radiation_health_exam")
public class MmpRadiationHealthExam extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 工作人员ID
     */
    private Long workerId;

    /**
     * 体检日期
     */
    private Date examDate;

    /**
     * 体检类型
     */
    private String examType;

    /**
     * 体检医院
     */
    private String examHospital;

    /**
     * 体检医生
     */
    private String examDoctor;

    /**
     * 体检结果
     */
    private String examResults;

    /**
     * 诊断结果
     */
    private String diagnosis;

    /**
     * 建议
     */
    private String recommendations;

    /**
     * 需要随访：0-否，1-是
     */
    private String followUpRequired;

    /**
     * 下次体检日期
     */
    private Date nextExamDate;

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
