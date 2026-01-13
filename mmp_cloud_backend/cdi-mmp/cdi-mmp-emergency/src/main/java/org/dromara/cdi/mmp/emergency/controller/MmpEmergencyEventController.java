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
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyEventVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyEventBo;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyEventService;
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
@RequestMapping("/emergencyEvent")
public class MmpEmergencyEventController extends BaseController {

    private final IMmpEmergencyEventService mmpEmergencyEventService;

    /**
     * 查询突发事件记录列表
     */
    @SaCheckPermission("emergency:emergencyEvent:list")
    @GetMapping("/list")
    public TableDataInfo<MmpEmergencyEventVo> list(MmpEmergencyEventBo bo, PageQuery pageQuery) {
        return mmpEmergencyEventService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出突发事件记录列表
     */
    @SaCheckPermission("emergency:emergencyEvent:export")
    @Log(title = "突发事件记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpEmergencyEventBo bo, HttpServletResponse response) {
        List<MmpEmergencyEventVo> list = mmpEmergencyEventService.queryList(bo);
        ExcelUtil.exportExcel(list, "突发事件记录", MmpEmergencyEventVo.class, response);
    }

    /**
     * 获取突发事件记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("emergency:emergencyEvent:query")
    @GetMapping("/{id}")
    public R<MmpEmergencyEventVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpEmergencyEventService.queryById(id));
    }

    /**
     * 新增突发事件记录
     */
    @SaCheckPermission("emergency:emergencyEvent:add")
    @Log(title = "突发事件记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpEmergencyEventBo bo) {
        return toAjax(mmpEmergencyEventService.insertByBo(bo));
    }

    /**
     * 修改突发事件记录
     */
    @SaCheckPermission("emergency:emergencyEvent:edit")
    @Log(title = "突发事件记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpEmergencyEventBo bo) {
        return toAjax(mmpEmergencyEventService.updateByBo(bo));
    }

    /**
     * 删除突发事件记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("emergency:emergencyEvent:remove")
    @Log(title = "突发事件记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpEmergencyEventService.deleteWithValidByIds(List.of(ids), true));
    }
}
