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
import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerBusinessLearningVo;
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerBusinessLearningBo;
import org.dromara.cdi.mmp.ledger.service.IMmpLedgerBusinessLearningService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 业务学习记录本
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/ledgerBusinessLearning")
public class MmpLedgerBusinessLearningController extends BaseController {

    private final IMmpLedgerBusinessLearningService mmpLedgerBusinessLearningService;

    /**
     * 查询业务学习记录本列表
     */
    @SaCheckPermission("ledger:ledgerBusinessLearning:list")
    @GetMapping("/list")
    public TableDataInfo<MmpLedgerBusinessLearningVo> list(MmpLedgerBusinessLearningBo bo, PageQuery pageQuery) {
        return mmpLedgerBusinessLearningService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出业务学习记录本列表
     */
    @SaCheckPermission("ledger:ledgerBusinessLearning:export")
    @Log(title = "业务学习记录本", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpLedgerBusinessLearningBo bo, HttpServletResponse response) {
        List<MmpLedgerBusinessLearningVo> list = mmpLedgerBusinessLearningService.queryList(bo);
        ExcelUtil.exportExcel(list, "业务学习记录本", MmpLedgerBusinessLearningVo.class, response);
    }

    /**
     * 获取业务学习记录本详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("ledger:ledgerBusinessLearning:query")
    @GetMapping("/{id}")
    public R<MmpLedgerBusinessLearningVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpLedgerBusinessLearningService.queryById(id));
    }

    /**
     * 新增业务学习记录本
     */
    @SaCheckPermission("ledger:ledgerBusinessLearning:add")
    @Log(title = "业务学习记录本", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpLedgerBusinessLearningBo bo) {
        return toAjax(mmpLedgerBusinessLearningService.insertByBo(bo));
    }

    /**
     * 修改业务学习记录本
     */
    @SaCheckPermission("ledger:ledgerBusinessLearning:edit")
    @Log(title = "业务学习记录本", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpLedgerBusinessLearningBo bo) {
        return toAjax(mmpLedgerBusinessLearningService.updateByBo(bo));
    }

    /**
     * 删除业务学习记录本
     *
     * @param ids 主键串
     */
    @SaCheckPermission("ledger:ledgerBusinessLearning:remove")
    @Log(title = "业务学习记录本", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpLedgerBusinessLearningService.deleteWithValidByIds(List.of(ids), true));
    }
}
