package org.dromara.cdi.mmp.supervision.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 整改复查对象 mmp_supervision_review
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_supervision_review")
public class MmpSupervisionReview extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 任务ID
     */
    private Long taskId;

    /**
     * 复查日期
     */
    private Date reviewDate;

    /**
     * 复查人
     */
    private String reviewer;

    /**
     * 复查结果：qualified-合格，unqualified-不合格
     */
    private String reviewResult;

    /**
     * 复查意见
     */
    private String reviewOpinion;

    /**
     * 下次复查日期
     */
    private Date nextReviewDate;

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
