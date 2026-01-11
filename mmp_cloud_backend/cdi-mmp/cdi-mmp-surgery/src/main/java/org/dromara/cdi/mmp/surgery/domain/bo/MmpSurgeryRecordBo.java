package org.dromara.cdi.mmp.surgery.domain.bo;

import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryRecord;
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
 * 手术记录业务对象 mmp_surgery_record
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSurgeryRecord.class, reverseConvertGenerate = false)
public class MmpSurgeryRecordBo extends BaseEntity {

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
     * 手术申请ID
     */
    private Long applicationId;

    /**
     * 患者ID
     */
    @NotBlank(message = "患者ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String patientId;

    /**
     * 患者姓名
     */
    @NotBlank(message = "患者姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String patientName;

    /**
     * 主刀医生ID
     */
    @NotNull(message = "主刀医生ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long doctorId;

    /**
     * 主刀医生姓名
     */
    @NotBlank(message = "主刀医生姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String doctorName;

    /**
     * 手术科室ID
     */
    @NotNull(message = "手术科室ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long departmentId;

    /**
     * 手术科室名称
     */
    @NotBlank(message = "手术科室名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String departmentName;

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
     * 手术等级
     */
    private String surgeryLevel;

    /**
     * 手术类型
     */
    private String surgeryType;

    /**
     * 麻醉方式
     */
    private String anesthesiaMethod;

    /**
     * 手术开始时间
     */
    @NotNull(message = "手术开始时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date surgeryStartTime;

    /**
     * 手术结束时间
     */
    private Date surgeryEndTime;

    /**
     * 手术时长(分钟)
     */
    private Long surgeryDuration;

    /**
     * ASA分级
     */
    private String asaGrade;

    /**
     * 失血量(ml)
     */
    private Long bloodLoss;

    /**
     * 手术状态
     */
    private String surgeryStatus;

    /**
     * 是否有并发症
     */
    private Long complicationFlag;

    /**
     * 删除标志
     */
    private String delFlag;


}
