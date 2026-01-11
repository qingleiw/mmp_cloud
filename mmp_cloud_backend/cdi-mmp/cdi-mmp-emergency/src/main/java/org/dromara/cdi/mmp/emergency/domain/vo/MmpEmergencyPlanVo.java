package org.dromara.cdi.mmp.emergency.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyPlan;
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
 * 应急预案视图对象 mmp_emergency_plan
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpEmergencyPlan.class)
public class MmpEmergencyPlanVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 预案编码
     */
    @ExcelProperty(value = "预案编码")
    private String planCode;

    /**
     * 预案名称
     */
    @ExcelProperty(value = "预案名称")
    private String planName;

    /**
     * 预案类型：fire-消防预案，medical-医疗应急预案，disaster-灾害预案，infection-感染控制预案
     */
    @ExcelProperty(value = "预案类型：fire-消防预案，medical-医疗应急预案，disaster-灾害预案，infection-感染控制预案")
    private String planType;

    /**
     * 状态：draft-草稿，review-审核中，approved-已批准，archived-已归档
     */
    @ExcelProperty(value = "状态：draft-草稿，review-审核中，approved-已批准，archived-已归档")
    private String status;

    /**
     * 生效日期
     */
    @ExcelProperty(value = "生效日期")
    private Date effectiveDate;

    /**
     * 审核日期
     */
    @ExcelProperty(value = "审核日期")
    private Date reviewDate;

    /**
     * 下次审核日期
     */
    @ExcelProperty(value = "下次审核日期")
    private Date nextReviewDate;

    /**
     * 关键词
     */
    @ExcelProperty(value = "关键词")
    private String keywords;

    /**
     * 文件路径
     */
    @ExcelProperty(value = "文件路径")
    private String filePath;

    /**
     * 文件名称
     */
    @ExcelProperty(value = "文件名称")
    private String fileName;

    /**
     * 文件大小
     */
    @ExcelProperty(value = "文件大小")
    private Long fileSize;

    /**
     * 上传者
     */
    @ExcelProperty(value = "上传者")
    private String uploadBy;

    /**
     * 上传时间
     */
    @ExcelProperty(value = "上传时间")
    private Date uploadTime;

    /**
     * 批准人
     */
    @ExcelProperty(value = "批准人")
    private String approveBy;

    /**
     * 批准时间
     */
    @ExcelProperty(value = "批准时间")
    private Date approveTime;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
