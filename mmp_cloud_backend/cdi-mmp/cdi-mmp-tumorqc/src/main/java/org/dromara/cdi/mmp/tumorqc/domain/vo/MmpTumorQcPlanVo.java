package org.dromara.cdi.mmp.tumorqc.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcPlan;
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
 * 肿瘤质控方案视图对象 mmp_tumor_qc_plan
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpTumorQcPlan.class)
public class MmpTumorQcPlanVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 方案编码
     */
    @ExcelProperty(value = "方案编码")
    private String planCode;

    /**
     * 方案名称
     */
    @ExcelProperty(value = "方案名称")
    private String planName;

    /**
     * 方案类型
     */
    @ExcelProperty(value = "方案类型")
    private String planType;

    /**
     * 方案描述
     */
    @ExcelProperty(value = "方案描述")
    private String description;

    /**
     * 开始日期
     */
    @ExcelProperty(value = "开始日期")
    private Date startDate;

    /**
     * 结束日期
     */
    @ExcelProperty(value = "结束日期")
    private Date endDate;

    /**
     * 状态（0正常 1停用）
     */
    @ExcelProperty(value = "状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=正常,1=停用")
    private String status;

    /**
     * 审批状态（0待审批 1已审批 2驳回）
     */
    @ExcelProperty(value = "审批状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=待审批,1=已审批,2=驳回")
    private String approvalStatus;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ExcelProperty(value = "删除标志", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=代表存在,1=代表删除")
    private String delFlag;


}
