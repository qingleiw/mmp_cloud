package org.dromara.cdi.mmp.coresystem.domain.bo;

import org.dromara.cdi.mmp.coresystem.domain.MmpCoreSystemRectificationRecord;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 制度整改记录业务对象 mmp_core_system_rectification_record
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpCoreSystemRectificationRecord.class, reverseConvertGenerate = false)
public class MmpCoreSystemRectificationRecordBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 整改ID
     */
    @NotBlank(message = "整改ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String rectificationId;

    /**
     * 制度ID
     */
    @NotNull(message = "制度ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long systemId;

    /**
     * 制度名称
     */
    @NotBlank(message = "制度名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String systemName;

    /**
     * 整改人ID
     */
    @NotNull(message = "整改人ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long rectifierId;

    /**
     * 整改人名称
     */
    @NotBlank(message = "整改人名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String rectifierName;

    /**
     * 整改状态(0:进行中,1:已完成,2:已验收)
     */
    @NotBlank(message = "整改状态(0:进行中,1:已完成,2:已验收)不能为空", groups = { AddGroup.class, EditGroup.class })
    private String rectificationStatus;

    /**
     * 开始时间
     */
    @NotNull(message = "开始时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date rectificationStartTime;

    /**
     * 完成时间
     */
    private Date rectificationEndTime;

    /**
     * 整改内容
     */
    private String rectificationContent;

    /**
     * 整改措施
     */
    private String rectificationMeasures;

    /**
     * 验收结果(1:合格,0:不合格)
     */
    private String acceptanceResult;

    /**
     * 验收意见
     */
    private String acceptanceOpinion;

    /**
     * 删除标志(0:未删除,1:已删除)
     */
    private Long delFlag;


}
