package org.dromara.cdi.mmp.qc.domain.bo;

import org.dromara.cdi.mmp.qc.domain.MmpQcIndicatorFactor;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 指标计算因子业务对象 mmp_qc_indicator_factor
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQcIndicatorFactor.class, reverseConvertGenerate = false)
public class MmpQcIndicatorFactorBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 指标ID
     */
    @NotNull(message = "指标ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long indicatorId;

    /**
     * 因子类型：numerator-分子，denominator-分母
     */
    @NotBlank(message = "因子类型：numerator-分子，denominator-分母不能为空", groups = { AddGroup.class, EditGroup.class })
    private String factorType;

    /**
     * 因子名称
     */
    @NotBlank(message = "因子名称不能为空", groups = { AddGroup.class, EditGroup.class })
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
