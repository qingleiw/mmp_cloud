package org.dromara.cdi.mmp.coresystem.domain.bo;

import org.dromara.cdi.mmp.coresystem.domain.MmpStatisticsCoreSystem;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 核心制度落实情况监测业务对象 mmp_statistics_core_system
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpStatisticsCoreSystem.class, reverseConvertGenerate = false)
public class MmpStatisticsCoreSystemBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 制度编码
     */
    @NotBlank(message = "制度编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String systemCode;

    /**
     * 制度名称
     */
    @NotBlank(message = "制度名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String systemName;

    /**
     * 执行部门
     */
    private String department;

    /**
     * 监测日期
     */
    @NotNull(message = "监测日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date monitoringDate;

    /**
     * 落实率
     */
    private Long complianceRate;

    /**
     * 执行次数
     */
    private Long executionCount;

    /**
     * 合格次数
     */
    private Long qualifiedCount;

    /**
     * 发现问题
     */
    private String issuesFound;

    /**
     * 改进措施
     */
    private String improvementMeasures;

    /**
     * 下次监测日期
     */
    private Date nextMonitoringDate;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
