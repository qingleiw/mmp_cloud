package org.dromara.cdi.mmp.surgery.controller;

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
import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryTeamVo;
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryTeamBo;
import org.dromara.cdi.mmp.surgery.service.IMmpSurgeryTeamService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 手术团队
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/surgeryTeam")
public class MmpSurgeryTeamController extends BaseController {

    private final IMmpSurgeryTeamService mmpSurgeryTeamService;

    /**
     * 查询手术团队列表
     */
    @SaCheckPermission("surgery:surgeryTeam:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSurgeryTeamVo> list(MmpSurgeryTeamBo bo, PageQuery pageQuery) {
        return mmpSurgeryTeamService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出手术团队列表
     */
    @SaCheckPermission("surgery:surgeryTeam:export")
    @Log(title = "手术团队", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSurgeryTeamBo bo, HttpServletResponse response) {
        List<MmpSurgeryTeamVo> list = mmpSurgeryTeamService.queryList(bo);
        ExcelUtil.exportExcel(list, "手术团队", MmpSurgeryTeamVo.class, response);
    }

    /**
     * 获取手术团队详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("surgery:surgeryTeam:query")
    @GetMapping("/{id}")
    public R<MmpSurgeryTeamVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSurgeryTeamService.queryById(id));
    }

    /**
     * 新增手术团队
     */
    @SaCheckPermission("surgery:surgeryTeam:add")
    @Log(title = "手术团队", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSurgeryTeamBo bo) {
        return toAjax(mmpSurgeryTeamService.insertByBo(bo));
    }

    /**
     * 修改手术团队
     */
    @SaCheckPermission("surgery:surgeryTeam:edit")
    @Log(title = "手术团队", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSurgeryTeamBo bo) {
        return toAjax(mmpSurgeryTeamService.updateByBo(bo));
    }

    /**
     * 删除手术团队
     *
     * @param ids 主键串
     */
    @SaCheckPermission("surgery:surgeryTeam:remove")
    @Log(title = "手术团队", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSurgeryTeamService.deleteWithValidByIds(List.of(ids), true));
    }
}
