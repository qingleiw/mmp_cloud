package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB023DiagInfo;
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
 * B02-3 患者诊断记录视图对象 mmp_natdss_b02_3_diag_info
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB023DiagInfo.class)
public class MmpNatdssB023DiagInfoVo implements Serializable {

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
     * 就诊类型:住院、门诊
     */
    @ExcelProperty(value = "就诊类型:住院、门诊")
    private String visitType;

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
     * 门诊号
     */
    @ExcelProperty(value = "门诊号")
    private String outpatientNo;

    /**
     * 就诊次数
     */
    @ExcelProperty(value = "就诊次数")
    private Long visitTimes;

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
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String name;

    /**
     * 诊断ID号
     */
    @ExcelProperty(value = "诊断ID号")
    private String diagId;

    /**
     * 诊断序号
     */
    @ExcelProperty(value = "诊断序号")
    private String diagSerialNumber;

    /**
     * 诊断类型:门诊诊断、入院诊断、出院诊断、其他诊断
     */
    @ExcelProperty(value = "诊断类型:门诊诊断、入院诊断、出院诊断、其他诊断")
    private String diagType;

    /**
     * 诊断编码
     */
    @ExcelProperty(value = "诊断编码")
    private String diagCode;

    /**
     * 诊断名称
     */
    @ExcelProperty(value = "诊断名称")
    private String diagName;

    /**
     * 诊断说明
     */
    @ExcelProperty(value = "诊断说明")
    private String diagExplanation;

    /**
     * 诊断时间
     */
    @ExcelProperty(value = "诊断时间")
    private Date diagDatetime;

    /**
     * 是否明确诊断
     */
    @ExcelProperty(value = "是否明确诊断")
    private String confirmedDiagMark;

    /**
     * 是否主要诊断
     */
    @ExcelProperty(value = "是否主要诊断")
    private String maindiagMark;

    /**
     * 诊断医生代码
     */
    @ExcelProperty(value = "诊断医生代码")
    private String diagDoctorNo;

    /**
     * 扩展字段1
     */
    @ExcelProperty(value = "扩展字段1")
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
