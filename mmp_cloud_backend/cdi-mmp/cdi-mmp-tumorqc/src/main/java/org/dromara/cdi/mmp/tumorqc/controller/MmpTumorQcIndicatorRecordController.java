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
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcIndicatorRecordVo;
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcIndicatorRecordBo;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcIndicatorRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 质控指标监测记录
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/tumorQcIndicatorRecord")
public class MmpTumorQcIndicatorRecordController extends BaseController {

    private final IMmpTumorQcIndicatorRecordService mmpTumorQcIndicatorRecordService;

    /**
     * 查询质控指标监测记录列表
     */
    @SaCheckPermission("system:tumorQcIndicatorRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpTumorQcIndicatorRecordVo> list(MmpTumorQcIndicatorRecordBo bo, PageQuery pageQuery) {
        return mmpTumorQcIndicatorRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出质控指标监测记录列表
     */
    @SaCheckPermission("system:tumorQcIndicatorRecord:export")
    @Log(title = "质控指标监测记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpTumorQcIndicatorRecordBo bo, HttpServletResponse response) {
        List<MmpTumorQcIndicatorRecordVo> list = mmpTumorQcIndicatorRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "质控指标监测记录", MmpTumorQcIndicatorRecordVo.class, response);
    }

    /**
     * 获取质控指标监测记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:tumorQcIndicatorRecord:query")
    @GetMapping("/{id}")
    public R<MmpTumorQcIndicatorRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpTumorQcIndicatorRecordService.queryById(id));
    }

    /**
     * 新增质控指标监测记录
     */
    @SaCheckPermission("system:tumorQcIndicatorRecord:add")
    @Log(title = "质控指标监测记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpTumorQcIndicatorRecordBo bo) {
        return toAjax(mmpTumorQcIndicatorRecordService.insertByBo(bo));
    }

    /**
     * 修改质控指标监测记录
     */
    @SaCheckPermission("system:tumorQcIndicatorRecord:edit")
    @Log(title = "质控指标监测记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpTumorQcIndicatorRecordBo bo) {
        return toAjax(mmpTumorQcIndicatorRecordService.updateByBo(bo));
    }

    /**
     * 删除质控指标监测记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:tumorQcIndicatorRecord:remove")
    @Log(title = "质控指标监测记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpTumorQcIndicatorRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
