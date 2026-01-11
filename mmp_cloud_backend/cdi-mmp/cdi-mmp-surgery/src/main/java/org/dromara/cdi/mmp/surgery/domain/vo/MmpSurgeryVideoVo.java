package org.dromara.cdi.mmp.surgery.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryVideo;
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
 * 手术视频视图对象 mmp_surgery_video
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpSurgeryVideo.class)
public class MmpSurgeryVideoVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 视频编号
     */
    @ExcelProperty(value = "视频编号")
    private String videoNo;

    /**
     * 视频标题
     */
    @ExcelProperty(value = "视频标题")
    private String videoTitle;

    /**
     * 视频类型 手术全程/关键步骤/教学片段
     */
    @ExcelProperty(value = "视频类型 手术全程/关键步骤/教学片段")
    private String videoType;

    /**
     * 视频URL
     */
    @ExcelProperty(value = "视频URL")
    private String videoUrl;

    /**
     * 视频时长(秒)
     */
    @ExcelProperty(value = "视频时长(秒)")
    private Long videoDuration;

    /**
     * 视频大小(字节)
     */
    @ExcelProperty(value = "视频大小(字节)")
    private Long videoSize;

    /**
     * 视频格式
     */
    @ExcelProperty(value = "视频格式")
    private String videoFormat;

    /**
     * 录制设备
     */
    @ExcelProperty(value = "录制设备")
    private String recordingDevice;

    /**
     * 录制医生姓名
     */
    @ExcelProperty(value = "录制医生姓名")
    private String recordingDoctorName;

    /**
     * 上传时间
     */
    @ExcelProperty(value = "上传时间")
    private Date uploadTime;

    /**
     * 审核状态 pending-待审核 approved-已通过 rejected-已拒绝
     */
    @ExcelProperty(value = "审核状态 pending-待审核 approved-已通过 rejected-已拒绝")
    private String reviewStatus;

    /**
     * 审核时间
     */
    @ExcelProperty(value = "审核时间")
    private Date reviewTime;

    /**
     * 审核意见
     */
    @ExcelProperty(value = "审核意见")
    private String reviewComment;

    /**
     * 访问级别 internal-院内 public-公开 restricted-受限
     */
    @ExcelProperty(value = "访问级别 internal-院内 public-公开 restricted-受限")
    private String accessLevel;

    /**
     * 删除标志
     */
    @ExcelProperty(value = "删除标志")
    private String delFlag;


}
