package org.dromara.cdi.mmp.exam.controller;

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
import org.dromara.cdi.mmp.exam.domain.vo.MmpExamArrangementVo;
import org.dromara.cdi.mmp.exam.domain.bo.MmpExamArrangementBo;
import org.dromara.cdi.mmp.exam.service.IMmpExamArrangementService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资质考试安排
 * 前端访问路由地址为:/natdss/examArrangement
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/examArrangement")
public class MmpExamArrangementController extends BaseController {

    private final IMmpExamArrangementService mmpExamArrangementService;

    /**
     * 查询资质考试安排列表
     */
    @SaCheckPermission("natdss:examArrangement:list")
    @GetMapping("/list")
    public TableDataInfo<MmpExamArrangementVo> list(MmpExamArrangementBo bo, PageQuery pageQuery) {
        return mmpExamArrangementService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资质考试安排列表
     */
    @SaCheckPermission("natdss:examArrangement:export")
    @Log(title = "资质考试安排", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpExamArrangementBo bo, HttpServletResponse response) {
        List<MmpExamArrangementVo> list = mmpExamArrangementService.queryList(bo);
        ExcelUtil.exportExcel(list, "资质考试安排", MmpExamArrangementVo.class, response);
    }

    /**
     * 获取资质考试安排详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:examArrangement:query")
    @GetMapping("/{id}")
    public R<MmpExamArrangementVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpExamArrangementService.queryById(id));
    }

    /**
     * 新增资质考试安排
     */
    @SaCheckPermission("natdss:examArrangement:add")
    @Log(title = "资质考试安排", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpExamArrangementBo bo) {
        return toAjax(mmpExamArrangementService.insertByBo(bo));
    }

    /**
     * 修改资质考试安排
     */
    @SaCheckPermission("natdss:examArrangement:edit")
    @Log(title = "资质考试安排", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpExamArrangementBo bo) {
        return toAjax(mmpExamArrangementService.updateByBo(bo));
    }

    /**
     * 删除资质考试安排
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:examArrangement:remove")
    @Log(title = "资质考试安排", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpExamArrangementService.deleteWithValidByIds(List.of(ids), true));
    }
}
