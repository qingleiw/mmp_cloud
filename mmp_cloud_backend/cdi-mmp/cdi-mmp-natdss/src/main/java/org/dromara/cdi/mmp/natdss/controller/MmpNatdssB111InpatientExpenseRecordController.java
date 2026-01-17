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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB111InpatientExpenseRecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB111InpatientExpenseRecordBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB111InpatientExpenseRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B11-1 住院收费记录
 * 前端访问路由地址为:/natdss/natdssB111InpatientExpenseRecord
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB111InpatientExpenseRecord")
public class MmpNatdssB111InpatientExpenseRecordController extends BaseController {

    private final IMmpNatdssB111InpatientExpenseRecordService mmpNatdssB111InpatientExpenseRecordService;

    /**
     * 查询B11-1 住院收费记录列表
     */
    @SaCheckPermission("natdss:natdssB111InpatientExpenseRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB111InpatientExpenseRecordVo> list(MmpNatdssB111InpatientExpenseRecordBo bo, PageQuery pageQuery) {
        return mmpNatdssB111InpatientExpenseRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B11-1 住院收费记录列表
     */
    @SaCheckPermission("natdss:natdssB111InpatientExpenseRecord:export")
    @Log(title = "B11-1 住院收费记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB111InpatientExpenseRecordBo bo, HttpServletResponse response) {
        List<MmpNatdssB111InpatientExpenseRecordVo> list = mmpNatdssB111InpatientExpenseRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "B11-1 住院收费记录", MmpNatdssB111InpatientExpenseRecordVo.class, response);
    }

    /**
     * 获取B11-1 住院收费记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB111InpatientExpenseRecord:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB111InpatientExpenseRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB111InpatientExpenseRecordService.queryById(id));
    }

    /**
     * 新增B11-1 住院收费记录
     */
    @SaCheckPermission("natdss:natdssB111InpatientExpenseRecord:add")
    @Log(title = "B11-1 住院收费记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB111InpatientExpenseRecordBo bo) {
        return toAjax(mmpNatdssB111InpatientExpenseRecordService.insertByBo(bo));
    }

    /**
     * 修改B11-1 住院收费记录
     */
    @SaCheckPermission("natdss:natdssB111InpatientExpenseRecord:edit")
    @Log(title = "B11-1 住院收费记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB111InpatientExpenseRecordBo bo) {
        return toAjax(mmpNatdssB111InpatientExpenseRecordService.updateByBo(bo));
    }

    /**
     * 删除B11-1 住院收费记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB111InpatientExpenseRecord:remove")
    @Log(title = "B11-1 住院收费记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB111InpatientExpenseRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
