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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB151OutpatientExpenseRecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB151OutpatientExpenseRecordBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB151OutpatientExpenseRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B15-1 门诊收费记录
 * 前端访问路由地址为:/natdss/natdssB151OutpatientExpenseRecord
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB151OutpatientExpenseRecord")
public class MmpNatdssB151OutpatientExpenseRecordController extends BaseController {

    private final IMmpNatdssB151OutpatientExpenseRecordService mmpNatdssB151OutpatientExpenseRecordService;

    /**
     * 查询B15-1 门诊收费记录列表
     */
    @SaCheckPermission("natdss:natdssB151OutpatientExpenseRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB151OutpatientExpenseRecordVo> list(MmpNatdssB151OutpatientExpenseRecordBo bo, PageQuery pageQuery) {
        return mmpNatdssB151OutpatientExpenseRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B15-1 门诊收费记录列表
     */
    @SaCheckPermission("natdss:natdssB151OutpatientExpenseRecord:export")
    @Log(title = "B15-1 门诊收费记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB151OutpatientExpenseRecordBo bo, HttpServletResponse response) {
        List<MmpNatdssB151OutpatientExpenseRecordVo> list = mmpNatdssB151OutpatientExpenseRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "B15-1 门诊收费记录", MmpNatdssB151OutpatientExpenseRecordVo.class, response);
    }

    /**
     * 获取B15-1 门诊收费记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB151OutpatientExpenseRecord:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB151OutpatientExpenseRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB151OutpatientExpenseRecordService.queryById(id));
    }

    /**
     * 新增B15-1 门诊收费记录
     */
    @SaCheckPermission("natdss:natdssB151OutpatientExpenseRecord:add")
    @Log(title = "B15-1 门诊收费记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB151OutpatientExpenseRecordBo bo) {
        return toAjax(mmpNatdssB151OutpatientExpenseRecordService.insertByBo(bo));
    }

    /**
     * 修改B15-1 门诊收费记录
     */
    @SaCheckPermission("natdss:natdssB151OutpatientExpenseRecord:edit")
    @Log(title = "B15-1 门诊收费记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB151OutpatientExpenseRecordBo bo) {
        return toAjax(mmpNatdssB151OutpatientExpenseRecordService.updateByBo(bo));
    }

    /**
     * 删除B15-1 门诊收费记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB151OutpatientExpenseRecord:remove")
    @Log(title = "B15-1 门诊收费记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB151OutpatientExpenseRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
