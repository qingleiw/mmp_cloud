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
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationHealthExamVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationHealthExamBo;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationHealthExamService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 职业健康体检
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/radiationHealthExam")
public class MmpRadiationHealthExamController extends BaseController {

    private final IMmpRadiationHealthExamService mmpRadiationHealthExamService;

    /**
     * 查询职业健康体检列表
     */
    @SaCheckPermission("system:radiationHealthExam:list")
    @GetMapping("/list")
    public TableDataInfo<MmpRadiationHealthExamVo> list(MmpRadiationHealthExamBo bo, PageQuery pageQuery) {
        return mmpRadiationHealthExamService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出职业健康体检列表
     */
    @SaCheckPermission("system:radiationHealthExam:export")
    @Log(title = "职业健康体检", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpRadiationHealthExamBo bo, HttpServletResponse response) {
        List<MmpRadiationHealthExamVo> list = mmpRadiationHealthExamService.queryList(bo);
        ExcelUtil.exportExcel(list, "职业健康体检", MmpRadiationHealthExamVo.class, response);
    }

    /**
     * 获取职业健康体检详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:radiationHealthExam:query")
    @GetMapping("/{id}")
    public R<MmpRadiationHealthExamVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpRadiationHealthExamService.queryById(id));
    }

    /**
     * 新增职业健康体检
     */
    @SaCheckPermission("system:radiationHealthExam:add")
    @Log(title = "职业健康体检", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpRadiationHealthExamBo bo) {
        return toAjax(mmpRadiationHealthExamService.insertByBo(bo));
    }

    /**
     * 修改职业健康体检
     */
    @SaCheckPermission("system:radiationHealthExam:edit")
    @Log(title = "职业健康体检", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpRadiationHealthExamBo bo) {
        return toAjax(mmpRadiationHealthExamService.updateByBo(bo));
    }

    /**
     * 删除职业健康体检
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:radiationHealthExam:remove")
    @Log(title = "职业健康体检", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpRadiationHealthExamService.deleteWithValidByIds(List.of(ids), true));
    }
}
