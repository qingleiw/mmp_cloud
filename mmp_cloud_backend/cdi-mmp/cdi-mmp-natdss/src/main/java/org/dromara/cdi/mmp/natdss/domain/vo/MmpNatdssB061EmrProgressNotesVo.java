package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB061EmrProgressNotes;
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
 * B06-1 病程记录视图对象 mmp_natdss_b06_1_emr_progress_notes
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB061EmrProgressNotes.class)
public class MmpNatdssB061EmrProgressNotesVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统自增主键
     */
    @ExcelProperty(value = "系统自增主键")
    private Long id;

    /**
     * 患者ID
     */
    @ExcelProperty(value = "患者ID")
    private String patientId;

    /**
     * 单次就诊唯一标识号
     */
    @ExcelProperty(value = "单次就诊唯一标识号")
    private String visitSn;

    /**
     * 病案号
     */
    @ExcelProperty(value = "病案号")
    private String medicalRecordNo;

    /**
     * 住院号
     */
    @ExcelProperty(value = "住院号")
    private String patientNo;

    /**
     * 住院次数
     */
    @ExcelProperty(value = "住院次数")
    private String hospitalizationTimes;

    /**
     * 病程记录流水号
     */
    @ExcelProperty(value = "病程记录流水号")
    private String recordSn;

    /**
     * 病程记录时间
     */
    @ExcelProperty(value = "病程记录时间")
    private Date recordDatetime;

    /**
     * 病程记录类型代码
     */
    @ExcelProperty(value = "病程记录类型代码")
    private String recordTitleCode;

    /**
     * 病程记录类型
     */
    @ExcelProperty(value = "病程记录类型")
    private String recordTitle;

    /**
     * 病程记录
     */
    @ExcelProperty(value = "病程记录")
    private String recordContent;

    /**
     * 扩展字段1
     */
    @ExcelProperty(value = "扩展字段1")
    private String extendData1;

    /**
     * 扩展字段2
     */
    @ExcelProperty(value = "扩展字段2")
    private String extendData2;

    /**
     * 记录状态:1正常 0作废
     */
    @ExcelProperty(value = "记录状态:1正常 0作废")
    private Long recordStatus;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createdTime;

    /**
     * 更新时间
     */
    @ExcelProperty(value = "更新时间")
    private Date updatedTime;


}
