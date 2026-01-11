package org.dromara.cdi.mmp.tumorqc.controller;

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
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcPlanVo;
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcPlanBo;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcPlanService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 肿瘤质控方案
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/tumorQcPlan")
public class MmpTumorQcPlanController extends BaseController {

    private final IMmpTumorQcPlanService mmpTumorQcPlanService;

    /**
     * 查询肿瘤质控方案列表
     */
    @SaCheckPermission("system:tumorQcPlan:list")
    @GetMapping("/list")
    public TableDataInfo<MmpTumorQcPlanVo> list(MmpTumorQcPlanBo bo, PageQuery pageQuery) {
        return mmpTumorQcPlanService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出肿瘤质控方案列表
     */
    @SaCheckPermission("system:tumorQcPlan:export")
    @Log(title = "肿瘤质控方案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpTumorQcPlanBo bo, HttpServletResponse response) {
        List<MmpTumorQcPlanVo> list = mmpTumorQcPlanService.queryList(bo);
        ExcelUtil.exportExcel(list, "肿瘤质控方案", MmpTumorQcPlanVo.class, response);
    }

    /**
     * 获取肿瘤质控方案详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:tumorQcPlan:query")
    @GetMapping("/{id}")
    public R<MmpTumorQcPlanVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpTumorQcPlanService.queryById(id));
    }

    /**
     * 新增肿瘤质控方案
     */
    @SaCheckPermission("system:tumorQcPlan:add")
    @Log(title = "肿瘤质控方案", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpTumorQcPlanBo bo) {
        return toAjax(mmpTumorQcPlanService.insertByBo(bo));
    }

    /**
     * 修改肿瘤质控方案
     */
    @SaCheckPermission("system:tumorQcPlan:edit")
    @Log(title = "肿瘤质控方案", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpTumorQcPlanBo bo) {
        return toAjax(mmpTumorQcPlanService.updateByBo(bo));
    }

    /**
     * 删除肿瘤质控方案
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:tumorQcPlan:remove")
    @Log(title = "肿瘤质控方案", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpTumorQcPlanService.deleteWithValidByIds(List.of(ids), true));
    }
}
