package org.dromara.cdi.mmp.surgery.domain.bo;

import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryWorkloadStatistics;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 手术工作量统计业务对象 mmp_surgery_workload_statistics
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSurgeryWorkloadStatistics.class, reverseConvertGenerate = false)
public class MmpSurgeryWorkloadStatisticsBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 医师ID
     */
    @NotNull(message = "医师ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long doctorId;

    /**
     * 医师姓名
     */
    private String doctorName;

    /**
     * 手术编码
     */
    @NotBlank(message = "手术编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String surgeryCode;

    /**
     * 手术名称
     */
    @NotBlank(message = "手术名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String surgeryName;

    /**
     * 手术级别
     */
    private String surgeryLevel;

    /**
     * 手术数量
     */
    @NotNull(message = "手术数量不能为空", groups = { AddGroup.class, EditGroup.class })
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
    @NotNull(message = "统计年份不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long statisticsYear;

    /**
     * 统计月份
     */
    @NotNull(message = "统计月份不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long statisticsMonth;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


}
