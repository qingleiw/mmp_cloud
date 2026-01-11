package org.dromara.cdi.mmp.emergency.domain.vo;

import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyTeam;
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
 * 应急队伍视图对象 mmp_emergency_team
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpEmergencyTeam.class)
public class MmpEmergencyTeamVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 队伍编码
     */
    @ExcelProperty(value = "队伍编码")
    private String teamCode;

    /**
     * 队伍名称
     */
    @ExcelProperty(value = "队伍名称")
    private String teamName;

    /**
     * 队伍类型
     */
    @ExcelProperty(value = "队伍类型")
    private String teamType;

    /**
     * 专业特长
     */
    @ExcelProperty(value = "专业特长")
    private String specialty;

    /**
     * 队长
     */
    @ExcelProperty(value = "队长")
    private String leader;

    /**
     * 联系方式
     */
    @ExcelProperty(value = "联系方式")
    private String contactInfo;

    /**
     * 成员数量
     */
    @ExcelProperty(value = "成员数量")
    private Long memberCount;

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
