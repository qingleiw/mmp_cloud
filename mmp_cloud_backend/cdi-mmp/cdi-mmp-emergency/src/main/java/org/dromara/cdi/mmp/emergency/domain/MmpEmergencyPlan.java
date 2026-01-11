package org.dromara.cdi.mmp.emergency.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 应急预案对象 mmp_emergency_plan
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_emergency_plan")
public class MmpEmergencyPlan extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 预案编码
     */
    private String planCode;

    /**
     * 预案名称
     */
    private String planName;

    /**
     * 预案类型：fire-消防预案，medical-医疗应急预案，disaster-灾害预案，infection-感染控制预案
     */
    private String planType;

    /**
     * 版本号
     */
    @Version
    private String version;

    /**
     * 状态：draft-草稿，review-审核中，approved-已批准，archived-已归档
     */
    private String status;

    /**
     * 生效日期
     */
    private Date effectiveDate;

    /**
     * 审核日期
     */
    private Date reviewDate;

    /**
     * 下次审核日期
     */
    private Date nextReviewDate;

    /**
     * 关键词
     */
    private String keywords;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 上传者
     */
    private String uploadBy;

    /**
     * 上传时间
     */
    private Date uploadTime;

    /**
     * 批准人
     */
    private String approveBy;

    /**
     * 批准时间
     */
    private Date approveTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Long delFlag;

    /**
     * 备注
     */
    private String remark;


}
