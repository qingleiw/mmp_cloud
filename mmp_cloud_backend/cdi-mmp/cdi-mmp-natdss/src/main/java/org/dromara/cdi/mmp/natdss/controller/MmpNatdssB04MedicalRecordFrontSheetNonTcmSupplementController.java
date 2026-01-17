package org.dromara.cdi.mmp.natdss.controller;

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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B04非中医院-补充信息（其他手术+费用+扩展信息）
 * 前端访问路由地址为:/natdss/natdssB04MedicalRecordFrontSheetNonTcmSupplement
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB04MedicalRecordFrontSheetNonTcmSupplement")
public class MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementController extends BaseController {

    private final IMmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementService mmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementService;

    /**
     * 查询B04非中医院-补充信息（其他手术+费用+扩展信息）列表
     */
    @SaCheckPermission("natdss:natdssB04MedicalRecordFrontSheetNonTcmSupplement:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementVo> list(MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo bo, PageQuery pageQuery) {
        return mmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B04非中医院-补充信息（其他手术+费用+扩展信息）列表
     */
    @SaCheckPermission("natdss:natdssB04MedicalRecordFrontSheetNonTcmSupplement:export")
    @Log(title = "B04非中医院-补充信息（其他手术+费用+扩展信息）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo bo, HttpServletResponse response) {
        List<MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementVo> list = mmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementService.queryList(bo);
        ExcelUtil.exportExcel(list, "B04非中医院-补充信息（其他手术+费用+扩展信息）", MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementVo.class, response);
    }

    /**
     * 获取B04非中医院-补充信息（其他手术+费用+扩展信息）详细信息
     *
     * @param patientId 主键
     */
    @SaCheckPermission("natdss:natdssB04MedicalRecordFrontSheetNonTcmSupplement:query")
    @GetMapping("/{patientId}")
    public R<MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("patientId") String patientId) {
        return R.ok(mmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementService.queryById(patientId));
    }

    /**
     * 新增B04非中医院-补充信息（其他手术+费用+扩展信息）
     */
    @SaCheckPermission("natdss:natdssB04MedicalRecordFrontSheetNonTcmSupplement:add")
    @Log(title = "B04非中医院-补充信息（其他手术+费用+扩展信息）", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo bo) {
        return toAjax(mmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementService.insertByBo(bo));
    }

    /**
     * 修改B04非中医院-补充信息（其他手术+费用+扩展信息）
     */
    @SaCheckPermission("natdss:natdssB04MedicalRecordFrontSheetNonTcmSupplement:edit")
    @Log(title = "B04非中医院-补充信息（其他手术+费用+扩展信息）", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo bo) {
        return toAjax(mmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementService.updateByBo(bo));
    }

    /**
     * 删除B04非中医院-补充信息（其他手术+费用+扩展信息）
     *
     * @param patientIds 主键串
     */
    @SaCheckPermission("natdss:natdssB04MedicalRecordFrontSheetNonTcmSupplement:remove")
    @Log(title = "B04非中医院-补充信息（其他手术+费用+扩展信息）", businessType = BusinessType.DELETE)
    @DeleteMapping("/{patientIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("patientIds") String[] patientIds) {
        return toAjax(mmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementService.deleteWithValidByIds(List.of(patientIds), true));
    }
}
