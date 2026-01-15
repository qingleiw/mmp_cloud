package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB031InpatientInfo;
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
 * B03-1 住院患者信息视图对象 mmp_natdss_b03_1_inpatient_info
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB031InpatientInfo.class)
public class MmpNatdssB031InpatientInfoVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统自增主键
     */
    @ExcelProperty(value = "系统自增主键")
    private Long id;

    /**
     * 患者ID
     */
    @ExcelProperty(value = "患者ID")
    private String patientId;

    /**
     * 单次就诊唯一标识号
     */
    @ExcelProperty(value = "单次就诊唯一标识号")
    private String visitSn;

    /**
     * 就诊卡号
     */
    @ExcelProperty(value = "就诊卡号")
    private String visitCardNo;

    /**
     * 病案号
     */
    @ExcelProperty(value = "病案号")
    private String medicalRecordNo;

    /**
     * 住院号
     */
    @ExcelProperty(value = "住院号")
    private String inpatientNo;

    /**
     * 住院次数
     */
    @ExcelProperty(value = "住院次数")
    private String hospitalizationTimes;

    /**
     * 姓名
     */
    @ExcelProperty(value = "姓名")
    private String name;

    /**
     * 入院时间
     */
    @ExcelProperty(value = "入院时间")
    private Date admissionDatetime;

    /**
     * 当前科室代码
     */
    @ExcelProperty(value = "当前科室代码")
    private String currentDeptCode;

    /**
     * 当前科室名称
     */
    @ExcelProperty(value = "当前科室名称")
    private String currentDeptName;

    /**
     * 当前病房名称
     */
    @ExcelProperty(value = "当前病房名称")
    private String currentWardName;

    /**
     * 当前床位名称
     */
    @ExcelProperty(value = "当前床位名称")
    private String currentBedName;

    /**
     * 管床医生代码
     */
    @ExcelProperty(value = "管床医生代码")
    private String visitDoctorNo;

    /**
     * 出院时间
     */
    @ExcelProperty(value = "出院时间")
    private Date dischargeDatetime;

    /**
     * 出院科室编码
     */
    @ExcelProperty(value = "出院科室编码")
    private String dischargeDeptCode;

    /**
     * 出院科室名称
     */
    @ExcelProperty(value = "出院科室名称")
    private String dischargeDeptName;

    /**
     * 扩展字段1:出院状态
     */
    @ExcelProperty(value = "扩展字段1:出院状态")
    private String extendData1;

    /**
     * 扩展字段2
     */
    @ExcelProperty(value = "扩展字段2")
    private String extendData2;

    /**
     * 记录状态:1正常 0作废
     */
    @ExcelProperty(value = "记录状态:1正常 0作废")
    private Long recordStatus;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createdTime;

    /**
     * 更新时间
     */
    @ExcelProperty(value = "更新时间")
    private Date updatedTime;


}
