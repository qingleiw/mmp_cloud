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
import org.dromara.cdi.mmp.ledger.domain.vo.MmpMedicalStatsVo;
import org.dromara.cdi.mmp.ledger.domain.bo.MmpMedicalStatsBo;
import org.dromara.cdi.mmp.ledger.service.IMmpMedicalStatsService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 医疗质量统计数据
 *
 * @author Lion Li
 * @date 2025-12-27
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/medicalStats")
public class MmpMedicalStatsController extends BaseController {

    private final IMmpMedicalStatsService mmpMedicalStatsService;

    /**
     * 查询医疗质量统计数据列表
     */
    @SaCheckPermission("ledger:medicalStats:list")
    @GetMapping("/list")
    public TableDataInfo<MmpMedicalStatsVo> list(MmpMedicalStatsBo bo, PageQuery pageQuery) {
        return mmpMedicalStatsService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出医疗质量统计数据列表
     */
    @SaCheckPermission("ledger:medicalStats:export")
    @Log(title = "医疗质量统计数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpMedicalStatsBo bo, HttpServletResponse response) {
        List<MmpMedicalStatsVo> list = mmpMedicalStatsService.queryList(bo);
        ExcelUtil.exportExcel(list, "医疗质量统计数据", MmpMedicalStatsVo.class, response);
    }

    /**
     * 获取医疗质量统计数据详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("ledger:medicalStats:query")
    @GetMapping("/{id}")
    public R<MmpMedicalStatsVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpMedicalStatsService.queryById(id));
    }

    /**
     * 新增医疗质量统计数据
     */
    @SaCheckPermission("ledger:medicalStats:add")
    @Log(title = "医疗质量统计数据", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpMedicalStatsBo bo) {
        return toAjax(mmpMedicalStatsService.insertByBo(bo));
    }

    /**
     * 修改医疗质量统计数据
     */
    @SaCheckPermission("ledger:medicalStats:edit")
    @Log(title = "医疗质量统计数据", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpMedicalStatsBo bo) {
        return toAjax(mmpMedicalStatsService.updateByBo(bo));
    }

    /**
     * 删除医疗质量统计数据
     *
     * @param ids 主键串
     */
    @SaCheckPermission("ledger:medicalStats:remove")
    @Log(title = "医疗质量统计数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpMedicalStatsService.deleteWithValidByIds(List.of(ids), true));
    }
}
