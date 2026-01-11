package org.dromara.cdi.mmp.doctor.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 论文论著对象 mmp_doctor_publication
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_doctor_publication")
public class MmpDoctorPublication extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 医生ID
     */
    private Long doctorId;

    /**
     * 类型 论文/论著/专利
     */
    private String publicationType;

    /**
     * 标题
     */
    private String title;

    /**
     * 作者
     */
    private String authors;

    /**
     * 作者排序
     */
    private Long authorOrder;

    /**
     * 期刊名称/出版社
     */
    private String journalName;

    /**
     * 发表日期
     */
    private Date publishDate;

    /**
     * 卷号
     */
    private String volume;

    /**
     * 期号
     */
    private String issue;

    /**
     * 页码
     */
    private String pages;

    /**
     * DOI
     */
    private String doi;

    /**
     * 影响因子
     */
    private Long impactFactor;

    /**
     * 引用次数
     */
    private Long citationCount;

    /**
     * 全文URL
     */
    private String fullTextUrl;

    /**
     * 是否删除
     */
    private Long delFlag;


}
