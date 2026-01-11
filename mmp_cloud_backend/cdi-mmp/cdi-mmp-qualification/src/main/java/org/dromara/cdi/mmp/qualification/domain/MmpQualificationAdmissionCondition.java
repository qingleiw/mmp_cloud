package org.dromara.cdi.mmp.qualification.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 资质准入条件对象 mmp_qualification_admission_condition
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qualification_admission_condition")
public class MmpQualificationAdmissionCondition extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 资质ID
     */
    private Long qualificationId;

    /**
     * 资质类型 医师/医技
     */
    private String qualificationType;

    /**
     * 条件类型 学历/职称/工作年限/专业/培训/考核/证书
     */
    private String conditionType;

    /**
     * 条件运算符 =/>/</>=/<=/in
     */
    private String conditionOperator;

    /**
     * 条件值
     */
    private String conditionValue;

    /**
     * 条件单位
     */
    private String conditionUnit;

    /**
     * 是否必须 1-是 0-否
     */
    private Long isRequired;

    /**
     * 逻辑关系 AND/OR
     */
    private String logicRelation;

    /**
     * 排序
     */
    private Long sortOrder;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    private Long delFlag;


}
