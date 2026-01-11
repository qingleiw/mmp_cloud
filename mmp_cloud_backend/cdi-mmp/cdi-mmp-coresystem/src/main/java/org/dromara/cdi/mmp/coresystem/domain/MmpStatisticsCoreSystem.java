package org.dromara.cdi.mmp.coresystem.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 核心制度落实情况监测对象 mmp_statistics_core_system
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_statistics_core_system")
public class MmpStatisticsCoreSystem extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 制度编码
     */
    private String systemCode;

    /**
     * 制度名称
     */
    private String systemName;

    /**
     * 执行部门
     */
    private String department;

    /**
     * 监测日期
     */
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
     * 是否删除
     */
    @TableLogic
    private Long delFlag;

    /**
     * 备注
     */
    private String remark;


}
