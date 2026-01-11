package org.dromara.cdi.mmp.qc.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 指标计算因子对象 mmp_qc_indicator_factor
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qc_indicator_factor")
public class MmpQcIndicatorFactor extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 指标ID
     */
    private Long indicatorId;

    /**
     * 因子类型：numerator-分子，denominator-分母
     */
    private String factorType;

    /**
     * 因子名称
     */
    private String factorName;

    /**
     * 因子代码
     */
    private String factorCode;

    /**
     * 因子描述
     */
    private String description;

    /**
     * 数据来源
     */
    private String dataSource;

    /**
     * 排序
     */
    private Long sortOrder;

    /**
     * 是否删除
     */
    private Long delFlag;


}
