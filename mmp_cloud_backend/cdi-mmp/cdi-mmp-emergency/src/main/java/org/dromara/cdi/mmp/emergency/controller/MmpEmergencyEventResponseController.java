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
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyEventResponseVo;
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyEventResponseBo;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyEventResponseService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 突发事件响应
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/emergencyEventResponse")
public class MmpEmergencyEventResponseController extends BaseController {

    private final IMmpEmergencyEventResponseService mmpEmergencyEventResponseService;

    /**
     * 查询突发事件响应列表
     */
    @SaCheckPermission("system:emergencyEventResponse:list")
    @GetMapping("/list")
    public TableDataInfo<MmpEmergencyEventResponseVo> list(MmpEmergencyEventResponseBo bo, PageQuery pageQuery) {
        return mmpEmergencyEventResponseService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出突发事件响应列表
     */
    @SaCheckPermission("system:emergencyEventResponse:export")
    @Log(title = "突发事件响应", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpEmergencyEventResponseBo bo, HttpServletResponse response) {
        List<MmpEmergencyEventResponseVo> list = mmpEmergencyEventResponseService.queryList(bo);
        ExcelUtil.exportExcel(list, "突发事件响应", MmpEmergencyEventResponseVo.class, response);
    }

    /**
     * 获取突发事件响应详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:emergencyEventResponse:query")
    @GetMapping("/{id}")
    public R<MmpEmergencyEventResponseVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpEmergencyEventResponseService.queryById(id));
    }

    /**
     * 新增突发事件响应
     */
    @SaCheckPermission("system:emergencyEventResponse:add")
    @Log(title = "突发事件响应", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpEmergencyEventResponseBo bo) {
        return toAjax(mmpEmergencyEventResponseService.insertByBo(bo));
    }

    /**
     * 修改突发事件响应
     */
    @SaCheckPermission("system:emergencyEventResponse:edit")
    @Log(title = "突发事件响应", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpEmergencyEventResponseBo bo) {
        return toAjax(mmpEmergencyEventResponseService.updateByBo(bo));
    }

    /**
     * 删除突发事件响应
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:emergencyEventResponse:remove")
    @Log(title = "突发事件响应", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpEmergencyEventResponseService.deleteWithValidByIds(List.of(ids), true));
    }
}
