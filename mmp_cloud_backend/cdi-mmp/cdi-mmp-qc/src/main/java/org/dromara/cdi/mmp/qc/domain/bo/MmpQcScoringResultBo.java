package org.dromara.cdi.mmp.qc.domain.bo;

import org.dromara.cdi.mmp.qc.domain.MmpQcScoringResult;
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
 * 评分结果业务对象 mmp_qc_scoring_result
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpQcScoringResult.class, reverseConvertGenerate = false)
public class MmpQcScoringResultBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 采集记录ID
     */
    @NotNull(message = "采集记录ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long collectionId;

    /**
     * 指标ID
     */
    @NotNull(message = "指标ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long indicatorId;

    /**
     * 指标值
     */
    private Long indicatorValue;

    /**
     * 标准值
     */
    private Long standardValue;

    /**
     * 满分
     */
    private Long maxScore;

    /**
     * 实际得分
     */
    private Long actualScore;

    /**
     * 得分率
     */
    private Long scoreRate;

    /**
     * 评价等级：excellent-优秀，good-良好，qualified-合格，unqualified-不合格
     */
    private String evaluationLevel;

    /**
     * 计算时间
     */
    private Date calculateTime;

    /**
     * 是否删除
     */
    private Long delFlag;


}
