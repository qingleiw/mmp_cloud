package org.dromara.cdi.mmp.qualification.domain.bo;

import org.dromara.cdi.mmp.qualification.domain.MmpQualificationUsageRecord;
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
 * 资质使用记录业务对象 mmp_qualification_usage_record
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQualificationUsageRecord.class, reverseConvertGenerate = false)
public class MmpQualificationUsageRecordBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 授权记录ID
     */
    @NotNull(message = "授权记录ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long authorizationId;

    /**
     * 人员ID
     */
    @NotNull(message = "人员ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long staffId;

    /**
     * 资质ID
     */
    @NotNull(message = "资质ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long qualificationId;

    /**
     * 使用时间
     */
    private Date usageDate;

    /**
     * 患者ID
     */
    private Long patientId;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 操作编码
     */
    private String operationCode;

    /**
     * 操作名称
     */
    private String operationName;

    /**
     * 使用结果 正常/异常
     */
    private String usageResult;

    /**
     * 是否超权限 1-是 0-否
     */
    private Long isOverAuthority;

    /**
     * 来源系统
     */
    private String sourceSystem;


}
