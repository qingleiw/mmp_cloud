package org.dromara.cdi.mmp.surgery.domain.vo;

import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryWorkloadStatistics;
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
 * 手术工作量统计视图对象 mmp_surgery_workload_statistics
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSurgeryWorkloadStatistics.class)
public class MmpSurgeryWorkloadStatisticsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 医师姓名
     */
    @ExcelProperty(value = "医师姓名")
    private String doctorName;

    /**
     * 手术编码
     */
    @ExcelProperty(value = "手术编码")
    private String surgeryCode;

    /**
     * 手术名称
     */
    @ExcelProperty(value = "手术名称")
    private String surgeryName;

    /**
     * 手术级别
     */
    @ExcelProperty(value = "手术级别")
    private String surgeryLevel;

    /**
     * 手术数量
     */
    @ExcelProperty(value = "手术数量")
    private Long surgeryCount;

    /**
     * 主刀次数
     */
    @ExcelProperty(value = "主刀次数")
    private Long mainOperatorCount;

    /**
     * 一助次数
     */
    @ExcelProperty(value = "一助次数")
    private Long firstAssistantCount;

    /**
     * 统计年份
     */
    @ExcelProperty(value = "统计年份")
    private Long statisticsYear;

    /**
     * 统计月份
     */
    @ExcelProperty(value = "统计月份")
    private Long statisticsMonth;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ExcelProperty(value = "删除标志", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=代表存在,1=代表删除")
    private String delFlag;


}
