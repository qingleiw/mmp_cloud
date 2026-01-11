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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorElectronicRegistrationVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorElectronicRegistrationBo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorElectronicRegistrationService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 医师电子化注册
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctorElectronicRegistration")
public class MmpDoctorElectronicRegistrationController extends BaseController {

    private final IMmpDoctorElectronicRegistrationService mmpDoctorElectronicRegistrationService;

    /**
     * 查询医师电子化注册列表
     */
    @SaCheckPermission("doctor:doctorElectronicRegistration:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorElectronicRegistrationVo> list(MmpDoctorElectronicRegistrationBo bo, PageQuery pageQuery) {
        return mmpDoctorElectronicRegistrationService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出医师电子化注册列表
     */
    @SaCheckPermission("doctor:doctorElectronicRegistration:export")
    @Log(title = "医师电子化注册", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorElectronicRegistrationBo bo, HttpServletResponse response) {
        List<MmpDoctorElectronicRegistrationVo> list = mmpDoctorElectronicRegistrationService.queryList(bo);
        ExcelUtil.exportExcel(list, "医师电子化注册", MmpDoctorElectronicRegistrationVo.class, response);
    }

    /**
     * 获取医师电子化注册详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorElectronicRegistration:query")
    @GetMapping("/{id}")
    public R<MmpDoctorElectronicRegistrationVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorElectronicRegistrationService.queryById(id));
    }

    /**
     * 新增医师电子化注册
     */
    @SaCheckPermission("doctor:doctorElectronicRegistration:add")
    @Log(title = "医师电子化注册", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorElectronicRegistrationBo bo) {
        return toAjax(mmpDoctorElectronicRegistrationService.insertByBo(bo));
    }

    /**
     * 修改医师电子化注册
     */
    @SaCheckPermission("doctor:doctorElectronicRegistration:edit")
    @Log(title = "医师电子化注册", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorElectronicRegistrationBo bo) {
        return toAjax(mmpDoctorElectronicRegistrationService.updateByBo(bo));
    }

    /**
     * 删除医师电子化注册
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorElectronicRegistration:remove")
    @Log(title = "医师电子化注册", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorElectronicRegistrationService.deleteWithValidByIds(List.of(ids), true));
    }
}
