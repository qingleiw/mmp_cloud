package org.dromara.cdi.mmp.radiation.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 体检结果记录对象 mmp_radiation_health_exam_result
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_radiation_health_exam_result")
public class MmpRadiationHealthExamResult extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 体检计划ID
     */
    private Long planId;

    /**
     * 工作人员ID
     */
    private Long staffId;

    /**
     * 工作人员姓名
     */
    private String staffName;

    /**
     * 体检日期
     */
    private Date examDate;

    /**
     * 体检结果：normal-正常，abnormal-异常
     */
    private String examResult;

    /**
     * 体检报告文件路径
     */
    private String examReportFile;

    /**
     * 体检报告文件名
     */
    private String examReportName;

    /**
     * 主要发现
     */
    private String keyFindings;

    /**
     * 建议措施
     */
    private String recommendations;

    /**
     * 是否需要随访：0-否，1-是
     */
    private String followUpRequired;

    /**
     * 随访日期
     */
    private Date followUpDate;

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
