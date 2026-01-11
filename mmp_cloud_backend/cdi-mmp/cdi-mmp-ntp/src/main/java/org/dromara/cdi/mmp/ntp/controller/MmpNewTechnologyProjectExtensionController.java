package org.dromara.cdi.mmp.ntp.controller;

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
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectExtensionVo;
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectExtensionBo;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectExtensionService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 新技术延期申请
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/newTechnologyProjectExtension")
public class MmpNewTechnologyProjectExtensionController extends BaseController {

    private final IMmpNewTechnologyProjectExtensionService mmpNewTechnologyProjectExtensionService;

    /**
     * 查询新技术延期申请列表
     */
    @SaCheckPermission("system:newTechnologyProjectExtension:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNewTechnologyProjectExtensionVo> list(MmpNewTechnologyProjectExtensionBo bo, PageQuery pageQuery) {
        return mmpNewTechnologyProjectExtensionService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出新技术延期申请列表
     */
    @SaCheckPermission("system:newTechnologyProjectExtension:export")
    @Log(title = "新技术延期申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNewTechnologyProjectExtensionBo bo, HttpServletResponse response) {
        List<MmpNewTechnologyProjectExtensionVo> list = mmpNewTechnologyProjectExtensionService.queryList(bo);
        ExcelUtil.exportExcel(list, "新技术延期申请", MmpNewTechnologyProjectExtensionVo.class, response);
    }

    /**
     * 获取新技术延期申请详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:newTechnologyProjectExtension:query")
    @GetMapping("/{id}")
    public R<MmpNewTechnologyProjectExtensionVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpNewTechnologyProjectExtensionService.queryById(id));
    }

    /**
     * 新增新技术延期申请
     */
    @SaCheckPermission("system:newTechnologyProjectExtension:add")
    @Log(title = "新技术延期申请", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNewTechnologyProjectExtensionBo bo) {
        return toAjax(mmpNewTechnologyProjectExtensionService.insertByBo(bo));
    }

    /**
     * 修改新技术延期申请
     */
    @SaCheckPermission("system:newTechnologyProjectExtension:edit")
    @Log(title = "新技术延期申请", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNewTechnologyProjectExtensionBo bo) {
        return toAjax(mmpNewTechnologyProjectExtensionService.updateByBo(bo));
    }

    /**
     * 删除新技术延期申请
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:newTechnologyProjectExtension:remove")
    @Log(title = "新技术延期申请", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpNewTechnologyProjectExtensionService.deleteWithValidByIds(List.of(ids), true));
    }
}
