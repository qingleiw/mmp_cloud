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
import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerCriticalPatientVo;
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerCriticalPatientBo;
import org.dromara.cdi.mmp.ledger.service.IMmpLedgerCriticalPatientService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 危重病人抢救登记本
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/ledgerCriticalPatient")
public class MmpLedgerCriticalPatientController extends BaseController {

    private final IMmpLedgerCriticalPatientService mmpLedgerCriticalPatientService;

    /**
     * 查询危重病人抢救登记本列表
     */
    @SaCheckPermission("ledger:ledgerCriticalPatient:list")
    @GetMapping("/list")
    public TableDataInfo<MmpLedgerCriticalPatientVo> list(MmpLedgerCriticalPatientBo bo, PageQuery pageQuery) {
        return mmpLedgerCriticalPatientService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出危重病人抢救登记本列表
     */
    @SaCheckPermission("ledger:ledgerCriticalPatient:export")
    @Log(title = "危重病人抢救登记本", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpLedgerCriticalPatientBo bo, HttpServletResponse response) {
        List<MmpLedgerCriticalPatientVo> list = mmpLedgerCriticalPatientService.queryList(bo);
        ExcelUtil.exportExcel(list, "危重病人抢救登记本", MmpLedgerCriticalPatientVo.class, response);
    }

    /**
     * 获取危重病人抢救登记本详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("ledger:ledgerCriticalPatient:query")
    @GetMapping("/{id}")
    public R<MmpLedgerCriticalPatientVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpLedgerCriticalPatientService.queryById(id));
    }

    /**
     * 新增危重病人抢救登记本
     */
    @SaCheckPermission("ledger:ledgerCriticalPatient:add")
    @Log(title = "危重病人抢救登记本", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpLedgerCriticalPatientBo bo) {
        return toAjax(mmpLedgerCriticalPatientService.insertByBo(bo));
    }

    /**
     * 修改危重病人抢救登记本
     */
    @SaCheckPermission("ledger:ledgerCriticalPatient:edit")
    @Log(title = "危重病人抢救登记本", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpLedgerCriticalPatientBo bo) {
        return toAjax(mmpLedgerCriticalPatientService.updateByBo(bo));
    }

    /**
     * 删除危重病人抢救登记本
     *
     * @param ids 主键串
     */
    @SaCheckPermission("ledger:ledgerCriticalPatient:remove")
    @Log(title = "危重病人抢救登记本", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpLedgerCriticalPatientService.deleteWithValidByIds(List.of(ids), true));
    }
}
