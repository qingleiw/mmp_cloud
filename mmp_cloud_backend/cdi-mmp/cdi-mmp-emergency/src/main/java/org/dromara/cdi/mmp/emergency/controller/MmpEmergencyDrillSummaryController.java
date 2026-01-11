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
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyDrillSummaryVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyDrillSummaryBo;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyDrillSummaryService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 应急演练总结
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/emergencyDrillSummary")
public class MmpEmergencyDrillSummaryController extends BaseController {

    private final IMmpEmergencyDrillSummaryService mmpEmergencyDrillSummaryService;

    /**
     * 查询应急演练总结列表
     */
    @SaCheckPermission("system:emergencyDrillSummary:list")
    @GetMapping("/list")
    public TableDataInfo<MmpEmergencyDrillSummaryVo> list(MmpEmergencyDrillSummaryBo bo, PageQuery pageQuery) {
        return mmpEmergencyDrillSummaryService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出应急演练总结列表
     */
    @SaCheckPermission("system:emergencyDrillSummary:export")
    @Log(title = "应急演练总结", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpEmergencyDrillSummaryBo bo, HttpServletResponse response) {
        List<MmpEmergencyDrillSummaryVo> list = mmpEmergencyDrillSummaryService.queryList(bo);
        ExcelUtil.exportExcel(list, "应急演练总结", MmpEmergencyDrillSummaryVo.class, response);
    }

    /**
     * 获取应急演练总结详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:emergencyDrillSummary:query")
    @GetMapping("/{id}")
    public R<MmpEmergencyDrillSummaryVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpEmergencyDrillSummaryService.queryById(id));
    }

    /**
     * 新增应急演练总结
     */
    @SaCheckPermission("system:emergencyDrillSummary:add")
    @Log(title = "应急演练总结", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpEmergencyDrillSummaryBo bo) {
        return toAjax(mmpEmergencyDrillSummaryService.insertByBo(bo));
    }

    /**
     * 修改应急演练总结
     */
    @SaCheckPermission("system:emergencyDrillSummary:edit")
    @Log(title = "应急演练总结", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpEmergencyDrillSummaryBo bo) {
        return toAjax(mmpEmergencyDrillSummaryService.updateByBo(bo));
    }

    /**
     * 删除应急演练总结
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:emergencyDrillSummary:remove")
    @Log(title = "应急演练总结", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpEmergencyDrillSummaryService.deleteWithValidByIds(List.of(ids), true));
    }
}
