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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB181RadInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB181RadInfoBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB181RadInfoService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B18-1 临床放疗记录
 * 前端访问路由地址为:/natdss/natdssB181RadInfo
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB181RadInfo")
public class MmpNatdssB181RadInfoController extends BaseController {

    private final IMmpNatdssB181RadInfoService mmpNatdssB181RadInfoService;

    /**
     * 查询B18-1 临床放疗记录列表
     */
    @SaCheckPermission("natdss:natdssB181RadInfo:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB181RadInfoVo> list(MmpNatdssB181RadInfoBo bo, PageQuery pageQuery) {
        return mmpNatdssB181RadInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B18-1 临床放疗记录列表
     */
    @SaCheckPermission("natdss:natdssB181RadInfo:export")
    @Log(title = "B18-1 临床放疗记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB181RadInfoBo bo, HttpServletResponse response) {
        List<MmpNatdssB181RadInfoVo> list = mmpNatdssB181RadInfoService.queryList(bo);
        ExcelUtil.exportExcel(list, "B18-1 临床放疗记录", MmpNatdssB181RadInfoVo.class, response);
    }

    /**
     * 获取B18-1 临床放疗记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB181RadInfo:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB181RadInfoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB181RadInfoService.queryById(id));
    }

    /**
     * 新增B18-1 临床放疗记录
     */
    @SaCheckPermission("natdss:natdssB181RadInfo:add")
    @Log(title = "B18-1 临床放疗记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB181RadInfoBo bo) {
        return toAjax(mmpNatdssB181RadInfoService.insertByBo(bo));
    }

    /**
     * 修改B18-1 临床放疗记录
     */
    @SaCheckPermission("natdss:natdssB181RadInfo:edit")
    @Log(title = "B18-1 临床放疗记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB181RadInfoBo bo) {
        return toAjax(mmpNatdssB181RadInfoService.updateByBo(bo));
    }

    /**
     * 删除B18-1 临床放疗记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB181RadInfo:remove")
    @Log(title = "B18-1 临床放疗记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB181RadInfoService.deleteWithValidByIds(List.of(ids), true));
    }
}
