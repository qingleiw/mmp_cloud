package org.dromara.cdi.mmp.supervision.controller;

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
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionIssueVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionIssueBo;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionIssueService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 督导问题
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/supervisionIssue")
public class MmpSupervisionIssueController extends BaseController {

    private final IMmpSupervisionIssueService mmpSupervisionIssueService;

    /**
     * 查询督导问题列表
     */
    @SaCheckPermission("system:supervisionIssue:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSupervisionIssueVo> list(MmpSupervisionIssueBo bo, PageQuery pageQuery) {
        return mmpSupervisionIssueService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出督导问题列表
     */
    @SaCheckPermission("system:supervisionIssue:export")
    @Log(title = "督导问题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSupervisionIssueBo bo, HttpServletResponse response) {
        List<MmpSupervisionIssueVo> list = mmpSupervisionIssueService.queryList(bo);
        ExcelUtil.exportExcel(list, "督导问题", MmpSupervisionIssueVo.class, response);
    }

    /**
     * 获取督导问题详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:supervisionIssue:query")
    @GetMapping("/{id}")
    public R<MmpSupervisionIssueVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSupervisionIssueService.queryById(id));
    }

    /**
     * 新增督导问题
     */
    @SaCheckPermission("system:supervisionIssue:add")
    @Log(title = "督导问题", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSupervisionIssueBo bo) {
        return toAjax(mmpSupervisionIssueService.insertByBo(bo));
    }

    /**
     * 修改督导问题
     */
    @SaCheckPermission("system:supervisionIssue:edit")
    @Log(title = "督导问题", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSupervisionIssueBo bo) {
        return toAjax(mmpSupervisionIssueService.updateByBo(bo));
    }

    /**
     * 删除督导问题
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:supervisionIssue:remove")
    @Log(title = "督导问题", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSupervisionIssueService.deleteWithValidByIds(List.of(ids), true));
    }
}
