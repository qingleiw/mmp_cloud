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
import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerPatientFullCycleVo;
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerPatientFullCycleBo;
import org.dromara.cdi.mmp.ledger.service.IMmpLedgerPatientFullCycleService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 患者医疗全周期信息管理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/ledgerPatientFullCycle")
public class MmpLedgerPatientFullCycleController extends BaseController {

    private final IMmpLedgerPatientFullCycleService mmpLedgerPatientFullCycleService;

    /**
     * 查询患者医疗全周期信息管理列表
     */
    @SaCheckPermission("ledger:ledgerPatientFullCycle:list")
    @GetMapping("/list")
    public TableDataInfo<MmpLedgerPatientFullCycleVo> list(MmpLedgerPatientFullCycleBo bo, PageQuery pageQuery) {
        return mmpLedgerPatientFullCycleService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出患者医疗全周期信息管理列表
     */
    @SaCheckPermission("ledger:ledgerPatientFullCycle:export")
    @Log(title = "患者医疗全周期信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpLedgerPatientFullCycleBo bo, HttpServletResponse response) {
        List<MmpLedgerPatientFullCycleVo> list = mmpLedgerPatientFullCycleService.queryList(bo);
        ExcelUtil.exportExcel(list, "患者医疗全周期信息管理", MmpLedgerPatientFullCycleVo.class, response);
    }

    /**
     * 获取患者医疗全周期信息管理详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("ledger:ledgerPatientFullCycle:query")
    @GetMapping("/{id}")
    public R<MmpLedgerPatientFullCycleVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpLedgerPatientFullCycleService.queryById(id));
    }

    /**
     * 新增患者医疗全周期信息管理
     */
    @SaCheckPermission("ledger:ledgerPatientFullCycle:add")
    @Log(title = "患者医疗全周期信息管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpLedgerPatientFullCycleBo bo) {
        return toAjax(mmpLedgerPatientFullCycleService.insertByBo(bo));
    }

    /**
     * 修改患者医疗全周期信息管理
     */
    @SaCheckPermission("ledger:ledgerPatientFullCycle:edit")
    @Log(title = "患者医疗全周期信息管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpLedgerPatientFullCycleBo bo) {
        return toAjax(mmpLedgerPatientFullCycleService.updateByBo(bo));
    }

    /**
     * 删除患者医疗全周期信息管理
     *
     * @param ids 主键串
     */
    @SaCheckPermission("ledger:ledgerPatientFullCycle:remove")
    @Log(title = "患者医疗全周期信息管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpLedgerPatientFullCycleService.deleteWithValidByIds(List.of(ids), true));
    }
}
