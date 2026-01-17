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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB16-2PathologicalExamRecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB16-2PathologicalExamRecordBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB16-2PathologicalExamRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B16-2 病理检查记录
 * 前端访问路由地址为:/natdss/natdssB16-2PathologicalExamRecord
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB16-2PathologicalExamRecord")
public class MmpNatdssB16-2PathologicalExamRecordController extends BaseController {

    private final IMmpNatdssB16-2PathologicalExamRecordService mmpNatdssB16-2PathologicalExamRecordService;

    /**
     * 查询B16-2 病理检查记录列表
     */
    @SaCheckPermission("natdss:natdssB16-2PathologicalExamRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB16-2PathologicalExamRecordVo> list(MmpNatdssB16-2PathologicalExamRecordBo bo, PageQuery pageQuery) {
        return mmpNatdssB16-2PathologicalExamRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B16-2 病理检查记录列表
     */
    @SaCheckPermission("natdss:natdssB16-2PathologicalExamRecord:export")
    @Log(title = "B16-2 病理检查记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB16-2PathologicalExamRecordBo bo, HttpServletResponse response) {
        List<MmpNatdssB16-2PathologicalExamRecordVo> list = mmpNatdssB16-2PathologicalExamRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "B16-2 病理检查记录", MmpNatdssB16-2PathologicalExamRecordVo.class, response);
    }

    /**
     * 获取B16-2 病理检查记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB16-2PathologicalExamRecord:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB16-2PathologicalExamRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB16-2PathologicalExamRecordService.queryById(id));
    }

    /**
     * 新增B16-2 病理检查记录
     */
    @SaCheckPermission("natdss:natdssB16-2PathologicalExamRecord:add")
    @Log(title = "B16-2 病理检查记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB16-2PathologicalExamRecordBo bo) {
        return toAjax(mmpNatdssB16-2PathologicalExamRecordService.insertByBo(bo));
    }

    /**
     * 修改B16-2 病理检查记录
     */
    @SaCheckPermission("natdss:natdssB16-2PathologicalExamRecord:edit")
    @Log(title = "B16-2 病理检查记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB16-2PathologicalExamRecordBo bo) {
        return toAjax(mmpNatdssB16-2PathologicalExamRecordService.updateByBo(bo));
    }

    /**
     * 删除B16-2 病理检查记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB16-2PathologicalExamRecord:remove")
    @Log(title = "B16-2 病理检查记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB16-2PathologicalExamRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
