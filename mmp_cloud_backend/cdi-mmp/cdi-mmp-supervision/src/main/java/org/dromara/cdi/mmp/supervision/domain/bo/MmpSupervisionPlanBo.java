package org.dromara.cdi.mmp.supervision.domain.bo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionPlan;
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
 * 督查计划业务对象 mmp_supervision_plan
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSupervisionPlan.class, reverseConvertGenerate = false)
public class MmpSupervisionPlanBo extends BaseEntity {

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
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long projectId;

    /**
     * 计划类型
     */
    private String planType;

    /**
     * 督导周期
     */
    private String supervisionPeriod;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    /**
     * 负责人
     */
    private String responsiblePerson;

    /**
     * 状态：draft-草稿，published-已发布，executing-执行中，completed-已完成
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
