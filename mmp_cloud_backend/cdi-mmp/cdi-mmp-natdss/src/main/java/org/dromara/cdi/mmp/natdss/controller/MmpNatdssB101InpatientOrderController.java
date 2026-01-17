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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB101InpatientOrderVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB101InpatientOrderBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB101InpatientOrderService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B10-1 住院医嘱记录
 * 前端访问路由地址为:/natdss/natdssB101InpatientOrder
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB101InpatientOrder")
public class MmpNatdssB101InpatientOrderController extends BaseController {

    private final IMmpNatdssB101InpatientOrderService mmpNatdssB101InpatientOrderService;

    /**
     * 查询B10-1 住院医嘱记录列表
     */
    @SaCheckPermission("natdss:natdssB101InpatientOrder:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB101InpatientOrderVo> list(MmpNatdssB101InpatientOrderBo bo, PageQuery pageQuery) {
        return mmpNatdssB101InpatientOrderService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B10-1 住院医嘱记录列表
     */
    @SaCheckPermission("natdss:natdssB101InpatientOrder:export")
    @Log(title = "B10-1 住院医嘱记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB101InpatientOrderBo bo, HttpServletResponse response) {
        List<MmpNatdssB101InpatientOrderVo> list = mmpNatdssB101InpatientOrderService.queryList(bo);
        ExcelUtil.exportExcel(list, "B10-1 住院医嘱记录", MmpNatdssB101InpatientOrderVo.class, response);
    }

    /**
     * 获取B10-1 住院医嘱记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB101InpatientOrder:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB101InpatientOrderVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB101InpatientOrderService.queryById(id));
    }

    /**
     * 新增B10-1 住院医嘱记录
     */
    @SaCheckPermission("natdss:natdssB101InpatientOrder:add")
    @Log(title = "B10-1 住院医嘱记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB101InpatientOrderBo bo) {
        return toAjax(mmpNatdssB101InpatientOrderService.insertByBo(bo));
    }

    /**
     * 修改B10-1 住院医嘱记录
     */
    @SaCheckPermission("natdss:natdssB101InpatientOrder:edit")
    @Log(title = "B10-1 住院医嘱记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB101InpatientOrderBo bo) {
        return toAjax(mmpNatdssB101InpatientOrderService.updateByBo(bo));
    }

    /**
     * 删除B10-1 住院医嘱记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB101InpatientOrder:remove")
    @Log(title = "B10-1 住院医嘱记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB101InpatientOrderService.deleteWithValidByIds(List.of(ids), true));
    }
}
