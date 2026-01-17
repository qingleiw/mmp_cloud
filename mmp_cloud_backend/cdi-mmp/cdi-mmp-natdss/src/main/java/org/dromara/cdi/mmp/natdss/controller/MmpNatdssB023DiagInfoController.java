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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB023DiagInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB023DiagInfoBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB023DiagInfoService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B02-3 患者诊断记录
 * 前端访问路由地址为:/natdss/natdssB023DiagInfo
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB023DiagInfo")
public class MmpNatdssB023DiagInfoController extends BaseController {

    private final IMmpNatdssB023DiagInfoService mmpNatdssB023DiagInfoService;

    /**
     * 查询B02-3 患者诊断记录列表
     */
    @SaCheckPermission("natdss:natdssB023DiagInfo:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB023DiagInfoVo> list(MmpNatdssB023DiagInfoBo bo, PageQuery pageQuery) {
        return mmpNatdssB023DiagInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B02-3 患者诊断记录列表
     */
    @SaCheckPermission("natdss:natdssB023DiagInfo:export")
    @Log(title = "B02-3 患者诊断记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB023DiagInfoBo bo, HttpServletResponse response) {
        List<MmpNatdssB023DiagInfoVo> list = mmpNatdssB023DiagInfoService.queryList(bo);
        ExcelUtil.exportExcel(list, "B02-3 患者诊断记录", MmpNatdssB023DiagInfoVo.class, response);
    }

    /**
     * 获取B02-3 患者诊断记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB023DiagInfo:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB023DiagInfoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB023DiagInfoService.queryById(id));
    }

    /**
     * 新增B02-3 患者诊断记录
     */
    @SaCheckPermission("natdss:natdssB023DiagInfo:add")
    @Log(title = "B02-3 患者诊断记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB023DiagInfoBo bo) {
        return toAjax(mmpNatdssB023DiagInfoService.insertByBo(bo));
    }

    /**
     * 修改B02-3 患者诊断记录
     */
    @SaCheckPermission("natdss:natdssB023DiagInfo:edit")
    @Log(title = "B02-3 患者诊断记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB023DiagInfoBo bo) {
        return toAjax(mmpNatdssB023DiagInfoService.updateByBo(bo));
    }

    /**
     * 删除B02-3 患者诊断记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB023DiagInfo:remove")
    @Log(title = "B02-3 患者诊断记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB023DiagInfoService.deleteWithValidByIds(List.of(ids), true));
    }
}
