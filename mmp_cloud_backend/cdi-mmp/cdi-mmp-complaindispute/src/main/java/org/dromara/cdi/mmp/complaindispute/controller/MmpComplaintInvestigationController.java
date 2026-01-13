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
import org.dromara.cdi.mmp.complaindispute.domain.vo.MmpComplaintInvestigationVo;
import org.dromara.cdi.mmp.complaindispute.domain.bo.MmpComplaintInvestigationBo;
import org.dromara.cdi.mmp.complaindispute.service.IMmpComplaintInvestigationService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 投诉调查记录
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/complaintInvestigation")
public class MmpComplaintInvestigationController extends BaseController {

    private final IMmpComplaintInvestigationService mmpComplaintInvestigationService;

    /**
     * 查询投诉调查记录列表
     */
    @SaCheckPermission("complaindispute:complaintInvestigation:list")
    @GetMapping("/list")
    public TableDataInfo<MmpComplaintInvestigationVo> list(MmpComplaintInvestigationBo bo, PageQuery pageQuery) {
        return mmpComplaintInvestigationService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出投诉调查记录列表
     */
    @SaCheckPermission("complaindispute:complaintInvestigation:export")
    @Log(title = "投诉调查记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpComplaintInvestigationBo bo, HttpServletResponse response) {
        List<MmpComplaintInvestigationVo> list = mmpComplaintInvestigationService.queryList(bo);
        ExcelUtil.exportExcel(list, "投诉调查记录", MmpComplaintInvestigationVo.class, response);
    }

    /**
     * 获取投诉调查记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("complaindispute:complaintInvestigation:query")
    @GetMapping("/{id}")
    public R<MmpComplaintInvestigationVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpComplaintInvestigationService.queryById(id));
    }

    /**
     * 新增投诉调查记录
     */
    @SaCheckPermission("complaindispute:complaintInvestigation:add")
    @Log(title = "投诉调查记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpComplaintInvestigationBo bo) {
        return toAjax(mmpComplaintInvestigationService.insertByBo(bo));
    }

    /**
     * 修改投诉调查记录
     */
    @SaCheckPermission("complaindispute:complaintInvestigation:edit")
    @Log(title = "投诉调查记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpComplaintInvestigationBo bo) {
        return toAjax(mmpComplaintInvestigationService.updateByBo(bo));
    }

    /**
     * 删除投诉调查记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("complaindispute:complaintInvestigation:remove")
    @Log(title = "投诉调查记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpComplaintInvestigationService.deleteWithValidByIds(List.of(ids), true));
    }
}
