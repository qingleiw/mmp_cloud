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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB04MedicalRecordFrontSheetNonTcmVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB04MedicalRecordFrontSheetNonTcmBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB04MedicalRecordFrontSheetNonTcmService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
 * 前端访问路由地址为:/natdss/natdssB04MedicalRecordFrontSheetNonTcm
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB04MedicalRecordFrontSheetNonTcm")
public class MmpNatdssB04MedicalRecordFrontSheetNonTcmController extends BaseController {

    private final IMmpNatdssB04MedicalRecordFrontSheetNonTcmService mmpNatdssB04MedicalRecordFrontSheetNonTcmService;

    /**
     * 查询B04病历首页-核心信息-非中医院（基础+诊断+主要手术）列表
     */
    @SaCheckPermission("natdss:natdssB04MedicalRecordFrontSheetNonTcm:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB04MedicalRecordFrontSheetNonTcmVo> list(MmpNatdssB04MedicalRecordFrontSheetNonTcmBo bo, PageQuery pageQuery) {
        return mmpNatdssB04MedicalRecordFrontSheetNonTcmService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B04病历首页-核心信息-非中医院（基础+诊断+主要手术）列表
     */
    @SaCheckPermission("natdss:natdssB04MedicalRecordFrontSheetNonTcm:export")
    @Log(title = "B04病历首页-核心信息-非中医院（基础+诊断+主要手术）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB04MedicalRecordFrontSheetNonTcmBo bo, HttpServletResponse response) {
        List<MmpNatdssB04MedicalRecordFrontSheetNonTcmVo> list = mmpNatdssB04MedicalRecordFrontSheetNonTcmService.queryList(bo);
        ExcelUtil.exportExcel(list, "B04病历首页-核心信息-非中医院（基础+诊断+主要手术）", MmpNatdssB04MedicalRecordFrontSheetNonTcmVo.class, response);
    }

    /**
     * 获取B04病历首页-核心信息-非中医院（基础+诊断+主要手术）详细信息
     *
     * @param patientId 主键
     */
    @SaCheckPermission("natdss:natdssB04MedicalRecordFrontSheetNonTcm:query")
    @GetMapping("/{patientId}")
    public R<MmpNatdssB04MedicalRecordFrontSheetNonTcmVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("patientId") String patientId) {
        return R.ok(mmpNatdssB04MedicalRecordFrontSheetNonTcmService.queryById(patientId));
    }

    /**
     * 新增B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
     */
    @SaCheckPermission("natdss:natdssB04MedicalRecordFrontSheetNonTcm:add")
    @Log(title = "B04病历首页-核心信息-非中医院（基础+诊断+主要手术）", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB04MedicalRecordFrontSheetNonTcmBo bo) {
        return toAjax(mmpNatdssB04MedicalRecordFrontSheetNonTcmService.insertByBo(bo));
    }

    /**
     * 修改B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
     */
    @SaCheckPermission("natdss:natdssB04MedicalRecordFrontSheetNonTcm:edit")
    @Log(title = "B04病历首页-核心信息-非中医院（基础+诊断+主要手术）", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB04MedicalRecordFrontSheetNonTcmBo bo) {
        return toAjax(mmpNatdssB04MedicalRecordFrontSheetNonTcmService.updateByBo(bo));
    }

    /**
     * 删除B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
     *
     * @param patientIds 主键串
     */
    @SaCheckPermission("natdss:natdssB04MedicalRecordFrontSheetNonTcm:remove")
    @Log(title = "B04病历首页-核心信息-非中医院（基础+诊断+主要手术）", businessType = BusinessType.DELETE)
    @DeleteMapping("/{patientIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("patientIds") String[] patientIds) {
        return toAjax(mmpNatdssB04MedicalRecordFrontSheetNonTcmService.deleteWithValidByIds(List.of(patientIds), true));
    }
}
