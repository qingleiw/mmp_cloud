package org.dromara.cdi.mmp.ledger.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.ledger.domain.MmpLedgerBusinessLearning;
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
 * 业务学习记录本视图对象 mmp_ledger_business_learning
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpLedgerBusinessLearning.class)
public class MmpLedgerBusinessLearningVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 学习日期
     */
    @ExcelProperty(value = "学习日期")
    private Date learningDate;

    /**
     * 学习主题
     */
    @ExcelProperty(value = "学习主题")
    private String learningTopic;

    /**
     * 学习类型
     */
    @ExcelProperty(value = "学习类型")
    private String learningType;

    /**
     * 组织者
     */
    @ExcelProperty(value = "组织者")
    private String organizer;

    /**
     * 参与人员
     */
    @ExcelProperty(value = "参与人员")
    private String participants;

    /**
     * 学习内容
     */
    @ExcelProperty(value = "学习内容")
    private String learningContent;

    /**
     * 学习学时
     */
    @ExcelProperty(value = "学习学时")
    private Long learningHours;

    /**
     * 授课人
     */
    @ExcelProperty(value = "授课人")
    private String instructor;

    /**
     * 评价结果
     */
    @ExcelProperty(value = "评价结果")
    private String evaluationResults;

    /**
     * 附件
     */
    @ExcelProperty(value = "附件")
    private String attachments;

    /**
     * 状态
     */
    @ExcelProperty(value = "状态")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
