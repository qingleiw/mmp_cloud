package org.dromara.cdi.mmp.ledger.domain.bo;

import org.dromara.cdi.mmp.ledger.domain.MmpLedgerBusinessLearning;
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
 * 业务学习记录本业务对象 mmp_ledger_business_learning
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpLedgerBusinessLearning.class, reverseConvertGenerate = false)
public class MmpLedgerBusinessLearningBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 学习日期
     */
    @NotNull(message = "学习日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date learningDate;

    /**
     * 学习主题
     */
    @NotBlank(message = "学习主题不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 备注
     */
    private String remark;


}
