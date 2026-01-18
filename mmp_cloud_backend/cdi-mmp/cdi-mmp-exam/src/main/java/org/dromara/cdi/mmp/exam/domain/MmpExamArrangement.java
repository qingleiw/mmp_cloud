package org.dromara.cdi.mmp.exam.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 资质考试安排对象 mmp_exam_arrangement
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_exam_arrangement")
public class MmpExamArrangement extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 考试编号
     */
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
    @TableLogic
    private String delFlag;

    /**
     * 备注
     */
    private String remark;


}
