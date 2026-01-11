package org.dromara.cdi.mmp.ntp.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectProgress;
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
 * 新技术进展报告视图对象 mmp_new_technology_project_progress
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNewTechnologyProjectProgress.class)
public class MmpNewTechnologyProjectProgressVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 报告编号
     */
    @ExcelProperty(value = "报告编号")
    private String reportNo;

    /**
     * 报告类型 进展报告/结题报告
     */
    @ExcelProperty(value = "报告类型 进展报告/结题报告")
    private String reportType;

    /**
     * 报告期间
     */
    @ExcelProperty(value = "报告期间")
    private String reportPeriod;

    /**
     * 报告日期
     */
    @ExcelProperty(value = "报告日期")
    private Date reportDate;

    /**
     * 开展病例数
     */
    @ExcelProperty(value = "开展病例数")
    private Long caseCount;

    /**
     * 成功病例数
     */
    @ExcelProperty(value = "成功病例数")
    private Long successCount;

    /**
     * 并发症例数
     */
    @ExcelProperty(value = "并发症例数")
    private Long complicationCount;

    /**
     * 不良反应例数
     */
    @ExcelProperty(value = "不良反应例数")
    private Long adverseReactionCount;

    /**
     * 死亡例数
     */
    @ExcelProperty(value = "死亡例数")
    private Long mortalityCount;

    /**
     * 效果评价
     */
    @ExcelProperty(value = "效果评价")
    private String effectEvaluation;

    /**
     * 存在问题
     */
    @ExcelProperty(value = "存在问题")
    private String existingProblems;

    /**
     * 改进措施
     */
    @ExcelProperty(value = "改进措施")
    private String improvementMeasures;

    /**
     * 下步计划
     */
    @ExcelProperty(value = "下步计划")
    private String nextPlan;

    /**
     * 继续状态 继续开展/终止/暂停
     */
    @ExcelProperty(value = "继续状态 继续开展/终止/暂停")
    private String continueStatus;

    /**
     * 运行监测指标JSON
     */
    @ExcelProperty(value = "运行监测指标JSON")
    private String monitoringIndicators;

    /**
     * 附件URLs
     */
    @ExcelProperty(value = "附件URLs")
    private String attachmentUrls;

    /**
     * 报告状态
     */
    @ExcelProperty(value = "报告状态")
    private String reportStatus;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
