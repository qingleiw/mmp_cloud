package org.dromara.cdi.mmp.radiation.controller;

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
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationEquipmentInspectionVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationEquipmentInspectionBo;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationEquipmentInspectionService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 放射设备检测记录
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/radiationEquipmentInspection")
public class MmpRadiationEquipmentInspectionController extends BaseController {

    private final IMmpRadiationEquipmentInspectionService mmpRadiationEquipmentInspectionService;

    /**
     * 查询放射设备检测记录列表
     */
    @SaCheckPermission("system:radiationEquipmentInspection:list")
    @GetMapping("/list")
    public TableDataInfo<MmpRadiationEquipmentInspectionVo> list(MmpRadiationEquipmentInspectionBo bo, PageQuery pageQuery) {
        return mmpRadiationEquipmentInspectionService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出放射设备检测记录列表
     */
    @SaCheckPermission("system:radiationEquipmentInspection:export")
    @Log(title = "放射设备检测记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpRadiationEquipmentInspectionBo bo, HttpServletResponse response) {
        List<MmpRadiationEquipmentInspectionVo> list = mmpRadiationEquipmentInspectionService.queryList(bo);
        ExcelUtil.exportExcel(list, "放射设备检测记录", MmpRadiationEquipmentInspectionVo.class, response);
    }

    /**
     * 获取放射设备检测记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:radiationEquipmentInspection:query")
    @GetMapping("/{id}")
    public R<MmpRadiationEquipmentInspectionVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpRadiationEquipmentInspectionService.queryById(id));
    }

    /**
     * 新增放射设备检测记录
     */
    @SaCheckPermission("system:radiationEquipmentInspection:add")
    @Log(title = "放射设备检测记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpRadiationEquipmentInspectionBo bo) {
        return toAjax(mmpRadiationEquipmentInspectionService.insertByBo(bo));
    }

    /**
     * 修改放射设备检测记录
     */
    @SaCheckPermission("system:radiationEquipmentInspection:edit")
    @Log(title = "放射设备检测记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpRadiationEquipmentInspectionBo bo) {
        return toAjax(mmpRadiationEquipmentInspectionService.updateByBo(bo));
    }

    /**
     * 删除放射设备检测记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:radiationEquipmentInspection:remove")
    @Log(title = "放射设备检测记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpRadiationEquipmentInspectionService.deleteWithValidByIds(List.of(ids), true));
    }
}
