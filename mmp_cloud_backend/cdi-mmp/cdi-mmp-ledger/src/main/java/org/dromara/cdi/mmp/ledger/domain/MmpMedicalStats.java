package org.dromara.cdi.mmp.ledger.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 医疗质量统计数据对象 mmp_medical_stats
 *
 * @author Lion Li
 * @date 2025-12-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_medical_stats")
public class MmpMedicalStats extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 科室ID
     */
    private Long deptId;

    /**
     * 科室名称
     */
    private String deptName;

    /**
     * 统计日期
     */
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
