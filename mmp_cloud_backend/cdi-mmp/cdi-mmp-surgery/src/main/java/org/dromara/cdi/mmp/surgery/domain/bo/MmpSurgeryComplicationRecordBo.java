package org.dromara.cdi.mmp.surgery.domain.bo;

import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryComplicationRecord;
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
 * 手术并发症记录业务对象 mmp_surgery_complication_record
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSurgeryComplicationRecord.class, reverseConvertGenerate = false)
public class MmpSurgeryComplicationRecordBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 手术记录ID（HIS系统ID）
     */
    @NotBlank(message = "手术记录ID（HIS系统ID）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String surgeryRecordId;

    /**
     * 医师ID
     */
    @NotNull(message = "医师ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long doctorId;

    /**
     * 医师姓名
     */
    private String doctorName;

    /**
     * 患者ID
     */
    @NotBlank(message = "患者ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String patientId;

    /**
     * 手术编码
     */
    @NotBlank(message = "手术编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String surgeryCode;

    /**
     * 手术名称
     */
    @NotBlank(message = "手术名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String surgeryName;

    /**
     * 并发症类型
     */
    @NotBlank(message = "并发症类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String complicationType;

    /**
     * 并发症描述
     */
    private String complicationDescription;

    /**
     * 并发症等级
     */
    private String complicationLevel;

    /**
     * 发生时间
     */
    @NotNull(message = "发生时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date occurrenceTime;

    /**
     * 是否为非计划二次手术
     */
    private Long isPlannedSecondary;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
