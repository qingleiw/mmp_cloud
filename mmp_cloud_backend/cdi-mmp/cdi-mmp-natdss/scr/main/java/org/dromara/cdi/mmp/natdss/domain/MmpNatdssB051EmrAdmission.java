package org.dromara.cdi.mmp.natdss.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * B05-1 入院记录对象 mmp_natdss_b05_1_emr_admission
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_natdss_b05_1_emr_admission")
public class MmpNatdssB051EmrAdmission extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统自增主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 患者ID
     */
    private String patientId;

    /**
     * 单次就诊唯一标识号
     */
    private String visitSn;

    /**
     * 病案号
     */
    private String medicalRecordNo;

    /**
     * 住院号
     */
    private String inpatientNo;

    /**
     * 住院次数
     */
    private String hospitalizationTimes;

    /**
     * 入院记录流水号
     */
    private String recordSn;

    /**
     * 入院记录创建时间
     */
    private Date recordDatetime;

    /**
     * KPS评分
     */
    private String kpsScore;

    /**
     * ECOG PS评分
     */
    private String ecogScore;

    /**
     * 文书内容
     */
    private String recordText;

    /**
     * 主诉
     */
    private String chiefComplaint;

    /**
     * 现病史
     */
    private String currentMedhistory;

    /**
     * 既往史
     */
    private String pastMedhistory;

    /**
     * 个人史
     */
    private String personalMedhistory;

    /**
     * 家族史
     */
    private String familyHistory;

    /**
     * 婚育史
     */
    private String marriageBirthHistory;

    /**
     * 月经史
     */
    private String menstrualHistory;

    /**
     * 收缩压(mmHg)
     */
    private String systolicPressure;

    /**
     * 舒张压(mmHg)
     */
    private String diastolicPressure;

    /**
     * 呼吸(次/分)
     */
    private String respiratoryRate;

    /**
     * 体温(℃)
     */
    private String bodyTemperature;

    /**
     * 心率(次/分)
     */
    private String heartRate;

    /**
     * 身高(cm)
     */
    private String height;

    /**
     * 体重(kg)
     */
    private String weight;

    /**
     * 体表面积(m²)
     */
    private String bodySurfaceArea;

    /**
     * 体格检查
     */
    private String physicalExam;

    /**
     * 专科检查
     */
    private String specialExam;

    /**
     * 辅助检查
     */
    private String auxiliaryExam;

    /**
     * 入院主要诊断编码
     */
    private String admissionMaindiagCode1;

    /**
     * 入院主要诊断名称
     */
    private String admissionMaindiagName1;

    /**
     * 入院诊断编码-2
     */
    private String admissionDiagCode2;

    /**
     * 入院诊断名称-2
     */
    private String admissionDiagName2;

    /**
     * 入院诊断编码-3
     */
    private String admissionDiagCode3;

    /**
     * 入院诊断名称-3
     */
    private String admissionDiagName3;

    /**
     * 入院诊断编码-4
     */
    private String admissionDiagCode4;

    /**
     * 入院诊断名称-4
     */
    private String admissionDiagName4;

    /**
     * 入院诊断编码-5
     */
    private String admissionDiagCode5;

    /**
     * 入院诊断名称-5
     */
    private String admissionDiagName5;

    /**
     * 入院诊断编码-N
     */
    private String admissionDiagCoden;

    /**
     * 入院诊断名称-N
     */
    private String admissionDiagNamen;

    /**
     * 扩展字段1
     */
    private String extendData1;

    /**
     * 扩展字段2
     */
    private String extendData2;

    /**
     * 记录状态:1正常 0作废
     */
    private Long recordStatus;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;


}
