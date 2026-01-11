package org.dromara.cdi.mmp.qc.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 数据采集记录对象 mmp_qc_data_collection
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qc_data_collection")
public class MmpQcDataCollection extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 指标ID
     */
    private Long indicatorId;

    /**
     * 统计周期：monthly-月度，quarterly-季度，yearly-年度
     */
    private String collectionPeriod;

    /**
     * 统计年份
     */
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
