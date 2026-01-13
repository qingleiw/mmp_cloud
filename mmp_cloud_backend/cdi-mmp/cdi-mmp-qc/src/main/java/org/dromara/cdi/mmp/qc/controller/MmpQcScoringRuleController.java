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
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcScoringRuleVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcScoringRuleBo;
import org.dromara.cdi.mmp.qc.service.IMmpQcScoringRuleService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 评分规则
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/qcScoringRule")
public class MmpQcScoringRuleController extends BaseController {

    private final IMmpQcScoringRuleService mmpQcScoringRuleService;

    /**
     * 查询评分规则列表
     */
    @SaCheckPermission("qc:qcScoringRule:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQcScoringRuleVo> list(MmpQcScoringRuleBo bo, PageQuery pageQuery) {
        return mmpQcScoringRuleService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出评分规则列表
     */
    @SaCheckPermission("qc:qcScoringRule:export")
    @Log(title = "评分规则", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQcScoringRuleBo bo, HttpServletResponse response) {
        List<MmpQcScoringRuleVo> list = mmpQcScoringRuleService.queryList(bo);
        ExcelUtil.exportExcel(list, "评分规则", MmpQcScoringRuleVo.class, response);
    }

    /**
     * 获取评分规则详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("qc:qcScoringRule:query")
    @GetMapping("/{id}")
    public R<MmpQcScoringRuleVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQcScoringRuleService.queryById(id));
    }

    /**
     * 新增评分规则
     */
    @SaCheckPermission("qc:qcScoringRule:add")
    @Log(title = "评分规则", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQcScoringRuleBo bo) {
        return toAjax(mmpQcScoringRuleService.insertByBo(bo));
    }

    /**
     * 修改评分规则
     */
    @SaCheckPermission("qc:qcScoringRule:edit")
    @Log(title = "评分规则", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQcScoringRuleBo bo) {
        return toAjax(mmpQcScoringRuleService.updateByBo(bo));
    }

    /**
     * 删除评分规则
     *
     * @param ids 主键串
     */
    @SaCheckPermission("qc:qcScoringRule:remove")
    @Log(title = "评分规则", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQcScoringRuleService.deleteWithValidByIds(List.of(ids), true));
    }
}
