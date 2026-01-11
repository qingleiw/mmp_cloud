package org.dromara.cdi.mmp.doctor.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 资质证书对象 mmp_doctor_certificate
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_doctor_certificate")
public class MmpDoctorCertificate extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 医生ID
     */
    private Long doctorId;

    /**
     * 证书类型 执业/资格/培训等
     */
    private String certificateType;

    /**
     * 证书名称
     */
    private String certificateName;

    /**
     * 证书编号
     */
    private String certificateNo;

    /**
     * 发证机构
     */
    private String issueUnit;

    /**
     * 发证日期
     */
    private Date issueDate;

    /**
     * 有效期至
     */
    private Date validDate;

    /**
     * 是否长期有效 1-是 0-否
     */
    private Long isPermanent;

    /**
     * 证书附件URL
     */
    private String certificateUrl;

    /**
     * 状态 1-有效 2-即将到期 3-已过期 4-已注销
     */
    private Long status;

    /**
     * 提前提醒天数
     */
    private Long remindDays;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    private Long delFlag;

    /**
     * 创建部门
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createDept;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

}
