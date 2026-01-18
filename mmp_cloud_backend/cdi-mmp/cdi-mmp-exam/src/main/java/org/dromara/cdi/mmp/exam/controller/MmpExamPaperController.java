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
import org.dromara.cdi.mmp.exam.domain.vo.MmpExamPaperVo;
import org.dromara.cdi.mmp.exam.domain.bo.MmpExamPaperBo;
import org.dromara.cdi.mmp.exam.service.IMmpExamPaperService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资质考核试卷
 * 前端访问路由地址为:/natdss/examPaper
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/examPaper")
public class MmpExamPaperController extends BaseController {

    private final IMmpExamPaperService mmpExamPaperService;

    /**
     * 查询资质考核试卷列表
     */
    @SaCheckPermission("natdss:examPaper:list")
    @GetMapping("/list")
    public TableDataInfo<MmpExamPaperVo> list(MmpExamPaperBo bo, PageQuery pageQuery) {
        return mmpExamPaperService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资质考核试卷列表
     */
    @SaCheckPermission("natdss:examPaper:export")
    @Log(title = "资质考核试卷", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpExamPaperBo bo, HttpServletResponse response) {
        List<MmpExamPaperVo> list = mmpExamPaperService.queryList(bo);
        ExcelUtil.exportExcel(list, "资质考核试卷", MmpExamPaperVo.class, response);
    }

    /**
     * 获取资质考核试卷详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:examPaper:query")
    @GetMapping("/{id}")
    public R<MmpExamPaperVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpExamPaperService.queryById(id));
    }

    /**
     * 新增资质考核试卷
     */
    @SaCheckPermission("natdss:examPaper:add")
    @Log(title = "资质考核试卷", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpExamPaperBo bo) {
        return toAjax(mmpExamPaperService.insertByBo(bo));
    }

    /**
     * 修改资质考核试卷
     */
    @SaCheckPermission("natdss:examPaper:edit")
    @Log(title = "资质考核试卷", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpExamPaperBo bo) {
        return toAjax(mmpExamPaperService.updateByBo(bo));
    }

    /**
     * 删除资质考核试卷
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:examPaper:remove")
    @Log(title = "资质考核试卷", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpExamPaperService.deleteWithValidByIds(List.of(ids), true));
    }
}
