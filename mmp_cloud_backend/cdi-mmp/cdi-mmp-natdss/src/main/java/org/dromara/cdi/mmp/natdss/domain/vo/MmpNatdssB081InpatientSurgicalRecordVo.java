package org.dromara.cdi.mmp.natdss.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB081InpatientSurgicalRecord;
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
 * B08-1 住院手术记录视图对象 mmp_natdss_b08_1_inpatient_surgical_record
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNatdssB081InpatientSurgicalRecord.class)
public class MmpNatdssB081InpatientSurgicalRecordVo implements Serializable {

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
     * 手术记录流水号
     */
    @ExcelProperty(value = "手术记录流水号")
    private String recordSn;

    /**
     * 手术记录时间
     */
    @ExcelProperty(value = "手术记录时间")
    private Date recordDatetime;

    /**
     * 主刀医生代码
     */
    @ExcelProperty(value = "主刀医生代码")
    private String surgeonNo;

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
     * 手术执行科室编号
     */
    @ExcelProperty(value = "手术执行科室编号")
    private String executiveDeptCode;

    /**
     * 手术执行科室名称
     */
    @ExcelProperty(value = "手术执行科室名称")
    private String executiveDeptName;

    /**
     * 手术编码
     */
    @ExcelProperty(value = "手术编码")
    private String surgeryCode;

    /**
     * 手术名称
     */
    @ExcelProperty(value = "手术名称")
    private String surgeryName;

    /**
     * 手术开始时间
     */
    @ExcelProperty(value = "手术开始时间")
    private Date startDatetime;

    /**
     * 手术结束时间
     */
    @ExcelProperty(value = "手术结束时间")
    private Date finishDatetime;

    /**
     * 切口类型
     */
    @ExcelProperty(value = "切口类型")
    private String incisionType;

    /**
     * 手术级别
     */
    @ExcelProperty(value = "手术级别")
    private String surgeryLevel;

    /**
     * 手术入路
     */
    @ExcelProperty(value = "手术入路")
    private String surgicalApproach;

    /**
     * 是否预防性使用抗生素
     */
    @ExcelProperty(value = "是否预防性使用抗生素")
    private String preventiveAntibioticMark;

    /**
     * 手术过程描述
     */
    @ExcelProperty(value = "手术过程描述")
    private String proceduresDescription;

    /**
     * 麻醉医师代码
     */
    @ExcelProperty(value = "麻醉医师代码")
    private String asaSurgeonNo;

    /**
     * 麻醉医师职称名称
     */
    @ExcelProperty(value = "麻醉医师职称名称")
    private String asaTechnicalTitle;

    /**
     * 麻醉医师职务名称
     */
    @ExcelProperty(value = "麻醉医师职务名称")
    private String asaJobTitle;

    /**
     * 麻醉方式代码
     */
    @ExcelProperty(value = "麻醉方式代码")
    private String anesthesiaTypeCode;

    /**
     * 麻醉方式
     */
    @ExcelProperty(value = "麻醉方式")
    private String anesthesiaType;

    /**
     * 麻醉评分
     */
    @ExcelProperty(value = "麻醉评分")
    private String asaPhysicalStatus;

    /**
     * 麻醉开始时间
     */
    @ExcelProperty(value = "麻醉开始时间")
    private Date anesthesiaStartTime;

    /**
     * 麻醉结束时间
     */
    @ExcelProperty(value = "麻醉结束时间")
    private Date anesthesiaEndTime;

    /**
     * 总入量(ml)
     */
    @ExcelProperty(value = "总入量(ml)")
    private String intakeVolume;

    /**
     * 总出量(ml)
     */
    @ExcelProperty(value = "总出量(ml)")
    private String outputVolume;

    /**
     * 输血血型-ABO
     */
    @ExcelProperty(value = "输血血型-ABO")
    private String bloodTransAbo;

    /**
     * 输血血型-Rh
     */
    @ExcelProperty(value = "输血血型-Rh")
    private String bloodTransRh;

    /**
     * 输血成份类型代码
     */
    @ExcelProperty(value = "输血成份类型代码")
    private String bloodTransComponentCode;

    /**
     * 输血成份类型
     */
    @ExcelProperty(value = "输血成份类型")
    private String bloodTransComponent;

    /**
     * 输血量(ml)
     */
    @ExcelProperty(value = "输血量(ml)")
    private String bloodTransVolume;

    /**
     * 出血量(ml)
     */
    @ExcelProperty(value = "出血量(ml)")
    private String bloodLossVolume;

    /**
     * 尿量(ml)
     */
    @ExcelProperty(value = "尿量(ml)")
    private String urineVolume;

