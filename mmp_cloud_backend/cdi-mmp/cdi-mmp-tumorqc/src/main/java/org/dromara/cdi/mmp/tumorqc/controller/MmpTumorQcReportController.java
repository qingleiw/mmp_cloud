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
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcReportVo;
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcReportBo;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcReportService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 肿瘤质控报告
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/tumorQcReport")
public class MmpTumorQcReportController extends BaseController {

    private final IMmpTumorQcReportService mmpTumorQcReportService;

    /**
     * 查询肿瘤质控报告列表
     */
    @SaCheckPermission("system:tumorQcReport:list")
    @GetMapping("/list")
    public TableDataInfo<MmpTumorQcReportVo> list(MmpTumorQcReportBo bo, PageQuery pageQuery) {
        return mmpTumorQcReportService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出肿瘤质控报告列表
     */
    @SaCheckPermission("system:tumorQcReport:export")
    @Log(title = "肿瘤质控报告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpTumorQcReportBo bo, HttpServletResponse response) {
        List<MmpTumorQcReportVo> list = mmpTumorQcReportService.queryList(bo);
        ExcelUtil.exportExcel(list, "肿瘤质控报告", MmpTumorQcReportVo.class, response);
    }

    /**
     * 获取肿瘤质控报告详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:tumorQcReport:query")
    @GetMapping("/{id}")
    public R<MmpTumorQcReportVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpTumorQcReportService.queryById(id));
    }

    /**
     * 新增肿瘤质控报告
     */
    @SaCheckPermission("system:tumorQcReport:add")
    @Log(title = "肿瘤质控报告", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpTumorQcReportBo bo) {
        return toAjax(mmpTumorQcReportService.insertByBo(bo));
    }

    /**
     * 修改肿瘤质控报告
     */
    @SaCheckPermission("system:tumorQcReport:edit")
    @Log(title = "肿瘤质控报告", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpTumorQcReportBo bo) {
        return toAjax(mmpTumorQcReportService.updateByBo(bo));
    }

    /**
     * 删除肿瘤质控报告
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:tumorQcReport:remove")
    @Log(title = "肿瘤质控报告", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpTumorQcReportService.deleteWithValidByIds(List.of(ids), true));
    }
}
