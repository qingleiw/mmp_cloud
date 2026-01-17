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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB17-2LabMicrobiologicalInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB17-2LabMicrobiologicalInfoBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB17-2LabMicrobiologicalInfoService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B17-2 微生物检验记录
 * 前端访问路由地址为:/natdss/natdssB17-2LabMicrobiologicalInfo
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB17-2LabMicrobiologicalInfo")
public class MmpNatdssB17-2LabMicrobiologicalInfoController extends BaseController {

    private final IMmpNatdssB17-2LabMicrobiologicalInfoService mmpNatdssB17-2LabMicrobiologicalInfoService;

    /**
     * 查询B17-2 微生物检验记录列表
     */
    @SaCheckPermission("natdss:natdssB17-2LabMicrobiologicalInfo:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB17-2LabMicrobiologicalInfoVo> list(MmpNatdssB17-2LabMicrobiologicalInfoBo bo, PageQuery pageQuery) {
        return mmpNatdssB17-2LabMicrobiologicalInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B17-2 微生物检验记录列表
     */
    @SaCheckPermission("natdss:natdssB17-2LabMicrobiologicalInfo:export")
    @Log(title = "B17-2 微生物检验记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB17-2LabMicrobiologicalInfoBo bo, HttpServletResponse response) {
        List<MmpNatdssB17-2LabMicrobiologicalInfoVo> list = mmpNatdssB17-2LabMicrobiologicalInfoService.queryList(bo);
        ExcelUtil.exportExcel(list, "B17-2 微生物检验记录", MmpNatdssB17-2LabMicrobiologicalInfoVo.class, response);
    }

    /**
     * 获取B17-2 微生物检验记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB17-2LabMicrobiologicalInfo:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB17-2LabMicrobiologicalInfoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB17-2LabMicrobiologicalInfoService.queryById(id));
    }

    /**
     * 新增B17-2 微生物检验记录
     */
    @SaCheckPermission("natdss:natdssB17-2LabMicrobiologicalInfo:add")
    @Log(title = "B17-2 微生物检验记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB17-2LabMicrobiologicalInfoBo bo) {
        return toAjax(mmpNatdssB17-2LabMicrobiologicalInfoService.insertByBo(bo));
    }

    /**
     * 修改B17-2 微生物检验记录
     */
    @SaCheckPermission("natdss:natdssB17-2LabMicrobiologicalInfo:edit")
    @Log(title = "B17-2 微生物检验记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB17-2LabMicrobiologicalInfoBo bo) {
        return toAjax(mmpNatdssB17-2LabMicrobiologicalInfoService.updateByBo(bo));
    }

    /**
     * 删除B17-2 微生物检验记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB17-2LabMicrobiologicalInfo:remove")
    @Log(title = "B17-2 微生物检验记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB17-2LabMicrobiologicalInfoService.deleteWithValidByIds(List.of(ids), true));
    }
}
