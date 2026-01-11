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
import org.dromara.cdi.mmp.qualification.domain.vo.MmpDepartmentQualificationCatalogVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpDepartmentQualificationCatalogBo;
import org.dromara.cdi.mmp.qualification.service.IMmpDepartmentQualificationCatalogService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 科室资质目录
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/departmentQualificationCatalog")
public class MmpDepartmentQualificationCatalogController extends BaseController {

    private final IMmpDepartmentQualificationCatalogService mmpDepartmentQualificationCatalogService;

    /**
     * 查询科室资质目录列表
     */
    @SaCheckPermission("system:departmentQualificationCatalog:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDepartmentQualificationCatalogVo> list(MmpDepartmentQualificationCatalogBo bo, PageQuery pageQuery) {
        return mmpDepartmentQualificationCatalogService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出科室资质目录列表
     */
    @SaCheckPermission("system:departmentQualificationCatalog:export")
    @Log(title = "科室资质目录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDepartmentQualificationCatalogBo bo, HttpServletResponse response) {
        List<MmpDepartmentQualificationCatalogVo> list = mmpDepartmentQualificationCatalogService.queryList(bo);
        ExcelUtil.exportExcel(list, "科室资质目录", MmpDepartmentQualificationCatalogVo.class, response);
    }

    /**
     * 获取科室资质目录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:departmentQualificationCatalog:query")
    @GetMapping("/{id}")
    public R<MmpDepartmentQualificationCatalogVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDepartmentQualificationCatalogService.queryById(id));
    }

    /**
     * 新增科室资质目录
     */
    @SaCheckPermission("system:departmentQualificationCatalog:add")
    @Log(title = "科室资质目录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDepartmentQualificationCatalogBo bo) {
        return toAjax(mmpDepartmentQualificationCatalogService.insertByBo(bo));
    }

    /**
     * 修改科室资质目录
     */
    @SaCheckPermission("system:departmentQualificationCatalog:edit")
    @Log(title = "科室资质目录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDepartmentQualificationCatalogBo bo) {
        return toAjax(mmpDepartmentQualificationCatalogService.updateByBo(bo));
    }

    /**
     * 删除科室资质目录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:departmentQualificationCatalog:remove")
    @Log(title = "科室资质目录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDepartmentQualificationCatalogService.deleteWithValidByIds(List.of(ids), true));
    }
}
