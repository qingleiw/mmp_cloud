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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB16-3MolecularPathologyExamRecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB16-3MolecularPathologyExamRecordBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB16-3MolecularPathologyExamRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B16-3 分子病理检测记录
 * 前端访问路由地址为:/natdss/natdssB16-3MolecularPathologyExamRecord
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB16-3MolecularPathologyExamRecord")
public class MmpNatdssB16-3MolecularPathologyExamRecordController extends BaseController {

    private final IMmpNatdssB16-3MolecularPathologyExamRecordService mmpNatdssB16-3MolecularPathologyExamRecordService;

    /**
     * 查询B16-3 分子病理检测记录列表
     */
    @SaCheckPermission("natdss:natdssB16-3MolecularPathologyExamRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB16-3MolecularPathologyExamRecordVo> list(MmpNatdssB16-3MolecularPathologyExamRecordBo bo, PageQuery pageQuery) {
        return mmpNatdssB16-3MolecularPathologyExamRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B16-3 分子病理检测记录列表
     */
    @SaCheckPermission("natdss:natdssB16-3MolecularPathologyExamRecord:export")
    @Log(title = "B16-3 分子病理检测记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB16-3MolecularPathologyExamRecordBo bo, HttpServletResponse response) {
        List<MmpNatdssB16-3MolecularPathologyExamRecordVo> list = mmpNatdssB16-3MolecularPathologyExamRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "B16-3 分子病理检测记录", MmpNatdssB16-3MolecularPathologyExamRecordVo.class, response);
    }

    /**
     * 获取B16-3 分子病理检测记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB16-3MolecularPathologyExamRecord:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB16-3MolecularPathologyExamRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB16-3MolecularPathologyExamRecordService.queryById(id));
    }

    /**
     * 新增B16-3 分子病理检测记录
     */
    @SaCheckPermission("natdss:natdssB16-3MolecularPathologyExamRecord:add")
    @Log(title = "B16-3 分子病理检测记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB16-3MolecularPathologyExamRecordBo bo) {
        return toAjax(mmpNatdssB16-3MolecularPathologyExamRecordService.insertByBo(bo));
    }

    /**
     * 修改B16-3 分子病理检测记录
     */
    @SaCheckPermission("natdss:natdssB16-3MolecularPathologyExamRecord:edit")
    @Log(title = "B16-3 分子病理检测记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB16-3MolecularPathologyExamRecordBo bo) {
        return toAjax(mmpNatdssB16-3MolecularPathologyExamRecordService.updateByBo(bo));
    }

    /**
     * 删除B16-3 分子病理检测记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB16-3MolecularPathologyExamRecord:remove")
    @Log(title = "B16-3 分子病理检测记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB16-3MolecularPathologyExamRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
