package org.dromara.cdi.mmp.doctor.controller;

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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorQualificationCatalogVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorQualificationCatalogBo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorQualificationCatalogService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 医师资质目录
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctorQualificationCatalog")
public class MmpDoctorQualificationCatalogController extends BaseController {

    private final IMmpDoctorQualificationCatalogService mmpDoctorQualificationCatalogService;

    /**
     * 查询医师资质目录列表
     */
    @SaCheckPermission("doctor:doctorQualificationCatalog:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorQualificationCatalogVo> list(MmpDoctorQualificationCatalogBo bo, PageQuery pageQuery) {
        return mmpDoctorQualificationCatalogService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出医师资质目录列表
     */
    @SaCheckPermission("doctor:doctorQualificationCatalog:export")
    @Log(title = "医师资质目录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorQualificationCatalogBo bo, HttpServletResponse response) {
        List<MmpDoctorQualificationCatalogVo> list = mmpDoctorQualificationCatalogService.queryList(bo);
        ExcelUtil.exportExcel(list, "医师资质目录", MmpDoctorQualificationCatalogVo.class, response);
    }

    /**
     * 获取医师资质目录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorQualificationCatalog:query")
    @GetMapping("/{id}")
    public R<MmpDoctorQualificationCatalogVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorQualificationCatalogService.queryById(id));
    }

    /**
     * 新增医师资质目录
     */
    @SaCheckPermission("doctor:doctorQualificationCatalog:add")
    @Log(title = "医师资质目录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorQualificationCatalogBo bo) {
        return toAjax(mmpDoctorQualificationCatalogService.insertByBo(bo));
    }

    /**
     * 修改医师资质目录
     */
    @SaCheckPermission("doctor:doctorQualificationCatalog:edit")
    @Log(title = "医师资质目录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorQualificationCatalogBo bo) {
        return toAjax(mmpDoctorQualificationCatalogService.updateByBo(bo));
    }

    /**
     * 删除医师资质目录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorQualificationCatalog:remove")
    @Log(title = "医师资质目录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorQualificationCatalogService.deleteWithValidByIds(List.of(ids), true));
    }
}
