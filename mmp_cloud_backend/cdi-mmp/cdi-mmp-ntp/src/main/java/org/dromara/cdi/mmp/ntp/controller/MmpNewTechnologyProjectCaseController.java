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
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectCaseVo;
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectCaseBo;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectCaseService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 新技术病例登记
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/newTechnologyProjectCase")
public class MmpNewTechnologyProjectCaseController extends BaseController {

    private final IMmpNewTechnologyProjectCaseService mmpNewTechnologyProjectCaseService;

    /**
     * 查询新技术病例登记列表
     */
    @SaCheckPermission("system:newTechnologyProjectCase:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNewTechnologyProjectCaseVo> list(MmpNewTechnologyProjectCaseBo bo, PageQuery pageQuery) {
        return mmpNewTechnologyProjectCaseService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出新技术病例登记列表
     */
    @SaCheckPermission("system:newTechnologyProjectCase:export")
    @Log(title = "新技术病例登记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNewTechnologyProjectCaseBo bo, HttpServletResponse response) {
        List<MmpNewTechnologyProjectCaseVo> list = mmpNewTechnologyProjectCaseService.queryList(bo);
        ExcelUtil.exportExcel(list, "新技术病例登记", MmpNewTechnologyProjectCaseVo.class, response);
    }

    /**
     * 获取新技术病例登记详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:newTechnologyProjectCase:query")
    @GetMapping("/{id}")
    public R<MmpNewTechnologyProjectCaseVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpNewTechnologyProjectCaseService.queryById(id));
    }

    /**
     * 新增新技术病例登记
     */
    @SaCheckPermission("system:newTechnologyProjectCase:add")
    @Log(title = "新技术病例登记", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNewTechnologyProjectCaseBo bo) {
        return toAjax(mmpNewTechnologyProjectCaseService.insertByBo(bo));
    }

    /**
     * 修改新技术病例登记
     */
    @SaCheckPermission("system:newTechnologyProjectCase:edit")
    @Log(title = "新技术病例登记", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNewTechnologyProjectCaseBo bo) {
        return toAjax(mmpNewTechnologyProjectCaseService.updateByBo(bo));
    }

    /**
     * 删除新技术病例登记
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:newTechnologyProjectCase:remove")
    @Log(title = "新技术病例登记", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpNewTechnologyProjectCaseService.deleteWithValidByIds(List.of(ids), true));
    }
}
