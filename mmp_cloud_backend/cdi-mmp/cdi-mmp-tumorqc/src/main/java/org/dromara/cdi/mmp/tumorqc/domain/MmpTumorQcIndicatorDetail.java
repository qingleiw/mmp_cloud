package org.dromara.cdi.mmp.tumorqc.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 质控指标明细数据对象 mmp_tumor_qc_indicator_detail
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_tumor_qc_indicator_detail")
public class MmpTumorQcIndicatorDetail extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 监测记录ID
     */
    private Long recordId;

    /**
     * 指标ID
     */
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
