package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB021PatientInfo;
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
 * B02-1 患者就诊基本信息视图对象 mmp_natdss_b02_1_patient_info
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB021PatientInfo.class)
public class MmpNatdssB021PatientInfoVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统自增主键
     */
    @ExcelProperty(value = "系统自增主键")
    private Long id;

    /**
     * 患者ID-患者在本院信息系统内的唯一标识
     */
    @ExcelProperty(value = "患者ID-患者在本院信息系统内的唯一标识")
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
     * 就诊次数
     */
    @ExcelProperty(value = "就诊次数")
    private Long visitTimes;

    /**
     * 就诊时间
     */
    @ExcelProperty(value = "就诊时间")
    private Date visitDatetime;

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
     * 住院次数
     */
    @ExcelProperty(value = "住院次数")
    private String hospitalizationTimes;

    /**
     * 入院时间
     */
    @ExcelProperty(value = "入院时间")
    private Date admissionDatetime;

    /**
     * 出院时间
     */
    @ExcelProperty(value = "出院时间")
    private Date dischargeDatetime;

    /**
     * 就诊医生代码
     */
    @ExcelProperty(value = "就诊医生代码")
    private String visitDoctorNo;

    /**
     * 姓名
     */
    @ExcelProperty(value = "姓名")
    private String name;

    /**
     * 性别:男、女、未知
     */
    @ExcelProperty(value = "性别:男、女、未知")
    private String gender;

    /**
     * 出生日期
     */
    @ExcelProperty(value = "出生日期")
    private Date dateOfBirth;

    /**
     * 职业类别代码
     */
    @ExcelProperty(value = "职业类别代码")
    private String occupationCode;

    /**
     * 职业类别名称
     */
    @ExcelProperty(value = "职业类别名称")
    private String occupationName;

    /**
     * 国籍
     */
    @ExcelProperty(value = "国籍")
    private String nationality;

    /**
     * 民族
     */
    @ExcelProperty(value = "民族")
    private String ethnicity;

    /**
     * 文化程度
     */
    @ExcelProperty(value = "文化程度")
    private String education;

    /**
     * 婚姻状况类别
     */
    @ExcelProperty(value = "婚姻状况类别")
    private String maritalStatus;

    /**
     * 是否新生儿
     */
    @ExcelProperty(value = "是否新生儿")
    private String newbronMark;

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
     * 健康卡类型
     */
    @ExcelProperty(value = "健康卡类型")
    private String healthCardType;

    /**
     * 健康卡号
     */
    @ExcelProperty(value = "健康卡号")
    private String healthCardNo;

    /**
     * 医保类型
     */
    @ExcelProperty(value = "医保类型")
    private String insuranceType;

    /**
     * 医保卡号
     */
    @ExcelProperty(value = "医保卡号")
    private String insuranceNo;

    /**
     * 户籍地址-省名称
     */
    @ExcelProperty(value = "户籍地址-省名称")
    private String residenceProvince;

    /**
     * 户籍地址-市名称
     */
    @ExcelProperty(value = "户籍地址-市名称")
    private String residenceCity;

    /**
     * 户籍地址-县名称
     */
    @ExcelProperty(value = "户籍地址-县名称")
    private String residenceCounty;

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
     * ABO血型
     */
    @ExcelProperty(value = "ABO血型")
    private String aboBloodType;

    /**
     * Rh血型
     */
    @ExcelProperty(value = "Rh血型")
    private String rhBloodType;

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
