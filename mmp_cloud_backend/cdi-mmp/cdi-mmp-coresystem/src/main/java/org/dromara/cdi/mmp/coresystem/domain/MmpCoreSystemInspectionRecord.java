package org.dromara.cdi.mmp.coresystem.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 制度检查记录对象 mmp_core_system_inspection_record
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_core_system_inspection_record")
public class MmpCoreSystemInspectionRecord extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 检查ID
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
     * 检查人ID
     */
    private Long inspectorId;

    /**
     * 检查人姓名
     */
    private String inspectorName;

    /**
     * 检查时间
     */
    private Date inspectionTime;

    /**
     * 检查结果 1-合格 0-不合格
     */
    private String inspectionResult;

    /**
     * 检查内容
     */
    private String inspectionContent;

    /**
     * 问题描述
     */
    private String problemDescription;

    /**
     * 整改建议
     */
    private String rectificationSuggestion;

    /**
     * 是否删除 0-未删除 1-已删除
     */
    private String delFlag;


}
