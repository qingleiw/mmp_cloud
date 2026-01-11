package org.dromara.cdi.mmp.radiation.domain.bo;

import org.dromara.cdi.mmp.radiation.domain.MmpRadiationHealthExamPlan;
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
 * 职业健康体检计划业务对象 mmp_radiation_health_exam_plan
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpRadiationHealthExamPlan.class, reverseConvertGenerate = false)
public class MmpRadiationHealthExamPlanBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 计划编码
     */
    @NotBlank(message = "计划编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String planCode;

    /**
     * 计划名称
     */
    @NotBlank(message = "计划名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String planName;

    /**
     * 体检类型：annual-年度体检，special-专项体检
     */
    private String examType;

    /**
     * 计划日期
     */
    @NotNull(message = "计划日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date plannedDate;

    /**
     * 体检地点
     */
    private String location;

    /**
     * 体检机构
     */
    private String examAgency;

    /**
     * 体检对象
     */
    private String targetStaff;

    /**
     * 状态：planned-已计划，ongoing-进行中，completed-已完成，cancelled-已取消
     */
    private String status;

    /**
     * 是否已发送提醒：0-否，1-是
     */
    private String reminderSent;

    /**
     * 提醒时间
     */
    private Date reminderTime;

    /**
     * 备注
     */
    private String remark;


}
