package org.dromara.cdi.mmp.qualification.controller;

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
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationAdmissionConditionVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationAdmissionConditionBo;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationAdmissionConditionService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资质准入条件
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/qualificationAdmissionCondition")
public class MmpQualificationAdmissionConditionController extends BaseController {

    private final IMmpQualificationAdmissionConditionService mmpQualificationAdmissionConditionService;

    /**
     * 查询资质准入条件列表
     */
    @SaCheckPermission("system:qualificationAdmissionCondition:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQualificationAdmissionConditionVo> list(MmpQualificationAdmissionConditionBo bo, PageQuery pageQuery) {
        return mmpQualificationAdmissionConditionService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资质准入条件列表
     */
    @SaCheckPermission("system:qualificationAdmissionCondition:export")
    @Log(title = "资质准入条件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQualificationAdmissionConditionBo bo, HttpServletResponse response) {
        List<MmpQualificationAdmissionConditionVo> list = mmpQualificationAdmissionConditionService.queryList(bo);
        ExcelUtil.exportExcel(list, "资质准入条件", MmpQualificationAdmissionConditionVo.class, response);
    }

    /**
     * 获取资质准入条件详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:qualificationAdmissionCondition:query")
    @GetMapping("/{id}")
    public R<MmpQualificationAdmissionConditionVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQualificationAdmissionConditionService.queryById(id));
    }

    /**
     * 新增资质准入条件
     */
    @SaCheckPermission("system:qualificationAdmissionCondition:add")
    @Log(title = "资质准入条件", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQualificationAdmissionConditionBo bo) {
        return toAjax(mmpQualificationAdmissionConditionService.insertByBo(bo));
    }

    /**
     * 修改资质准入条件
     */
    @SaCheckPermission("system:qualificationAdmissionCondition:edit")
    @Log(title = "资质准入条件", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQualificationAdmissionConditionBo bo) {
        return toAjax(mmpQualificationAdmissionConditionService.updateByBo(bo));
    }

    /**
     * 删除资质准入条件
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:qualificationAdmissionCondition:remove")
    @Log(title = "资质准入条件", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQualificationAdmissionConditionService.deleteWithValidByIds(List.of(ids), true));
    }
}
