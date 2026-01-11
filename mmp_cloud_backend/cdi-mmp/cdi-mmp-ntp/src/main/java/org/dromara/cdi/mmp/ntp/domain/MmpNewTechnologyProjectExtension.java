package org.dromara.cdi.mmp.ntp.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 新技术延期申请对象 mmp_new_technology_project_extension
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_new_technology_project_extension")
public class MmpNewTechnologyProjectExtension extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 申请编号
     */
    private String applyNo;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 原结束日期
     */
    private Date originalEndDate;

    /**
     * 延期天数
     */
    private Long extendDays;

    /**
     * 新结束日期
     */
    private Date newEndDate;

    /**
     * 延期理由
     */
    private String extensionReason;

    /**
     * 申请状态
     */
    private String applyStatus;

    /**
     * 工作流实例ID
     */
    private Long workflowInstanceId;

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
