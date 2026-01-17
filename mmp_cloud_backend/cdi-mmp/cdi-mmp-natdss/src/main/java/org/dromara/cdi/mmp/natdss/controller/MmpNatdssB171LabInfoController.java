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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB171LabInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB171LabInfoBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB171LabInfoService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B17-1 常规检验记录
 * 前端访问路由地址为:/natdss/natdssB171LabInfo
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB171LabInfo")
public class MmpNatdssB171LabInfoController extends BaseController {

    private final IMmpNatdssB171LabInfoService mmpNatdssB171LabInfoService;

    /**
     * 查询B17-1 常规检验记录列表
     */
    @SaCheckPermission("natdss:natdssB171LabInfo:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB171LabInfoVo> list(MmpNatdssB171LabInfoBo bo, PageQuery pageQuery) {
        return mmpNatdssB171LabInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B17-1 常规检验记录列表
     */
    @SaCheckPermission("natdss:natdssB171LabInfo:export")
    @Log(title = "B17-1 常规检验记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB171LabInfoBo bo, HttpServletResponse response) {
        List<MmpNatdssB171LabInfoVo> list = mmpNatdssB171LabInfoService.queryList(bo);
        ExcelUtil.exportExcel(list, "B17-1 常规检验记录", MmpNatdssB171LabInfoVo.class, response);
    }

    /**
     * 获取B17-1 常规检验记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB171LabInfo:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB171LabInfoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB171LabInfoService.queryById(id));
    }

    /**
     * 新增B17-1 常规检验记录
     */
    @SaCheckPermission("natdss:natdssB171LabInfo:add")
    @Log(title = "B17-1 常规检验记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB171LabInfoBo bo) {
        return toAjax(mmpNatdssB171LabInfoService.insertByBo(bo));
    }

    /**
     * 修改B17-1 常规检验记录
     */
    @SaCheckPermission("natdss:natdssB171LabInfo:edit")
    @Log(title = "B17-1 常规检验记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB171LabInfoBo bo) {
        return toAjax(mmpNatdssB171LabInfoService.updateByBo(bo));
    }

    /**
     * 删除B17-1 常规检验记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB171LabInfo:remove")
    @Log(title = "B17-1 常规检验记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB171LabInfoService.deleteWithValidByIds(List.of(ids), true));
    }
}
