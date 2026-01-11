package org.dromara.cdi.mmp.doctor.domain.vo;

import java.util.Date;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorPublication;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 论文论著视图对象 mmp_doctor_publication
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDoctorPublication.class)
public class MmpDoctorPublicationVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 医生ID
     */
    @ExcelProperty(value = "医生ID")
    private Long doctorId;

    /**
     * 类型 论文/论著/专利
     */
    @ExcelProperty(value = "类型 论文/论著/专利")
    private String publicationType;

    /**
     * 标题
     */
    @ExcelProperty(value = "标题")
    private String title;

    /**
     * 作者
     */
    @ExcelProperty(value = "作者")
    private String authors;

    /**
     * 作者排序
     */
    @ExcelProperty(value = "作者排序")
    private Long authorOrder;

    /**
     * 期刊名称/出版社
     */
    @ExcelProperty(value = "期刊名称/出版社")
    private String journalName;

    /**
     * 发表日期
     */
    @ExcelProperty(value = "发表日期")
    private Date publishDate;

    /**
     * 卷号
     */
    @ExcelProperty(value = "卷号")
    private String volume;

    /**
     * 期号
     */
    @ExcelProperty(value = "期号")
    private String issue;

    /**
     * 页码
     */
    @ExcelProperty(value = "页码")
    private String pages;

    /**
     * DOI
     */
    @ExcelProperty(value = "DOI")
    private String doi;

    /**
     * 影响因子
     */
    @ExcelProperty(value = "影响因子")
    private Long impactFactor;

    /**
     * 引用次数
     */
    @ExcelProperty(value = "引用次数")
    private Long citationCount;

    /**
     * 全文URL
     */
    @ExcelProperty(value = "全文URL")
    private String fullTextUrl;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
