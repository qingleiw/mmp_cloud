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
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionPlanVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionPlanBo;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionPlanService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 督查计划
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/supervisionPlan")
public class MmpSupervisionPlanController extends BaseController {

    private final IMmpSupervisionPlanService mmpSupervisionPlanService;

    /**
     * 查询督查计划列表
     */
    @SaCheckPermission("system:supervisionPlan:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSupervisionPlanVo> list(MmpSupervisionPlanBo bo, PageQuery pageQuery) {
        return mmpSupervisionPlanService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出督查计划列表
     */
    @SaCheckPermission("system:supervisionPlan:export")
    @Log(title = "督查计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSupervisionPlanBo bo, HttpServletResponse response) {
        List<MmpSupervisionPlanVo> list = mmpSupervisionPlanService.queryList(bo);
        ExcelUtil.exportExcel(list, "督查计划", MmpSupervisionPlanVo.class, response);
    }

    /**
     * 获取督查计划详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:supervisionPlan:query")
    @GetMapping("/{id}")
    public R<MmpSupervisionPlanVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSupervisionPlanService.queryById(id));
    }

    /**
     * 新增督查计划
     */
    @SaCheckPermission("system:supervisionPlan:add")
    @Log(title = "督查计划", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSupervisionPlanBo bo) {
        return toAjax(mmpSupervisionPlanService.insertByBo(bo));
    }

    /**
     * 修改督查计划
     */
    @SaCheckPermission("system:supervisionPlan:edit")
    @Log(title = "督查计划", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSupervisionPlanBo bo) {
        return toAjax(mmpSupervisionPlanService.updateByBo(bo));
    }

    /**
     * 删除督查计划
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:supervisionPlan:remove")
    @Log(title = "督查计划", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSupervisionPlanService.deleteWithValidByIds(List.of(ids), true));
    }
}
