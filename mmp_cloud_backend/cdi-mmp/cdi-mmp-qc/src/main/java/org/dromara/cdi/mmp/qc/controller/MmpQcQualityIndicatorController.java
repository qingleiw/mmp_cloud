package org.dromara.cdi.mmp.qc.controller;

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
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcQualityIndicatorVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcQualityIndicatorBo;
import org.dromara.cdi.mmp.qc.service.IMmpQcQualityIndicatorService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 质量指标
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/qcQualityIndicator")
public class MmpQcQualityIndicatorController extends BaseController {

    private final IMmpQcQualityIndicatorService mmpQcQualityIndicatorService;

    /**
     * 查询质量指标列表
     */
    @SaCheckPermission("system:qcQualityIndicator:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQcQualityIndicatorVo> list(MmpQcQualityIndicatorBo bo, PageQuery pageQuery) {
        return mmpQcQualityIndicatorService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出质量指标列表
     */
    @SaCheckPermission("system:qcQualityIndicator:export")
    @Log(title = "质量指标", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQcQualityIndicatorBo bo, HttpServletResponse response) {
        List<MmpQcQualityIndicatorVo> list = mmpQcQualityIndicatorService.queryList(bo);
        ExcelUtil.exportExcel(list, "质量指标", MmpQcQualityIndicatorVo.class, response);
    }

    /**
     * 获取质量指标详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:qcQualityIndicator:query")
    @GetMapping("/{id}")
    public R<MmpQcQualityIndicatorVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQcQualityIndicatorService.queryById(id));
    }

    /**
     * 新增质量指标
     */
    @SaCheckPermission("system:qcQualityIndicator:add")
    @Log(title = "质量指标", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQcQualityIndicatorBo bo) {
        return toAjax(mmpQcQualityIndicatorService.insertByBo(bo));
    }

    /**
     * 修改质量指标
     */
    @SaCheckPermission("system:qcQualityIndicator:edit")
    @Log(title = "质量指标", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQcQualityIndicatorBo bo) {
        return toAjax(mmpQcQualityIndicatorService.updateByBo(bo));
    }

    /**
     * 删除质量指标
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:qcQualityIndicator:remove")
    @Log(title = "质量指标", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQcQualityIndicatorService.deleteWithValidByIds(List.of(ids), true));
    }
}
