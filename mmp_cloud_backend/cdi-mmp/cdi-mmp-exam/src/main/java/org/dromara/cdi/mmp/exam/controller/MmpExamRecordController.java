package org.dromara.cdi.mmp.exam.controller;

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
import org.dromara.cdi.mmp.exam.domain.vo.MmpExamRecordVo;
import org.dromara.cdi.mmp.exam.domain.bo.MmpExamRecordBo;
import org.dromara.cdi.mmp.exam.service.IMmpExamRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资质考试记录
 * 前端访问路由地址为:/natdss/examRecord
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/examRecord")
public class MmpExamRecordController extends BaseController {

    private final IMmpExamRecordService mmpExamRecordService;

    /**
     * 查询资质考试记录列表
     */
    @SaCheckPermission("natdss:examRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpExamRecordVo> list(MmpExamRecordBo bo, PageQuery pageQuery) {
        return mmpExamRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资质考试记录列表
     */
    @SaCheckPermission("natdss:examRecord:export")
    @Log(title = "资质考试记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpExamRecordBo bo, HttpServletResponse response) {
        List<MmpExamRecordVo> list = mmpExamRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "资质考试记录", MmpExamRecordVo.class, response);
    }

    /**
     * 获取资质考试记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:examRecord:query")
    @GetMapping("/{id}")
    public R<MmpExamRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpExamRecordService.queryById(id));
    }

    /**
     * 新增资质考试记录
     */
    @SaCheckPermission("natdss:examRecord:add")
    @Log(title = "资质考试记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpExamRecordBo bo) {
        return toAjax(mmpExamRecordService.insertByBo(bo));
    }

    /**
     * 修改资质考试记录
     */
    @SaCheckPermission("natdss:examRecord:edit")
    @Log(title = "资质考试记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpExamRecordBo bo) {
        return toAjax(mmpExamRecordService.updateByBo(bo));
    }

    /**
     * 删除资质考试记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:examRecord:remove")
    @Log(title = "资质考试记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpExamRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
