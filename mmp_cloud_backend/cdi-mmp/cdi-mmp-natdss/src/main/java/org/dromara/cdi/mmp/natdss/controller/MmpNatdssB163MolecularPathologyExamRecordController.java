package org.dromara.cdi.mmp.natdss.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.common.web.core.BaseController;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB163MolecularPathologyExamRecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB163MolecularPathologyExamRecordBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB163MolecularPathologyExamRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B163 分子病理检测记录
 * 前端访问路由地址为:/natdss/natdssB163MolecularPathologyExamRecord
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB163MolecularPathologyExamRecord")
public class MmpNatdssB163MolecularPathologyExamRecordController extends BaseController {

    private final IMmpNatdssB163MolecularPathologyExamRecordService mmpNatdssB163MolecularPathologyExamRecordService;

    /**
     * 查询B163 分子病理检测记录列表
     */
    @SaCheckPermission("natdss:natdssB163MolecularPathologyExamRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB163MolecularPathologyExamRecordVo> list(MmpNatdssB163MolecularPathologyExamRecordBo bo, PageQuery pageQuery) {
        return mmpNatdssB163MolecularPathologyExamRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B163 分子病理检测记录列表
     */
    @SaCheckPermission("natdss:natdssB163MolecularPathologyExamRecord:export")
    @Log(title = "B163 分子病理检测记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB163MolecularPathologyExamRecordBo bo, HttpServletResponse response) {
        List<MmpNatdssB163MolecularPathologyExamRecordVo> list = mmpNatdssB163MolecularPathologyExamRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "B163 分子病理检测记录", MmpNatdssB163MolecularPathologyExamRecordVo.class, response);
    }

    /**
     * 获取B163 分子病理检测记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB163MolecularPathologyExamRecord:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB163MolecularPathologyExamRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB163MolecularPathologyExamRecordService.queryById(id));
    }

    /**
     * 新增B163 分子病理检测记录
     */
    @SaCheckPermission("natdss:natdssB163MolecularPathologyExamRecord:add")
    @Log(title = "B163 分子病理检测记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB163MolecularPathologyExamRecordBo bo) {
        return toAjax(mmpNatdssB163MolecularPathologyExamRecordService.insertByBo(bo));
    }

    /**
     * 修改B163 分子病理检测记录
     */
    @SaCheckPermission("natdss:natdssB163MolecularPathologyExamRecord:edit")
    @Log(title = "B163 分子病理检测记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB163MolecularPathologyExamRecordBo bo) {
        return toAjax(mmpNatdssB163MolecularPathologyExamRecordService.updateByBo(bo));
    }

    /**
     * 删除B163 分子病理检测记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB163MolecularPathologyExamRecord:remove")
    @Log(title = "B163 分子病理检测记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB163MolecularPathologyExamRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
