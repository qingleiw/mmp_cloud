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
import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerLongStayPatientVo;
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerLongStayPatientBo;
import org.dromara.cdi.mmp.ledger.service.IMmpLedgerLongStayPatientService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 住院超30天患者登记本
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/ledgerLongStayPatient")
public class MmpLedgerLongStayPatientController extends BaseController {

    private final IMmpLedgerLongStayPatientService mmpLedgerLongStayPatientService;

    /**
     * 查询住院超30天患者登记本列表
     */
    @SaCheckPermission("ledger:ledgerLongStayPatient:list")
    @GetMapping("/list")
    public TableDataInfo<MmpLedgerLongStayPatientVo> list(MmpLedgerLongStayPatientBo bo, PageQuery pageQuery) {
        return mmpLedgerLongStayPatientService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出住院超30天患者登记本列表
     */
    @SaCheckPermission("ledger:ledgerLongStayPatient:export")
    @Log(title = "住院超30天患者登记本", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpLedgerLongStayPatientBo bo, HttpServletResponse response) {
        List<MmpLedgerLongStayPatientVo> list = mmpLedgerLongStayPatientService.queryList(bo);
        ExcelUtil.exportExcel(list, "住院超30天患者登记本", MmpLedgerLongStayPatientVo.class, response);
    }

    /**
     * 获取住院超30天患者登记本详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("ledger:ledgerLongStayPatient:query")
    @GetMapping("/{id}")
    public R<MmpLedgerLongStayPatientVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpLedgerLongStayPatientService.queryById(id));
    }

    /**
     * 新增住院超30天患者登记本
     */
    @SaCheckPermission("ledger:ledgerLongStayPatient:add")
    @Log(title = "住院超30天患者登记本", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpLedgerLongStayPatientBo bo) {
        return toAjax(mmpLedgerLongStayPatientService.insertByBo(bo));
    }

    /**
     * 修改住院超30天患者登记本
     */
    @SaCheckPermission("ledger:ledgerLongStayPatient:edit")
    @Log(title = "住院超30天患者登记本", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpLedgerLongStayPatientBo bo) {
        return toAjax(mmpLedgerLongStayPatientService.updateByBo(bo));
    }

    /**
     * 删除住院超30天患者登记本
     *
     * @param ids 主键串
     */
    @SaCheckPermission("ledger:ledgerLongStayPatient:remove")
    @Log(title = "住院超30天患者登记本", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpLedgerLongStayPatientService.deleteWithValidByIds(List.of(ids), true));
    }
}
