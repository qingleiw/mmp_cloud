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
import org.dromara.cdi.mmp.coresystem.domain.vo.MmpStatisticsCoreSystemVo;
import org.dromara.cdi.mmp.coresystem.domain.bo.MmpStatisticsCoreSystemBo;
import org.dromara.cdi.mmp.coresystem.service.IMmpStatisticsCoreSystemService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 核心制度落实情况监测
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/statisticsCoreSystem")
public class MmpStatisticsCoreSystemController extends BaseController {

    private final IMmpStatisticsCoreSystemService mmpStatisticsCoreSystemService;

    /**
     * 查询核心制度落实情况监测列表
     */
    @SaCheckPermission("coresystem:statisticsCoreSystem:list")
    @GetMapping("/list")
    public TableDataInfo<MmpStatisticsCoreSystemVo> list(MmpStatisticsCoreSystemBo bo, PageQuery pageQuery) {
        return mmpStatisticsCoreSystemService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出核心制度落实情况监测列表
     */
    @SaCheckPermission("coresystem:statisticsCoreSystem:export")
    @Log(title = "核心制度落实情况监测", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpStatisticsCoreSystemBo bo, HttpServletResponse response) {
        List<MmpStatisticsCoreSystemVo> list = mmpStatisticsCoreSystemService.queryList(bo);
        ExcelUtil.exportExcel(list, "核心制度落实情况监测", MmpStatisticsCoreSystemVo.class, response);
    }

    /**
     * 获取核心制度落实情况监测详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("coresystem:statisticsCoreSystem:query")
    @GetMapping("/{id}")
    public R<MmpStatisticsCoreSystemVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpStatisticsCoreSystemService.queryById(id));
    }

    /**
     * 新增核心制度落实情况监测
     */
    @SaCheckPermission("coresystem:statisticsCoreSystem:add")
    @Log(title = "核心制度落实情况监测", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpStatisticsCoreSystemBo bo) {
        return toAjax(mmpStatisticsCoreSystemService.insertByBo(bo));
    }

    /**
     * 修改核心制度落实情况监测
     */
    @SaCheckPermission("coresystem:statisticsCoreSystem:edit")
    @Log(title = "核心制度落实情况监测", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpStatisticsCoreSystemBo bo) {
        return toAjax(mmpStatisticsCoreSystemService.updateByBo(bo));
    }

    /**
     * 删除核心制度落实情况监测
     *
     * @param ids 主键串
     */
    @SaCheckPermission("coresystem:statisticsCoreSystem:remove")
    @Log(title = "核心制度落实情况监测", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpStatisticsCoreSystemService.deleteWithValidByIds(List.of(ids), true));
    }
}
