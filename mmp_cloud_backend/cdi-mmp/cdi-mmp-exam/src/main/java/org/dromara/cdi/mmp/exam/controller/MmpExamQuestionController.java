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
import org.dromara.cdi.mmp.exam.domain.vo.MmpExamQuestionVo;
import org.dromara.cdi.mmp.exam.domain.bo.MmpExamQuestionBo;
import org.dromara.cdi.mmp.exam.service.IMmpExamQuestionService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资质考核题库
 * 前端访问路由地址为:/natdss/examQuestion
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/examQuestion")
public class MmpExamQuestionController extends BaseController {

    private final IMmpExamQuestionService mmpExamQuestionService;

    /**
     * 查询资质考核题库列表
     */
    @SaCheckPermission("natdss:examQuestion:list")
    @GetMapping("/list")
    public TableDataInfo<MmpExamQuestionVo> list(MmpExamQuestionBo bo, PageQuery pageQuery) {
        return mmpExamQuestionService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资质考核题库列表
     */
    @SaCheckPermission("natdss:examQuestion:export")
    @Log(title = "资质考核题库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpExamQuestionBo bo, HttpServletResponse response) {
        List<MmpExamQuestionVo> list = mmpExamQuestionService.queryList(bo);
        ExcelUtil.exportExcel(list, "资质考核题库", MmpExamQuestionVo.class, response);
    }

    /**
     * 获取资质考核题库详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:examQuestion:query")
    @GetMapping("/{id}")
    public R<MmpExamQuestionVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpExamQuestionService.queryById(id));
    }

    /**
     * 新增资质考核题库
     */
    @SaCheckPermission("natdss:examQuestion:add")
    @Log(title = "资质考核题库", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpExamQuestionBo bo) {
        return toAjax(mmpExamQuestionService.insertByBo(bo));
    }

    /**
     * 修改资质考核题库
     */
    @SaCheckPermission("natdss:examQuestion:edit")
    @Log(title = "资质考核题库", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpExamQuestionBo bo) {
        return toAjax(mmpExamQuestionService.updateByBo(bo));
    }

    /**
     * 删除资质考核题库
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:examQuestion:remove")
    @Log(title = "资质考核题库", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpExamQuestionService.deleteWithValidByIds(List.of(ids), true));
    }
}
