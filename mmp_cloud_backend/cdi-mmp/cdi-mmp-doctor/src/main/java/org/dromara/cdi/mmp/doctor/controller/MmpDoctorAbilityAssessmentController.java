package org.dromara.cdi.mmp.doctor.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorAbilityAssessmentVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorAbilityAssessmentBo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorAbilityAssessmentService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 医师能力评估
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctorAbilityAssessment")
public class MmpDoctorAbilityAssessmentController extends BaseController {

    private final IMmpDoctorAbilityAssessmentService mmpDoctorAbilityAssessmentService;

    /**
     * 查询医师能力评估列表
     */
    @SaCheckPermission("doctor:doctorAbilityAssessment:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorAbilityAssessmentVo> list(MmpDoctorAbilityAssessmentBo bo, PageQuery pageQuery) {
        return mmpDoctorAbilityAssessmentService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出医师能力评估列表
     */
    @SaCheckPermission("doctor:doctorAbilityAssessment:export")
    @Log(title = "医师能力评估", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorAbilityAssessmentBo bo, HttpServletResponse response) {
        List<MmpDoctorAbilityAssessmentVo> list = mmpDoctorAbilityAssessmentService.queryList(bo);
        ExcelUtil.exportExcel(list, "医师能力评估", MmpDoctorAbilityAssessmentVo.class, response);
    }

    /**
     * 获取医师能力评估详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorAbilityAssessment:query")
    @GetMapping("/{id}")
    public R<MmpDoctorAbilityAssessmentVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorAbilityAssessmentService.queryById(id));
    }

    /**
     * 新增医师能力评估
     */
    @SaCheckPermission("doctor:doctorAbilityAssessment:add")
    @Log(title = "医师能力评估", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorAbilityAssessmentBo bo) {
        return toAjax(mmpDoctorAbilityAssessmentService.insertByBo(bo));
    }

    /**
     * 修改医师能力评估
     */
    @SaCheckPermission("doctor:doctorAbilityAssessment:edit")
    @Log(title = "医师能力评估", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorAbilityAssessmentBo bo) {
        return toAjax(mmpDoctorAbilityAssessmentService.updateByBo(bo));
    }

    /**
     * 删除医师能力评估
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorAbilityAssessment:remove")
    @Log(title = "医师能力评估", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorAbilityAssessmentService.deleteWithValidByIds(List.of(ids), true));
    }
}
