package org.dromara.cdi.mmp.natdss.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * B01-2 抗肿瘤药物使用记录对象 mmp_natdss_b01_2_drug_use
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_natdss_b01_2_drug_use")
public class MmpNatdssB012DrugUse extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统自增主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 药品使用流水号
     */
    private String presSn;

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
    private Long presUnitPrice;

    /**
     * 使用数量
     */
    private Long presQuantity;

    /**
     * 使用金额
     */
    private Long presTotalPrice;

    /**
     * 来源:门诊/住院
     */
    private String presOrigin;

    /**
     * 收费时间
     */
    private Date presDate;

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
