package org.dromara.cdi.mmp.coresystem.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 制度执行记录对象 mmp_core_system_execution_record
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_core_system_execution_record")
public class MmpCoreSystemExecutionRecord extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 执行ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 制度ID
     */
    private Long systemId;

    /**
     * 制度名称
     */
    private String systemName;

    /**
     * 执行人ID
     */
    private Long executorId;

    /**
     * 执行人姓名
     */
    private String executorName;

    /**
     * 执行时间
     */
    private Date executionTime;

    /**
     * 执行结果 1-成功 0-失败
     */
    private String executionResult;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除 0-未删除 1-已删除
     */
    private String delFlag;


}
