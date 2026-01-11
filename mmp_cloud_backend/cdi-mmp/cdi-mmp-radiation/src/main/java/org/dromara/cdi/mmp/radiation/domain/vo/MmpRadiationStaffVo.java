package org.dromara.cdi.mmp.radiation.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationStaff;
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
 * 放射工作人员视图对象 mmp_radiation_staff
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpRadiationStaff.class)
public class MmpRadiationStaffVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    @ExcelProperty(value = "姓名")
    private String userName;

    /**
     * 员工编码
     */
    @ExcelProperty(value = "员工编码")
    private String employeeCode;

    /**
     * 所在部门名称
     */
    @ExcelProperty(value = "所在部门名称")
    private String departmentName;

    /**
     * 工作岗位
     */
    @ExcelProperty(value = "工作岗位")
    private String position;

    /**
     * 入职日期
     */
    @ExcelProperty(value = "入职日期")
    private Date hireDate;

    /**
     * 放射工作年限
     */
    @ExcelProperty(value = "放射工作年限")
    private Long radiationWorkYears;

    /**
     * 放射资质
     */
    @ExcelProperty(value = "放射资质")
    private String radiationQualification;

    /**
     * 资质证书
     */
    @ExcelProperty(value = "资质证书")
    private String qualificationCertificate;

    /**
     * 证书编号
     */
    @ExcelProperty(value = "证书编号")
    private String certificateNumber;

    /**
     * 证书发证日期
     */
    @ExcelProperty(value = "证书发证日期")
    private Date certificateIssueDate;

    /**
     * 证书到期日期
     */
    @ExcelProperty(value = "证书到期日期")
    private Date certificateExpiryDate;

    /**
     * 培训记录
     */
    @ExcelProperty(value = "培训记录")
    private String trainingRecords;

    /**
     * 体检记录
     */
    @ExcelProperty(value = "体检记录")
    private String healthExamRecords;

    /**
     * 状态：active-在职，inactive-离职
     */
    @ExcelProperty(value = "状态：active-在职，inactive-离职")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
