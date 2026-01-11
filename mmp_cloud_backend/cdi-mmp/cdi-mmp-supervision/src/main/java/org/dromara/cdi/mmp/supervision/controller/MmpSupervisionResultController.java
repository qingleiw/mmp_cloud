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
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionResultVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionResultBo;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionResultService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 督查结果
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/supervisionResult")
public class MmpSupervisionResultController extends BaseController {

    private final IMmpSupervisionResultService mmpSupervisionResultService;

    /**
     * 查询督查结果列表
     */
    @SaCheckPermission("system:supervisionResult:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSupervisionResultVo> list(MmpSupervisionResultBo bo, PageQuery pageQuery) {
        return mmpSupervisionResultService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出督查结果列表
     */
    @SaCheckPermission("system:supervisionResult:export")
    @Log(title = "督查结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSupervisionResultBo bo, HttpServletResponse response) {
        List<MmpSupervisionResultVo> list = mmpSupervisionResultService.queryList(bo);
        ExcelUtil.exportExcel(list, "督查结果", MmpSupervisionResultVo.class, response);
    }

    /**
     * 获取督查结果详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:supervisionResult:query")
    @GetMapping("/{id}")
    public R<MmpSupervisionResultVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSupervisionResultService.queryById(id));
    }

    /**
     * 新增督查结果
     */
    @SaCheckPermission("system:supervisionResult:add")
    @Log(title = "督查结果", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSupervisionResultBo bo) {
        return toAjax(mmpSupervisionResultService.insertByBo(bo));
    }

    /**
     * 修改督查结果
     */
    @SaCheckPermission("system:supervisionResult:edit")
    @Log(title = "督查结果", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSupervisionResultBo bo) {
        return toAjax(mmpSupervisionResultService.updateByBo(bo));
    }

    /**
     * 删除督查结果
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:supervisionResult:remove")
    @Log(title = "督查结果", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSupervisionResultService.deleteWithValidByIds(List.of(ids), true));
    }
}
