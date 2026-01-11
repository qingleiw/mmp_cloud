package org.dromara.cdi.mmp.radiation.domain.bo;

import org.dromara.cdi.mmp.radiation.domain.MmpRadiationEquipmentInspection;
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
 * 放射设备检测记录业务对象 mmp_radiation_equipment_inspection
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpRadiationEquipmentInspection.class, reverseConvertGenerate = false)
public class MmpRadiationEquipmentInspectionBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 设备ID
     */
    @NotNull(message = "设备ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long equipmentId;

    /**
     * 检测日期
     */
    @NotNull(message = "检测日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date inspectionDate;

    /**
     * 检测机构
     */
    private String inspectionAgency;

    /**
     * 检测人员
     */
    private String inspectorName;

    /**
     * 检测结果：pass-合格，fail-不合格
     */
    private String inspectionResult;

    /**
     * 检测报告
     */
    private String inspectionReport;

    /**
     * 下次检测日期
     */
    private Date nextInspectionDate;

    /**
     * 备注
     */
    private String remark;


}
