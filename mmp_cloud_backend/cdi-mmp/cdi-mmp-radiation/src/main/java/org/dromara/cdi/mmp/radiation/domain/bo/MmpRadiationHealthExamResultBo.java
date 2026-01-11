package org.dromara.cdi.mmp.radiation.domain.bo;

import org.dromara.cdi.mmp.radiation.domain.MmpRadiationHealthExamResult;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 体检结果记录业务对象 mmp_radiation_health_exam_result
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpRadiationHealthExamResult.class, reverseConvertGenerate = false)
public class MmpRadiationHealthExamResultBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 体检计划ID
     */
    @NotNull(message = "体检计划ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long planId;

    /**
     * 工作人员ID
     */
    @NotNull(message = "工作人员ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long staffId;

    /**
     * 工作人员姓名
     */
    private String staffName;

    /**
     * 体检日期
     */
    @NotNull(message = "体检日期不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 备注
     */
    private String remark;


}
