package org.dromara.cdi.mmp.surgery.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 手术目录对象 mmp_surgery_catalog
 *
 * @author Lion Li
 * @date 2026-01-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_surgery_catalog")
public class MmpSurgeryCatalog extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 附加编码
     */
    private String additionalCode;

    /**
     * 细目代码
     */
    private String detailCode;

    /**
     * 手术操作名称
     */
    private String surgeryName;

    /**
     * 类别
     */
    private String category;

    /**
     * 手术等级
     */
    private String surgeryLevel;

    /**
     * 是否启用
     */
    private Long isEnabled;

    /**
     * 版本号
     */
    @Version
    private String version;

    /**
     * 所属科室
     */
    private String department;

    /**
     * 手术分类
     */
    private String surgeryCategory;

    /**
     * 备注
     */
    private String remark;


}
