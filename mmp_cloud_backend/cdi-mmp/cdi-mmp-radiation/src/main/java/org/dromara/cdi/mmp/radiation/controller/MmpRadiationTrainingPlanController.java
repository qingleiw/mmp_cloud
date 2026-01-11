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
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationTrainingPlanVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationTrainingPlanBo;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationTrainingPlanService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 职业健康培训计划
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/radiationTrainingPlan")
public class MmpRadiationTrainingPlanController extends BaseController {

    private final IMmpRadiationTrainingPlanService mmpRadiationTrainingPlanService;

    /**
     * 查询职业健康培训计划列表
     */
    @SaCheckPermission("system:radiationTrainingPlan:list")
    @GetMapping("/list")
    public TableDataInfo<MmpRadiationTrainingPlanVo> list(MmpRadiationTrainingPlanBo bo, PageQuery pageQuery) {
        return mmpRadiationTrainingPlanService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出职业健康培训计划列表
     */
    @SaCheckPermission("system:radiationTrainingPlan:export")
    @Log(title = "职业健康培训计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpRadiationTrainingPlanBo bo, HttpServletResponse response) {
        List<MmpRadiationTrainingPlanVo> list = mmpRadiationTrainingPlanService.queryList(bo);
        ExcelUtil.exportExcel(list, "职业健康培训计划", MmpRadiationTrainingPlanVo.class, response);
    }

    /**
     * 获取职业健康培训计划详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:radiationTrainingPlan:query")
    @GetMapping("/{id}")
    public R<MmpRadiationTrainingPlanVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpRadiationTrainingPlanService.queryById(id));
    }

    /**
     * 新增职业健康培训计划
     */
    @SaCheckPermission("system:radiationTrainingPlan:add")
    @Log(title = "职业健康培训计划", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpRadiationTrainingPlanBo bo) {
        return toAjax(mmpRadiationTrainingPlanService.insertByBo(bo));
    }

    /**
     * 修改职业健康培训计划
     */
    @SaCheckPermission("system:radiationTrainingPlan:edit")
    @Log(title = "职业健康培训计划", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpRadiationTrainingPlanBo bo) {
        return toAjax(mmpRadiationTrainingPlanService.updateByBo(bo));
    }

    /**
     * 删除职业健康培训计划
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:radiationTrainingPlan:remove")
    @Log(title = "职业健康培训计划", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpRadiationTrainingPlanService.deleteWithValidByIds(List.of(ids), true));
    }
}
