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
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionReviewVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionReviewBo;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionReviewService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 整改复查
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/supervisionReview")
public class MmpSupervisionReviewController extends BaseController {

    private final IMmpSupervisionReviewService mmpSupervisionReviewService;

    /**
     * 查询整改复查列表
     */
    @SaCheckPermission("system:supervisionReview:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSupervisionReviewVo> list(MmpSupervisionReviewBo bo, PageQuery pageQuery) {
        return mmpSupervisionReviewService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出整改复查列表
     */
    @SaCheckPermission("system:supervisionReview:export")
    @Log(title = "整改复查", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSupervisionReviewBo bo, HttpServletResponse response) {
        List<MmpSupervisionReviewVo> list = mmpSupervisionReviewService.queryList(bo);
        ExcelUtil.exportExcel(list, "整改复查", MmpSupervisionReviewVo.class, response);
    }

    /**
     * 获取整改复查详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:supervisionReview:query")
    @GetMapping("/{id}")
    public R<MmpSupervisionReviewVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSupervisionReviewService.queryById(id));
    }

    /**
     * 新增整改复查
     */
    @SaCheckPermission("system:supervisionReview:add")
    @Log(title = "整改复查", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSupervisionReviewBo bo) {
        return toAjax(mmpSupervisionReviewService.insertByBo(bo));
    }

    /**
     * 修改整改复查
     */
    @SaCheckPermission("system:supervisionReview:edit")
    @Log(title = "整改复查", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSupervisionReviewBo bo) {
        return toAjax(mmpSupervisionReviewService.updateByBo(bo));
    }

    /**
     * 删除整改复查
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:supervisionReview:remove")
    @Log(title = "整改复查", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSupervisionReviewService.deleteWithValidByIds(List.of(ids), true));
    }
}
