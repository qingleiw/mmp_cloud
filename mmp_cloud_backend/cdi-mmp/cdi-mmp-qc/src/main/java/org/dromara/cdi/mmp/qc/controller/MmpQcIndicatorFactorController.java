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
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcIndicatorFactorVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcIndicatorFactorBo;
import org.dromara.cdi.mmp.qc.service.IMmpQcIndicatorFactorService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 指标计算因子
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/qcIndicatorFactor")
public class MmpQcIndicatorFactorController extends BaseController {

    private final IMmpQcIndicatorFactorService mmpQcIndicatorFactorService;

    /**
     * 查询指标计算因子列表
     */
    @SaCheckPermission("qc:qcIndicatorFactor:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQcIndicatorFactorVo> list(MmpQcIndicatorFactorBo bo, PageQuery pageQuery) {
        return mmpQcIndicatorFactorService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出指标计算因子列表
     */
    @SaCheckPermission("qc:qcIndicatorFactor:export")
    @Log(title = "指标计算因子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQcIndicatorFactorBo bo, HttpServletResponse response) {
        List<MmpQcIndicatorFactorVo> list = mmpQcIndicatorFactorService.queryList(bo);
        ExcelUtil.exportExcel(list, "指标计算因子", MmpQcIndicatorFactorVo.class, response);
    }

    /**
     * 获取指标计算因子详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("qc:qcIndicatorFactor:query")
    @GetMapping("/{id}")
    public R<MmpQcIndicatorFactorVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQcIndicatorFactorService.queryById(id));
    }

    /**
     * 新增指标计算因子
     */
    @SaCheckPermission("qc:qcIndicatorFactor:add")
    @Log(title = "指标计算因子", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQcIndicatorFactorBo bo) {
        return toAjax(mmpQcIndicatorFactorService.insertByBo(bo));
    }

    /**
     * 修改指标计算因子
     */
    @SaCheckPermission("qc:qcIndicatorFactor:edit")
    @Log(title = "指标计算因子", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQcIndicatorFactorBo bo) {
        return toAjax(mmpQcIndicatorFactorService.updateByBo(bo));
    }

    /**
     * 删除指标计算因子
     *
     * @param ids 主键串
     */
    @SaCheckPermission("qc:qcIndicatorFactor:remove")
    @Log(title = "指标计算因子", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQcIndicatorFactorService.deleteWithValidByIds(List.of(ids), true));
    }
}
