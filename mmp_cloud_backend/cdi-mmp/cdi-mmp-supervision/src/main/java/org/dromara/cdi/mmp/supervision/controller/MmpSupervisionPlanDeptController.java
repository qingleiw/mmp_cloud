package org.dromara.cdi.mmp.supervision.controller;

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
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionPlanDeptVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionPlanDeptBo;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionPlanDeptService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 督查计划科室关联
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/supervisionPlanDept")
public class MmpSupervisionPlanDeptController extends BaseController {

    private final IMmpSupervisionPlanDeptService mmpSupervisionPlanDeptService;

    /**
     * 查询督查计划科室关联列表
     */
    @SaCheckPermission("system:supervisionPlanDept:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSupervisionPlanDeptVo> list(MmpSupervisionPlanDeptBo bo, PageQuery pageQuery) {
        return mmpSupervisionPlanDeptService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出督查计划科室关联列表
     */
    @SaCheckPermission("system:supervisionPlanDept:export")
    @Log(title = "督查计划科室关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSupervisionPlanDeptBo bo, HttpServletResponse response) {
        List<MmpSupervisionPlanDeptVo> list = mmpSupervisionPlanDeptService.queryList(bo);
        ExcelUtil.exportExcel(list, "督查计划科室关联", MmpSupervisionPlanDeptVo.class, response);
    }

    /**
     * 获取督查计划科室关联详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:supervisionPlanDept:query")
    @GetMapping("/{id}")
    public R<MmpSupervisionPlanDeptVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSupervisionPlanDeptService.queryById(id));
    }

    /**
     * 新增督查计划科室关联
     */
    @SaCheckPermission("system:supervisionPlanDept:add")
    @Log(title = "督查计划科室关联", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSupervisionPlanDeptBo bo) {
        return toAjax(mmpSupervisionPlanDeptService.insertByBo(bo));
    }

    /**
     * 修改督查计划科室关联
     */
    @SaCheckPermission("system:supervisionPlanDept:edit")
    @Log(title = "督查计划科室关联", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSupervisionPlanDeptBo bo) {
        return toAjax(mmpSupervisionPlanDeptService.updateByBo(bo));
    }

    /**
     * 删除督查计划科室关联
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:supervisionPlanDept:remove")
    @Log(title = "督查计划科室关联", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSupervisionPlanDeptService.deleteWithValidByIds(List.of(ids), true));
    }
}
