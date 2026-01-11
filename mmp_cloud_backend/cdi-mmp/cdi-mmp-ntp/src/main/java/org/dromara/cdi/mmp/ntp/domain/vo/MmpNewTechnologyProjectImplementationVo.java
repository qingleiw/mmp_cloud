package org.dromara.cdi.mmp.ntp.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectImplementation;
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
 * 新技术实施视图对象 mmp_new_technology_project_implementation
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNewTechnologyProjectImplementation.class)
public class MmpNewTechnologyProjectImplementationVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 项目编号
     */
    @ExcelProperty(value = "项目编号")
    private String projectNo;

    /**
     * 实施状态 0-未开始 1-进行中 2-已完成 3-暂停
     */
    @ExcelProperty(value = "实施状态 0-未开始 1-进行中 2-已完成 3-暂停")
    private Long implementationStatus;

    /**
     * 实施医生
     */
    @ExcelProperty(value = "实施医生")
    private String implementDoctor;

    /**
     * 实施地点
     */
    @ExcelProperty(value = "实施地点")
    private String implementationLocation;

    /**
     * 实施日期
     */
    @ExcelProperty(value = "实施日期")
    private Date implementationDate;

    /**
     * 实施结果
     */
    @ExcelProperty(value = "实施结果")
    private String implementationResult;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long isDeleted;


}
