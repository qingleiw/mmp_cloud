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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB191FollowUpVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB191FollowUpBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB191FollowUpService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B19-1 随访记录
 * 前端访问路由地址为:/natdss/natdssB191FollowUp
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB191FollowUp")
public class MmpNatdssB191FollowUpController extends BaseController {

    private final IMmpNatdssB191FollowUpService mmpNatdssB191FollowUpService;

    /**
     * 查询B19-1 随访记录列表
     */
    @SaCheckPermission("natdss:natdssB191FollowUp:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB191FollowUpVo> list(MmpNatdssB191FollowUpBo bo, PageQuery pageQuery) {
        return mmpNatdssB191FollowUpService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B19-1 随访记录列表
     */
    @SaCheckPermission("natdss:natdssB191FollowUp:export")
    @Log(title = "B19-1 随访记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB191FollowUpBo bo, HttpServletResponse response) {
        List<MmpNatdssB191FollowUpVo> list = mmpNatdssB191FollowUpService.queryList(bo);
        ExcelUtil.exportExcel(list, "B19-1 随访记录", MmpNatdssB191FollowUpVo.class, response);
    }

    /**
     * 获取B19-1 随访记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB191FollowUp:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB191FollowUpVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB191FollowUpService.queryById(id));
    }

    /**
     * 新增B19-1 随访记录
     */
    @SaCheckPermission("natdss:natdssB191FollowUp:add")
    @Log(title = "B19-1 随访记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB191FollowUpBo bo) {
        return toAjax(mmpNatdssB191FollowUpService.insertByBo(bo));
    }

    /**
     * 修改B19-1 随访记录
     */
    @SaCheckPermission("natdss:natdssB191FollowUp:edit")
    @Log(title = "B19-1 随访记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB191FollowUpBo bo) {
        return toAjax(mmpNatdssB191FollowUpService.updateByBo(bo));
    }

    /**
     * 删除B19-1 随访记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB191FollowUp:remove")
    @Log(title = "B19-1 随访记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB191FollowUpService.deleteWithValidByIds(List.of(ids), true));
    }
}
