package org.dromara.cdi.mmp.tumorqc.domain.bo;

import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcPlan;
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
 * 肿瘤质控方案业务对象 mmp_tumor_qc_plan
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpTumorQcPlan.class, reverseConvertGenerate = false)
public class MmpTumorQcPlanBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 方案编码
     */
    @NotBlank(message = "方案编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String planCode;

    /**
     * 方案名称
     */
    @NotBlank(message = "方案名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String planName;

    /**
     * 方案类型
     */
    private String planType;

    /**
     * 方案描述
     */
    private String description;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    /**
     * 状态（0正常 1停用）
     */
    private String status;

    /**
     * 审批状态（0待审批 1已审批 2驳回）
     */
    private String approvalStatus;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
