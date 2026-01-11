package org.dromara.cdi.mmp.doctor.domain.vo;

import org.dromara.cdi.mmp.doctor.domain.MmpDoctorEthicsEvaluation;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 医德医风考评视图对象 mmp_doctor_ethics_evaluation
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpDoctorEthicsEvaluation.class)
public class MmpDoctorEthicsEvaluationVo implements Serializable {

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
     * 考评年度
     */
    @ExcelProperty(value = "考评年度")
    private Long evaluationYear;

    /**
     * 考评周期
     */
    @ExcelProperty(value = "考评周期")
    private String evaluationCycle;

    /**
     * 自评得分
     */
    @ExcelProperty(value = "自评得分")
    private Long selfScore;

    /**
     * 同行评议得分
     */
    @ExcelProperty(value = "同行评议得分")
    private Long peerScore;

    /**
     * 患者评价得分
     */
    @ExcelProperty(value = "患者评价得分")
    private Long patientScore;

    /**
     * 科室评价得分
     */
    @ExcelProperty(value = "科室评价得分")
    private Long departmentScore;

    /**
     * 医院评价得分
     */
    @ExcelProperty(value = "医院评价得分")
    private Long hospitalScore;

    /**
     * 总分
     */
    @ExcelProperty(value = "总分")
    private Long totalScore;

    /**
     * 考评结果 优秀/良好/合格/不合格
     */
    @ExcelProperty(value = "考评结果 优秀/良好/合格/不合格")
    private String evaluationResult;

    /**
     * 奖惩情况
     */
    @ExcelProperty(value = "奖惩情况")
    private String rewardPunishment;

    /**
     * 考评意见
     */
    @ExcelProperty(value = "考评意见")
    private String remark;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
