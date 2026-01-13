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
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyEventTreatmentVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyEventTreatmentBo;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyEventTreatmentService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 突发事件救治
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/emergencyEventTreatment")
public class MmpEmergencyEventTreatmentController extends BaseController {

    private final IMmpEmergencyEventTreatmentService mmpEmergencyEventTreatmentService;

    /**
     * 查询突发事件救治列表
     */
    @SaCheckPermission("emergency:emergencyEventTreatment:list")
    @GetMapping("/list")
    public TableDataInfo<MmpEmergencyEventTreatmentVo> list(MmpEmergencyEventTreatmentBo bo, PageQuery pageQuery) {
        return mmpEmergencyEventTreatmentService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出突发事件救治列表
     */
    @SaCheckPermission("emergency:emergencyEventTreatment:export")
    @Log(title = "突发事件救治", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpEmergencyEventTreatmentBo bo, HttpServletResponse response) {
        List<MmpEmergencyEventTreatmentVo> list = mmpEmergencyEventTreatmentService.queryList(bo);
        ExcelUtil.exportExcel(list, "突发事件救治", MmpEmergencyEventTreatmentVo.class, response);
    }

    /**
     * 获取突发事件救治详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("emergency:emergencyEventTreatment:query")
    @GetMapping("/{id}")
    public R<MmpEmergencyEventTreatmentVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpEmergencyEventTreatmentService.queryById(id));
    }

    /**
     * 新增突发事件救治
     */
    @SaCheckPermission("emergency:emergencyEventTreatment:add")
    @Log(title = "突发事件救治", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpEmergencyEventTreatmentBo bo) {
        return toAjax(mmpEmergencyEventTreatmentService.insertByBo(bo));
    }

    /**
     * 修改突发事件救治
     */
    @SaCheckPermission("emergency:emergencyEventTreatment:edit")
    @Log(title = "突发事件救治", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpEmergencyEventTreatmentBo bo) {
        return toAjax(mmpEmergencyEventTreatmentService.updateByBo(bo));
    }

    /**
     * 删除突发事件救治
     *
     * @param ids 主键串
     */
    @SaCheckPermission("emergency:emergencyEventTreatment:remove")
    @Log(title = "突发事件救治", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpEmergencyEventTreatmentService.deleteWithValidByIds(List.of(ids), true));
    }
}
