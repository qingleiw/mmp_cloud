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
import org.dromara.cdi.mmp.coresystem.domain.vo.MmpCoreSystemInspectionRecordVo;
import org.dromara.cdi.mmp.coresystem.domain.bo.MmpCoreSystemInspectionRecordBo;
import org.dromara.cdi.mmp.coresystem.service.IMmpCoreSystemInspectionRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 制度检查记录
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/coresystem/coreSystemInspectionRecord")
public class MmpCoreSystemInspectionRecordController extends BaseController {

    private final IMmpCoreSystemInspectionRecordService mmpCoreSystemInspectionRecordService;

    /**
     * 查询制度检查记录列表
     */
    @SaCheckPermission("coresystem:coreSystemInspectionRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpCoreSystemInspectionRecordVo> list(MmpCoreSystemInspectionRecordBo bo, PageQuery pageQuery) {
        return mmpCoreSystemInspectionRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出制度检查记录列表
     */
    @SaCheckPermission("coresystem:coreSystemInspectionRecord:export")
    @Log(title = "制度检查记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpCoreSystemInspectionRecordBo bo, HttpServletResponse response) {
        List<MmpCoreSystemInspectionRecordVo> list = mmpCoreSystemInspectionRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "制度检查记录", MmpCoreSystemInspectionRecordVo.class, response);
    }

    /**
     * 获取制度检查记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("coresystem:coreSystemInspectionRecord:query")
    @GetMapping("/{id}")
    public R<MmpCoreSystemInspectionRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpCoreSystemInspectionRecordService.queryById(id));
    }

    /**
     * 新增制度检查记录
     */
    @SaCheckPermission("coresystem:coreSystemInspectionRecord:add")
    @Log(title = "制度检查记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpCoreSystemInspectionRecordBo bo) {
        return toAjax(mmpCoreSystemInspectionRecordService.insertByBo(bo));
    }

    /**
     * 修改制度检查记录
     */
    @SaCheckPermission("coresystem:coreSystemInspectionRecord:edit")
    @Log(title = "制度检查记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpCoreSystemInspectionRecordBo bo) {
        return toAjax(mmpCoreSystemInspectionRecordService.updateByBo(bo));
    }

    /**
     * 删除制度检查记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("coresystem:coreSystemInspectionRecord:remove")
    @Log(title = "制度检查记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpCoreSystemInspectionRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
