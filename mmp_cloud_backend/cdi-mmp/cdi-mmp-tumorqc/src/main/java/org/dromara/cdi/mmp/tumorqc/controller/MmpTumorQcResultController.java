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
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcResultVo;
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcResultBo;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcResultService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 肿瘤质控结果
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/tumorQcResult")
public class MmpTumorQcResultController extends BaseController {

    private final IMmpTumorQcResultService mmpTumorQcResultService;

    /**
     * 查询肿瘤质控结果列表
     */
    @SaCheckPermission("system:tumorQcResult:list")
    @GetMapping("/list")
    public TableDataInfo<MmpTumorQcResultVo> list(MmpTumorQcResultBo bo, PageQuery pageQuery) {
        return mmpTumorQcResultService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出肿瘤质控结果列表
     */
    @SaCheckPermission("system:tumorQcResult:export")
    @Log(title = "肿瘤质控结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpTumorQcResultBo bo, HttpServletResponse response) {
        List<MmpTumorQcResultVo> list = mmpTumorQcResultService.queryList(bo);
        ExcelUtil.exportExcel(list, "肿瘤质控结果", MmpTumorQcResultVo.class, response);
    }

    /**
     * 获取肿瘤质控结果详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:tumorQcResult:query")
    @GetMapping("/{id}")
    public R<MmpTumorQcResultVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpTumorQcResultService.queryById(id));
    }

    /**
     * 新增肿瘤质控结果
     */
    @SaCheckPermission("system:tumorQcResult:add")
    @Log(title = "肿瘤质控结果", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpTumorQcResultBo bo) {
        return toAjax(mmpTumorQcResultService.insertByBo(bo));
    }

    /**
     * 修改肿瘤质控结果
     */
    @SaCheckPermission("system:tumorQcResult:edit")
    @Log(title = "肿瘤质控结果", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpTumorQcResultBo bo) {
        return toAjax(mmpTumorQcResultService.updateByBo(bo));
    }

    /**
     * 删除肿瘤质控结果
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:tumorQcResult:remove")
    @Log(title = "肿瘤质控结果", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpTumorQcResultService.deleteWithValidByIds(List.of(ids), true));
    }
}
