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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorProfessionalRatingVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorProfessionalRatingBo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorProfessionalRatingService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 医师职业评分
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctor/doctorProfessionalRating")
public class MmpDoctorProfessionalRatingController extends BaseController {

    private final IMmpDoctorProfessionalRatingService mmpDoctorProfessionalRatingService;

    /**
     * 查询医师职业评分列表
     */
    @SaCheckPermission("doctor:doctorProfessionalRating:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorProfessionalRatingVo> list(MmpDoctorProfessionalRatingBo bo, PageQuery pageQuery) {
        return mmpDoctorProfessionalRatingService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出医师职业评分列表
     */
    @SaCheckPermission("doctor:doctorProfessionalRating:export")
    @Log(title = "医师职业评分", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorProfessionalRatingBo bo, HttpServletResponse response) {
        List<MmpDoctorProfessionalRatingVo> list = mmpDoctorProfessionalRatingService.queryList(bo);
        ExcelUtil.exportExcel(list, "医师职业评分", MmpDoctorProfessionalRatingVo.class, response);
    }

    /**
     * 获取医师职业评分详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorProfessionalRating:query")
    @GetMapping("/{id}")
    public R<MmpDoctorProfessionalRatingVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorProfessionalRatingService.queryById(id));
    }

    /**
     * 新增医师职业评分
     */
    @SaCheckPermission("doctor:doctorProfessionalRating:add")
    @Log(title = "医师职业评分", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorProfessionalRatingBo bo) {
        return toAjax(mmpDoctorProfessionalRatingService.insertByBo(bo));
    }

    /**
     * 修改医师职业评分
     */
    @SaCheckPermission("doctor:doctorProfessionalRating:edit")
    @Log(title = "医师职业评分", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorProfessionalRatingBo bo) {
        return toAjax(mmpDoctorProfessionalRatingService.updateByBo(bo));
    }

    /**
     * 删除医师职业评分
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorProfessionalRating:remove")
    @Log(title = "医师职业评分", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorProfessionalRatingService.deleteWithValidByIds(List.of(ids), true));
    }
}
