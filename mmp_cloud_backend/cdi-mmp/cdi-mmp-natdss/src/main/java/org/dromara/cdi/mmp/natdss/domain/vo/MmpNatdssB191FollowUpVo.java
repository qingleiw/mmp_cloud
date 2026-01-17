package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB191FollowUp;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * B19-1 随访记录视图对象 mmp_natdss_b19_1_follow_up
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB191FollowUp.class)
public class MmpNatdssB191FollowUpVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统自增主键
     */
    @ExcelProperty(value = "系统自增主键")
    private Long id;

    /**
     * 患者ID
     */
    @ExcelProperty(value = "患者ID")
    private String patientId;

    /**
     * 单次就诊唯一标识号
     */
    @ExcelProperty(value = "单次就诊唯一标识号")
    private String visitSn;

    /**
     * 就诊类型:住院、门诊
     */
    @ExcelProperty(value = "就诊类型:住院、门诊")
    private String visitType;

    /**
     * 就诊卡号
     */
    @ExcelProperty(value = "就诊卡号")
    private String visitCardNo;

    /**
     * 门诊号
     */
    @ExcelProperty(value = "门诊号")
    private String outpatientNo;

    /**
     * 病案号
     */
    @ExcelProperty(value = "病案号")
    private String medicalRecordNo;

    /**
     * 住院号
     */
    @ExcelProperty(value = "住院号")
    private String inpatientNo;

    /**
     * 姓名
     */
    @ExcelProperty(value = "姓名")
    private String name;

    /**
     * 性别
     */
    @ExcelProperty(value = "性别")
    private String gender;

    /**
     * 年龄(岁)
     */
    @ExcelProperty(value = "年龄(岁)")
    private Long age;

    /**
     * 出生日期
     */
    @ExcelProperty(value = "出生日期")
    private Date dateOfBirth;

    /**
     * 随访流水号
     */
    @ExcelProperty(value = "随访流水号")
    private String followupSn;

    /**
     * 随访方式
     */
    @ExcelProperty(value = "随访方式")
    private String followupMethod;

    /**
     * 初治年龄
     */
    @ExcelProperty(value = "初治年龄")
    private Long firstTreatAge;

    /**
     * 初治日期
     */
    @ExcelProperty(value = "初治日期")
    private Date firstTreatDatetime;

    /**
     * 随访周期
     */
    @ExcelProperty(value = "随访周期")
    private String followupPeriod;

    /**
     * 随访日期
     */
    @ExcelProperty(value = "随访日期")
    private Date followupDatetime;

    /**
     * 随访状态代码
     */
    @ExcelProperty(value = "随访状态代码")
    private String followupStatusCode;

    /**
     * 随访状态
     */
    @ExcelProperty(value = "随访状态")
    private String followupStatus;

    /**
     * 身体状况
     */
    @ExcelProperty(value = "身体状况")
    private String healthStatus;

    /**
     * 死亡日期
     */
    @ExcelProperty(value = "死亡日期")
    private Date deathDatetime;

    /**
     * 死亡原因
     */
    @ExcelProperty(value = "死亡原因")
    private String causeOfDeath;

    /**
     * 复发日期
     */
    @ExcelProperty(value = "复发日期")
    private Date recurDatetime;

    /**
     * 复发诊断编码
     */
    @ExcelProperty(value = "复发诊断编码")
    private String recurDiagCode;

    /**
     * 复发诊断名称
     */
    @ExcelProperty(value = "复发诊断名称")
    private String recurDiagName;

    /**
     * 首次复发转移日期
     */
    @ExcelProperty(value = "首次复发转移日期")
    private Date firstRecurMetsDate;

    /**
     * 转移日期
     */
    @ExcelProperty(value = "转移日期")
    private Date metsDatetime;

    /**
     * 转移部位
     */
    @ExcelProperty(value = "转移部位")
    private String metsSite;

    /**
     * 转移诊断编码
     */
    @ExcelProperty(value = "转移诊断编码")
    private String metsDiagCode;

    /**
     * 转移诊断名称
     */
    @ExcelProperty(value = "转移诊断名称")
    private String metsDiagName;

    /**
     * 多原发诊断编码
     */
    @ExcelProperty(value = "多原发诊断编码")
    private String mulpriDiagCode;

    /**
     * 多原发诊断名称
     */
    @ExcelProperty(value = "多原发诊断名称")
    private String mulpriDiagName;

    /**
     * 随访结论
     */
    @ExcelProperty(value = "随访结论")
    private String followupConclusion;

    /**
     * 证件类型
     */
    @ExcelProperty(value = "证件类型")
    private String certificateType;

    /**
     * 证件号码
     */
    @ExcelProperty(value = "证件号码")
    private String certificateNo;

    /**
     * 现住址
     */
    @ExcelProperty(value = "现住址")
    private String currentAddress;

    /**
     * 联系电话
     */
    @ExcelProperty(value = "联系电话")
    private String phoneNo;

    /**
     * 联系电话2
     */
    @ExcelProperty(value = "联系电话2")
    private String phoneNo2;

    /**
     * 邮箱
     */
    @ExcelProperty(value = "邮箱")
    private String email;

    /**
     * 微信
     */
    @ExcelProperty(value = "微信")
    private String weixin;

    /**
     * 紧急联系人1
     */
    @ExcelProperty(value = "紧急联系人1")
    private String contactPerson1;

    /**
     * 紧急联系人电话1
     */
    @ExcelProperty(value = "紧急联系人电话1")
    private String contactPhoneNo1;

    /**
     * 紧急联系人2
     */
    @ExcelProperty(value = "紧急联系人2")
    private String contactPerson2;

    /**
     * 紧急联系人电话2
     */
    @ExcelProperty(value = "紧急联系人电话2")
    private String contactPhoneNo2;

    /**
     * 扩展字段1
     */
    @ExcelProperty(value = "扩展字段1")
    private String extendData1;

    /**
     * 扩展字段2
     */
    @ExcelProperty(value = "扩展字段2")
    private String extendData2;

    /**
     * 记录状态:1正常 0作废
     */
    @ExcelProperty(value = "记录状态:1正常 0作废")
    private Long recordStatus;

    /**
     * 不良反应
     */
    @ExcelProperty(value = "不良反应")
    private String adverseReaction;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createdTime;

    /**
     * 更新时间
     */
    @ExcelProperty(value = "更新时间")
    private Date updatedTime;


}
