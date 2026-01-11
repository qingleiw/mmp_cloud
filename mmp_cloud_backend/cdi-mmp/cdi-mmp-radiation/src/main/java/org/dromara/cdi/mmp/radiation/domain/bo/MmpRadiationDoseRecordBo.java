package org.dromara.cdi.mmp.radiation.domain.bo;

import org.dromara.cdi.mmp.radiation.domain.MmpRadiationDoseRecord;
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
 * 个人剂量监测记录业务对象 mmp_radiation_dose_record
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpRadiationDoseRecord.class, reverseConvertGenerate = false)
public class MmpRadiationDoseRecordBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 工作人员ID
     */
    @NotNull(message = "工作人员ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long staffId;

    /**
     * 工作人员姓名
     */
    private String staffName;

    /**
     * 记录日期
     */
    @NotNull(message = "记录日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date recordDate;

    /**
     * 记录周期：daily-日，monthly-月，quarterly-季度，yearly-年
     */
    private String recordPeriod;

    /**
     * 剂量值
     */
    @NotNull(message = "剂量值不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long doseValue;

    /**
     * 剂量单位
     */
    private String doseUnit;

    /**
     * 测量方法
     */
    private String measurementMethod;

    /**
     * 测量设备
     */
    private String measurementDevice;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 备注
     */
    private String remark;


}
