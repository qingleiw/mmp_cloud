package org.dromara.cdi.mmp.qc.domain.bo;

import org.dromara.cdi.mmp.qc.domain.MmpQcManualData;
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
 * 人工补录数据业务对象 mmp_qc_manual_data
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQcManualData.class, reverseConvertGenerate = false)
public class MmpQcManualDataBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 指标ID
     */
    @NotNull(message = "指标ID不能为空", groups = { AddGroup.class, EditGroup.class })
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
