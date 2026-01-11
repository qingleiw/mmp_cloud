package org.dromara.cdi.mmp.surgery.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryRecord;
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
 * 手术记录视图对象 mmp_surgery_record
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSurgeryRecord.class)
public class MmpSurgeryRecordVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String patientName;

    /**
     * 主刀医生姓名
     */
    @ExcelProperty(value = "主刀医生姓名")
    private String doctorName;

    /**
     * 手术科室名称
     */
    @ExcelProperty(value = "手术科室名称")
    private String departmentName;

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
     * 手术等级
     */
    @ExcelProperty(value = "手术等级")
    private String surgeryLevel;

    /**
     * 手术类型
     */
    @ExcelProperty(value = "手术类型")
    private String surgeryType;

    /**
     * 麻醉方式
     */
    @ExcelProperty(value = "麻醉方式")
    private String anesthesiaMethod;

    /**
     * 手术开始时间
     */
    @ExcelProperty(value = "手术开始时间")
    private Date surgeryStartTime;

    /**
     * 手术结束时间
     */
    @ExcelProperty(value = "手术结束时间")
    private Date surgeryEndTime;

    /**
     * 手术时长(分钟)
     */
    @ExcelProperty(value = "手术时长(分钟)")
    private Long surgeryDuration;

    /**
     * ASA分级
     */
    @ExcelProperty(value = "ASA分级")
    private String asaGrade;

    /**
     * 失血量(ml)
     */
    @ExcelProperty(value = "失血量(ml)")
    private Long bloodLoss;

    /**
     * 手术状态
     */
    @ExcelProperty(value = "手术状态")
    private String surgeryStatus;

    /**
     * 是否有并发症
     */
    @ExcelProperty(value = "是否有并发症")
    private Long complicationFlag;

    /**
     * 删除标志
     */
    @ExcelProperty(value = "删除标志")
    private String delFlag;


}
