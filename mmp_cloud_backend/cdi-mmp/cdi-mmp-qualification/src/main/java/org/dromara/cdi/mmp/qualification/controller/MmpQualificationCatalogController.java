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
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationCatalogVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationCatalogBo;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationCatalogService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 医生手术授权目录
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/qualificationCatalog")
public class MmpQualificationCatalogController extends BaseController {

    private final IMmpQualificationCatalogService mmpQualificationCatalogService;

    /**
     * 查询医生手术授权目录列表
     */
    @SaCheckPermission("system:qualificationCatalog:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQualificationCatalogVo> list(MmpQualificationCatalogBo bo, PageQuery pageQuery) {
        return mmpQualificationCatalogService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出医生手术授权目录列表
     */
    @SaCheckPermission("system:qualificationCatalog:export")
    @Log(title = "医生手术授权目录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQualificationCatalogBo bo, HttpServletResponse response) {
        List<MmpQualificationCatalogVo> list = mmpQualificationCatalogService.queryList(bo);
        ExcelUtil.exportExcel(list, "医生手术授权目录", MmpQualificationCatalogVo.class, response);
    }

    /**
     * 获取医生手术授权目录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:qualificationCatalog:query")
    @GetMapping("/{id}")
    public R<MmpQualificationCatalogVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQualificationCatalogService.queryById(id));
    }

    /**
     * 新增医生手术授权目录
     */
    @SaCheckPermission("system:qualificationCatalog:add")
    @Log(title = "医生手术授权目录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQualificationCatalogBo bo) {
        return toAjax(mmpQualificationCatalogService.insertByBo(bo));
    }

    /**
     * 修改医生手术授权目录
     */
    @SaCheckPermission("system:qualificationCatalog:edit")
    @Log(title = "医生手术授权目录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQualificationCatalogBo bo) {
        return toAjax(mmpQualificationCatalogService.updateByBo(bo));
    }

    /**
     * 删除医生手术授权目录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:qualificationCatalog:remove")
    @Log(title = "医生手术授权目录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQualificationCatalogService.deleteWithValidByIds(List.of(ids), true));
    }
}
