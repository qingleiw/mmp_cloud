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
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectDocumentVo;
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectDocumentBo;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectDocumentService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 项目文档
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/newTechnologyProjectDocument")
public class MmpNewTechnologyProjectDocumentController extends BaseController {

    private final IMmpNewTechnologyProjectDocumentService mmpNewTechnologyProjectDocumentService;

    /**
     * 查询项目文档列表
     */
    @SaCheckPermission("system:newTechnologyProjectDocument:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNewTechnologyProjectDocumentVo> list(MmpNewTechnologyProjectDocumentBo bo, PageQuery pageQuery) {
        return mmpNewTechnologyProjectDocumentService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出项目文档列表
     */
    @SaCheckPermission("system:newTechnologyProjectDocument:export")
    @Log(title = "项目文档", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNewTechnologyProjectDocumentBo bo, HttpServletResponse response) {
        List<MmpNewTechnologyProjectDocumentVo> list = mmpNewTechnologyProjectDocumentService.queryList(bo);
        ExcelUtil.exportExcel(list, "项目文档", MmpNewTechnologyProjectDocumentVo.class, response);
    }

    /**
     * 获取项目文档详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:newTechnologyProjectDocument:query")
    @GetMapping("/{id}")
    public R<MmpNewTechnologyProjectDocumentVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpNewTechnologyProjectDocumentService.queryById(id));
    }

    /**
     * 新增项目文档
     */
    @SaCheckPermission("system:newTechnologyProjectDocument:add")
    @Log(title = "项目文档", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNewTechnologyProjectDocumentBo bo) {
        return toAjax(mmpNewTechnologyProjectDocumentService.insertByBo(bo));
    }

    /**
     * 修改项目文档
     */
    @SaCheckPermission("system:newTechnologyProjectDocument:edit")
    @Log(title = "项目文档", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNewTechnologyProjectDocumentBo bo) {
        return toAjax(mmpNewTechnologyProjectDocumentService.updateByBo(bo));
    }

    /**
     * 删除项目文档
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:newTechnologyProjectDocument:remove")
    @Log(title = "项目文档", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpNewTechnologyProjectDocumentService.deleteWithValidByIds(List.of(ids), true));
    }
}
