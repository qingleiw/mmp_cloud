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
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyIncidentVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyIncidentBo;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyIncidentService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 突发事件记录
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/emergencyIncident")
public class MmpEmergencyIncidentController extends BaseController {

    private final IMmpEmergencyIncidentService mmpEmergencyIncidentService;

    /**
     * 查询突发事件记录列表
     */
    @SaCheckPermission("system:emergencyIncident:list")
    @GetMapping("/list")
    public TableDataInfo<MmpEmergencyIncidentVo> list(MmpEmergencyIncidentBo bo, PageQuery pageQuery) {
        return mmpEmergencyIncidentService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出突发事件记录列表
     */
    @SaCheckPermission("system:emergencyIncident:export")
    @Log(title = "突发事件记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpEmergencyIncidentBo bo, HttpServletResponse response) {
        List<MmpEmergencyIncidentVo> list = mmpEmergencyIncidentService.queryList(bo);
        ExcelUtil.exportExcel(list, "突发事件记录", MmpEmergencyIncidentVo.class, response);
    }

    /**
     * 获取突发事件记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:emergencyIncident:query")
    @GetMapping("/{id}")
    public R<MmpEmergencyIncidentVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpEmergencyIncidentService.queryById(id));
    }

    /**
     * 新增突发事件记录
     */
    @SaCheckPermission("system:emergencyIncident:add")
    @Log(title = "突发事件记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpEmergencyIncidentBo bo) {
        return toAjax(mmpEmergencyIncidentService.insertByBo(bo));
    }

    /**
     * 修改突发事件记录
     */
    @SaCheckPermission("system:emergencyIncident:edit")
    @Log(title = "突发事件记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpEmergencyIncidentBo bo) {
        return toAjax(mmpEmergencyIncidentService.updateByBo(bo));
    }

    /**
     * 删除突发事件记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:emergencyIncident:remove")
    @Log(title = "突发事件记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpEmergencyIncidentService.deleteWithValidByIds(List.of(ids), true));
    }
}
