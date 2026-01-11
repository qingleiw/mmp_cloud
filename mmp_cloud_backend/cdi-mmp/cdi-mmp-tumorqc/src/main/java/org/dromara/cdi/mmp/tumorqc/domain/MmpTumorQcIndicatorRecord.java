package org.dromara.cdi.mmp.tumorqc.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 质控指标监测记录对象 mmp_tumor_qc_indicator_record
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_tumor_qc_indicator_record")
public class MmpTumorQcIndicatorRecord extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 记录日期
     */
    private Date recordDate;

    /**
     * 计算周期
     */
    private String calculationCycle;

    /**
     * 科室ID
     */
    private Long departmentId;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 指标ID
     */
    private Long indicatorId;

    /**
     * 指标编码
     */
    private String indicatorCode;

    /**
     * 指标名称
     */
    private String indicatorName;

    /**
     * 分子
     */
    private Long numerator;

    /**
     * 分母
     */
    private Long denominator;

    /**
     * 指标值
     */
    private Long indicatorValue;

    /**
     * 目标值
     */
    private String targetValue;

    /**
     * 达标状态 达标/不达标
     */
    private String complianceStatus;

    /**
     * 完成率(%)
     */
    private Long completionRate;

    /**
     * 院内排名
     */
    private Long rankInHospital;

    /**
     * 趋势方向
     */
    private String trendDirection;

    /**
     * 是否异常 1-是 0-否
     */
    private Long isAbnormal;

    /**
     * 数据来源说明
     */
    private String dataSource;

    /**
     * 是否人工录入 1-是 0-否
     */
    private Long isManual;

    /**
     * 备注
     */
    private String remark;


}
