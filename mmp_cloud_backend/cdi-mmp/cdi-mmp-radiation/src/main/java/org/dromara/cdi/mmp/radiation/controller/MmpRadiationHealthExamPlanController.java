package org.dromara.cdi.mmp.radiation.controller;

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
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationHealthExamPlanVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationHealthExamPlanBo;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationHealthExamPlanService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 职业健康体检计划
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/radiationHealthExamPlan")
public class MmpRadiationHealthExamPlanController extends BaseController {

    private final IMmpRadiationHealthExamPlanService mmpRadiationHealthExamPlanService;

    /**
     * 查询职业健康体检计划列表
     */
    @SaCheckPermission("system:radiationHealthExamPlan:list")
    @GetMapping("/list")
    public TableDataInfo<MmpRadiationHealthExamPlanVo> list(MmpRadiationHealthExamPlanBo bo, PageQuery pageQuery) {
        return mmpRadiationHealthExamPlanService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出职业健康体检计划列表
     */
    @SaCheckPermission("system:radiationHealthExamPlan:export")
    @Log(title = "职业健康体检计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpRadiationHealthExamPlanBo bo, HttpServletResponse response) {
        List<MmpRadiationHealthExamPlanVo> list = mmpRadiationHealthExamPlanService.queryList(bo);
        ExcelUtil.exportExcel(list, "职业健康体检计划", MmpRadiationHealthExamPlanVo.class, response);
    }

    /**
     * 获取职业健康体检计划详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:radiationHealthExamPlan:query")
    @GetMapping("/{id}")
    public R<MmpRadiationHealthExamPlanVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpRadiationHealthExamPlanService.queryById(id));
    }

    /**
     * 新增职业健康体检计划
     */
    @SaCheckPermission("system:radiationHealthExamPlan:add")
    @Log(title = "职业健康体检计划", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpRadiationHealthExamPlanBo bo) {
        return toAjax(mmpRadiationHealthExamPlanService.insertByBo(bo));
    }

    /**
     * 修改职业健康体检计划
     */
    @SaCheckPermission("system:radiationHealthExamPlan:edit")
    @Log(title = "职业健康体检计划", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpRadiationHealthExamPlanBo bo) {
        return toAjax(mmpRadiationHealthExamPlanService.updateByBo(bo));
    }

    /**
     * 删除职业健康体检计划
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:radiationHealthExamPlan:remove")
    @Log(title = "职业健康体检计划", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpRadiationHealthExamPlanService.deleteWithValidByIds(List.of(ids), true));
    }
}
