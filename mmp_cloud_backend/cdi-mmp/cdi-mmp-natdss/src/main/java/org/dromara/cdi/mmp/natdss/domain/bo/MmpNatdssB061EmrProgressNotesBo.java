package org.dromara.cdi.mmp.natdss.domain.bo;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB061EmrProgressNotes;
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
 * B06-1 病程记录业务对象 mmp_natdss_b06_1_emr_progress_notes
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNatdssB061EmrProgressNotes.class, reverseConvertGenerate = false)
public class MmpNatdssB061EmrProgressNotesBo extends BaseEntity {

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
     * 病案号
     */
    private String medicalRecordNo;

    /**
     * 住院号
     */
    private String patientNo;

    /**
     * 住院次数
     */
    private String hospitalizationTimes;

    /**
     * 病程记录流水号
     */
    @NotBlank(message = "病程记录流水号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String recordSn;

    /**
     * 病程记录时间
     */
    private Date recordDatetime;

    /**
     * 病程记录类型代码
     */
    private String recordTitleCode;

    /**
     * 病程记录类型
     */
    private String recordTitle;

    /**
     * 病程记录
     */
    private String recordContent;

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
