package org.dromara.cdi.mmp.natdss.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * B03-1 住院患者信息对象 mmp_natdss_b03_1_inpatient_info
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_natdss_b03_1_inpatient_info")
public class MmpNatdssB031InpatientInfo extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统自增主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 患者ID
     */
    private String patientId;

    /**
     * 单次就诊唯一标识号
     */
    private String visitSn;

    /**
     * 就诊卡号
     */
    private String visitCardNo;

    /**
     * 病案号
     */
    private String medicalRecordNo;

    /**
     * 住院号
     */
    private String inpatientNo;

    /**
     * 住院次数
     */
    private String hospitalizationTimes;

    /**
     * 姓名
     */
    private String name;

    /**
     * 入院时间
     */
    private Date admissionDatetime;

    /**
     * 当前科室代码
     */
    private String currentDeptCode;

    /**
     * 当前科室名称
     */
    private String currentDeptName;

    /**
     * 当前病房名称
     */
    private String currentWardName;

    /**
     * 当前床位名称
     */
    private String currentBedName;

    /**
     * 管床医生代码
     */
    private String visitDoctorNo;

    /**
     * 出院时间
     */
    private Date dischargeDatetime;

    /**
     * 出院科室编码
     */
    private String dischargeDeptCode;

    /**
     * 出院科室名称
     */
    private String dischargeDeptName;

    /**
     * 扩展字段1:出院状态
     */
    private String extendData1;

    /**
     * 扩展字段2
     */
    private String extendData2;

    /**
     * 记录状态:1正常 0作废
     */
    private Long recordStatus;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;


}
