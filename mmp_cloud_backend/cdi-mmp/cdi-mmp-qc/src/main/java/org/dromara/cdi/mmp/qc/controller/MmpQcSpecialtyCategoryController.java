package org.dromara.cdi.mmp.qc.controller;

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
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcSpecialtyCategoryVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcSpecialtyCategoryBo;
import org.dromara.cdi.mmp.qc.service.IMmpQcSpecialtyCategoryService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 专业类别
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/qcSpecialtyCategory")
public class MmpQcSpecialtyCategoryController extends BaseController {

    private final IMmpQcSpecialtyCategoryService mmpQcSpecialtyCategoryService;

    /**
     * 查询专业类别列表
     */
    @SaCheckPermission("system:qcSpecialtyCategory:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQcSpecialtyCategoryVo> list(MmpQcSpecialtyCategoryBo bo, PageQuery pageQuery) {
        return mmpQcSpecialtyCategoryService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出专业类别列表
     */
    @SaCheckPermission("system:qcSpecialtyCategory:export")
    @Log(title = "专业类别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQcSpecialtyCategoryBo bo, HttpServletResponse response) {
        List<MmpQcSpecialtyCategoryVo> list = mmpQcSpecialtyCategoryService.queryList(bo);
        ExcelUtil.exportExcel(list, "专业类别", MmpQcSpecialtyCategoryVo.class, response);
    }

    /**
     * 获取专业类别详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:qcSpecialtyCategory:query")
    @GetMapping("/{id}")
    public R<MmpQcSpecialtyCategoryVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQcSpecialtyCategoryService.queryById(id));
    }

    /**
     * 新增专业类别
     */
    @SaCheckPermission("system:qcSpecialtyCategory:add")
    @Log(title = "专业类别", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQcSpecialtyCategoryBo bo) {
        return toAjax(mmpQcSpecialtyCategoryService.insertByBo(bo));
    }

    /**
     * 修改专业类别
     */
    @SaCheckPermission("system:qcSpecialtyCategory:edit")
    @Log(title = "专业类别", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQcSpecialtyCategoryBo bo) {
        return toAjax(mmpQcSpecialtyCategoryService.updateByBo(bo));
    }

    /**
     * 删除专业类别
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:qcSpecialtyCategory:remove")
    @Log(title = "专业类别", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQcSpecialtyCategoryService.deleteWithValidByIds(List.of(ids), true));
    }
}
