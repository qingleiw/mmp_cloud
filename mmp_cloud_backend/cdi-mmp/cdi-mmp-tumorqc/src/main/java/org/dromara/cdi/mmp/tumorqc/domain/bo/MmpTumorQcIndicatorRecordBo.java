package org.dromara.cdi.mmp.tumorqc.domain.bo;

import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcIndicatorRecord;
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
 * 质控指标监测记录业务对象 mmp_tumor_qc_indicator_record
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpTumorQcIndicatorRecord.class, reverseConvertGenerate = false)
public class MmpTumorQcIndicatorRecordBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 记录日期
     */
    @NotNull(message = "记录日期不能为空", groups = { AddGroup.class, EditGroup.class })
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
    @NotNull(message = "指标ID不能为空", groups = { AddGroup.class, EditGroup.class })
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
