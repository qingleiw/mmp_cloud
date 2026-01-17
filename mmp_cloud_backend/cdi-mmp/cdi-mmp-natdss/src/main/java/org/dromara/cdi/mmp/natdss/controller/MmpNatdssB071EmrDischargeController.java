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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB071EmrDischargeVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB071EmrDischargeBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB071EmrDischargeService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B07-1 出院记录
 * 前端访问路由地址为:/natdss/natdssB071EmrDischarge
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB071EmrDischarge")
public class MmpNatdssB071EmrDischargeController extends BaseController {

    private final IMmpNatdssB071EmrDischargeService mmpNatdssB071EmrDischargeService;

    /**
     * 查询B07-1 出院记录列表
     */
    @SaCheckPermission("natdss:natdssB071EmrDischarge:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB071EmrDischargeVo> list(MmpNatdssB071EmrDischargeBo bo, PageQuery pageQuery) {
        return mmpNatdssB071EmrDischargeService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B07-1 出院记录列表
     */
    @SaCheckPermission("natdss:natdssB071EmrDischarge:export")
    @Log(title = "B07-1 出院记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB071EmrDischargeBo bo, HttpServletResponse response) {
        List<MmpNatdssB071EmrDischargeVo> list = mmpNatdssB071EmrDischargeService.queryList(bo);
        ExcelUtil.exportExcel(list, "B07-1 出院记录", MmpNatdssB071EmrDischargeVo.class, response);
    }

    /**
     * 获取B07-1 出院记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB071EmrDischarge:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB071EmrDischargeVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB071EmrDischargeService.queryById(id));
    }

    /**
     * 新增B07-1 出院记录
     */
    @SaCheckPermission("natdss:natdssB071EmrDischarge:add")
    @Log(title = "B07-1 出院记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB071EmrDischargeBo bo) {
        return toAjax(mmpNatdssB071EmrDischargeService.insertByBo(bo));
    }

    /**
     * 修改B07-1 出院记录
     */
    @SaCheckPermission("natdss:natdssB071EmrDischarge:edit")
    @Log(title = "B07-1 出院记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB071EmrDischargeBo bo) {
        return toAjax(mmpNatdssB071EmrDischargeService.updateByBo(bo));
    }

    /**
     * 删除B07-1 出院记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB071EmrDischarge:remove")
    @Log(title = "B07-1 出院记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB071EmrDischargeService.deleteWithValidByIds(List.of(ids), true));
    }
}
