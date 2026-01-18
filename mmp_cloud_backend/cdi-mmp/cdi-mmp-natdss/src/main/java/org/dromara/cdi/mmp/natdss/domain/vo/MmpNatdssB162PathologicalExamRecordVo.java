package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB162PathologicalExamRecord;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * B162 病理检查记录视图对象 mmp_natdss_b16-2_pathological_exam_record
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB162PathologicalExamRecord.class)
public class MmpNatdssB162PathologicalExamRecordVo implements Serializable {

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
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String name;

    /**
     * 性别
     */
    @ExcelProperty(value = "性别")
    private String gender;

    /**
     * 年龄(岁)
     */
    @ExcelProperty(value = "年龄(岁)")
    private Long age;

    /**
     * 出生日期
     */
    @ExcelProperty(value = "出生日期")
    private Date dateOfBirth;

    /**
     * 申请单号
     */
    @ExcelProperty(value = "申请单号")
    private String applyNo;

    /**
     * 申请医嘱流水号
     */
    @ExcelProperty(value = "申请医嘱流水号")
    private String orderSn;

    /**
     * 申请时间
     */
    @ExcelProperty(value = "申请时间")
    private Date applyDatetime;

    /**
     * 病理号
     */
    @ExcelProperty(value = "病理号")
    private String pathologyNo;

    /**
     * 病理检查流水号
     */
    @ExcelProperty(value = "病理检查流水号")
    private String pathologySn;

    /**
     * 检查时间
     */
    @ExcelProperty(value = "检查时间")
    private Date examDatetime;

    /**
     * 病理检查类型代码
     */
    @ExcelProperty(value = "病理检查类型代码")
    private String pathologyTestTypeCode;

    /**
     * 病理检查类型
     */
    @ExcelProperty(value = "病理检查类型")
    private String pathologyTestType;

    /**
     * 标本部位
     */
    @ExcelProperty(value = "标本部位")
    private String specimenSite;

    /**
     * 标本来源
     */
    @ExcelProperty(value = "标本来源")
    private String specimenObtainMethod;

    /**
     * 标本类型
     */
    @ExcelProperty(value = "标本类型")
    private String specimenType;

    /**
     * 标本编号
     */
    @ExcelProperty(value = "标本编号")
    private String specimenCode;

    /**
     * 标本采集时间
     */
    @ExcelProperty(value = "标本采集时间")
    private Date collectedDatetime;

    /**
     * 标本接收时间
     */
    @ExcelProperty(value = "标本接收时间")
    private Date receivedDatetime;

    /**
     * 报告单号
     */
    @ExcelProperty(value = "报告单号")
    private String reportNo;

    /**
     * 报告时间
     */
    @ExcelProperty(value = "报告时间")
    private Date reportDatetime;

    /**
     * TNM分期版本
     */
    @ExcelProperty(value = "TNM分期版本")
    private String stagingVersion;

    /**
     * 病理分期
     */
    @ExcelProperty(value = "病理分期")
    private String clinicalStage;

    /**
     * pT分期
     */
    @ExcelProperty(value = "pT分期")
    private String pathoTStaging;

    /**
     * pN分期
     */
    @ExcelProperty(value = "pN分期")
    private String pathoNStaging;

    /**
     * pM分期
     */
    @ExcelProperty(value = "pM分期")
    private String pathoMStaging;

    /**
     * 肉眼所见
     */
    @ExcelProperty(value = "肉眼所见")
    private String grossDescription;

    /**
     * 镜下所见
     */
    @ExcelProperty(value = "镜下所见")
    private String microDescription;

    /**
     * 病理诊断结论
     */
    @ExcelProperty(value = "病理诊断结论")
    private String pathoDiagConclusion;

    /**
     * 免疫组化检测结果
     */
    @ExcelProperty(value = "免疫组化检测结果")
    private String ihcResults;

    /**
     * 有无分子检测
     */
    @ExcelProperty(value = "有无分子检测")
    private String molTestMark;

    /**
     * 分子检测项目及方法
     */
    @ExcelProperty(value = "分子检测项目及方法")
    private String molTestGeneAndMethod;

    /**
     * 分子检测结果
     */
    @ExcelProperty(value = "分子检测结果")
    private String molTestResult;

    /**
     * 分化程度
     */
    @ExcelProperty(value = "分化程度")
    private String differentiationDegree;

    /**
     * 血管浸润
     */
    @ExcelProperty(value = "血管浸润")
    private String bloodVesselInfil;

    /**
     * 淋巴浸润
     */
    @ExcelProperty(value = "淋巴浸润")
    private String lymphInfilt;

    /**
     * 淋巴结转移
     */
    @ExcelProperty(value = "淋巴结转移")
    private String lymphMet;

    /**
     * 脉管瘤栓
     */
    @ExcelProperty(value = "脉管瘤栓")
    private String vascTumourThrombus;

    /**
     * 神经侵犯
     */
    @ExcelProperty(value = "神经侵犯")
    private String nerveInvasion;

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
     * 术中冰冻结果
     */
    @ExcelProperty(value = "术中冰冻结果")
    private String intraoperativeFreezingResult;

    /**
     * 记录人1
     */
    @ExcelProperty(value = "记录人1")
    private String recorder1;

    /**
     * 记录人2
     */
    @ExcelProperty(value = "记录人2")
    private String recorder2;

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
