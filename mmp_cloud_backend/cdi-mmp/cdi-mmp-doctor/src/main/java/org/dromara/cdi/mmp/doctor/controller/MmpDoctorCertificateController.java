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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorCertificateVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorCertificateBo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorCertificateService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资质证书
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctor/doctorCertificate")
public class MmpDoctorCertificateController extends BaseController {

    private final IMmpDoctorCertificateService mmpDoctorCertificateService;

    /**
     * 查询资质证书列表
     */
    //@SaCheckPermission("doctor:doctorCertificate:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorCertificateVo> list(MmpDoctorCertificateBo bo, PageQuery pageQuery) {
        return mmpDoctorCertificateService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资质证书列表
     */
    @SaCheckPermission("doctor:doctorCertificate:export")
    @Log(title = "资质证书", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorCertificateBo bo, HttpServletResponse response) {
        List<MmpDoctorCertificateVo> list = mmpDoctorCertificateService.queryList(bo);
        ExcelUtil.exportExcel(list, "资质证书", MmpDoctorCertificateVo.class, response);
    }

    /**
     * 获取资质证书详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorCertificate:query")
    @GetMapping("/{id}")
    public R<MmpDoctorCertificateVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorCertificateService.queryById(id));
    }

    /**
     * 新增资质证书
     */
    @SaCheckPermission("doctor:doctorCertificate:add")
    @Log(title = "资质证书", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorCertificateBo bo) {
        return toAjax(mmpDoctorCertificateService.insertByBo(bo));
    }

    /**
     * 修改资质证书
     */
    @SaCheckPermission("doctor:doctorCertificate:edit")
    @Log(title = "资质证书", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorCertificateBo bo) {
        return toAjax(mmpDoctorCertificateService.updateByBo(bo));
    }

    /**
     * 删除资质证书
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorCertificate:remove")
    @Log(title = "资质证书", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorCertificateService.deleteWithValidByIds(List.of(ids), true));
    }
}
