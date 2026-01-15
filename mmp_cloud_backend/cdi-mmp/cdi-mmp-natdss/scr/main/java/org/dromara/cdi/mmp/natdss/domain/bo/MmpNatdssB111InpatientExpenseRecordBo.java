package org.dromara.cdi.mmp.natdss.domain.bo;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB111InpatientExpenseRecord;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * B11-1 住院收费记录业务对象 mmp_natdss_b11_1_inpatient_expense_record
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNatdssB111InpatientExpenseRecord.class, reverseConvertGenerate = false)
public class MmpNatdssB111InpatientExpenseRecordBo extends BaseEntity {

    /**
     * 系统自增主键
     */
    @NotNull(message = "系统自增主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 患者ID
     */
    @NotBlank(message = "患者ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String patientId;

    /**
     * 单次就诊唯一标识号
     */
    @NotBlank(message = "单次就诊唯一标识号不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 费用明细流水号
     */
    @NotBlank(message = "费用明细流水号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String expenseSn;

    /**
     * 收据号
     */
    private String receiptNo;

    /**
     * 医嘱流水号
     */
    private String orderSn;

    /**
     * 医嘱类别:长期医嘱、临时医嘱、出院带药
     */
    private String orderType;

    /**
     * 收费时间
     */
    private Date expenseDatetime;

    /**
     * 交易类别代码
     */
    private String transactionTypeCode;

    /**
     * 交易类别名称
     */
    private String transactionTypeName;

    /**
     * 收费项目类型代码
     */
    private String itemTypeCode;

    /**
     * 收费项目类型名称
     */
    private String itemTypeName;

    /**
     * 收费项目代码
     */
    private String itemCode;

    /**
     * 收费项目名称
     */
    private String itemName;

    /**
     * 收费项目单位
     */
    private String itemUnit;

    /**
     * 费用明细项目单价(元)
     */
    private Long itemUnitPrice;

    /**
     * 费用明细项目数量
     */
    private Long itemAmount;

    /**
     * 收费项目总金额(元)
     */
    private Long itemTotalPrice;

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
