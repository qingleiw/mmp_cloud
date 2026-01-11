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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorEducationVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorEducationBo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorEducationService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 教育经历
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctorEducation")
public class MmpDoctorEducationController extends BaseController {

    private final IMmpDoctorEducationService mmpDoctorEducationService;

    /**
     * 查询教育经历列表
     */
    @SaCheckPermission("doctor:doctorEducation:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorEducationVo> list(MmpDoctorEducationBo bo, PageQuery pageQuery) {
        return mmpDoctorEducationService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出教育经历列表
     */
    @SaCheckPermission("doctor:doctorEducation:export")
    @Log(title = "教育经历", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorEducationBo bo, HttpServletResponse response) {
        List<MmpDoctorEducationVo> list = mmpDoctorEducationService.queryList(bo);
        ExcelUtil.exportExcel(list, "教育经历", MmpDoctorEducationVo.class, response);
    }

    /**
     * 获取教育经历详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorEducation:query")
    @GetMapping("/{id}")
    public R<MmpDoctorEducationVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorEducationService.queryById(id));
    }

    /**
     * 新增教育经历
     */
    @SaCheckPermission("doctor:doctorEducation:add")
    @Log(title = "教育经历", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorEducationBo bo) {
        return toAjax(mmpDoctorEducationService.insertByBo(bo));
    }

    /**
     * 修改教育经历
     */
    @SaCheckPermission("doctor:doctorEducation:edit")
    @Log(title = "教育经历", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorEducationBo bo) {
        return toAjax(mmpDoctorEducationService.updateByBo(bo));
    }

    /**
     * 删除教育经历
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorEducation:remove")
    @Log(title = "教育经历", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorEducationService.deleteWithValidByIds(List.of(ids), true));
    }
}
