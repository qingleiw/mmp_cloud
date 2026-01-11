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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorPublicationVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorPublicationBo;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorPublicationService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 论文论著
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctor/doctorPublication")
public class MmpDoctorPublicationController extends BaseController {

    private final IMmpDoctorPublicationService mmpDoctorPublicationService;

    /**
     * 查询论文论著列表
     */
    @SaCheckPermission("doctor:doctorPublication:list")
    @GetMapping("/list")
    public TableDataInfo<MmpDoctorPublicationVo> list(MmpDoctorPublicationBo bo, PageQuery pageQuery) {
        return mmpDoctorPublicationService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出论文论著列表
     */
    @SaCheckPermission("doctor:doctorPublication:export")
    @Log(title = "论文论著", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpDoctorPublicationBo bo, HttpServletResponse response) {
        List<MmpDoctorPublicationVo> list = mmpDoctorPublicationService.queryList(bo);
        ExcelUtil.exportExcel(list, "论文论著", MmpDoctorPublicationVo.class, response);
    }

    /**
     * 获取论文论著详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("doctor:doctorPublication:query")
    @GetMapping("/{id}")
    public R<MmpDoctorPublicationVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpDoctorPublicationService.queryById(id));
    }

    /**
     * 新增论文论著
     */
    @SaCheckPermission("doctor:doctorPublication:add")
    @Log(title = "论文论著", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpDoctorPublicationBo bo) {
        return toAjax(mmpDoctorPublicationService.insertByBo(bo));
    }

    /**
     * 修改论文论著
     */
    @SaCheckPermission("doctor:doctorPublication:edit")
    @Log(title = "论文论著", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpDoctorPublicationBo bo) {
        return toAjax(mmpDoctorPublicationService.updateByBo(bo));
    }

    /**
     * 删除论文论著
     *
     * @param ids 主键串
     */
    @SaCheckPermission("doctor:doctorPublication:remove")
    @Log(title = "论文论著", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpDoctorPublicationService.deleteWithValidByIds(List.of(ids), true));
    }
}
