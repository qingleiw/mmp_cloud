package org.dromara.cdi.mmp.supervision.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionIssue;
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
 * 督导问题视图对象 mmp_supervision_issue
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSupervisionIssue.class)
public class MmpSupervisionIssueVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 问题类型
     */
    @ExcelProperty(value = "问题类型")
    private String issueType;

    /**
     * 问题描述
     */
    @ExcelProperty(value = "问题描述")
    private String issueDescription;

    /**
     * 严重程度
     */
    @ExcelProperty(value = "严重程度")
    private String severity;

    /**
     * 责任人
     */
    @ExcelProperty(value = "责任人")
    private String responsiblePerson;

    /**
     * 整改期限
     */
    @ExcelProperty(value = "整改期限")
    private Date rectificationDeadline;

    /**
     * 状态：pending-待整改，rectifying-整改中，completed-已完成
     */
    @ExcelProperty(value = "状态：pending-待整改，rectifying-整改中，completed-已完成")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
