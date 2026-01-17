package org.dromara.cdi.mmp.natdss.domain.bo;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB071EmrDischarge;
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
 * B07-1 出院记录业务对象 mmp_natdss_b07_1_emr_discharge
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNatdssB071EmrDischarge.class, reverseConvertGenerate = false)
public class MmpNatdssB071EmrDischargeBo extends BaseEntity {

    /**
     * 系统自增主键
     */
    @NotNull(message = "系统自增主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 患者ID
     */
    @NotBlank(message = "患者ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String patientId;

    /**
     * 单次就诊唯一标识号
     */
    @NotBlank(message = "单次就诊唯一标识号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String visitSn;

    /**
     * 病案号
     */
    private String medicalRecordNo;

    /**
     * 住院号
     */
    private String inpatientNo;

    /**
     * 住院次数
     */
    private String hospitalizationTimes;

    /**
     * 出院记录流水号
     */
    @NotBlank(message = "出院记录流水号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String recordSn;

    /**
     * 出院记录创建时间
     */
    private Date recordDatetime;

    /**
     * 入院时间
     */
    private Date admissionDatetime;

    /**
     * 出院医嘱
     */
    private String dischargeOrder;

    /**
     * 出院时间
     */
    private Date dischargeDatetime;

    /**
     * 实际住院天数
     */
    private Long lengthOfStay;

    /**
     * KPS评分
     */
    private String kpsScore;

    /**
     * ECOG PS评分
     */
    private String ecogScore;

    /**
     * 文书内容
     */
    private String recordText;

    /**
     * 入院情况
     */
    private String admissionCondition;

    /**
     * 诊疗经过
     */
    private String treatmentInfo;

    /**
     * 出院情况
     */
    private String dischargeCondition;

    /**
     * 入院主要诊断编码
     */
    private String admissionMaindiagCode1;

    /**
     * 入院主要诊断名称
     */
    private String admissionMaindiagName1;

    /**
     * 入院诊断编码-2
     */
    private String admissionDiagCode2;

    /**
     * 入院诊断名称-2
     */
    private String admissionDiagName2;

    /**
     * 入院诊断编码-3
     */
    private String admissionDiagCode3;

    /**
     * 入院诊断名称-3
     */
    private String admissionDiagName3;

    /**
     * 入院诊断编码-4
     */
    private String admissionDiagCode4;

    /**
     * 入院诊断名称-4
     */
    private String admissionDiagName4;

    /**
     * 入院诊断编码-5
     */
    private String admissionDiagCode5;

    /**
     * 入院诊断名称-5
     */
    private String admissionDiagName5;

    /**
     * 入院诊断编码-N
     */
    private String admissionDiagCoden;

    /**
     * 入院诊断名称-N
     */
    private String admissionDiagNamen;

    /**
     * 出院主要诊断编码
     */
    private String dischargeMaindiagCode1;

    /**
     * 出院主要诊断名称
     */
    private String dischargeMaindiagName1;

    /**
     * 出院诊断编码-2
     */
    private String dischargeDiagCode2;

    /**
     * 出院诊断名称-2
     */
    private String dischargeDiagName2;

    /**
     * 出院诊断编码-3
     */
    private String dischargeDiagCode3;

    /**
     * 出院诊断名称-3
     */
    private String dischargeDiagName3;

    /**
     * 出院诊断编码-4
     */
    private String dischargeDiagCode4;

    /**
     * 出院诊断名称-4
     */
    private String dischargeDiagName4;

    /**
     * 出院诊断编码-5
     */
    private String dischargeDiagCode5;

    /**
     * 出院诊断名称-5
     */
    private String dischargeDiagName5;

    /**
     * 出院诊断编码-N
     */
    private String dischargeDiagCoden;

    /**
     * 出院诊断名称-N
     */
    private String dischargeDiagNamen;

    /**
     * 扩展字段1
     */
    private String extendData1;

    /**
     * 扩展字段2
     */
    private String extendData2;

    /**
     * 记录状态:1正常 0作废
     */
    private Long recordStatus;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;


}
