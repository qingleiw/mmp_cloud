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
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationAuthorizationRecordVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationAuthorizationRecordBo;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationAuthorizationRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资质授权记录
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/qualificationAuthorizationRecord")
public class MmpQualificationAuthorizationRecordController extends BaseController {

    private final IMmpQualificationAuthorizationRecordService mmpQualificationAuthorizationRecordService;

    /**
     * 查询资质授权记录列表
     */
    @SaCheckPermission("qualification:qualificationAuthorizationRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQualificationAuthorizationRecordVo> list(MmpQualificationAuthorizationRecordBo bo, PageQuery pageQuery) {
        return mmpQualificationAuthorizationRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资质授权记录列表
     */
    @SaCheckPermission("qualification:qualificationAuthorizationRecord:export")
    @Log(title = "资质授权记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQualificationAuthorizationRecordBo bo, HttpServletResponse response) {
        List<MmpQualificationAuthorizationRecordVo> list = mmpQualificationAuthorizationRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "资质授权记录", MmpQualificationAuthorizationRecordVo.class, response);
    }

    /**
     * 获取资质授权记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("qualification:qualificationAuthorizationRecord:query")
    @GetMapping("/{id}")
    public R<MmpQualificationAuthorizationRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQualificationAuthorizationRecordService.queryById(id));
    }

    /**
     * 新增资质授权记录
     */
    @SaCheckPermission("qualification:qualificationAuthorizationRecord:add")
    @Log(title = "资质授权记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQualificationAuthorizationRecordBo bo) {
        return toAjax(mmpQualificationAuthorizationRecordService.insertByBo(bo));
    }

    /**
     * 修改资质授权记录
     */
    @SaCheckPermission("qualification:qualificationAuthorizationRecord:edit")
    @Log(title = "资质授权记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQualificationAuthorizationRecordBo bo) {
        return toAjax(mmpQualificationAuthorizationRecordService.updateByBo(bo));
    }

    /**
     * 删除资质授权记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("qualification:qualificationAuthorizationRecord:remove")
    @Log(title = "资质授权记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQualificationAuthorizationRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
