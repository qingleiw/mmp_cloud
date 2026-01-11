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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorAcademicPositionVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorAcademicPositionBo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorAcademicPositionService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 学术任职
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctor/doctorAcademicPosition")
public class MmpDoctorAcademicPositionController extends BaseController {

    private final IMmpDoctorAcademicPositionService mmpDoctorAcademicPositionService;

    /**
     * 查询学术任职列表
     */
    @SaCheckPermission("doctor:doctorAcademicPosition:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorAcademicPositionVo> list(MmpDoctorAcademicPositionBo bo, PageQuery pageQuery) {
        return mmpDoctorAcademicPositionService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出学术任职列表
     */
    @SaCheckPermission("doctor:doctorAcademicPosition:export")
    @Log(title = "学术任职", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorAcademicPositionBo bo, HttpServletResponse response) {
        List<MmpDoctorAcademicPositionVo> list = mmpDoctorAcademicPositionService.queryList(bo);
        ExcelUtil.exportExcel(list, "学术任职", MmpDoctorAcademicPositionVo.class, response);
    }

    /**
     * 获取学术任职详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorAcademicPosition:query")
    @GetMapping("/{id}")
    public R<MmpDoctorAcademicPositionVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorAcademicPositionService.queryById(id));
    }

    /**
     * 新增学术任职
     */
    @SaCheckPermission("doctor:doctorAcademicPosition:add")
    @Log(title = "学术任职", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorAcademicPositionBo bo) {
        return toAjax(mmpDoctorAcademicPositionService.insertByBo(bo));
    }

    /**
     * 修改学术任职
     */
    @SaCheckPermission("doctor:doctorAcademicPosition:edit")
    @Log(title = "学术任职", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorAcademicPositionBo bo) {
        return toAjax(mmpDoctorAcademicPositionService.updateByBo(bo));
    }

    /**
     * 删除学术任职
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorAcademicPosition:remove")
    @Log(title = "学术任职", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorAcademicPositionService.deleteWithValidByIds(List.of(ids), true));
    }
}
