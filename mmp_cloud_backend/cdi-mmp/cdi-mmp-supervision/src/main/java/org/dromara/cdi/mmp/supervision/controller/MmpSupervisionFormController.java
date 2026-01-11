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
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionFormVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionFormBo;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionFormService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 督查单
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/supervisionForm")
public class MmpSupervisionFormController extends BaseController {

    private final IMmpSupervisionFormService mmpSupervisionFormService;

    /**
     * 查询督查单列表
     */
    @SaCheckPermission("system:supervisionForm:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSupervisionFormVo> list(MmpSupervisionFormBo bo, PageQuery pageQuery) {
        return mmpSupervisionFormService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出督查单列表
     */
    @SaCheckPermission("system:supervisionForm:export")
    @Log(title = "督查单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSupervisionFormBo bo, HttpServletResponse response) {
        List<MmpSupervisionFormVo> list = mmpSupervisionFormService.queryList(bo);
        ExcelUtil.exportExcel(list, "督查单", MmpSupervisionFormVo.class, response);
    }

    /**
     * 获取督查单详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:supervisionForm:query")
    @GetMapping("/{id}")
    public R<MmpSupervisionFormVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSupervisionFormService.queryById(id));
    }

    /**
     * 新增督查单
     */
    @SaCheckPermission("system:supervisionForm:add")
    @Log(title = "督查单", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSupervisionFormBo bo) {
        return toAjax(mmpSupervisionFormService.insertByBo(bo));
    }

    /**
     * 修改督查单
     */
    @SaCheckPermission("system:supervisionForm:edit")
    @Log(title = "督查单", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSupervisionFormBo bo) {
        return toAjax(mmpSupervisionFormService.updateByBo(bo));
    }

    /**
     * 删除督查单
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:supervisionForm:remove")
    @Log(title = "督查单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSupervisionFormService.deleteWithValidByIds(List.of(ids), true));
    }
}
