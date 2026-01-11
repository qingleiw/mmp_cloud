package org.dromara.cdi.mmp.tumorqc.domain.bo;

import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcInspection;
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
 * 肿瘤质控检查业务对象 mmp_tumor_qc_inspection
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpTumorQcInspection.class, reverseConvertGenerate = false)
public class MmpTumorQcInspectionBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 检查编码
     */
    @NotBlank(message = "检查编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String inspectionCode;

    /**
     * 关联方案ID
     */
    private Long planId;

    /**
     * 检查日期
     */
    @NotNull(message = "检查日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date inspectionDate;

    /**
     * 检查人ID
     */
    private Long inspectorId;

    /**
     * 检查人姓名
     */
    private String inspectorName;

    /**
     * 检查科室ID
     */
    private Long departmentId;

    /**
     * 检查科室名称
     */
    private String departmentName;

    /**
     * 检查类型
     */
    private String inspectionType;

    /**
     * 检查结果
     */
    private String inspectionResult;

    /**
     * 问题描述
     */
    private String problemDescription;

    /**
     * 整改建议
     */
    private String suggestion;

    /**
     * 状态（0待整改 1已整改）
     */
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
