package org.dromara.cdi.mmp.coresystem.domain.bo;

import org.dromara.cdi.mmp.coresystem.domain.MmpCoreSystemExecutionRecord;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 制度执行记录业务对象 mmp_core_system_execution_record
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpCoreSystemExecutionRecord.class, reverseConvertGenerate = false)
public class MmpCoreSystemExecutionRecordBo extends BaseEntity {

    /**
     * 执行ID
     */
    @NotNull(message = "执行ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 制度ID
     */
    @NotNull(message = "制度ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long systemId;

    /**
     * 制度名称
     */
    private String systemName;

    /**
     * 执行人ID
     */
    @NotNull(message = "执行人ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long executorId;

    /**
     * 执行人姓名
     */
    private String executorName;

    /**
     * 执行时间
     */
    @NotNull(message = "执行时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date executionTime;

    /**
     * 执行结果 1-成功 0-失败
     */
    @NotBlank(message = "执行结果 1-成功 0-失败不能为空", groups = { AddGroup.class, EditGroup.class })
    private String executionResult;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除 0-未删除 1-已删除
     */
    private String delFlag;


}
