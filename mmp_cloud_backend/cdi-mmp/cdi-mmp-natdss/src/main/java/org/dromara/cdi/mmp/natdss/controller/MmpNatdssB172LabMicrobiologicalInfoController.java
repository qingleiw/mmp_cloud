package org.dromara.cdi.mmp.natdss.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.common.web.core.BaseController;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB172LabMicrobiologicalInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB172LabMicrobiologicalInfoBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB172LabMicrobiologicalInfoService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B172 微生物检验记录
 * 前端访问路由地址为:/natdss/natdssB172LabMicrobiologicalInfo
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB172LabMicrobiologicalInfo")
public class MmpNatdssB172LabMicrobiologicalInfoController extends BaseController {

    private final IMmpNatdssB172LabMicrobiologicalInfoService mmpNatdssB172LabMicrobiologicalInfoService;

    /**
     * 查询B172 微生物检验记录列表
     */
    @SaCheckPermission("natdss:natdssB172LabMicrobiologicalInfo:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB172LabMicrobiologicalInfoVo> list(MmpNatdssB172LabMicrobiologicalInfoBo bo, PageQuery pageQuery) {
        return mmpNatdssB172LabMicrobiologicalInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B172 微生物检验记录列表
     */
    @SaCheckPermission("natdss:natdssB172LabMicrobiologicalInfo:export")
    @Log(title = "B172 微生物检验记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB172LabMicrobiologicalInfoBo bo, HttpServletResponse response) {
        List<MmpNatdssB172LabMicrobiologicalInfoVo> list = mmpNatdssB172LabMicrobiologicalInfoService.queryList(bo);
        ExcelUtil.exportExcel(list, "B172 微生物检验记录", MmpNatdssB172LabMicrobiologicalInfoVo.class, response);
    }

    /**
     * 获取B172 微生物检验记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB172LabMicrobiologicalInfo:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB172LabMicrobiologicalInfoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB172LabMicrobiologicalInfoService.queryById(id));
    }

    /**
     * 新增B172 微生物检验记录
     */
    @SaCheckPermission("natdss:natdssB172LabMicrobiologicalInfo:add")
    @Log(title = "B172 微生物检验记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB172LabMicrobiologicalInfoBo bo) {
        return toAjax(mmpNatdssB172LabMicrobiologicalInfoService.insertByBo(bo));
    }

    /**
     * 修改B172 微生物检验记录
     */
    @SaCheckPermission("natdss:natdssB172LabMicrobiologicalInfo:edit")
    @Log(title = "B172 微生物检验记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB172LabMicrobiologicalInfoBo bo) {
        return toAjax(mmpNatdssB172LabMicrobiologicalInfoService.updateByBo(bo));
    }

    /**
     * 删除B172 微生物检验记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB172LabMicrobiologicalInfo:remove")
    @Log(title = "B172 微生物检验记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB172LabMicrobiologicalInfoService.deleteWithValidByIds(List.of(ids), true));
    }
}
