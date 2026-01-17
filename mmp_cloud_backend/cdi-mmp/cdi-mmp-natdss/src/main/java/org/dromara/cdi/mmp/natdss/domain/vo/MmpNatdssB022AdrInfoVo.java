package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB022AdrInfo;
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
 * B02-2 患者药物不良反应记录视图对象 mmp_natdss_b02_2_adr_info
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB022AdrInfo.class)
public class MmpNatdssB022AdrInfoVo implements Serializable {

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
     * 姓名
     */
    @ExcelProperty(value = "姓名")
    private String name;

    /**
     * 药品不良反应流水号
     */
    @ExcelProperty(value = "药品不良反应流水号")
    private String adrEventSn;

    /**
     * 药品不良反应报告状态
     */
    @ExcelProperty(value = "药品不良反应报告状态")
    private String adrReportStatus;

    /**
     * 药品不良反应报告类型
     */
    @ExcelProperty(value = "药品不良反应报告类型")
    private String adrReportType;

    /**
     * 报告时间
     */
    @ExcelProperty(value = "报告时间")
    private Date adrReportTime;

    /**
     * 患者原患疾病
     */
    @ExcelProperty(value = "患者原患疾病")
    private String adrOriginalDisease;

    /**
     * 对原患疾病的影响
     */
    @ExcelProperty(value = "对原患疾病的影响")
    private String adrDiseaseInfluence;

    /**
     * 家族药品不良反应
     */
    @ExcelProperty(value = "家族药品不良反应")
    private String adrFamilyStatus;

    /**
     * 既往药品不良反应
     */
    @ExcelProperty(value = "既往药品不良反应")
    private String adrPastStatus;

    /**
     * 其他既往信息
     */
    @ExcelProperty(value = "其他既往信息")
    private String adrPastOther;

    /**
     * 药品不良反应事件名称
     */
    @ExcelProperty(value = "药品不良反应事件名称")
    private String adrEventName;

    /**
     * 不良事件发生时间
     */
    @ExcelProperty(value = "不良事件发生时间")
    private Date adrEventTime;

    /**
     * 不良事件过程描述
     */
    @ExcelProperty(value = "不良事件过程描述")
    private String adrEventContent;

    /**
     * 不良反应结果
     */
    @ExcelProperty(value = "不良反应结果")
    private String adrEventResult;

    /**
     * 停药或减药后是否减轻或消失
     */
    @ExcelProperty(value = "停药或减药后是否减轻或消失")
    private String adrStopStatus;

    /**
     * 再次使用药物后是否出现同样反应
     */
    @ExcelProperty(value = "再次使用药物后是否出现同样反应")
    private String adrReuseStatus;

    /**
     * 怀疑药品批准文号
     */
    @ExcelProperty(value = "怀疑药品批准文号")
    private String suspectDrugApprovalNo;

    /**
     * 怀疑药品编码
     */
    @ExcelProperty(value = "怀疑药品编码")
    private String suspectDrugCode;

    /**
     * 怀疑药品商品名
     */
    @ExcelProperty(value = "怀疑药品商品名")
    private String suspectDrugTradeName;

    /**
     * 怀疑药品通用名
     */
    @ExcelProperty(value = "怀疑药品通用名")
    private String suspectDrugGenericName;

    /**
     * 怀疑药品生产厂商
     */
    @ExcelProperty(value = "怀疑药品生产厂商")
    private String suspectDrugManufac;

    /**
     * 怀疑药品生产批号
     */
    @ExcelProperty(value = "怀疑药品生产批号")
    private String suspectDrugBatchNo;

    /**
     * 怀疑药品用量
     */
    @ExcelProperty(value = "怀疑药品用量")
    private String suspectDrugDosage;

    /**
     * 怀疑药品给药途径
     */
    @ExcelProperty(value = "怀疑药品给药途径")
    private String suspectDrugMethod;

    /**
     * 怀疑药品开始时间
     */
    @ExcelProperty(value = "怀疑药品开始时间")
    private Date suspectDrugStartTime;

    /**
     * 怀疑药品结束时间
     */
    @ExcelProperty(value = "怀疑药品结束时间")
    private Date suspectDrugEndTime;

    /**
     * 怀疑药品用药原因
     */
    @ExcelProperty(value = "怀疑药品用药原因")
    private String suspectDrugReason;

    /**
     * 合并药品批准文号
     */
    @ExcelProperty(value = "合并药品批准文号")
    private String concomitantDrugApprovalNo;

    /**
     * 合并药品编码
     */
    @ExcelProperty(value = "合并药品编码")
    private String concomitantDrugCode;

    /**
     * 合并药品商品名
     */
    @ExcelProperty(value = "合并药品商品名")
    private String concomitantDrugTradeName;

    /**
     * 合并药品通用名
     */
    @ExcelProperty(value = "合并药品通用名")
    private String concomitantDrugGenericName;

    /**
     * 合并药品生产厂商
     */
    @ExcelProperty(value = "合并药品生产厂商")
    private String concomitantDrugManufac;

    /**
     * 合并药品生产批号
     */
    @ExcelProperty(value = "合并药品生产批号")
    private String concomitantDrugBatchNo;

    /**
     * 合并药品用量
     */
    @ExcelProperty(value = "合并药品用量")
    private String concomitantDrugDosage;

    /**
     * 合并药品给药途径
     */
    @ExcelProperty(value = "合并药品给药途径")
    private String concomitantDrugMethod;

    /**
     * 合并药品开始时间
     */
    @ExcelProperty(value = "合并药品开始时间")
    private Date concomitantDrugStartTime;

    /**
     * 合并药品结束时间
     */
    @ExcelProperty(value = "合并药品结束时间")
    private Date concomitantDrugEndTime;

    /**
     * 合并药品用药原因
     */
    @ExcelProperty(value = "合并药品用药原因")
    private String concomitantDrugReason;

    /**
     * 关联性报告人评价
     */
    @ExcelProperty(value = "关联性报告人评价")
    private String adrReporterAppraise;

    /**
     * 关联性报告单位评价
     */
    @ExcelProperty(value = "关联性报告单位评价")
    private String adrReportUnitAppraise;

    /**
     * 扩展字段1:填写怀疑用药或并用药品
     */
    @ExcelProperty(value = "扩展字段1:填写怀疑用药或并用药品")
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
