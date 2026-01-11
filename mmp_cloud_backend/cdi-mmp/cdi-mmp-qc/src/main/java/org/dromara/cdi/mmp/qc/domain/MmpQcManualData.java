package org.dromara.cdi.mmp.qc.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 人工补录数据对象 mmp_qc_manual_data
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qc_manual_data")
public class MmpQcManualData extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 指标ID
     */
    private Long indicatorId;

    /**
     * 患者ID
     */
    private Long patientId;

    /**
     * 就诊号
     */
    private String visitNo;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 数据字段
     */
    private String dataField;

    /**
     * 数据值
     */
    private String dataValue;

    /**
     * 数据日期
     */
    private Date dataDate;

    /**
     * 操作类型 新增/修正
     */
    private String operationType;

    /**
     * 原始值
     */
    private String originalValue;

    /**
     * 修改原因
     */
    private String modifyReason;

    /**
     * 是否删除
     */
    private Long delFlag;


}
