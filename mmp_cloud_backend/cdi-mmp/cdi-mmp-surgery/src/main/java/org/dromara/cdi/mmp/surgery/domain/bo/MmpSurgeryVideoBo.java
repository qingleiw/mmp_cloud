package org.dromara.cdi.mmp.surgery.domain.bo;

import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryVideo;
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
 * 手术视频业务对象 mmp_surgery_video
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSurgeryVideo.class, reverseConvertGenerate = false)
public class MmpSurgeryVideoBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 手术记录ID
     */
    @NotBlank(message = "手术记录ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String surgeryRecordId;

    /**
     * 视频编号
     */
    @NotBlank(message = "视频编号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String videoNo;

    /**
     * 视频标题
     */
    private String videoTitle;

    /**
     * 视频类型 手术全程/关键步骤/教学片段
     */
    private String videoType;

    /**
     * 视频URL
     */
    @NotBlank(message = "视频URL不能为空", groups = { AddGroup.class, EditGroup.class })
    private String videoUrl;

    /**
     * 视频时长(秒)
     */
    private Long videoDuration;

    /**
     * 视频大小(字节)
     */
    private Long videoSize;

    /**
     * 视频格式
     */
    private String videoFormat;

    /**
     * 录制设备
     */
    private String recordingDevice;

    /**
     * 录制医生ID
     */
    private Long recordingDoctorId;

    /**
     * 录制医生姓名
     */
    private String recordingDoctorName;

    /**
     * 上传时间
     */
    private Date uploadTime;

    /**
     * 审核状态 pending-待审核 approved-已通过 rejected-已拒绝
     */
    private String reviewStatus;

    /**
     * 审核人ID
     */
    private Long reviewerId;

    /**
     * 审核时间
     */
    private Date reviewTime;

    /**
     * 审核意见
     */
    private String reviewComment;

    /**
     * 访问级别 internal-院内 public-公开 restricted-受限
     */
    private String accessLevel;

    /**
     * 删除标志
     */
    private String delFlag;


}
