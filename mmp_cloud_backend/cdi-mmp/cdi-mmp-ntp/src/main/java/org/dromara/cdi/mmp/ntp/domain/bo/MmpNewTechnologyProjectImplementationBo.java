package org.dromara.cdi.mmp.ntp.domain.bo;

import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectImplementation;
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
 * 新技术实施业务对象 mmp_new_technology_project_implementation
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNewTechnologyProjectImplementation.class, reverseConvertGenerate = false)
public class MmpNewTechnologyProjectImplementationBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
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
