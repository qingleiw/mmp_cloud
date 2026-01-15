package org.dromara.cdi.mmp.natdss.domain.bo;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB023DiagInfo;
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
 * B02-3 患者诊断记录业务对象 mmp_natdss_b02_3_diag_info
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNatdssB023DiagInfo.class, reverseConvertGenerate = false)
public class MmpNatdssB023DiagInfoBo extends BaseEntity {

    /**
     * 系统自增主键
     */
    @NotNull(message = "系统自增主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 患者ID
     */
    @NotBlank(message = "患者ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String patientId;

    /**
     * 单次就诊唯一标识号
     */
    @NotBlank(message = "单次就诊唯一标识号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String visitSn;

    /**
     * 就诊类型:住院、门诊
     */
    private String visitType;

    /**
     * 就诊卡号
     */
    private String visitCardNo;

    /**
     * 病案号
     */
    private String medicalRecordNo;

    /**
     * 门诊号
     */
    private String outpatientNo;

    /**
     * 就诊次数
     */
    private Long visitTimes;

    /**
     * 住院号
     */
    private String inpatientNo;

    /**
     * 住院次数
     */
    private String hospitalizationTimes;

    /**
     * 患者姓名
     */
    private String name;

    /**
     * 诊断ID号
     */
    @NotBlank(message = "诊断ID号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String diagId;

    /**
     * 诊断序号
     */
    private String diagSerialNumber;

    /**
     * 诊断类型:门诊诊断、入院诊断、出院诊断、其他诊断
     */
    private String diagType;

    /**
     * 诊断编码
     */
    private String diagCode;

    /**
     * 诊断名称
     */
    private String diagName;

    /**
     * 诊断说明
     */
    private String diagExplanation;

    /**
     * 诊断时间
     */
    private Date diagDatetime;

    /**
     * 是否明确诊断
     */
    private String confirmedDiagMark;

    /**
     * 是否主要诊断
     */
    private String maindiagMark;

    /**
     * 诊断医生代码
     */
    private String diagDoctorNo;

    /**
     * 扩展字段1
     */
    private String extendData1;

    /**
     * 扩展字段2
     */
    private String extendData2;

    /**
     * 记录状态:1正常 0作废
     */
    private Long recordStatus;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;


}
