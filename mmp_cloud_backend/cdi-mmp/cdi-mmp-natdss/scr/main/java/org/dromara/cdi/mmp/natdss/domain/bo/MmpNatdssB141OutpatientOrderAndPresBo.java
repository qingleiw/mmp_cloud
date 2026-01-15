package org.dromara.cdi.mmp.natdss.domain.bo;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB141OutpatientOrderAndPres;
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
 * B14-1 门诊医嘱处方记录业务对象 mmp_natdss_b14_1_outpatient_order_and_pres
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNatdssB141OutpatientOrderAndPres.class, reverseConvertGenerate = false)
public class MmpNatdssB141OutpatientOrderAndPresBo extends BaseEntity {

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
     * 医嘱流水号
     */
    @NotBlank(message = "医嘱流水号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String orderSn;

    /**
     * 医技申请单号
     */
    private String requestNo;

    /**
     * 医嘱开具时间
     */
    private Date orderGivenTime;

    /**
     * 就诊科室代码
     */
    private String visitDeptCode;

    /**
     * 就诊科室名称
     */
    private String visitDeptName;

    /**
     * 医嘱下达科室代码
     */
    private String orderDeptCode;

    /**
     * 医嘱下达科室名称
     */
    private String orderDeptName;

    /**
     * 医嘱开单医生代码
     */
    private String orderDoctorNo;

    /**
     * 职称名称
     */
    private String technicalTitle;

    /**
     * 职务名称
     */
    private String jobTitle;

    /**
     * 医嘱执行科室代码
     */
    private String executiveDeptCode;

    /**
     * 医嘱执行科室名称
     */
    private String executiveDeptName;

    /**
     * 处方分类代码
     */
    private String prescriptionClassCode;

    /**
     * 处方分类名称
     */
    private String prescriptionClassName;

    /**
     * 医嘱分类代码
     */
    private String orderClassCode;

    /**
     * 医嘱分类名称
     */
    private String orderClassName;

    /**
     * 医嘱项目代码
     */
    private String orderItemCode;

    /**
     * 医嘱项目名称
     */
    private String orderItemName;

    /**
     * 医嘱组号
     */
    private String orderGroupNo;

    /**
     * 单次剂量
     */
    private Long dose;

    /**
     * 剂量单位
     */
    private String doseUnit;

    /**
     * 药品剂型
     */
    private String form;

    /**
     * 规格
     */
    private String spec;

    /**
     * 使用频率代码
     */
    private String frequencyCode;

    /**
     * 使用频率
     */
    private String frequency;

    /**
     * 给药途径
     */
    private String administrationRoute;

    /**
     * 液体配置
     */
    private String liquidConfiguration;

    /**
     * 注射方式
     */
    private String injectionType;

    /**
     * 用药顺序
     */
    private String drugOrder;

    /**
     * 用药配伍
     */
    private String drugCompatibility;

    /**
     * 输液时长
     */
    private String infusionDuration;

    /**
     * 使用天数
     */
    private Long daysOfMedication;

    /**
     * 药品使用总剂量
     */
    private Long totalDose;

    /**
     * 总量单位
     */
    private String totalDoseUnit;

    /**
     * 医嘱数量
     */
    private String numOfOrders;

    /**
     * 医嘱数量单位
     */
    private String numOfOrdersUnit;

    /**
     * 医嘱备注
     */
    private String orderNote;

    /**
     * 草药备注
     */
    private String herbalNote;

    /**
     * 是否药品
     */
    private String drugFlag;

    /**
     * 生产厂家
     */
    private String manufac;

    /**
     * 药品商品名
     */
    private String tradeName;

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
