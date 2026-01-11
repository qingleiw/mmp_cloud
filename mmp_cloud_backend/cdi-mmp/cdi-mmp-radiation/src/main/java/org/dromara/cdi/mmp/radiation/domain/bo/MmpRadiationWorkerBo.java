package org.dromara.cdi.mmp.radiation.domain.bo;

import org.dromara.cdi.mmp.radiation.domain.MmpRadiationWorker;
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
 * 放射工作人员业务对象 mmp_radiation_worker
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpRadiationWorker.class, reverseConvertGenerate = false)
public class MmpRadiationWorkerBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 工作人员编码
     */
    @NotBlank(message = "工作人员编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String workerCode;

    /**
     * 工作人员姓名
     */
    @NotBlank(message = "工作人员姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String workerName;

    /**
     * 所属部门
     */
    private String department;

    /**
     * 职位
     */
    private String position;

    /**
     * 接触辐射类型
     */
    private String radiationType;

    /**
     * 入职日期
     */
    private Date employmentDate;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 紧急联系人
     */
    private String emergencyContact;

    /**
     * 健康状况
     */
    private String healthStatus;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
