package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB16-3MolecularPathologyExamRecord;
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
 * B16-3 分子病理检测记录视图对象 mmp_natdss_b16-3_molecular_pathology_exam_record
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB16-3MolecularPathologyExamRecord.class)
public class MmpNatdssB16-3MolecularPathologyExamRecordVo implements Serializable {

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
     * 分子病理号
     */
    @ExcelProperty(value = "分子病理号")
    private String molPathoNo;

    /**
     * 检测流水号
     */
    @ExcelProperty(value = "检测流水号")
    private String labSn;

    /**
     * 检测时间
     */
    @ExcelProperty(value = "检测时间")
    private Date examDatetime;

    /**
     * 标本编号
     */
    @ExcelProperty(value = "标本编号")
    private String sampleNo;

    /**
     * 标本类型
     */
    @ExcelProperty(value = "标本类型")
    private String sampleType;

    /**
     * 检测平台
     */
    @ExcelProperty(value = "检测平台")
    private String testPlatform;

    /**
     * 检测项目
     */
    @ExcelProperty(value = "检测项目")
    private String testItem;

    /**
     * 检测方法
     */
    @ExcelProperty(value = "检测方法")
    private String testMethod;

    /**
     * 检测内容
     */
    @ExcelProperty(value = "检测内容")
    private String testContent;

    /**
     * 检测结果
     */
    @ExcelProperty(value = "检测结果")
    private String testResult;

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
     * 外显子
     */
    @ExcelProperty(value = "外显子")
    private String testExon;

    /**
     * 位点
     */
    @ExcelProperty(value = "位点")
    private String testLocus;

    /**
     * 检测基因
     */
    @ExcelProperty(value = "检测基因")
    private String testGene;

    /**
     * 转录本
     */
    @ExcelProperty(value = "转录本")
    private String transcript;

    /**
     * 核苷酸改变
     */
    @ExcelProperty(value = "核苷酸改变")
    private String nucleAlt;

    /**
     * 氨基酸改变
     */
    @ExcelProperty(value = "氨基酸改变")
    private String aminoAcidAlt;

    /**
     * 丰度
     */
    @ExcelProperty(value = "丰度")
    private String mutAbundance;

    /**
     * 变异类型
     */
    @ExcelProperty(value = "变异类型")
    private String variationType;

    /**
     * 变异解读
     */
    @ExcelProperty(value = "变异解读")
    private String mutInterpretation;

    /**
     * 基因型
     */
    @ExcelProperty(value = "基因型")
    private String genoType;

    /**
     * 取材部位
     */
    @ExcelProperty(value = "取材部位")
    private String samplingSite;

    /**
     * 测序深度
     */
    @ExcelProperty(value = "测序深度")
    private String geneSequencingDepth;

    /**
     * 肿瘤突变负荷
     */
    @ExcelProperty(value = "肿瘤突变负荷")
    private String tmb;

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
