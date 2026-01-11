package org.dromara.cdi.mmp.supervision.controller;

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
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionResultDetailVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionResultDetailBo;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionResultDetailService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 督查结果明细
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/supervisionResultDetail")
public class MmpSupervisionResultDetailController extends BaseController {

    private final IMmpSupervisionResultDetailService mmpSupervisionResultDetailService;

    /**
     * 查询督查结果明细列表
     */
    @SaCheckPermission("system:supervisionResultDetail:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSupervisionResultDetailVo> list(MmpSupervisionResultDetailBo bo, PageQuery pageQuery) {
        return mmpSupervisionResultDetailService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出督查结果明细列表
     */
    @SaCheckPermission("system:supervisionResultDetail:export")
    @Log(title = "督查结果明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSupervisionResultDetailBo bo, HttpServletResponse response) {
        List<MmpSupervisionResultDetailVo> list = mmpSupervisionResultDetailService.queryList(bo);
        ExcelUtil.exportExcel(list, "督查结果明细", MmpSupervisionResultDetailVo.class, response);
    }

    /**
     * 获取督查结果明细详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:supervisionResultDetail:query")
    @GetMapping("/{id}")
    public R<MmpSupervisionResultDetailVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSupervisionResultDetailService.queryById(id));
    }

    /**
     * 新增督查结果明细
     */
    @SaCheckPermission("system:supervisionResultDetail:add")
    @Log(title = "督查结果明细", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSupervisionResultDetailBo bo) {
        return toAjax(mmpSupervisionResultDetailService.insertByBo(bo));
    }

    /**
     * 修改督查结果明细
     */
    @SaCheckPermission("system:supervisionResultDetail:edit")
    @Log(title = "督查结果明细", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSupervisionResultDetailBo bo) {
        return toAjax(mmpSupervisionResultDetailService.updateByBo(bo));
    }

    /**
     * 删除督查结果明细
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:supervisionResultDetail:remove")
    @Log(title = "督查结果明细", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSupervisionResultDetailService.deleteWithValidByIds(List.of(ids), true));
    }
}
