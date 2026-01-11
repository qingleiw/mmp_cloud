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
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionRectificationTaskVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionRectificationTaskBo;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionRectificationTaskService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 整改任务
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/supervisionRectificationTask")
public class MmpSupervisionRectificationTaskController extends BaseController {

    private final IMmpSupervisionRectificationTaskService mmpSupervisionRectificationTaskService;

    /**
     * 查询整改任务列表
     */
    @SaCheckPermission("system:supervisionRectificationTask:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSupervisionRectificationTaskVo> list(MmpSupervisionRectificationTaskBo bo, PageQuery pageQuery) {
        return mmpSupervisionRectificationTaskService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出整改任务列表
     */
    @SaCheckPermission("system:supervisionRectificationTask:export")
    @Log(title = "整改任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSupervisionRectificationTaskBo bo, HttpServletResponse response) {
        List<MmpSupervisionRectificationTaskVo> list = mmpSupervisionRectificationTaskService.queryList(bo);
        ExcelUtil.exportExcel(list, "整改任务", MmpSupervisionRectificationTaskVo.class, response);
    }

    /**
     * 获取整改任务详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:supervisionRectificationTask:query")
    @GetMapping("/{id}")
    public R<MmpSupervisionRectificationTaskVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSupervisionRectificationTaskService.queryById(id));
    }

    /**
     * 新增整改任务
     */
    @SaCheckPermission("system:supervisionRectificationTask:add")
    @Log(title = "整改任务", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSupervisionRectificationTaskBo bo) {
        return toAjax(mmpSupervisionRectificationTaskService.insertByBo(bo));
    }

    /**
     * 修改整改任务
     */
    @SaCheckPermission("system:supervisionRectificationTask:edit")
    @Log(title = "整改任务", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSupervisionRectificationTaskBo bo) {
        return toAjax(mmpSupervisionRectificationTaskService.updateByBo(bo));
    }

    /**
     * 删除整改任务
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:supervisionRectificationTask:remove")
    @Log(title = "整改任务", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSupervisionRectificationTaskService.deleteWithValidByIds(List.of(ids), true));
    }
}
