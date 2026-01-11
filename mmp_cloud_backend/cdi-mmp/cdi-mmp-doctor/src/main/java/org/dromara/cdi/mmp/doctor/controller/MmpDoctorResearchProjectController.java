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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorResearchProjectVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorResearchProjectBo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorResearchProjectService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 科研项目
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctorResearchProject")
public class MmpDoctorResearchProjectController extends BaseController {

    private final IMmpDoctorResearchProjectService mmpDoctorResearchProjectService;

    /**
     * 查询科研项目列表
     */
    @SaCheckPermission("doctor:doctorResearchProject:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorResearchProjectVo> list(MmpDoctorResearchProjectBo bo, PageQuery pageQuery) {
        return mmpDoctorResearchProjectService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出科研项目列表
     */
    @SaCheckPermission("doctor:doctorResearchProject:export")
    @Log(title = "科研项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorResearchProjectBo bo, HttpServletResponse response) {
        List<MmpDoctorResearchProjectVo> list = mmpDoctorResearchProjectService.queryList(bo);
        ExcelUtil.exportExcel(list, "科研项目", MmpDoctorResearchProjectVo.class, response);
    }

    /**
     * 获取科研项目详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorResearchProject:query")
    @GetMapping("/{id}")
    public R<MmpDoctorResearchProjectVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorResearchProjectService.queryById(id));
    }

    /**
     * 新增科研项目
     */
    @SaCheckPermission("doctor:doctorResearchProject:add")
    @Log(title = "科研项目", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorResearchProjectBo bo) {
        return toAjax(mmpDoctorResearchProjectService.insertByBo(bo));
    }

    /**
     * 修改科研项目
     */
    @SaCheckPermission("doctor:doctorResearchProject:edit")
    @Log(title = "科研项目", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorResearchProjectBo bo) {
        return toAjax(mmpDoctorResearchProjectService.updateByBo(bo));
    }

    /**
     * 删除科研项目
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorResearchProject:remove")
    @Log(title = "科研项目", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorResearchProjectService.deleteWithValidByIds(List.of(ids), true));
    }
}
