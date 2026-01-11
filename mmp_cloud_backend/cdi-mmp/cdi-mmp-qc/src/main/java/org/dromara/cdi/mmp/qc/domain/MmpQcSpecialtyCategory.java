package org.dromara.cdi.mmp.qc.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 专业类别对象 mmp_qc_specialty_category
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_qc_specialty_category")
public class MmpQcSpecialtyCategory extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 专业代码
     */
    private String categoryCode;

    /**
     * 专业名称
     */
    private String categoryName;

    /**
     * 版本号
     */
    @Version
    private String version;

    /**
     * 发布年份
     */
    private Long publishYear;

    /**
     * 排序
     */
    private Long sortOrder;

    /**
     * 状态：1-启用，0-禁用
     */
    private Long status;

    /**
     * 是否删除
     */
    private Long delFlag;


}
