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
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionExpertMemberVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionExpertMemberBo;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionExpertMemberService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 专家组成员
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/supervisionExpertMember")
public class MmpSupervisionExpertMemberController extends BaseController {

    private final IMmpSupervisionExpertMemberService mmpSupervisionExpertMemberService;

    /**
     * 查询专家组成员列表
     */
    @SaCheckPermission("system:supervisionExpertMember:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSupervisionExpertMemberVo> list(MmpSupervisionExpertMemberBo bo, PageQuery pageQuery) {
        return mmpSupervisionExpertMemberService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出专家组成员列表
     */
    @SaCheckPermission("system:supervisionExpertMember:export")
    @Log(title = "专家组成员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSupervisionExpertMemberBo bo, HttpServletResponse response) {
        List<MmpSupervisionExpertMemberVo> list = mmpSupervisionExpertMemberService.queryList(bo);
        ExcelUtil.exportExcel(list, "专家组成员", MmpSupervisionExpertMemberVo.class, response);
    }

    /**
     * 获取专家组成员详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:supervisionExpertMember:query")
    @GetMapping("/{id}")
    public R<MmpSupervisionExpertMemberVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSupervisionExpertMemberService.queryById(id));
    }

    /**
     * 新增专家组成员
     */
    @SaCheckPermission("system:supervisionExpertMember:add")
    @Log(title = "专家组成员", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSupervisionExpertMemberBo bo) {
        return toAjax(mmpSupervisionExpertMemberService.insertByBo(bo));
    }

    /**
     * 修改专家组成员
     */
    @SaCheckPermission("system:supervisionExpertMember:edit")
    @Log(title = "专家组成员", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSupervisionExpertMemberBo bo) {
        return toAjax(mmpSupervisionExpertMemberService.updateByBo(bo));
    }

    /**
     * 删除专家组成员
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:supervisionExpertMember:remove")
    @Log(title = "专家组成员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSupervisionExpertMemberService.deleteWithValidByIds(List.of(ids), true));
    }
}
