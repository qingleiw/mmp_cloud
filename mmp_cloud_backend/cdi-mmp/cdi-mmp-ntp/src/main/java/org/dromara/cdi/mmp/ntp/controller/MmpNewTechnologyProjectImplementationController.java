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
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectImplementationVo;
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectImplementationBo;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectImplementationService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 新技术实施
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/newTechnologyProjectImplementation")
public class MmpNewTechnologyProjectImplementationController extends BaseController {

    private final IMmpNewTechnologyProjectImplementationService mmpNewTechnologyProjectImplementationService;

    /**
     * 查询新技术实施列表
     */
    @SaCheckPermission("system:newTechnologyProjectImplementation:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNewTechnologyProjectImplementationVo> list(MmpNewTechnologyProjectImplementationBo bo, PageQuery pageQuery) {
        return mmpNewTechnologyProjectImplementationService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出新技术实施列表
     */
    @SaCheckPermission("system:newTechnologyProjectImplementation:export")
    @Log(title = "新技术实施", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNewTechnologyProjectImplementationBo bo, HttpServletResponse response) {
        List<MmpNewTechnologyProjectImplementationVo> list = mmpNewTechnologyProjectImplementationService.queryList(bo);
        ExcelUtil.exportExcel(list, "新技术实施", MmpNewTechnologyProjectImplementationVo.class, response);
    }

    /**
     * 获取新技术实施详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:newTechnologyProjectImplementation:query")
    @GetMapping("/{id}")
    public R<MmpNewTechnologyProjectImplementationVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpNewTechnologyProjectImplementationService.queryById(id));
    }

    /**
     * 新增新技术实施
     */
    @SaCheckPermission("system:newTechnologyProjectImplementation:add")
    @Log(title = "新技术实施", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNewTechnologyProjectImplementationBo bo) {
        return toAjax(mmpNewTechnologyProjectImplementationService.insertByBo(bo));
    }

    /**
     * 修改新技术实施
     */
    @SaCheckPermission("system:newTechnologyProjectImplementation:edit")
    @Log(title = "新技术实施", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNewTechnologyProjectImplementationBo bo) {
        return toAjax(mmpNewTechnologyProjectImplementationService.updateByBo(bo));
    }

    /**
     * 删除新技术实施
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:newTechnologyProjectImplementation:remove")
    @Log(title = "新技术实施", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpNewTechnologyProjectImplementationService.deleteWithValidByIds(List.of(ids), true));
    }
}
