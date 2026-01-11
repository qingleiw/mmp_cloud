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
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationExamArrangementVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationExamArrangementBo;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationExamArrangementService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资质考试安排
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/qualificationExamArrangement")
public class MmpQualificationExamArrangementController extends BaseController {

    private final IMmpQualificationExamArrangementService mmpQualificationExamArrangementService;

    /**
     * 查询资质考试安排列表
     */
    @SaCheckPermission("system:qualificationExamArrangement:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQualificationExamArrangementVo> list(MmpQualificationExamArrangementBo bo, PageQuery pageQuery) {
        return mmpQualificationExamArrangementService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资质考试安排列表
     */
    @SaCheckPermission("system:qualificationExamArrangement:export")
    @Log(title = "资质考试安排", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQualificationExamArrangementBo bo, HttpServletResponse response) {
        List<MmpQualificationExamArrangementVo> list = mmpQualificationExamArrangementService.queryList(bo);
        ExcelUtil.exportExcel(list, "资质考试安排", MmpQualificationExamArrangementVo.class, response);
    }

    /**
     * 获取资质考试安排详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:qualificationExamArrangement:query")
    @GetMapping("/{id}")
    public R<MmpQualificationExamArrangementVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQualificationExamArrangementService.queryById(id));
    }

    /**
     * 新增资质考试安排
     */
    @SaCheckPermission("system:qualificationExamArrangement:add")
    @Log(title = "资质考试安排", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQualificationExamArrangementBo bo) {
        return toAjax(mmpQualificationExamArrangementService.insertByBo(bo));
    }

    /**
     * 修改资质考试安排
     */
    @SaCheckPermission("system:qualificationExamArrangement:edit")
    @Log(title = "资质考试安排", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQualificationExamArrangementBo bo) {
        return toAjax(mmpQualificationExamArrangementService.updateByBo(bo));
    }

    /**
     * 删除资质考试安排
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:qualificationExamArrangement:remove")
    @Log(title = "资质考试安排", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQualificationExamArrangementService.deleteWithValidByIds(List.of(ids), true));
    }
}
