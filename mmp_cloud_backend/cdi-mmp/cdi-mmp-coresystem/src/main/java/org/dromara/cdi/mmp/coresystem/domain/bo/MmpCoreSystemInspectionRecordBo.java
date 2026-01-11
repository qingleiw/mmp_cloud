package org.dromara.cdi.mmp.coresystem.domain.bo;

import org.dromara.cdi.mmp.coresystem.domain.MmpCoreSystemInspectionRecord;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 制度检查记录业务对象 mmp_core_system_inspection_record
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpCoreSystemInspectionRecord.class, reverseConvertGenerate = false)
public class MmpCoreSystemInspectionRecordBo extends BaseEntity {

    /**
     * 检查ID
     */
    @NotNull(message = "检查ID不能为空", groups = { EditGroup.class })
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
     * 检查人ID
     */
    @NotNull(message = "检查人ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long inspectorId;

    /**
     * 检查人姓名
     */
    private String inspectorName;

    /**
     * 检查时间
     */
    @NotNull(message = "检查时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date inspectionTime;

    /**
     * 检查结果 1-合格 0-不合格
     */
    @NotBlank(message = "检查结果 1-合格 0-不合格不能为空", groups = { AddGroup.class, EditGroup.class })
    private String inspectionResult;

    /**
     * 检查内容
     */
    @NotBlank(message = "检查内容不能为空", groups = { AddGroup.class, EditGroup.class })
    private String inspectionContent;

    /**
     * 问题描述
     */
    private String problemDescription;

    /**
     * 整改建议
     */
    private String rectificationSuggestion;

    /**
     * 是否删除 0-未删除 1-已删除
     */
    private String delFlag;


}
