package org.dromara.cdi.mmp.complaintdispute.controller;

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
import org.dromara.cdi.mmp.complaintdispute.domain.vo.MmpComplaintDisputeVo;
import org.dromara.cdi.mmp.complaintdispute.domain.bo.MmpComplaintDisputeBo;
import org.dromara.cdi.mmp.complaintdispute.service.IMmpComplaintDisputeService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 投诉纠纷主
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/complaintDispute")
public class MmpComplaintDisputeController extends BaseController {

    private final IMmpComplaintDisputeService mmpComplaintDisputeService;

    /**
     * 查询投诉纠纷主列表
     */
    @SaCheckPermission("complaintdispute:complaintDispute:list")
    @GetMapping("/list")
    public TableDataInfo<MmpComplaintDisputeVo> list(MmpComplaintDisputeBo bo, PageQuery pageQuery) {
        return mmpComplaintDisputeService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出投诉纠纷主列表
     */
    @SaCheckPermission("complaintdispute:complaintDispute:export")
    @Log(title = "投诉纠纷主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpComplaintDisputeBo bo, HttpServletResponse response) {
        List<MmpComplaintDisputeVo> list = mmpComplaintDisputeService.queryList(bo);
        ExcelUtil.exportExcel(list, "投诉纠纷主", MmpComplaintDisputeVo.class, response);
    }

    /**
     * 获取投诉纠纷主详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("complaintdispute:complaintDispute:query")
    @GetMapping("/{id}")
    public R<MmpComplaintDisputeVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpComplaintDisputeService.queryById(id));
    }

    /**
     * 新增投诉纠纷主
     */
    @SaCheckPermission("complaintdispute:complaintDispute:add")
    @Log(title = "投诉纠纷主", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpComplaintDisputeBo bo) {
        return toAjax(mmpComplaintDisputeService.insertByBo(bo));
    }

    /**
     * 修改投诉纠纷主
     */
    @SaCheckPermission("complaintdispute:complaintDispute:edit")
    @Log(title = "投诉纠纷主", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpComplaintDisputeBo bo) {
        return toAjax(mmpComplaintDisputeService.updateByBo(bo));
    }

    /**
     * 删除投诉纠纷主
     *
     * @param ids 主键串
     */
    @SaCheckPermission("complaintdispute:complaintDispute:remove")
    @Log(title = "投诉纠纷主", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpComplaintDisputeService.deleteWithValidByIds(List.of(ids), true));
    }
}
