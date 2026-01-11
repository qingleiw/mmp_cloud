package org.dromara.cdi.mmp.radiation.domain.bo;

import org.dromara.cdi.mmp.radiation.domain.MmpRadiationHealthExam;
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
 * 职业健康体检业务对象 mmp_radiation_health_exam
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpRadiationHealthExam.class, reverseConvertGenerate = false)
public class MmpRadiationHealthExamBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 工作人员ID
     */
    @NotNull(message = "工作人员ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long workerId;

    /**
     * 体检日期
     */
    @NotNull(message = "体检日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date examDate;

    /**
     * 体检类型
     */
    private String examType;

    /**
     * 体检医院
     */
    private String examHospital;

    /**
     * 体检医生
     */
    private String examDoctor;

    /**
     * 体检结果
     */
    private String examResults;

    /**
     * 诊断结果
     */
    private String diagnosis;

    /**
     * 建议
     */
    private String recommendations;

    /**
     * 需要随访：0-否，1-是
     */
    private String followUpRequired;

    /**
     * 下次体检日期
     */
    private Date nextExamDate;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
