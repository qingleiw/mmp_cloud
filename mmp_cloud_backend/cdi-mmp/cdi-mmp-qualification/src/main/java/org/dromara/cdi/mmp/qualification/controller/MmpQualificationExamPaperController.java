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
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationExamPaperVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationExamPaperBo;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationExamPaperService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资质考核试卷
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/qualificationExamPaper")
public class MmpQualificationExamPaperController extends BaseController {

    private final IMmpQualificationExamPaperService mmpQualificationExamPaperService;

    /**
     * 查询资质考核试卷列表
     */
    @SaCheckPermission("system:qualificationExamPaper:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQualificationExamPaperVo> list(MmpQualificationExamPaperBo bo, PageQuery pageQuery) {
        return mmpQualificationExamPaperService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资质考核试卷列表
     */
    @SaCheckPermission("system:qualificationExamPaper:export")
    @Log(title = "资质考核试卷", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQualificationExamPaperBo bo, HttpServletResponse response) {
        List<MmpQualificationExamPaperVo> list = mmpQualificationExamPaperService.queryList(bo);
        ExcelUtil.exportExcel(list, "资质考核试卷", MmpQualificationExamPaperVo.class, response);
    }

    /**
     * 获取资质考核试卷详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:qualificationExamPaper:query")
    @GetMapping("/{id}")
    public R<MmpQualificationExamPaperVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQualificationExamPaperService.queryById(id));
    }

    /**
     * 新增资质考核试卷
     */
    @SaCheckPermission("system:qualificationExamPaper:add")
    @Log(title = "资质考核试卷", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQualificationExamPaperBo bo) {
        return toAjax(mmpQualificationExamPaperService.insertByBo(bo));
    }

    /**
     * 修改资质考核试卷
     */
    @SaCheckPermission("system:qualificationExamPaper:edit")
    @Log(title = "资质考核试卷", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQualificationExamPaperBo bo) {
        return toAjax(mmpQualificationExamPaperService.updateByBo(bo));
    }

    /**
     * 删除资质考核试卷
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:qualificationExamPaper:remove")
    @Log(title = "资质考核试卷", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQualificationExamPaperService.deleteWithValidByIds(List.of(ids), true));
    }
}
