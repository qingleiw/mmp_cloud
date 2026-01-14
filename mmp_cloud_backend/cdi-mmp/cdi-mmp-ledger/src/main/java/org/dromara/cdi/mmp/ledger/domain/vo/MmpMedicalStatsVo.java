package org.dromara.cdi.mmp.ledger.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.ledger.domain.MmpMedicalStats;
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
 * 医疗质量统计数据视图对象 mmp_medical_stats
 *
 * @author Lion Li
 * @date 2025-12-27
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpMedicalStats.class)
public class MmpMedicalStatsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 科室名称
     */
    @ExcelProperty(value = "科室名称")
    private String deptName;

    /**
     * 统计日期
     */
    @ExcelProperty(value = "统计日期")
    private Date statDate;

    /**
     * 新入院患者数
     */
    @ExcelProperty(value = "新入院患者数")
    private Long newAdmissions;

    /**
     * 在院患者数
     */
    @ExcelProperty(value = "在院患者数")
    private Long inWard;

    /**
     * 危重患者数
     */
    @ExcelProperty(value = "危重患者数")
    private Long critical;

    /**
     * 出院患者数
     */
    @ExcelProperty(value = "出院患者数")
    private Long discharged;

    /**
     * 死亡患者数
     */
    @ExcelProperty(value = "死亡患者数")
    private Long deaths;

    /**
     * 转入患者数
     */
    @ExcelProperty(value = "转入患者数")
    private Long transfersIn;

    /**
     * 转出患者数
     */
    @ExcelProperty(value = "转出患者数")
    private Long transfersOut;

    /**
     * 关注患者数
     */
    @ExcelProperty(value = "关注患者数")
    private Long attentionPatients;

    /**
     * 抢救次数
     */
    @ExcelProperty(value = "抢救次数")
    private Long rescues;

    /**
     * 危急值次数
     */
    @ExcelProperty(value = "危急值次数")
    private Long criticalValues;

    /**
     * 病危患者数
     */
    @ExcelProperty(value = "病危患者数")
    private Long criticallyIll;

    /**
     * 病重患者数
     */
    @ExcelProperty(value = "病重患者数")
    private Long seriouslyIll;

    /**
     * 会诊次数
     */
    @ExcelProperty(value = "会诊次数")
    private Long consultations;

    /**
     * 住院超30天患者数
     */
    @ExcelProperty(value = "住院超30天患者数")
    private Long longStayPatients;

    /**
     * 三级手术次数
     */
    @ExcelProperty(value = "三级手术次数")
    private Long level3Surgeries;

    /**
     * 四级手术次数
     */
    @ExcelProperty(value = "四级手术次数")
    private Long level4Surgeries;

    /**
     * 二次手术次数
     */
    @ExcelProperty(value = "二次手术次数")
    private Long secondarySurgeries;

    /**
     * 输血次数
     */
    @ExcelProperty(value = "输血次数")
    private Long bloodTransfusions;

    /**
     * 入径患者数
     */
    @ExcelProperty(value = "入径患者数")
    private Long pathwayEntries;

    /**
     * 抗菌药物使用次数
     */
    @ExcelProperty(value = "抗菌药物使用次数")
    private Long antibioticUsage;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
