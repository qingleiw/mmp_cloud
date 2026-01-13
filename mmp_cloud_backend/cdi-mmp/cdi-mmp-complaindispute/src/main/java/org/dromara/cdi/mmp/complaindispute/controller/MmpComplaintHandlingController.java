package org.dromara.cdi.mmp.complaindispute.controller;

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
import org.dromara.cdi.mmp.complaindispute.domain.vo.MmpComplaintHandlingVo;
import org.dromara.cdi.mmp.complaindispute.domain.bo.MmpComplaintHandlingBo;
import org.dromara.cdi.mmp.complaindispute.service.IMmpComplaintHandlingService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 投诉处理记录
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/complaintHandling")
public class MmpComplaintHandlingController extends BaseController {

    private final IMmpComplaintHandlingService mmpComplaintHandlingService;

    /**
     * 查询投诉处理记录列表
     */
    @SaCheckPermission("complaindispute:complaintHandling:list")
    @GetMapping("/list")
    public TableDataInfo<MmpComplaintHandlingVo> list(MmpComplaintHandlingBo bo, PageQuery pageQuery) {
        return mmpComplaintHandlingService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出投诉处理记录列表
     */
    @SaCheckPermission("complaindispute:complaintHandling:export")
    @Log(title = "投诉处理记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpComplaintHandlingBo bo, HttpServletResponse response) {
        List<MmpComplaintHandlingVo> list = mmpComplaintHandlingService.queryList(bo);
        ExcelUtil.exportExcel(list, "投诉处理记录", MmpComplaintHandlingVo.class, response);
    }

    /**
     * 获取投诉处理记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("complaindispute:complaintHandling:query")
    @GetMapping("/{id}")
    public R<MmpComplaintHandlingVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpComplaintHandlingService.queryById(id));
    }

    /**
     * 新增投诉处理记录
     */
    @SaCheckPermission("complaindispute:complaintHandling:add")
    @Log(title = "投诉处理记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpComplaintHandlingBo bo) {
        return toAjax(mmpComplaintHandlingService.insertByBo(bo));
    }

    /**
     * 修改投诉处理记录
     */
    @SaCheckPermission("complaindispute:complaintHandling:edit")
    @Log(title = "投诉处理记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpComplaintHandlingBo bo) {
        return toAjax(mmpComplaintHandlingService.updateByBo(bo));
    }

    /**
     * 删除投诉处理记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("complaindispute:complaintHandling:remove")
    @Log(title = "投诉处理记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpComplaintHandlingService.deleteWithValidByIds(List.of(ids), true));
    }
}
