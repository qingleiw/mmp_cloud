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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB031InpatientInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB031InpatientInfoBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB031InpatientInfoService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B03-1 住院患者信息
 * 前端访问路由地址为:/natdss/natdssB031InpatientInfo
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB031InpatientInfo")
public class MmpNatdssB031InpatientInfoController extends BaseController {

    private final IMmpNatdssB031InpatientInfoService mmpNatdssB031InpatientInfoService;

    /**
     * 查询B03-1 住院患者信息列表
     */
    @SaCheckPermission("natdss:natdssB031InpatientInfo:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB031InpatientInfoVo> list(MmpNatdssB031InpatientInfoBo bo, PageQuery pageQuery) {
        return mmpNatdssB031InpatientInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B03-1 住院患者信息列表
     */
    @SaCheckPermission("natdss:natdssB031InpatientInfo:export")
    @Log(title = "B03-1 住院患者信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB031InpatientInfoBo bo, HttpServletResponse response) {
        List<MmpNatdssB031InpatientInfoVo> list = mmpNatdssB031InpatientInfoService.queryList(bo);
        ExcelUtil.exportExcel(list, "B03-1 住院患者信息", MmpNatdssB031InpatientInfoVo.class, response);
    }

    /**
     * 获取B03-1 住院患者信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB031InpatientInfo:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB031InpatientInfoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB031InpatientInfoService.queryById(id));
    }

    /**
     * 新增B03-1 住院患者信息
     */
    @SaCheckPermission("natdss:natdssB031InpatientInfo:add")
    @Log(title = "B03-1 住院患者信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB031InpatientInfoBo bo) {
        return toAjax(mmpNatdssB031InpatientInfoService.insertByBo(bo));
    }

    /**
     * 修改B03-1 住院患者信息
     */
    @SaCheckPermission("natdss:natdssB031InpatientInfo:edit")
    @Log(title = "B03-1 住院患者信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB031InpatientInfoBo bo) {
        return toAjax(mmpNatdssB031InpatientInfoService.updateByBo(bo));
    }

    /**
     * 删除B03-1 住院患者信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB031InpatientInfo:remove")
    @Log(title = "B03-1 住院患者信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB031InpatientInfoService.deleteWithValidByIds(List.of(ids), true));
    }
}
