package org.dromara.cdi.mmp.exam.domain.bo;

import org.dromara.cdi.mmp.exam.domain.MmpQualificationExamArrangement;
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
 * 资质考试安排业务对象 mmp_qualification_exam_arrangement
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQualificationExamArrangement.class, reverseConvertGenerate = false)
public class MmpQualificationExamArrangementBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 考试编号
     */
    @NotBlank(message = "考试编号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String examCode;

    /**
     * 考试名称
     */
    private String examName;

    /**
     * 试卷ID
     */
    private Long paperId;

    /**
     * 资质ID
     */
    private Long qualificationId;

    /**
     * 考试开始时间
     */
    private Date examStartTime;

    /**
     * 考试结束时间
     */
    private Date examEndTime;

    /**
     * 考生ID列表
     */
    private String examineeIds;

    /**
     * 考试状态 未开始/进行中/已结束
     */
    private String examStatus;

    /**
     * 是否删除
     */
    private Long delFlag;


}
