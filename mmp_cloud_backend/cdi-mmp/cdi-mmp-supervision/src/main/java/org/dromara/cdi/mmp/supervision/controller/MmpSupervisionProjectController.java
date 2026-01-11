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
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionProjectVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionProjectBo;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionProjectService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 督查项目
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/supervisionProject")
public class MmpSupervisionProjectController extends BaseController {

    private final IMmpSupervisionProjectService mmpSupervisionProjectService;

    /**
     * 查询督查项目列表
     */
    @SaCheckPermission("system:supervisionProject:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSupervisionProjectVo> list(MmpSupervisionProjectBo bo, PageQuery pageQuery) {
        return mmpSupervisionProjectService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出督查项目列表
     */
    @SaCheckPermission("system:supervisionProject:export")
    @Log(title = "督查项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSupervisionProjectBo bo, HttpServletResponse response) {
        List<MmpSupervisionProjectVo> list = mmpSupervisionProjectService.queryList(bo);
        ExcelUtil.exportExcel(list, "督查项目", MmpSupervisionProjectVo.class, response);
    }

    /**
     * 获取督查项目详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:supervisionProject:query")
    @GetMapping("/{id}")
    public R<MmpSupervisionProjectVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSupervisionProjectService.queryById(id));
    }

    /**
     * 新增督查项目
     */
    @SaCheckPermission("system:supervisionProject:add")
    @Log(title = "督查项目", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSupervisionProjectBo bo) {
        return toAjax(mmpSupervisionProjectService.insertByBo(bo));
    }

    /**
     * 修改督查项目
     */
    @SaCheckPermission("system:supervisionProject:edit")
    @Log(title = "督查项目", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSupervisionProjectBo bo) {
        return toAjax(mmpSupervisionProjectService.updateByBo(bo));
    }

    /**
     * 删除督查项目
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:supervisionProject:remove")
    @Log(title = "督查项目", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSupervisionProjectService.deleteWithValidByIds(List.of(ids), true));
    }
}
