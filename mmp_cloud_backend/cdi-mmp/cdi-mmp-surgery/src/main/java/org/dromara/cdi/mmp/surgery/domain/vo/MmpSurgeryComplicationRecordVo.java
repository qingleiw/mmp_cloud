package org.dromara.cdi.mmp.surgery.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryComplicationRecord;
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
 * 手术并发症记录视图对象 mmp_surgery_complication_record
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSurgeryComplicationRecord.class)
public class MmpSurgeryComplicationRecordVo implements Serializable {

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
     * 并发症类型
     */
    @ExcelProperty(value = "并发症类型")
    private String complicationType;

    /**
     * 并发症描述
     */
    @ExcelProperty(value = "并发症描述")
    private String complicationDescription;

    /**
     * 并发症等级
     */
    @ExcelProperty(value = "并发症等级")
    private String complicationLevel;

    /**
     * 发生时间
     */
    @ExcelProperty(value = "发生时间")
    private Date occurrenceTime;

    /**
     * 是否为非计划二次手术
     */
    @ExcelProperty(value = "是否为非计划二次手术")
    private Long isPlannedSecondary;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ExcelProperty(value = "删除标志", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=代表存在,1=代表删除")
    private String delFlag;


}
