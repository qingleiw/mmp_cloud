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
import org.dromara.cdi.mmp.qualification.domain.vo.MmpTechnicianQualificationCatalogVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpTechnicianQualificationCatalogBo;
import org.dromara.cdi.mmp.qualification.service.IMmpTechnicianQualificationCatalogService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 医技资质目录
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/technicianQualificationCatalog")
public class MmpTechnicianQualificationCatalogController extends BaseController {

    private final IMmpTechnicianQualificationCatalogService mmpTechnicianQualificationCatalogService;

    /**
     * 查询医技资质目录列表
     */
    @SaCheckPermission("system:technicianQualificationCatalog:list")
    @GetMapping("/list")
    public TableDataInfo<MmpTechnicianQualificationCatalogVo> list(MmpTechnicianQualificationCatalogBo bo, PageQuery pageQuery) {
        return mmpTechnicianQualificationCatalogService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出医技资质目录列表
     */
    @SaCheckPermission("system:technicianQualificationCatalog:export")
    @Log(title = "医技资质目录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpTechnicianQualificationCatalogBo bo, HttpServletResponse response) {
        List<MmpTechnicianQualificationCatalogVo> list = mmpTechnicianQualificationCatalogService.queryList(bo);
        ExcelUtil.exportExcel(list, "医技资质目录", MmpTechnicianQualificationCatalogVo.class, response);
    }

    /**
     * 获取医技资质目录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:technicianQualificationCatalog:query")
    @GetMapping("/{id}")
    public R<MmpTechnicianQualificationCatalogVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpTechnicianQualificationCatalogService.queryById(id));
    }

    /**
     * 新增医技资质目录
     */
    @SaCheckPermission("system:technicianQualificationCatalog:add")
    @Log(title = "医技资质目录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpTechnicianQualificationCatalogBo bo) {
        return toAjax(mmpTechnicianQualificationCatalogService.insertByBo(bo));
    }

    /**
     * 修改医技资质目录
     */
    @SaCheckPermission("system:technicianQualificationCatalog:edit")
    @Log(title = "医技资质目录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpTechnicianQualificationCatalogBo bo) {
        return toAjax(mmpTechnicianQualificationCatalogService.updateByBo(bo));
    }

    /**
     * 删除医技资质目录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:technicianQualificationCatalog:remove")
    @Log(title = "医技资质目录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpTechnicianQualificationCatalogService.deleteWithValidByIds(List.of(ids), true));
    }
}
