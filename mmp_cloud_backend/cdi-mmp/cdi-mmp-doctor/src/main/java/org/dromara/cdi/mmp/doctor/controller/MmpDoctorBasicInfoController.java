package org.dromara.cdi.mmp.doctor.controller;

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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorBasicInfoVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorBasicInfoBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorInfoVo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorBasicInfoService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 医师基本信息
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctor/doctorBasicInfo")
public class MmpDoctorBasicInfoController extends BaseController {

    private final IMmpDoctorBasicInfoService mmpDoctorBasicInfoService;

    /**
     * 查询医师基本信息列表
     */
    @SaCheckPermission("doctor:doctorInfo:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorBasicInfoVo> list(MmpDoctorBasicInfoBo bo, PageQuery pageQuery) {
        return mmpDoctorBasicInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出医师基本信息列表
     */
    @SaCheckPermission("doctor:doctorInfo:export")
    @Log(title = "医师基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorBasicInfoBo bo, HttpServletResponse response) {
        List<MmpDoctorBasicInfoVo> list = mmpDoctorBasicInfoService.queryList(bo);
        ExcelUtil.exportExcel(list, "医师基本信息", MmpDoctorBasicInfoVo.class, response);
    }

    /**
     * 获取医师基本信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorInfo:query")
    @GetMapping("/{id}")
    public R<MmpDoctorBasicInfoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorBasicInfoService.queryById(id));
    }

    /**
     * 新增医师基本信息
     */
    @SaCheckPermission("doctor:doctorInfo:add")
    @Log(title = "医师基本信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorBasicInfoBo bo) {
        return toAjax(mmpDoctorBasicInfoService.insertByBo(bo));
    }

    /**
     * 修改医师基本信息
     */
    @SaCheckPermission("doctor:doctorInfo:edit")
    @Log(title = "医师基本信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorBasicInfoBo bo) {
        return toAjax(mmpDoctorBasicInfoService.updateByBo(bo));
    }

    /**
     * 删除医师基本信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorInfo:remove")
    @Log(title = "医师基本信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorBasicInfoService.deleteWithValidByIds(List.of(ids), true));
    }
    /**
     * 获取医师档案信息
     *
     * @param doctorId 医师ID
     */
    @SaCheckPermission("doctor:doctorInfo:query")
    @GetMapping("/archive/{doctorId}")
    public R<MmpDoctorInfoVo> getArchive(@NotNull(message = "医师ID不能为空")
                                             @PathVariable Long doctorId) {
        return R.ok(mmpDoctorBasicInfoService.getDoctorArchive(doctorId));
    }}
