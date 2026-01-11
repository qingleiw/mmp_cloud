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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorEthicsEvaluationVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorEthicsEvaluationBo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorEthicsEvaluationService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 医德医风考评
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctorEthicsEvaluation")
public class MmpDoctorEthicsEvaluationController extends BaseController {

    private final IMmpDoctorEthicsEvaluationService mmpDoctorEthicsEvaluationService;

    /**
     * 查询医德医风考评列表
     */
    @SaCheckPermission("doctor:doctorEthicsEvaluation:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorEthicsEvaluationVo> list(MmpDoctorEthicsEvaluationBo bo, PageQuery pageQuery) {
        return mmpDoctorEthicsEvaluationService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出医德医风考评列表
     */
    @SaCheckPermission("doctor:doctorEthicsEvaluation:export")
    @Log(title = "医德医风考评", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorEthicsEvaluationBo bo, HttpServletResponse response) {
        List<MmpDoctorEthicsEvaluationVo> list = mmpDoctorEthicsEvaluationService.queryList(bo);
        ExcelUtil.exportExcel(list, "医德医风考评", MmpDoctorEthicsEvaluationVo.class, response);
    }

    /**
     * 获取医德医风考评详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorEthicsEvaluation:query")
    @GetMapping("/{id}")
    public R<MmpDoctorEthicsEvaluationVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorEthicsEvaluationService.queryById(id));
    }

    /**
     * 新增医德医风考评
     */
    @SaCheckPermission("doctor:doctorEthicsEvaluation:add")
    @Log(title = "医德医风考评", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorEthicsEvaluationBo bo) {
        return toAjax(mmpDoctorEthicsEvaluationService.insertByBo(bo));
    }

    /**
     * 修改医德医风考评
     */
    @SaCheckPermission("doctor:doctorEthicsEvaluation:edit")
    @Log(title = "医德医风考评", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorEthicsEvaluationBo bo) {
        return toAjax(mmpDoctorEthicsEvaluationService.updateByBo(bo));
    }

    /**
     * 删除医德医风考评
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorEthicsEvaluation:remove")
    @Log(title = "医德医风考评", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorEthicsEvaluationService.deleteWithValidByIds(List.of(ids), true));
    }
}
