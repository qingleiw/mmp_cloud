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
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationStaffVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationStaffBo;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationStaffService;
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
@RequestMapping("/radiationStaff")
public class MmpRadiationStaffController extends BaseController {

    private final IMmpRadiationStaffService mmpRadiationStaffService;

    /**
     * 查询放射工作人员列表
     */
    @SaCheckPermission("radiation:radiationStaff:list")
    @GetMapping("/list")
    public TableDataInfo<MmpRadiationStaffVo> list(MmpRadiationStaffBo bo, PageQuery pageQuery) {
        return mmpRadiationStaffService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出放射工作人员列表
     */
    @SaCheckPermission("radiation:radiationStaff:export")
    @Log(title = "放射工作人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpRadiationStaffBo bo, HttpServletResponse response) {
        List<MmpRadiationStaffVo> list = mmpRadiationStaffService.queryList(bo);
        ExcelUtil.exportExcel(list, "放射工作人员", MmpRadiationStaffVo.class, response);
    }

    /**
     * 获取放射工作人员详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("radiation:radiationStaff:query")
    @GetMapping("/{id}")
    public R<MmpRadiationStaffVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpRadiationStaffService.queryById(id));
    }

    /**
     * 新增放射工作人员
     */
    @SaCheckPermission("radiation:radiationStaff:add")
    @Log(title = "放射工作人员", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpRadiationStaffBo bo) {
        return toAjax(mmpRadiationStaffService.insertByBo(bo));
    }

    /**
     * 修改放射工作人员
     */
    @SaCheckPermission("radiation:radiationStaff:edit")
    @Log(title = "放射工作人员", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpRadiationStaffBo bo) {
        return toAjax(mmpRadiationStaffService.updateByBo(bo));
    }

    /**
     * 删除放射工作人员
     *
     * @param ids 主键串
     */
    @SaCheckPermission("radiation:radiationStaff:remove")
    @Log(title = "放射工作人员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpRadiationStaffService.deleteWithValidByIds(List.of(ids), true));
    }
}
