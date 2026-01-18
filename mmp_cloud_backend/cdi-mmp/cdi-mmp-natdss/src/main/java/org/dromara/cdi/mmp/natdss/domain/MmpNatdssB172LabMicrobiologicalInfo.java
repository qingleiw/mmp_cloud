package org.dromara.cdi.mmp.natdss.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

import java.io.Serial;

/**
 * B172 微生物检验记录对象 mmp_natdss_b17-2_lab_microbiological_info
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_natdss_b17-2_lab_microbiological_info")
public class MmpNatdssB172LabMicrobiologicalInfo extends BaseEntity {

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
     * 微生物检验流水号
     */
    private String labSn;

    /**
     * 检验时间
     */
    private Date testDatetime;

    /**
     * 报告单号
     */
    private String reportNo;

    /**
     * 报告时间
     */
    private Date reportDatetime;

    /**
     * 标本编号
     */
    private String specimenCode;

    /**
     * 标本来源
     */
    private String sampleType;

    /**
     * 检验方法代码
     */
    private String testMethodCode;

    /**
     * 检验方法
     */
    private String testMethod;

    /**
     * 培养结果
     */
    private String cultivationResult;

    /**
     * 结果代码
     */
    private String resultCode;

    /**
     * 结果阴阳性
     */
    private String resultPosNeg;

    /**
     * 药敏方法
     */
    private String sensTestMethod;

    /**
     * 耐药机制
     */
    private String resisMechanism;

    /**
     * 检测抗生素编码
     */
    private String antibioticsCode;

    /**
     * 检测抗生素名称
     */
    private String antibiotics;

    /**
     * 抗生素检测结果
     */
    private String antibioResult;

    /**
     * 药敏结果
     */
    private String sensitivityResult;

    /**
     * 结果参考值
     */
    private String resultReference;

    /**
     * 多重耐药名称
     */
    private String mdroName;

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
     * 培养代码
     */
    private String cultivationCode;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;


}
