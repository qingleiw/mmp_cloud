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
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcInspectionVo;
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcInspectionBo;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcInspectionService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 肿瘤质控检查
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/tumorQcInspection")
public class MmpTumorQcInspectionController extends BaseController {

    private final IMmpTumorQcInspectionService mmpTumorQcInspectionService;

    /**
     * 查询肿瘤质控检查列表
     */
    @SaCheckPermission("system:tumorQcInspection:list")
    @GetMapping("/list")
    public TableDataInfo<MmpTumorQcInspectionVo> list(MmpTumorQcInspectionBo bo, PageQuery pageQuery) {
        return mmpTumorQcInspectionService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出肿瘤质控检查列表
     */
    @SaCheckPermission("system:tumorQcInspection:export")
    @Log(title = "肿瘤质控检查", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpTumorQcInspectionBo bo, HttpServletResponse response) {
        List<MmpTumorQcInspectionVo> list = mmpTumorQcInspectionService.queryList(bo);
        ExcelUtil.exportExcel(list, "肿瘤质控检查", MmpTumorQcInspectionVo.class, response);
    }

    /**
     * 获取肿瘤质控检查详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:tumorQcInspection:query")
    @GetMapping("/{id}")
    public R<MmpTumorQcInspectionVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpTumorQcInspectionService.queryById(id));
    }

    /**
     * 新增肿瘤质控检查
     */
    @SaCheckPermission("system:tumorQcInspection:add")
    @Log(title = "肿瘤质控检查", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpTumorQcInspectionBo bo) {
        return toAjax(mmpTumorQcInspectionService.insertByBo(bo));
    }

    /**
     * 修改肿瘤质控检查
     */
    @SaCheckPermission("system:tumorQcInspection:edit")
    @Log(title = "肿瘤质控检查", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpTumorQcInspectionBo bo) {
        return toAjax(mmpTumorQcInspectionService.updateByBo(bo));
    }

    /**
     * 删除肿瘤质控检查
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:tumorQcInspection:remove")
    @Log(title = "肿瘤质控检查", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpTumorQcInspectionService.deleteWithValidByIds(List.of(ids), true));
    }
}
