package org.dromara.cdi.mmp.coresystem.controller;

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
import org.dromara.cdi.mmp.coresystem.domain.vo.MmpCoreSystemIndicatorVo;
import org.dromara.cdi.mmp.coresystem.domain.bo.MmpCoreSystemIndicatorBo;
import org.dromara.cdi.mmp.coresystem.service.IMmpCoreSystemIndicatorService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 核心制度指标
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/coresystem/coreSystemIndicator")
public class MmpCoreSystemIndicatorController extends BaseController {

    private final IMmpCoreSystemIndicatorService mmpCoreSystemIndicatorService;

    /**
     * 查询核心制度指标列表
     */
    @SaCheckPermission("coresystem:coreSystemIndicator:list")
    @GetMapping("/list")
    public TableDataInfo<MmpCoreSystemIndicatorVo> list(MmpCoreSystemIndicatorBo bo, PageQuery pageQuery) {
        return mmpCoreSystemIndicatorService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出核心制度指标列表
     */
    @SaCheckPermission("coresystem:coreSystemIndicator:export")
    @Log(title = "核心制度指标", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpCoreSystemIndicatorBo bo, HttpServletResponse response) {
        List<MmpCoreSystemIndicatorVo> list = mmpCoreSystemIndicatorService.queryList(bo);
        ExcelUtil.exportExcel(list, "核心制度指标", MmpCoreSystemIndicatorVo.class, response);
    }

    /**
     * 获取核心制度指标详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("coresystem:coreSystemIndicator:query")
    @GetMapping("/{id}")
    public R<MmpCoreSystemIndicatorVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpCoreSystemIndicatorService.queryById(id));
    }

    /**
     * 新增核心制度指标
     */
    @SaCheckPermission("coresystem:coreSystemIndicator:add")
    @Log(title = "核心制度指标", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpCoreSystemIndicatorBo bo) {
        return toAjax(mmpCoreSystemIndicatorService.insertByBo(bo));
    }

    /**
     * 修改核心制度指标
     */
    @SaCheckPermission("coresystem:coreSystemIndicator:edit")
    @Log(title = "核心制度指标", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpCoreSystemIndicatorBo bo) {
        return toAjax(mmpCoreSystemIndicatorService.updateByBo(bo));
    }

    /**
     * 删除核心制度指标
     *
     * @param ids 主键串
     */
    @SaCheckPermission("coresystem:coreSystemIndicator:remove")
    @Log(title = "核心制度指标", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpCoreSystemIndicatorService.deleteWithValidByIds(List.of(ids), true));
    }
}
