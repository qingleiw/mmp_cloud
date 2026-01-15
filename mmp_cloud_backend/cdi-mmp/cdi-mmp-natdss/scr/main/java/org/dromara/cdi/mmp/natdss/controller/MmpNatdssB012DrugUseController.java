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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB012DrugUseVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB012DrugUseBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB012DrugUseService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B01-2 抗肿瘤药物使用记录
 * 前端访问路由地址为:/natdss/natdssB012DrugUse
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB012DrugUse")
public class MmpNatdssB012DrugUseController extends BaseController {

    private final IMmpNatdssB012DrugUseService mmpNatdssB012DrugUseService;

    /**
     * 查询B01-2 抗肿瘤药物使用记录列表
     */
    @SaCheckPermission("natdss:natdssB012DrugUse:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB012DrugUseVo> list(MmpNatdssB012DrugUseBo bo, PageQuery pageQuery) {
        return mmpNatdssB012DrugUseService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B01-2 抗肿瘤药物使用记录列表
     */
    @SaCheckPermission("natdss:natdssB012DrugUse:export")
    @Log(title = "B01-2 抗肿瘤药物使用记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB012DrugUseBo bo, HttpServletResponse response) {
        List<MmpNatdssB012DrugUseVo> list = mmpNatdssB012DrugUseService.queryList(bo);
        ExcelUtil.exportExcel(list, "B01-2 抗肿瘤药物使用记录", MmpNatdssB012DrugUseVo.class, response);
    }

    /**
     * 获取B01-2 抗肿瘤药物使用记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB012DrugUse:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB012DrugUseVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB012DrugUseService.queryById(id));
    }

    /**
     * 新增B01-2 抗肿瘤药物使用记录
     */
    @SaCheckPermission("natdss:natdssB012DrugUse:add")
    @Log(title = "B01-2 抗肿瘤药物使用记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB012DrugUseBo bo) {
        return toAjax(mmpNatdssB012DrugUseService.insertByBo(bo));
    }

    /**
     * 修改B01-2 抗肿瘤药物使用记录
     */
    @SaCheckPermission("natdss:natdssB012DrugUse:edit")
    @Log(title = "B01-2 抗肿瘤药物使用记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB012DrugUseBo bo) {
        return toAjax(mmpNatdssB012DrugUseService.updateByBo(bo));
    }

    /**
     * 删除B01-2 抗肿瘤药物使用记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB012DrugUse:remove")
    @Log(title = "B01-2 抗肿瘤药物使用记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB012DrugUseService.deleteWithValidByIds(List.of(ids), true));
    }
}
