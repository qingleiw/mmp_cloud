package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB051EmrAdmission;
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
 * B05-1 入院记录视图对象 mmp_natdss_b05_1_emr_admission
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB051EmrAdmission.class)
public class MmpNatdssB051EmrAdmissionVo implements Serializable {

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
     * 入院记录流水号
     */
    @ExcelProperty(value = "入院记录流水号")
    private String recordSn;

    /**
     * 入院记录创建时间
     */
    @ExcelProperty(value = "入院记录创建时间")
    private Date recordDatetime;

    /**
     * KPS评分
     */
    @ExcelProperty(value = "KPS评分")
    private String kpsScore;

    /**
     * ECOG PS评分
     */
    @ExcelProperty(value = "ECOG PS评分")
    private String ecogScore;

    /**
     * 文书内容
     */
    @ExcelProperty(value = "文书内容")
    private String recordText;

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
     * 收缩压(mmHg)
     */
    @ExcelProperty(value = "收缩压(mmHg)")
    private String systolicPressure;

    /**
     * 舒张压(mmHg)
     */
    @ExcelProperty(value = "舒张压(mmHg)")
    private String diastolicPressure;

    /**
     * 呼吸(次/分)
     */
    @ExcelProperty(value = "呼吸(次/分)")
    private String respiratoryRate;

    /**
     * 体温(℃)
     */
    @ExcelProperty(value = "体温(℃)")
    private String bodyTemperature;

    /**
     * 心率(次/分)
     */
    @ExcelProperty(value = "心率(次/分)")
    private String heartRate;

    /**
     * 身高(cm)
     */
    @ExcelProperty(value = "身高(cm)")
    private String height;

    /**
     * 体重(kg)
     */
    @ExcelProperty(value = "体重(kg)")
    private String weight;

    /**
     * 体表面积(m²)
     */
    @ExcelProperty(value = "体表面积(m²)")
    private String bodySurfaceArea;

    /**
     * 体格检查
     */
    @ExcelProperty(value = "体格检查")
    private String physicalExam;

    /**
     * 专科检查
     */
    @ExcelProperty(value = "专科检查")
    private String specialExam;

    /**
     * 辅助检查
     */
    @ExcelProperty(value = "辅助检查")
    private String auxiliaryExam;

    /**
     * 入院主要诊断编码
     */
    @ExcelProperty(value = "入院主要诊断编码")
    private String admissionMaindiagCode1;

    /**
     * 入院主要诊断名称
     */
    @ExcelProperty(value = "入院主要诊断名称")
    private String admissionMaindiagName1;

    /**
     * 入院诊断编码-2
     */
    @ExcelProperty(value = "入院诊断编码-2")
    private String admissionDiagCode2;

    /**
     * 入院诊断名称-2
     */
    @ExcelProperty(value = "入院诊断名称-2")
    private String admissionDiagName2;

    /**
     * 入院诊断编码-3
     */
    @ExcelProperty(value = "入院诊断编码-3")
    private String admissionDiagCode3;

    /**
     * 入院诊断名称-3
     */
    @ExcelProperty(value = "入院诊断名称-3")
    private String admissionDiagName3;

    /**
     * 入院诊断编码-4
     */
    @ExcelProperty(value = "入院诊断编码-4")
    private String admissionDiagCode4;

    /**
     * 入院诊断名称-4
     */
    @ExcelProperty(value = "入院诊断名称-4")
    private String admissionDiagName4;

    /**
     * 入院诊断编码-5
     */
    @ExcelProperty(value = "入院诊断编码-5")
    private String admissionDiagCode5;

    /**
     * 入院诊断名称-5
     */
    @ExcelProperty(value = "入院诊断名称-5")
    private String admissionDiagName5;

    /**
     * 入院诊断编码-N
     */
    @ExcelProperty(value = "入院诊断编码-N")
    private String admissionDiagCoden;

    /**
     * 入院诊断名称-N
     */
    @ExcelProperty(value = "入院诊断名称-N")
    private String admissionDiagNamen;

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
