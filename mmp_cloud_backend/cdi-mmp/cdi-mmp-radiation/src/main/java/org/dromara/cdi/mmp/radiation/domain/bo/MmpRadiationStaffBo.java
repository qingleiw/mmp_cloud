package org.dromara.cdi.mmp.radiation.domain.bo;

import org.dromara.cdi.mmp.radiation.domain.MmpRadiationStaff;
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
 * 放射工作人员业务对象 mmp_radiation_staff
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpRadiationStaff.class, reverseConvertGenerate = false)
public class MmpRadiationStaffBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long userId;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 备注
     */
    private String remark;


}
