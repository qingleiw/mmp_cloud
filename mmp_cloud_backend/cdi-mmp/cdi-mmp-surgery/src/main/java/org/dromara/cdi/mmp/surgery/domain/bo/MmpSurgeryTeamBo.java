package org.dromara.cdi.mmp.surgery.domain.bo;

import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryTeam;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 手术团队业务对象 mmp_surgery_team
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpSurgeryTeam.class, reverseConvertGenerate = false)
public class MmpSurgeryTeamBo extends BaseEntity {

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
     * 医生ID
     */
    @NotNull(message = "医生ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long doctorId;

    /**
     * 医生姓名
     */
    @NotBlank(message = "医生姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String doctorName;

    /**
     * 角色类型 主刀/一助/二助/巡回护士/器械护士/麻醉师
     */
    @NotBlank(message = "角色类型 主刀/一助/二助/巡回护士/器械护士/麻醉师不能为空", groups = { AddGroup.class, EditGroup.class })
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
