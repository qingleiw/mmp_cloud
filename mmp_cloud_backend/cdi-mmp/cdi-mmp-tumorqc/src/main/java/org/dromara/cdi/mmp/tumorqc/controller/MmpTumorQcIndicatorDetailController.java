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
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcIndicatorDetailVo;
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcIndicatorDetailBo;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcIndicatorDetailService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 质控指标明细数据
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/tumorQcIndicatorDetail")
public class MmpTumorQcIndicatorDetailController extends BaseController {

    private final IMmpTumorQcIndicatorDetailService mmpTumorQcIndicatorDetailService;

    /**
     * 查询质控指标明细数据列表
     */
    @SaCheckPermission("system:tumorQcIndicatorDetail:list")
    @GetMapping("/list")
    public TableDataInfo<MmpTumorQcIndicatorDetailVo> list(MmpTumorQcIndicatorDetailBo bo, PageQuery pageQuery) {
        return mmpTumorQcIndicatorDetailService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出质控指标明细数据列表
     */
    @SaCheckPermission("system:tumorQcIndicatorDetail:export")
    @Log(title = "质控指标明细数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpTumorQcIndicatorDetailBo bo, HttpServletResponse response) {
        List<MmpTumorQcIndicatorDetailVo> list = mmpTumorQcIndicatorDetailService.queryList(bo);
        ExcelUtil.exportExcel(list, "质控指标明细数据", MmpTumorQcIndicatorDetailVo.class, response);
    }

    /**
     * 获取质控指标明细数据详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:tumorQcIndicatorDetail:query")
    @GetMapping("/{id}")
    public R<MmpTumorQcIndicatorDetailVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpTumorQcIndicatorDetailService.queryById(id));
    }

    /**
     * 新增质控指标明细数据
     */
    @SaCheckPermission("system:tumorQcIndicatorDetail:add")
    @Log(title = "质控指标明细数据", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpTumorQcIndicatorDetailBo bo) {
        return toAjax(mmpTumorQcIndicatorDetailService.insertByBo(bo));
    }

    /**
     * 修改质控指标明细数据
     */
    @SaCheckPermission("system:tumorQcIndicatorDetail:edit")
    @Log(title = "质控指标明细数据", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpTumorQcIndicatorDetailBo bo) {
        return toAjax(mmpTumorQcIndicatorDetailService.updateByBo(bo));
    }

    /**
     * 删除质控指标明细数据
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:tumorQcIndicatorDetail:remove")
    @Log(title = "质控指标明细数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpTumorQcIndicatorDetailService.deleteWithValidByIds(List.of(ids), true));
    }
}
