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
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcRectificationVo;
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcRectificationBo;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcRectificationService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 肿瘤质控整改
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/tumorQcRectification")
public class MmpTumorQcRectificationController extends BaseController {

    private final IMmpTumorQcRectificationService mmpTumorQcRectificationService;

    /**
     * 查询肿瘤质控整改列表
     */
    @SaCheckPermission("system:tumorQcRectification:list")
    @GetMapping("/list")
    public TableDataInfo<MmpTumorQcRectificationVo> list(MmpTumorQcRectificationBo bo, PageQuery pageQuery) {
        return mmpTumorQcRectificationService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出肿瘤质控整改列表
     */
    @SaCheckPermission("system:tumorQcRectification:export")
    @Log(title = "肿瘤质控整改", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpTumorQcRectificationBo bo, HttpServletResponse response) {
        List<MmpTumorQcRectificationVo> list = mmpTumorQcRectificationService.queryList(bo);
        ExcelUtil.exportExcel(list, "肿瘤质控整改", MmpTumorQcRectificationVo.class, response);
    }

    /**
     * 获取肿瘤质控整改详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:tumorQcRectification:query")
    @GetMapping("/{id}")
    public R<MmpTumorQcRectificationVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpTumorQcRectificationService.queryById(id));
    }

    /**
     * 新增肿瘤质控整改
     */
    @SaCheckPermission("system:tumorQcRectification:add")
    @Log(title = "肿瘤质控整改", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpTumorQcRectificationBo bo) {
        return toAjax(mmpTumorQcRectificationService.insertByBo(bo));
    }

    /**
     * 修改肿瘤质控整改
     */
    @SaCheckPermission("system:tumorQcRectification:edit")
    @Log(title = "肿瘤质控整改", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpTumorQcRectificationBo bo) {
        return toAjax(mmpTumorQcRectificationService.updateByBo(bo));
    }

    /**
     * 删除肿瘤质控整改
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:tumorQcRectification:remove")
    @Log(title = "肿瘤质控整改", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpTumorQcRectificationService.deleteWithValidByIds(List.of(ids), true));
    }
}
