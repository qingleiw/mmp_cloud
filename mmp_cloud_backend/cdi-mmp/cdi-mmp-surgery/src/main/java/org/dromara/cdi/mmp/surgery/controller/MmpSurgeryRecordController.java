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
import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryRecordVo;
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryRecordBo;
import org.dromara.cdi.mmp.surgery.service.IMmpSurgeryRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 手术记录
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/surgeryRecord")
public class MmpSurgeryRecordController extends BaseController {

    private final IMmpSurgeryRecordService mmpSurgeryRecordService;

    /**
     * 查询手术记录列表
     */
    @SaCheckPermission("surgery:surgeryRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSurgeryRecordVo> list(MmpSurgeryRecordBo bo, PageQuery pageQuery) {
        return mmpSurgeryRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出手术记录列表
     */
    @SaCheckPermission("surgery:surgeryRecord:export")
    @Log(title = "手术记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSurgeryRecordBo bo, HttpServletResponse response) {
        List<MmpSurgeryRecordVo> list = mmpSurgeryRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "手术记录", MmpSurgeryRecordVo.class, response);
    }

    /**
     * 获取手术记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("surgery:surgeryRecord:query")
    @GetMapping("/{id}")
    public R<MmpSurgeryRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSurgeryRecordService.queryById(id));
    }

    /**
     * 新增手术记录
     */
    @SaCheckPermission("surgery:surgeryRecord:add")
    @Log(title = "手术记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSurgeryRecordBo bo) {
        return toAjax(mmpSurgeryRecordService.insertByBo(bo));
    }

    /**
     * 修改手术记录
     */
    @SaCheckPermission("surgery:surgeryRecord:edit")
    @Log(title = "手术记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSurgeryRecordBo bo) {
        return toAjax(mmpSurgeryRecordService.updateByBo(bo));
    }

    /**
     * 删除手术记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("surgery:surgeryRecord:remove")
    @Log(title = "手术记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSurgeryRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
