package org.dromara.cdi.mmp.radiation.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 培训参与记录对象 mmp_radiation_training_participant
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_radiation_training_participant")
public class MmpRadiationTrainingParticipant extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 培训计划ID
     */
    private Long planId;

    /**
     * 工作人员ID
     */
    private Long staffId;

    /**
     * 工作人员姓名
     */
    private String staffName;

    /**
     * 出席状态：registered-已报名，attended-出席，absent-缺席
     */
    private String attendanceStatus;

    /**
     * 培训成绩
     */
    private Long score;

    /**
     * 评价
     */
    private String evaluation;

    /**
     * 是否发放证书：0-否，1-是
     */
    private String certificateIssued;

    /**
     * 证书编号
     */
    private String certificateNumber;

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