    /**
     * 术前主要诊断编码
     */
    @ExcelProperty(value = "术前主要诊断编码")
    private String presurgeryMaindiagCode1;

    /**
     * 术前主要诊断名称
     */
    @ExcelProperty(value = "术前主要诊断名称")
    private String presurgeryMaindiagName1;

    /**
     * 术前诊断编码-2
     */
    @ExcelProperty(value = "术前诊断编码-2")
    private String presurgeryDiagCode2;

    /**
     * 术前诊断名称-2
     */
    @ExcelProperty(value = "术前诊断名称-2")
    private String presurgeryDiagName2;

    /**
     * 术前诊断编码-3
     */
    @ExcelProperty(value = "术前诊断编码-3")
    private String presurgeryDiagCode3;

    /**
     * 术前诊断名称-3
     */
    @ExcelProperty(value = "术前诊断名称-3")
    private String presurgeryDiagName3;

    /**
     * 术前诊断编码-4
     */
    @ExcelProperty(value = "术前诊断编码-4")
    private String presurgeryDiagCode4;

    /**
     * 术前诊断名称-4
     */
    @ExcelProperty(value = "术前诊断名称-4")
    private String presurgeryDiagName4;

    /**
     * 术前诊断编码-5
     */
    @ExcelProperty(value = "术前诊断编码-5")
    private String presurgeryDiagCode5;

    /**
     * 术前诊断名称-5
     */
    @ExcelProperty(value = "术前诊断名称-5")
    private String presurgeryDiagName5;

    /**
     * 术中主要诊断编码
     */
    @ExcelProperty(value = "术中主要诊断编码")
    private String intrasurgeryMaindiagCode1;

    /**
     * 术中主要诊断名称
     */
    @ExcelProperty(value = "术中主要诊断名称")
    private String intrasurgeryMaindiagName1;

    /**
     * 术中诊断编码-2
     */
    @ExcelProperty(value = "术中诊断编码-2")
    private String intrasurgeryDiagCode2;

    /**
     * 术中诊断名称-2
     */
    @ExcelProperty(value = "术中诊断名称-2")
    private String intrasurgeryDiagName2;

    /**
     * 术中诊断编码-3
     */
    @ExcelProperty(value = "术中诊断编码-3")
    private String intrasurgeryDiagCode3;

    /**
     * 术中诊断名称-3
     */
    @ExcelProperty(value = "术中诊断名称-3")
    private String intrasurgeryDiagName3;

    /**
     * 术中诊断编码-4
     */
    @ExcelProperty(value = "术中诊断编码-4")
    private String intrasurgeryDiagCode4;

    /**
     * 术中诊断名称-4
     */
    @ExcelProperty(value = "术中诊断名称-4")
    private String intrasurgeryDiagName4;

    /**
     * 术中诊断编码-5
     */
    @ExcelProperty(value = "术中诊断编码-5")
    private String intrasurgeryDiagCode5;

    /**
     * 术中诊断名称-5
     */
    @ExcelProperty(value = "术中诊断名称-5")
    private String intrasurgeryDiagName5;

    /**
     * 术后主要诊断编码
     */
    @ExcelProperty(value = "术后主要诊断编码")
    private String postsurgeryMaindiagCode1;

    /**
     * 术后主要诊断名称
     */
    @ExcelProperty(value = "术后主要诊断名称")
    private String postsurgeryMaindiagName1;

    /**
     * 术后诊断编码-2
     */
    @ExcelProperty(value = "术后诊断编码-2")
    private String postsurgeryDiagCode2;

    /**
     * 术后诊断名称-2
     */
    @ExcelProperty(value = "术后诊断名称-2")
    private String postsurgeryDiagName2;

    /**
     * 术后诊断编码-3
     */
    @ExcelProperty(value = "术后诊断编码-3")
    private String postsurgeryDiagCode3;

    /**
     * 术后诊断名称-3
     */
    @ExcelProperty(value = "术后诊断名称-3")
    private String postsurgeryDiagName3;

    /**
     * 术后诊断编码-4
     */
    @ExcelProperty(value = "术后诊断编码-4")
    private String postsurgeryDiagCode4;

    /**
     * 术后诊断名称-4
     */
    @ExcelProperty(value = "术后诊断名称-4")
    private String postsurgeryDiagName4;

    /**
     * 术后诊断编码-5
     */
    @ExcelProperty(value = "术后诊断编码-5")
    private String postsurgeryDiagCode5;

    /**
     * 术后诊断名称-5
     */
    @ExcelProperty(value = "术后诊断名称-5")
    private String postsurgeryDiagName5;

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
