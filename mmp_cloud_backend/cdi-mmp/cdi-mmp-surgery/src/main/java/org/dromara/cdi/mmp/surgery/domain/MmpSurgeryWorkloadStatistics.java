package org.dromara.cdi.mmp.surgery.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 手术工作量统计对象 mmp_surgery_workload_statistics
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_surgery_workload_statistics")
public class MmpSurgeryWorkloadStatistics extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 医师ID
     */
    private Long doctorId;

    /**
     * 医师姓名
     */
    private String doctorName;

    /**
     * 手术编码
     */
    private String surgeryCode;

    /**
     * 手术名称
     */
    private String surgeryName;

    /**
     * 手术级别
     */
    private String surgeryLevel;

    /**
     * 手术数量
     */
    private Long surgeryCount;

    /**
     * 主刀次数
     */
    private Long mainOperatorCount;

    /**
     * 一助次数
     */
    private Long firstAssistantCount;

    /**
     * 统计年份
     */
    private Long statisticsYear;

    /**
     * 统计月份
     */
    private Long statisticsMonth;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
