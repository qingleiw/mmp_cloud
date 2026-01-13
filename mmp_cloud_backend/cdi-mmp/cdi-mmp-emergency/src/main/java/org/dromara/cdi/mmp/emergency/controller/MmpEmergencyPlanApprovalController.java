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
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyPlanApprovalVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyPlanApprovalBo;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyPlanApprovalService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 应急预案审批
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/emergencyPlanApproval")
public class MmpEmergencyPlanApprovalController extends BaseController {

    private final IMmpEmergencyPlanApprovalService mmpEmergencyPlanApprovalService;

    /**
     * 查询应急预案审批列表
     */
    @SaCheckPermission("emergency:emergencyPlanApproval:list")
    @GetMapping("/list")
    public TableDataInfo<MmpEmergencyPlanApprovalVo> list(MmpEmergencyPlanApprovalBo bo, PageQuery pageQuery) {
        return mmpEmergencyPlanApprovalService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出应急预案审批列表
     */
    @SaCheckPermission("emergency:emergencyPlanApproval:export")
    @Log(title = "应急预案审批", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpEmergencyPlanApprovalBo bo, HttpServletResponse response) {
        List<MmpEmergencyPlanApprovalVo> list = mmpEmergencyPlanApprovalService.queryList(bo);
        ExcelUtil.exportExcel(list, "应急预案审批", MmpEmergencyPlanApprovalVo.class, response);
    }

    /**
     * 获取应急预案审批详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("emergency:emergencyPlanApproval:query")
    @GetMapping("/{id}")
    public R<MmpEmergencyPlanApprovalVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpEmergencyPlanApprovalService.queryById(id));
    }

    /**
     * 新增应急预案审批
     */
    @SaCheckPermission("emergency:emergencyPlanApproval:add")
    @Log(title = "应急预案审批", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpEmergencyPlanApprovalBo bo) {
        return toAjax(mmpEmergencyPlanApprovalService.insertByBo(bo));
    }

    /**
     * 修改应急预案审批
     */
    @SaCheckPermission("emergency:emergencyPlanApproval:edit")
    @Log(title = "应急预案审批", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpEmergencyPlanApprovalBo bo) {
        return toAjax(mmpEmergencyPlanApprovalService.updateByBo(bo));
    }

    /**
     * 删除应急预案审批
     *
     * @param ids 主键串
     */
    @SaCheckPermission("emergency:emergencyPlanApproval:remove")
    @Log(title = "应急预案审批", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpEmergencyPlanApprovalService.deleteWithValidByIds(List.of(ids), true));
    }
}
