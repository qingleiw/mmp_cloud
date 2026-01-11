package org.dromara.cdi.mmp.tumorqc.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 肿瘤质控检查对象 mmp_tumor_qc_inspection
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_tumor_qc_inspection")
public class MmpTumorQcInspection extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 检查编码
     */
    private String inspectionCode;

    /**
     * 关联方案ID
     */
    private Long planId;

    /**
     * 检查日期
     */
    private Date inspectionDate;

    /**
     * 检查人ID
     */
    private Long inspectorId;

    /**
     * 检查人姓名
     */
    private String inspectorName;

    /**
     * 检查科室ID
     */
    private Long departmentId;

    /**
     * 检查科室名称
     */
    private String departmentName;

    /**
     * 检查类型
     */
    private String inspectionType;

    /**
     * 检查结果
     */
    private String inspectionResult;

    /**
     * 问题描述
     */
    private String problemDescription;

    /**
     * 整改建议
     */
    private String suggestion;

    /**
     * 状态（0待整改 1已整改）
     */
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
