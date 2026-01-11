package org.dromara.cdi.mmp.qualification.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 医生手术授权目录对象 mmp_qualification_catalog
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qualification_catalog")
public class MmpQualificationCatalog extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 医生ID
     */
    private Long doctorId;

    /**
     * 医生姓名
     */
    private String doctorName;

    /**
     * 科室
     */
    private String department;

    /**
     * 职务
     */
    private String position;

    /**
     * 职称
     */
    private String title;

    /**
     * 所授权手术级别
     */
    private String authorizedLevel;

    /**
     * 一级手术授权（1=通过，0=未通过）
     */
    private Long level1;

    /**
     * 二级手术授权（1=通过，0=未通过）
     */
    private Long level2;

    /**
     * 三级手术授权（1=通过，0=未通过）
     */
    private Long level3;

    /**
     * 四级手术授权（1=通过，0=未通过）
     */
    private Long level4;

    /**
     * 手术名称
     */
    private String surgeryName;

    /**
     * 手术代码
     */
    private String surgeryCode;

    /**
     * 手术级别（三级/四级）
     */
    private String surgeryLevel;

    /**
     * 资质类型
     */
    private String qualificationType;

    /**
     * 有效期开始
     */
    private Date validStartDate;

    /**
     * 有效期结束
     */
    private Date validEndDate;

    /**
     * 状态
     */
    private String status;

    /**
     * 数据来源
     */
    private String dataSource;

    /**
     * 是否删除
     */
    private Long delFlag;


}
