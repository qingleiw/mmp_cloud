package org.dromara.cdi.mmp.tumorqc.domain.bo;

import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcResult;
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
 * 肿瘤质控结果业务对象 mmp_tumor_qc_result
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpTumorQcResult.class, reverseConvertGenerate = false)
public class MmpTumorQcResultBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 结果编码
     */
    @NotBlank(message = "结果编码不能为空", groups = { AddGroup.class, EditGroup.class })
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
