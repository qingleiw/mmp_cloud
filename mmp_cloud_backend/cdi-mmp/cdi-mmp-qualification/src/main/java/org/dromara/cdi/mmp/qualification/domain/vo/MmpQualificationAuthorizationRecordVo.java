package org.dromara.cdi.mmp.qualification.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.cdi.mmp.qualification.domain.MmpQualificationAuthorizationRecord;
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
 * 资质授权记录视图对象 mmp_qualification_authorization_record
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MmpQualificationAuthorizationRecord.class)
public class MmpQualificationAuthorizationRecordVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 授权编号
     */
    @ExcelProperty(value = "授权编号")
    private String authorizationNo;

    /**
     * 人员ID
     */
    @ExcelProperty(value = "人员ID")
    private Long staffId;

    /**
     * 人员姓名
     */
    @ExcelProperty(value = "人员姓名")
    private String staffName;

    /**
     * 人员类型 医师/医技
     */
    @ExcelProperty(value = "人员类型 医师/医技")
    private String staffType;

    /**
     * 资质ID
     */
    @ExcelProperty(value = "资质ID")
    private Long qualificationId;

    /**
     * 资质编码
     */
    @ExcelProperty(value = "资质编码")
    private String qualificationCode;

    /**
     * 资质名称
     */
    @ExcelProperty(value = "资质名称")
    private String qualificationName;

    /**
     * 授权类型 首次授权/再授权/升级/降级/直接授权
     */
    @ExcelProperty(value = "授权类型 首次授权/再授权/升级/降级/直接授权")
    private String authorizationType;

    /**
     * 授权级别
     */
    @ExcelProperty(value = "授权级别")
    private String authorizationLevel;

    /**
     * 有效期开始
     */
    @ExcelProperty(value = "有效期开始")
    private Date validStartDate;

    /**
     * 有效期结束
     */
    @ExcelProperty(value = "有效期结束")
    private Date validEndDate;

    /**
     * 授权状态 有效/即将到期/已过期/已停用
     */
    @ExcelProperty(value = "授权状态 有效/即将到期/已过期/已停用")
    private String authorizationStatus;

    /**
     * 关联申请ID
     */
    @ExcelProperty(value = "关联申请ID")
    private Long applyId;

    /**
     * 特殊限制条件
     */
    @ExcelProperty(value = "特殊限制条件")
    private String specialCondition;

    /**
     * 限定患者ID(紧急授权)
     */
    @ExcelProperty(value = "限定患者ID(紧急授权)")
    private Long patientId;

    /**
     * 授权理由
     */
    @ExcelProperty(value = "授权理由")
    private String authorizationReason;

    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Long delFlag;


}
