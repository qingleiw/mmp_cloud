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
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationDoseMonitoringVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationDoseMonitoringBo;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationDoseMonitoringService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 个人剂量监测
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/radiationDoseMonitoring")
public class MmpRadiationDoseMonitoringController extends BaseController {

    private final IMmpRadiationDoseMonitoringService mmpRadiationDoseMonitoringService;

    /**
     * 查询个人剂量监测列表
     */
    @SaCheckPermission("system:radiationDoseMonitoring:list")
    @GetMapping("/list")
    public TableDataInfo<MmpRadiationDoseMonitoringVo> list(MmpRadiationDoseMonitoringBo bo, PageQuery pageQuery) {
        return mmpRadiationDoseMonitoringService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出个人剂量监测列表
     */
    @SaCheckPermission("system:radiationDoseMonitoring:export")
    @Log(title = "个人剂量监测", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpRadiationDoseMonitoringBo bo, HttpServletResponse response) {
        List<MmpRadiationDoseMonitoringVo> list = mmpRadiationDoseMonitoringService.queryList(bo);
        ExcelUtil.exportExcel(list, "个人剂量监测", MmpRadiationDoseMonitoringVo.class, response);
    }

    /**
     * 获取个人剂量监测详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:radiationDoseMonitoring:query")
    @GetMapping("/{id}")
    public R<MmpRadiationDoseMonitoringVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpRadiationDoseMonitoringService.queryById(id));
    }

    /**
     * 新增个人剂量监测
     */
    @SaCheckPermission("system:radiationDoseMonitoring:add")
    @Log(title = "个人剂量监测", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpRadiationDoseMonitoringBo bo) {
        return toAjax(mmpRadiationDoseMonitoringService.insertByBo(bo));
    }

    /**
     * 修改个人剂量监测
     */
    @SaCheckPermission("system:radiationDoseMonitoring:edit")
    @Log(title = "个人剂量监测", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpRadiationDoseMonitoringBo bo) {
        return toAjax(mmpRadiationDoseMonitoringService.updateByBo(bo));
    }

    /**
     * 删除个人剂量监测
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:radiationDoseMonitoring:remove")
    @Log(title = "个人剂量监测", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpRadiationDoseMonitoringService.deleteWithValidByIds(List.of(ids), true));
    }
}
