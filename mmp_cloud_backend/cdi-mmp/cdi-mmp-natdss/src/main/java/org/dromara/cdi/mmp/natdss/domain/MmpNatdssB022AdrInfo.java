package org.dromara.cdi.mmp.natdss.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * B02-2 患者药物不良反应记录对象 mmp_natdss_b02_2_adr_info
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_natdss_b02_2_adr_info")
public class MmpNatdssB022AdrInfo extends BaseEntity {

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
     * 病案号
     */
    private String medicalRecordNo;

    /**
     * 门诊号
     */
    private String outpatientNo;

    /**
     * 就诊次数
     */
    private Long visitTimes;

    /**
     * 住院号
     */
    private String inpatientNo;

    /**
     * 住院次数
     */
    private String hospitalizationTimes;

    /**
     * 姓名
     */
    private String name;

    /**
     * 药品不良反应流水号
     */
    private String adrEventSn;

    /**
     * 药品不良反应报告状态
     */
    private String adrReportStatus;

    /**
     * 药品不良反应报告类型
     */
    private String adrReportType;

    /**
     * 报告时间
     */
    private Date adrReportTime;

    /**
     * 患者原患疾病
     */
    private String adrOriginalDisease;

    /**
     * 对原患疾病的影响
     */
    private String adrDiseaseInfluence;

    /**
     * 家族药品不良反应
     */
    private String adrFamilyStatus;

    /**
     * 既往药品不良反应
     */
    private String adrPastStatus;

    /**
     * 其他既往信息
     */
    private String adrPastOther;

    /**
     * 药品不良反应事件名称
     */
    private String adrEventName;

    /**
     * 不良事件发生时间
     */
    private Date adrEventTime;

    /**
     * 不良事件过程描述
     */
    private String adrEventContent;

    /**
     * 不良反应结果
     */
    private String adrEventResult;

    /**
     * 停药或减药后是否减轻或消失
     */
    private String adrStopStatus;

    /**
     * 再次使用药物后是否出现同样反应
     */
    private String adrReuseStatus;

    /**
     * 怀疑药品批准文号
     */
    private String suspectDrugApprovalNo;

    /**
     * 怀疑药品编码
     */
    private String suspectDrugCode;

    /**
     * 怀疑药品商品名
     */
    private String suspectDrugTradeName;

    /**
     * 怀疑药品通用名
     */
    private String suspectDrugGenericName;

    /**
     * 怀疑药品生产厂商
     */
    private String suspectDrugManufac;

    /**
     * 怀疑药品生产批号
     */
    private String suspectDrugBatchNo;

    /**
     * 怀疑药品用量
     */
    private String suspectDrugDosage;

    /**
     * 怀疑药品给药途径
     */
    private String suspectDrugMethod;

    /**
     * 怀疑药品开始时间
     */
    private Date suspectDrugStartTime;

    /**
     * 怀疑药品结束时间
     */
    private Date suspectDrugEndTime;

    /**
     * 怀疑药品用药原因
     */
    private String suspectDrugReason;

    /**
     * 合并药品批准文号
     */
    private String concomitantDrugApprovalNo;

    /**
     * 合并药品编码
     */
    private String concomitantDrugCode;

    /**
     * 合并药品商品名
     */
    private String concomitantDrugTradeName;

    /**
     * 合并药品通用名
     */
    private String concomitantDrugGenericName;

    /**
     * 合并药品生产厂商
     */
    private String concomitantDrugManufac;

    /**
     * 合并药品生产批号
     */
    private String concomitantDrugBatchNo;

    /**
     * 合并药品用量
     */
    private String concomitantDrugDosage;

    /**
     * 合并药品给药途径
     */
    private String concomitantDrugMethod;

    /**
     * 合并药品开始时间
     */
    private Date concomitantDrugStartTime;

    /**
     * 合并药品结束时间
     */
    private Date concomitantDrugEndTime;

    /**
     * 合并药品用药原因
     */
    private String concomitantDrugReason;

    /**
     * 关联性报告人评价
     */
    private String adrReporterAppraise;

    /**
     * 关联性报告单位评价
     */
    private String adrReportUnitAppraise;

    /**
     * 扩展字段1:填写怀疑用药或并用药品
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
