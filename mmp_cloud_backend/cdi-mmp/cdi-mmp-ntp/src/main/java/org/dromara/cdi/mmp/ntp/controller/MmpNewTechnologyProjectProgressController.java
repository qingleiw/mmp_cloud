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
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectProgressVo;
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectProgressBo;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectProgressService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 新技术进展报告
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/newTechnologyProjectProgress")
public class MmpNewTechnologyProjectProgressController extends BaseController {

    private final IMmpNewTechnologyProjectProgressService mmpNewTechnologyProjectProgressService;

    /**
     * 查询新技术进展报告列表
     */
    @SaCheckPermission("ntp:newTechnologyProjectProgress:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNewTechnologyProjectProgressVo> list(MmpNewTechnologyProjectProgressBo bo, PageQuery pageQuery) {
        return mmpNewTechnologyProjectProgressService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出新技术进展报告列表
     */
    @SaCheckPermission("ntp:newTechnologyProjectProgress:export")
    @Log(title = "新技术进展报告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNewTechnologyProjectProgressBo bo, HttpServletResponse response) {
        List<MmpNewTechnologyProjectProgressVo> list = mmpNewTechnologyProjectProgressService.queryList(bo);
        ExcelUtil.exportExcel(list, "新技术进展报告", MmpNewTechnologyProjectProgressVo.class, response);
    }

    /**
     * 获取新技术进展报告详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("ntp:newTechnologyProjectProgress:query")
    @GetMapping("/{id}")
    public R<MmpNewTechnologyProjectProgressVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpNewTechnologyProjectProgressService.queryById(id));
    }

    /**
     * 新增新技术进展报告
     */
    @SaCheckPermission("ntp:newTechnologyProjectProgress:add")
    @Log(title = "新技术进展报告", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNewTechnologyProjectProgressBo bo) {
        return toAjax(mmpNewTechnologyProjectProgressService.insertByBo(bo));
    }

    /**
     * 修改新技术进展报告
     */
    @SaCheckPermission("ntp:newTechnologyProjectProgress:edit")
    @Log(title = "新技术进展报告", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNewTechnologyProjectProgressBo bo) {
        return toAjax(mmpNewTechnologyProjectProgressService.updateByBo(bo));
    }

    /**
     * 删除新技术进展报告
     *
     * @param ids 主键串
     */
    @SaCheckPermission("ntp:newTechnologyProjectProgress:remove")
    @Log(title = "新技术进展报告", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpNewTechnologyProjectProgressService.deleteWithValidByIds(List.of(ids), true));
    }
}
