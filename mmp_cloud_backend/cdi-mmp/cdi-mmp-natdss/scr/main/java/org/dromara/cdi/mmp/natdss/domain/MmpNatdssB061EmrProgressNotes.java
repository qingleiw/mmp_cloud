package org.dromara.cdi.mmp.natdss.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * B06-1 病程记录对象 mmp_natdss_b06_1_emr_progress_notes
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_natdss_b06_1_emr_progress_notes")
public class MmpNatdssB061EmrProgressNotes extends BaseEntity {

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
     * 病案号
     */
    private String medicalRecordNo;

    /**
     * 住院号
     */
    private String patientNo;

    /**
     * 住院次数
     */
    private String hospitalizationTimes;

    /**
     * 病程记录流水号
     */
    private String recordSn;

    /**
     * 病程记录时间
     */
    private Date recordDatetime;

    /**
     * 病程记录类型代码
     */
    private String recordTitleCode;

    /**
     * 病程记录类型
     */
    private String recordTitle;

    /**
     * 病程记录
     */
    private String recordContent;

    /**
     * 扩展字段1
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
