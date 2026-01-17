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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB051EmrAdmissionVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB051EmrAdmissionBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB051EmrAdmissionService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B05-1 入院记录
 * 前端访问路由地址为:/natdss/natdssB051EmrAdmission
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB051EmrAdmission")
public class MmpNatdssB051EmrAdmissionController extends BaseController {

    private final IMmpNatdssB051EmrAdmissionService mmpNatdssB051EmrAdmissionService;

    /**
     * 查询B05-1 入院记录列表
     */
    @SaCheckPermission("natdss:natdssB051EmrAdmission:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB051EmrAdmissionVo> list(MmpNatdssB051EmrAdmissionBo bo, PageQuery pageQuery) {
        return mmpNatdssB051EmrAdmissionService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B05-1 入院记录列表
     */
    @SaCheckPermission("natdss:natdssB051EmrAdmission:export")
    @Log(title = "B05-1 入院记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB051EmrAdmissionBo bo, HttpServletResponse response) {
        List<MmpNatdssB051EmrAdmissionVo> list = mmpNatdssB051EmrAdmissionService.queryList(bo);
        ExcelUtil.exportExcel(list, "B05-1 入院记录", MmpNatdssB051EmrAdmissionVo.class, response);
    }

    /**
     * 获取B05-1 入院记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB051EmrAdmission:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB051EmrAdmissionVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB051EmrAdmissionService.queryById(id));
    }

    /**
     * 新增B05-1 入院记录
     */
    @SaCheckPermission("natdss:natdssB051EmrAdmission:add")
    @Log(title = "B05-1 入院记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB051EmrAdmissionBo bo) {
        return toAjax(mmpNatdssB051EmrAdmissionService.insertByBo(bo));
    }

    /**
     * 修改B05-1 入院记录
     */
    @SaCheckPermission("natdss:natdssB051EmrAdmission:edit")
    @Log(title = "B05-1 入院记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB051EmrAdmissionBo bo) {
        return toAjax(mmpNatdssB051EmrAdmissionService.updateByBo(bo));
    }

    /**
     * 删除B05-1 入院记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB051EmrAdmission:remove")
    @Log(title = "B05-1 入院记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB051EmrAdmissionService.deleteWithValidByIds(List.of(ids), true));
    }
}
