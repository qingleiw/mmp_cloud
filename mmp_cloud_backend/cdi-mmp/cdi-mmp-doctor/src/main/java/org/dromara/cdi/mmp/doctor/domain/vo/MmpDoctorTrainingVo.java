package org.dromara.cdi.mmp.doctor.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorTraining;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 培训记录视图对象 mmp_doctor_training
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDoctorTraining.class)
public class MmpDoctorTrainingVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 医生ID
     */
    @ExcelProperty(value = "医生ID")
    private Long doctorId;

    /**
     * 医生姓名
     */
    @ExcelProperty(value = "医生姓名")
    private String doctorName;

    /**
     * 培训类型 进修/继续教育/院内培训
     */
    @ExcelProperty(value = "培训类型 进修/继续教育/院内培训")
    private String trainingType;

    /**
     * 培训名称
     */
    @ExcelProperty(value = "培训名称")
    private String trainingName;

    /**
     * 培训单位
     */
    @ExcelProperty(value = "培训单位")
    private String trainingUnit;

    /**
     * 开始日期
     */
    @ExcelProperty(value = "开始日期")
    private Date startDate;

    /**
     * 结束日期
     */
    @ExcelProperty(value = "结束日期")
    private Date endDate;

    /**
     * 培训学时
     */
    @ExcelProperty(value = "培训学时")
    private Long trainingHours;

    /**
     * 培训内容
     */
    @ExcelProperty(value = "培训内容")
    private String trainingContent;

    /**
     * 培训结果 合格/不合格
     */
    @ExcelProperty(value = "培训结果 合格/不合格")
    private String trainingResult;

    /**
     * 证书编号
     */
    @ExcelProperty(value = "证书编号")
    private String certificateNo;

    /**
     * 证书附件URL
     */
    @ExcelProperty(value = "证书附件URL")
    private String certificateUrl;

    /**
     * 学分
     */
    @ExcelProperty(value = "学分")
    private Long credits;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
