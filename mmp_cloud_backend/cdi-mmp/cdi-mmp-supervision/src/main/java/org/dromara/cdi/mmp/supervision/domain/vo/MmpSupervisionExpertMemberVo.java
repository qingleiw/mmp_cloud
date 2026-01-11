package org.dromara.cdi.mmp.supervision.domain.vo;

import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionExpertMember;
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
 * 专家组成员视图对象 mmp_supervision_expert_member
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSupervisionExpertMember.class)
public class MmpSupervisionExpertMemberVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 专家姓名
     */
    @ExcelProperty(value = "专家姓名")
    private String expertName;

    /**
     * 专家职称
     */
    @ExcelProperty(value = "专家职称")
    private String expertTitle;

    /**
     * 所在医院
     */
    @ExcelProperty(value = "所在医院")
    private String hospital;

    /**
     * 专业特长
     */
    @ExcelProperty(value = "专业特长")
    private String specialty;

    /**
     * 联系方式
     */
    @ExcelProperty(value = "联系方式")
    private String contactInfo;

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
