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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB011DrugPurchaseVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB011DrugPurchaseBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB011DrugPurchaseService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B01-1 抗肿瘤药物采购记录
 * 前端访问路由地址为:/natdss/natdssB011DrugPurchase
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB011DrugPurchase")
public class MmpNatdssB011DrugPurchaseController extends BaseController {

    private final IMmpNatdssB011DrugPurchaseService mmpNatdssB011DrugPurchaseService;

    /**
     * 查询B01-1 抗肿瘤药物采购记录列表
     */
    @SaCheckPermission("natdss:natdssB011DrugPurchase:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB011DrugPurchaseVo> list(MmpNatdssB011DrugPurchaseBo bo, PageQuery pageQuery) {
        return mmpNatdssB011DrugPurchaseService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B01-1 抗肿瘤药物采购记录列表
     */
    @SaCheckPermission("natdss:natdssB011DrugPurchase:export")
    @Log(title = "B01-1 抗肿瘤药物采购记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB011DrugPurchaseBo bo, HttpServletResponse response) {
        List<MmpNatdssB011DrugPurchaseVo> list = mmpNatdssB011DrugPurchaseService.queryList(bo);
        ExcelUtil.exportExcel(list, "B01-1 抗肿瘤药物采购记录", MmpNatdssB011DrugPurchaseVo.class, response);
    }

    /**
     * 获取B01-1 抗肿瘤药物采购记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB011DrugPurchase:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB011DrugPurchaseVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB011DrugPurchaseService.queryById(id));
    }

    /**
     * 新增B01-1 抗肿瘤药物采购记录
     */
    @SaCheckPermission("natdss:natdssB011DrugPurchase:add")
    @Log(title = "B01-1 抗肿瘤药物采购记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB011DrugPurchaseBo bo) {
        return toAjax(mmpNatdssB011DrugPurchaseService.insertByBo(bo));
    }

    /**
     * 修改B01-1 抗肿瘤药物采购记录
     */
    @SaCheckPermission("natdss:natdssB011DrugPurchase:edit")
    @Log(title = "B01-1 抗肿瘤药物采购记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB011DrugPurchaseBo bo) {
        return toAjax(mmpNatdssB011DrugPurchaseService.updateByBo(bo));
    }

    /**
     * 删除B01-1 抗肿瘤药物采购记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB011DrugPurchase:remove")
    @Log(title = "B01-1 抗肿瘤药物采购记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB011DrugPurchaseService.deleteWithValidByIds(List.of(ids), true));
    }
}
