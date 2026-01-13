package org.dromara.cdi.mmp.ledger.domain.bo;

import org.dromara.cdi.mmp.ledger.domain.MmpLedgerMajorSurgery;
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
 * 重大疑难手术监测与管理业务对象 mmp_ledger_major_surgery
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpLedgerMajorSurgery.class, reverseConvertGenerate = false)
public class MmpLedgerMajorSurgeryBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

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
     * 手术日期
     */
    @NotNull(message = "手术日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date operationDate;

    /**
     * 手术科室
     */
    private String department;

    /**
     * 主刀医师
     */
    private String surgeon;

    /**
     * 手术名称
     */
    @NotBlank(message = "手术名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String operationName;

    /**
     * 手术等级
     */
    private String operationLevel;

    /**
     * 术前诊断
     */
    private String preoperativeDiagnosis;

    /**
     * 术后诊断
     */
    private String postoperativeDiagnosis;

    /**
     * 手术时长(分钟)
     */
    private Long operationDuration;

    /**
     * 麻醉方式
     */
    private String anesthesiaMethod;

    /**
     * 术中并发症
     */
    private String complications;

    /**
     * 手术结局
     */
    private String outcome;

    /**
     * 随访结果
     */
    private String followUpResults;

    /**
     * 医疗评价
     */
    private String medicalEvaluation;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
