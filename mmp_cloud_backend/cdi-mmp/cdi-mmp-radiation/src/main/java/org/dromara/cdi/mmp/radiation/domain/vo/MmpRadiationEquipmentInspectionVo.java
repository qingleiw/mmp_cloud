package org.dromara.cdi.mmp.radiation.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationEquipmentInspection;
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
 * 放射设备检测记录视图对象 mmp_radiation_equipment_inspection
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpRadiationEquipmentInspection.class)
public class MmpRadiationEquipmentInspectionVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 检测日期
     */
    @ExcelProperty(value = "检测日期")
    private Date inspectionDate;

    /**
     * 检测机构
     */
    @ExcelProperty(value = "检测机构")
    private String inspectionAgency;

    /**
     * 检测人员
     */
    @ExcelProperty(value = "检测人员")
    private String inspectorName;

    /**
     * 检测结果：pass-合格，fail-不合格
     */
    @ExcelProperty(value = "检测结果：pass-合格，fail-不合格")
    private String inspectionResult;

    /**
     * 检测报告
     */
    @ExcelProperty(value = "检测报告")
    private String inspectionReport;

    /**
     * 下次检测日期
     */
    @ExcelProperty(value = "下次检测日期")
    private Date nextInspectionDate;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
