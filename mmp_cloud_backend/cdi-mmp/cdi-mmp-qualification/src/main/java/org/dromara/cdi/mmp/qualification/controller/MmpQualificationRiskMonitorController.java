package org.dromara.cdi.mmp.qualification.controller;

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
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationRiskMonitorVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationRiskMonitorBo;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationRiskMonitorService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资质风险监测
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/qualificationRiskMonitor")
public class MmpQualificationRiskMonitorController extends BaseController {

    private final IMmpQualificationRiskMonitorService mmpQualificationRiskMonitorService;

    /**
     * 查询资质风险监测列表
     */
    @SaCheckPermission("system:qualificationRiskMonitor:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQualificationRiskMonitorVo> list(MmpQualificationRiskMonitorBo bo, PageQuery pageQuery) {
        return mmpQualificationRiskMonitorService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资质风险监测列表
     */
    @SaCheckPermission("system:qualificationRiskMonitor:export")
    @Log(title = "资质风险监测", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQualificationRiskMonitorBo bo, HttpServletResponse response) {
        List<MmpQualificationRiskMonitorVo> list = mmpQualificationRiskMonitorService.queryList(bo);
        ExcelUtil.exportExcel(list, "资质风险监测", MmpQualificationRiskMonitorVo.class, response);
    }

    /**
     * 获取资质风险监测详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:qualificationRiskMonitor:query")
    @GetMapping("/{id}")
    public R<MmpQualificationRiskMonitorVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQualificationRiskMonitorService.queryById(id));
    }

    /**
     * 新增资质风险监测
     */
    @SaCheckPermission("system:qualificationRiskMonitor:add")
    @Log(title = "资质风险监测", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQualificationRiskMonitorBo bo) {
        return toAjax(mmpQualificationRiskMonitorService.insertByBo(bo));
    }

    /**
     * 修改资质风险监测
     */
    @SaCheckPermission("system:qualificationRiskMonitor:edit")
    @Log(title = "资质风险监测", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQualificationRiskMonitorBo bo) {
        return toAjax(mmpQualificationRiskMonitorService.updateByBo(bo));
    }

    /**
     * 删除资质风险监测
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:qualificationRiskMonitor:remove")
    @Log(title = "资质风险监测", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQualificationRiskMonitorService.deleteWithValidByIds(List.of(ids), true));
    }
}
