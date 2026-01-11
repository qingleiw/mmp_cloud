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
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyMedicalSupportVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyMedicalSupportBo;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyMedicalSupportService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 医疗保障资源
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/emergencyMedicalSupport")
public class MmpEmergencyMedicalSupportController extends BaseController {

    private final IMmpEmergencyMedicalSupportService mmpEmergencyMedicalSupportService;

    /**
     * 查询医疗保障资源列表
     */
    @SaCheckPermission("system:emergencyMedicalSupport:list")
    @GetMapping("/list")
    public TableDataInfo<MmpEmergencyMedicalSupportVo> list(MmpEmergencyMedicalSupportBo bo, PageQuery pageQuery) {
        return mmpEmergencyMedicalSupportService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出医疗保障资源列表
     */
    @SaCheckPermission("system:emergencyMedicalSupport:export")
    @Log(title = "医疗保障资源", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpEmergencyMedicalSupportBo bo, HttpServletResponse response) {
        List<MmpEmergencyMedicalSupportVo> list = mmpEmergencyMedicalSupportService.queryList(bo);
        ExcelUtil.exportExcel(list, "医疗保障资源", MmpEmergencyMedicalSupportVo.class, response);
    }

    /**
     * 获取医疗保障资源详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:emergencyMedicalSupport:query")
    @GetMapping("/{id}")
    public R<MmpEmergencyMedicalSupportVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpEmergencyMedicalSupportService.queryById(id));
    }

    /**
     * 新增医疗保障资源
     */
    @SaCheckPermission("system:emergencyMedicalSupport:add")
    @Log(title = "医疗保障资源", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpEmergencyMedicalSupportBo bo) {
        return toAjax(mmpEmergencyMedicalSupportService.insertByBo(bo));
    }

    /**
     * 修改医疗保障资源
     */
    @SaCheckPermission("system:emergencyMedicalSupport:edit")
    @Log(title = "医疗保障资源", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpEmergencyMedicalSupportBo bo) {
        return toAjax(mmpEmergencyMedicalSupportService.updateByBo(bo));
    }

    /**
     * 删除医疗保障资源
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:emergencyMedicalSupport:remove")
    @Log(title = "医疗保障资源", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpEmergencyMedicalSupportService.deleteWithValidByIds(List.of(ids), true));
    }
}
