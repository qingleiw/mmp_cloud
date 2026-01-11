package org.dromara.cdi.mmp.coresystem.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.coresystem.domain.MmpCoreSystemRectificationRecord;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 制度整改记录视图对象 mmp_core_system_rectification_record
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpCoreSystemRectificationRecord.class)
public class MmpCoreSystemRectificationRecordVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 制度名称
     */
    @ExcelProperty(value = "制度名称")
    private String systemName;

    /**
     * 整改人名称
     */
    @ExcelProperty(value = "整改人名称")
    private String rectifierName;

    /**
     * 整改状态(0:进行中,1:已完成,2:已验收)
     */
    @ExcelProperty(value = "整改状态(0:进行中,1:已完成,2:已验收)")
    private String rectificationStatus;

    /**
     * 开始时间
     */
    @ExcelProperty(value = "开始时间")
    private Date rectificationStartTime;

    /**
     * 完成时间
     */
    @ExcelProperty(value = "完成时间")
    private Date rectificationEndTime;

    /**
     * 整改内容
     */
    @ExcelProperty(value = "整改内容")
    private String rectificationContent;

    /**
     * 整改措施
     */
    @ExcelProperty(value = "整改措施")
    private String rectificationMeasures;

    /**
     * 验收结果(1:合格,0:不合格)
     */
    @ExcelProperty(value = "验收结果(1:合格,0:不合格)")
    private String acceptanceResult;

    /**
     * 验收意见
     */
    @ExcelProperty(value = "验收意见")
    private String acceptanceOpinion;

    /**
     * 删除标志(0:未删除,1:已删除)
     */
    @ExcelProperty(value = "删除标志(0:未删除,1:已删除)")
    private Long delFlag;


}
