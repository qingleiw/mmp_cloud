package org.dromara.cdi.mmp.tumorqc.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcInspection;
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
 * 肿瘤质控检查视图对象 mmp_tumor_qc_inspection
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpTumorQcInspection.class)
public class MmpTumorQcInspectionVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 检查编码
     */
    @ExcelProperty(value = "检查编码")
    private String inspectionCode;

    /**
     * 检查日期
     */
    @ExcelProperty(value = "检查日期")
    private Date inspectionDate;

    /**
     * 检查人姓名
     */
    @ExcelProperty(value = "检查人姓名")
    private String inspectorName;

    /**
     * 检查科室名称
     */
    @ExcelProperty(value = "检查科室名称")
    private String departmentName;

    /**
     * 检查类型
     */
    @ExcelProperty(value = "检查类型")
    private String inspectionType;

    /**
     * 检查结果
     */
    @ExcelProperty(value = "检查结果")
    private String inspectionResult;

    /**
     * 问题描述
     */
    @ExcelProperty(value = "问题描述")
    private String problemDescription;

    /**
     * 整改建议
     */
    @ExcelProperty(value = "整改建议")
    private String suggestion;

    /**
     * 状态（0待整改 1已整改）
     */
    @ExcelProperty(value = "状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=待整改,1=已整改")
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ExcelProperty(value = "删除标志", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=代表存在,1=代表删除")
    private String delFlag;


}
