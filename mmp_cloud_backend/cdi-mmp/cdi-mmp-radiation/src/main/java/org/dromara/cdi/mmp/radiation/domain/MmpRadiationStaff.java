package org.dromara.cdi.mmp.radiation.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 放射工作人员对象 mmp_radiation_staff
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_radiation_staff")
public class MmpRadiationStaff extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 员工编码
     */
    private String employeeCode;

    /**
     * 所在部门ID
     */
    private Long departmentId;

    /**
     * 所在部门名称
     */
    private String departmentName;

    /**
     * 工作岗位
     */
    private String position;

    /**
     * 入职日期
     */
    private Date hireDate;

    /**
     * 放射工作年限
     */
    private Long radiationWorkYears;

    /**
     * 放射资质
     */
    private String radiationQualification;

    /**
     * 资质证书
     */
    private String qualificationCertificate;

    /**
     * 证书编号
     */
    private String certificateNumber;

    /**
     * 证书发证日期
     */
    private Date certificateIssueDate;

    /**
     * 证书到期日期
     */
    private Date certificateExpiryDate;

    /**
     * 培训记录
     */
    private String trainingRecords;

    /**
     * 体检记录
     */
    private String healthExamRecords;

    /**
     * 状态：active-在职，inactive-离职
     */
    private String status;

    /**
     * 是否删除
     */
    @TableLogic
    private Long delFlag;

    /**
     * 备注
     */
    private String remark;


}
