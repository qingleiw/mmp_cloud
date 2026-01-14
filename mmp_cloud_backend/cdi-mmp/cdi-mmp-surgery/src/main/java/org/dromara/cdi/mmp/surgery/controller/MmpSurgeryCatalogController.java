package org.dromara.system.controller;

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
import org.dromara.system.domain.vo.MmpSurgeryCatalogVo;
import org.dromara.system.domain.bo.MmpSurgeryCatalogBo;
import org.dromara.system.service.IMmpSurgeryCatalogService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 手术目录
 *
 * @author Lion Li
 * @date 2026-01-02
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/surgeryCatalog")
public class MmpSurgeryCatalogController extends BaseController {

    private final IMmpSurgeryCatalogService mmpSurgeryCatalogService;

    /**
     * 查询手术目录列表
     */
    @SaCheckPermission("system:surgeryCatalog:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSurgeryCatalogVo> list(MmpSurgeryCatalogBo bo, PageQuery pageQuery) {
        return mmpSurgeryCatalogService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出手术目录列表
     */
    @SaCheckPermission("system:surgeryCatalog:export")
    @Log(title = "手术目录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSurgeryCatalogBo bo, HttpServletResponse response) {
        List<MmpSurgeryCatalogVo> list = mmpSurgeryCatalogService.queryList(bo);
        ExcelUtil.exportExcel(list, "手术目录", MmpSurgeryCatalogVo.class, response);
    }

    /**
     * 获取手术目录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:surgeryCatalog:query")
    @GetMapping("/{id}")
    public R<MmpSurgeryCatalogVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSurgeryCatalogService.queryById(id));
    }

    /**
     * 新增手术目录
     */
    @SaCheckPermission("system:surgeryCatalog:add")
    @Log(title = "手术目录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSurgeryCatalogBo bo) {
        return toAjax(mmpSurgeryCatalogService.insertByBo(bo));
    }

    /**
     * 修改手术目录
     */
    @SaCheckPermission("system:surgeryCatalog:edit")
    @Log(title = "手术目录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSurgeryCatalogBo bo) {
        return toAjax(mmpSurgeryCatalogService.updateByBo(bo));
    }

    /**
     * 删除手术目录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:surgeryCatalog:remove")
    @Log(title = "手术目录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSurgeryCatalogService.deleteWithValidByIds(List.of(ids), true));
    }
}
