package org.dromara.cdi.mmp.qualification.controller;

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
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationExamQuestionVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationExamQuestionBo;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationExamQuestionService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资质考核题库
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/qualificationExamQuestion")
public class MmpQualificationExamQuestionController extends BaseController {

    private final IMmpQualificationExamQuestionService mmpQualificationExamQuestionService;

    /**
     * 查询资质考核题库列表
     */
    @SaCheckPermission("system:qualificationExamQuestion:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQualificationExamQuestionVo> list(MmpQualificationExamQuestionBo bo, PageQuery pageQuery) {
        return mmpQualificationExamQuestionService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资质考核题库列表
     */
    @SaCheckPermission("system:qualificationExamQuestion:export")
    @Log(title = "资质考核题库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQualificationExamQuestionBo bo, HttpServletResponse response) {
        List<MmpQualificationExamQuestionVo> list = mmpQualificationExamQuestionService.queryList(bo);
        ExcelUtil.exportExcel(list, "资质考核题库", MmpQualificationExamQuestionVo.class, response);
    }

    /**
     * 获取资质考核题库详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:qualificationExamQuestion:query")
    @GetMapping("/{id}")
    public R<MmpQualificationExamQuestionVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQualificationExamQuestionService.queryById(id));
    }

    /**
     * 新增资质考核题库
     */
    @SaCheckPermission("system:qualificationExamQuestion:add")
    @Log(title = "资质考核题库", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQualificationExamQuestionBo bo) {
        return toAjax(mmpQualificationExamQuestionService.insertByBo(bo));
    }

    /**
     * 修改资质考核题库
     */
    @SaCheckPermission("system:qualificationExamQuestion:edit")
    @Log(title = "资质考核题库", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQualificationExamQuestionBo bo) {
        return toAjax(mmpQualificationExamQuestionService.updateByBo(bo));
    }

    /**
     * 删除资质考核题库
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:qualificationExamQuestion:remove")
    @Log(title = "资质考核题库", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQualificationExamQuestionService.deleteWithValidByIds(List.of(ids), true));
    }
}
