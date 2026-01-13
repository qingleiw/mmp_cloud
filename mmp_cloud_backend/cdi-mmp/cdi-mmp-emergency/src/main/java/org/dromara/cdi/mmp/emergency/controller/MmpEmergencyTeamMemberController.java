package org.dromara.cdi.mmp.emergency.controller;

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
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyTeamMemberVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyTeamMemberBo;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyTeamMemberService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 应急队伍成员
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/emergencyTeamMember")
public class MmpEmergencyTeamMemberController extends BaseController {

    private final IMmpEmergencyTeamMemberService mmpEmergencyTeamMemberService;

    /**
     * 查询应急队伍成员列表
     */
    @SaCheckPermission("emergency:emergencyTeamMember:list")
    @GetMapping("/list")
    public TableDataInfo<MmpEmergencyTeamMemberVo> list(MmpEmergencyTeamMemberBo bo, PageQuery pageQuery) {
        return mmpEmergencyTeamMemberService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出应急队伍成员列表
     */
    @SaCheckPermission("emergency:emergencyTeamMember:export")
    @Log(title = "应急队伍成员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpEmergencyTeamMemberBo bo, HttpServletResponse response) {
        List<MmpEmergencyTeamMemberVo> list = mmpEmergencyTeamMemberService.queryList(bo);
        ExcelUtil.exportExcel(list, "应急队伍成员", MmpEmergencyTeamMemberVo.class, response);
    }

    /**
     * 获取应急队伍成员详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("emergency:emergencyTeamMember:query")
    @GetMapping("/{id}")
    public R<MmpEmergencyTeamMemberVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpEmergencyTeamMemberService.queryById(id));
    }

    /**
     * 新增应急队伍成员
     */
    @SaCheckPermission("emergency:emergencyTeamMember:add")
    @Log(title = "应急队伍成员", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpEmergencyTeamMemberBo bo) {
        return toAjax(mmpEmergencyTeamMemberService.insertByBo(bo));
    }

    /**
     * 修改应急队伍成员
     */
    @SaCheckPermission("emergency:emergencyTeamMember:edit")
    @Log(title = "应急队伍成员", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpEmergencyTeamMemberBo bo) {
        return toAjax(mmpEmergencyTeamMemberService.updateByBo(bo));
    }

    /**
     * 删除应急队伍成员
     *
     * @param ids 主键串
     */
    @SaCheckPermission("emergency:emergencyTeamMember:remove")
    @Log(title = "应急队伍成员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpEmergencyTeamMemberService.deleteWithValidByIds(List.of(ids), true));
    }
}
