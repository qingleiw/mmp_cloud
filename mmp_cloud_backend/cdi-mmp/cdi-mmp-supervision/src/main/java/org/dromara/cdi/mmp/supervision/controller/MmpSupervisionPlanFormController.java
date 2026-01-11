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
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionPlanFormVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionPlanFormBo;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionPlanFormService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 督查计划单关联
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/supervisionPlanForm")
public class MmpSupervisionPlanFormController extends BaseController {

    private final IMmpSupervisionPlanFormService mmpSupervisionPlanFormService;

    /**
     * 查询督查计划单关联列表
     */
    @SaCheckPermission("system:supervisionPlanForm:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSupervisionPlanFormVo> list(MmpSupervisionPlanFormBo bo, PageQuery pageQuery) {
        return mmpSupervisionPlanFormService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出督查计划单关联列表
     */
    @SaCheckPermission("system:supervisionPlanForm:export")
    @Log(title = "督查计划单关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSupervisionPlanFormBo bo, HttpServletResponse response) {
        List<MmpSupervisionPlanFormVo> list = mmpSupervisionPlanFormService.queryList(bo);
        ExcelUtil.exportExcel(list, "督查计划单关联", MmpSupervisionPlanFormVo.class, response);
    }

    /**
     * 获取督查计划单关联详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:supervisionPlanForm:query")
    @GetMapping("/{id}")
    public R<MmpSupervisionPlanFormVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSupervisionPlanFormService.queryById(id));
    }

    /**
     * 新增督查计划单关联
     */
    @SaCheckPermission("system:supervisionPlanForm:add")
    @Log(title = "督查计划单关联", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSupervisionPlanFormBo bo) {
        return toAjax(mmpSupervisionPlanFormService.insertByBo(bo));
    }

    /**
     * 修改督查计划单关联
     */
    @SaCheckPermission("system:supervisionPlanForm:edit")
    @Log(title = "督查计划单关联", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSupervisionPlanFormBo bo) {
        return toAjax(mmpSupervisionPlanFormService.updateByBo(bo));
    }

    /**
     * 删除督查计划单关联
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:supervisionPlanForm:remove")
    @Log(title = "督查计划单关联", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSupervisionPlanFormService.deleteWithValidByIds(List.of(ids), true));
    }
}
