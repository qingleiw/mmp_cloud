package org.dromara.cdi.mmp.ntp.domain.bo;

import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectCase;
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
 * 新技术病例登记业务对象 mmp_new_technology_project_case
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNewTechnologyProjectCase.class, reverseConvertGenerate = false)
public class MmpNewTechnologyProjectCaseBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long projectId;

    /**
     * 患者ID
     */
    @NotNull(message = "患者ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long patientId;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 就诊类型 门诊/住院
     */
    private String visitType;

    /**
     * 就诊号
     */
    private String visitNo;

    /**
     * 就诊日期
     */
    private Date visitDate;

    /**
     * 就诊科室ID
     */
    private Long visitDepartmentId;

    /**
     * 就诊科室名称
     */
    private String visitDepartmentName;

    /**
     * 诊断
     */
    private String diagnosis;

    /**
     * 操作医生
     */
    private String operator;

    /**
     * 操作时间
     */
    private Date operationDate;

    /**
     * 效果评价
     */
    private String effectEvaluation;

    /**
     * 并发症
     */
    private String complication;

    /**
     * 不良反应
     */
    private String adverseReaction;

    /**
     * 随访状态
     */
    private String followUpStatus;

    /**
     * 随访结果
     */
    private String followUpResult;

    /**
     * 是否已报备 1-是 0-否
     */
    private Long isReported;

    /**
     * 报备时间
     */
    private Date reportTime;

    /**
     * 备注
     */
    private String remark;


}
