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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorHonorVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorHonorBo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorHonorService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 荣誉奖励
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctorHonor")
public class MmpDoctorHonorController extends BaseController {

    private final IMmpDoctorHonorService mmpDoctorHonorService;

    /**
     * 查询荣誉奖励列表
     */
    @SaCheckPermission("doctor:doctorHonor:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorHonorVo> list(MmpDoctorHonorBo bo, PageQuery pageQuery) {
        return mmpDoctorHonorService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出荣誉奖励列表
     */
    @SaCheckPermission("doctor:doctorHonor:export")
    @Log(title = "荣誉奖励", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorHonorBo bo, HttpServletResponse response) {
        List<MmpDoctorHonorVo> list = mmpDoctorHonorService.queryList(bo);
        ExcelUtil.exportExcel(list, "荣誉奖励", MmpDoctorHonorVo.class, response);
    }

    /**
     * 获取荣誉奖励详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorHonor:query")
    @GetMapping("/{id}")
    public R<MmpDoctorHonorVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorHonorService.queryById(id));
    }

    /**
     * 新增荣誉奖励
     */
    @SaCheckPermission("doctor:doctorHonor:add")
    @Log(title = "荣誉奖励", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorHonorBo bo) {
        return toAjax(mmpDoctorHonorService.insertByBo(bo));
    }

    /**
     * 修改荣誉奖励
     */
    @SaCheckPermission("doctor:doctorHonor:edit")
    @Log(title = "荣誉奖励", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorHonorBo bo) {
        return toAjax(mmpDoctorHonorService.updateByBo(bo));
    }

    /**
     * 删除荣誉奖励
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorHonor:remove")
    @Log(title = "荣誉奖励", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorHonorService.deleteWithValidByIds(List.of(ids), true));
    }
}
