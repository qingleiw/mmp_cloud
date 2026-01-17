package org.dromara.cdi.mmp.exam.domain.bo;

import org.dromara.cdi.mmp.exam.domain.MmpQualificationExamRecord;
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
 * 资质考试记录业务对象 mmp_qualification_exam_record
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQualificationExamRecord.class, reverseConvertGenerate = false)
public class MmpQualificationExamRecordBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 考试安排ID
     */
    @NotNull(message = "考试安排ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long examId;

    /**
     * 考生ID
     */
    @NotNull(message = "考生ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long examineeId;

    /**
     * 考生姓名
     */
    private String examineeName;

    /**
     * 试卷ID
     */
    private Long paperId;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 提交时间
     */
    private Date submitTime;

    /**
     * 答题卡JSON
     */
    private String answerSheet;

    /**
     * 客观题得分
     */
    private Long objectiveScore;

    /**
     * 主观题得分
     */
    private Long subjectiveScore;

    /**
     * 总分
     */
    private Long totalScore;

    /**
     * 考试结果 及格/不及格
     */
    private String examResult;

    /**
     * 阅卷状态
     */
    private String markingStatus;

    /**
     * 阅卷人
     */
    private String marker;

    /**
     * 阅卷时间
     */
    private Date markingTime;


}
