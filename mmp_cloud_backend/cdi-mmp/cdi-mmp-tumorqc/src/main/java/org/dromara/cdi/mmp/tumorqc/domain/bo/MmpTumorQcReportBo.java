package org.dromara.cdi.mmp.tumorqc.domain.bo;

import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcReport;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 肿瘤质控报告业务对象 mmp_tumor_qc_report
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpTumorQcReport.class, reverseConvertGenerate = false)
public class MmpTumorQcReportBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 报告编码
     */
    @NotBlank(message = "报告编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String reportCode;

    /**
     * 报告标题
     */
    @NotBlank(message = "报告标题不能为空", groups = { AddGroup.class, EditGroup.class })
    private String reportTitle;

    /**
     * 报告类型
     */
    private String reportType;

    /**
     * 关联方案ID
     */
    private Long planId;

    /**
     * 报告周期开始
     */
    private Date periodStart;

    /**
     * 报告周期结束
     */
    private Date periodEnd;

    /**
     * 报告内容
     */
    private String reportContent;

    /**
     * 报告摘要
     */
    private String summary;

    /**
     * 建议措施
     */
    private String recommendations;

    /**
     * 状态（0草稿 1已发布）
     */
    private String status;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
