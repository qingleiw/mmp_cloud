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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorTrainingVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorTrainingBo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorTrainingService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 培训记录
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctor/doctorTraining")
public class MmpDoctorTrainingController extends BaseController {

    private final IMmpDoctorTrainingService mmpDoctorTrainingService;

    /**
     * 查询培训记录列表
     */
    @SaCheckPermission("doctor:doctorTraining:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorTrainingVo> list(MmpDoctorTrainingBo bo, PageQuery pageQuery) {
        return mmpDoctorTrainingService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出培训记录列表
     */
    @SaCheckPermission("doctor:doctorTraining:export")
    @Log(title = "培训记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorTrainingBo bo, HttpServletResponse response) {
        List<MmpDoctorTrainingVo> list = mmpDoctorTrainingService.queryList(bo);
        ExcelUtil.exportExcel(list, "培训记录", MmpDoctorTrainingVo.class, response);
    }

    /**
     * 获取培训记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorTraining:query")
    @GetMapping("/{id}")
    public R<MmpDoctorTrainingVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorTrainingService.queryById(id));
    }

    /**
     * 新增培训记录
     */
    @SaCheckPermission("doctor:doctorTraining:add")
    @Log(title = "培训记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorTrainingBo bo) {
        return toAjax(mmpDoctorTrainingService.insertByBo(bo));
    }

    /**
     * 修改培训记录
     */
    @SaCheckPermission("doctor:doctorTraining:edit")
    @Log(title = "培训记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorTrainingBo bo) {
        return toAjax(mmpDoctorTrainingService.updateByBo(bo));
    }

    /**
     * 删除培训记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorTraining:remove")
    @Log(title = "培训记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorTrainingService.deleteWithValidByIds(List.of(ids), true));
    }
}
