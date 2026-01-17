package org.dromara.cdi.mmp.natdss.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * B01-1 抗肿瘤药物采购记录对象 mmp_natdss_b01_1_drug_purchase
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_natdss_b01_1_drug_purchase")
public class MmpNatdssB011DrugPurchase extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统自增主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 药品入库明细流水号
     */
    private String purSn;

    /**
     * 本院药品编码
     */
    private String hosDrugCode;

    /**
     * 药品通用名
     */
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
