package org.dromara.cdi.mmp.tumorqc.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 肿瘤质控方案对象 mmp_tumor_qc_plan
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_tumor_qc_plan")
public class MmpTumorQcPlan extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 方案编码
     */
    private String planCode;

    /**
     * 方案名称
     */
    private String planName;

    /**
     * 方案类型
     */
    private String planType;

    /**
     * 方案描述
     */
    private String description;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    /**
     * 状态（0正常 1停用）
     */
    private String status;

    /**
     * 审批状态（0待审批 1已审批 2驳回）
     */
    private String approvalStatus;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
