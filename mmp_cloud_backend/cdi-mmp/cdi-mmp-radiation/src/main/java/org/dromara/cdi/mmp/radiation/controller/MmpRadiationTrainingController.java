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
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationTrainingVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationTrainingBo;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationTrainingService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 职业健康培训
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/radiationTraining")
public class MmpRadiationTrainingController extends BaseController {

    private final IMmpRadiationTrainingService mmpRadiationTrainingService;

    /**
     * 查询职业健康培训列表
     */
    @SaCheckPermission("system:radiationTraining:list")
    @GetMapping("/list")
    public TableDataInfo<MmpRadiationTrainingVo> list(MmpRadiationTrainingBo bo, PageQuery pageQuery) {
        return mmpRadiationTrainingService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出职业健康培训列表
     */
    @SaCheckPermission("system:radiationTraining:export")
    @Log(title = "职业健康培训", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpRadiationTrainingBo bo, HttpServletResponse response) {
        List<MmpRadiationTrainingVo> list = mmpRadiationTrainingService.queryList(bo);
        ExcelUtil.exportExcel(list, "职业健康培训", MmpRadiationTrainingVo.class, response);
    }

    /**
     * 获取职业健康培训详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:radiationTraining:query")
    @GetMapping("/{id}")
    public R<MmpRadiationTrainingVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpRadiationTrainingService.queryById(id));
    }

    /**
     * 新增职业健康培训
     */
    @SaCheckPermission("system:radiationTraining:add")
    @Log(title = "职业健康培训", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpRadiationTrainingBo bo) {
        return toAjax(mmpRadiationTrainingService.insertByBo(bo));
    }

    /**
     * 修改职业健康培训
     */
    @SaCheckPermission("system:radiationTraining:edit")
    @Log(title = "职业健康培训", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpRadiationTrainingBo bo) {
        return toAjax(mmpRadiationTrainingService.updateByBo(bo));
    }

    /**
     * 删除职业健康培训
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:radiationTraining:remove")
    @Log(title = "职业健康培训", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpRadiationTrainingService.deleteWithValidByIds(List.of(ids), true));
    }
}
