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
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationDoseRecordVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationDoseRecordBo;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationDoseRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 个人剂量监测记录
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/radiationDoseRecord")
public class MmpRadiationDoseRecordController extends BaseController {

    private final IMmpRadiationDoseRecordService mmpRadiationDoseRecordService;

    /**
     * 查询个人剂量监测记录列表
     */
    @SaCheckPermission("system:radiationDoseRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpRadiationDoseRecordVo> list(MmpRadiationDoseRecordBo bo, PageQuery pageQuery) {
        return mmpRadiationDoseRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出个人剂量监测记录列表
     */
    @SaCheckPermission("system:radiationDoseRecord:export")
    @Log(title = "个人剂量监测记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpRadiationDoseRecordBo bo, HttpServletResponse response) {
        List<MmpRadiationDoseRecordVo> list = mmpRadiationDoseRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "个人剂量监测记录", MmpRadiationDoseRecordVo.class, response);
    }

    /**
     * 获取个人剂量监测记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:radiationDoseRecord:query")
    @GetMapping("/{id}")
    public R<MmpRadiationDoseRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpRadiationDoseRecordService.queryById(id));
    }

    /**
     * 新增个人剂量监测记录
     */
    @SaCheckPermission("system:radiationDoseRecord:add")
    @Log(title = "个人剂量监测记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpRadiationDoseRecordBo bo) {
        return toAjax(mmpRadiationDoseRecordService.insertByBo(bo));
    }

    /**
     * 修改个人剂量监测记录
     */
    @SaCheckPermission("system:radiationDoseRecord:edit")
    @Log(title = "个人剂量监测记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpRadiationDoseRecordBo bo) {
        return toAjax(mmpRadiationDoseRecordService.updateByBo(bo));
    }

    /**
     * 删除个人剂量监测记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:radiationDoseRecord:remove")
    @Log(title = "个人剂量监测记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpRadiationDoseRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
