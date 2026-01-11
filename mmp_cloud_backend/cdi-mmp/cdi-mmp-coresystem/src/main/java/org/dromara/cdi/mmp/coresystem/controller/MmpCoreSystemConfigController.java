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
import org.dromara.cdi.mmp.coresystem.domain.vo.MmpCoreSystemConfigVo;
import org.dromara.cdi.mmp.coresystem.domain.bo.MmpCoreSystemConfigBo;
import org.dromara.cdi.mmp.coresystem.service.IMmpCoreSystemConfigService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 核心制度配置
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/coresystem/coreSystemConfig")
public class MmpCoreSystemConfigController extends BaseController {

    private final IMmpCoreSystemConfigService mmpCoreSystemConfigService;

    /**
     * 查询核心制度配置列表
     */
    @SaCheckPermission("coresystem:coreSystemConfig:list")
    @GetMapping("/list")
    public TableDataInfo<MmpCoreSystemConfigVo> list(MmpCoreSystemConfigBo bo, PageQuery pageQuery) {
        return mmpCoreSystemConfigService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出核心制度配置列表
     */
    @SaCheckPermission("coresystem:coreSystemConfig:export")
    @Log(title = "核心制度配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpCoreSystemConfigBo bo, HttpServletResponse response) {
        List<MmpCoreSystemConfigVo> list = mmpCoreSystemConfigService.queryList(bo);
        ExcelUtil.exportExcel(list, "核心制度配置", MmpCoreSystemConfigVo.class, response);
    }

    /**
     * 获取核心制度配置详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("coresystem:coreSystemConfig:query")
    @GetMapping("/{id}")
    public R<MmpCoreSystemConfigVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpCoreSystemConfigService.queryById(id));
    }

    /**
     * 新增核心制度配置
     */
    @SaCheckPermission("coresystem:coreSystemConfig:add")
    @Log(title = "核心制度配置", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpCoreSystemConfigBo bo) {
        return toAjax(mmpCoreSystemConfigService.insertByBo(bo));
    }

    /**
     * 修改核心制度配置
     */
    @SaCheckPermission("coresystem:coreSystemConfig:edit")
    @Log(title = "核心制度配置", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpCoreSystemConfigBo bo) {
        return toAjax(mmpCoreSystemConfigService.updateByBo(bo));
    }

    /**
     * 删除核心制度配置
     *
     * @param ids 主键串
     */
    @SaCheckPermission("coresystem:coreSystemConfig:remove")
    @Log(title = "核心制度配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpCoreSystemConfigService.deleteWithValidByIds(List.of(ids), true));
    }
}
