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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB141OutpatientOrderAndPresVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB141OutpatientOrderAndPresBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB141OutpatientOrderAndPresService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B14-1 门诊医嘱处方记录
 * 前端访问路由地址为:/natdss/natdssB141OutpatientOrderAndPres
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB141OutpatientOrderAndPres")
public class MmpNatdssB141OutpatientOrderAndPresController extends BaseController {

    private final IMmpNatdssB141OutpatientOrderAndPresService mmpNatdssB141OutpatientOrderAndPresService;

    /**
     * 查询B14-1 门诊医嘱处方记录列表
     */
    @SaCheckPermission("natdss:natdssB141OutpatientOrderAndPres:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB141OutpatientOrderAndPresVo> list(MmpNatdssB141OutpatientOrderAndPresBo bo, PageQuery pageQuery) {
        return mmpNatdssB141OutpatientOrderAndPresService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B14-1 门诊医嘱处方记录列表
     */
    @SaCheckPermission("natdss:natdssB141OutpatientOrderAndPres:export")
    @Log(title = "B14-1 门诊医嘱处方记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB141OutpatientOrderAndPresBo bo, HttpServletResponse response) {
        List<MmpNatdssB141OutpatientOrderAndPresVo> list = mmpNatdssB141OutpatientOrderAndPresService.queryList(bo);
        ExcelUtil.exportExcel(list, "B14-1 门诊医嘱处方记录", MmpNatdssB141OutpatientOrderAndPresVo.class, response);
    }

    /**
     * 获取B14-1 门诊医嘱处方记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB141OutpatientOrderAndPres:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB141OutpatientOrderAndPresVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB141OutpatientOrderAndPresService.queryById(id));
    }

    /**
     * 新增B14-1 门诊医嘱处方记录
     */
    @SaCheckPermission("natdss:natdssB141OutpatientOrderAndPres:add")
    @Log(title = "B14-1 门诊医嘱处方记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB141OutpatientOrderAndPresBo bo) {
        return toAjax(mmpNatdssB141OutpatientOrderAndPresService.insertByBo(bo));
    }

    /**
     * 修改B14-1 门诊医嘱处方记录
     */
    @SaCheckPermission("natdss:natdssB141OutpatientOrderAndPres:edit")
    @Log(title = "B14-1 门诊医嘱处方记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB141OutpatientOrderAndPresBo bo) {
        return toAjax(mmpNatdssB141OutpatientOrderAndPresService.updateByBo(bo));
    }

    /**
     * 删除B14-1 门诊医嘱处方记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB141OutpatientOrderAndPres:remove")
    @Log(title = "B14-1 门诊医嘱处方记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB141OutpatientOrderAndPresService.deleteWithValidByIds(List.of(ids), true));
    }
}
