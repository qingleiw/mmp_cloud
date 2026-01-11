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
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionRectificationProgressVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionRectificationProgressBo;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionRectificationProgressService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 整改进度
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/supervisionRectificationProgress")
public class MmpSupervisionRectificationProgressController extends BaseController {

    private final IMmpSupervisionRectificationProgressService mmpSupervisionRectificationProgressService;

    /**
     * 查询整改进度列表
     */
    @SaCheckPermission("system:supervisionRectificationProgress:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSupervisionRectificationProgressVo> list(MmpSupervisionRectificationProgressBo bo, PageQuery pageQuery) {
        return mmpSupervisionRectificationProgressService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出整改进度列表
     */
    @SaCheckPermission("system:supervisionRectificationProgress:export")
    @Log(title = "整改进度", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSupervisionRectificationProgressBo bo, HttpServletResponse response) {
        List<MmpSupervisionRectificationProgressVo> list = mmpSupervisionRectificationProgressService.queryList(bo);
        ExcelUtil.exportExcel(list, "整改进度", MmpSupervisionRectificationProgressVo.class, response);
    }

    /**
     * 获取整改进度详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:supervisionRectificationProgress:query")
    @GetMapping("/{id}")
    public R<MmpSupervisionRectificationProgressVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSupervisionRectificationProgressService.queryById(id));
    }

    /**
     * 新增整改进度
     */
    @SaCheckPermission("system:supervisionRectificationProgress:add")
    @Log(title = "整改进度", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSupervisionRectificationProgressBo bo) {
        return toAjax(mmpSupervisionRectificationProgressService.insertByBo(bo));
    }

    /**
     * 修改整改进度
     */
    @SaCheckPermission("system:supervisionRectificationProgress:edit")
    @Log(title = "整改进度", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSupervisionRectificationProgressBo bo) {
        return toAjax(mmpSupervisionRectificationProgressService.updateByBo(bo));
    }

    /**
     * 删除整改进度
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:supervisionRectificationProgress:remove")
    @Log(title = "整改进度", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSupervisionRectificationProgressService.deleteWithValidByIds(List.of(ids), true));
    }
}
