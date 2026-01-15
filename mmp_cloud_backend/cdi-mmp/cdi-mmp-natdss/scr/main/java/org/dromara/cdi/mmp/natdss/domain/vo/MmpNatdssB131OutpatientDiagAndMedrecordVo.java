package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB131OutpatientDiagAndMedrecord;
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
 * B13-1 门诊病历记录视图对象 mmp_natdss_b13_1_outpatient_diag_and_medrecord
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB131OutpatientDiagAndMedrecord.class)
public class MmpNatdssB131OutpatientDiagAndMedrecordVo implements Serializable {

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
     * 就诊类型:门诊、急诊
     */
    @ExcelProperty(value = "就诊类型:门诊、急诊")
    private String visitType;

    /**
     * 就诊卡号
     */
    @ExcelProperty(value = "就诊卡号")
    private String visitCardNo;

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
     * 就诊时间
     */
    @ExcelProperty(value = "就诊时间")
    private Date visitDatetime;

    /**
     * 病历记录流水号
     */
    @ExcelProperty(value = "病历记录流水号")
    private String recordSn;

    /**
     * 病历记录时间
     */
    @ExcelProperty(value = "病历记录时间")
    private Date recordDatetime;

    /**
     * 病历文书内容
     */
    @ExcelProperty(value = "病历文书内容")
    private String recordText;

    /**
     * 诊疗经过
     */
    @ExcelProperty(value = "诊疗经过")
    private String treatmentInfo;

    /**
     * 操作记录
     */
    @ExcelProperty(value = "操作记录")
    private String operationInfo;

    /**
     * 主诉
     */
    @ExcelProperty(value = "主诉")
    private String chiefComplaint;

    /**
     * 现病史
     */
    @ExcelProperty(value = "现病史")
    private String currentMedhistory;

    /**
     * 既往史
     */
    @ExcelProperty(value = "既往史")
    private String pastMedhistory;

    /**
     * 个人史
     */
    @ExcelProperty(value = "个人史")
    private String personalMedhistory;

    /**
     * 家族史
     */
    @ExcelProperty(value = "家族史")
    private String familyHistory;

    /**
     * 婚育史
     */
    @ExcelProperty(value = "婚育史")
    private String marriageBirthHistory;

    /**
     * 月经史
     */
    @ExcelProperty(value = "月经史")
    private String menstrualHistory;

    /**
     * 体格检查
     */
    @ExcelProperty(value = "体格检查")
    private String physicalExam;

    /**
     * 中医病名
     */
    @ExcelProperty(value = "中医病名")
    private String tcmDiseaseName;

    /**
     * 中医证候
     */
    @ExcelProperty(value = "中医证候")
    private String tcmSyndromeName;

    /**
     * 诊断时间
     */
    @ExcelProperty(value = "诊断时间")
    private Date diagnoseDatetime;

    /**
     * 主要诊断编码
     */
    @ExcelProperty(value = "主要诊断编码")
    private String maindiagCode1;

    /**
     * 主要诊断名称
     */
    @ExcelProperty(value = "主要诊断名称")
    private String maindiagName1;

    /**
     * 诊断编码-2
     */
    @ExcelProperty(value = "诊断编码-2")
    private String diagCode2;

    /**
     * 诊断名称-2
     */
    @ExcelProperty(value = "诊断名称-2")
    private String diagName2;

    /**
     * 诊断编码-3
     */
    @ExcelProperty(value = "诊断编码-3")
    private String diagCode3;

    /**
     * 诊断名称-3
     */
    @ExcelProperty(value = "诊断名称-3")
    private String diagName3;

    /**
     * 诊断编码-4
     */
    @ExcelProperty(value = "诊断编码-4")
    private String diagCode4;

    /**
     * 诊断名称-4
     */
    @ExcelProperty(value = "诊断名称-4")
    private String diagName4;

    /**
     * 诊断编码-5
     */
    @ExcelProperty(value = "诊断编码-5")
    private String diagCode5;

    /**
     * 诊断名称-5
     */
    @ExcelProperty(value = "诊断名称-5")
    private String diagName5;

    /**
     * 诊断编码-6
     */
    @ExcelProperty(value = "诊断编码-6")
    private String diagCode6;

    /**
     * 诊断名称-6
     */
    @ExcelProperty(value = "诊断名称-6")
    private String diagName6;

    /**
     * 诊断编码-7
     */
    @ExcelProperty(value = "诊断编码-7")
    private String diagCode7;

    /**
     * 诊断名称-7
     */
    @ExcelProperty(value = "诊断名称-7")
    private String diagName7;

    /**
     * 诊断编码-8
     */
    @ExcelProperty(value = "诊断编码-8")
    private String diagCode8;

    /**
     * 诊断名称-8
     */
    @ExcelProperty(value = "诊断名称-8")
    private String diagName8;

    /**
     * 诊断编码-9
     */
    @ExcelProperty(value = "诊断编码-9")
    private String diagCode9;

    /**
     * 诊断名称-9
     */
    @ExcelProperty(value = "诊断名称-9")
    private String diagName9;

    /**
     * 诊断编码-10
     */
    @ExcelProperty(value = "诊断编码-10")
    private String diagCode10;

    /**
     * 诊断名称-10
     */
    @ExcelProperty(value = "诊断名称-10")
    private String diagName10;

    /**
     * 诊断编码-N
     */
    @ExcelProperty(value = "诊断编码-N")
    private String diagCoden;

    /**
     * 诊断名称-N
     */
    @ExcelProperty(value = "诊断名称-N")
    private String diagNamen;

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
