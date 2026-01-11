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
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationWorkerVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationWorkerBo;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationWorkerService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 放射工作人员
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/radiationWorker")
public class MmpRadiationWorkerController extends BaseController {

    private final IMmpRadiationWorkerService mmpRadiationWorkerService;

    /**
     * 查询放射工作人员列表
     */
    @SaCheckPermission("system:radiationWorker:list")
    @GetMapping("/list")
    public TableDataInfo<MmpRadiationWorkerVo> list(MmpRadiationWorkerBo bo, PageQuery pageQuery) {
        return mmpRadiationWorkerService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出放射工作人员列表
     */
    @SaCheckPermission("system:radiationWorker:export")
    @Log(title = "放射工作人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpRadiationWorkerBo bo, HttpServletResponse response) {
        List<MmpRadiationWorkerVo> list = mmpRadiationWorkerService.queryList(bo);
        ExcelUtil.exportExcel(list, "放射工作人员", MmpRadiationWorkerVo.class, response);
    }

    /**
     * 获取放射工作人员详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:radiationWorker:query")
    @GetMapping("/{id}")
    public R<MmpRadiationWorkerVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpRadiationWorkerService.queryById(id));
    }

    /**
     * 新增放射工作人员
     */
    @SaCheckPermission("system:radiationWorker:add")
    @Log(title = "放射工作人员", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpRadiationWorkerBo bo) {
        return toAjax(mmpRadiationWorkerService.insertByBo(bo));
    }

    /**
     * 修改放射工作人员
     */
    @SaCheckPermission("system:radiationWorker:edit")
    @Log(title = "放射工作人员", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpRadiationWorkerBo bo) {
        return toAjax(mmpRadiationWorkerService.updateByBo(bo));
    }

    /**
     * 删除放射工作人员
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:radiationWorker:remove")
    @Log(title = "放射工作人员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpRadiationWorkerService.deleteWithValidByIds(List.of(ids), true));
    }
}
