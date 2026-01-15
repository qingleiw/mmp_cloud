package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB121OutpatientInfo;
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
 * B12-1 门诊患者信息视图对象 mmp_natdss_b12_1_outpatient_info
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB121OutpatientInfo.class)
public class MmpNatdssB121OutpatientInfoVo implements Serializable {

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
     * 就诊类型:门诊、急诊
     */
    @ExcelProperty(value = "就诊类型:门诊、急诊")
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
     * 患者姓名
     */
    @ExcelProperty(value = "患者姓名")
    private String name;

    /**
     * 挂号流水号
     */
    @ExcelProperty(value = "挂号流水号")
    private String regisSn;

    /**
     * 挂号时间
     */
    @ExcelProperty(value = "挂号时间")
    private Date regisDatetime;

    /**
     * 就诊时间
     */
    @ExcelProperty(value = "就诊时间")
    private Date visitDatetime;

    /**
     * 是否初诊
     */
    @ExcelProperty(value = "是否初诊")
    private String firstVisitMark;

    /**
     * 挂号渠道代码
     */
    @ExcelProperty(value = "挂号渠道代码")
    private String regisMethodCode;

    /**
     * 挂号渠道名称
     */
    @ExcelProperty(value = "挂号渠道名称")
    private String regisMethod;

    /**
     * 挂号类型代码
     */
    @ExcelProperty(value = "挂号类型代码")
    private String regisTypeCode;

    /**
     * 挂号类型
     */
    @ExcelProperty(value = "挂号类型")
    private String regisType;

    /**
     * 挂号金额(元)
     */
    @ExcelProperty(value = "挂号金额(元)")
    private Long regisChargePrice;

    /**
     * 实付金额(元)
     */
    @ExcelProperty(value = "实付金额(元)")
    private Long regisPaidPrice;

    /**
     * 挂号科室代码
     */
    @ExcelProperty(value = "挂号科室代码")
    private String regisDeptCode;

    /**
     * 挂号科室名称
     */
    @ExcelProperty(value = "挂号科室名称")
    private String regisDeptName;

    /**
     * 就诊医生代码
     */
    @ExcelProperty(value = "就诊医生代码")
    private String visitDoctorNo;

    /**
     * 医师职称名称
     */
    @ExcelProperty(value = "医师职称名称")
    private String technicalTitle;

    /**
     * 医师职务名称
     */
    @ExcelProperty(value = "医师职务名称")
    private String jobTitle;

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
