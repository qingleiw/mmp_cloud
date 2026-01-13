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
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyTeamVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyTeamBo;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyTeamService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 应急队伍
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/emergencyTeam")
public class MmpEmergencyTeamController extends BaseController {

    private final IMmpEmergencyTeamService mmpEmergencyTeamService;

    /**
     * 查询应急队伍列表
     */
    @SaCheckPermission("emergency:emergencyTeam:list")
    @GetMapping("/list")
    public TableDataInfo<MmpEmergencyTeamVo> list(MmpEmergencyTeamBo bo, PageQuery pageQuery) {
        return mmpEmergencyTeamService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出应急队伍列表
     */
    @SaCheckPermission("emergency:emergencyTeam:export")
    @Log(title = "应急队伍", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpEmergencyTeamBo bo, HttpServletResponse response) {
        List<MmpEmergencyTeamVo> list = mmpEmergencyTeamService.queryList(bo);
        ExcelUtil.exportExcel(list, "应急队伍", MmpEmergencyTeamVo.class, response);
    }

    /**
     * 获取应急队伍详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("emergency:emergencyTeam:query")
    @GetMapping("/{id}")
    public R<MmpEmergencyTeamVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpEmergencyTeamService.queryById(id));
    }

    /**
     * 新增应急队伍
     */
    @SaCheckPermission("emergency:emergencyTeam:add")
    @Log(title = "应急队伍", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpEmergencyTeamBo bo) {
        return toAjax(mmpEmergencyTeamService.insertByBo(bo));
    }

    /**
     * 修改应急队伍
     */
    @SaCheckPermission("emergency:emergencyTeam:edit")
    @Log(title = "应急队伍", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpEmergencyTeamBo bo) {
        return toAjax(mmpEmergencyTeamService.updateByBo(bo));
    }

    /**
     * 删除应急队伍
     *
     * @param ids 主键串
     */
    @SaCheckPermission("emergency:emergencyTeam:remove")
    @Log(title = "应急队伍", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpEmergencyTeamService.deleteWithValidByIds(List.of(ids), true));
    }
}
