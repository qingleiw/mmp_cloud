package org.dromara.cdi.mmp.radiation.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 职业健康培训对象 mmp_radiation_training
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_radiation_training")
public class MmpRadiationTraining extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 培训编码
     */
    private String trainingCode;

    /**
     * 培训名称
     */
    private String trainingName;

    /**
     * 培训类型
     */
    private String trainingType;

    /**
     * 培训日期
     */
    private Date trainingDate;

    /**
     * 培训师
     */
    private String trainer;

    /**
     * 参与人员
     */
    private String participants;

    /**
     * 培训内容
     */
    private String trainingContent;

    /**
     * 培训学时
     */
    private Long trainingHours;

    /**
     * 评估结果
     */
    private String evaluationResults;

    /**
     * 状态
     */
    private String status;

    /**
     * 是否删除
     */
    @TableLogic
    private Long delFlag;

    /**
     * 备注
     */
    private String remark;


}
