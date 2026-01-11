package org.dromara.cdi.mmp.radiation.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationWorker;
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
 * 放射工作人员视图对象 mmp_radiation_worker
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpRadiationWorker.class)
public class MmpRadiationWorkerVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 工作人员编码
     */
    @ExcelProperty(value = "工作人员编码")
    private String workerCode;

    /**
     * 工作人员姓名
     */
    @ExcelProperty(value = "工作人员姓名")
    private String workerName;

    /**
     * 所属部门
     */
    @ExcelProperty(value = "所属部门")
    private String department;

    /**
     * 职位
     */
    @ExcelProperty(value = "职位")
    private String position;

    /**
     * 接触辐射类型
     */
    @ExcelProperty(value = "接触辐射类型")
    private String radiationType;

    /**
     * 入职日期
     */
    @ExcelProperty(value = "入职日期")
    private Date employmentDate;

    /**
     * 联系方式
     */
    @ExcelProperty(value = "联系方式")
    private String contactInfo;

    /**
     * 紧急联系人
     */
    @ExcelProperty(value = "紧急联系人")
    private String emergencyContact;

    /**
     * 健康状况
     */
    @ExcelProperty(value = "健康状况")
    private String healthStatus;

    /**
     * 状态
     */
    @ExcelProperty(value = "状态")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
