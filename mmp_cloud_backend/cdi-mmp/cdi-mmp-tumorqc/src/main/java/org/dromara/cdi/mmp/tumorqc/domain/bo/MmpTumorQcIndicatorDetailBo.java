package org.dromara.cdi.mmp.tumorqc.domain.bo;

import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcIndicatorDetail;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 质控指标明细数据业务对象 mmp_tumor_qc_indicator_detail
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpTumorQcIndicatorDetail.class, reverseConvertGenerate = false)
public class MmpTumorQcIndicatorDetailBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 监测记录ID
     */
    @NotNull(message = "监测记录ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long recordId;

    /**
     * 指标ID
     */
    @NotNull(message = "指标ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long indicatorId;

    /**
     * 患者ID
     */
    private Long patientId;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 就诊号
     */
    private String visitNo;

    /**
     * 诊断
     */
    private String diagnosis;

    /**
     * 指标结果 达标/不达标/不适用
     */
    private String indicatorResult;

    /**
     * 结果说明
     */
    private String resultDescription;

    /**
     * 相关数据JSON
     */
    private String relatedData;


}
