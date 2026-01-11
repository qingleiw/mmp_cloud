package org.dromara.cdi.mmp.tumorqc.domain.vo;

import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcIndicatorDetail;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 质控指标明细数据视图对象 mmp_tumor_qc_indicator_detail
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpTumorQcIndicatorDetail.class)
public class MmpTumorQcIndicatorDetailVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 监测记录ID
     */
    @ExcelProperty(value = "监测记录ID")
    private Long recordId;

    /**
     * 指标ID
     */
    @ExcelProperty(value = "指标ID")
    private Long indicatorId;

    /**
     * 患者ID
     */
    @ExcelProperty(value = "患者ID")
    private Long patientId;

    /**
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String patientName;

    /**
     * 就诊号
     */
    @ExcelProperty(value = "就诊号")
    private String visitNo;

    /**
     * 诊断
     */
    @ExcelProperty(value = "诊断")
    private String diagnosis;

    /**
     * 指标结果 达标/不达标/不适用
     */
    @ExcelProperty(value = "指标结果 达标/不达标/不适用")
    private String indicatorResult;

    /**
     * 结果说明
     */
    @ExcelProperty(value = "结果说明")
    private String resultDescription;

    /**
     * 相关数据JSON
     */
    @ExcelProperty(value = "相关数据JSON")
    private String relatedData;


}
