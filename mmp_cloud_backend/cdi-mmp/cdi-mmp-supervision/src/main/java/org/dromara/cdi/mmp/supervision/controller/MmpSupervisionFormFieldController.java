package org.dromara.cdi.mmp.supervision.controller;

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
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionFormFieldVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionFormFieldBo;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionFormFieldService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 督查单字段
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/supervisionFormField")
public class MmpSupervisionFormFieldController extends BaseController {

    private final IMmpSupervisionFormFieldService mmpSupervisionFormFieldService;

    /**
     * 查询督查单字段列表
     */
    @SaCheckPermission("system:supervisionFormField:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSupervisionFormFieldVo> list(MmpSupervisionFormFieldBo bo, PageQuery pageQuery) {
        return mmpSupervisionFormFieldService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出督查单字段列表
     */
    @SaCheckPermission("system:supervisionFormField:export")
    @Log(title = "督查单字段", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSupervisionFormFieldBo bo, HttpServletResponse response) {
        List<MmpSupervisionFormFieldVo> list = mmpSupervisionFormFieldService.queryList(bo);
        ExcelUtil.exportExcel(list, "督查单字段", MmpSupervisionFormFieldVo.class, response);
    }

    /**
     * 获取督查单字段详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:supervisionFormField:query")
    @GetMapping("/{id}")
    public R<MmpSupervisionFormFieldVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSupervisionFormFieldService.queryById(id));
    }

    /**
     * 新增督查单字段
     */
    @SaCheckPermission("system:supervisionFormField:add")
    @Log(title = "督查单字段", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSupervisionFormFieldBo bo) {
        return toAjax(mmpSupervisionFormFieldService.insertByBo(bo));
    }

    /**
     * 修改督查单字段
     */
    @SaCheckPermission("system:supervisionFormField:edit")
    @Log(title = "督查单字段", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSupervisionFormFieldBo bo) {
        return toAjax(mmpSupervisionFormFieldService.updateByBo(bo));
    }

    /**
     * 删除督查单字段
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:supervisionFormField:remove")
    @Log(title = "督查单字段", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSupervisionFormFieldService.deleteWithValidByIds(List.of(ids), true));
    }
}
