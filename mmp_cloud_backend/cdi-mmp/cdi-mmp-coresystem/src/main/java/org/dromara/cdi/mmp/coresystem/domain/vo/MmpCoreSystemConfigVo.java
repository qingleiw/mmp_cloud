package org.dromara.cdi.mmp.coresystem.domain.vo;

import org.dromara.cdi.mmp.coresystem.domain.MmpCoreSystemConfig;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 核心制度配置视图对象 mmp_core_system_config
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpCoreSystemConfig.class)
public class MmpCoreSystemConfigVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 制度编码
     */
    @ExcelProperty(value = "制度编码")
    private String systemCode;

    /**
     * 制度名称
     */
    @ExcelProperty(value = "制度名称")
    private String systemName;

    /**
     * 制度类型
     */
    @ExcelProperty(value = "制度类型")
    private String systemType;

    /**
     * 制度描述
     */
    @ExcelProperty(value = "制度描述")
    private String systemDescription;

    /**
     * 制度总分
     */
    @ExcelProperty(value = "制度总分")
    private Long totalScore;

    /**
     * 权重
     */
    @ExcelProperty(value = "权重")
    private Long weight;

    /**
     * 是否启用
     */
    @ExcelProperty(value = "是否启用")
    private Long isEnabled;

    /**
     * 是否自定义 1-是 0-否
     */
    @ExcelProperty(value = "是否自定义 1-是 0-否")
    private Long isCustom;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
