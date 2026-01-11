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
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionExpertGroupVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionExpertGroupBo;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionExpertGroupService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 专家组
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/supervisionExpertGroup")
public class MmpSupervisionExpertGroupController extends BaseController {

    private final IMmpSupervisionExpertGroupService mmpSupervisionExpertGroupService;

    /**
     * 查询专家组列表
     */
    @SaCheckPermission("system:supervisionExpertGroup:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSupervisionExpertGroupVo> list(MmpSupervisionExpertGroupBo bo, PageQuery pageQuery) {
        return mmpSupervisionExpertGroupService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出专家组列表
     */
    @SaCheckPermission("system:supervisionExpertGroup:export")
    @Log(title = "专家组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSupervisionExpertGroupBo bo, HttpServletResponse response) {
        List<MmpSupervisionExpertGroupVo> list = mmpSupervisionExpertGroupService.queryList(bo);
        ExcelUtil.exportExcel(list, "专家组", MmpSupervisionExpertGroupVo.class, response);
    }

    /**
     * 获取专家组详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:supervisionExpertGroup:query")
    @GetMapping("/{id}")
    public R<MmpSupervisionExpertGroupVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSupervisionExpertGroupService.queryById(id));
    }

    /**
     * 新增专家组
     */
    @SaCheckPermission("system:supervisionExpertGroup:add")
    @Log(title = "专家组", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSupervisionExpertGroupBo bo) {
        return toAjax(mmpSupervisionExpertGroupService.insertByBo(bo));
    }

    /**
     * 修改专家组
     */
    @SaCheckPermission("system:supervisionExpertGroup:edit")
    @Log(title = "专家组", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSupervisionExpertGroupBo bo) {
        return toAjax(mmpSupervisionExpertGroupService.updateByBo(bo));
    }

    /**
     * 删除专家组
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:supervisionExpertGroup:remove")
    @Log(title = "专家组", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSupervisionExpertGroupService.deleteWithValidByIds(List.of(ids), true));
    }
}
