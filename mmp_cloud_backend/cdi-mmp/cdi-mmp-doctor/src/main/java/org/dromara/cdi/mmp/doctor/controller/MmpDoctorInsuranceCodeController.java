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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorInsuranceCodeVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorInsuranceCodeBo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorInsuranceCodeService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 医保医师码
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctorInsuranceCode")
public class MmpDoctorInsuranceCodeController extends BaseController {

    private final IMmpDoctorInsuranceCodeService mmpDoctorInsuranceCodeService;

    /**
     * 查询医保医师码列表
     */
    @SaCheckPermission("doctor:doctorInsuranceCode:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorInsuranceCodeVo> list(MmpDoctorInsuranceCodeBo bo, PageQuery pageQuery) {
        return mmpDoctorInsuranceCodeService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出医保医师码列表
     */
    @SaCheckPermission("doctor:doctorInsuranceCode:export")
    @Log(title = "医保医师码", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorInsuranceCodeBo bo, HttpServletResponse response) {
        List<MmpDoctorInsuranceCodeVo> list = mmpDoctorInsuranceCodeService.queryList(bo);
        ExcelUtil.exportExcel(list, "医保医师码", MmpDoctorInsuranceCodeVo.class, response);
    }

    /**
     * 获取医保医师码详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorInsuranceCode:query")
    @GetMapping("/{id}")
    public R<MmpDoctorInsuranceCodeVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorInsuranceCodeService.queryById(id));
    }

    /**
     * 新增医保医师码
     */
    @SaCheckPermission("doctor:doctorInsuranceCode:add")
    @Log(title = "医保医师码", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorInsuranceCodeBo bo) {
        return toAjax(mmpDoctorInsuranceCodeService.insertByBo(bo));
    }

    /**
     * 修改医保医师码
     */
    @SaCheckPermission("doctor:doctorInsuranceCode:edit")
    @Log(title = "医保医师码", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorInsuranceCodeBo bo) {
        return toAjax(mmpDoctorInsuranceCodeService.updateByBo(bo));
    }

    /**
     * 删除医保医师码
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorInsuranceCode:remove")
    @Log(title = "医保医师码", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorInsuranceCodeService.deleteWithValidByIds(List.of(ids), true));
    }
}
