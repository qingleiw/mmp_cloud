package org.dromara.cdi.mmp.exam.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 资质考试记录对象 mmp_qualification_exam_record
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qualification_exam_record")
public class MmpQualificationExamRecord extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 考试安排ID
     */
    private Long examId;

    /**
     * 考生ID
     */
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

    /**
     * 创建部门 - 此表不包含此字段
     */
    @TableField(exist = false)
    private Long createDept;

    /**
     * 创建者 - 此表不包含此字段
     */
    @TableField(exist = false)
    private Long createBy;

    /**
     * 更新时间 - 此表不包含此字段
     */
    @TableField(exist = false)
    private Date updateTime;

    /**
     * 更新者 - 此表不包含此字段
     */
    @TableField(exist = false)
    private Long updateBy;

}
