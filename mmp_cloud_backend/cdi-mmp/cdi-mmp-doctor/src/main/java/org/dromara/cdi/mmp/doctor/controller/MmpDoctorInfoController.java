package org.dromara.cdi.mmp.doctor.controller;

import lombok.RequiredArgsConstructor;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.core.domain.R;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorInfoVo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorInfoService;

/**
 * 医师信息
 *
 * @author Lion Li
 * @date 2026-01-05
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctor/doctorInfo")
public class MmpDoctorInfoController extends BaseController {

    private final IMmpDoctorInfoService mmpDoctorInfoService;

    /**
     * 获取医师档案信息
     *
     * @param doctorId 医师ID
     */
    @SaCheckPermission("doctor:doctorInfo:query")
    @GetMapping("/archive/{doctorId}")
    public R<MmpDoctorInfoVo> getArchive(@NotNull(message = "医师ID不能为空")
                                             @PathVariable Long doctorId) {
        return R.ok(mmpDoctorInfoService.getDoctorArchive(doctorId));
    }
}
