package org.dromara.cdi.mmp.exam.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 资质考核试卷对象 mmp_exam_paper
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_exam_paper")
public class MmpExamPaper extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 试卷编号
     */
    private String paperCode;

    /**
     * 试卷名称
     */
    private String paperName;

    /**
     * 关联资质ID
     */
    private Long qualificationId;

    /**
     * 总分
     */
    private Long totalScore;

    /**
     * 及格分
     */
    private Long passScore;

    /**
     * 考试时长(分钟)
     */
    private Long examDuration;

    /**
     * 题目ID列表JSON
     */
    private String questionIds;

    /**
     * 是否随机抽题 1-是 0-否
     */
    private Long isRandom;

    /**
     * 随机规则JSON
     */
    private String randomRule;

    /**
     * 是否启用
     */
    private Long isEnabled;

    /**
     * 是否删除
     */
    @TableLogic
    private String delFlag;

    /**
     * 备注
     */
    private String remark;


}
