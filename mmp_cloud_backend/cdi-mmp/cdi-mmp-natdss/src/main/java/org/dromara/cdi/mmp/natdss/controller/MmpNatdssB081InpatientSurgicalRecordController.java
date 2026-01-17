package org.dromara.cdi.mmp.natdss.controller;

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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB081InpatientSurgicalRecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB081InpatientSurgicalRecordBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB081InpatientSurgicalRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B08-1 住院手术记录
 * 前端访问路由地址为:/natdss/natdssB081InpatientSurgicalRecord
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB081InpatientSurgicalRecord")
public class MmpNatdssB081InpatientSurgicalRecordController extends BaseController {

    private final IMmpNatdssB081InpatientSurgicalRecordService mmpNatdssB081InpatientSurgicalRecordService;

    /**
     * 查询B08-1 住院手术记录列表
     */
    @SaCheckPermission("natdss:natdssB081InpatientSurgicalRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB081InpatientSurgicalRecordVo> list(MmpNatdssB081InpatientSurgicalRecordBo bo, PageQuery pageQuery) {
        return mmpNatdssB081InpatientSurgicalRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B08-1 住院手术记录列表
     */
    @SaCheckPermission("natdss:natdssB081InpatientSurgicalRecord:export")
    @Log(title = "B08-1 住院手术记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB081InpatientSurgicalRecordBo bo, HttpServletResponse response) {
        List<MmpNatdssB081InpatientSurgicalRecordVo> list = mmpNatdssB081InpatientSurgicalRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "B08-1 住院手术记录", MmpNatdssB081InpatientSurgicalRecordVo.class, response);
    }

    /**
     * 获取B08-1 住院手术记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB081InpatientSurgicalRecord:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB081InpatientSurgicalRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB081InpatientSurgicalRecordService.queryById(id));
    }

    /**
     * 新增B08-1 住院手术记录
     */
    @SaCheckPermission("natdss:natdssB081InpatientSurgicalRecord:add")
    @Log(title = "B08-1 住院手术记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB081InpatientSurgicalRecordBo bo) {
        return toAjax(mmpNatdssB081InpatientSurgicalRecordService.insertByBo(bo));
    }

    /**
     * 修改B08-1 住院手术记录
     */
    @SaCheckPermission("natdss:natdssB081InpatientSurgicalRecord:edit")
    @Log(title = "B08-1 住院手术记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB081InpatientSurgicalRecordBo bo) {
        return toAjax(mmpNatdssB081InpatientSurgicalRecordService.updateByBo(bo));
    }

    /**
     * 删除B08-1 住院手术记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB081InpatientSurgicalRecord:remove")
    @Log(title = "B08-1 住院手术记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB081InpatientSurgicalRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
