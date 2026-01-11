package org.dromara.cdi.mmp.qualification.controller;

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
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationExamRecordVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationExamRecordBo;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationExamRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资质考试记录
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/qualificationExamRecord")
public class MmpQualificationExamRecordController extends BaseController {

    private final IMmpQualificationExamRecordService mmpQualificationExamRecordService;

    /**
     * 查询资质考试记录列表
     */
    @SaCheckPermission("system:qualificationExamRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQualificationExamRecordVo> list(MmpQualificationExamRecordBo bo, PageQuery pageQuery) {
        return mmpQualificationExamRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资质考试记录列表
     */
    @SaCheckPermission("system:qualificationExamRecord:export")
    @Log(title = "资质考试记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQualificationExamRecordBo bo, HttpServletResponse response) {
        List<MmpQualificationExamRecordVo> list = mmpQualificationExamRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "资质考试记录", MmpQualificationExamRecordVo.class, response);
    }

    /**
     * 获取资质考试记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:qualificationExamRecord:query")
    @GetMapping("/{id}")
    public R<MmpQualificationExamRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQualificationExamRecordService.queryById(id));
    }

    /**
     * 新增资质考试记录
     */
    @SaCheckPermission("system:qualificationExamRecord:add")
    @Log(title = "资质考试记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQualificationExamRecordBo bo) {
        return toAjax(mmpQualificationExamRecordService.insertByBo(bo));
    }

    /**
     * 修改资质考试记录
     */
    @SaCheckPermission("system:qualificationExamRecord:edit")
    @Log(title = "资质考试记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQualificationExamRecordBo bo) {
        return toAjax(mmpQualificationExamRecordService.updateByBo(bo));
    }

    /**
     * 删除资质考试记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:qualificationExamRecord:remove")
    @Log(title = "资质考试记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQualificationExamRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
