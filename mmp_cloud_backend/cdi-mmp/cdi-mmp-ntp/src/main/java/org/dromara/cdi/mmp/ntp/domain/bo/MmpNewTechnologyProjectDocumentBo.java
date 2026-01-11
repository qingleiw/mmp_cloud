package org.dromara.cdi.mmp.ntp.domain.bo;

import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectDocument;
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
 * 项目文档业务对象 mmp_new_technology_project_document
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNewTechnologyProjectDocument.class, reverseConvertGenerate = false)
public class MmpNewTechnologyProjectDocumentBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long projectId;

    /**
     * 文档类型：application-申报书，approval-批复文件，progress-进展报告，final-结题报告
     */
    private String documentType;

    /**
     * 文档名称
     */
    @NotBlank(message = "文档名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String documentName;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 上传人
     */
    private String uploadBy;

    /**
     * 上传时间
     */
    private Date uploadTime;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
