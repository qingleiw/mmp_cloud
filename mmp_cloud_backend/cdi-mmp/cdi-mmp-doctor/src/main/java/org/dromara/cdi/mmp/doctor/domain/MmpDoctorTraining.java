package org.dromara.cdi.mmp.doctor.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 培训记录对象 mmp_doctor_training
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_doctor_training")
public class MmpDoctorTraining extends BaseEntity {

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
     * 培训类型 进修/继续教育/院内培训
     */
    private String trainingType;

    /**
     * 培训名称
     */
    private String trainingName;

    /**
     * 培训单位
     */
    private String trainingUnit;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    /**
     * 培训学时
     */
    private Long trainingHours;

    /**
     * 培训内容
     */
    private String trainingContent;

    /**
     * 培训结果 合格/不合格
     */
    private String trainingResult;

    /**
     * 证书编号
     */
    private String certificateNo;

    /**
     * 证书附件URL
     */
    private String certificateUrl;

    /**
     * 学分
     */
    private Long credits;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    private Long delFlag;

    /**
     * 创建部门
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createDept;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

}
