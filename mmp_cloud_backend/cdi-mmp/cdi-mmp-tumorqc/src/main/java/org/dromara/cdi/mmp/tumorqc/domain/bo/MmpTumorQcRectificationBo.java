package org.dromara.cdi.mmp.tumorqc.domain.bo;

import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcRectification;
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
 * 肿瘤质控整改业务对象 mmp_tumor_qc_rectification
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpTumorQcRectification.class, reverseConvertGenerate = false)
public class MmpTumorQcRectificationBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 整改编码
     */
    @NotBlank(message = "整改编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String rectificationCode;

    /**
     * 关联检查ID
     */
    private Long inspectionId;

    /**
     * 问题描述
     */
    private String problemDescription;

    /**
     * 整改措施
     */
    private String rectificationMeasures;

    /**
     * 负责人ID
     */
    private Long responsiblePersonId;

    /**
     * 负责人姓名
     */
    private String responsiblePersonName;

    /**
     * 整改期限
     */
    private Date deadline;

    /**
     * 完成时间
     */
    private Date completionTime;

    /**
     * 整改结果
     */
    private String rectificationResult;

    /**
     * 验证状态（0待验证 1已验证）
     */
    private String verificationStatus;

    /**
     * 状态（0进行中 1已完成）
     */
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
