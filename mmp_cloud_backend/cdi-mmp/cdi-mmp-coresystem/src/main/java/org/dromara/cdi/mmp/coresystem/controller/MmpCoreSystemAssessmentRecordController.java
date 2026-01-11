package org.dromara.cdi.mmp.coresystem.controller;

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
import org.dromara.cdi.mmp.coresystem.domain.vo.MmpCoreSystemAssessmentRecordVo;
import org.dromara.cdi.mmp.coresystem.domain.bo.MmpCoreSystemAssessmentRecordBo;
import org.dromara.cdi.mmp.coresystem.service.IMmpCoreSystemAssessmentRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 制度考核记录
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/coresystem/coreSystemAssessmentRecord")
public class MmpCoreSystemAssessmentRecordController extends BaseController {

    private final IMmpCoreSystemAssessmentRecordService mmpCoreSystemAssessmentRecordService;

    /**
     * 查询制度考核记录列表
     */
    @SaCheckPermission("coresystem:coreSystemAssessmentRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpCoreSystemAssessmentRecordVo> list(MmpCoreSystemAssessmentRecordBo bo, PageQuery pageQuery) {
        return mmpCoreSystemAssessmentRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出制度考核记录列表
     */
    @SaCheckPermission("coresystem:coreSystemAssessmentRecord:export")
    @Log(title = "制度考核记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpCoreSystemAssessmentRecordBo bo, HttpServletResponse response) {
        List<MmpCoreSystemAssessmentRecordVo> list = mmpCoreSystemAssessmentRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "制度考核记录", MmpCoreSystemAssessmentRecordVo.class, response);
    }

    /**
     * 获取制度考核记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("coresystem:coreSystemAssessmentRecord:query")
    @GetMapping("/{id}")
    public R<MmpCoreSystemAssessmentRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpCoreSystemAssessmentRecordService.queryById(id));
    }

    /**
     * 新增制度考核记录
     */
    @SaCheckPermission("coresystem:coreSystemAssessmentRecord:add")
    @Log(title = "制度考核记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpCoreSystemAssessmentRecordBo bo) {
        return toAjax(mmpCoreSystemAssessmentRecordService.insertByBo(bo));
    }

    /**
     * 修改制度考核记录
     */
    @SaCheckPermission("coresystem:coreSystemAssessmentRecord:edit")
    @Log(title = "制度考核记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpCoreSystemAssessmentRecordBo bo) {
        return toAjax(mmpCoreSystemAssessmentRecordService.updateByBo(bo));
    }

    /**
     * 删除制度考核记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("coresystem:coreSystemAssessmentRecord:remove")
    @Log(title = "制度考核记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpCoreSystemAssessmentRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
