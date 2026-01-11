package org.dromara.cdi.mmp.supervision.domain.vo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionExpertGroup;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 专家组视图对象 mmp_supervision_expert_group
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSupervisionExpertGroup.class)
public class MmpSupervisionExpertGroupVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 专家组编码
     */
    @ExcelProperty(value = "专家组编码")
    private String groupCode;

    /**
     * 专家组名称
     */
    @ExcelProperty(value = "专家组名称")
    private String groupName;

    /**
     * 专家组类型
     */
    @ExcelProperty(value = "专家组类型")
    private String groupType;

    /**
     * 专业领域
     */
    @ExcelProperty(value = "专业领域")
    private String specialty;

    /**
     * 描述
     */
    @ExcelProperty(value = "描述")
    private String description;

    /**
     * 状态
     */
    @ExcelProperty(value = "状态")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
