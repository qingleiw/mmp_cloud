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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB022AdrInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB022AdrInfoBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB022AdrInfoService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B02-2 患者药物不良反应记录
 * 前端访问路由地址为:/natdss/natdssB022AdrInfo
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB022AdrInfo")
public class MmpNatdssB022AdrInfoController extends BaseController {

    private final IMmpNatdssB022AdrInfoService mmpNatdssB022AdrInfoService;

    /**
     * 查询B02-2 患者药物不良反应记录列表
     */
    @SaCheckPermission("natdss:natdssB022AdrInfo:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB022AdrInfoVo> list(MmpNatdssB022AdrInfoBo bo, PageQuery pageQuery) {
        return mmpNatdssB022AdrInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B02-2 患者药物不良反应记录列表
     */
    @SaCheckPermission("natdss:natdssB022AdrInfo:export")
    @Log(title = "B02-2 患者药物不良反应记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB022AdrInfoBo bo, HttpServletResponse response) {
        List<MmpNatdssB022AdrInfoVo> list = mmpNatdssB022AdrInfoService.queryList(bo);
        ExcelUtil.exportExcel(list, "B02-2 患者药物不良反应记录", MmpNatdssB022AdrInfoVo.class, response);
    }

    /**
     * 获取B02-2 患者药物不良反应记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB022AdrInfo:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB022AdrInfoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB022AdrInfoService.queryById(id));
    }

    /**
     * 新增B02-2 患者药物不良反应记录
     */
    @SaCheckPermission("natdss:natdssB022AdrInfo:add")
    @Log(title = "B02-2 患者药物不良反应记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB022AdrInfoBo bo) {
        return toAjax(mmpNatdssB022AdrInfoService.insertByBo(bo));
    }

    /**
     * 修改B02-2 患者药物不良反应记录
     */
    @SaCheckPermission("natdss:natdssB022AdrInfo:edit")
    @Log(title = "B02-2 患者药物不良反应记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB022AdrInfoBo bo) {
        return toAjax(mmpNatdssB022AdrInfoService.updateByBo(bo));
    }

    /**
     * 删除B02-2 患者药物不良反应记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB022AdrInfo:remove")
    @Log(title = "B02-2 患者药物不良反应记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB022AdrInfoService.deleteWithValidByIds(List.of(ids), true));
    }
}
