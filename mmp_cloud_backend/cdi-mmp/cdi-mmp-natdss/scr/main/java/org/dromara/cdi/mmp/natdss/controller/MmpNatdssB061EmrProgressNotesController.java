package org.dromara.cdi.mmp.natdss.controller;

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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB061EmrProgressNotesVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB061EmrProgressNotesBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB061EmrProgressNotesService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B06-1 病程记录
 * 前端访问路由地址为:/natdss/natdssB061EmrProgressNotes
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB061EmrProgressNotes")
public class MmpNatdssB061EmrProgressNotesController extends BaseController {

    private final IMmpNatdssB061EmrProgressNotesService mmpNatdssB061EmrProgressNotesService;

    /**
     * 查询B06-1 病程记录列表
     */
    @SaCheckPermission("natdss:natdssB061EmrProgressNotes:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB061EmrProgressNotesVo> list(MmpNatdssB061EmrProgressNotesBo bo, PageQuery pageQuery) {
        return mmpNatdssB061EmrProgressNotesService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B06-1 病程记录列表
     */
    @SaCheckPermission("natdss:natdssB061EmrProgressNotes:export")
    @Log(title = "B06-1 病程记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB061EmrProgressNotesBo bo, HttpServletResponse response) {
        List<MmpNatdssB061EmrProgressNotesVo> list = mmpNatdssB061EmrProgressNotesService.queryList(bo);
        ExcelUtil.exportExcel(list, "B06-1 病程记录", MmpNatdssB061EmrProgressNotesVo.class, response);
    }

    /**
     * 获取B06-1 病程记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB061EmrProgressNotes:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB061EmrProgressNotesVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB061EmrProgressNotesService.queryById(id));
    }

    /**
     * 新增B06-1 病程记录
     */
    @SaCheckPermission("natdss:natdssB061EmrProgressNotes:add")
    @Log(title = "B06-1 病程记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB061EmrProgressNotesBo bo) {
        return toAjax(mmpNatdssB061EmrProgressNotesService.insertByBo(bo));
    }

    /**
     * 修改B06-1 病程记录
     */
    @SaCheckPermission("natdss:natdssB061EmrProgressNotes:edit")
    @Log(title = "B06-1 病程记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB061EmrProgressNotesBo bo) {
        return toAjax(mmpNatdssB061EmrProgressNotesService.updateByBo(bo));
    }

    /**
     * 删除B06-1 病程记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB061EmrProgressNotes:remove")
    @Log(title = "B06-1 病程记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB061EmrProgressNotesService.deleteWithValidByIds(List.of(ids), true));
    }
}
