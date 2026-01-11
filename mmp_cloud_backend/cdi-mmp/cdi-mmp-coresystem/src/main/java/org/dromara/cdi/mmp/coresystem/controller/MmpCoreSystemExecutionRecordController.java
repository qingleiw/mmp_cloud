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
import org.dromara.cdi.mmp.coresystem.domain.vo.MmpCoreSystemExecutionRecordVo;
import org.dromara.cdi.mmp.coresystem.domain.bo.MmpCoreSystemExecutionRecordBo;
import org.dromara.cdi.mmp.coresystem.service.IMmpCoreSystemExecutionRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 制度执行记录
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/coresystem/coreSystemExecutionRecord")
public class MmpCoreSystemExecutionRecordController extends BaseController {

    private final IMmpCoreSystemExecutionRecordService mmpCoreSystemExecutionRecordService;

    /**
     * 查询制度执行记录列表
     */
    @SaCheckPermission("coresystem:coreSystemExecutionRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpCoreSystemExecutionRecordVo> list(MmpCoreSystemExecutionRecordBo bo, PageQuery pageQuery) {
        return mmpCoreSystemExecutionRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出制度执行记录列表
     */
    @SaCheckPermission("coresystem:coreSystemExecutionRecord:export")
    @Log(title = "制度执行记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpCoreSystemExecutionRecordBo bo, HttpServletResponse response) {
        List<MmpCoreSystemExecutionRecordVo> list = mmpCoreSystemExecutionRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "制度执行记录", MmpCoreSystemExecutionRecordVo.class, response);
    }

    /**
     * 获取制度执行记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("coresystem:coreSystemExecutionRecord:query")
    @GetMapping("/{id}")
    public R<MmpCoreSystemExecutionRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpCoreSystemExecutionRecordService.queryById(id));
    }

    /**
     * 新增制度执行记录
     */
    @SaCheckPermission("coresystem:coreSystemExecutionRecord:add")
    @Log(title = "制度执行记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpCoreSystemExecutionRecordBo bo) {
        return toAjax(mmpCoreSystemExecutionRecordService.insertByBo(bo));
    }

    /**
     * 修改制度执行记录
     */
    @SaCheckPermission("coresystem:coreSystemExecutionRecord:edit")
    @Log(title = "制度执行记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpCoreSystemExecutionRecordBo bo) {
        return toAjax(mmpCoreSystemExecutionRecordService.updateByBo(bo));
    }

    /**
     * 删除制度执行记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("coresystem:coreSystemExecutionRecord:remove")
    @Log(title = "制度执行记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpCoreSystemExecutionRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
