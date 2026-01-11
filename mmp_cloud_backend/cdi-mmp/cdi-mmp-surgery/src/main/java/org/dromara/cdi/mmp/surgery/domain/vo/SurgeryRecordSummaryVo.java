package org.dromara.cdi.mmp.surgery.domain.vo;

import lombok.Data;

/**
 * 手术记录汇总VO
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
public class SurgeryRecordSummaryVo {

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 手术级别
     */
    private String surgeryLevel;

    /**
     * 医生姓名
     */
    private String doctorName;

    /**
     * 手术数量
     */
    private Integer surgeryCount;

    /**
     * 平均手术时长
     */
    private Double avgDuration;

    /**
     * 总手术时长
     */
    private Integer totalDuration;

}