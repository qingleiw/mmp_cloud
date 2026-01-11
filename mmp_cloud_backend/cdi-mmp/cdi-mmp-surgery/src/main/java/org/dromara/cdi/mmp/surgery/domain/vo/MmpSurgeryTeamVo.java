package org.dromara.cdi.mmp.surgery.domain.vo;

import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryTeam;
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
 * 手术团队视图对象 mmp_surgery_team
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSurgeryTeam.class)
public class MmpSurgeryTeamVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 医生姓名
     */
    @ExcelProperty(value = "医生姓名")
    private String doctorName;

    /**
     * 角色类型 主刀/一助/二助/巡回护士/器械护士/麻醉师
     */
    @ExcelProperty(value = "角色类型 主刀/一助/二助/巡回护士/器械护士/麻醉师")
    private String roleType;

    /**
     * 资格验证 1-已验证 0-未验证
     */
    @ExcelProperty(value = "资格验证 1-已验证 0-未验证")
    private Long qualificationVerify;

    /**
     * 删除标志
     */
    @ExcelProperty(value = "删除标志")
    private String delFlag;


}
