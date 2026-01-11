package org.dromara.cdi.mmp.ntp.controller;

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
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectAssessmentVo;
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectAssessmentBo;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectAssessmentService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 项目考核评估
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/newTechnologyProjectAssessment")
public class MmpNewTechnologyProjectAssessmentController extends BaseController {

    private final IMmpNewTechnologyProjectAssessmentService mmpNewTechnologyProjectAssessmentService;

    /**
     * 查询项目考核评估列表
     */
    @SaCheckPermission("system:newTechnologyProjectAssessment:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNewTechnologyProjectAssessmentVo> list(MmpNewTechnologyProjectAssessmentBo bo, PageQuery pageQuery) {
        return mmpNewTechnologyProjectAssessmentService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出项目考核评估列表
     */
    @SaCheckPermission("system:newTechnologyProjectAssessment:export")
    @Log(title = "项目考核评估", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNewTechnologyProjectAssessmentBo bo, HttpServletResponse response) {
        List<MmpNewTechnologyProjectAssessmentVo> list = mmpNewTechnologyProjectAssessmentService.queryList(bo);
        ExcelUtil.exportExcel(list, "项目考核评估", MmpNewTechnologyProjectAssessmentVo.class, response);
    }

    /**
     * 获取项目考核评估详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:newTechnologyProjectAssessment:query")
    @GetMapping("/{id}")
    public R<MmpNewTechnologyProjectAssessmentVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpNewTechnologyProjectAssessmentService.queryById(id));
    }

    /**
     * 新增项目考核评估
     */
    @SaCheckPermission("system:newTechnologyProjectAssessment:add")
    @Log(title = "项目考核评估", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNewTechnologyProjectAssessmentBo bo) {
        return toAjax(mmpNewTechnologyProjectAssessmentService.insertByBo(bo));
    }

    /**
     * 修改项目考核评估
     */
    @SaCheckPermission("system:newTechnologyProjectAssessment:edit")
    @Log(title = "项目考核评估", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNewTechnologyProjectAssessmentBo bo) {
        return toAjax(mmpNewTechnologyProjectAssessmentService.updateByBo(bo));
    }

    /**
     * 删除项目考核评估
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:newTechnologyProjectAssessment:remove")
    @Log(title = "项目考核评估", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpNewTechnologyProjectAssessmentService.deleteWithValidByIds(List.of(ids), true));
    }
}
