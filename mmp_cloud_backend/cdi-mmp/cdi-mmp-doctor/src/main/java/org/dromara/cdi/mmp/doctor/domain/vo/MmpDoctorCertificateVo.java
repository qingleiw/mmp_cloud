package org.dromara.cdi.mmp.doctor.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorCertificate;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 资质证书视图对象 mmp_doctor_certificate
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDoctorCertificate.class)
public class MmpDoctorCertificateVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 医生ID
     */
    @ExcelProperty(value = "医生ID")
    private Long doctorId;

    /**
     * 医生姓名
     */
    @ExcelProperty(value = "医生姓名")
    private String doctorName;

    /**
     * 证书类型 执业/资格/培训等
     */
    @ExcelProperty(value = "证书类型 执业/资格/培训等")
    private String certificateType;

    /**
     * 证书名称
     */
    @ExcelProperty(value = "证书名称")
    private String certificateName;

    /**
     * 证书编号
     */
    @ExcelProperty(value = "证书编号")
    private String certificateNo;

    /**
     * 发证机构
     */
    @ExcelProperty(value = "发证机构")
    private String issueUnit;

    /**
     * 发证日期
     */
    @ExcelProperty(value = "发证日期")
    private Date issueDate;

    /**
     * 有效期至
     */
    @ExcelProperty(value = "有效期至")
    private Date validDate;

    /**
     * 是否长期有效 1-是 0-否
     */
    @ExcelProperty(value = "是否长期有效 1-是 0-否")
    private Long isPermanent;

    /**
     * 证书附件URL
     */
    @ExcelProperty(value = "证书附件URL")
    private String certificateUrl;

    /**
     * 状态 1-有效 2-即将到期 3-已过期 4-已注销
     */
    @ExcelProperty(value = "状态 1-有效 2-即将到期 3-已过期 4-已注销")
    private Long status;

    /**
     * 提前提醒天数
     */
    @ExcelProperty(value = "提前提醒天数")
    private Long remindDays;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
