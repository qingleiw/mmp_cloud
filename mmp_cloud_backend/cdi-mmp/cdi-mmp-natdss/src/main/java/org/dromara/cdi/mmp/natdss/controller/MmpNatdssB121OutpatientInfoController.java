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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB121OutpatientInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB121OutpatientInfoBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB121OutpatientInfoService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B12-1 门诊患者信息
 * 前端访问路由地址为:/natdss/natdssB121OutpatientInfo
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB121OutpatientInfo")
public class MmpNatdssB121OutpatientInfoController extends BaseController {

    private final IMmpNatdssB121OutpatientInfoService mmpNatdssB121OutpatientInfoService;

    /**
     * 查询B12-1 门诊患者信息列表
     */
    @SaCheckPermission("natdss:natdssB121OutpatientInfo:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB121OutpatientInfoVo> list(MmpNatdssB121OutpatientInfoBo bo, PageQuery pageQuery) {
        return mmpNatdssB121OutpatientInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B12-1 门诊患者信息列表
     */
    @SaCheckPermission("natdss:natdssB121OutpatientInfo:export")
    @Log(title = "B12-1 门诊患者信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB121OutpatientInfoBo bo, HttpServletResponse response) {
        List<MmpNatdssB121OutpatientInfoVo> list = mmpNatdssB121OutpatientInfoService.queryList(bo);
        ExcelUtil.exportExcel(list, "B12-1 门诊患者信息", MmpNatdssB121OutpatientInfoVo.class, response);
    }

    /**
     * 获取B12-1 门诊患者信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB121OutpatientInfo:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB121OutpatientInfoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB121OutpatientInfoService.queryById(id));
    }

    /**
     * 新增B12-1 门诊患者信息
     */
    @SaCheckPermission("natdss:natdssB121OutpatientInfo:add")
    @Log(title = "B12-1 门诊患者信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB121OutpatientInfoBo bo) {
        return toAjax(mmpNatdssB121OutpatientInfoService.insertByBo(bo));
    }

    /**
     * 修改B12-1 门诊患者信息
     */
    @SaCheckPermission("natdss:natdssB121OutpatientInfo:edit")
    @Log(title = "B12-1 门诊患者信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB121OutpatientInfoBo bo) {
        return toAjax(mmpNatdssB121OutpatientInfoService.updateByBo(bo));
    }

    /**
     * 删除B12-1 门诊患者信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB121OutpatientInfo:remove")
    @Log(title = "B12-1 门诊患者信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB121OutpatientInfoService.deleteWithValidByIds(List.of(ids), true));
    }
}
