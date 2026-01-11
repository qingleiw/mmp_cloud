package org.dromara.cdi.mmp.qualification.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 资质授权记录对象 mmp_qualification_authorization_record
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qualification_authorization_record")
public class MmpQualificationAuthorizationRecord extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 授权编号
     */
    private String authorizationNo;

    /**
     * 人员ID
     */
    private Long staffId;

    /**
     * 人员姓名
     */
    private String staffName;

    /**
     * 人员类型 医师/医技
     */
    private String staffType;

    /**
     * 资质ID
     */
    private Long qualificationId;

    /**
     * 资质编码
     */
    private String qualificationCode;

    /**
     * 资质名称
     */
    private String qualificationName;

    /**
     * 授权类型 首次授权/再授权/升级/降级/直接授权
     */
    private String authorizationType;

    /**
     * 授权级别
     */
    private String authorizationLevel;

    /**
     * 有效期开始
     */
    private Date validStartDate;

    /**
     * 有效期结束
     */
    private Date validEndDate;

    /**
     * 授权状态 有效/即将到期/已过期/已停用
     */
    private String authorizationStatus;

    /**
     * 关联申请ID
     */
    private Long applyId;

    /**
     * 特殊限制条件
     */
    private String specialCondition;

    /**
     * 限定患者ID(紧急授权)
     */
    private Long patientId;

    /**
     * 授权理由
     */
    private String authorizationReason;

    /**
     * 是否删除
     */
    private Long delFlag;


}
