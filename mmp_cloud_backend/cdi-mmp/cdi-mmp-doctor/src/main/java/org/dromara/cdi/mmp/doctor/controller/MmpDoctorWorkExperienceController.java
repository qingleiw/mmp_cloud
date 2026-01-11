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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorWorkExperienceVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorWorkExperienceBo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorWorkExperienceService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 工作经历
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctor/doctorWorkExperience")
public class MmpDoctorWorkExperienceController extends BaseController {

    private final IMmpDoctorWorkExperienceService mmpDoctorWorkExperienceService;

    /**
     * 查询工作经历列表
     */
    @SaCheckPermission("doctor:doctorWorkExperience:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorWorkExperienceVo> list(MmpDoctorWorkExperienceBo bo, PageQuery pageQuery) {
        return mmpDoctorWorkExperienceService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出工作经历列表
     */
    @SaCheckPermission("doctor:doctorWorkExperience:export")
    @Log(title = "工作经历", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorWorkExperienceBo bo, HttpServletResponse response) {
        List<MmpDoctorWorkExperienceVo> list = mmpDoctorWorkExperienceService.queryList(bo);
        ExcelUtil.exportExcel(list, "工作经历", MmpDoctorWorkExperienceVo.class, response);
    }

    /**
     * 获取工作经历详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorWorkExperience:query")
    @GetMapping("/{id}")
    public R<MmpDoctorWorkExperienceVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorWorkExperienceService.queryById(id));
    }

    /**
     * 新增工作经历
     */
    @SaCheckPermission("doctor:doctorWorkExperience:add")
    @Log(title = "工作经历", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorWorkExperienceBo bo) {
        return toAjax(mmpDoctorWorkExperienceService.insertByBo(bo));
    }

    /**
     * 修改工作经历
     */
    @SaCheckPermission("doctor:doctorWorkExperience:edit")
    @Log(title = "工作经历", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorWorkExperienceBo bo) {
        return toAjax(mmpDoctorWorkExperienceService.updateByBo(bo));
    }

    /**
     * 删除工作经历
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorWorkExperience:remove")
    @Log(title = "工作经历", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorWorkExperienceService.deleteWithValidByIds(List.of(ids), true));
    }
}
