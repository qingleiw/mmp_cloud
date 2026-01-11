package org.dromara.cdi.mmp.qualification.controller;

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
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationPermissionAdjustmentVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationPermissionAdjustmentBo;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationPermissionAdjustmentService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资质权限调整历史
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/qualificationPermissionAdjustment")
public class MmpQualificationPermissionAdjustmentController extends BaseController {

    private final IMmpQualificationPermissionAdjustmentService mmpQualificationPermissionAdjustmentService;

    /**
     * 查询资质权限调整历史列表
     */
    @SaCheckPermission("system:qualificationPermissionAdjustment:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQualificationPermissionAdjustmentVo> list(MmpQualificationPermissionAdjustmentBo bo, PageQuery pageQuery) {
        return mmpQualificationPermissionAdjustmentService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资质权限调整历史列表
     */
    @SaCheckPermission("system:qualificationPermissionAdjustment:export")
    @Log(title = "资质权限调整历史", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQualificationPermissionAdjustmentBo bo, HttpServletResponse response) {
        List<MmpQualificationPermissionAdjustmentVo> list = mmpQualificationPermissionAdjustmentService.queryList(bo);
        ExcelUtil.exportExcel(list, "资质权限调整历史", MmpQualificationPermissionAdjustmentVo.class, response);
    }

    /**
     * 获取资质权限调整历史详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:qualificationPermissionAdjustment:query")
    @GetMapping("/{id}")
    public R<MmpQualificationPermissionAdjustmentVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQualificationPermissionAdjustmentService.queryById(id));
    }

    /**
     * 新增资质权限调整历史
     */
    @SaCheckPermission("system:qualificationPermissionAdjustment:add")
    @Log(title = "资质权限调整历史", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQualificationPermissionAdjustmentBo bo) {
        return toAjax(mmpQualificationPermissionAdjustmentService.insertByBo(bo));
    }

    /**
     * 修改资质权限调整历史
     */
    @SaCheckPermission("system:qualificationPermissionAdjustment:edit")
    @Log(title = "资质权限调整历史", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQualificationPermissionAdjustmentBo bo) {
        return toAjax(mmpQualificationPermissionAdjustmentService.updateByBo(bo));
    }

    /**
     * 删除资质权限调整历史
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:qualificationPermissionAdjustment:remove")
    @Log(title = "资质权限调整历史", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQualificationPermissionAdjustmentService.deleteWithValidByIds(List.of(ids), true));
    }
}
