package org.dromara.cdi.mmp.tumorqc.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 肿瘤质控整改对象 mmp_tumor_qc_rectification
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_tumor_qc_rectification")
public class MmpTumorQcRectification extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 整改编码
     */
    private String rectificationCode;

    /**
     * 关联检查ID
     */
    private Long inspectionId;

    /**
     * 问题描述
     */
    private String problemDescription;

    /**
     * 整改措施
     */
    private String rectificationMeasures;

    /**
     * 负责人ID
     */
    private Long responsiblePersonId;

    /**
     * 负责人姓名
     */
    private String responsiblePersonName;

    /**
     * 整改期限
     */
    private Date deadline;

    /**
     * 完成时间
     */
    private Date completionTime;

    /**
     * 整改结果
     */
    private String rectificationResult;

    /**
     * 验证状态（0待验证 1已验证）
     */
    private String verificationStatus;

    /**
     * 状态（0进行中 1已完成）
     */
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
