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
import org.dromara.cdi.mmp.coresystem.domain.vo.MmpCoreSystemRectificationRecordVo;
import org.dromara.cdi.mmp.coresystem.domain.bo.MmpCoreSystemRectificationRecordBo;
import org.dromara.cdi.mmp.coresystem.service.IMmpCoreSystemRectificationRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 制度整改记录
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/coreSystemRectificationRecord")
public class MmpCoreSystemRectificationRecordController extends BaseController {

    private final IMmpCoreSystemRectificationRecordService mmpCoreSystemRectificationRecordService;

    /**
     * 查询制度整改记录列表
     */
    @SaCheckPermission("coresystem:coreSystemRectificationRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpCoreSystemRectificationRecordVo> list(MmpCoreSystemRectificationRecordBo bo, PageQuery pageQuery) {
        return mmpCoreSystemRectificationRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出制度整改记录列表
     */
    @SaCheckPermission("coresystem:coreSystemRectificationRecord:export")
    @Log(title = "制度整改记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpCoreSystemRectificationRecordBo bo, HttpServletResponse response) {
        List<MmpCoreSystemRectificationRecordVo> list = mmpCoreSystemRectificationRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "制度整改记录", MmpCoreSystemRectificationRecordVo.class, response);
    }

    /**
     * 获取制度整改记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("coresystem:coreSystemRectificationRecord:query")
    @GetMapping("/{id}")
    public R<MmpCoreSystemRectificationRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpCoreSystemRectificationRecordService.queryById(id));
    }

    /**
     * 新增制度整改记录
     */
    @SaCheckPermission("coresystem:coreSystemRectificationRecord:add")
    @Log(title = "制度整改记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpCoreSystemRectificationRecordBo bo) {
        return toAjax(mmpCoreSystemRectificationRecordService.insertByBo(bo));
    }

    /**
     * 修改制度整改记录
     */
    @SaCheckPermission("coresystem:coreSystemRectificationRecord:edit")
    @Log(title = "制度整改记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpCoreSystemRectificationRecordBo bo) {
        return toAjax(mmpCoreSystemRectificationRecordService.updateByBo(bo));
    }

    /**
     * 删除制度整改记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("coresystem:coreSystemRectificationRecord:remove")
    @Log(title = "制度整改记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpCoreSystemRectificationRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
