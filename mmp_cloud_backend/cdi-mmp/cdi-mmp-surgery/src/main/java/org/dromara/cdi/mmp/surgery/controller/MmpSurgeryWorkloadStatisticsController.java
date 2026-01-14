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
import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryWorkloadStatisticsVo;
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryWorkloadStatisticsBo;
import org.dromara.cdi.mmp.surgery.service.IMmpSurgeryWorkloadStatisticsService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 手术工作量统计
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/surgeryWorkloadStatistics")
public class MmpSurgeryWorkloadStatisticsController extends BaseController {

    private final IMmpSurgeryWorkloadStatisticsService mmpSurgeryWorkloadStatisticsService;

    /**
     * 查询手术工作量统计列表
     */
    @SaCheckPermission("surgery:surgeryWorkloadStatistics:list")
    @GetMapping("/list")
    public TableDataInfo<MmpSurgeryWorkloadStatisticsVo> list(MmpSurgeryWorkloadStatisticsBo bo, PageQuery pageQuery) {
        return mmpSurgeryWorkloadStatisticsService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出手术工作量统计列表
     */
    @SaCheckPermission("surgery:surgeryWorkloadStatistics:export")
    @Log(title = "手术工作量统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpSurgeryWorkloadStatisticsBo bo, HttpServletResponse response) {
        List<MmpSurgeryWorkloadStatisticsVo> list = mmpSurgeryWorkloadStatisticsService.queryList(bo);
        ExcelUtil.exportExcel(list, "手术工作量统计", MmpSurgeryWorkloadStatisticsVo.class, response);
    }

    /**
     * 获取手术工作量统计详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("surgery:surgeryWorkloadStatistics:query")
    @GetMapping("/{id}")
    public R<MmpSurgeryWorkloadStatisticsVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpSurgeryWorkloadStatisticsService.queryById(id));
    }

    /**
     * 新增手术工作量统计
     */
    @SaCheckPermission("surgery:surgeryWorkloadStatistics:add")
    @Log(title = "手术工作量统计", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpSurgeryWorkloadStatisticsBo bo) {
        return toAjax(mmpSurgeryWorkloadStatisticsService.insertByBo(bo));
    }

    /**
     * 修改手术工作量统计
     */
    @SaCheckPermission("surgery:surgeryWorkloadStatistics:edit")
    @Log(title = "手术工作量统计", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpSurgeryWorkloadStatisticsBo bo) {
        return toAjax(mmpSurgeryWorkloadStatisticsService.updateByBo(bo));
    }

    /**
     * 删除手术工作量统计
     *
     * @param ids 主键串
     */
    @SaCheckPermission("surgery:surgeryWorkloadStatistics:remove")
    @Log(title = "手术工作量统计", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpSurgeryWorkloadStatisticsService.deleteWithValidByIds(List.of(ids), true));
    }
}
