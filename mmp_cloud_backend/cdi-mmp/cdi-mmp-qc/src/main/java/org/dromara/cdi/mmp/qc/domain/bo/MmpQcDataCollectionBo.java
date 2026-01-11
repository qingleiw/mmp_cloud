package org.dromara.cdi.mmp.qc.domain.bo;

import org.dromara.cdi.mmp.qc.domain.MmpQcDataCollection;
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
 * 数据采集记录业务对象 mmp_qc_data_collection
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQcDataCollection.class, reverseConvertGenerate = false)
public class MmpQcDataCollectionBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 指标ID
     */
    @NotNull(message = "指标ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long indicatorId;

    /**
     * 统计周期：monthly-月度，quarterly-季度，yearly-年度
     */
    @NotBlank(message = "统计周期：monthly-月度，quarterly-季度，yearly-年度不能为空", groups = { AddGroup.class, EditGroup.class })
    private String collectionPeriod;

    /**
     * 统计年份
     */
    @NotNull(message = "统计年份不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long collectionYear;

    /**
     * 统计月份
     */
    private Long collectionMonth;

    /**
     * 统计季度
     */
    private Long collectionQuarter;

    /**
     * 科室ID
     */
    private Long departmentId;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 分子值
     */
    private Long numeratorValue;

    /**
     * 分母值
     */
    private Long denominatorValue;

    /**
     * 指标值（计算结果）
     */
    private Long indicatorValue;

    /**
     * 数据状态：0-草稿，1-已提交，2-已审核
     */
    private Long dataStatus;

    /**
     * 采集人
     */
    private String collector;

    /**
     * 审核人
     */
    private String reviewer;

    /**
     * 采集时间
     */
    private Date collectionTime;

    /**
     * 审核时间
     */
    private Date reviewTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    private Long delFlag;


}
