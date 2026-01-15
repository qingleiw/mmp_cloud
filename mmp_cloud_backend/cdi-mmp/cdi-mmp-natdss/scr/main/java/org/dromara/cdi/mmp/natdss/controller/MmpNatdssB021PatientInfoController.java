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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB021PatientInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB021PatientInfoBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB021PatientInfoService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B02-1 患者就诊基本信息
 * 前端访问路由地址为:/natdss/natdssB021PatientInfo
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB021PatientInfo")
public class MmpNatdssB021PatientInfoController extends BaseController {

    private final IMmpNatdssB021PatientInfoService mmpNatdssB021PatientInfoService;

    /**
     * 查询B02-1 患者就诊基本信息列表
     */
    @SaCheckPermission("natdss:natdssB021PatientInfo:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB021PatientInfoVo> list(MmpNatdssB021PatientInfoBo bo, PageQuery pageQuery) {
        return mmpNatdssB021PatientInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B02-1 患者就诊基本信息列表
     */
    @SaCheckPermission("natdss:natdssB021PatientInfo:export")
    @Log(title = "B02-1 患者就诊基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB021PatientInfoBo bo, HttpServletResponse response) {
        List<MmpNatdssB021PatientInfoVo> list = mmpNatdssB021PatientInfoService.queryList(bo);
        ExcelUtil.exportExcel(list, "B02-1 患者就诊基本信息", MmpNatdssB021PatientInfoVo.class, response);
    }

    /**
     * 获取B02-1 患者就诊基本信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB021PatientInfo:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB021PatientInfoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB021PatientInfoService.queryById(id));
    }

    /**
     * 新增B02-1 患者就诊基本信息
     */
    @SaCheckPermission("natdss:natdssB021PatientInfo:add")
    @Log(title = "B02-1 患者就诊基本信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB021PatientInfoBo bo) {
        return toAjax(mmpNatdssB021PatientInfoService.insertByBo(bo));
    }

    /**
     * 修改B02-1 患者就诊基本信息
     */
    @SaCheckPermission("natdss:natdssB021PatientInfo:edit")
    @Log(title = "B02-1 患者就诊基本信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB021PatientInfoBo bo) {
        return toAjax(mmpNatdssB021PatientInfoService.updateByBo(bo));
    }

    /**
     * 删除B02-1 患者就诊基本信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB021PatientInfo:remove")
    @Log(title = "B02-1 患者就诊基本信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB021PatientInfoService.deleteWithValidByIds(List.of(ids), true));
    }
}
