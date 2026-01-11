package org.dromara.cdi.mmp.radiation.domain.bo;

import org.dromara.cdi.mmp.radiation.domain.MmpRadiationTrainingParticipant;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 培训参与记录业务对象 mmp_radiation_training_participant
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpRadiationTrainingParticipant.class, reverseConvertGenerate = false)
public class MmpRadiationTrainingParticipantBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 培训计划ID
     */
    @NotNull(message = "培训计划ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long planId;

    /**
     * 工作人员ID
     */
    @NotNull(message = "工作人员ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long staffId;

    /**
     * 工作人员姓名
     */
    private String staffName;

    /**
     * 出席状态：registered-已报名，attended-出席，absent-缺席
     */
    private String attendanceStatus;

    /**
     * 培训成绩
     */
    private Long score;

    /**
     * 评价
     */
    private String evaluation;

    /**
     * 是否发放证书：0-否，1-是
     */
    private String certificateIssued;

    /**
     * 证书编号
     */
    private String certificateNumber;

    /**
     * 备注
     */
    private String remark;


}
