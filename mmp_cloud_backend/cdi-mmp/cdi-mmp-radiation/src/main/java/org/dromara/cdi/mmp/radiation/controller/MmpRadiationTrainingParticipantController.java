package org.dromara.cdi.mmp.radiation.controller;

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
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationTrainingParticipantVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationTrainingParticipantBo;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationTrainingParticipantService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 培训参与记录
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/radiationTrainingParticipant")
public class MmpRadiationTrainingParticipantController extends BaseController {

    private final IMmpRadiationTrainingParticipantService mmpRadiationTrainingParticipantService;

    /**
     * 查询培训参与记录列表
     */
    @SaCheckPermission("radiation:radiationTrainingParticipant:list")
    @GetMapping("/list")
    public TableDataInfo<MmpRadiationTrainingParticipantVo> list(MmpRadiationTrainingParticipantBo bo, PageQuery pageQuery) {
        return mmpRadiationTrainingParticipantService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出培训参与记录列表
     */
    @SaCheckPermission("radiation:radiationTrainingParticipant:export")
    @Log(title = "培训参与记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpRadiationTrainingParticipantBo bo, HttpServletResponse response) {
        List<MmpRadiationTrainingParticipantVo> list = mmpRadiationTrainingParticipantService.queryList(bo);
        ExcelUtil.exportExcel(list, "培训参与记录", MmpRadiationTrainingParticipantVo.class, response);
    }

    /**
     * 获取培训参与记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("radiation:radiationTrainingParticipant:query")
    @GetMapping("/{id}")
    public R<MmpRadiationTrainingParticipantVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpRadiationTrainingParticipantService.queryById(id));
    }

    /**
     * 新增培训参与记录
     */
    @SaCheckPermission("radiation:radiationTrainingParticipant:add")
    @Log(title = "培训参与记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpRadiationTrainingParticipantBo bo) {
        return toAjax(mmpRadiationTrainingParticipantService.insertByBo(bo));
    }

    /**
     * 修改培训参与记录
     */
    @SaCheckPermission("radiation:radiationTrainingParticipant:edit")
    @Log(title = "培训参与记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpRadiationTrainingParticipantBo bo) {
        return toAjax(mmpRadiationTrainingParticipantService.updateByBo(bo));
    }

    /**
     * 删除培训参与记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("radiation:radiationTrainingParticipant:remove")
    @Log(title = "培训参与记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpRadiationTrainingParticipantService.deleteWithValidByIds(List.of(ids), true));
    }
}
