package org.dromara.cdi.mmp.supervision.domain.bo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionReview;
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
 * 整改复查业务对象 mmp_supervision_review
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSupervisionReview.class, reverseConvertGenerate = false)
public class MmpSupervisionReviewBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 任务ID
     */
    @NotNull(message = "任务ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long taskId;

    /**
     * 复查日期
     */
    @NotNull(message = "复查日期不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 备注
     */
    private String remark;


}
