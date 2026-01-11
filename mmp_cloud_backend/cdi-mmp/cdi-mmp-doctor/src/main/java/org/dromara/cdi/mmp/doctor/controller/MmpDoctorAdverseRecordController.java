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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorAdverseRecordVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorAdverseRecordBo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorAdverseRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 不良行为记录
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctor/doctorAdverseRecord")
public class MmpDoctorAdverseRecordController extends BaseController {

    private final IMmpDoctorAdverseRecordService mmpDoctorAdverseRecordService;

    /**
     * 查询不良行为记录列表
     */
    @SaCheckPermission("doctor:doctorAdverseRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorAdverseRecordVo> list(MmpDoctorAdverseRecordBo bo, PageQuery pageQuery) {
        return mmpDoctorAdverseRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出不良行为记录列表
     */
    @SaCheckPermission("doctor:doctorAdverseRecord:export")
    @Log(title = "不良行为记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorAdverseRecordBo bo, HttpServletResponse response) {
        List<MmpDoctorAdverseRecordVo> list = mmpDoctorAdverseRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "不良行为记录", MmpDoctorAdverseRecordVo.class, response);
    }

    /**
     * 获取不良行为记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorAdverseRecord:query")
    @GetMapping("/{id}")
    public R<MmpDoctorAdverseRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorAdverseRecordService.queryById(id));
    }

    /**
     * 新增不良行为记录
     */
    @SaCheckPermission("doctor:doctorAdverseRecord:add")
    @Log(title = "不良行为记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorAdverseRecordBo bo) {
        return toAjax(mmpDoctorAdverseRecordService.insertByBo(bo));
    }

    /**
     * 修改不良行为记录
     */
    @SaCheckPermission("doctor:doctorAdverseRecord:edit")
    @Log(title = "不良行为记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorAdverseRecordBo bo) {
        return toAjax(mmpDoctorAdverseRecordService.updateByBo(bo));
    }

    /**
     * 删除不良行为记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorAdverseRecord:remove")
    @Log(title = "不良行为记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorAdverseRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
