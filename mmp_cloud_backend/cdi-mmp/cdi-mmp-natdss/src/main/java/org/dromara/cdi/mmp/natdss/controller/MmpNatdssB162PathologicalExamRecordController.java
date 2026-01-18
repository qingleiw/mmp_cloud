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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB162PathologicalExamRecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB162PathologicalExamRecordBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB162PathologicalExamRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B162 病理检查记录
 * 前端访问路由地址为:/natdss/natdssB162PathologicalExamRecord
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB162PathologicalExamRecord")
public class MmpNatdssB162PathologicalExamRecordController extends BaseController {

    private final IMmpNatdssB162PathologicalExamRecordService mmpNatdssB162PathologicalExamRecordService;

    /**
     * 查询B162 病理检查记录列表
     */
    @SaCheckPermission("natdss:natdssB162PathologicalExamRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB162PathologicalExamRecordVo> list(MmpNatdssB162PathologicalExamRecordBo bo, PageQuery pageQuery) {
        return mmpNatdssB162PathologicalExamRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B162 病理检查记录列表
     */
    @SaCheckPermission("natdss:natdssB162PathologicalExamRecord:export")
    @Log(title = "B162 病理检查记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB162PathologicalExamRecordBo bo, HttpServletResponse response) {
        List<MmpNatdssB162PathologicalExamRecordVo> list = mmpNatdssB162PathologicalExamRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "B162 病理检查记录", MmpNatdssB162PathologicalExamRecordVo.class, response);
    }

    /**
     * 获取B162 病理检查记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB162PathologicalExamRecord:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB162PathologicalExamRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB162PathologicalExamRecordService.queryById(id));
    }

    /**
     * 新增B162 病理检查记录
     */
    @SaCheckPermission("natdss:natdssB162PathologicalExamRecord:add")
    @Log(title = "B162 病理检查记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB162PathologicalExamRecordBo bo) {
        return toAjax(mmpNatdssB162PathologicalExamRecordService.insertByBo(bo));
    }

    /**
     * 修改B162 病理检查记录
     */
    @SaCheckPermission("natdss:natdssB162PathologicalExamRecord:edit")
    @Log(title = "B162 病理检查记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB162PathologicalExamRecordBo bo) {
        return toAjax(mmpNatdssB162PathologicalExamRecordService.updateByBo(bo));
    }

    /**
     * 删除B162 病理检查记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB162PathologicalExamRecord:remove")
    @Log(title = "B162 病理检查记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB162PathologicalExamRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
