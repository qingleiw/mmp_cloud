package org.dromara.cdi.mmp.supervision.domain.vo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionRectificationProgress;
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
 * 整改进度视图对象 mmp_supervision_rectification_progress
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSupervisionRectificationProgress.class)
public class MmpSupervisionRectificationProgressVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 进度描述
     */
    @ExcelProperty(value = "进度描述")
    private String progressDescription;

    /**
     * 进度百分比
     */
    @ExcelProperty(value = "进度百分比")
    private Long progressPercentage;

    /**
     * 附件URL
     */
    @ExcelProperty(value = "附件URL")
    private String attachmentUrls;

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
