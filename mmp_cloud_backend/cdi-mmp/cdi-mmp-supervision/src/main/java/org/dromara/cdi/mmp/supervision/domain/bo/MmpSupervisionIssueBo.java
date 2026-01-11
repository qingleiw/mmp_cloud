package org.dromara.cdi.mmp.supervision.domain.bo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionIssue;
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
 * 督导问题业务对象 mmp_supervision_issue
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSupervisionIssue.class, reverseConvertGenerate = false)
public class MmpSupervisionIssueBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 结果ID
     */
    @NotNull(message = "结果ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long resultId;

    /**
     * 问题类型
     */
    private String issueType;

    /**
     * 问题描述
     */
    @NotBlank(message = "问题描述不能为空", groups = { AddGroup.class, EditGroup.class })
    private String issueDescription;

    /**
     * 严重程度
     */
    private String severity;

    /**
     * 责任人
     */
    private String responsiblePerson;

    /**
     * 整改期限
     */
    private Date rectificationDeadline;

    /**
     * 状态：pending-待整改，rectifying-整改中，completed-已完成
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
