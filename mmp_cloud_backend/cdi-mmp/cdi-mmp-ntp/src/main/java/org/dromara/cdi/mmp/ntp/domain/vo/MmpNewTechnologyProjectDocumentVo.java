package org.dromara.cdi.mmp.ntp.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectDocument;
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
 * 项目文档视图对象 mmp_new_technology_project_document
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpNewTechnologyProjectDocument.class)
public class MmpNewTechnologyProjectDocumentVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 文档类型：application-申报书，approval-批复文件，progress-进展报告，final-结题报告
     */
    @ExcelProperty(value = "文档类型：application-申报书，approval-批复文件，progress-进展报告，final-结题报告")
    private String documentType;

    /**
     * 文档名称
     */
    @ExcelProperty(value = "文档名称")
    private String documentName;

    /**
     * 文件路径
     */
    @ExcelProperty(value = "文件路径")
    private String filePath;

    /**
     * 文件名
     */
    @ExcelProperty(value = "文件名")
    private String fileName;

    /**
     * 文件大小
     */
    @ExcelProperty(value = "文件大小")
    private Long fileSize;

    /**
     * 上传人
     */
    @ExcelProperty(value = "上传人")
    private String uploadBy;

    /**
     * 上传时间
     */
    @ExcelProperty(value = "上传时间")
    private Date uploadTime;

    /**
     * 状态
     */
    @ExcelProperty(value = "状态")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
