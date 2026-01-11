package org.dromara.cdi.mmp.doctor.domain.bo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorTraining;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 培训记录业务对象 mmp_doctor_training
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpDoctorTraining.class, reverseConvertGenerate = false)
public class MmpDoctorTrainingBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 医生ID
     */
    @NotNull(message = "医生ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long doctorId;

    /**
     * 培训类型 进修/继续教育/院内培训
     */
    private String trainingType;

    /**
     * 培训名称
     */
    private String trainingName;

    /**
     * 培训单位
     */
    private String trainingUnit;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    /**
     * 培训学时
     */
    private Long trainingHours;

    /**
     * 培训内容
     */
    private String trainingContent;

    /**
     * 培训结果 合格/不合格
     */
    private String trainingResult;

    /**
     * 证书编号
     */
    private String certificateNo;

    /**
     * 证书附件URL
     */
    private String certificateUrl;

    /**
     * 学分
     */
    private Long credits;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    private Long delFlag;


}
