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
import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryVideoVo;
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryVideoBo;
import org.dromara.cdi.mmp.surgery.service.IMmpSurgeryVideoService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 手术视频
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/surgeryVideo")
public class MmpSurgeryVideoController extends BaseController {

    private final IMmpSurgeryVideoService mmpSurgeryVideoService;

    /**
     * 查询手术视频列表
     */
    @SaCheckPermission("system:surgeryVideo:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSurgeryVideoVo> list(MmpSurgeryVideoBo bo, PageQuery pageQuery) {
        return mmpSurgeryVideoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出手术视频列表
     */
    @SaCheckPermission("system:surgeryVideo:export")
    @Log(title = "手术视频", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSurgeryVideoBo bo, HttpServletResponse response) {
        List<MmpSurgeryVideoVo> list = mmpSurgeryVideoService.queryList(bo);
        ExcelUtil.exportExcel(list, "手术视频", MmpSurgeryVideoVo.class, response);
    }

    /**
     * 获取手术视频详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:surgeryVideo:query")
    @GetMapping("/{id}")
    public R<MmpSurgeryVideoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSurgeryVideoService.queryById(id));
    }

    /**
     * 新增手术视频
     */
    @SaCheckPermission("system:surgeryVideo:add")
    @Log(title = "手术视频", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSurgeryVideoBo bo) {
        return toAjax(mmpSurgeryVideoService.insertByBo(bo));
    }

    /**
     * 修改手术视频
     */
    @SaCheckPermission("system:surgeryVideo:edit")
    @Log(title = "手术视频", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSurgeryVideoBo bo) {
        return toAjax(mmpSurgeryVideoService.updateByBo(bo));
    }

    /**
     * 删除手术视频
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:surgeryVideo:remove")
    @Log(title = "手术视频", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSurgeryVideoService.deleteWithValidByIds(List.of(ids), true));
    }
}
