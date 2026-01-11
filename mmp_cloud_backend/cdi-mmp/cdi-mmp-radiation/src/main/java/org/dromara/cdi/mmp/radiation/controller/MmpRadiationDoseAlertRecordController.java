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
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationDoseAlertRecordVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationDoseAlertRecordBo;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationDoseAlertRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 剂量异常预警记录
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/radiationDoseAlertRecord")
public class MmpRadiationDoseAlertRecordController extends BaseController {

    private final IMmpRadiationDoseAlertRecordService mmpRadiationDoseAlertRecordService;

    /**
     * 查询剂量异常预警记录列表
     */
    @SaCheckPermission("system:radiationDoseAlertRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpRadiationDoseAlertRecordVo> list(MmpRadiationDoseAlertRecordBo bo, PageQuery pageQuery) {
        return mmpRadiationDoseAlertRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出剂量异常预警记录列表
     */
    @SaCheckPermission("system:radiationDoseAlertRecord:export")
    @Log(title = "剂量异常预警记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpRadiationDoseAlertRecordBo bo, HttpServletResponse response) {
        List<MmpRadiationDoseAlertRecordVo> list = mmpRadiationDoseAlertRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "剂量异常预警记录", MmpRadiationDoseAlertRecordVo.class, response);
    }

    /**
     * 获取剂量异常预警记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:radiationDoseAlertRecord:query")
    @GetMapping("/{id}")
    public R<MmpRadiationDoseAlertRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpRadiationDoseAlertRecordService.queryById(id));
    }

    /**
     * 新增剂量异常预警记录
     */
    @SaCheckPermission("system:radiationDoseAlertRecord:add")
    @Log(title = "剂量异常预警记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpRadiationDoseAlertRecordBo bo) {
        return toAjax(mmpRadiationDoseAlertRecordService.insertByBo(bo));
    }

    /**
     * 修改剂量异常预警记录
     */
    @SaCheckPermission("system:radiationDoseAlertRecord:edit")
    @Log(title = "剂量异常预警记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpRadiationDoseAlertRecordBo bo) {
        return toAjax(mmpRadiationDoseAlertRecordService.updateByBo(bo));
    }

    /**
     * 删除剂量异常预警记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:radiationDoseAlertRecord:remove")
    @Log(title = "剂量异常预警记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpRadiationDoseAlertRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
