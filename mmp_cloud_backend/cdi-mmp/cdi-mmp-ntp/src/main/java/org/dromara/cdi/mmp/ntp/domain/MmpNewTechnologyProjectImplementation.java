package org.dromara.cdi.mmp.ntp.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 新技术实施对象 mmp_new_technology_project_implementation
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_new_technology_project_implementation")
public class MmpNewTechnologyProjectImplementation extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 项目编号
     */
    private String projectNo;

    /**
     * 实施状态 0-未开始 1-进行中 2-已完成 3-暂停
     */
    private Long implementationStatus;

    /**
     * 实施医生
     */
    private String implementDoctor;

    /**
     * 实施地点
     */
    private String implementationLocation;

    /**
     * 实施日期
     */
    private Date implementationDate;

    /**
     * 实施结果
     */
    private String implementationResult;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    private Long isDeleted;


}
