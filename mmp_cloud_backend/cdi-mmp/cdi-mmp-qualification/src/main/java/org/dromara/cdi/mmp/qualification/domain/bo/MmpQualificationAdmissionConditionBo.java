package org.dromara.cdi.mmp.qualification.domain.bo;

import org.dromara.cdi.mmp.qualification.domain.MmpQualificationAdmissionCondition;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 资质准入条件业务对象 mmp_qualification_admission_condition
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQualificationAdmissionCondition.class, reverseConvertGenerate = false)
public class MmpQualificationAdmissionConditionBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 资质ID
     */
    @NotNull(message = "资质ID不能为空", groups = { AddGroup.class, EditGroup.class })
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
