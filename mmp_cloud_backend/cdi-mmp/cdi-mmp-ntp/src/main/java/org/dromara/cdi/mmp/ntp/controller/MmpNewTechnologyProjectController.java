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
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectVo;
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectBo;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 新技术项目基本信息
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/newTechnologyProject")
public class MmpNewTechnologyProjectController extends BaseController {

    private final IMmpNewTechnologyProjectService mmpNewTechnologyProjectService;

    /**
     * 查询新技术项目基本信息列表
     */
    @SaCheckPermission("ntp:newTechnologyProject:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNewTechnologyProjectVo> list(MmpNewTechnologyProjectBo bo, PageQuery pageQuery) {
        return mmpNewTechnologyProjectService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出新技术项目基本信息列表
     */
    @SaCheckPermission("ntp:newTechnologyProject:export")
    @Log(title = "新技术项目基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNewTechnologyProjectBo bo, HttpServletResponse response) {
        List<MmpNewTechnologyProjectVo> list = mmpNewTechnologyProjectService.queryList(bo);
        ExcelUtil.exportExcel(list, "新技术项目基本信息", MmpNewTechnologyProjectVo.class, response);
    }

    /**
     * 获取新技术项目基本信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("ntp:newTechnologyProject:query")
    @GetMapping("/{id}")
    public R<MmpNewTechnologyProjectVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpNewTechnologyProjectService.queryById(id));
    }

    /**
     * 新增新技术项目基本信息
     */
    @SaCheckPermission("ntp:newTechnologyProject:add")
    @Log(title = "新技术项目基本信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNewTechnologyProjectBo bo) {
        return toAjax(mmpNewTechnologyProjectService.insertByBo(bo));
    }

    /**
     * 修改新技术项目基本信息
     */
    @SaCheckPermission("ntp:newTechnologyProject:edit")
    @Log(title = "新技术项目基本信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNewTechnologyProjectBo bo) {
        return toAjax(mmpNewTechnologyProjectService.updateByBo(bo));
    }

    /**
     * 删除新技术项目基本信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("ntp:newTechnologyProject:remove")
    @Log(title = "新技术项目基本信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpNewTechnologyProjectService.deleteWithValidByIds(List.of(ids), true));
    }
}
