package org.dromara.cdi.mmp.tumorqc.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 肿瘤质控报告对象 mmp_tumor_qc_report
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_tumor_qc_report")
public class MmpTumorQcReport extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 报告编码
     */
    private String reportCode;

    /**
     * 报告标题
     */
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
