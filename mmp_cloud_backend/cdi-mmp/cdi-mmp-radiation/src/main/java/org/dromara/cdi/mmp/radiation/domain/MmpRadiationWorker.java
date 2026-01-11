package org.dromara.cdi.mmp.radiation.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 放射工作人员对象 mmp_radiation_worker
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_radiation_worker")
public class MmpRadiationWorker extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 工作人员编码
     */
    private String workerCode;

    /**
     * 工作人员姓名
     */
    private String workerName;

    /**
     * 所属部门
     */
    private String department;

    /**
     * 职位
     */
    private String position;

    /**
     * 接触辐射类型
     */
    private String radiationType;

    /**
     * 入职日期
     */
    private Date employmentDate;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 紧急联系人
     */
    private String emergencyContact;

    /**
     * 健康状况
     */
    private String healthStatus;

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
