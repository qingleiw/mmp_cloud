package org.dromara.cdi.mmp.qc.controller;

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
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcScoringResultVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcScoringResultBo;
import org.dromara.cdi.mmp.qc.service.IMmpQcScoringResultService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 评分结果
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/qcScoringResult")
public class MmpQcScoringResultController extends BaseController {

    private final IMmpQcScoringResultService mmpQcScoringResultService;

    /**
     * 查询评分结果列表
     */
    @SaCheckPermission("system:qcScoringResult:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQcScoringResultVo> list(MmpQcScoringResultBo bo, PageQuery pageQuery) {
        return mmpQcScoringResultService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出评分结果列表
     */
    @SaCheckPermission("system:qcScoringResult:export")
    @Log(title = "评分结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQcScoringResultBo bo, HttpServletResponse response) {
        List<MmpQcScoringResultVo> list = mmpQcScoringResultService.queryList(bo);
        ExcelUtil.exportExcel(list, "评分结果", MmpQcScoringResultVo.class, response);
    }

    /**
     * 获取评分结果详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:qcScoringResult:query")
    @GetMapping("/{id}")
    public R<MmpQcScoringResultVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQcScoringResultService.queryById(id));
    }

    /**
     * 新增评分结果
     */
    @SaCheckPermission("system:qcScoringResult:add")
    @Log(title = "评分结果", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQcScoringResultBo bo) {
        return toAjax(mmpQcScoringResultService.insertByBo(bo));
    }

    /**
     * 修改评分结果
     */
    @SaCheckPermission("system:qcScoringResult:edit")
    @Log(title = "评分结果", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQcScoringResultBo bo) {
        return toAjax(mmpQcScoringResultService.updateByBo(bo));
    }

    /**
     * 删除评分结果
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:qcScoringResult:remove")
    @Log(title = "评分结果", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQcScoringResultService.deleteWithValidByIds(List.of(ids), true));
    }
}
