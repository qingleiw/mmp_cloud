package org.dromara.cdi.mmp.surgery.controller;

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
import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryComplicationRecordVo;
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryComplicationRecordBo;
import org.dromara.cdi.mmp.surgery.service.IMmpSurgeryComplicationRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 手术并发症记录
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/surgeryComplicationRecord")
public class MmpSurgeryComplicationRecordController extends BaseController {

    private final IMmpSurgeryComplicationRecordService mmpSurgeryComplicationRecordService;

    /**
     * 查询手术并发症记录列表
     */
    @SaCheckPermission("system:surgeryComplicationRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSurgeryComplicationRecordVo> list(MmpSurgeryComplicationRecordBo bo, PageQuery pageQuery) {
        return mmpSurgeryComplicationRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出手术并发症记录列表
     */
    @SaCheckPermission("system:surgeryComplicationRecord:export")
    @Log(title = "手术并发症记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSurgeryComplicationRecordBo bo, HttpServletResponse response) {
        List<MmpSurgeryComplicationRecordVo> list = mmpSurgeryComplicationRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "手术并发症记录", MmpSurgeryComplicationRecordVo.class, response);
    }

    /**
     * 获取手术并发症记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:surgeryComplicationRecord:query")
    @GetMapping("/{id}")
    public R<MmpSurgeryComplicationRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSurgeryComplicationRecordService.queryById(id));
    }

    /**
     * 新增手术并发症记录
     */
    @SaCheckPermission("system:surgeryComplicationRecord:add")
    @Log(title = "手术并发症记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSurgeryComplicationRecordBo bo) {
        return toAjax(mmpSurgeryComplicationRecordService.insertByBo(bo));
    }

    /**
     * 修改手术并发症记录
     */
    @SaCheckPermission("system:surgeryComplicationRecord:edit")
    @Log(title = "手术并发症记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSurgeryComplicationRecordBo bo) {
        return toAjax(mmpSurgeryComplicationRecordService.updateByBo(bo));
    }

    /**
     * 删除手术并发症记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:surgeryComplicationRecord:remove")
    @Log(title = "手术并发症记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSurgeryComplicationRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
