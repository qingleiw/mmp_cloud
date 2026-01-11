package org.dromara.cdi.mmp.ntp.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectExtension;
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
 * 新技术延期申请视图对象 mmp_new_technology_project_extension
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNewTechnologyProjectExtension.class)
public class MmpNewTechnologyProjectExtensionVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 申请编号
     */
    @ExcelProperty(value = "申请编号")
    private String applyNo;

    /**
     * 原结束日期
     */
    @ExcelProperty(value = "原结束日期")
    private Date originalEndDate;

    /**
     * 延期天数
     */
    @ExcelProperty(value = "延期天数")
    private Long extendDays;

    /**
     * 新结束日期
     */
    @ExcelProperty(value = "新结束日期")
    private Date newEndDate;

    /**
     * 延期理由
     */
    @ExcelProperty(value = "延期理由")
    private String extensionReason;

    /**
     * 申请状态
     */
    @ExcelProperty(value = "申请状态")
    private String applyStatus;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
