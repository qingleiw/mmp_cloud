package org.dromara.cdi.mmp.coresystem.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.coresystem.domain.MmpCoreSystemInspectionRecord;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 制度检查记录视图对象 mmp_core_system_inspection_record
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpCoreSystemInspectionRecord.class)
public class MmpCoreSystemInspectionRecordVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 检查ID
     */
    @ExcelProperty(value = "检查ID")
    private Long id;

    /**
     * 制度名称
     */
    @ExcelProperty(value = "制度名称")
    private String systemName;

    /**
     * 检查人姓名
     */
    @ExcelProperty(value = "检查人姓名")
    private String inspectorName;

    /**
     * 检查时间
     */
    @ExcelProperty(value = "检查时间")
    private Date inspectionTime;

    /**
     * 检查结果 1-合格 0-不合格
     */
    @ExcelProperty(value = "检查结果 1-合格 0-不合格")
    private String inspectionResult;

    /**
     * 检查内容
     */
    @ExcelProperty(value = "检查内容")
    private String inspectionContent;

    /**
     * 问题描述
     */
    @ExcelProperty(value = "问题描述")
    private String problemDescription;

    /**
     * 整改建议
     */
    @ExcelProperty(value = "整改建议")
    private String rectificationSuggestion;

    /**
     * 是否删除 0-未删除 1-已删除
     */
    @ExcelProperty(value = "是否删除 0-未删除 1-已删除")
    private String delFlag;


}
