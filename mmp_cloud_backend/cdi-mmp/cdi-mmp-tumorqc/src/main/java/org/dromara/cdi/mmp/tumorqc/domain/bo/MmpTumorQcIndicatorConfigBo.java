package org.dromara.cdi.mmp.tumorqc.domain.bo;

import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcIndicatorConfig;
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
 * 肿瘤质控指标配置业务对象 mmp_tumor_qc_indicator_config
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpTumorQcIndicatorConfig.class, reverseConvertGenerate = false)
public class MmpTumorQcIndicatorConfigBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 指标编码
     */
    @NotBlank(message = "指标编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String indicatorCode;

    /**
     * 指标名称
     */
    @NotBlank(message = "指标名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String indicatorName;

    /**
     * 指标分类
     */
    private String indicatorCategory;

    /**
     * 肿瘤类型
     */
    private String tumorType;

    /**
     * 指标类型 强制性/推荐性
     */
    private String indicatorType;

    /**
     * 计算公式
     */
    private String calculationFormula;

    /**
     * 数据来源
     */
    private String dataSource;

    /**
     * 采集频率 实时/每日/每周/每月
     */
    private String collectionFrequency;

    /**
     * 标准值
     */
    private String standardValue;

    /**
     * 目标值
     */
    private String targetValue;

    /**
     * 生效日期
     */
    private Date effectiveDate;

    /**
     * 政策级别 国家级/省级/市级
     */
    private String policyLevel;

    /**
     * 政策来源
     */
    private String policySource;

    /**
     * 是否启用
     */
    private Long isEnabled;

    /**
     * 是否删除
     */
    private Long delFlag;


}
