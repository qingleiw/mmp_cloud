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
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectMappingVo;
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectMappingBo;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectMappingService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 新技术项目对码
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/newTechnologyProjectMapping")
public class MmpNewTechnologyProjectMappingController extends BaseController {

    private final IMmpNewTechnologyProjectMappingService mmpNewTechnologyProjectMappingService;

    /**
     * 查询新技术项目对码列表
     */
    @SaCheckPermission("system:newTechnologyProjectMapping:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNewTechnologyProjectMappingVo> list(MmpNewTechnologyProjectMappingBo bo, PageQuery pageQuery) {
        return mmpNewTechnologyProjectMappingService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出新技术项目对码列表
     */
    @SaCheckPermission("system:newTechnologyProjectMapping:export")
    @Log(title = "新技术项目对码", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNewTechnologyProjectMappingBo bo, HttpServletResponse response) {
        List<MmpNewTechnologyProjectMappingVo> list = mmpNewTechnologyProjectMappingService.queryList(bo);
        ExcelUtil.exportExcel(list, "新技术项目对码", MmpNewTechnologyProjectMappingVo.class, response);
    }

    /**
     * 获取新技术项目对码详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:newTechnologyProjectMapping:query")
    @GetMapping("/{id}")
    public R<MmpNewTechnologyProjectMappingVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpNewTechnologyProjectMappingService.queryById(id));
    }

    /**
     * 新增新技术项目对码
     */
    @SaCheckPermission("system:newTechnologyProjectMapping:add")
    @Log(title = "新技术项目对码", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNewTechnologyProjectMappingBo bo) {
        return toAjax(mmpNewTechnologyProjectMappingService.insertByBo(bo));
    }

    /**
     * 修改新技术项目对码
     */
    @SaCheckPermission("system:newTechnologyProjectMapping:edit")
    @Log(title = "新技术项目对码", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNewTechnologyProjectMappingBo bo) {
        return toAjax(mmpNewTechnologyProjectMappingService.updateByBo(bo));
    }

    /**
     * 删除新技术项目对码
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:newTechnologyProjectMapping:remove")
    @Log(title = "新技术项目对码", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpNewTechnologyProjectMappingService.deleteWithValidByIds(List.of(ids), true));
    }
}
