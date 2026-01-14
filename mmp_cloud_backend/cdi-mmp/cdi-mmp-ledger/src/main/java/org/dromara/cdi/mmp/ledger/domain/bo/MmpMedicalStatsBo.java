package org.dromara.cdi.mmp.ledger.domain.bo;

import org.dromara.cdi.mmp.ledger.domain.MmpMedicalStats;
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
 * 医疗质量统计数据业务对象 mmp_medical_stats
 *
 * @author Lion Li
 * @date 2025-12-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpMedicalStats.class, reverseConvertGenerate = false)
public class MmpMedicalStatsBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 科室ID
     */
    @NotNull(message = "科室ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long deptId;

    /**
     * 科室名称
     */
    @NotBlank(message = "科室名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String deptName;

    /**
     * 统计日期
     */
    @NotNull(message = "统计日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date statDate;

    /**
     * 新入院患者数
     */
    private Long newAdmissions;

    /**
     * 在院患者数
     */
    private Long inWard;

    /**
     * 危重患者数
     */
    private Long critical;

    /**
     * 出院患者数
     */
    private Long discharged;

    /**
     * 死亡患者数
     */
    private Long deaths;

    /**
     * 转入患者数
     */
    private Long transfersIn;

    /**
     * 转出患者数
     */
    private Long transfersOut;

    /**
     * 关注患者数
     */
    private Long attentionPatients;

    /**
     * 抢救次数
     */
    private Long rescues;

    /**
     * 危急值次数
     */
    private Long criticalValues;

    /**
     * 病危患者数
     */
    private Long criticallyIll;

    /**
     * 病重患者数
     */
    private Long seriouslyIll;

    /**
     * 会诊次数
     */
    private Long consultations;

    /**
     * 住院超30天患者数
     */
    private Long longStayPatients;

    /**
     * 三级手术次数
     */
    private Long level3Surgeries;

    /**
     * 四级手术次数
     */
    private Long level4Surgeries;

    /**
     * 二次手术次数
     */
    private Long secondarySurgeries;

    /**
     * 输血次数
     */
    private Long bloodTransfusions;

    /**
     * 入径患者数
     */
    private Long pathwayEntries;

    /**
     * 抗菌药物使用次数
     */
    private Long antibioticUsage;

    /**
     * 备注
     */
    private String remark;


}
