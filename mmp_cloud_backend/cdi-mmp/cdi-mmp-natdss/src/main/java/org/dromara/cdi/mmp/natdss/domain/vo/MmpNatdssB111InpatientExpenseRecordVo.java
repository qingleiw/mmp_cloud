package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB111InpatientExpenseRecord;
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
 * B11-1 住院收费记录视图对象 mmp_natdss_b11_1_inpatient_expense_record
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB111InpatientExpenseRecord.class)
public class MmpNatdssB111InpatientExpenseRecordVo implements Serializable {

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
     * 费用明细流水号
     */
    @ExcelProperty(value = "费用明细流水号")
    private String expenseSn;

    /**
     * 收据号
     */
    @ExcelProperty(value = "收据号")
    private String receiptNo;

    /**
     * 医嘱流水号
     */
    @ExcelProperty(value = "医嘱流水号")
    private String orderSn;

    /**
     * 医嘱类别:长期医嘱、临时医嘱、出院带药
     */
    @ExcelProperty(value = "医嘱类别:长期医嘱、临时医嘱、出院带药")
    private String orderType;

    /**
     * 收费时间
     */
    @ExcelProperty(value = "收费时间")
    private Date expenseDatetime;

    /**
     * 交易类别代码
     */
    @ExcelProperty(value = "交易类别代码")
    private String transactionTypeCode;

    /**
     * 交易类别名称
     */
    @ExcelProperty(value = "交易类别名称")
    private String transactionTypeName;

    /**
     * 收费项目类型代码
     */
    @ExcelProperty(value = "收费项目类型代码")
    private String itemTypeCode;

    /**
     * 收费项目类型名称
     */
    @ExcelProperty(value = "收费项目类型名称")
    private String itemTypeName;

    /**
     * 收费项目代码
     */
    @ExcelProperty(value = "收费项目代码")
    private String itemCode;

    /**
     * 收费项目名称
     */
    @ExcelProperty(value = "收费项目名称")
    private String itemName;

    /**
     * 收费项目单位
     */
    @ExcelProperty(value = "收费项目单位")
    private String itemUnit;

    /**
     * 费用明细项目单价(元)
     */
    @ExcelProperty(value = "费用明细项目单价(元)")
    private Long itemUnitPrice;

    /**
     * 费用明细项目数量
     */
    @ExcelProperty(value = "费用明细项目数量")
    private Long itemAmount;

    /**
     * 收费项目总金额(元)
     */
    @ExcelProperty(value = "收费项目总金额(元)")
    private Long itemTotalPrice;

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
