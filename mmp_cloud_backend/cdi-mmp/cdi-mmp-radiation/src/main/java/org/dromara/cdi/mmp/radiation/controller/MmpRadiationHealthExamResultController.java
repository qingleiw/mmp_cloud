package org.dromara.cdi.mmp.radiation.controller;

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
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationHealthExamResultVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationHealthExamResultBo;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationHealthExamResultService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 体检结果记录
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/radiationHealthExamResult")
public class MmpRadiationHealthExamResultController extends BaseController {

    private final IMmpRadiationHealthExamResultService mmpRadiationHealthExamResultService;

    /**
     * 查询体检结果记录列表
     */
    @SaCheckPermission("system:radiationHealthExamResult:list")
    @GetMapping("/list")
    public TableDataInfo<MmpRadiationHealthExamResultVo> list(MmpRadiationHealthExamResultBo bo, PageQuery pageQuery) {
        return mmpRadiationHealthExamResultService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出体检结果记录列表
     */
    @SaCheckPermission("system:radiationHealthExamResult:export")
    @Log(title = "体检结果记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpRadiationHealthExamResultBo bo, HttpServletResponse response) {
        List<MmpRadiationHealthExamResultVo> list = mmpRadiationHealthExamResultService.queryList(bo);
        ExcelUtil.exportExcel(list, "体检结果记录", MmpRadiationHealthExamResultVo.class, response);
    }

    /**
     * 获取体检结果记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:radiationHealthExamResult:query")
    @GetMapping("/{id}")
    public R<MmpRadiationHealthExamResultVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpRadiationHealthExamResultService.queryById(id));
    }

    /**
     * 新增体检结果记录
     */
    @SaCheckPermission("system:radiationHealthExamResult:add")
    @Log(title = "体检结果记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpRadiationHealthExamResultBo bo) {
        return toAjax(mmpRadiationHealthExamResultService.insertByBo(bo));
    }

    /**
     * 修改体检结果记录
     */
    @SaCheckPermission("system:radiationHealthExamResult:edit")
    @Log(title = "体检结果记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpRadiationHealthExamResultBo bo) {
        return toAjax(mmpRadiationHealthExamResultService.updateByBo(bo));
    }

    /**
     * 删除体检结果记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:radiationHealthExamResult:remove")
    @Log(title = "体检结果记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpRadiationHealthExamResultService.deleteWithValidByIds(List.of(ids), true));
    }
}
