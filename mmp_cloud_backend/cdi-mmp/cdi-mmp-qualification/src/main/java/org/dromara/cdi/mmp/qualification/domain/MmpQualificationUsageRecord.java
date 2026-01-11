package org.dromara.cdi.mmp.qualification.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 资质使用记录对象 mmp_qualification_usage_record
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qualification_usage_record")
public class MmpQualificationUsageRecord extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 授权记录ID
     */
    private Long authorizationId;

    /**
     * 人员ID
     */
    private Long staffId;

    /**
     * 资质ID
     */
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
