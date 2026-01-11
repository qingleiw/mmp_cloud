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
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationDoseAlertVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationDoseAlertBo;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationDoseAlertService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 剂量监测预警设置
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/radiationDoseAlert")
public class MmpRadiationDoseAlertController extends BaseController {

    private final IMmpRadiationDoseAlertService mmpRadiationDoseAlertService;

    /**
     * 查询剂量监测预警设置列表
     */
    @SaCheckPermission("system:radiationDoseAlert:list")
    @GetMapping("/list")
    public TableDataInfo<MmpRadiationDoseAlertVo> list(MmpRadiationDoseAlertBo bo, PageQuery pageQuery) {
        return mmpRadiationDoseAlertService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出剂量监测预警设置列表
     */
    @SaCheckPermission("system:radiationDoseAlert:export")
    @Log(title = "剂量监测预警设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpRadiationDoseAlertBo bo, HttpServletResponse response) {
        List<MmpRadiationDoseAlertVo> list = mmpRadiationDoseAlertService.queryList(bo);
        ExcelUtil.exportExcel(list, "剂量监测预警设置", MmpRadiationDoseAlertVo.class, response);
    }

    /**
     * 获取剂量监测预警设置详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:radiationDoseAlert:query")
    @GetMapping("/{id}")
    public R<MmpRadiationDoseAlertVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpRadiationDoseAlertService.queryById(id));
    }

    /**
     * 新增剂量监测预警设置
     */
    @SaCheckPermission("system:radiationDoseAlert:add")
    @Log(title = "剂量监测预警设置", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpRadiationDoseAlertBo bo) {
        return toAjax(mmpRadiationDoseAlertService.insertByBo(bo));
    }

    /**
     * 修改剂量监测预警设置
     */
    @SaCheckPermission("system:radiationDoseAlert:edit")
    @Log(title = "剂量监测预警设置", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpRadiationDoseAlertBo bo) {
        return toAjax(mmpRadiationDoseAlertService.updateByBo(bo));
    }

    /**
     * 删除剂量监测预警设置
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:radiationDoseAlert:remove")
    @Log(title = "剂量监测预警设置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpRadiationDoseAlertService.deleteWithValidByIds(List.of(ids), true));
    }
}
