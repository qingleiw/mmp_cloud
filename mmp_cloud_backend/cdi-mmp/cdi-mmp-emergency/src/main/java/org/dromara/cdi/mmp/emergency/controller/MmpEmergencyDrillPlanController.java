package org.dromara.cdi.mmp.emergency.controller;

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
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyDrillPlanVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyDrillPlanBo;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyDrillPlanService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 应急演练计划
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/emergencyDrillPlan")
public class MmpEmergencyDrillPlanController extends BaseController {

    private final IMmpEmergencyDrillPlanService mmpEmergencyDrillPlanService;

    /**
     * 查询应急演练计划列表
     */
    @SaCheckPermission("emergency:emergencyDrillPlan:list")
    @GetMapping("/list")
    public TableDataInfo<MmpEmergencyDrillPlanVo> list(MmpEmergencyDrillPlanBo bo, PageQuery pageQuery) {
        return mmpEmergencyDrillPlanService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出应急演练计划列表
     */
    @SaCheckPermission("emergency:emergencyDrillPlan:export")
    @Log(title = "应急演练计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpEmergencyDrillPlanBo bo, HttpServletResponse response) {
        List<MmpEmergencyDrillPlanVo> list = mmpEmergencyDrillPlanService.queryList(bo);
        ExcelUtil.exportExcel(list, "应急演练计划", MmpEmergencyDrillPlanVo.class, response);
    }

    /**
     * 获取应急演练计划详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("emergency:emergencyDrillPlan:query")
    @GetMapping("/{id}")
    public R<MmpEmergencyDrillPlanVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpEmergencyDrillPlanService.queryById(id));
    }

    /**
     * 新增应急演练计划
     */
    @SaCheckPermission("emergency:emergencyDrillPlan:add")
    @Log(title = "应急演练计划", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpEmergencyDrillPlanBo bo) {
        return toAjax(mmpEmergencyDrillPlanService.insertByBo(bo));
    }

    /**
     * 修改应急演练计划
     */
    @SaCheckPermission("emergency:emergencyDrillPlan:edit")
    @Log(title = "应急演练计划", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpEmergencyDrillPlanBo bo) {
        return toAjax(mmpEmergencyDrillPlanService.updateByBo(bo));
    }

    /**
     * 删除应急演练计划
     *
     * @param ids 主键串
     */
    @SaCheckPermission("emergency:emergencyDrillPlan:remove")
    @Log(title = "应急演练计划", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpEmergencyDrillPlanService.deleteWithValidByIds(List.of(ids), true));
    }
}
