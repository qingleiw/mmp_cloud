package org.dromara.cdi.mmp.radiation.domain.bo;

import org.dromara.cdi.mmp.radiation.domain.MmpRadiationTraining;
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
 * 职业健康培训业务对象 mmp_radiation_training
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpRadiationTraining.class, reverseConvertGenerate = false)
public class MmpRadiationTrainingBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 培训编码
     */
    @NotBlank(message = "培训编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String trainingCode;

    /**
     * 培训名称
     */
    @NotBlank(message = "培训名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String trainingName;

    /**
     * 培训类型
     */
    private String trainingType;

    /**
     * 培训日期
     */
    private Date trainingDate;

    /**
     * 培训师
     */
    private String trainer;

    /**
     * 参与人员
     */
    private String participants;

    /**
     * 培训内容
     */
    private String trainingContent;

    /**
     * 培训学时
     */
    private Long trainingHours;

    /**
     * 评估结果
     */
    private String evaluationResults;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
