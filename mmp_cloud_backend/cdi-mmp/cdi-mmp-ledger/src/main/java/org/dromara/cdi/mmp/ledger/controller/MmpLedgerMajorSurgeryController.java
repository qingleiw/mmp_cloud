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
import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerMajorSurgeryVo;
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerMajorSurgeryBo;
import org.dromara.cdi.mmp.ledger.service.IMmpLedgerMajorSurgeryService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 重大疑难手术监测与管理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/ledgerMajorSurgery")
public class MmpLedgerMajorSurgeryController extends BaseController {

    private final IMmpLedgerMajorSurgeryService mmpLedgerMajorSurgeryService;

    /**
     * 查询重大疑难手术监测与管理列表
     */
    @SaCheckPermission("ledger:ledgerMajorSurgery:list")
    @GetMapping("/list")
    public TableDataInfo<MmpLedgerMajorSurgeryVo> list(MmpLedgerMajorSurgeryBo bo, PageQuery pageQuery) {
        return mmpLedgerMajorSurgeryService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出重大疑难手术监测与管理列表
     */
    @SaCheckPermission("ledger:ledgerMajorSurgery:export")
    @Log(title = "重大疑难手术监测与管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpLedgerMajorSurgeryBo bo, HttpServletResponse response) {
        List<MmpLedgerMajorSurgeryVo> list = mmpLedgerMajorSurgeryService.queryList(bo);
        ExcelUtil.exportExcel(list, "重大疑难手术监测与管理", MmpLedgerMajorSurgeryVo.class, response);
    }

    /**
     * 获取重大疑难手术监测与管理详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("ledger:ledgerMajorSurgery:query")
    @GetMapping("/{id}")
    public R<MmpLedgerMajorSurgeryVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpLedgerMajorSurgeryService.queryById(id));
    }

    /**
     * 新增重大疑难手术监测与管理
     */
    @SaCheckPermission("ledger:ledgerMajorSurgery:add")
    @Log(title = "重大疑难手术监测与管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpLedgerMajorSurgeryBo bo) {
        return toAjax(mmpLedgerMajorSurgeryService.insertByBo(bo));
    }

    /**
     * 修改重大疑难手术监测与管理
     */
    @SaCheckPermission("ledger:ledgerMajorSurgery:edit")
    @Log(title = "重大疑难手术监测与管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpLedgerMajorSurgeryBo bo) {
        return toAjax(mmpLedgerMajorSurgeryService.updateByBo(bo));
    }

    /**
     * 删除重大疑难手术监测与管理
     *
     * @param ids 主键串
     */
    @SaCheckPermission("ledger:ledgerMajorSurgery:remove")
    @Log(title = "重大疑难手术监测与管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpLedgerMajorSurgeryService.deleteWithValidByIds(List.of(ids), true));
    }
}
