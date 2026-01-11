package org.dromara.cdi.mmp.coresystem.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 制度整改记录对象 mmp_core_system_rectification_record
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_core_system_rectification_record")
public class MmpCoreSystemRectificationRecord extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 整改ID
     */
    private String rectificationId;

    /**
     * 制度ID
     */
    private Long systemId;

    /**
     * 制度名称
     */
    private String systemName;

    /**
     * 整改人ID
     */
    private Long rectifierId;

    /**
     * 整改人名称
     */
    private String rectifierName;

    /**
     * 整改状态(0:进行中,1:已完成,2:已验收)
     */
    private String rectificationStatus;

    /**
     * 开始时间
     */
    private Date rectificationStartTime;

    /**
     * 完成时间
     */
    private Date rectificationEndTime;

    /**
     * 整改内容
     */
    private String rectificationContent;

    /**
     * 整改措施
     */
    private String rectificationMeasures;

    /**
     * 验收结果(1:合格,0:不合格)
     */
    private String acceptanceResult;

    /**
     * 验收意见
     */
    private String acceptanceOpinion;

    /**
     * 删除标志(0:未删除,1:已删除)
     */
    private Long delFlag;


}
