package org.dromara.cdi.mmp.natdss.domain.bo;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB191FollowUp;
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
 * B19-1 随访记录业务对象 mmp_natdss_b19_1_follow_up
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNatdssB191FollowUp.class, reverseConvertGenerate = false)
public class MmpNatdssB191FollowUpBo extends BaseEntity {

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
    private String visitSn;

    /**
     * 就诊类型:住院、门诊
     */
    private String visitType;

    /**
     * 就诊卡号
     */
    private String visitCardNo;

    /**
     * 门诊号
     */
    private String outpatientNo;

    /**
     * 病案号
     */
    private String medicalRecordNo;

    /**
     * 住院号
     */
    private String inpatientNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄(岁)
     */
    private Long age;

    /**
     * 出生日期
     */
    private Date dateOfBirth;

    /**
     * 随访流水号
     */
    @NotBlank(message = "随访流水号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String followupSn;

    /**
     * 随访方式
     */
    private String followupMethod;

    /**
     * 初治年龄
     */
    private Long firstTreatAge;

    /**
     * 初治日期
     */
    private Date firstTreatDatetime;

    /**
     * 随访周期
     */
    private String followupPeriod;

    /**
     * 随访日期
     */
    private Date followupDatetime;

    /**
     * 随访状态代码
     */
    private String followupStatusCode;

    /**
     * 随访状态
     */
    private String followupStatus;

    /**
     * 身体状况
     */
    private String healthStatus;

    /**
     * 死亡日期
     */
    private Date deathDatetime;

    /**
     * 死亡原因
     */
    private String causeOfDeath;

    /**
     * 复发日期
     */
    private Date recurDatetime;

    /**
     * 复发诊断编码
     */
    private String recurDiagCode;

    /**
     * 复发诊断名称
     */
    private String recurDiagName;

    /**
     * 首次复发转移日期
     */
    private Date firstRecurMetsDate;

    /**
     * 转移日期
     */
    private Date metsDatetime;

    /**
     * 转移部位
     */
    private String metsSite;

    /**
     * 转移诊断编码
     */
    private String metsDiagCode;

    /**
     * 转移诊断名称
     */
    private String metsDiagName;

    /**
     * 多原发诊断编码
     */
    private String mulpriDiagCode;

    /**
     * 多原发诊断名称
     */
    private String mulpriDiagName;

    /**
     * 随访结论
     */
    private String followupConclusion;

    /**
     * 证件类型
     */
    private String certificateType;

    /**
     * 证件号码
     */
    private String certificateNo;

    /**
     * 现住址
     */
    private String currentAddress;

    /**
     * 联系电话
     */
    private String phoneNo;

    /**
     * 联系电话2
     */
    private String phoneNo2;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 微信
     */
    private String weixin;

    /**
     * 紧急联系人1
     */
    private String contactPerson1;

    /**
     * 紧急联系人电话1
     */
    private String contactPhoneNo1;

    /**
     * 紧急联系人2
     */
    private String contactPerson2;

    /**
     * 紧急联系人电话2
     */
    private String contactPhoneNo2;

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
     * 不良反应
     */
    private String adverseReaction;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;


}
