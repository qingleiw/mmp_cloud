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
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationAuthorizationApplyVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationAuthorizationApplyBo;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationAuthorizationApplyService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资质授权申请
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/qualificationAuthorizationApply")
public class MmpQualificationAuthorizationApplyController extends BaseController {

    private final IMmpQualificationAuthorizationApplyService mmpQualificationAuthorizationApplyService;

    /**
     * 查询资质授权申请列表
     */
    @SaCheckPermission("qualification:qualificationAuthorizationApply:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQualificationAuthorizationApplyVo> list(MmpQualificationAuthorizationApplyBo bo, PageQuery pageQuery) {
        return mmpQualificationAuthorizationApplyService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资质授权申请列表
     */
    @SaCheckPermission("qualification:qualificationAuthorizationApply:export")
    @Log(title = "资质授权申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQualificationAuthorizationApplyBo bo, HttpServletResponse response) {
        List<MmpQualificationAuthorizationApplyVo> list = mmpQualificationAuthorizationApplyService.queryList(bo);
        ExcelUtil.exportExcel(list, "资质授权申请", MmpQualificationAuthorizationApplyVo.class, response);
    }

    /**
     * 获取资质授权申请详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("qualification:qualificationAuthorizationApply:query")
    @GetMapping("/{id}")
    public R<MmpQualificationAuthorizationApplyVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQualificationAuthorizationApplyService.queryById(id));
    }

    /**
     * 新增资质授权申请
     */
    @SaCheckPermission("qualification:qualificationAuthorizationApply:add")
    @Log(title = "资质授权申请", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQualificationAuthorizationApplyBo bo) {
        return toAjax(mmpQualificationAuthorizationApplyService.insertByBo(bo));
    }

    /**
     * 修改资质授权申请
     */
    @SaCheckPermission("qualification:qualificationAuthorizationApply:edit")
    @Log(title = "资质授权申请", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQualificationAuthorizationApplyBo bo) {
        return toAjax(mmpQualificationAuthorizationApplyService.updateByBo(bo));
    }

    /**
     * 删除资质授权申请
     *
     * @param ids 主键串
     */
    @SaCheckPermission("qualification:qualificationAuthorizationApply:remove")
    @Log(title = "资质授权申请", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQualificationAuthorizationApplyService.deleteWithValidByIds(List.of(ids), true));
    }
}
