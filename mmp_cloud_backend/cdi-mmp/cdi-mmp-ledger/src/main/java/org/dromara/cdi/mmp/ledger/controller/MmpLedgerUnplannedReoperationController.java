package org.dromara.cdi.mmp.ledger.controller;

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
import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerUnplannedReoperationVo;
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerUnplannedReoperationBo;
import org.dromara.cdi.mmp.ledger.service.IMmpLedgerUnplannedReoperationService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 非计划再次手术登记本
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/ledgerUnplannedReoperation")
public class MmpLedgerUnplannedReoperationController extends BaseController {

    private final IMmpLedgerUnplannedReoperationService mmpLedgerUnplannedReoperationService;

    /**
     * 查询非计划再次手术登记本列表
     */
    @SaCheckPermission("ledger:ledgerUnplannedReoperation:list")
    @GetMapping("/list")
    public TableDataInfo<MmpLedgerUnplannedReoperationVo> list(MmpLedgerUnplannedReoperationBo bo, PageQuery pageQuery) {
        return mmpLedgerUnplannedReoperationService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出非计划再次手术登记本列表
     */
    @SaCheckPermission("ledger:ledgerUnplannedReoperation:export")
    @Log(title = "非计划再次手术登记本", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpLedgerUnplannedReoperationBo bo, HttpServletResponse response) {
        List<MmpLedgerUnplannedReoperationVo> list = mmpLedgerUnplannedReoperationService.queryList(bo);
        ExcelUtil.exportExcel(list, "非计划再次手术登记本", MmpLedgerUnplannedReoperationVo.class, response);
    }

    /**
     * 获取非计划再次手术登记本详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("ledger:ledgerUnplannedReoperation:query")
    @GetMapping("/{id}")
    public R<MmpLedgerUnplannedReoperationVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpLedgerUnplannedReoperationService.queryById(id));
    }

    /**
     * 新增非计划再次手术登记本
     */
    @SaCheckPermission("ledger:ledgerUnplannedReoperation:add")
    @Log(title = "非计划再次手术登记本", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpLedgerUnplannedReoperationBo bo) {
        return toAjax(mmpLedgerUnplannedReoperationService.insertByBo(bo));
    }

    /**
     * 修改非计划再次手术登记本
     */
    @SaCheckPermission("ledger:ledgerUnplannedReoperation:edit")
    @Log(title = "非计划再次手术登记本", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpLedgerUnplannedReoperationBo bo) {
        return toAjax(mmpLedgerUnplannedReoperationService.updateByBo(bo));
    }

    /**
     * 删除非计划再次手术登记本
     *
     * @param ids 主键串
     */
    @SaCheckPermission("ledger:ledgerUnplannedReoperation:remove")
    @Log(title = "非计划再次手术登记本", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpLedgerUnplannedReoperationService.deleteWithValidByIds(List.of(ids), true));
    }
}
