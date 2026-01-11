package org.dromara.cdi.mmp.surgery.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 手术团队对象 mmp_surgery_team
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_surgery_team")
public class MmpSurgeryTeam extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 手术记录ID
     */
    private String surgeryRecordId;

    /**
     * 医生ID
     */
    private Long doctorId;

    /**
     * 医生姓名
     */
    private String doctorName;

    /**
     * 角色类型 主刀/一助/二助/巡回护士/器械护士/麻醉师
     */
    private String roleType;

    /**
     * 资格验证 1-已验证 0-未验证
     */
    private Long qualificationVerify;

    /**
     * 删除标志
     */
    private String delFlag;


}
