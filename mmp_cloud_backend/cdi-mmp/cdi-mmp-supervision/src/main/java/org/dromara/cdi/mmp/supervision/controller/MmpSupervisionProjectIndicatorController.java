package org.dromara.cdi.mmp.supervision.controller;

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
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionProjectIndicatorVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionProjectIndicatorBo;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionProjectIndicatorService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 督查项目指标
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/supervisionProjectIndicator")
public class MmpSupervisionProjectIndicatorController extends BaseController {

    private final IMmpSupervisionProjectIndicatorService mmpSupervisionProjectIndicatorService;

    /**
     * 查询督查项目指标列表
     */
    @SaCheckPermission("system:supervisionProjectIndicator:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSupervisionProjectIndicatorVo> list(MmpSupervisionProjectIndicatorBo bo, PageQuery pageQuery) {
        return mmpSupervisionProjectIndicatorService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出督查项目指标列表
     */
    @SaCheckPermission("system:supervisionProjectIndicator:export")
    @Log(title = "督查项目指标", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSupervisionProjectIndicatorBo bo, HttpServletResponse response) {
        List<MmpSupervisionProjectIndicatorVo> list = mmpSupervisionProjectIndicatorService.queryList(bo);
        ExcelUtil.exportExcel(list, "督查项目指标", MmpSupervisionProjectIndicatorVo.class, response);
    }

    /**
     * 获取督查项目指标详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:supervisionProjectIndicator:query")
    @GetMapping("/{id}")
    public R<MmpSupervisionProjectIndicatorVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSupervisionProjectIndicatorService.queryById(id));
    }

    /**
     * 新增督查项目指标
     */
    @SaCheckPermission("system:supervisionProjectIndicator:add")
    @Log(title = "督查项目指标", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSupervisionProjectIndicatorBo bo) {
        return toAjax(mmpSupervisionProjectIndicatorService.insertByBo(bo));
    }

    /**
     * 修改督查项目指标
     */
    @SaCheckPermission("system:supervisionProjectIndicator:edit")
    @Log(title = "督查项目指标", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSupervisionProjectIndicatorBo bo) {
        return toAjax(mmpSupervisionProjectIndicatorService.updateByBo(bo));
    }

    /**
     * 删除督查项目指标
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:supervisionProjectIndicator:remove")
    @Log(title = "督查项目指标", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSupervisionProjectIndicatorService.deleteWithValidByIds(List.of(ids), true));
    }
}
