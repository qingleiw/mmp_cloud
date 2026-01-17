package org.dromara.cdi.mmp.natdss.domain.bo;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB151OutpatientExpenseRecord;
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
 * B15-1 门诊收费记录业务对象 mmp_natdss_b15_1_outpatient_expense_record
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNatdssB151OutpatientExpenseRecord.class, reverseConvertGenerate = false)
public class MmpNatdssB151OutpatientExpenseRecordBo extends BaseEntity {

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
     * 就诊类型:门诊、急诊
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
     * 收费记录明细流水号
     */
    @NotBlank(message = "收费记录明细流水号不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 费用明细项目金额(元)
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
