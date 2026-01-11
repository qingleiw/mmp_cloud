package org.dromara.cdi.mmp.surgery.controller;

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
import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryApprovalFormVo;
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryApprovalFormBo;
import org.dromara.cdi.mmp.surgery.service.IMmpSurgeryApprovalFormService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 重大手术审批报告单
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/surgeryApprovalForm")
public class MmpSurgeryApprovalFormController extends BaseController {

    private final IMmpSurgeryApprovalFormService mmpSurgeryApprovalFormService;

    /**
     * 查询重大手术审批报告单列表
     */
    @SaCheckPermission("system:surgeryApprovalForm:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSurgeryApprovalFormVo> list(MmpSurgeryApprovalFormBo bo, PageQuery pageQuery) {
        return mmpSurgeryApprovalFormService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出重大手术审批报告单列表
     */
    @SaCheckPermission("system:surgeryApprovalForm:export")
    @Log(title = "重大手术审批报告单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSurgeryApprovalFormBo bo, HttpServletResponse response) {
        List<MmpSurgeryApprovalFormVo> list = mmpSurgeryApprovalFormService.queryList(bo);
        ExcelUtil.exportExcel(list, "重大手术审批报告单", MmpSurgeryApprovalFormVo.class, response);
    }

    /**
     * 获取重大手术审批报告单详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:surgeryApprovalForm:query")
    @GetMapping("/{id}")
    public R<MmpSurgeryApprovalFormVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSurgeryApprovalFormService.queryById(id));
    }

    /**
     * 新增重大手术审批报告单
     */
    @SaCheckPermission("system:surgeryApprovalForm:add")
    @Log(title = "重大手术审批报告单", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSurgeryApprovalFormBo bo) {
        return toAjax(mmpSurgeryApprovalFormService.insertByBo(bo));
    }

    /**
     * 修改重大手术审批报告单
     */
    @SaCheckPermission("system:surgeryApprovalForm:edit")
    @Log(title = "重大手术审批报告单", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSurgeryApprovalFormBo bo) {
        return toAjax(mmpSurgeryApprovalFormService.updateByBo(bo));
    }

    /**
     * 删除重大手术审批报告单
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:surgeryApprovalForm:remove")
    @Log(title = "重大手术审批报告单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSurgeryApprovalFormService.deleteWithValidByIds(List.of(ids), true));
    }
}
