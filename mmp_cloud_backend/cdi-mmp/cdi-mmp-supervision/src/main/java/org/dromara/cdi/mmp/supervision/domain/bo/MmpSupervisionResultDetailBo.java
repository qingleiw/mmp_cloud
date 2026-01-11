package org.dromara.cdi.mmp.supervision.domain.bo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionResultDetail;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 督查结果明细业务对象 mmp_supervision_result_detail
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSupervisionResultDetail.class, reverseConvertGenerate = false)
public class MmpSupervisionResultDetailBo extends BaseEntity {

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
     * 指标ID
     */
    @NotNull(message = "指标ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long indicatorId;

    /**
     * 得分
     */
    private Long score;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 备注
     */
    private String remark;


}
