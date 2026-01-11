package org.dromara.cdi.mmp.emergency.domain.bo;

import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyPlan;
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
 * 应急预案业务对象 mmp_emergency_plan
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpEmergencyPlan.class, reverseConvertGenerate = false)
public class MmpEmergencyPlanBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 预案编码
     */
    @NotBlank(message = "预案编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String planCode;

    /**
     * 预案名称
     */
    @NotBlank(message = "预案名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String planName;

    /**
     * 预案类型：fire-消防预案，medical-医疗应急预案，disaster-灾害预案，infection-感染控制预案
     */
    private String planType;

    /**
     * 状态：draft-草稿，review-审核中，approved-已批准，archived-已归档
     */
    private String status;

    /**
     * 生效日期
     */
    private Date effectiveDate;

    /**
     * 审核日期
     */
    private Date reviewDate;

    /**
     * 下次审核日期
     */
    private Date nextReviewDate;

    /**
     * 关键词
     */
    private String keywords;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 上传者
     */
    private String uploadBy;

    /**
     * 上传时间
     */
    private Date uploadTime;

    /**
     * 批准人
     */
    private String approveBy;

    /**
     * 批准时间
     */
    private Date approveTime;

    /**
     * 备注
     */
    private String remark;


}
