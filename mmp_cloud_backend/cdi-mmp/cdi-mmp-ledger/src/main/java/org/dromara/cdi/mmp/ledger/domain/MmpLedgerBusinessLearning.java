package org.dromara.cdi.mmp.ledger.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 业务学习记录本对象 mmp_ledger_business_learning
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_ledger_business_learning")
public class MmpLedgerBusinessLearning extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 学习日期
     */
    private Date learningDate;

    /**
     * 学习主题
     */
    private String learningTopic;

    /**
     * 学习类型
     */
    private String learningType;

    /**
     * 组织者
     */
    private String organizer;

    /**
     * 参与人员
     */
    private String participants;

    /**
     * 学习内容
     */
    private String learningContent;

    /**
     * 学习学时
     */
    private Long learningHours;

    /**
     * 授课人
     */
    private String instructor;

    /**
     * 评价结果
     */
    private String evaluationResults;

    /**
     * 附件
     */
    private String attachments;

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
