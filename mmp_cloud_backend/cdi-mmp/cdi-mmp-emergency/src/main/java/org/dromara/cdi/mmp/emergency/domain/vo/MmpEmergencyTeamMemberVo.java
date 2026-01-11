package org.dromara.cdi.mmp.emergency.domain.vo;

import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyTeamMember;
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
 * 应急队伍成员视图对象 mmp_emergency_team_member
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpEmergencyTeamMember.class)
public class MmpEmergencyTeamMemberVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 成员姓名
     */
    @ExcelProperty(value = "成员姓名")
    private String memberName;

    /**
     * 成员类型
     */
    @ExcelProperty(value = "成员类型")
    private String memberType;

    /**
     * 所在部门
     */
    @ExcelProperty(value = "所在部门")
    private String department;

    /**
     * 职位
     */
    @ExcelProperty(value = "职位")
    private String position;

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
     * 紧急联系人
     */
    @ExcelProperty(value = "紧急联系人")
    private String emergencyContact;

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
