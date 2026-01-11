package org.dromara.cdi.mmp.doctor.domain.bo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorPublication;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 论文论著业务对象 mmp_doctor_publication
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpDoctorPublication.class, reverseConvertGenerate = false)
public class MmpDoctorPublicationBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 医生ID
     */
    @NotNull(message = "医生ID不能为空", groups = { AddGroup.class, EditGroup.class })
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
