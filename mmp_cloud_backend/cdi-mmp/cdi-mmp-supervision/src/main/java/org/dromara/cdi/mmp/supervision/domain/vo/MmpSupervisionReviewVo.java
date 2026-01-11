package org.dromara.cdi.mmp.supervision.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionReview;
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
 * 整改复查视图对象 mmp_supervision_review
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSupervisionReview.class)
public class MmpSupervisionReviewVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 复查日期
     */
    @ExcelProperty(value = "复查日期")
    private Date reviewDate;

    /**
     * 复查人
     */
    @ExcelProperty(value = "复查人")
    private String reviewer;

    /**
     * 复查结果：qualified-合格，unqualified-不合格
     */
    @ExcelProperty(value = "复查结果：qualified-合格，unqualified-不合格")
    private String reviewResult;

    /**
     * 复查意见
     */
    @ExcelProperty(value = "复查意见")
    private String reviewOpinion;

    /**
     * 下次复查日期
     */
    @ExcelProperty(value = "下次复查日期")
    private Date nextReviewDate;

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
