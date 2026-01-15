package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB181RadInfo;
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
 * B18-1 临床放疗记录视图对象 mmp_natdss_b18_1_rad_info
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB181RadInfo.class)
public class MmpNatdssB181RadInfoVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统自增主键
     */
    @ExcelProperty(value = "系统自增主键")
    private Long id;

    /**
     * 患者ID
     */
    @ExcelProperty(value = "患者ID")
    private String patientId;

    /**
     * 单次就诊唯一标识号
     */
    @ExcelProperty(value = "单次就诊唯一标识号")
    private String visitSn;

    /**
     * 就诊类型:住院、门诊
     */
    @ExcelProperty(value = "就诊类型:住院、门诊")
    private String visitType;

    /**
     * 就诊卡号
     */
    @ExcelProperty(value = "就诊卡号")
    private String visitCardNo;

    /**
     * 门诊号
     */
    @ExcelProperty(value = "门诊号")
    private String outpatientNo;

    /**
     * 就诊次数
     */
    @ExcelProperty(value = "就诊次数")
    private Long visitTimes;

    /**
     * 病案号
     */
    @ExcelProperty(value = "病案号")
    private String medicalRecordNo;

    /**
     * 住院号
     */
    @ExcelProperty(value = "住院号")
    private String inpatientNo;

    /**
     * 住院次数
     */
    @ExcelProperty(value = "住院次数")
    private String hospitalizationTimes;

    /**
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String name;

    /**
     * 性别
     */
    @ExcelProperty(value = "性别")
    private String gender;

    /**
     * 年龄(岁)
     */
    @ExcelProperty(value = "年龄(岁)")
    private Long age;

    /**
     * 出生日期
     */
    @ExcelProperty(value = "出生日期")
    private Date dateOfBirth;

    /**
     * 放疗流水号
     */
    @ExcelProperty(value = "放疗流水号")
    private String radioSn;

    /**
     * 疗程号
     */
    @ExcelProperty(value = "疗程号")
    private String courseSn;

    /**
     * 放疗开始日期
     */
    @ExcelProperty(value = "放疗开始日期")
    private Date radioStartTime;

    /**
     * 放疗结束日期
     */
    @ExcelProperty(value = "放疗结束日期")
    private Date radioEndTime;

    /**
     * 放疗技术
     */
    @ExcelProperty(value = "放疗技术")
    private String radioTech;

    /**
     * 放疗部位
     */
    @ExcelProperty(value = "放疗部位")
    private String radioSite;

    /**
     * 靶区部位
     */
    @ExcelProperty(value = "靶区部位")
    private String targetVolume;

    /**
     * 处方天数
     */
    @ExcelProperty(value = "处方天数")
    private Long presDays;

    /**
     * 处方总剂量
     */
    @ExcelProperty(value = "处方总剂量")
    private String presTotalDose;

    /**
     * 处方放疗次数
     */
    @ExcelProperty(value = "处方放疗次数")
    private Long presRadioCount;

    /**
     * 处方分次剂量
     */
    @ExcelProperty(value = "处方分次剂量")
    private String radioSingleDose;

    /**
     * 是否同步化疗
     */
    @ExcelProperty(value = "是否同步化疗")
    private String synChemoMark;

    /**
     * 同步化疗方案
     */
    @ExcelProperty(value = "同步化疗方案")
    private String synChemoScheme;

    /**
     * 是否同步其他药物治疗
     */
    @ExcelProperty(value = "是否同步其他药物治疗")
    private String synOtherSchemeMark;

    /**
     * 其他同步治疗方案
     */
    @ExcelProperty(value = "其他同步治疗方案")
    private String synOtherScheme;

    /**
     * 疗效评价日期
     */
    @ExcelProperty(value = "疗效评价日期")
    private Date effectEvalTime;

    /**
     * 疗效评价
     */
    @ExcelProperty(value = "疗效评价")
    private String effectEval;

    /**
     * 不良反应
     */
    @ExcelProperty(value = "不良反应")
    private String adverseDrugReaction;

    /**
     * 扩展字段1
     */
    @ExcelProperty(value = "扩展字段1")
    private String extendData1;

    /**
     * 扩展字段2
     */
    @ExcelProperty(value = "扩展字段2")
    private String extendData2;

    /**
     * 记录状态:1正常 0作废
     */
    @ExcelProperty(value = "记录状态:1正常 0作废")
    private Long recordStatus;

    /**
     * 治疗目的
     */
    @ExcelProperty(value = "治疗目的")
    private String therapeuticPurposes;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createdTime;

    /**
     * 更新时间
     */
    @ExcelProperty(value = "更新时间")
    private Date updatedTime;


}
