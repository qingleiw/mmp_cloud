package org.dromara.cdi.mmp.natdss.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

import java.io.Serial;

/**
 * B163 分子病理检测记录对象 mmp_natdss_b16-3_molecular_pathology_exam_record
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_natdss_b16-3_molecular_pathology_exam_record")
public class MmpNatdssB163MolecularPathologyExamRecord extends BaseEntity {

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
     * 就诊类型:住院、门诊
     */
    private String visitType;

    /**
     * 就诊卡号
     */
    private String visitCardNo;

    /**
     * 门诊号
     */
    private String outpatientNo;

    /**
     * 就诊次数
     */
    private Long visitTimes;

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
     * 患者姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄(岁)
     */
    private Long age;

    /**
     * 出生日期
     */
    private Date dateOfBirth;

    /**
     * 申请单号
     */
    private String applyNo;

    /**
     * 申请医嘱流水号
     */
    private String orderSn;

    /**
     * 申请时间
     */
    private Date applyDatetime;

    /**
     * 分子病理号
     */
    private String molPathoNo;

    /**
     * 检测流水号
     */
    private String labSn;

    /**
     * 检测时间
     */
    private Date examDatetime;

    /**
     * 标本编号
     */
    private String sampleNo;

    /**
     * 标本类型
     */
    private String sampleType;

    /**
     * 检测平台
     */
    private String testPlatform;

    /**
     * 检测项目
     */
    private String testItem;

    /**
     * 检测方法
     */
    private String testMethod;

    /**
     * 检测内容
     */
    private String testContent;

    /**
     * 检测结果
     */
    private String testResult;

    /**
     * 报告单号
     */
    private String reportNo;

    /**
     * 报告时间
     */
    private Date reportDatetime;

    /**
     * 外显子
     */
    private String testExon;

    /**
     * 位点
     */
    private String testLocus;

    /**
     * 检测基因
     */
    private String testGene;

    /**
     * 转录本
     */
    private String transcript;

    /**
     * 核苷酸改变
     */
    private String nucleAlt;

    /**
     * 氨基酸改变
     */
    private String aminoAcidAlt;

    /**
     * 丰度
     */
    private String mutAbundance;

    /**
     * 变异类型
     */
    private String variationType;

    /**
     * 变异解读
     */
    private String mutInterpretation;

    /**
     * 基因型
     */
    private String genoType;

    /**
     * 取材部位
     */
    private String samplingSite;

    /**
     * 测序深度
     */
    private String geneSequencingDepth;

    /**
     * 肿瘤突变负荷
     */
    private String tmb;

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
