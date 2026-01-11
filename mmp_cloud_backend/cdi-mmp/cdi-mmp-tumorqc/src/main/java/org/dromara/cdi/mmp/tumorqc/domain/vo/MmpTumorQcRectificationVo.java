package org.dromara.cdi.mmp.tumorqc.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcRectification;
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
 * 肿瘤质控整改视图对象 mmp_tumor_qc_rectification
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpTumorQcRectification.class)
public class MmpTumorQcRectificationVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 整改编码
     */
    @ExcelProperty(value = "整改编码")
    private String rectificationCode;

    /**
     * 问题描述
     */
    @ExcelProperty(value = "问题描述")
    private String problemDescription;

    /**
     * 整改措施
     */
    @ExcelProperty(value = "整改措施")
    private String rectificationMeasures;

    /**
     * 负责人姓名
     */
    @ExcelProperty(value = "负责人姓名")
    private String responsiblePersonName;

    /**
     * 整改期限
     */
    @ExcelProperty(value = "整改期限")
    private Date deadline;

    /**
     * 完成时间
     */
    @ExcelProperty(value = "完成时间")
    private Date completionTime;

    /**
     * 整改结果
     */
    @ExcelProperty(value = "整改结果")
    private String rectificationResult;

    /**
     * 验证状态（0待验证 1已验证）
     */
    @ExcelProperty(value = "验证状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=待验证,1=已验证")
    private String verificationStatus;

    /**
     * 状态（0进行中 1已完成）
     */
    @ExcelProperty(value = "状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=进行中,1=已完成")
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ExcelProperty(value = "删除标志", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=代表存在,1=代表删除")
    private String delFlag;


}
