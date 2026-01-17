package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB012DrugUse;
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
 * B01-2 抗肿瘤药物使用记录视图对象 mmp_natdss_b01_2_drug_use
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB012DrugUse.class)
public class MmpNatdssB012DrugUseVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统自增主键
     */
    @ExcelProperty(value = "系统自增主键")
    private Long id;

    /**
     * 药品使用流水号
     */
    @ExcelProperty(value = "药品使用流水号")
    private String presSn;

    /**
     * 本院药品编码
     */
    @ExcelProperty(value = "本院药品编码")
    private String hosDrugCode;

    /**
     * 药品通用名
     */
    @ExcelProperty(value = "药品通用名")
    private String genericName;

    /**
     * 药品商品名
     */
    @ExcelProperty(value = "药品商品名")
    private String tradeName;

    /**
     * 生产厂家
     */
    @ExcelProperty(value = "生产厂家")
    private String manufac;

    /**
     * 批准文号
     */
    @ExcelProperty(value = "批准文号")
    private String approvalNo;

    /**
     * 药品剂型
     */
    @ExcelProperty(value = "药品剂型")
    private String form;

    /**
     * 药品规格
     */
    @ExcelProperty(value = "药品规格")
    private String spec;

    /**
     * 包装数量
     */
    @ExcelProperty(value = "包装数量")
    private String packingQuantity;

    /**
     * 包装单位
     */
    @ExcelProperty(value = "包装单位")
    private String packingUnit;

    /**
     * 药品单价
     */
    @ExcelProperty(value = "药品单价")
    private Long presUnitPrice;

    /**
     * 使用数量
     */
    @ExcelProperty(value = "使用数量")
    private Long presQuantity;

    /**
     * 使用金额
     */
    @ExcelProperty(value = "使用金额")
    private Long presTotalPrice;

    /**
     * 来源:门诊/住院
     */
    @ExcelProperty(value = "来源:门诊/住院")
    private String presOrigin;

    /**
     * 收费时间
     */
    @ExcelProperty(value = "收费时间")
    private Date presDate;

    /**
     * 费用类型
     */
    @ExcelProperty(value = "费用类型")
    private String insuranceType;

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
