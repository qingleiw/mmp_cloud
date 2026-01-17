package org.dromara.cdi.mmp.natdss.domain.bo;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB011DrugPurchase;
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
 * B01-1 抗肿瘤药物采购记录业务对象 mmp_natdss_b01_1_drug_purchase
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNatdssB011DrugPurchase.class, reverseConvertGenerate = false)
public class MmpNatdssB011DrugPurchaseBo extends BaseEntity {

    /**
     * 系统自增主键
     */
    @NotNull(message = "系统自增主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 药品入库明细流水号
     */
    @NotBlank(message = "药品入库明细流水号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String purSn;

    /**
     * 本院药品编码
     */
    @NotBlank(message = "本院药品编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String hosDrugCode;

    /**
     * 药品通用名
     */
    @NotBlank(message = "药品通用名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String genericName;

    /**
     * 药品商品名
     */
    private String tradeName;

    /**
     * 生产厂家
     */
    private String manufac;

    /**
     * 批准文号
     */
    private String approvalNo;

    /**
     * 药品剂型
     */
    private String form;

    /**
     * 药品规格
     */
    private String spec;

    /**
     * 包装数量
     */
    private String packingQuantity;

    /**
     * 包装单位
     */
    private String packingUnit;

    /**
     * 药品单价
     */
    private Long purUnitPrice;

    /**
     * 采购数量
     */
    private Long purQuantity;

    /**
     * 采购金额
     */
    private Long purTotalPrice;

    /**
     * 采购时间
     */
    @NotNull(message = "采购时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date purDate;

    /**
     * 费用类型
     */
    private String insuranceType;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;


}
