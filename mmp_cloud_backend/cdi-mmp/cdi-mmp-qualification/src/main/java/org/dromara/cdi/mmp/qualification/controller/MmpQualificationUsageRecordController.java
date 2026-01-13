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
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationUsageRecordVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationUsageRecordBo;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationUsageRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资质使用记录
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/qualificationUsageRecord")
public class MmpQualificationUsageRecordController extends BaseController {

    private final IMmpQualificationUsageRecordService mmpQualificationUsageRecordService;

    /**
     * 查询资质使用记录列表
     */
    @SaCheckPermission("qualification:qualificationUsageRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQualificationUsageRecordVo> list(MmpQualificationUsageRecordBo bo, PageQuery pageQuery) {
        return mmpQualificationUsageRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资质使用记录列表
     */
    @SaCheckPermission("qualification:qualificationUsageRecord:export")
    @Log(title = "资质使用记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQualificationUsageRecordBo bo, HttpServletResponse response) {
        List<MmpQualificationUsageRecordVo> list = mmpQualificationUsageRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "资质使用记录", MmpQualificationUsageRecordVo.class, response);
    }

    /**
     * 获取资质使用记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("qualification:qualificationUsageRecord:query")
    @GetMapping("/{id}")
    public R<MmpQualificationUsageRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQualificationUsageRecordService.queryById(id));
    }

    /**
     * 新增资质使用记录
     */
    @SaCheckPermission("qualification:qualificationUsageRecord:add")
    @Log(title = "资质使用记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQualificationUsageRecordBo bo) {
        return toAjax(mmpQualificationUsageRecordService.insertByBo(bo));
    }

    /**
     * 修改资质使用记录
     */
    @SaCheckPermission("qualification:qualificationUsageRecord:edit")
    @Log(title = "资质使用记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQualificationUsageRecordBo bo) {
        return toAjax(mmpQualificationUsageRecordService.updateByBo(bo));
    }

    /**
     * 删除资质使用记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("qualification:qualificationUsageRecord:remove")
    @Log(title = "资质使用记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQualificationUsageRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
