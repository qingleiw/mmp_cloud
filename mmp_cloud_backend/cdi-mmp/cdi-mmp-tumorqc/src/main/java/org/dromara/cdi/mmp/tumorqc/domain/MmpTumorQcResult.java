package org.dromara.cdi.mmp.tumorqc.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 肿瘤质控结果对象 mmp_tumor_qc_result
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_tumor_qc_result")
public class MmpTumorQcResult extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 结果编码
     */
    private String resultCode;

    /**
     * 关联方案ID
     */
    private Long planId;

    /**
     * 指标ID
     */
    private Long indicatorId;

    /**
     * 指标名称
     */
    private String indicatorName;

    /**
     * 结果值
     */
    private Long resultValue;

    /**
     * 目标值
     */
    private Long targetValue;

    /**
     * 达标率
     */
    private Long complianceRate;

    /**
     * 结果分析
     */
    private String analysis;

    /**
     * 统计周期开始
     */
    private Date periodStart;

    /**
     * 统计周期结束
     */
    private Date periodEnd;

    /**
     * 状态（0正常 1异常）
     */
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
